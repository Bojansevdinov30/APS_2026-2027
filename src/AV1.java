import java.util.Scanner;
import java.util.ArrayList;
public class AV1 {
    // ArrayTester
    /*public static void main(String[] args){
        Array<Integer> a = new Array<Integer>(5);
        for(int i=0;i<4;i++){
            a.insertLast(i);
        }

        a.insert(0, 5);
        for(int i=0;i<5;i++){
            System.out.println(a.get(i));
        }

    }*/
    // zadaca 1 - element najblisku do prosekot na nizata
    /* public static int elementClosestToMean(Array<Integer> a){

        int sum =0;
        for (int i=0; i < a.getSize(); i++){
            sum += a.get(i);
        }
        int average = sum/a.getSize();
        int min_diff = Math.abs((a.get(0) - average));
        int index = 0;
        for (int i = 1; i < a.getSize(); i++) {
            if(Math.abs(a.get(i) - average) < min_diff){
                min_diff = Math.abs(a.get(i) - average);
                index = i;
            }else if(Math.abs(a.get(i) - average) == min_diff){
                if(a.get(i) < a.get(index)){
                    index = i;
                }
            }
        }
        return a.get(index);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        Array<Integer> a = new Array<Integer>(N);
        for (int i = 0; i < N; i++) {
            a.insertLast(input.nextInt());
        }
        System.out.println(elementClosestToMean(a));
    }*/
    // zadaca 2 - promena na nizi vo zavisnost od toa dali ima isti elementi na isti pozicii
    /*
    public static class ChangeArrays<E> {
        // namesto ovaka mozes i vaka:  public static <E> void compareAndChangeArrays(Array<E> arr1, Array<E> arr2) {
        //        ...
        //    }
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
        System.out.println(arr1.toString());
        System.out.println(arr2.toString());

        ChangeArrays<String> pom = new ChangeArrays<String>();
        pom.compareAndChangeArrays(arr1, arr2);

        System.out.println("Nizite po primenuvanjeto na funkcijata: ");
        System.out.println(arr1.toString());
        System.out.println(arr2.toString());

        Array<Integer> arr3 = new Array<Integer>(3);
        arr3.insertLast(10);
        arr3.insertLast(13);
        arr3.insertLast(7);

        Array<Integer> arr4 = new Array<Integer>(3);
        arr4.insertLast(5);
        arr4.insertLast(13);
        arr4.insertLast(3);

        System.out.println("Nizite pred primenuvanjeto na funkcijata: ");
        System.out.println(arr3.toString());
        System.out.println(arr4.toString());

        ChangeArrays<Integer> pom2 = new ChangeArrays<Integer>();
        pom2.compareAndChangeArrays(arr3, arr4);

        System.out.println("Nizite po primenuvanjeto na funkcijata: ");
        System.out.println(arr3.toString());
        System.out.println(arr4.toString());

    }*/
    // zadaca 3 - За дадена низа од N (1<=N<=50) природни броеви да се избришат дупликат вредностите кои се jавуваат на соседни позиции
    /*
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        ArrayList<Integer> list = new ArrayList<Integer>(n);

        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
        }

        int i = 1;

        while (i < list.size()) {
            if (list.get(i).equals(list.get(i - 1))) {
                list.remove(i);
            } else {
                i++;
            }
        }

        for (int num : list) {
            System.out.print(num + " ");
        }
    }
    */
    // zadaca 4 - За дадена низа од N природни броеви меѓу секои два соседи да се внесе нов елемент коj е просек од двата соседи.
    /*
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        ArrayList<Integer> list = new ArrayList<>(2 * n - 1);

        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
        }

        int i = 0;

        while (i < list.size() - 1) {
            int average = (int) Math.round((list.get(i) + list.get(i + 1)) / 2.0);

            list.add(i + 1, average);

            i += 2;
        }

        for (int num : list) {
            System.out.print(num + " ");
        }
    }*/

}
