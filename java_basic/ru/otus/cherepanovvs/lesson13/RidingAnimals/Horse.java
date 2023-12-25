package ru.otus.cherepanovvs.lesson13.RidingAnimals;

import ru.otus.cherepanovvs.lesson13.Terrain;

public class Horse extends RidingAnimals{
    public Horse(String name, int stamina, int staminaConsumption, Terrain[] allowedTerrain) {
        this.name = name;
        this.stamina = stamina;
        this.staminaConsumption = staminaConsumption;
        this.allowedTerrain = allowedTerrain;
    }
}
