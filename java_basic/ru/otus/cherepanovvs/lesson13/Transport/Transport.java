package ru.otus.cherepanovvs.lesson13.Transport;
import ru.otus.cherepanovvs.lesson13.Driver;
import ru.otus.cherepanovvs.lesson13.Human;
import ru.otus.cherepanovvs.lesson13.Terrain;

public abstract class Transport implements Driver{
    protected String model;
    protected int fuelValue;
    protected int fuelConsumption;
    protected Human driver;
    protected Terrain[] allowedTerrain;

    @Override
    public boolean startControl(Human driver) {
        if (this.driver != null) {
            System.out.println("Новый водитель: " +  this.driver);
            return false;
        }
        this.driver = driver;
        this.driver.setCurrentTransport(this);
        if (this.fuelValue == -1) {
            this.fuelValue = this.driver.getStamina();
            this.fuelConsumption = this.driver.getStaminaConsumptionWalk() / 2;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.model;
    }

    @Override
    public boolean finishControl() {
        if (this.driver == null) {
            System.out.println("Водитель отсутствует");
            return false;
        }
        this.driver.setCurrentTransport(null);
        this.driver = null;
        return true;
    }

    @Override
    public boolean drive(int distance, Terrain terrain)
    {
        if (this.driver == null) {
            System.out.println("Водитель отсутствует");
            return false;
        }

        boolean allowedTerrainFlag = false;
        for (int i = 0; i < this.allowedTerrain.length; i++) {
            if (terrain == allowedTerrain[i]) {
                allowedTerrainFlag = true;
            }           
        }
        if (!allowedTerrainFlag) {
            System.out.println("Невозможно проехать по " + terrain);
            return false;
        }

        int spentFuel = (distance / 100) * fuelConsumption;
        if (this.fuelValue - spentFuel <= 0) {
            System.out.println("Не хватит топлива");
            return false;
        }
        this.fuelValue -= spentFuel;
        System.out.println("Успешно проехал по " + terrain);
        return true;
    }
}
