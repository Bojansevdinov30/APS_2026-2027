package PrethodniIspitni._2024;

import dataStructures.SLL;
import dataStructures.SLLNode;

import java.io.*;

/*Да се бришат елементи од дадена СЛЛ листа се додека има .. појасно тест пример. Првен еден елемент се печате еден се брише па
2 се печатат па 1 се брише па 3 се печатат ...

Sample input:
1 2 3 4 5 6 7 8 9

Sample output:
1->3->4->6->7->8->*/
public class RandomZadaca2_brisenjePattern {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        SLL<Integer> list = new SLL<>();

        String line = br.readLine();
        String[] parts = line.split(" ");
        for (int i = 0; i < parts.length; i++) {
            list.insertLast(Integer.parseInt(parts[i]));
        }

        SLLNode<Integer> node = list.getHead();

        int brojac = 1;
        while (node.getSucc() != null) {
            list.delete(node.getSucc());
            for (int i = 0; i <= brojac; i++) {
                if (node.getSucc() != null) node = node.getSucc();
                else break;
            }
            brojac++;
        }

        System.out.println(list.toString());
    }

}
