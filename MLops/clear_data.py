#!/usr/bin/puthon3

# -*- coding:utf-8 -*-

# Скрипт для очистки данных для ДЗ 16 курса MLOps в Отус

# Библиотеки
from pyspark.sql import SparkSession
from pyspark.sql.functions import isnan, when, count, col, countDistinct
from pyspark.sql.types import StructType, StructField, IntegerType
from pyspark.sql.types import TimestampType, FloatType, StringType
import matplotlib.pyplot as plt
import subprocess
import os

# Читаем параметры
with open("params.conf", "r", encoding="utf-8") as f:
    params = dict([tuple(row.replace("\n", "").split("=")) for row in f.readlines()])

# Получаем список файлов в bucket
cmd = "hdfs dfs -ls s3a://cherepanov-bucket-new/"
files = subprocess.check_output(cmd, shell=True).decode("utf-8").split("\n")
files = [f.split(" ")[-1] for f in files if ".txt" in f]

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
spark = SparkSession.builder.config("spark.hadoop.fs.s3a.access.key", params["access"]) \
                            .config("spark.hadoop.fs.s3a.secret.key", params["secret"]) \
                            .config("spark.hadoop.fs.endpoint", "storage.yandexcloud.net") \
                            .getOrCreate()

# читаем в цикле файлы
for data_file in files:
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
