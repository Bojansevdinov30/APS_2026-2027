package dataStructures;

// Define a generic class called TreeNode. It holds data of a type that implements Comparable.
public class TreeNode<T extends Comparable<T>> {

    // Declare a public variable 'data' to hold the node's data.
    public T data;

    // Declare pointers for the left and right children of the TreeNode.
    public TreeNode<T> left;
    public TreeNode<T> right;

    // Constructor for initializing the TreeNode with data.
    public TreeNode(T data) {
        // Store the given data in this node.

        this.data = data;

        // Initialize the left and right children to null.
        left = null;
        right = null;
    }

    // Override the toString method to convert the TreeNode into a String representation.
    @Override
    public String toString() {
        // Use a StringBuilder to build the output string.
        StringBuilder sb = new StringBuilder();

        // Call the helper function to build the output string.
        toStringHelper(sb, this, 0, 7);

        // Convert the StringBuilder to String and return it.
        return sb.toString();
    }

    // Helper function that builds the output recursively
    private void toStringHelper(StringBuilder sb, TreeNode<T> node, int
            space, int count) {

        if (node == null)
            return;

        // to increase the distance between levels
        space += count;

        // print the right child first
        toStringHelper(sb, node.right, space, count);

        // print the current node after adding the spaces
        sb.append("\n");
        for (int i = count; i < space; i++)
            sb.append(" ");
        sb.append(node.data + "\n");

        //print the left child

        toStringHelper(sb, node.left, space, count);
    }
}