package PrethodniIspitni._2018;
/*
Даена беше еднострано поврзана листа, се бараше N пати да се избрише средината.
Ако листата е со парен број елементи од 2та средишни елементи се брише помалиот, а ако се исти се брише првиот.
Влез: првата линија број на елементи на листата,вториот ред елементите на листата и во третиот ред број колку пати да се избрише средината.
*/


import dataStructures.SLL;
import dataStructures.SLLNode;

import java.io.*;

public class Juni_2018_Vlezna_BrisenjeSredina {
    public static void juni(SLL<Integer> list, int n) {

        for (int i = 0; i < n; i++) {
            SLLNode<Integer> node = list.getHead();
            int j = 0;
            while (node != null) {
                j++;
                if (list.size() % 2 == 1) {
                    if (j > list.size() / 2) {
                        list.delete(node);
                        break;
                    }
                } else {
                    if (j >= list.size() / 2) {
                        if (node.element.compareTo(node.succ.element) < 0) {
                            list.delete(node);
                            break;
                        } else if (node.element.compareTo(node.succ.element) == 0) {
                            list.delete(node);
                            break;
                        } else {
                            list.delete(node.succ);
                            break;
                        }
                    }


                }
                node = node.succ;
            }
        }
        System.out.println(list);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        SLL<Integer> list = new SLL<>();

        int brElem = Integer.parseInt(br.readLine());
        String line = br.readLine();
        String[] parts = line.split(" ");
        int delMid = Integer.parseInt(br.readLine());

        for (int i = 0; i < brElem; i++) {
            list.insertLast(Integer.parseInt(parts[i]));
        }
        juni(list, delMid);
    }
}
