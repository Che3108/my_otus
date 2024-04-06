#!/usr/bin/python3

# -*- codung:utf-8 -*-

# итоговое тестирование модели

import pickle
import pandas as pd
import os

from sklearn.metrics import classification_report

os.chdir('/home/slawa/HDD/my_scripts/my_otus/ML_advanced/lesson_9/hw')

# загружаем данные
raw_data_file_name = 'data/test_data/final_test_data.csv'
raw_data = pd.read_csv(raw_data_file_name, delimiter=',', decimal='.')
raw_data

with open("models/RandomForestClassifier.pickle", "rb") as file:
    RandomForestClassifier = pickle.load(file)
 
preds = RandomForestClassifier.predict(raw_data.drop(['target'], axis=1))
print(classification_report(raw_data['target'], preds))

