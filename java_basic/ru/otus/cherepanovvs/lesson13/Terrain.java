package ru.otus.cherepanovvs.lesson13;

public enum Terrain {
    FOREST("Густой лес"),
    PLAIN("Равнина"),
    SWAMP("Болото");

    private String russian;

    Terrain(String russian) {
        this.russian = russian;
    }

    public String russian() {
        return russian;
    }

}
