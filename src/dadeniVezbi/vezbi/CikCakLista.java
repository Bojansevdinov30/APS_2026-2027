package dadeniVezbi.vezbi;

import dataStructures.SLL;
import dataStructures.SLLNode;

import java.util.Scanner;

/*Eднострано поврзана листа треба да се трансформира во Цик-Цак листа така што:

1.Сите елементи со вредност 0 се бришат

2.Ако има два позитивни елементи еден до друг се брише вториот

3.Ако има два негативни елементи еден до друг, помеѓу нив се додава нов јазел со вредност апсолутен број од првиот јазел

input: 8 4 7 -3 -2 0 7 7 9

output: 4 -3 3 -2 7*/
public class CikCakLista {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        SLL<Integer> zigZagList = new SLL<Integer>();
        for (int i = 0; i < n; i++) {
            zigZagList.insertLast(sc.nextInt());
        }

        transformList(zigZagList);
    }

    private static void transformList(SLL<Integer> zigZagList) {
        SLLNode<Integer> curr = zigZagList.getHead();
        boolean positive = false;
        boolean negative = false;
        int negativeNum = 0;

        while (curr != null) {
            if(curr.getElement().equals(0)) {
                zigZagList.delete(curr);
            }
            if(curr.getElement() > 0) {
                if(positive) {
                    zigZagList.delete(curr);
                    positive = false;
                    continue;
                }
                positive = true;
                negative = false;
            } else {
                if(negative) {
                    zigZagList.insertBefore(Math.abs(negativeNum), curr);
                    negative = false;
                    continue;
                }
                negative = true;
                negativeNum = curr.getElement();
                positive = false;
            }
            curr = curr.getSucc();
        }

        System.out.println(zigZagList);
    }

}
