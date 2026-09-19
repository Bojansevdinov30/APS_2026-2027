package book._06_Trees.NonlinearDS;

import dataStructures.BinaryTree;
import dataStructures.TreeNode;

import java.util.Scanner;

import static dataStructures.BinaryTreeTest.GetExampleIntTree;

/*Нека е дадено бинарно дрво со цели броеви и вредноста на еден jазел во дрвото.
Да се напише функциjа коjа што ´ке го пресмета збирот на елементите во левото
поддрво на дадениот jазел кои се помали од него и функциjа коjа што ´ке го
пресмета збирот на елементите во десното поддрво на дадениот jазел кои се
поголеми од него.
Пример:
Влез:
Бинарно дрво од слика 6-11.
Вредност на jазел: 7
Излез:
The sum of the left subtree is 2
The sum of the right subtree is 11
*/
public class Zadaca5_SumaNaPoddrva {
    public static int sumMinLeftSubtree(TreeNode<Integer> current, int value) {
        // Base case: If the current node is null, return 0.
        if (current == null)
            return 0;
        // recursively summing the values in its subtrees
        int tmp = sumMinLeftSubtree(current.left, value) + sumMinLeftSubtree(current.right, value);
        // Check if the value of the current node is less than the specified 'value'.
        if (current.data < value) {
            // Include the current node's value in the sum and recursively sum
            return tmp + current.data;
        } else {
            // If the current node's value is not less than 'value', just return the subtree's values
            return tmp;
        }

    }

    public static int sumMaxRightSubtree(TreeNode<Integer> current, int value) {
        // Base case: If the current node is null, return 0.
        if (current == null)
            return 0;
        // recursively summing the values in its subtrees
        int tmp = sumMaxRightSubtree(current.left, value) + sumMaxRightSubtree(current.right, value);
        // Check if the value of the current node is greater than the specified 'value'.
        if (current.data > value) {
            // Include the current node's value in the sum and recursively sum
            return current.data + tmp;
        } else {
            // If the current node's value is not less than 'value', just return the subtree 's values
            return tmp;
        }

    }

    // Method to test the exampleSumSubtrees() method.
    public static void exampleSumSubtrees() {
        // Create an example integer tree and keep a reference in intTree.
        BinaryTree<Integer> intTree = GetExampleIntTree();

        // Create a Scanner to get user input.
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter an integer value.
        System.out.print("Enter an integer value to search in the binary tree:");

        // Read the user's input as an integer.
        int value = Integer.parseInt(input.next());

        // Find the node with the entered value in the binary tree.
        TreeNode<Integer> node = intTree.findNode(intTree.root, value);

        // Check if the node exists in the tree.
        if (node != null) {
            // Calculate and display the sum of the left subtree of the found node.
            System.out.println("The sum of the left subtree is " + sumMinLeftSubtree(node.left, value));

            // Calculate and display the sum of the right subtree of the found node.
            System.out.println("The sum of the right subtree is " + sumMaxRightSubtree(node.right, value));

        } else {
            // Display a message indicating that the node with the entered value doesn 't exist in the tree.
            System.out.println("Node with value " + value + " does NOT exist in the given binary tree");

        }

    }


    public static void main(String[] args) {
        //Call the exampleSumSubtrees method
        exampleSumSubtrees();

    }
}
