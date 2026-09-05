package dataStructures;

public class SLLNode<E> {
    protected E data;
    protected SLLNode<E> next; // SE E PO REFERENCA

    public SLLNode(E data, SLLNode<E> next) {
        this.data = data;
        this.next = next;
    }

    public E getData() {
        return data;
    }

    public SLLNode<E> getNext() {
        return next;
    }
}
