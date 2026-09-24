package dadeniVezbi.courses;

import dataStructures.DLL;
import dataStructures.DLLNode;

import java.util.Scanner;

public class ZadacaZaPrvKol_3 {
    public static long findMagicNumber(DLL<DLL<Integer>> list) {
        long product = 1;
        DLLNode<DLL<Integer>> curr = list.getFirst();

        while (curr != null) {
            DLLNode<Integer> subListCurr = curr.getElement().getFirst();
            int sum = 0;
            while(subListCurr != null) {
                sum += subListCurr.getElement();
                subListCurr = subListCurr.getSucc();
            }
            product *= sum;
            curr = curr.getSucc();
        }

        return product;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DLL<DLL<Integer>> list = new DLL<>();

        int n = sc.nextInt();
        int m = sc.nextInt();

        for (int i = 0; i < n; i++) {
            DLL<Integer> subList = new DLL<>();
            for (int j = 0; j < m; j++) {
                subList.insertLast(sc.nextInt());
            }
            list.insertLast(subList);
        }

        System.out.println(findMagicNumber(list));
    }

}
