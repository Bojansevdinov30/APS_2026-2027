package PrethodniIspitni._2024;

import dataStructures.DLL;
import dataStructures.DLLNode;

import java.io.*;
/*Да се напише функција која како аргумент прима DLL.
Инфото на секој јазел е буква распоредена во растечки редослед ( може да има и дупликати ).
Да се отстранат дупликатите, и јазлите да се распределат наизменично ( ако има две согласки или самогласки додруго, втората се брише).

Sample input:
a a e k k l i i s s

Sample output:
a<->k<->i<->s
*/
public class RandomZadaca3_samoglaskiSoglaskiRasporedNaLista {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        DLL<Character> list = new DLL<>();

        String line = br.readLine();
        String[] parts = line.split(" ");

        for (int i = 0; i < parts.length; i++) {
            list.insertLast(parts[i].charAt(0));
        }

        DLLNode<Character> node = list.getFirst();
        DLLNode<Character> node2 = node.succ;
        while (node != null) {
            node2 = node.succ;
            while (node2 != null) {
                if (node.element == node2.element) {
                    list.delete(node2);
                } else {
                    break;
                }
                node2 = node2.succ;
            }
            node = node.succ;
        }

        node = list.getFirst();
        while (node.succ != null) {
            if ((node.element == 'a' || node.element == 'e' || node.element == 'i' || node.element == 'o' || node.element == 'u') &&
                    (node.succ.element == 'a' || node.succ.element == 'e' || node.succ.element == 'i' || node.succ.element == 'o' || node.succ.element == 'u')) {
                list.delete(node.succ);
            } else if (!(node.element == 'a' || node.element == 'e' || node.element == 'i' || node.element == 'o' || node.element == 'u') &&
                    !(node.succ.element == 'a' || node.succ.element == 'e' || node.succ.element == 'i' || node.succ.element == 'o' || node.succ.element == 'u')) {
                list.delete(node.succ);
            }
            node = node.succ;
        }


        System.out.println(list);
    }

}
