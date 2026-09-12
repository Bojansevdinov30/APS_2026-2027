package auds.auds5;

import java.util.NoSuchElementException;

/*Da se implementira niza so 2 stekovi od dvete strani*/
public class Zadaca2_DvostranStack {

    public static class DoubleArrayStack<E> {
        private E[] elements;
        private int depth1;
        private int depth2;

        private DoubleArrayStack(int maxDepth) {
            this.elements = (E[]) new Object[maxDepth];
            this.depth1 = 0;
            this.depth2 = 0;
        }

        public boolean isFull(){
            return (depth1 + depth2 == elements.length);
        }

        public boolean isEmptyFirst() {
            return depth1 == 0;
        }

        public boolean isEmptySecond() {
            return depth2 == 0;
        }

        public void clearFirst() {
            for (int i = 0; i < depth1; i++) {
                elements[i] = null;
            }
            depth1 = 0;
        }

        public void clearSecond() {
            for (int i = elements.length - 1; i >= elements.length - depth2; i--) {
                elements[i] = null;
            }
            depth2 = 0;
        }

        public E peekFirst() {
            if(depth1 ==0){
                throw new NoSuchElementException();
            }
            return elements[depth1-1];
        }

        public E peekSecond() {
            if(depth2 ==0){
                throw new NoSuchElementException();
            }
            return elements[elements.length-depth2];
        }

        public void pushFirst(E e) {
            if(!isFull()) {
                elements[depth1++] = e;
            }
        }

        public void pushSecond(E e) {
            if(!isFull()) {
                elements[elements.length - (++depth2)] = e;
            }
        }

        public E popFirst() {
            if(depth1 ==0){
                throw new NoSuchElementException();
            }
            E top = elements[--depth1];
            elements[depth1] = null;
            return top;
        }

        public E popSecond() {
            if(depth2 ==0){
                throw new NoSuchElementException();
            }
            E top = elements[elements.length - depth2];
            elements[depth2--] = null;
            return top;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for(E e : elements){
                sb.append(e.toString()).append(" ");
            }
            return sb.toString();
        }
    }

 public static void main(String[] args) {
         DoubleArrayStack<Integer> d = new DoubleArrayStack<Integer>(6);
         d.pushFirst(1);
         d.pushFirst(2);
         d.pushFirst(3);
         d.pushSecond(-1);
         d.pushSecond(-2);
         d.pushSecond(-3);
         System.out.println("Vrv na prv: " + d.peekFirst() + ", dolzina na prv: " + d.depth1);
         System.out.println("Vrv na vtor: " + d.peekSecond() + ", dolzina na vtor: " + d.depth2);
         d.pushFirst(4);
         d.popFirst();
         d.pushFirst(4);
         System.out.println("Vrv na prv: " + d.peekFirst() + ", dolzina na prv: " + d.depth1);
         System.out.println(d.toString());
         }
}
