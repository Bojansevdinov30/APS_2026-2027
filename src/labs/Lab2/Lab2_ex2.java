package labs.Lab2;

import dataStructures.DLL;
import dataStructures.DLLNode;

import java.util.Scanner;
// pomesti gi elementite vo DLL lista za K mesta vo levo
public class Lab2_ex2 {
    static void solve(DLL<Integer> dll, int k){
        DLLNode<Integer> tmp = dll.getFirst();
        while (k != 0){
            dll.insertLast(tmp.getElement());
            dll.delete(tmp);
            tmp = tmp.getSucc();
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
