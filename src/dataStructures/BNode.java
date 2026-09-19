package dataStructures;

public class BNode<E> {
    public E info;
    public BNode<E> left;
    public BNode<E> right;
    public static int LEFT = 1;
    public static int RIGHT = 2;
    public BNode<E> parent; // add a parent field in BNode

    public BNode(E info) {
        this.info = info;
        left = null;
        right = null;
        this.parent = null;
    }

    public BNode(E info, BNode<E> left, BNode<E> right) {
        this.info = info;
        this.left = left;
        this.right = right;
    }

    public BNode(E info, BNode<E> parent) { // create a new constructor in BNode
        this.info = info;
        left = null;
        right = null;
        this.parent = parent;
    }

    public E getInfo() {
        return info;
    }

    public void setInfo(E info) {
        this.info = info;
    }

    public BNode<E> getLeft() {
        return left;
    }

    public void setLeft(BNode<E> left) {
        this.left = left;
    }

    public BNode<E> getRight() {
        return right;
    }

    public void setRight(BNode<E> right) {
        this.right = right;
    }

    public static int getLEFT() {
        return LEFT;
    }

    public static void setLEFT(int LEFT) {
        BNode.LEFT = LEFT;
    }

    public static int getRIGHT() {
        return RIGHT;
    }

    public static void setRIGHT(int RIGHT) {
        BNode.RIGHT = RIGHT;
    }

}
