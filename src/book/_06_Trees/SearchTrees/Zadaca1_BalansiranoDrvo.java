package book._06_Trees.SearchTrees;

import dataStructures.BinarySearchTree;

/*Да се имплементира функциjа коjа ´ке проверува дали дадено бинарно пребару-
вачко дрво е балансирано или не.
Пример:
Влез:
Бинарно дрво од слика 6-39
Излез:
The given binary search tree is also balanced.*/
public class Zadaca1_BalansiranoDrvo {
    // gi imas metodite vo BinarySearchTree
    // This method serves as an example for testing the 'isBalanced' method on a binary search tree (BST).
    public static void exampleIsBalanced() {
        // Create an example integer binary search tree (BST) and keep a reference in intTree.
        BinarySearchTree<Integer> intTree = GetExampleBSTree();

        // Print the contents of the binary search tree (BST).
        intTree.print();

        // Check if the binary search tree (BST) is balanced using the 'isBalanced' method.
        if (intTree.isBalanced(intTree.getRoot())) {
            System.out.println("The given binary search tree is also balanced.");
        } else {
            System.out.println("The given binary search tree is NOT balanced.");
        }
    }

    public static BinarySearchTree<Integer> GetExampleBSTree() {
        System.out.println("Temp example");
        return new BinarySearchTree<>();
    }

    public static void main(String[] args) {
        //Call the exampleIsBalanced method
        exampleIsBalanced();
    }
}
