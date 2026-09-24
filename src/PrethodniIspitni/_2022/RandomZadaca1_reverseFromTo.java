package PrethodniIspitni._2022;

import dataStructures.SLL;
import dataStructures.SLLNode;

import java.io.*;

/*
Sample input:
1 2 3 4 5 6
1
4

Sample output:
1->5->4->3->2->6
*/
public class RandomZadaca1_reverseFromTo {

    private static SLL<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        SLL<Integer> list = new SLL<>();
        String[] parts = br.readLine().split(" ");
        for (String part : parts) {
            list.insertLast(Integer.parseInt(part));
        }
        int fromIndex = Integer.parseInt(br.readLine());
        int toIndex = Integer.parseInt(br.readLine());
        while (fromIndex < toIndex) {
            SLLNode<Integer> from = list.getHead();
            SLLNode<Integer> to = list.getHead();
            for (int i = 0; i < fromIndex; i++) {
                from = from.getSucc();
            }
            for (int i = 0; i < toIndex; i++) {
                to = to.getSucc();
            }
            int temp = from.getElement();
            from.element = to.getElement();
            to.element = temp;
            fromIndex++;
            toIndex--;
        }
        System.out.println(list);
    }
}
