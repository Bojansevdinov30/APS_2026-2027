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

    public void setHead(SLLNode<E> head) {
        this.head = head;
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

    public SLLNode<E> reverselist(SLLNode<E> node) {
        SLLNode<E> prev = null, curr = node, next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        node = prev;
        return node;
    }

    public void rearrange() {
        //1) Наjди jа средината на листата
        SLLNode<E> sredina = this.getHead();
        for (int i = 1; i < this.size() / 2; i++)
            sredina = sredina.next;
        System.out.println(sredina.data);

        //2) Подели jа листата на две половини
        //node1, првиот jазел од првата половина 1 -> 2 -> 3
        //node2, првиот jазел од втората половина 4 -> 5
        SLLNode<E> node1 = this.getHead();
        SLLNode<E> node2 = sredina.next;
        sredina.next = null;

        //3) Преврти jа втората половина т.е. 5 -> 4

        node2 = reverselist(node2);

        //4) Наизменично споjуваj ги jазлите
        SLLNode<E> node = new SLLNode<E>(null, null); //помошен jазoл

        // curr е покажувачот на помошниот jазол
        // од каде ´ке се формира новата листа
        SLLNode<E> curr = node;
        while (node1 != null || node2 != null) {

            // Прво додаj jазол од првата листа
            if (node1 != null) {
                curr.next = node1;
                curr = curr.next;
                node1 = node1.next;
            }

            // Па додаj jазол од втората листа
            if (node2 != null) {
                curr.next = node2;
                curr = curr.next;
                node2 = node2.next;
            }
        }

        // Отстрани го помошниот jазел
        node = node.next;
    }

}
