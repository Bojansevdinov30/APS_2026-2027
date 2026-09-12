package dataStructures;

public interface Queue<E> {
    // Елементи на редицата се обjекти од произволен тип.
    // Методи за пристап:
    public boolean isEmpty();

    // Вра´ка true ако и само ако редицата е празна.
    public int size();
    // Jа вра´ка должината на редицата.

    public E peek();
    // Го вра´ка елементот од почетокот на редицата.

    // Методи за трансформациjа:

    public void clear();
    // Jа празни редицата.

    public void enqueue(E x);
    // Го додава x на краj на редицата.

    public E dequeue();
    // Го отстранува и вра´ка почетниот елемент на редицата.
}
