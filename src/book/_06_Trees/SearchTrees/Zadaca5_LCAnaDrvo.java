package book._06_Trees.SearchTrees;

import dataStructures.BNode;
import dataStructures.BinarySearchTree;

/*За дадено бинарно пребарувачко дрво да се напише функциjа коjа ´ке го наjде
соодветниот наjдолен заеднички предок (lowest common ancestor - LCA) во дрво-
то.*/
public class Zadaca5_LCAnaDrvo {
    public static BNode<Integer> lca(BNode<Integer> node, int a, int b) {

        if (node == null) {
            return null;
        }

        // И двете вредности се помали -> оди лево
        if (a < node.info && b < node.info) {
            return lca(node.left, a, b);
        }

        // И двете вредности се поголеми -> оди десно
        if (a > node.info && b > node.info) {
            return lca(node.right, a, b);
        }

        // Инаку се разделуваат тука
        return node;
    }

    public static void main(String[] args) {

        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        tree.insert(20);
        tree.insert(10);
        tree.insert(30);
        tree.insert(5);
        tree.insert(15);
        tree.insert(25);
        tree.insert(40);

        BNode<Integer> result = lca(tree.getRoot(), 5, 15);

        if (result != null) {
            System.out.println(result.info);
        }
    }
}
