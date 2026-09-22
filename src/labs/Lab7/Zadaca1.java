package labs.Lab7;

import java.util.Scanner;

public class Zadaca1 {

    static class Node {
        int value;
        Node left, right;

        Node(int value) {
            this.value = value;
        }
    }

    // insert во BST
    static Node insert(Node root, int value) {
        if (root == null) return new Node(value);
        if (value < root.value)
            root.left = insert(root.left, value);
        else
            root.right = insert(root.right, value);
        return root;
    }

    // 1️⃣ Наоѓање на LCA (најмало поддрво што ги содржи P и Q)
    static Node findLCA(Node root, int P, int Q) {
        if (root == null) return null;

        if (P < root.value && Q < root.value)
            return findLCA(root.left, P, Q);
        if (P > root.value && Q > root.value)
            return findLCA(root.right, P, Q);

        return root; // тука се раздвојуваат
    }

    static int sum = 0;
    static int count = 0;

    // 2️⃣ Собирање на K најголеми елементи
    static void sumKLargest(Node node, int K) {
        if (node == null || count >= K) return;

        sumKLargest(node.right, K);

        if (count < K) {
            sum += node.value;
            count++;
        }

        sumKLargest(node.left, K);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Node root = null;

        for (int i = 0; i < N; i++) {
            root = insert(root, sc.nextInt());
        }

        int P = sc.nextInt();
        int Q = sc.nextInt();
        int K = sc.nextInt();

        Node subtreeRoot = findLCA(root, P, Q);

        sum = 0;
        count = 0;
        sumKLargest(subtreeRoot, K);

        System.out.println(sum);
    }

}
