package dataStructures;

import java.util.NoSuchElementException;

public class LinkedQueue<E> implements Queue<E> {
    // Редицата е претставена на следниот начин:
    // length го содржи броjот на елементи.
    // Елементите се зачувуваат во jазли од SLL
    // front и rear се линкови до првиот и последниот jазел соодветно.
    SLLNode<E> front, rear;
    int length;

    // Конструктор ...
    public LinkedQueue() {
        clear();
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
        // O(1) complexity
        // Го вра´ка елементот на почетокот на редицата.
        if (front == null)
            throw new NoSuchElementException();
        return front.element;
    }

    public void clear() {
        // O(1) complexity
        // Jа празни редицата.
        front = rear = null;
        length = 0;
    }

    public void enqueue(E x) {
        // O(1) complexity
        // Го додава x на краj на редицата.
        SLLNode<E> latest = new SLLNode<E>(x, null);
        if (rear != null) {
            rear.succ = latest;
            rear = latest;
        } else
            front = rear = latest;
        length++;
    }

    public E dequeue() {
        // O(1) complexity
        // Го отстранува и вра´ка почетниот елемент на редицата.
        if (front != null) {
            E frontmost = front.element;
            front = front.succ;
            if (front == null) rear = null;
            length--;
            return frontmost;
        } else
            throw new NoSuchElementException();
    }
}
