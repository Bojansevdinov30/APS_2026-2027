package dataStructures;

import java.util.NoSuchElementException;

public class ArrayQueue<E> {
    // Редицата е претставена на следниот начин:
    // length го содржи броjот на елементи.
    // Ако length > 0, тогаш елементите на редицата се зачувани во elems[front...rear-1]
    // Ако rear > front, тогаш во elems[front...maxlength-1] и elems[0...rear-1]
    E[] elems;
    int length, front, rear;

    // Конструктор ...
    @SuppressWarnings("unchecked")
    public ArrayQueue(int maxlength) {
        elems = (E[]) new Object[maxlength];
        clear();
    }

    public E[] getElems() {
        return elems;
    }

    public void setElems(E[] elems) {
        this.elems = elems;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getFront() {
        return front;
    }

    public void setFront(int front) {
        this.front = front;
    }

    public int getRear() {
        return rear;
    }

    public void setRear(int rear) {
        this.rear = rear;
    }

    public boolean isEmpty() {
        // Вра´ка true ако и само ако редицата е празна.
        return (length == 0);
    }

    public int size() {
        // Jа вра´ка должината на редицата.
        return length;
    }

    public E peek() {
        // Го пра´ка елементот на почетокот на редицата.
        // O(1) complexity
        if (length > 0)
            return elems[front];
        else
            throw new NoSuchElementException();
    }

    public void clear() {
        // O(1) complexity
        // Jа празни редицата.
        length = 0;
        front = rear = 0; // произволно
    }

    public void enqueue(E x) {
        // O(1) complexity
        // Го додава x на краj на редицата.
        if (length == elems.length)
            throw new NoSuchElementException();
        elems[rear++] = x;
        if (rear == elems.length) rear = 0;
        length++;
    }

    public E dequeue() {
        // O(1) complexity
        // Го отстранува и вра´ка почетниот елемент на редицата.
        if (length > 0) {
            E frontmost = elems[front];
            elems[front++] = null;
            if (front == elems.length) front = 0;
            length--;
            return frontmost;
        } else
            throw new NoSuchElementException();
    }
}
