package book._06_Trees.SearchTrees;

import dataStructures.BinarySearchTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static book._06_Trees.SearchTrees.Zadaca1_BalansiranoDrvo.GetExampleBSTree;/*Да се напише функциjа коjа ´ке го наjде k-от наjмал/наjголем елемент во бинарно
пребарувачко дрво. Вредноста за k се внесува од тастатура.
Пример:
Влез:
Бинарно дрво од слика 6-39
Вредност за k: 4
Излез:
The 4-th smallest element in BST is 5
The 4-th biggest element in BST is 8*/

public class Zadaca2_KtiNajmalNajgolemElement {
    // Create an example integer binary search tree (BST) and keep a reference in intTree.
    public static void exampleKthSmallest() {
        BinarySearchTree<Integer> intTree = GetExampleBSTree();

        // Create a Scanner to get user input.
        Scanner input = new Scanner(System.in);

        // Read the user's input as an integer 'k' to find the kth smallest and kth largest elements.
        int k = Integer.parseInt(input.next());

        // Create a dynamic array to store the elements of the BST in sorted order.
        List<Integer> sortedInorder = new ArrayList<Integer>();

        // Perform an inorder traversal of the BST to populate 'sortedInorder' with sorted elements.
        intTree.inorder(sortedInorder);

        // Calculate the size of the 'sortedInorder' array.
        int len = sortedInorder.size();

        // Check if 'k' is within a valid range (1 <= k <= len).
        if (k > 0 && k <= len) {
            // Print the kth smallest and kth largest elements in the BST.
            System.out.println("The " + k + "th smallest element in BST is "
                    + sortedInorder.get(k - 1));
            System.out.println("The " + k + "th biggest element in BST is "
                    + sortedInorder.get(len - k));
        }
    }


    public static void main(String[] args) {
        //Call the exampleKthSmallest method
        exampleKthSmallest();
    }
}
