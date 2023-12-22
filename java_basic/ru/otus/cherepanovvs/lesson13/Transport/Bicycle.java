package ru.otus.cherepanovvs.lesson13.Transport;

import ru.otus.cherepanovvs.lesson13.Terrain;

public class Bicycle extends Transport{
    public Bicycle(String model, Terrain[] allowedTerrain) {
        this.model = model;
        this.fuelValue = -1;
        this.fuelConsumption = -1;
        this.allowedTerrain = allowedTerrain;
    }
}
