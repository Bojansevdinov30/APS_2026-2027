package auds.auds9;

import dataStructures.BNode;
import dataStructures.BinarySearchTree;

import java.util.Scanner;

/*Да се напише функциjа коjа ќе го наjде
претходникот и следбеникот на дадена вредност
при inorder изминување на бинарно
пребарувачко дрво. Вредноста се внесува од
тастатура.
Влез:
N - Бројот на елементи во бинарното дрво
a1 a2 … aN - Елементите во бинарното дрво, во еден
ред одвоени со празно место
Т - Елементот чиј што претходник и следбеник
треба да бидат пронајдени*/
public class Zadaca4_PrethodnikISledbenik {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for (int i = 0; i < n; i++) bst.insert(sc.nextInt());
        int t = sc.nextInt();
        System.out.println("Before " + smaller(bst, t));
        System.out.println("After " + greater(bst, t));
    }

    private static int smaller(BinarySearchTree<Integer> bst, int t) {
        if (subtreeMin(bst.getRoot()) == t) return -1;
        return smallerRecursive(bst.getRoot(), t);
    }

    private static int greater(BinarySearchTree<Integer> bst, int t) {
        if (subtreeMax(bst.getRoot()) == t) return -1;
        return greaterRecursive(bst.getRoot(), t);
    }

    private static int smallerRecursive(BNode<Integer> node, int t) {
        if (node.info > t) return smallerRecursive(node.left, t);
        if (node.info == t) return subtreeMax(node.left);
        if (subtreeMin(node.right) == t) return node.info;
        return smallerRecursive(node.right, t);
    }

    private static int greaterRecursive(BNode<Integer> node, int t) {
        if (node.info < t) return greaterRecursive(node.right, t);
        if (node.info == t) return subtreeMin(node.right);
        if (subtreeMax(node.left) == t) return node.info;
        return greaterRecursive(node.left, t);
    }

    private static int subtreeMin(BNode<Integer> node) {
        while (node.left != null) node = node.left;
        return node.info;
    }

    private static int subtreeMax(BNode<Integer> node) {
        while (node.right != null) node = node.right;
        return node.info;
    }
}
