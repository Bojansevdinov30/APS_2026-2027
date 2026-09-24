package dadeniVezbi.courses;

import dataStructures.BNode;
import dataStructures.BTree;

import java.util.HashMap;
import java.util.Scanner;

public class Drva_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int q = sc.nextInt();

        BTree<String> tree = new BTree<>();
        HashMap<String, BNode<String>> map = new HashMap<>();

        sc.nextLine();
        for (int i = 0; i < n + q; i++) {
            String[] line = sc.nextLine().split(" ");
            if(line[0].equals("root")) {
                String rootId = line[1];
                tree.makeRoot(rootId);
                map.put(rootId, tree.root);
            } else if (line[0].equals("add")) {
                String parentId = line[1];
                String childId = line[2];
                String position = line[3];

                if(position.equals("LEFT")) {
                    BNode<String> node = tree.addChild(map.get(parentId), 1, childId);
                    map.put(childId, node);
                } else {
                    BNode<String> node = tree.addChild(map.get(parentId), 2, childId);
                    map.put(childId, node);
                }
            } else {
                String parentId = line[1];
                BNode<String> node = map.get(parentId);
                System.out.println(insideNodes(node));
            }
        }
    }

    public static int insideNodes(BNode<String> node) {
        if(node == null) {
            return 0;
        }
        if(node.left == null && node.right == null) {
            return 0;
        }
        return insideNodes(node.left) + insideNodes(node.right) + 1;
    }

    public static int sumOfDegrees(BNode<String> node) {
        if(node == null) return 0;
        return 1 + sumOfDegrees(node.left) + sumOfDegrees(node.right);
    }

}
