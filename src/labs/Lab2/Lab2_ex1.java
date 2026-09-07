package labs.Lab2;

import dataStructures.DLL;
import dataStructures.DLLNode;

import java.util.Scanner;
// vo DLL odime napred i nazad od sekoj element, gledame vo prosek cij zbir e pogolem, ako e toa na levata strana
// togas res++, odnosno broime kolku broevi imaat prosecno pogolema leva strana otkolku desna
public class Lab2_ex1 {
    static int solve(DLL<Integer> list){
        if (list.getFirst() == null || list.getFirst().getSucc() == null) return 0;
        DLLNode<Integer> tmp = list.getFirst().getSucc();
        DLLNode<Integer> prev = list.getFirst();
        DLLNode<Integer> after = list.getFirst().getSucc();

        int sum1,sum2;
        int ctr1, ctr2;
        int res = 0;

        while (tmp != null && tmp.getSucc() != null){
            sum1 = sum2 = 0;
            ctr1 = ctr2 = 0;
            prev = tmp.getPred();
            after = tmp.getSucc();
            while (prev != null) {
                sum1 += prev.getElement();
                ctr1++;
                prev = prev.getPred();
            }
            while (after != null){
                sum2 += after.getElement();
                ctr2++;
                after = after.getSucc();
            }
            if ((float)sum1 / ctr1 > (float)sum2 / ctr2) res++;
            tmp = tmp.getSucc();
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        DLL<Integer> list = new DLL<>();
        for (int i = 0; i < n; i++) {
            list.insertLast(in.nextInt());
        }
        System.out.println(solve(list));
    }
}
