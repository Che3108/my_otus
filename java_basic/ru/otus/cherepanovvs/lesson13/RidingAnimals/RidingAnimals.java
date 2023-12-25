package ru.otus.cherepanovvs.lesson13.RidingAnimals;

import ru.otus.cherepanovvs.lesson13.Driver;
import ru.otus.cherepanovvs.lesson13.Human;
import ru.otus.cherepanovvs.lesson13.Terrain;

public abstract class RidingAnimals implements Driver{
    protected String name;
    protected int stamina;
    protected int staminaConsumption;
    protected Human coachman;
    protected Terrain[] allowedTerrain;
    
    @Override
    public boolean startControl(Human coachman) {
        if (this.coachman != null) {
            System.out.println("Сейчас кучер: " +  this.coachman);
            return false;
        }
        this.coachman = coachman;
        System.out.println("Новый кучер: " +  this.coachman);
        return true;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public boolean finishControl() {
        if (this.coachman == null) {
            System.out.println("Кучер отсутствует");
            return false;
        }
        this.coachman = null;
        System.out.println("Кучер спешился");
        return true;
    }

    @Override
    public boolean drive(int distance, Terrain terrain)
    {
        if (this.coachman == null) {
            System.out.println("Кучер отсутствует");
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

        int spentStamina = distance * staminaConsumption;
        if (this.stamina - spentStamina <= 0) {
            System.out.println("Не хватит сил проехать");
            return false;
        }
        this.stamina -= spentStamina;
        System.out.println("Успешно проехал по " + terrain.russian());
        return true;
    }

    public void info() {
        System.out.println("Имя: " + this.name);
        System.out.println("Стамина: " + this.stamina);
        if (this.coachman == null) {
            System.out.println("Кучер отсутствует");
            System.out.println();
            return;
        }
        System.out.println("Текущий Кучер: " + this.coachman);
        System.out.println();
    }
}
