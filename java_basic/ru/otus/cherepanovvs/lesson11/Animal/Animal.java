package ru.otus.cherepanovvs.lesson11.Animal;

public abstract class Animal {
    protected String name;
    protected int staminaSize;
    protected boolean fatigueFlag;

    protected int action(int actionSpeed, int distance, int staminaLowSpeed) {
        // в идеале это статичный метод, но не придумал как прокидывать сквозь него поял размера выносливости и усталость
        int maxDistance = this.staminaSize / staminaLowSpeed;
        if (distance > maxDistance) {
            this.fatigueFlag = true;
            return -1;
        }
        this.staminaSize -= distance * staminaLowSpeed;
        return distance / actionSpeed;
    }

    public void info() {
        String state = "";
        state += getClass().getSimpleName() + ": " + this.name + "\n";
        state += "Выносливость: " + this.staminaSize + "\n";
        state += "Усталость: " + this.fatigueFlag + "\n";
        System.out.println(state);
    }

}
