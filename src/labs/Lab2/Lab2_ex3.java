package labs.Lab2;

import dataStructures.DLL;
import dataStructures.DLLNode;

import java.util.Scanner;

// pomesti gi elementite na niza za k mesta vo desno
public class Lab2_ex3 {
    static void solve(DLL<Integer> dll, int k){
        DLLNode<Integer> tmp = dll.getLast();

        while (k != 0){
            dll.insertFirst(tmp.getElement());
            dll.delete(tmp);
            tmp = tmp.getPred();
            k--;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        DLL<Integer> dll = new DLL<>();
        for (int i = 0; i < n; i++) {
            dll.insertLast(in.nextInt());
        }

        int k = in.nextInt();

        solve(dll,k);

        System.out.println(dll.toString());
    }
}
