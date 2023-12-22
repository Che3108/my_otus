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
    }

    @Override
    public String toString() {
        return this.name;
    }

    public int getStamina() {
        return this.stamina;
    }

    public int getStaminaConsumptionWalk() {
        return this.staminaConsumption;
    }

    public void setCurrentTransport(Driver transport) {
        if (transport == null) {
            this.currentTransport = null;
        }
        this.currentTransport = transport;
    }

    public boolean drive(int distance, Terrain terrain)
    {
        if (this.currentTransport != null) {
            return this.currentTransport.drive(distance, terrain);
        }
        

        int spentStamina = (distance / 100) * this.staminaConsumption;
        if (this.stamina - spentStamina <= 0) {
            System.out.println("Не хватит сил пройти");
            return false;
        }
        this.stamina -= spentStamina;
        System.out.println("Успешно прошел по " + terrain);
        return true;
    }


}
