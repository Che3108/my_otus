package ru.otus.cherepanovvs.lesson1;

public class HomeWork1 {
    public static void main(String[] args) {
        greetings();
        checkSign(10, 20, 30);
        checkSign(10, 20, -31);
        selectColor();
        compareNumbers();
        addOrSubtractAndPrint(10, 2, true);
        addOrSubtractAndPrint(10, 2, false);
    }

    public static void greetings() {
        System.out.println("Hello\nWorld\nfrom\nJava");
    }

    public static void checkSign(int a, int b, int c) {
        int sumInputArgs = a + b + c;
        if (sumInputArgs >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    public static void selectColor() {
        int data = 25;
        if (data <= 10) {
            System.out.println("Красный");
        }
        if ((data > 10) && (data <= 20)) {
            System.out.println("Желтый");
        }
        if (data > 20) {
            System.out.println("Зеленый");
        }
    }

    public static void compareNumbers() {
        int a = 25;
        int b = 25;
        String compareSymbol = ">=";
        if (a < b) {
            compareSymbol = "<";
        }
        System.out.println("a " + compareSymbol + " b");
    }

    public static void addOrSubtractAndPrint(int initValue, int delta, boolean increment) {
        if (increment) {
            initValue += delta;
        } else {
            initValue -= delta;
        }
        System.out.println(initValue);
    }

}