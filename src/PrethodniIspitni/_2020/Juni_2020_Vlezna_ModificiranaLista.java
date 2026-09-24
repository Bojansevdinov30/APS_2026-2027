package PrethodniIspitni._2020;
/*

Дадена е двојно поврзана лсита со n јазли кои содржат природни броеви. Треба да ја модифицирате листата така што новата вредност на
првиот елемент да е еднаква на сумата од вредноста на последниот јазел во листата и тековната вредност на првиот елемент, а после него
да се вметне јазел во листата со поголемата вредност од вредноста на последниот јазел и вредноста на првиот; понатаму новата вредност на
вториот јазел да е еднаква на сумата од вредноста на претпоследниот јазел во листата и вредноста на вториот јазел во листата, а после
него да се вметне јазел во листата со поголемата вредност од вредноста на претпоследниот и вториот јазел. Оваа модификација да се направи
се до средината на листата. Ако n е непарен број, тогаш да не се менува вредноста на средниот јазел во листата.

Sample input:
5
10 4 5 3 6

Sample output:
16 10 7 4 5 3 6
 */


import dataStructures.DLL;
import dataStructures.DLLNode;

import java.io.*;

public class Juni_2020_Vlezna_ModificiranaLista {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        DLL<Integer> list = new DLL<>();
        int num = Integer.parseInt(br.readLine());
        String line = br.readLine();
        String[] parts = line.split(" ");
        for (int i = 0; i < parts.length; i++) {
            list.insertLast(Integer.parseInt(parts[i]));
        }

        modified(list);
    }

    public static void modified(DLL<Integer> lista) {
        DLLNode<Integer> pocetok = lista.getFirst(),
                kraj = lista.getLast();

        for (int i = 0; i < lista.length() / 2 - 1; i++) {
            if (pocetok.element > kraj.element) {
                lista.insertAfter(pocetok.element, pocetok);
            } else {
                lista.insertAfter(kraj.element, pocetok);
            }
            lista.insertAfter(pocetok.element + kraj.element, pocetok);

            DLLNode<Integer> pomosen = pocetok;
            pocetok = pocetok.succ;
            lista.delete(pomosen);
            kraj = kraj.pred;
            pocetok = pocetok.succ.succ;


        }
        System.out.println(lista.toString());
    }

}
