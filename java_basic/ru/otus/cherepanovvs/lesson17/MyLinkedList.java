package ru.otus.cherepanovvs.lesson17;

public class MyLinkedList<T> {
    private int size;
    private MyNode<T> first;
    private MyNode<T> last;

    public MyLinkedList() {
        this.size = 0;
    }

    public int getSize() {
        return this.size;
    }

    public void addLast(T data) {
        MyNode<T> newNode = new MyNode<T>(data, null);
        if (this.size == 0) {
            this.first = newNode;
            this.last = this.first;
        } else {
            this.last.setNext(newNode);
            this.last = newNode;
        }
        ++this.size;
    }

    public void addFirst(T data) {
        MyNode<T> newNode = new MyNode<T>(data, null);
        if (this.size == 0) {
            this.first = newNode;
            this.last = this.first;
        } else {
            newNode.setNext(this.first);
            this.first = newNode;
        }
        ++this.size;
    }

    public T getFirst() {
        if (this.size == 0) {
            return null;
        }
        return this.first.getValue();
    }

    public T getLast() {
        if (this.size == 0) {
            return null;
        }
        return this.last.getValue();
    }

    public T get(int position) throws IndexOutOfBoundsException {
        checkIndexOutOfBounds(position, this.size);
        MyNode<T> currentNode = this.first;
        for (int i = 0; i < position; i++) {
            currentNode = currentNode.getNext();
        }
        return currentNode.getValue();
    }

    public void remove(int position) throws IndexOutOfBoundsException {
        checkIndexOutOfBounds(position, this.size);
        if (position == 0) {
            this.first = this.first.getNext();
            -- this.size;
            return;
        }
        MyNode<T> currentNode = this.first;
        MyNode<T> previousNode = null;
        for (int i = 0; i < position; i++) {
            previousNode = currentNode;
            currentNode = currentNode.getNext();
        }
        previousNode.setNext(currentNode.getNext());
        --this.size;
        return;
    }

    public void add(int position, T data) throws IndexOutOfBoundsException {
        checkIndexOutOfBounds(position, this.size);
        if (position == 0) {
            this.addFirst(data);
            return;
        }
        MyNode<T> newNode = new MyNode<T>(data, null);
        MyNode<T> currentNode = this.first;
        MyNode<T> previousNode = null;
        for (int i = 0; i < position; i++) {
            previousNode = currentNode;
            currentNode = currentNode.getNext();
        }
        newNode.setNext(currentNode);
        previousNode.setNext(newNode);
        ++this.size;
        return;
    }

    @Override
    public String toString() {
        String result = "[";
        MyNode<T> currentNode = this.first;
        for (int i = 0; i < this.size; i++) {
            result += currentNode.getValue();
            if (i != this.size - 1) {
                result += ", ";
            }
            currentNode = currentNode.getNext();
        }
        result += "]";
        return result;
    }

    private static void checkIndexOutOfBounds(int index, int limit) throws IndexOutOfBoundsException {
        if ((index >= limit) ||  (index < 0)) {
            throw new IndexOutOfBoundsException("Индекс " + index + " не существует в списке размера " + limit);
        }
    }
}
