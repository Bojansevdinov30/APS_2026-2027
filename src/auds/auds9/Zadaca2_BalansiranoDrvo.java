package auds.auds9;

import dataStructures.BNode;
import dataStructures.BinarySearchTree;

import java.util.Scanner;

/*Да се имплементира функција која ќе
проверува дали бинарно пребарувачко дрво
од цели броеви е балансирано или не.
Влез:
N - Бројот на елементи во бинарното дрво
a1 a2 … aN - Елементите во бинарното дрво, во еден
ред одвоени со празно место*/
public class Zadaca2_BalansiranoDrvo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for (int i = 0; i < n; i++) bst.insert(sc.nextInt());
        if (isBalanced(bst)) System.out.println("YES");
        else System.out.println("NO");
    }

    private static boolean isBalanced(BinarySearchTree<Integer> bst) {
        return isBalancedSubtree(bst.getRoot());
    }

    private static boolean isBalancedSubtree(BNode<Integer> node) {
        if (node == null) return true;
        int leftHeight = subtreeHeight(node.left);
        int rightHeight = subtreeHeight(node.right);
        return Math.abs(leftHeight - rightHeight) <= 1 && isBalancedSubtree(node.left) && isBalancedSubtree(node.right);
    }

    private static int subtreeHeight(BNode<Integer> node) {
        if (node == null) return 0;
        return 1 + Math.max(subtreeHeight(node.left), subtreeHeight(node.right));
    }
}
