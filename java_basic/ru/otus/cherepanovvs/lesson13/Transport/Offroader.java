package ru.otus.cherepanovvs.lesson13.Transport;

import ru.otus.cherepanovvs.lesson13.Terrain;

public class Offroader extends Transport{
    public Offroader(String model, int fuelValue, int fuelConsumption, Terrain[] allowedTerrain) {
        this.model = model;
        this.fuelValue = fuelValue;
        this.fuelConsumption = fuelConsumption;
        this.allowedTerrain = allowedTerrain;
    }
}
