package ru.otus.cherepanovvs.lesson14;

public class HomeWork14 {
    public static void main(String args[]) {
        /* Задание:
         * 1) Реализуйте метод, аргументом которого является двумерный строковый массив размером 4х4.
         * Если передан массив другого размера необходимо бросить исключение AppArraySizeException.
         * 2) Метод должен обойти все элементы массива, преобразовать в int и просуммировать.
         * Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит текст вместо числа),
         * должно быть брошено исключение AppArrayDataException с детализацией, в какой именно ячейке лежат неверные данные. 
         * 3) В методе main() необходимо вызвать полученный метод,
         * обработать возможные исключения AppArraySizeException и AppArrayDataException и вывести результат расчета 
         * (сумму элементов, при условии что подали на вход корректный массив).
         */

        
        String[][] myArray = {
            {"1", "1", "1", "1"}, 
            {"1", "1", "1", "1"}, 
            {"1", "1", "1", "1"}, 
            {"1", "1", "1", "1"}, 
        };
        int sum = 0;

        try {
            sum = summator(myArray);
            System.out.println(sum);
        } catch (AppArraySizeException e) {
            System.out.println(e.getMessage());
        } catch (AppArrayDataException e) {
            System.out.println(e.getMessage());
        }

        myArray = new String[][] {
            {"1", "1", "1", "1"}, 
            {"1", "1", "1", "1"}, 
            {"1", "1", "1", "1"}, 
        };
        try {
            sum = summator(myArray);
            System.out.println(sum);
        } catch (AppArraySizeException e) {
            System.out.println(e.getMessage());
        } catch (AppArrayDataException e) {
            System.out.println(e.getMessage());
        }

        myArray = new String[][] {
            {"1", "1", "1", "1"}, 
            {"1", "1", "1", "1"}, 
            {"1", "1", "1", "1"},
            {"1", "A", "1", "1"}, 
        };
        try {
            sum = summator(myArray);
            System.out.println(sum);
        } catch (AppArraySizeException e) {
            System.out.println(e.getMessage());
        } catch (AppArrayDataException e) {
            System.out.println(e.getMessage());
        }

    }

    public static int summator (String[][] array) throws AppArraySizeException, AppArrayDataException{
        if (array.length != 4 ) {
            throw new AppArraySizeException("Неверный размер входящих данных");
        }
        // так как массив массивов, то для проверки размера столбцов придется перебрать весь массив
        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4 ) {
                throw new AppArraySizeException("Неверный размер входящих данных");
            }
        }
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException ex) {
                    throw AppArrayDataException.forInputString(array[i][j], i, j);
                }
            }
        }
        return sum;
    }
}

class AppArrayDataException extends NumberFormatException {
    public AppArrayDataException() {
    }
    public AppArrayDataException(String var1) {
       super(var1);
    }
    static AppArrayDataException forInputString(String var0, int rowIndex, int colIndex) {
        return new AppArrayDataException("Невозможно преобразовать в число \"" + var0 + "\" на позиции [" + rowIndex + "][" + colIndex + "]");
    }
}

class AppArraySizeException extends RuntimeException {
    public AppArraySizeException() {
    }
    public AppArraySizeException(String var1) {
       super(var1);
    }
}