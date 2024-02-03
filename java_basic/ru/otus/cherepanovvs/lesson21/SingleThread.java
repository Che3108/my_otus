package ru.otus.cherepanovvs.lesson21;

import java.time.Duration;
import java.time.Instant;

public class SingleThread {
    public static void main(String[] args) {
        double[] xSpace = new double[100_000_000];

        Instant start = Instant.now();
        calculateFunc(xSpace, 0, 100_000_000);
        Instant finish = Instant.now();
        long elapsed = Duration.between(start, finish).toMillis();

        System.out.println("Прошло времени, мс: " + elapsed);
    }

    public static double[] calculateFunc(double[] xSpace, int start, int finish) throws IllegalArgumentException {
        if (finish - start <= 0) {
            throw new IllegalArgumentException();
        }
        for (int i = start; i < xSpace.length; i++) {
            xSpace[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
        }
        return xSpace;
    }
}
