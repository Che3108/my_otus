package ru.otus.cherepanovvs.lesson17;

public class MyQueue<T> {
    private MyLinkedList<T> contents;

    public MyQueue() {
        this.contents = new MyLinkedList<>();
    }

    public void offer(T data) {
        this.contents.addLast(data);
    }

    public T poll() {
        if (this.contents.getSize() == 0) {
            return null;
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
