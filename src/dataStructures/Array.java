package dataStructures;

public class Array<E> {
    private E[] data;
    private int size;

    public Array(int capacity) {
        this.data = (E[]) new Object[capacity];
        this.size = 0;
    }

    public void insertLast(E o) {
        // O(1) complexity
        if (size == data.length) {
            System.out.println("Array is full");
            return;
        }
        data[size] = o;
        size++;
    }

    public void insert(int position, E o) {
        // O(n) complexity
        if (size == data.length) {
            System.out.println("Array is full");
        }
        if (position < 0 || position > size) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = size; i > position; i--) {
            data[i] = data[i - 1];
        }
        data[position] = o;
        size++;
    }

    public void set(int position, E o) {
        // O(1) complexity
        if (position < 0 || position > size) {
            throw new IndexOutOfBoundsException();
        }
        data[position] = o;
    }

    public E get(int position) {
        // O(1) complexity
        if (position < 0 || position > size) {
            throw new IndexOutOfBoundsException();
        }
        return data[position];
    }

    public int find(E o) {
        // O(n) complexity
        for (int i = 0; i < size; i++) {
            if (data[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    public int getSize() {
        //O(1) complexity
        return size;
    }

    public void delete(int position) {
        // O(n) complexity
        if (position < 0 || position >= size) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = position; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        data[size - 1] = null;
        size--;
    }

    public void resize(int newCapacity) {
        // O(n) complexity
        // moze i bez newCapacity, togas odime so new Object[size*2]
        if (newCapacity < size) {
            throw new IllegalArgumentException(
                    "New capacity cannot be smaller than size"
            );
        }

        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
        // DON'T DO size = newCapacity; THAT IS EXACTLY WHAT NOT TO DO
    }

    @Override
    public String toString() {
        // O(n) complexity, but technically it is n^2 because it creates new strings each time, there is another method below
        /*
        @Override
        public String toString() {
            if (size == 0) {
            return "Array is empty";
            }

        StringBuilder str = new StringBuilder("{ ");

        for (int i = 0; i < size; i++) {
            str.append(element[i]).append(" ");
        }

        str.append("}");

        return str.toString();
        }
        */
        if (size == 0) {
            return "Array is empty";
        }
        String str = "{ ";
        for (int i = 0; i < size; i++) {
            str += data[i] + " ";
        }
        str += "}";
        return str;
    }

}
