package dataStructures;

public interface Stack<E> {
    // Елементи на стекот се обjекти од произволен тип.
    // Методи за пристап:
    public boolean isEmpty();
    // Вра´ка true ако и само ако стекот е празен.

    public E peek();
    // Го вра´ка елементот на врвот од стекот.

    // Методи за трансформациjа:
    public void clear();
    // Го празни стекот.

    public void push(E x);
    // Го додава x на врвот на стекот.

    public E pop();
    // Го отстранува и вра´ка елементот што е на врв на стекот.
}