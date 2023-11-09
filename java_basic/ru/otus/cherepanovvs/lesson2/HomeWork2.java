package ru.otus.cherepanovvs.lesson2;

import java.util.Scanner;

public class HomeWork2 {
    public static void main(String[] args) {
        simpleCLIcalc();
    }
    

    public static void simpleGussNumberGame() {
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


    public static void difficultGussNumberGame() {
        int scaleCoefficient;
        int tryingCount;
        int hiddenNumber;
        int answerNumber;
        int difficultyGame;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Здравствуй, путник!\nТебе необходимо угадать число, которое я загадал.");
        System.out.println("Но в начале выбери сложность:\n1 - легко\n2 - средне\n3 - сложно");
        difficultyGame = scanner.nextInt();
        while (true) {
            if (difficultyGame == 1 || difficultyGame == 2 || difficultyGame == 3) {
                break;
            } else {
                System.out.println("Выбери, пожалуйста, сложность...");
                difficultyGame = scanner.nextInt();
            }
        }

        switch (difficultyGame) {
            case 1:
                scaleCoefficient = 10;
                tryingCount = 4;
                break;
            case 2:
                scaleCoefficient = 15;
                tryingCount = 3;
                break;
            case 3:
                scaleCoefficient = 20;
                tryingCount = 2;
                break;
            default:
                scaleCoefficient = 100;
                tryingCount = 1;
                break;
        }

        hiddenNumber = (int)(Math.random() * scaleCoefficient);
        System.out.println("Загаданное число в диапазоне от 0 до " + (scaleCoefficient -1));
        for (; tryingCount != 0; tryingCount--) {
            System.out.println("Осталость попыток: " + tryingCount);
            answerNumber = scanner.nextInt();
            if (answerNumber == hiddenNumber) {
                System.out.println("Да, все верно!");
                break;
            }
            if (answerNumber > hiddenNumber) {
                System.out.println("Загаданное число меньше, чем " + answerNumber);
            }
            if (answerNumber < hiddenNumber) {
                System.out.println("Загаданное число больше, чем " + answerNumber);
            }
        }
        scanner.close();
    }

    public static void simpleCLIcalc() {
        Scanner scanner = new Scanner(System.in);
        float firstNumber;
        float secondNumber;
        char operator;
        float result = 0.0f;
        boolean successFlag = true;

        firstNumber = scanner.nextFloat();
        operator = scanner.next().charAt(0);
        secondNumber = scanner.nextFloat();

        switch (operator) {
            case '+':
                result = firstNumber + secondNumber;
                break;
            case '-':
                result = firstNumber - secondNumber;
                break;
            case '*':
                result = firstNumber * secondNumber;
                break;
            case '/':
                if (secondNumber == 0.0f) {
                    System.out.println("Ошибка, на 0 делить нельзя!");
                    successFlag = false;
                }
                result = firstNumber / secondNumber;
                break;
            default:
                System.out.println("Ошибка, оператор неверный!");
                successFlag = false;
                break;
        }

        if (successFlag) {
            System.out.println(firstNumber + " " + operator + " " + secondNumber + " = " + result);
        }
        
        scanner.close();
    }
}
