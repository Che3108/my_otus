#!/usr/bin/python3

# -*- codung:utf-8 -*-

from fastapi import FastAPI, Form
from fastapi.responses import HTMLResponse, FileResponse
from model import MyClassifier
import pandas as pd
import uvicorn
from typing import Annotated
import os

work_dir = os.getcwd()
model_file_path = os.path.join(work_dir, 'RandomForestClassifier.pickle')
html_dir = os.path.join(work_dir, 'html')

my_model = MyClassifier()
my_model.load_model(model_file_path)

my_app = FastAPI()


@my_app.get("/")
def root():
    return FileResponse(os.path.join(html_dir, 'index.html'))


@my_app.post("/result")
def get_result(
        age: Annotated[int, Form()],
        sex: Annotated[str, Form()],
        cp: Annotated[int, Form()],
        trestbps: Annotated[int, Form()],
        chol: Annotated[int, Form()],
        fbs: Annotated[int, Form()],
        restecg: Annotated[int, Form()],
        thalach: Annotated[int, Form()],
        exang: Annotated[str, Form()],
        oldpeak: Annotated[float, Form()],
        slope: Annotated[int, Form()],
        ca: Annotated[int, Form()],
        thal: Annotated[int, Form()]):
    sex_num = 1
    if sex == "M":
        sex_num = 0
    exang_num = 0
    if (exang == "Yes") or (exang == "yes"):
        exang_num = 1
    data = {
        "age": [age],
        "sex": [sex_num],
        "cp": [cp],
        "trestbps": [trestbps],
        "chol": [chol],
        "fbs": [fbs],
        "restecg": [restecg],
        "thalach": [thalach],
        "exang": [exang_num],
        "oldpeak": [oldpeak],
        "slope": [slope],
        "ca": [ca],
        "thal": [thal]
    }
    with open(os.path.join(html_dir, 'result.html'), "r", encoding="utf-8") as f:
        result_page = f.read()
    pred = my_model.predict(pd.DataFrame(data=data))
    if pred == 1:
        result_page = result_page.replace('%%%result%%%', 'Presence of heart disease')
    elif pred == 0:
        result_page = result_page.replace('%%%result%%%', 'Absence of heart disease')
    return HTMLResponse(content=result_page, status_code=200)


if __name__ == "__main__":
    uvicorn.run(my_app, host="0.0.0.0", port=8000)
