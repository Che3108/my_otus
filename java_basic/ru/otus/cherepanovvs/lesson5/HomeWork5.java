package ru.otus.cherepanovvs.lesson5;

import java.util.Scanner;

public class HomeWork5 {
    public static void main(String[] args) {
        dublicator("Привет, мир!", 3);
        summator(1,9,2,8,3,7,4,6,5);

        int[] myArray = {0,1,2,3,4,5,6,7};
        fillArray

    }
    
    public static void dublicator(String inputData, int dublicateCount) {
        if (dublicateCount > 0) {
            for (; dublicateCount > 0; dublicateCount--) {
                System.out.println(inputData);
            }
        }
    }

    public static void summator(int ... arr) {
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 5) {
                result += arr[i];
            }
        }
        System.out.println(result);
    }

    public static int[] fillArray(int[] arr, int fillValue) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = fillValue;
        }
        return arr;
    }
}

/*
Реализуйте метод, принимающий в качестве аргументов целое число и ссылку на целочисленный
массив, метод должен заполнить каждую ячейку массива указанным числом;
*/
