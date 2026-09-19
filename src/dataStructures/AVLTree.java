package dataStructures;

// Define an AVLTree class, which extends the BinarySearchTree class.
// This class takes a generic type T that extends Comparable interface, meaning T can be compared.
class AVLTree<T extends Comparable<T>> extends BinarySearchTree<T> {

    // Function to get the height of a node.
    // If the node is null, its height is 0.
    int height(AVLNode<T> node) {
        return (node == null) ? 0 : node.height;
    }

    // Function to insert a new node while keeping the tree balanced.
    public AVLNode<T> insert(AVLNode<T> node, T data) {
        // Standard BST insert operation.
        if (node == null) {
            return new AVLNode<T>(data);
        }

        // Insert in the left or right subtree based on the value of 'data'.
        if (data.compareTo(node.data) < 0) {
            // Type-casting is needed because node.left is of type BinaryNode,
            // but we know it is actually AVLNode in this context.
            node.left = insert((AVLNode<T>) node.left, data);
        } else if (data.compareTo(node.data) > 0) {
            node.right = insert((AVLNode<T>) node.right, data);
        } else {
            return node; // Duplicates not allowed
        }

        // Update the height of the current node.
        node.height = 1 + Math.max(height((AVLNode<T>) node.left), height((AVLNode<T>) node.right));

        // Compute the balance factor to check for imbalance.
        int balance = height((AVLNode<T>) node.left) - height((AVLNode<T>) node.right);

        // If left subtree is heavier
        if (balance > 1) {
            // If the data belongs to the left of left child, it's a straight left-left case.
            if (data.compareTo(node.left.data) < 0) {
                return rotateRight(node); // Single right rotation
            } else {
                // This is a left-right case.
                node.left = rotateLeft((AVLNode<T>) node.left); // First rotate the left child
                return rotateRight(node); // Then rotate the unbalanced node
            }
        }

        // If right subtree is heavier
        if (balance < -1) {
            // If the data belongs to the right of right child, it's a straight right-right case.
            if (data.compareTo(node.right.data) > 0) {
                return rotateLeft(node); // Single left rotation
            } else {
                // This is a right-left case.
                node.right = rotateRight((AVLNode<T>) node.right); // First rotate the right child
                return rotateLeft(node); // Then rotate the unbalanced node
            }
        }

        return node; // Return the (now balanced) node pointer
    }

    // Function to perform right rotation
    // It handles the rotation and also updates the height.
    private AVLNode<T> rotateRight(AVLNode<T> y) {
        AVLNode<T> x = (AVLNode<T>) y.left;
        AVLNode<T> T2 = (AVLNode<T>) x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = Math.max(height((AVLNode<T>) y.left), height((AVLNode<T>) y.right)) + 1;
        x.height = Math.max(height((AVLNode<T>) x.left), height((AVLNode<T>) x.right)) + 1;

        // Return new root
        return x;
    }

    // Function to perform left rotation
    // It handles the rotation and also updates the height.
    private AVLNode<T> rotateLeft(AVLNode<T> x) {
        AVLNode<T> y = (AVLNode<T>) x.right;
        AVLNode<T> T2 = (AVLNode<T>) y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        // Update heights
        x.height = Math.max(height((AVLNode<T>) x.left), height((AVLNode<T>) x.right)) + 1;
        y.height = Math.max(height((AVLNode<T>) y.left), height((AVLNode<T>) y.right)) + 1;

        // Return new root
        return y;
    }

    public int getBalance(AVLNode<T> node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = height((AVLNode<T>) node.left);
        int rightHeight = height((AVLNode<T>) node.right);

        return leftHeight - rightHeight;
    }
}
