package ru.otus.cherepanovvs.lesson11.Animal;

public class Dog extends Animal {
    protected int staminaLowSpeedRun;
    protected int runSpeed;
    protected int staminaLowSpeedSwim;
    protected int swimSpeed;

    public Dog(String name) {
        this.name = name;
        this.staminaSize = 300;
        this.fatigueFlag = false;
        this.staminaLowSpeedRun = 1;
        this.runSpeed = 7;
        this.staminaLowSpeedSwim = 2;
        this.swimSpeed = 2;
    }

    public void run(int distance) {
        int time = super.action(this.runSpeed, distance, this.staminaLowSpeedRun);
        if (time == -1) {
            System.out.println(this.name + " не хватит сил для забега");
            return;
        }
        System.out.println(this.name + " пробежал расстояние " + distance + " метров за " + time + " секунд");
    }

    public void swim(int distance) {
        int time = super.action(this.swimSpeed, distance, this.staminaLowSpeedSwim);
        if (time == -1) {
            System.out.println(this.name + " не хватит сил для заплыва");
            return;
        }
        System.out.println(this.name + " проплыл расстояние " + distance + " метров за " + time + " секунд");
    }
}