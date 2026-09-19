package book._06_Trees.NonlinearDS;

import dataStructures.BinaryTree;

import java.util.Scanner;

import static dataStructures.BinaryTreeTest.GetExampleIntTree;

/*За дадено бинарното дрво и jазел за коj се вчитува податочниот елемент од
тастатура, да се провери дали вредноста на jазелот постои во бинарното дрво.
Влез:
Бинарно дрво од слика 6-11.
Вредност на jазел: 6
Излез:
Node with value 6 exists in the given binary tree
*/
public class Zadaca2_DaliPostoiJazol {
    // method to test findNode()
    public static void exampleFindNode() {
        // Create an example integer tree and keep a reference in intTree.
        BinaryTree<Integer> intTree = GetExampleIntTree();

        // Create a Scanner to get user input.
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter an integer value.
        System.out.print("Enter an integer value to search in the binary tree: ");

        // Read the user's input as an integer.
        int value = Integer.parseInt(input.next());

        // Call the findNode method to check if the value exists in the binary tree.
        intTree.findNode(value);
    }

    public static void main(String[] args) {
        //Call the exampleFindNode method
        exampleFindNode();

    }
}
