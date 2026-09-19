package book._06_Trees.SearchTrees;

import dataStructures.BNode;
import dataStructures.BinarySearchTree;

/*За дадено бинарно пребарувачко дрво да се напише функциjа коjа ´ке направи
бришење на сите терминирачки jазли - листови од дрвото*/
public class Zadaca6_BrisenjeListovi {
    public static BNode<Integer> removeLeaves(BNode<Integer> node) {

        if (node == null) {
            return null;
        }

        if (node.left == null && node.right == null) {
            return null;
        }

        node.left = removeLeaves(node.left);
        node.right = removeLeaves(node.right);

        return node;
    }

    public static void main(String[] args) {

        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(2);
        tree.insert(7);

        tree.setRoot(removeLeaves(tree.getRoot()));
    }
}
