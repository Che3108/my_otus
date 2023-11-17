package ru.otus.cherepanovvs.lesson5;

import java.util.Arrays;

public class HomeWork5 {
    public static void main(String[] args) {

        /* Задание 1
        Реализуйте метод, принимающий в качестве аргументов целое число и строку,
        и печатающий вконсоль строку указанное количество раз */
        dublicator("Привет, мир!", 3);

        /* Задание 2
        Реализуйте метод, принимающий в качестве аргумента целочисленный массив,
        суммирующий все элементы, значение которых больше 5,
        и печатающий полученную сумму в консоль */
        summator(1,9,2,8,3,7,4,6,5);

        /* Задание 3
        Реализуйте метод, принимающий в качестве аргументов целое число и ссылку
        на целочисленный массив, метод должен заполнить каждую ячейку массива
        указанным числом */
        int[] myArray = {0,1,2,3,4,5,6};
        int[] resultArray = new int[myArray.length];
        int fillValue = 88;
        resultArray = fillArray(myArray, fillValue);
        System.out.println(Arrays.toString(resultArray));

        /* Задание 4
        Реализуйте метод, принимающий в качестве аргументов целое число и ссылку
        на целочисленный массив, увеличивающий каждый элемент массива на
        указанное число */
        int scalarValue = 10;
        resultArray = arrayAddScalar(myArray, scalarValue);
        System.out.println(Arrays.toString(resultArray));

        /* Задание 5
        Реализуйте метод, принимающий в качестве аргумента целочисленный массив, 
        и печатающий в консоль информацию о том, сумма элементов какой 
        из половин массива больше */
        System.out.println(Arrays.toString(myArray));
        arrBalace(myArray);
        arrBalace(invertArray(myArray));

        /* Задание 6*
        Реализуйте метод, принимающий на вход набор целочисленных массивов, и 
        получающий новый массив равный сумме входящих */
        int[] arr1 = new int[] { 1, 2, 3 };
        int[] arr2 = new int[] { 2, 2 };
        int[] arr3 = new int[] { 1, 1, 1, 1, 1};
        int[] arraysSum = arraySummator(arr1, arr2, arr3);
        System.out.println(Arrays.toString(arraysSum));

        /* Задание 7*
        Реализуйте метод, принимающий на вход набор целочисленных массивов, и 
        получающий новый массив равный сумме входящих */
        findPointBalance(new int[] {5, 3, 4, -2});

        /* Задание 8*
        Реализуйте метод, проверяющий что все элементы массива идут в порядке 
        убывания или возрастания (по выбору пользователя) */
        checkingOrder(new int[] {1,3,2,4}, true);

        /* Задание 9*
        Реализуйте метод, “переворачивающий” входящий массив */
        System.out.println(Arrays.toString(myArray));
        int[] invMyArr = invertArray(myArray);
        System.out.println(Arrays.toString(invMyArr));

    }
    
    public static void dublicator(String inputData, int dublicateCount) {
            for (; dublicateCount > 0; dublicateCount--) {
                System.out.println(inputData);
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
        arr = arr.clone();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = fillValue;
        }
        return arr;
    }

    public static int[] arrayAddScalar(int[] arr, int scalarValue) {
        arr = arr.clone();
        for (int i = 0; i < arr.length; i++) {
            arr[i] += scalarValue;
        }
        return arr;
    }

    public static int[] invertArray(int[] arr) {
        int[] invertArr = new int[arr.length];
        int idxArr;
        for (int i = 0; i < arr.length; i++) {
            idxArr = (arr.length - 1) - i;
            invertArr[i] = arr[idxArr];
        }
        return invertArr;
    }

    public static void arrBalace(int[] arr) {
        int idxCenter;
        int leftSum = 0;
        int rightSum = 0;
        idxCenter = arr.length / 2;
        for (int i = 0; i < arr.length; i++) {
            if (i < idxCenter) {
                leftSum += arr[i];
            } else {
                rightSum += arr[i];
            }
        }
        if (leftSum > rightSum) {
            System.out.println("Сумма левой половины массива больше");
        }
        if (leftSum < rightSum) {
            System.out.println("Сумма правой половины массива больше");
        }
        if (leftSum == rightSum) {
            System.out.println("Половины массива сбалансированы");
        }
    }

    public static int[] arraySummator(int[] ... arr) {
        int maxLen = 0; // размер массива не может быть меньше нуля, поэтому 0 тут оправдан
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length > maxLen) {
                maxLen = arr[i].length;
            }
        }
        int[] result = new int[maxLen];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                result[j] += arr[i][j];
            }
        }
        return result;
    }

    public static void findPointBalance(int[] arr) {
        int arrSumm = 0;
        int leftSumm = 0;
        for (int i = 0; i < arr.length; i++) {
            arrSumm += arr[i];
        }
        if (arrSumm % 2 != 0) {
            System.out.println("В массиве нет точки баланса");
        } else {
            int halfSumm = arrSumm / 2;
            for (int i = 0; i < arr.length; i++) {
                leftSumm += arr[i];
                if (leftSumm == halfSumm) {
                    System.out.println("В массиве точка баланса находится между " + i + " и " + (i+1) + " элементами");
                    break;
                }
                if (leftSumm > halfSumm) {
                    System.out.println("В массиве нет точки баланса");
                    break;
                }

            }
        }
    }

    public static void checkingOrder(int[] arr, boolean ascending) {
        int len = arr.length;
        int countPositine = 0;
        int countNegative = 0;
        for (int i = 1; i < len; i++) {
            if (arr[i-1] - arr[i] > 0) {
                countPositine++;
            }
            if (arr[i-1] - arr[i] < 0) {
                countNegative++;
            }
        }

        if (ascending) {
            if (countPositine == 0) {
                System.err.println("Правда");
            } else {
                System.err.println("Ложь");
            }
        } else {
            if (countNegative == 0) {
                System.err.println("Правда");
            } else {
                System.err.println("Ложь");
            }
        }
        
        
    }

}
