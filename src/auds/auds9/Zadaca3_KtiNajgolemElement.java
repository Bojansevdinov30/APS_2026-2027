package auds.auds9;

import dataStructures.BNode;
import dataStructures.BinarySearchTree;

import java.util.Scanner;

/*Да се имплементира функција која ќе најде
кој е К-тиот најголем елемент во бинарно
пребарувачко дрво од цели броеви.
Влез:
N K - Бројот на елементи во бинарното дрво и
бараниот реден број
a1 a2 … aN - Елементите во бинарното дрво, во еден
ред одвоени со празно место*/
public class Zadaca3_KtiNajgolemElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for (int i = 0; i < n; i++) bst.insert(sc.nextInt());
        System.out.println(k + "`th largest is " + kthLargest(bst, k));
    }

    private static int kthLargest(BinarySearchTree<Integer> bst, int k) {
        return kthLargestInSubtree(bst.getRoot(), k);
    }

    private static int kthLargestInSubtree(BNode<Integer> node, int k) {
        int rightSubtreeSize = subtreeSize(node.right);
        if (rightSubtreeSize >= k) return kthLargestInSubtree(node.right, k);
        else if (rightSubtreeSize + 1 == k) return node.info;
        return kthLargestInSubtree(node.left, k - rightSubtreeSize - 1);
    }

    private static int subtreeSize(BNode<Integer> node) {
        if (node == null) return 0;
        return 1 + subtreeSize(node.left) + subtreeSize(node.right);
    }
}
/*private static int count = 0;
private static Integer result = null;

private static void kthLargest(BNode<Integer> node, int k) {
    if (node == null || result != null) {
        return;
    }

    kthLargest(node.right, k);

    count++;

    if (count == k) {
        result = node.info;
        return;
    }

    kthLargest(node.left, k);
}*/
