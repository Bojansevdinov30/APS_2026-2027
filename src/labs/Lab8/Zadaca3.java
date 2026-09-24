package labs.Lab8;

import dataStructures.BinarySearchTree;

import java.util.Scanner;

// najdi pogolemi od daden broj vo drvo
public class Zadaca3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int q = sc.nextInt();

        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        for (int i = 0; i < n + q; i++) {
            String command = sc.next();
            if (command.equals("insert")) {
                int childId = sc.nextInt();
                bst.insert(childId);
            } else if (command.equals("ask")) {
                int childId = sc.nextInt();
                System.out.println(bst.findHigher(bst.getRoot(), childId));
            }
        }

    }
}
