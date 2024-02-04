package ru.otus.cherepanovvs.lesson11.Animal;

public class Cat extends Animal {
    protected int staminaLowSpeedRun;
    protected int runSpeed;

    public Cat(String name) {
        this.name = name;
        this.staminaSize = 200;
        this.fatigueFlag = false;
        this.staminaLowSpeedRun = 1;
        this.runSpeed = 5;
    }

    public void run(int distance) {
        int time = super.action(this.runSpeed, distance, this.staminaLowSpeedRun);
        if (time == -1) {
            System.out.println(this.name + " не хватит сил для забега");
            return;
        }
        System.out.println(this.name + " пробежал расстояние " + distance + " метров за " + time + " секунд");
    }

    // так как кот плавать не умеет, то и метода у него такого нет
}
