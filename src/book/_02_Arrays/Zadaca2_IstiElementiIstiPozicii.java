package book._02_Arrays;

import dataStructures.Array;

// Promena na nizi vo zavisnost od toa dali ima isti elementi na isti pozicii.
public class Zadaca2_IstiElementiIstiPozicii {

    public static class ChangeArrays<E> {

        // Moze i kako static genericki metod:
        // public static <E> void compareAndChangeArrays(Array<E> arr1, Array<E> arr2)
        public void compareAndChangeArrays(Array<E> arr1, Array<E> arr2) {
            if (arr1.getSize() != arr2.getSize()) {
                System.out.println("Nizite ne se so ista golemina!");
                return;
            }

            int size = arr1.getSize();
            int i = 0;
            while (i < size) {
                if (arr1.get(i).equals(arr2.get(i))) {
                    arr1.delete(i);
                    arr2.delete(i);
                    size--;
                } else {
                    i++;
                }
            }
        }
    }

    public static void main(String[] args) {
        Array<String> arr1 = new Array<String>(4);
        arr1.insertLast("nb11");
        arr1.insertLast("b1");
        arr1.insertLast("b2");
        arr1.insertLast("nb12");

        Array<String> arr2 = new Array<String>(4);
        arr2.insertLast("nb21");
        arr2.insertLast("b1");
        arr2.insertLast("b2");
        arr2.insertLast("nb22");

        System.out.println("Nizite pred primenuvanjeto na funkcijata: ");
        System.out.println(arr1);
        System.out.println(arr2);

        ChangeArrays<String> pom = new ChangeArrays<String>();
        pom.compareAndChangeArrays(arr1, arr2);

        System.out.println("Nizite po primenuvanjeto na funkcijata: ");
        System.out.println(arr1);
        System.out.println(arr2);

        Array<Integer> arr3 = new Array<Integer>(3);
        arr3.insertLast(10);
        arr3.insertLast(13);
        arr3.insertLast(7);

        Array<Integer> arr4 = new Array<Integer>(3);
        arr4.insertLast(5);
        arr4.insertLast(13);
        arr4.insertLast(3);

        System.out.println("Nizite pred primenuvanjeto na funkcijata: ");
        System.out.println(arr3);
        System.out.println(arr4);

        ChangeArrays<Integer> pom2 = new ChangeArrays<Integer>();
        pom2.compareAndChangeArrays(arr3, arr4);

        System.out.println("Nizite po primenuvanjeto na funkcijata: ");
        System.out.println(arr3);
        System.out.println(arr4);
    }
}
