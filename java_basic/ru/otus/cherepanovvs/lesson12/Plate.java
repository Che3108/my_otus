package ru.otus.cherepanovvs.lesson12;

public class Plate {
    private final int maxVolume;
    private int foodVolume;

    public Plate(int maxVolume) {
        this.maxVolume = maxVolume;
        this.foodVolume = maxVolume;
    }

    public void info() {
        System.out.println("Наполнение " + this.foodVolume + " из " + this.maxVolume);
    }

    public void addFood(int volume) {
        if (this.foodVolume + volume > this.maxVolume) {
            System.out.println("Нет места!");
            return;
        }
        this.foodVolume += volume;
        this.info();
        return;
    }

    public boolean takeFood(int volume) {
        if (this.foodVolume - volume < 0) {
            System.out.println("Наполнение не изменилось!");
            return false;
        }
        this.foodVolume -= volume;
        this.info();
        return true;
    }

    public int getFoodVolume() {
        return foodVolume;
    }
}
