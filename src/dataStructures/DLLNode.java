package dataStructures;

public class DLLNode<E extends Comparable<E>> {
    public E element;
    public DLLNode<E> pred;
    public DLLNode<E> succ;
    // staveno e zaradi zadaca 5 od Auds1 - brisenje na duplikati
    protected int numAppearances;

    public DLLNode(E element, DLLNode<E> pred, DLLNode<E> succ) {
        this.element = element;
        this.pred = pred;
        this.succ = succ;
        this.numAppearances = 1;
    }

    @Override
    public String toString() {
        return element.toString() + "(" + numAppearances + ")";
    }

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public DLLNode<E> getPred() {
        return pred;
    }

    public void setPred(DLLNode<E> pred) {
        this.pred = pred;
    }

    public DLLNode<E> getSucc() {
        return succ;
    }

    public void setSucc(DLLNode<E> succ) {
        this.succ = succ;
    }

    public int getNumAppearances() {
        return numAppearances;
    }

    public void setNumAppearances(int numAppearances) {
        this.numAppearances = numAppearances;
    }
}
