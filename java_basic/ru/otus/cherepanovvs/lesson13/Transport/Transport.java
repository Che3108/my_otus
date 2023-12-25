package ru.otus.cherepanovvs.lesson13.Transport;
import ru.otus.cherepanovvs.lesson13.Driver;
import ru.otus.cherepanovvs.lesson13.Human;
import ru.otus.cherepanovvs.lesson13.Terrain;

public abstract class Transport implements Driver{
    protected String model;
    protected int fuelValue;
    protected int currFuelValue;
    protected int fuelConsumption;
    protected Human driver;
    protected Terrain[] allowedTerrain;

    @Override
    public boolean startControl(Human driver) {
        this.driver = driver;
        if (this.driver == null) {
            System.out.println("За руль " + this + " никто не сел");
            return false;
        }
        if (this.fuelValue == -1) {
            this.currFuelValue = this.driver.getStamina();
            this.fuelConsumption = this.driver.getStaminaConsumptionWalk() / 2;
        }
        System.out.println("Новый водитель " + this + ": " +  this.driver);
        return true;
    }

    @Override
    public String toString() {
        return this.model;
    }

    @Override
    public boolean finishControl() {
        if (this.driver == null) {
            System.out.println("Водитель " + this + " отсутствует");
            return false;
        }
        this.driver = null;
        System.out.println("Водитель " + this + " успешно вышел");
        return true;
    }

    @Override
    public boolean drive(int distance, Terrain terrain)
    {
        if (this.driver == null) {
            System.out.println("Водитель " + this + " отсутствует");
            return false;
        }

        boolean allowedTerrainFlag = false;
        for (int i = 0; i < this.allowedTerrain.length; i++) {
            if (terrain == allowedTerrain[i]) {
                allowedTerrainFlag = true;
            }           
        }
        if (!allowedTerrainFlag) {
            System.out.println("Невозможно проехать по " + terrain.russian());
            return false;
        }

        int spentFuel = distance * fuelConsumption;
        if (this.currFuelValue - spentFuel <= 0) {
            System.out.println("Не хватит топлива");
            return false;
        }
        this.currFuelValue -= spentFuel;
        if (this.fuelValue == -1) {
            this.driver.setStamina(this.currFuelValue);
        }
        System.out.println("Успешно проехал по " + terrain.russian());
        return true;
    }

    public void info() {
        System.out.println("Модель: " + this.model);
        System.out.println("Остаток топлива: " + this.currFuelValue);
        if (this.driver == null) {
            System.out.println("Водитель отсутствует");
            System.out.println();
            return;
        }
        System.out.println("Текущий водитель: " + this.driver);
        System.out.println();
    }
}
