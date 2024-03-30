package ru.otus.cherepanovvs.lesson12;

public class Cat {
    private final String name;
    private int appetite;
    private boolean fullness;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.fullness = false;
    }

    public void eat(Plate plate) {
        if (this.fullness) {
            System.err.println(this.name + " сытый =)");
            return;
        }
        if (plate.getFoodVolume() < this.appetite) {
            System.err.println(this.name + " мало еды =(");
            return;
        }
        plate.takeFood(this.appetite);
        this.fullness = true;
        System.err.println(this.name + " поел =)");
        return;
    }

    public void info() {
        if (this.fullness) {
            System.err.println(this.name + " сытый =)");
            return;
        }
        System.err.println(this.name + " голодный =(");
        return;
    }
}
