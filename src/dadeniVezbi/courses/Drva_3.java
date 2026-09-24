package dadeniVezbi.courses;

import dataStructures.BNode;
import dataStructures.BinarySearchTree;

import java.util.Scanner;

public class Drva_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int q = sc.nextInt();

        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        sc.nextLine();
        for (int i = 0; i < n + q; i++) {
            String[] line = sc.nextLine().split(" ");
            String command = line[0];
            int nodeId = Integer.parseInt(line[1]);

            if (command.equals("insert")) {
                bst.insert(nodeId);
            } else {
                System.out.println(findDepth(bst.getRoot(), nodeId));
            }
        }
    }

    public static int findDepth(BNode<Integer> node, int nodeId) {
        if (node == null) {
            return 0;
        } else if (node.info == nodeId) {
            return 1;
        } else if (node.info > nodeId) {
            return findDepth(node.left, nodeId) + 1;
        } else {
            return findDepth(node.right, nodeId) + 1;
        }
    }

    public static int findSmaller(BNode<Integer> node, int nodeId) {
        if (node == null) return 0;
        else if (node.info < nodeId) {
            return 1 + findSmaller(node.left, nodeId) + findSmaller(node.right, nodeId);
        } else {
            return findSmaller(node.left, nodeId) + findSmaller(node.right, nodeId);
        }
    }


}
