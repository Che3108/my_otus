#!/usr/bin/python3

# -*- codung:utf-8 -*-

# модель машинного обучения

import pandas as pd
import pickle
import os


class MyClassifier:

    def load_model(self, model_file_path:str) -> bool:
        if not isinstance(model_file_path, str):
            raise TypeError(f"expecting str, got {type(model_file_path)}")
        if not os.path.isfile(model_file_path):
            raise FileNotFoundError("wrong file_name")
        if model_file_path.split(".")[-1] != "pickle":
            raise FileNotFoundError("wrong file_name")
        with open(model_file_path, "rb") as file:
            self.__classifier = pickle.load(file)
        return True
    

    def predict(self, X:pd.DataFrame) -> bool:
        preds = self.__classifier.predict(X)[0]
        return preds


