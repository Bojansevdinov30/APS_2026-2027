package book._03_LinkedLists.SLLLists;

import java.util.Scanner;
import dataStructures.SLL;
import dataStructures.SLLNode;

// Izbrisi go poslednoto pojavuvanje na broj od lista.
public class Zadaca1_IzbrishiPoslednoPojavuvanje {
// compareTo is used for ordering, equals for equality
    public static void removeLast(SLL<Integer> sll, int numberToDelete) {
        SLLNode<Integer> temp = null;
        SLLNode<Integer> curr =  sll.getHead();
        while(curr != null){
            if(curr.getElement().equals(numberToDelete)){
                temp = curr;
            }
            curr = curr.getSucc();
        }
        sll.delete(temp);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        SLL<Integer> list = new SLL<Integer>();
        for (int i = 0; i < n; i++) {
            list.insertLast(sc.nextInt());
        }
        int numberToDelete =  sc.nextInt();
        removeLast(list, numberToDelete);
        System.out.println(list.toString());
    }
}
