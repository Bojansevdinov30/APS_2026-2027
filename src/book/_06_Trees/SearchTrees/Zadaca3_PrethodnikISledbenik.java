package book._06_Trees.SearchTrees;

import dataStructures.BNode;
import dataStructures.BinarySearchTree;
import dataStructures.TreeNode;

import java.util.Scanner;

import static book._06_Trees.SearchTrees.Zadaca1_BalansiranoDrvo.GetExampleBSTree;

/*Да се напише функциjа коjа ´ке го наjде претходникот и следбеникот на даден jа-
зел при inorder изминување на бинарно пребарувачко дрво. Вредноста на jазелот
се внесува од тастатура.
Пример:
Влез:
Бинарно дрво од слика 6-39
Вредност за jазел: 3
Излез:
The inorder predecessor for 3 is 2
The inorder successor for 3 is 5*/
public class Zadaca3_PrethodnikISledbenik {

    // Initialize the predecessor and successor nodes as global with null values.
    static BNode<Integer> pred = new BNode<>(null);
    static BNode<Integer> succ = new BNode<>(null);

    // This function finds the inorder predecessor and successor nodes of a given 'key' in a BST.
    static void findPredSucc(BNode<Integer> node, int key) {
        // Base case: If the current node is null, return.
        if (node == null) {
            return;
        }
        // If the current node's data matches the 'key', we've found the node.
        if (node.info == key) {
            // If the node has a left subtree, find the predecessor.
            if (node.left != null) {
                BNode<Integer> tmp = node.left;
                while (tmp.right != null)
                    tmp = tmp.right;
                pred = tmp;
            }

            // If the node has a right subtree, find the successor.
            if (node.right != null) {
                BNode<Integer> tmp = node.right;
                while (tmp.left != null)
                    tmp = tmp.left;

                succ = tmp;
            }
            return;
        }

        // If 'key' is smaller than the current node's data, search in the left subtree.
        if (node.info > key) {
            succ = node; // Update the successor.
            findPredSucc(node.left, key);
        }

        // If 'key' is larger than the current node's data, search in the right subtree.
        else {
            pred = node; // Update the predecessor.
            findPredSucc(node.right, key);
        }
    }

    // This method serves as an example for finding the inorder predecessor  and successor of a key in a binary search tree (BST).
    public static void exampleInorderPredSucc() {
        // Create an example integer binary search tree (BST) and keep a reference in intTree.
        BinarySearchTree<Integer> intTree = GetExampleBSTree();

        // Create a Scanner to get user input.
        Scanner input = new Scanner(System.in);

        // Read the user's input as an integer 'key'.
        int key = Integer.parseInt(input.next());
        // Find the inorder predecessor and successor for the 'key' in the BST.
        findPredSucc(intTree.getRoot(), key);

        // Print the inorder predecessor if it exists.
        if (pred != null) {
            System.out.println("Inorder predecessor for " + key + " is " + pred.info);
        }

        // Print the inorder successor if it exists.
        if (succ != null) {
            System.out.println("Inorder successor for " + key + " is " + succ.info);
        }
    }


    public static void main(String[] args) {
        //Call the exampleInorderPredSucc method
        exampleInorderPredSucc();
    }

}
