package book._06_Trees.NonlinearDS;

import dataStructures.BinaryTree;

import java.util.Scanner;

import static dataStructures.BinaryTreeTest.GetExampleIntTree;

/*Нека е дадено бинарно дрво со цели броеви. Да се напише функциjа коjа што ´ке
го пресмета растоjанието поме´гу два jазли. Вредностите на jазлите за кои треба
да се пресмета растоjанието се соодветно дадени.
Пример:
Влез:
Бинарно дрво од слика 6-11
Вредноста на првиот jазел: 7
Вредноста на вториот jазел: 15
Излез:
Dist(7, 15) = 4*/
public class Zadaca6_RastojanieMegjuJazli {
    // Method to test the getDist() method.
    public static void exampleGetDist() {
        // Create an example integer tree and keep a reference in intTree.
        BinaryTree<Integer> intTree = GetExampleIntTree();
        // Create a Scanner to get user input.
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter two integer values to find their distance in the binary tree.
        System.out.print("Enter two integer values to get their distance in the binary tree: ");

        // Read the user's input as two integers.
        int value1 = Integer.parseInt(input.next());
        int value2 = Integer.parseInt(input.next());

        // Call the getDist method to find the distance between the two values in the binary tree.
        int dist = intTree.getDist(value1, value2);

        // Check if the distance is not 0, indicating both values were found in the tree.
        if (dist != 0) {
            System.out.println("Dist(" + value1 + ", " + value2 + ") = " + dist);
        } else {
            // Display a message indicating that one or both of the values are not present in the tree.
            System.out.println("Some of the values are not present in the tree");
        }
    }

    public static void main(String[] args) {
        //Call the exampleGetDist method
        exampleGetDist();
    }
}
