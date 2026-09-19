package book._06_Trees.NonlinearDS;

import dataStructures.BinaryTree;

import java.util.Scanner;

import static dataStructures.BinaryTreeTest.GetExampleIntTree;

/*Да се напише функциjа коjа што го вра´ка нивото на соодветен jазел во дрвото
(сметаj´ки дека коренот се нао´га на ниво 1) или 0 ако не постои во дрвото. Потоа,
да се тестира истата за бинарното дрво на слика 6-11, и jазол за коj се вчитува
податочниот елемент од тастатура.
Влез:
Бинарно дрво од слика 6-11.
Вредност на jазел: 6
Излез:
Level of 6 is 3*/
public class Zadaca3_NivoNaJazol {
    // Method to test the getLevel() method.
    public static void exampleGetLevel() {
        // Create an example integer tree and keep a reference in intTree.
        BinaryTree<Integer> intTree = GetExampleIntTree();

        // Create a Scanner to get user input.
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter an integer value.
        System.out.print("Enter an integer value to get its level in the binary tree: ");

        // Read the user's input as an integer.

        int value = Integer.parseInt(input.next());

        // Call the getLevel method to find the level of the node in the binary tree.
        int level = intTree.getLevel(value);

        // Check if the level is not 0
        if (level != 0) {
            System.out.println("Level of " + value + " is " + level);
        } else {
            System.out.println(value + " is not present in the tree");
        }
    }

    public static void main(String[] args) {
        //Call the exampleGetLevel method
        exampleGetLevel();
    }
}
