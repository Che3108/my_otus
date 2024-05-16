#!/usr/bin/puthon3

# -*- coding:utf-8 -*-

# Скрипт для очистки данных для ДЗ 16 курса MLOps в Отус

# Библиотеки
from pyspark.sql import SparkSession
from pyspark.sql.functions import isnan, when, count, col, countDistinct
from pyspark.sql.types import StructType, StructField, IntegerType
from pyspark.sql.types import TimestampType, FloatType, StringType
import subprocess
import os

env_var = {
    "S3_BUCKET":   os.environ["S3_BUCKET"],
    "S3_ENDPOINT": os.environ["S3_ENDPOINT"],
    "S3_SECRET":   os.environ["S3_SECRET"],
    "S3_ACCESS":   os.environ["S3_ACCESS"],
}

# Получаем список файлов .parquet в bucket
cmd = f"hdfs dfs -ls {env_var['S3_BUCKET']}"
files = subprocess.check_output(cmd, shell=True).decode("utf-8").split("\n")
files_parquet = [f.split(" ")[-1] for f in files if ".parquet" in f]

# удаляем в цикле файлы .parquet
for parquet_file in files_parquet:
    os.system(f"hadoop fs -rm -r {parquet_file}")

# Получаем список файлов в bucket
files_txt = [f.split(" ")[-1] for f in files if ".txt" in f]

# Создаем схему данных
schema = StructType(
    [
        StructField("tranaction_id",     IntegerType(), True),
        StructField("tx_datetime",       TimestampType(), True),
        StructField("customer_id",       IntegerType(), True),
        StructField("terminal_id",       IntegerType(), True),
        StructField("tx_amount",         FloatType(), True),
        StructField("tx_time_seconds",   IntegerType(), True),
        StructField("tx_time_days",      IntegerType(), True),
        StructField("tx_fraud",          IntegerType(), True),
        StructField("tx_fraud_scenario", IntegerType(), True),
    ]
)

# Создаем сессию spark
spark = SparkSession.builder.config("spark.hadoop.fs.s3a.access.key", env_var["S3_ACCESS"]) \
                            .config("spark.hadoop.fs.s3a.secret.key", env_var["S3_SECRET"]) \
                            .config("spark.hadoop.fs.endpoint", env_var["S3_ENDPOINT"]) \
                            .getOrCreate()

# читаем в цикле файлы
for data_file in files_txt:
    df = spark.read.format("csv") \
                   .schema(schema) \
                   .option("header", "true") \
                   .option("sep", ",") \
                   .load(data_file)
    
    # удаляем строки с пропусками
    df2 = df.na.drop()

    # удаляем дубли
    df3 = df2.drop_duplicates()

    # сохраняем в нужном формате
    df3.write.parquet(data_file.replace(".txt", ".parquet"))

# Останавливаем работу spark
spark.stop()
