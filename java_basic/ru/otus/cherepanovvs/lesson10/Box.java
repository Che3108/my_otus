package ru.otus.cherepanovvs.lesson10;

public class Box {
    private int height;
    private int width;
    private int length;
    private String color;
    private boolean emptyFlag;
    private boolean openFlag;
    private String item;

    public Box(int length, int height, int width, String color) {
        this.length = length;
        this.height = height;
        this.width = width;
        this.color = color;
        this.emptyFlag = true;
        this.openFlag = false;
        this.item = "";
    }
    
    public boolean isOpen() {
        if (this.openFlag) {
            System.out.println("Коробка открыта");
        } else {
            System.out.println("Коробка закрыта");
        }
        return this.openFlag;
    }

    public void open() {
        if (!this.openFlag) {
            System.out.println("Открываем коробку");
            this.openFlag = true;
        } else {
            System.out.println("Коробка уже открыта");
        }
    }

    public void close() {
        if (this.openFlag) {
            System.out.println("Закрываем коробку");
            this.openFlag = false;
        } else {
            System.out.println("Коробка уже закрыта");
        }
    }

    public boolean isEmpty() {
        if (this.emptyFlag) {
            System.out.println("Коробка пуста");
        } else {
            System.out.println("Коробка не пуста");
        }
        return this.emptyFlag;
    }

    public String getColor() {
        System.out.println("Текущий цвет коробки: " + this.color);
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
        System.out.println("Коробка перекрашена в: " + this.color);
    }

    public void info() {
        System.out.println("Длина: " + this.length);
        System.out.println("Ширина: " + this.width);
        System.out.println("Высота: " + this.height);
        System.out.println("Цвет: " + this.color);
        if (this.emptyFlag) {
            System.out.println("Текущие содержимое: ничего");
        } else {
            System.out.println("Текущие содержимое: " + this.item);
        }
        if (this.openFlag) {
            System.out.println("Текущие состояние: открыта");
        } else {
            System.out.println("Текущие состояние: закрыта");
        }
    }

    public void putItem(String itemName) {
        if (!this.openFlag) {
            System.out.println("Предмет " + itemName + " не добавлен!");
            System.out.println("Коробка закрыта");
            return;
        }
        if (!this.emptyFlag) {
            System.out.println("Предмет " + itemName + " не добавлен!");
            System.out.println("Коробка не пуста");
            return;
        }
        this.item = itemName;
        this.emptyFlag = false;
        System.out.println("Добавлен предмет: " + this.item);
        return;
    }

    public void takeItem() {
        if (!this.openFlag) {
            System.out.println("Предмет " + this.item + " не взят!");
            System.out.println("Коробка закрыта");
            return;
        }
        if (this.emptyFlag) {
            System.out.println("Брать нечего, коробка пуста");
            return;
        }
        System.out.println("Предмет " + this.item + " успешно взят");
        this.emptyFlag = true;
        this.item = "";
        return;
    }
}
