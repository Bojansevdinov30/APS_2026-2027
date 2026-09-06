package book._03_LinkedLists.SLLLists;

import dataStructures.SLL;
import java.util.*;
import dataStructures.SLLNode;

/*
Дадена е еднострано поврзана листа со природни броеви. Да се креираат две
резултантни еднострано поврзани листи т.ш. во првата листа ´ке се земаат само
jазлите што содржат парни броj, при што доколку во првичната листа има пове´ке
соседни jазли со парни броеви се зема само последниот jазел. Слична процедура
се применува и за втората резултантна листа, при што овде се земаат само jазлите
што содржат непарни броеви, при што ако има пове´ке соседни jазли со непарни
броеви се зема само последниот jазел.
Влез: Во првата линиjа е даден броjот на елементи n. Во втората линиjа се
даваат броевите во листата одделени со празно место.
Излез: Прво се печати резултантната листа со прости броеви, а потоа во нов
ред таа со непрости. Доколку некоjа од листите е празна се печати: Prazna lista.
Пример.
Влез:
8
1 3 2 4 5 7 6 8
Излез:
4->8
3->7
 */
public class Zadaca3 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        SLL<Integer> lista = new SLL<Integer>();
        SLL<Integer> parni = new SLL<Integer>();
        SLL<Integer> neparni = new SLL<Integer>();

        int n = input.nextInt();
        for (int i = 0; i < n; i++) {
            lista.insertLast(input.nextInt());
        }

        SLLNode<Integer> temp = lista.getHead();

        while (temp != null) {
            while (temp.getNext() != null && temp.getData() %2 == 0 && temp.getNext().getData() % 2 ==0) {
                temp = temp.getNext();
            }
            while (temp.getNext() != null && temp.getData() %2 != 0 && temp.getNext().getData() % 2 !=0) {
                temp = temp.getNext();
            }
            if (temp.getData() % 2 == 0){
                parni.insertLast(temp.getData());
            }else {
                neparni.insertLast(temp.getData());
            }
            temp = temp.getNext();

        }
        System.out.println(parni.toString());
        System.out.println(neparni.toString());

    }

}
