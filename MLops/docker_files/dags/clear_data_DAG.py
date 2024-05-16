#!/usr/bin/python3

# -*- coding:utf-8 -*-

# скрипт с первым DAGом
# задача DAGа - запуск скрипта по очистке данных в bucket


import datetime

from airflow import DAG
from airflow.providers.sftp.operators.sftp import SFTPOperator
from airflow.providers.ssh.operators.ssh import SSHOperator
from airflow.utils.dates import days_ago
from airflow.models.connection import Connection
import os

env_var = (
    ("S3_BUCKET",   os.environ["S3_BUCKET"]),
    ("S3_ENDPOINT", os.environ["S3_ENDPOINT"]),
    ("S3_SECRET",   os.environ["S3_SECRET"]),
    ("S3_ACCESS",   os.environ["S3_ACCESS"]),
)

commands = [f"export {name}={value}" for name, value in env_var]

my_dag = DAG(
    dag_id="сlear_data",
    start_date=days_ago(0),
    schedule="@daily",
)

install_pyspark = SSHOperator(
    task_id="install_pyspark",
    ssh_conn_id="my_ssh",
    command="cd /home/user/ && pip uninstall -y pyspark && pip install pyspark==3.0.2",
    dag=my_dag,
    do_xcom_push=True
)

put_clear_data = SFTPOperator(
    task_id="put_clear_data",
    ssh_conn_id="my_ssh",
    local_filepath="/opt/airflow/temp/clear_data.py",
    remote_filepath="/home/user/clear_data.py",
    operation="put",
    create_intermediate_dirs=True,
    dag=my_dag,
)

run_script_clear_data = SSHOperator(
    task_id="run_script_clear_data",
    ssh_conn_id="my_ssh",
    command="cd /home/user/ && " + " && ".join(commands) + " && spark-submit clear_data.py",
    dag=my_dag,
    do_xcom_push=True
)

install_pyspark >> put_clear_data >> run_script_clear_data
