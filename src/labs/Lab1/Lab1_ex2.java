package labs.Lab1;

import dataStructures.SLL;
import dataStructures.SLLNode;

import java.util.Scanner;
// vo SLL najdi gi stringovite so dolzina l i premesti gi na kraj
public class Lab1_ex2 {
    public static void solve(SLL<String> list, int l){
        SLLNode<String> tmp = list.getHead();
        SLLNode<String> prev = list.getHead();
        for (int i = 0; i < list.size(); i++) {
            if (tmp.getData().length() == l){
                prev = tmp;
                list.insertLast(tmp.getData());
                list.delete(tmp);
                tmp = prev.getNext();
            }
            else tmp = tmp.getNext();
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        SLL<String>list = new SLL<>();
        for (int i = 0; i < n; i++) {
            list.insertLast(in.next());
        }
        int l = in.nextInt();
        System.out.println(list.toString());
        solve(list,l);
        System.out.println(list.toString());
    }
}
