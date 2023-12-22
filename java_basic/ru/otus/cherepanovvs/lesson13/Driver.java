package ru.otus.cherepanovvs.lesson13;

public interface Driver {
    boolean startControl(Human driver);
    boolean finishControl();
    boolean drive(int distance, Terrain terrain);
    String toString(); // это на всякий случай указал =)
}
