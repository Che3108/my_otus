package ru.otus.cherepanovvs.lesson7;

public class HomeWork7 {
    public static void main(String[] args) {
        /* Реализовать метод sumOfPositiveElements(..), 
        принимающий в качестве аргумента целочисленный двумерный массив, 
        метод должен посчитать и вернуть сумму всех элементов массива, которые больше 0; */
        int sum = sumOfPositiveElements(new int[][] {{-10, 8}, {-2, 4}, {3, -4}, {10, -8}});
        System.out.println(sum);
        System.out.println("\n");

        /* Реализовать метод, который принимает в качестве аргумента int size и 
        печатает в консоль квадрат из символов * со сторонами соответствующей длины; */
        printSquad(5, '*');
        System.out.println("\n");

        /* Реализовать метод, принимающий в качестве аргумента двумерный целочисленный массив и 
        зануляющий его диагональные элементы (можете выбрать любую из диагоналей, или занулить обе); */
        int[][] myArray = new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {7, 8, 9}};
        printTable(myArray);

        
        System.out.println();
        int[][] modifyArray = bothDiagZero(myArray);
        printTable(modifyArray);
        System.out.println("\n");

        /* Реализовать метод findMax(int[][] array) который должен найти и вернуть максимальный элемент массива; */
        int maxMyArray = findMax(myArray);
        System.out.println(maxMyArray);
        System.out.println("\n");

        /* Реализуйте метод, который считает сумму элементов второй строки двумерного массива, 
        если второй строки не существует, то в качестве результата необходимо вернуть -1  */
        // исхожу из того, что вторая строка в человеческом смысле, т.е. с индексом 1
        int sum1 = secondRowSum(new int[][] {{-10, 8}, {-2, 4}, {3, -4}, {10, -8}});
        System.out.println(sum1);
        int sum2 = secondRowSum(new int[][] {{-10, 8}});
        System.out.println(sum2);
    }

    public static int sumOfPositiveElements(int[][] tableArray) {
        int positiveSum = 0;
        for (int i = 0; i < tableArray.length; i++) {
            for (int j = 0; j < tableArray[i].length; j++) {
                if (tableArray[i][j] > 0) {
                    positiveSum += tableArray[i][j];
                }
            }
        }
        return positiveSum;
    }

    public static void printSquad(int size, char fill) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(fill + " ");
            }
            System.out.println();
        }
    }

    public static void printTable(int[][] tableArray) {
        for (int i = 0; i < tableArray.length; i++) {
            for (int j = 0; j < tableArray[i].length; j++) {
                System.out.print(tableArray[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] bothDiagZero(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (j == i) {
                    array[i][j] = 0;
                    array[i][(array[0].length - 1) - j] = 0;
                }
            }
        }
        return array;
    }

    public static int findMax(int[][] array) {
        int max = array[0][0];
        for (int i = 1; i < array.length; i++) {
            for (int j = 1; j < array[i].length; j++) {
                if (array[i][j] > max) {
                    max = array[i][j];
                }
            }
        }
        return max;
    }

    public static int secondRowSum(int[][] array) {
        if (array.length < 2) {
            System.out.println("Массив не содержит искомой строки");
            return -1;
        }
        int sum = 0;
        for (int i = 0; i < array[1].length; i++) {
            sum += array[1][i];
        }
        return sum;
    }
}

