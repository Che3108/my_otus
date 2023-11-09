package ru.otus.cherepanovvs.lesson2;

import java.util.Scanner;

public class HomeWork2 {
    public static void main(String[] args) {
        simpleGussNumber();
    }

    public static void simpleGussNumber() {
        final String greetings = "Здравствуй, путник!\nТебе необходимо угадать число, которое я загадал.";
        final int scaleCoefficient = 10;

        int hiddenNumber;
        int answerNumber;

        Scanner scanner = new Scanner(System.in);

        System.out.println(greetings);
        System.out.println("Загаданное число в диапазоне от 0 до " + (scaleCoefficient -1) + ".");

        hiddenNumber = (int)(Math.random() * scaleCoefficient);
        answerNumber = scanner.nextInt();
        scanner.close();

        if (answerNumber == hiddenNumber) {
            System.out.println("Да, все верно.");
        } else {
            System.out.println("Нет, не угадал.");
        }
    }
}
