package dadeniVezbi.courses;

import dataStructures.BinarySearchTree;

import java.util.Scanner;

public class ZadacaZaIspit_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        sc.nextLine();
        for(int i = 0; i < n; i++) {
            bst.insert(sc.nextInt());
        }

        sortedBST(bst, n);
    }

    public static void sortedBST(BinarySearchTree<Integer> bst, int n) {
        for(int i = 0; i < n; i++) {
            int min = bst.findMin();
            System.out.println(min);
            bst.remove(min);
        }
    }

}
