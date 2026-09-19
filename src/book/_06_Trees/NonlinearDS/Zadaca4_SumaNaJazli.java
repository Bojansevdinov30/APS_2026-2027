package book._06_Trees.NonlinearDS;

import dataStructures.BinaryTree;
import dataStructures.TreeNode;

import static dataStructures.BinaryTreeTest.GetExampleIntTree;

/*Нека е дадено бинарно дрво со цели броеви. Да се напише функциjа коjа што ´ке
го пресмета збирот на елементите од целото дрво.
Влез:
Бинарно дрво од слика 6-11.
Излез:
Sum of all the elements in the tree is: 75*/
public class Zadaca4_SumaNaJazli {
    // Method to calculate the sum of all elements in a binary tree.
    public static int sumBT(TreeNode<Integer> node) {
        // If the current node is null, return 0 (base case).
        if (node == null)
            return 0;

        // Recursively calculate the sum of the current node's data,
        // left subtree, and right subtree, and return the total sum.
        return (node.data + sumBT(node.left) + sumBT(node.right));
    }

    // Method to test the sumBT() method.
    public static void exampleSumBT() {
        // Create an example integer tree and keep a reference in intTree.
        BinaryTree<Integer> intTree = GetExampleIntTree();

        // Calculate the sum of all elements in the tree starting from the root.
        int sum = sumBT(intTree.root);

        // Print the result.
        System.out.println("Sum of all the elements in the tree is: " + sum);
    }

    public static void main(String[] args) {
        //Call the exampleSumBT method
        exampleSumBT();

    }
}
