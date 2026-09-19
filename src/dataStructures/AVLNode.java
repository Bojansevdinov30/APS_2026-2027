package dataStructures;

// Define an AVLNode class, extending TreeNode
public class AVLNode<T extends Comparable<T>> extends TreeNode<T> {
    int height; // Additional field for AVLNode

    public AVLNode(T data) {
        super(data);
        height = 1; // Initialize height as 1
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
