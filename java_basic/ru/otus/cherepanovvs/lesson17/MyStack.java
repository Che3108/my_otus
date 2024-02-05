package ru.otus.cherepanovvs.lesson17;

public class MyStack<T> {
    private MyLinkedList<T> contents;

    public MyStack() {
        this.contents = new MyLinkedList<>();
    }

    public void push(T data) {
        this.contents.addFirst(data);
    }

    public T pop() throws Empty {
        if (this.contents.getSize() == 0) {
            throw new Empty("Стек пуст");
        }
        T value = this.contents.getFirst();
        this.contents.remove(0);
        return value;
    }

    @Override
    public String toString() {
        return this.contents.toString();
    }
}

class Empty extends RuntimeException {
    public Empty(String var1) {
        super(var1);
    }
}
