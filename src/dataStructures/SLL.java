package dataStructures;

import java.util.Iterator;
import java.util.NoSuchElementException;
// the iterable interface is implemented so that we can use ehanced for on this class
public class SLL<E> implements Iterable<E> {
    private SLLNode<E> head;

    public SLL() {
        this.head = null;
    }

    public SLLNode<E> getHead() {
        return head;
    }

    @Override
    public String toString() {
        // O(n) complexity - it goes through them all, if we had String instead of StringBuilder, it would have been O(n^2) technically
        if (this.head == null) {
            return "Prazna lista!";
        }
        StringBuilder ret = new StringBuilder();
        SLLNode<E> curr = this.head;
        ret.append(curr.data);
        while (curr.next != null) {
            curr = curr.next;
            ret.append(" -> ").append(curr.data);
        }
        return ret.toString();
    }

    public void insertFirst(E object) {
        // O(1) complexity
        SLLNode<E> newNode = new SLLNode<E>(object, head);
        head = newNode;
    }

    public void insertAfter(E object, SLLNode<E> node) {
        // O(1) complexity
        if (node != null) {
            SLLNode<E> ins = new SLLNode<E>(object, node.next);
            node.next = ins;
        } else {
            System.out.println("Dadeniot jazol e null!");
        }
    }

    public void insertLast(E object) {
        // O(n) complexity
        if (head == null) {
            insertFirst(object);
        } else {
            SLLNode<E> temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new SLLNode<E>(object, null);
        }
    }

    public void insertBefore(E object, SLLNode<E> node) {
        // O(n) complexity
        if (head != null) {
            if (head == node) {
                this.insertFirst(object);
                return;
            }
            SLLNode<E> curr = head;
            while (curr.next != node && curr.next != null) {
                curr = curr.next;
            }
            if (curr.next == node) {
                curr.next = new SLLNode<E>(object, node);
            } else {
                System.out.println("Elementot ne postoi vo nizata!");
            }
        } else {
            System.out.println("Listata e prazna!");
        }
    }

    public E deleteFirst() {
        // O(1) complexity
        if (head == null) {
            System.out.println("Listata e prazna!");
            return null;
        }
        SLLNode<E> temp = head;
        head = head.next;
        return temp.data;
    }

    public E delete(SLLNode<E> node) {
        // O(n) complexity
        if (head == null) {
            System.out.println("Listata e prazna!");
            return null;
        }
        if (head == node) {
            return this.deleteFirst();
        }
        SLLNode<E> curr = head;
        while (curr.next != node && curr.next != null) {
            curr = curr.next;
        }
        if (curr.next == node) {
            curr.next = curr.next.next;
            return node.data;
        } else {
            System.out.println("Elementot ne postoi vo nizata!");
            return null;
        }
    }

    public int size() {
        // O(n) complexity
        int count = 0;
        SLLNode<E> curr = head;

        while (curr != null) {
            count++;
            curr = curr.next;
        }

        return count;
    }

    public SLLNode<E> find(E object) {
        // O(n) complexity
        if (head == null) {
            System.out.println("Listata e prazna!");
            return null;
        }
        SLLNode<E> curr = head;
        while (!curr.data.equals(object) && curr.next != null) {
            curr = curr.next;
        }
        if (curr.data.equals(object)) {
            return curr;
        } else {
            System.out.println("Elementot ne postoi vo nizata!");
            return null;
        }
    }

    public void merge(SLL<E> in) {
        // O(n) complexity
        if (head == null) {
            head = in.getHead();
        }
        SLLNode<E> curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = in.getHead();
    }

    public void deleteList(){
        // O(1) complexity
        this.head = null;
    }

    public void mirror() {
        // O(n) complexity
        if (head != null) {
            SLLNode<E> temp = head;
            SLLNode<E> newSucc = null;
            SLLNode<E> next;

            while (temp != null) {
                next = temp.next;
                temp.next = newSucc;
                newSucc = temp;
                temp = next;
            }

            head = newSucc;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new SLLIterator();
    }

    private class SLLIterator implements Iterator<E> {

        private SLLNode<E> current;

        public SLLIterator() {
            current = head;
        }

        @Override
        public boolean hasNext() {
            // O(1) complexity
            return current != null;
        }

        @Override
        public E next() {
            // O(1) complexity
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            E data = current.data;
            current = current.next;

            return data;
        }
    }

}
