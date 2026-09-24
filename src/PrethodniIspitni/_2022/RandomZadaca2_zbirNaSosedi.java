package PrethodniIspitni._2022;
/*
Во ДЛЛ со едно изминување да се провере колку броја поголеми може да се најдат од големиот број како збир од два соседни.
Ако се спојат два соседни се брише вториот.

Sample input:
9 8 7 6 5 4 3 2 1 2 3 4 5 6 7 8 9
40

Sample output:
98<->76<->54<->3<->2<->1<->2<->3<->45<->67<->89<->
*/

import dataStructures.DLL;
import dataStructures.DLLNode;

import java.io.*;

public class RandomZadaca2_zbirNaSosedi {
    public static void spojka(DLL<Integer> lista, int n) {
        DLLNode<Integer> node = lista.getFirst(), kraj = lista.getLast();

        while (node.succ != null) {
            String s = node.toString() + node.succ.toString();
            double broj = Double.parseDouble(s);
            if (broj > n) {
                if (node.succ != null) lista.insertAfter((int) broj, node.succ);
                lista.delete(node);
                if (node.succ != null) node = node.succ;
                lista.delete(node);
                if (node == kraj) break;
                if (node.succ.succ != null) node = node.succ.succ;
                //System.out.println(node);
            } else {
                if (node.succ != null) node = node.succ;
            }
        }
        System.out.println(lista);
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        DLL<Integer> list = new DLL<>();

        String line = br.readLine();
        String[] parts = line.split(" ");
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < parts.length; i++)
            list.insertLast(Integer.parseInt(parts[i]));

        spojka(list, n);

    }

}
