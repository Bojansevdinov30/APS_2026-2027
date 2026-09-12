package dataStructures;

import java.util.NoSuchElementException;

public class LinkedStack<E> implements Stack<E> {
    // top е линк до првиот jазол од еднострано поврзаната листа коjа ги содржи елементите на стекот.
    private SLLNode<E> top;
    int size;

    public LinkedStack() {
        // Конструкциjа на нов, празен стек.
        top = null;
        size = 0;
    }

    @Override
    public String toString() {
        // O(n) complexity
        // Прави текстуална репрезентациjа на стекот.
        SLLNode<E> current = top;
        StringBuilder s = new StringBuilder();
        while (current != null) {
            s.append(current.element);
            s.append(" ");
            current = current.succ;
        }
        return s.toString();
    }

    public boolean isEmpty() {
        // Вра´ка true ако и само ако стекот е празен.
        return (top == null);
    }

    public void clear() {
        // O(1) complexity
        // Го празни стекот.
        top = null;
        size = 0;
    }

    public E peek() {
        // O(1) complexity
        // Го вра´ка елементот на врвот на стекот.
        if (top == null)
            return null;
        return top.element;
    }

    public void push(E x) {
        // O(1) complexity
        // Го додава x на врвот на стекот.
        top = new SLLNode<E>(x, top);
        size++;
    }

    public int size() {
        // Jа вра´ка должината на стекот.
        return size;
    }

    public E pop() {
        // O(1) complexity
        // Го отстранува и вра´ка елементот што е на врвот на стекот.
        if (top == null)
            throw new NoSuchElementException();
        E topElem = top.element;
        size--;
        top = top.succ;
        return topElem;
    }

}
