package dataStructures;

// Define a generic class BinaryTree with elements of type T, where T extends Comparable.
public class BinaryTree<T extends Comparable<T>> {
    // prebaruvanje e O(n)
    // vmetnuvanje e O(n)
    // brisenje e O(n)
    // Declare the root node of the binary tree.
    public TreeNode<T> root;

    // Default constructor to initialize the binary tree with a null root.
    public BinaryTree() {
        root = null;
    }

    // Function to add a left child node with the data 'x' to a given parent node 'parent'.
    public TreeNode<T> addLeftChild(T x, TreeNode<T> parent) {
        // O(n) complexity
        // Create a new node with the data 'x'.
        TreeNode<T> newNode = new TreeNode<>(x);

        // If the parent node is null, the tree is empty. Make the new node the root.
        if (parent == null) {
            this.root = newNode;
            System.out.println("Added " + x + " as the root.");
        } else {
            // Otherwise, add the new node as the left child of the parent.
            // First, link any existing left child of the parent to the new node.
            newNode.left = parent.left;

            // Now, link the new node to the parent as its left child.
            parent.left = newNode;
            System.out.println("Added " + x + " as the left child of " + parent.data);
        }
        return newNode;
    }

    // Function to add a right child node with the data 'x' to a given parent node 'parent'.
    public TreeNode<T> addRightChild(T x, TreeNode<T> parent) {
        // O(n) complexity
        // Create a new node with the data 'x'.
        TreeNode<T> newNode = new TreeNode<>(x);

        // If the parent node is null, the tree is empty. Make the new node the root.
        if (parent == null) {
            this.root = newNode;
            System.out.println("Added " + x + " as the root.");
        } else {
            // Otherwise, add the new node as the right child of the parent.
            // First, link any existing right child of the parent to the new node.
            newNode.right = parent.right;

            // Now, link the new node to the parent as its right child.
            parent.right = newNode;
            System.out.println("Added " + x + " as the right child of " + parent.data);
        }
        return newNode;
    }

    // Function to make a node with the data 'data' the root of the tree.
    public void makeRoot(T data) {
        root = new TreeNode<T>(data);
    }

    // Public function to perform inorder traversal and print the tree.
    public void inorder() {
        System.out.println("Inorder traversal:");
        inorder(root);
        System.out.println();
    }

    // Public function to perform preorder traversal and print the tree.
    public void preorder() {
        System.out.println("Preorder traversal:");
        preorder(root);
        System.out.println();

    }

    // Public function to perform postorder traversal and print the tree.
    public void postorder() {
        System.out.println("Postorder traversal:");
        postorder(root);
        System.out.println();
    }

    // Private function for inorder traversal starting at node 'node'.
    private void inorder(TreeNode<T> node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.data + " ");
            inorder(node.right);
        }
    }

    // Private function for preorder traversal starting at node 'node'.
    private void preorder(TreeNode<T> node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preorder(node.left);
            preorder(node.right);
        }
    }

    // Private function for postorder traversal starting at node 'node'.
    private void postorder(TreeNode<T> node) {
        if (node != null) {
            postorder(node.left);
            postorder(node.right);
            System.out.print(node.data + " ");
        }
    }

    // Override toString method to convert the BinaryTree to a String representation.
    @Override
    public String toString() {
        // If the root is not null, return its String representation. Otherwise, say the tree is empty.
        return (root != null) ? root.toString() : "The tree is empty.";
    }

    public void print() {
        System.out.println(this.toString());
    }

    // zadaca2 od kniga
    // private method to find a node with a specific value in a binary tree.
    public TreeNode<T> findNode(TreeNode<T> n, T key) {
        // O(n) complexity
        // If the current node is null, the key is not found in the tree.
        if (n == null)
            return null;

        // Check if the current node's data is equal to the key.
        if (n.data.equals(key))
            return n; // Return the current node if it matches the key.

        // Recursively search for the key in the left subtree.
        TreeNode<T> foundLeft = findNode(n.left, key);

        // If the key is found in the left subtree, return the result.
        if (foundLeft != null)
            return foundLeft;

        // If the key is not found in the left subtree, search in the right subtree.
        TreeNode<T> foundRight = findNode(n.right, key);

        // Return the result of the search in the right subtree.
        return foundRight;
    }

    //public function to check if a node with a specific value exists in the binary tree
    public void findNode(T data) {
        // Call the findNode method to search for the node with the given data starting from the root node
        if (findNode(root, data) != null)
            System.out.println("Node with value " + data + " exists in the given binary tree");
        else
            System.out.println("Node with value " + data + " does NOT exist in the given binary tree");
    }

    // zadaca3 od kniga
    // This method calculates the level (depth) of a node with a specific 'data' value in a binary tree.
    private int getLevel(TreeNode<T> node, T data, int level) {
        // Base case: If the current node is null, return 0.
        if (node == null) {
            return 0;
        }

        // Check if the current node's data matches the specified 'data'.
        if (node.data.equals(data)) {
            return level; // The level of the node with 'data' has been found.
        }

        // Recursively search for 'data' in the left subtree.
        int tmplevel = getLevel(node.left, data, level + 1);

        if (tmplevel != 0) {
            return tmplevel; // Return the level if found in the left subtree.
        }

        // If 'data' is not found in the left subtree, search in the right subtree.
        tmplevel = getLevel(node.right, data, level + 1);
        return tmplevel;
    }

    // This public method calculates the level (depth) of a node with a specific 'data' value in a binary tree.
    public int getLevel(T data) {
        // Start the level calculation from the root of the tree.
        int level = getLevel(root, data, 1);

        // Return the calculated level.
        return level;
    }

    // zadaca6 od auditoriski
    // This method finds the Lowest Common Ancestor (LCA) of two nodes with values 'n1' and 'n2' in a binary tree.
    private TreeNode<T> findLCA(TreeNode<T> node, T n1, T n2) {
        // Base case: If the current node is null, return null.
        if (node == null) {
            return null;
        }

        // Check if the current node's data matches either of the two values 'n1' or 'n2'.
        if (node.data.equals(n1) || node.data.equals(n2)) {
            return node; // This node is LCA.
        }

        // Recursively search for the LCA in the left and right subtrees.
        TreeNode<T> leftLCA = findLCA(node.left, n1, n2);
        TreeNode<T> rightLCA = findLCA(node.right, n1, n2);

        // Determine the LCA based on the results from left and right subtrees.
        if (leftLCA != null && rightLCA != null) {
            return node; // LCA is the root of the subtrees
        }
        if (leftLCA == null && rightLCA == null) {
            return null; // not found in either subtree.
        }
        if (leftLCA != null) {
            return leftLCA; // LCA found in the left subtree.
        } else {
            return rightLCA; // LCA found in the right subtree.
        }
    }

    // Returns the distance between 'n1' and 'n2' in the binary tree.
    public int getDist(T n1, T n2) {
        // Find the Lowest Common Ancestor (LCA) of 'n1' and 'n2'.
        TreeNode<T> lca = findLCA(root, n1, n2);

        // Calculate the level (depth) of 'n1' and 'n2' with respect to the LCA.
        int d1 = getLevel(lca, n1, 0);
        int d2 = getLevel(lca, n2, 0);

        // Return the sum of the distances from LCA to 'n1' and LCA to 'n2'.
        return d1 + d2;
    }
}
