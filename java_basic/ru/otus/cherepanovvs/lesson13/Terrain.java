package ru.otus.cherepanovvs.lesson13;

public enum Terrain {
    FOREST(0),
    PLAIN(1),
    SWAMP(2);

    private int index;

    Terrain(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

}
