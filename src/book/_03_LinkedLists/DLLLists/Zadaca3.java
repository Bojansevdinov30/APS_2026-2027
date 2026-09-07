package book._03_LinkedLists.DLLLists;

import dataStructures.DLL;
import dataStructures.DLLNode;

import java.io.*;

/*
Дадена е двострано поврзана листа коjа содржи природни броеви. Ваша задача
е да jа преуредите влезната листата, т.ш. ме´гу секои два соседни jазли од влез-
ната листа ´ке додадете нов jазел коj ´ке jа содржи средната вредност од двата
соседни jазли. Доколку средната вредност е децимална, тогаш броjот треба да
биде заокружен на поголемиот (пр. Ако соседните jазли имаат вредност 1 и 2,
нивната средна вредност е 1,5 и оваа вредност се заокружува на 2).

Влез: Од стандарден влез во првиот ред се дава цел броj N, коj го претста-
вува броjот на елементи во листата, а во вториот се даваат броевите во листата
одделени со празно место.

Излез: Ваша задача е да jа испечатите резултантната листа.
Пример.
Влез:
3
1 2 4
Излез:
1 2 2 3 4
*/
public class Zadaca3 {
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        DLL<Integer> lista = new DLL<Integer>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int N = Integer.parseInt(s);
        s = br.readLine();
        String[] pomniza = s.split(" ");
        for (int i = 0; i < N; i++) {
            lista.insertLast(Integer.parseInt(pomniza[i]));
        }

        DLLNode<Integer> tmp = lista.getFirst();
        DLLNode<Integer> next = tmp.getSucc();
        while (tmp != null && next != null) {
            float a = tmp.getElement();
            float b = next.getElement();
            Integer nov = Math.round((a + b) / 2);
            lista.insertAfter(nov, tmp);
            tmp = next;
            next = tmp.getSucc();
        }

        tmp = lista.getFirst();
        while (tmp != null) {
            System.out.print(tmp.getElement() + " ");
            tmp = tmp.getSucc();
        }
    }
}
