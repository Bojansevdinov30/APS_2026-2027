package dataStructures;

public class SLLNode<E> {
    protected E element;
    protected SLLNode<E> succ; // SE E PO REFERENCA

    public SLLNode(E element, SLLNode<E> succ) {
        this.element = element;
        this.succ = succ;
    }

    public E getElement() {
        return element;
    }

    public SLLNode<E> getSucc() {
        return succ;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public void setSucc(SLLNode<E> succ) {
        this.succ = succ;
    }
}
