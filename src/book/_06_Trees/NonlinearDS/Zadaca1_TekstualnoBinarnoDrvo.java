package book._06_Trees.NonlinearDS;

import dataStructures.BinaryTree;
import dataStructures.TreeNode;

/*За дадено бинарно дрво, да се напише функциjа коjа ´ке го креира, така што еле-
менти на неговите jазли ´ке бидат текстуални низи. Потоа да се прикаже неговото
изминување во инордер и истото да се испечати.
Влез:
Бинарно дрво од слика 6-12.
orange
banana
lemon
apple
pear
Излез:
Inorder traversal:
peach pear apple lemon banana orange*/
public class Zadaca1_TekstualnoBinarnoDrvo {
    // Method to create an example string-based binary tree.
    public static BinaryTree<String> GetExampleStringTree() {
        // Create a new BinaryTree of String type.
        BinaryTree<String> stringTree = new BinaryTree<>();

        // Set "apple" as the root of the tree.
        stringTree.makeRoot("apple");

        // Add "pear" as the left child of the root node.
        TreeNode<String> node1 = stringTree.addLeftChild("pear", stringTree.root); // root

        // Add "peach" as the left child of the "pear" node.
        TreeNode<String> node2 = stringTree.addLeftChild("peach", node1);
        // Add "banana" as the right child of the root node.
        TreeNode<String> node3 = stringTree.addRightChild("banana", stringTree.root);

        // Add "orange" as the right child of the "banana" node.
        node2 = stringTree.addRightChild("orange", node3);

        // Add "lemon" as the left child of the "banana" node.
        node2 = stringTree.addLeftChild("lemon", node3);

        // Return the example string tree.
        return stringTree;
    }

    // Main method to test the BinaryTree class.
    public static void main(String[] args) {
        // Create an example of string tree and keep a reference in strTree.
        BinaryTree<String> strTree = GetExampleStringTree();

        // Perform and print inorder of the tree
        strTree.inorder();

        // Print the string representation of the tree.
        strTree.print();
    }
}
