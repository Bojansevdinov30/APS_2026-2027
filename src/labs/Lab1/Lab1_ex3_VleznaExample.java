package labs.Lab1;

import dataStructures.SLL;
import dataStructures.SLLNode;

import java.util.Scanner;

/*
SLL - Влезна задача
Се внесува број на стрингови, се печати низата пред промени, секој стринг што почнува со мала буква се преместува на крајот од листата,
и па се печате листата
Input
4
ova
Eden
Zdravo
hawaii
Output
ova -> Eden -> Zdravo -> hawaii
Eden -> Zdravo -> ova -> hawaii
*/
public class Lab1_ex3_VleznaExample {

    public static void solution(SLL<String> list) {
        int n = list.size();

        SLLNode<String> curr = list.getHead();

        for (int i = 0; i < n && curr != null; i++) {

            // Save succ BEFORE changing the list
            SLLNode<String> next = curr.getSucc();

            if (Character.isLowerCase(curr.getElement().charAt(0))) {
                list.insertLast(curr.getElement());
                list.delete(curr);
            }

            curr = next;
        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        SLL<String> S = new SLL<>();
        for (int i = 0; i < N; i++) {
            S.insertLast(input.next());
        }

        System.out.println(S.toString());
        solution(S);
        System.out.println(S.toString());

    }
}
