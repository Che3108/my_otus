package ru.otus.cherepanovvs.lesson13;

public class Human {
    private String name;
    private String currentTransport;
    private int stamina;
    private int staminaConsumptionWalk;

    public Human(String name, int stamina, int staminaConsumptionWalk) {
        this.name = name;
        this.stamina = stamina;
        this.currentTransport = "ноги";
    }

    @Override
    public String toString() {
        return this.name;
    }

    public int getStamina() {
        return this.stamina;
    }

    public int getStaminaConsumptionWalk() {
        return this.staminaConsumptionWalk;
    }

    public void setCurrentTransport(Driver transport) {
        if (transport == null) {
            this.currentTransport = "ноги";
        }
        this.currentTransport = transport.toString();
    }

}
