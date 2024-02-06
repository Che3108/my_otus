package ru.otus.cherepanovvs.lesson29;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HomeWork29 {
    public static String currentChar = "C";
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        Object monitor = new Object();

        Runnable taskA = () -> {
            for (int i = 0; i < 5; i++) {
                synchronized (monitor) {
                    while (!currentChar.equals("C")) {
                        try {
                            monitor.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    System.out.print("A");
                    currentChar = "A";
                    monitor.notifyAll();
                }
            }
        };

        Runnable taskB = () -> {
            for (int i = 0; i < 5; i++) {
                synchronized (monitor) {
                    while (!currentChar.equals("A")) {
                        try {
                            monitor.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    System.out.print("B");
                    currentChar = "B";
                    monitor.notifyAll();
                }
            }
        };

        Runnable taskC = () -> {
            for (int i = 0; i < 5; i++) {
                synchronized (monitor) {
                    while (!currentChar.equals("B")) {
                        try {
                            monitor.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    System.out.print("C");
                    currentChar = "C";
                    monitor.notifyAll();
                }
            }
        };

        executor.execute(taskA);
        executor.execute(taskB);
        executor.execute(taskC);

        executor.shutdown();
    }
}