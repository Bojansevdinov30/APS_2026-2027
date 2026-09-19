package dataStructures;

public class BinaryTreeTest {

    // Method to create an example integer-based binary tree.
    public static BinaryTree<Integer> GetExampleIntTree() {
        // Declare temporary TreeNode variables.
        TreeNode<Integer> tmp1, tmp2, tmp3;

        // Create a new BinaryTree of Integer type.
        BinaryTree<Integer> intTree = new BinaryTree<>();

        // Make the root of the tree with the value 1.
        intTree.makeRoot(1);

        // Add 7 as the left child of the root and keep a reference to this new node in tmp1.
        tmp1 = intTree.addLeftChild(7, intTree.root);

        // Add 2 as the left child of node 7 (tmp1) and keep a reference in tmp2.
        tmp2 = intTree.addLeftChild(2, tmp1);

        // Add 6 as the right child of node 7 (tmp1) and update the reference in tmp2.
        tmp2 = intTree.addRightChild(6, tmp1);

        // Add 5 as the left child of node 6 (tmp2) and keep a reference in tmp3.
        tmp3 = intTree.addLeftChild(5, tmp2);

        // Add 11 as the right child of node 6 (tmp2) and update the reference in tmp3.
        tmp3 = intTree.addRightChild(11, tmp2);

        // Add 9 as the right child of the root and keep a reference in tmp1.

        tmp1 = intTree.addRightChild(9, intTree.root);

        // Add 19 as the right child of node 9 (tmp1) and keep a reference in tmp2.
        tmp2 = intTree.addRightChild(19, tmp1);

        // Add 15 as the left child of node 19 (tmp2).
        tmp3 = intTree.addLeftChild(15, tmp2);

        // Return the example integer tree.
        return intTree;
    }


    // Main method to test the BinaryTree class.
    public static void main(String[] args) {
        // Create an example integer tree and keep a reference in intTree.
        BinaryTree<Integer> intTree = GetExampleIntTree();

        // Perform and print inorder, preorder, and postorder traversals of intTree.
        intTree.inorder();
        intTree.preorder();
        intTree.postorder();

        // Print the string representation of intTree.
        System.out.print(intTree);
    }
}
