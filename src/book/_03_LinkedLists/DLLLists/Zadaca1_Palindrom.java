package book._03_LinkedLists.DLLLists;

import dataStructures.DLL;
import dataStructures.DLLNode;

import java.util.Scanner;

/*
Дадена е двоjно поврзана листа со N jазли каде секоj jазел содржи по еден броj.
Да се провери дали двоjно поврзаната листа е палиндром: односно ако jа изми-
нете од почеток до краj и од краj до почеток, дали ´ке добиете ист збор.

Влез: Во првиот ред од влезот даден е броjот на jазли во листата N, а во
вториот ред се дадени броевите.

Излез: На излез треба да се испечати 1 ако листата е палиндром, -1 ако не е.

Пример.
Влез 1:
5
1 2 3 1 2
Излез:
-1
Влез 2:
5
1 2 3 2 1
Излез:
1
*/
public class Zadaca1_Palindrom {

    public static int isItPalindrome(DLL<Integer> list) {
        DLLNode<Integer> poceten = list.getFirst();
        DLLNode<Integer> posleden = list.getLast();

        while((poceten != posleden)&&(poceten.getPred() != posleden)){
            if(!poceten.getElement().equals(posleden.getElement())){
                return -1;
            }
            poceten = poceten.getSucc();
            posleden = posleden.getPred();
        }
        return 1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        DLL<Integer> list = new DLL<Integer>();
        for (int i = 0; i < n; i++) {
            list.insertLast(in.nextInt());
        }
        in.close();
        System.out.println(isItPalindrome(list));
    }

}
