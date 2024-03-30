package ru.otus.cherepanovvs.lesson21;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ManyThreads {
    public static void main(String[] args) {
        double[] xSpace = new double[100_000_000];

        List<Thread> threads = new ArrayList<>();

        Thread thread1 = new Thread(() -> calculateFunc(xSpace, 0, 25_000_000));
        Thread thread2 = new Thread(() -> calculateFunc(xSpace, 25_000_000, 50_000_000));
        Thread thread3 = new Thread(() -> calculateFunc(xSpace, 50_000_000, 75_000_000));
        Thread thread4 = new Thread(() -> calculateFunc(xSpace, 75_000_000, 100_000_000));

        threads.add(thread1);
        threads.add(thread2);
        threads.add(thread3);
        threads.add(thread4);

        Instant start = Instant.now();
        for (Thread t: threads) {
            t.start();            
        }

        for (Thread t: threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }         
        }
        Instant finish = Instant.now();
        long elapsed = Duration.between(start, finish).toMillis();

        System.out.println("Прошло времени, мс: " + elapsed);
    }

    public static double[] calculateFunc(double[] xSpace, int start, int finish) throws IllegalArgumentException {
        if (finish - start <= 0) {
            throw new IllegalArgumentException();
        }
        for (int i = start; i < finish; i++) {
            xSpace[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
        }
        return xSpace;
    }
}
