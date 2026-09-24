package dadeniVezbi.courses;

import dataStructures.SLLTree;

import java.util.HashMap;
import java.util.Scanner;

public class Drva_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int q = sc.nextInt();

        SLLTree<Integer> tree = new SLLTree<>();
        HashMap<Integer, SLLTree.SLLNode<Integer>> map = new HashMap<>();

        sc.nextLine();
        for (int i = 0; i < n + q; i++) {
            String[] command = sc.nextLine().split(" ");
            if(command[0].equals("root")) {
                int rootId = Integer.parseInt(command[1]);
                tree.makeRoot(rootId);
                map.put(rootId, tree.getRoot());
            } else if (command[0].equals("add")) {
                int parentId = Integer.parseInt(command[1]);
                int childId = Integer.parseInt(command[2]);

                SLLTree.SLLNode<Integer> node = (SLLTree.SLLNode<Integer>) tree.addChild(map.get(parentId), childId);
                map.put(childId, node);
            } else if (command[0].equals("ask")) {
                int parentId = Integer.parseInt(command[1]);
                SLLTree.SLLNode<Integer> node = (SLLTree.SLLNode<Integer>) map.get(parentId);
                System.out.println(countLeaves(node));
            }
        }
    }

    public static int countLeaves(SLLTree.SLLNode<Integer> node) {
        if(node.getFirstChild() == null) {
            return 1;
        }
        SLLTree.SLLNode<Integer> tmp = node.getFirstChild();
        int count = 0;
        while(tmp != null) {
            count += countLeaves(tmp);
            tmp = tmp.getSibling();
        }
        return count;
    }

}
