package ru.otus.cherepanovvs.lesson13;

public class Human {
    private String name;
    private Driver currentTransport;
    private int stamina;
    private int staminaConsumption;

    public Human(String name, int stamina, int staminaConsumption) {
        this.name = name;
        this.stamina = stamina;
        this.currentTransport = null;
        this.staminaConsumption = staminaConsumption;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public int getStamina() {
        return this.stamina;
    }

    public void setStamina(int stamina) {
        if ((stamina <= this.stamina) & (stamina >= 0)) {
            this.stamina = stamina;
        }
    }

    public int getStaminaConsumptionWalk() {
        return this.staminaConsumption;
    }

    public void takeTransport(Driver transport) {
        if (this.currentTransport != null) {
            this.currentTransport.finishControl();
        }
        this.currentTransport = transport;
        this.currentTransport.startControl(this);
    }

    public void leaveTransport() {
        this.currentTransport.finishControl();
        this.currentTransport = null;
    }

    public boolean drive(int distance, Terrain terrain)
    {
        if (terrain == null) {
            System.out.println("Некуда двигаться");
            return false;
        }

        if (this.currentTransport != null) {
            return this.currentTransport.drive(distance, terrain);
        }

        int spentStamina = distance * this.staminaConsumption;
        if (this.stamina - spentStamina < 0) {
            System.out.println("Не хватит сил пройти");
            return false;
        }
        this.stamina -= spentStamina;
        System.out.println("Успешно прошел по " + terrain.russian());
        return true;
    }

    public void info() {
        System.out.println("Имя: " + this.name);
        System.out.println("Стамина: " + this.stamina);
        System.out.println();
    }
}
