package dataStructures;

import java.util.List;

public class BinarySearchTree<E extends Comparable<E>> {
    // prebaruvanje e O(logn) ako e balansirano, inace e O(n)
    // vmetnuvanje e O(logn)
    // brisenje e O(logn)
    private BNode<E> root;

    public BinarySearchTree() {
        root = null;
    }

    public void makeEmpty() {
        root = null;
    }

    /**
     * Internal method to insert into a subtree.
     *
     * @param x the item to insert.
     * @param t the node that roots the tree.
     * @return the new root.
     */
    private BNode<E> insert(E x, BNode<E> t) {
        // O(logn) complexity
        if (t == null) {
            t = new BNode<E>(x, null, null);
        } else if (x.compareTo(t.info) < 0) {
            t.left = insert(x, t.left);
        } else if (x.compareTo(t.info) > 0) {
            t.right = insert(x, t.right);
        } else ; // Duplicate; do nothing
        return t;
    }

    public void insert(E x) {
        root = insert(x, root);
    }

    private BNode<E> findMin(BNode<E> t) {
        if (t == null) {
            return null;
        } else if (t.left == null) {
            return t;
        }
        return findMin(t.left);
    }

    public E findMin() {
        return elementAt(findMin(root));
    }

    private BNode<E> findMax(BNode<E> t) {
        if (t == null) {
            return null;
        } else if (t.right == null) {
            return t;
        }
        return findMax(t.right);
    }

    public E findMax() {
        return elementAt(findMax(root));
    }

    private E elementAt(BNode<E> node) {
        return node.info;
    }

    private BNode<E> find(E x, BNode<E> t) {
        // O(logn) ako e balansirano, O(n) inaku e najlos
        if (t == null)
            return null;
        if (x.compareTo(t.info) < 0) {
            return find(x, t.left);
        } else if (x.compareTo(t.info) > 0) {
            return find(x, t.right);
        } else {
            return t; // Match
        }
    }

    public BNode<E> find(E x) {
        return find(x, root);
    }

    private BNode<E> remove(Comparable x, BNode<E> t) {
        // O(logn) complexity
        if (t == null)
            return t; // Item not found; do nothing
        if (x.compareTo(t.info) < 0) {
            t.left = remove(x, t.left);
        } else if (x.compareTo(t.info) > 0) {
            t.right = remove(x, t.right);
        } else if (t.left != null && t.right != null) { // Two children
            t.info = findMin(t.right).info;
            t.right = remove(t.info, t.right);
        } else {
            if (t.left != null)
                return t.left;
            else
                return t.right;
        }
        return t;
    }

    public void remove(E x) {
        root = remove(x, root);
    }

    public BNode<E> getRoot() {
        return root;
    }

    public void setRoot(BNode<E> root) {
        this.root = root;
    }

    // This method calculates the height (maximum depth) of a binary tree rooted at 'node'.
    public int height(BNode<E> node) {
        // Base case: If the current node is null, the height is 0.
        if (node == null) {
            return 0;

        }

        // Recursively calculate the height of the left and right subtrees,
        // and return the maximum height plus 1 (to account for the current node).
        return 1 + Math.max(height(node.left), height(node.right));
    }

    // This method checks whether a binary tree rooted at 'node' is balanced.
    public boolean isBalanced(BNode<E> node) {
        int left_h, right_h;

        // Base case: If the current node is null, it's considered balanced.
        if (node == null) {
            return true;
        }

        // Calculate the heights of the left and right subtrees.
        left_h = height(node.left);
        right_h = height(node.right);

        // Check if the difference in heights of left and right subtrees is at most 1,
        // and both left and right subtrees are themselves balanced.
        if (Math.abs(left_h - right_h) <= 1 && isBalanced(node.left) && isBalanced(node.right)) {
            return true; // The tree rooted at 'node' is balanced.
        }

        return false; // The tree rooted at 'node' is not balanced.
    }

    public void print() {
        System.out.print(root.info); // temp example
    }


    // Private function for performing an inorder traversal and store the data in a list
    private void inorder(BNode<E> node, List<E> sortedInorder) {
        // Base case: If the current node is not null.
        if (node != null) {
            // Recursively traverse the left subtree.
            inorder(node.left, sortedInorder);

            // Add the data of the current node to the 'sortedInorder' list.
            sortedInorder.add(node.info);

            // Recursively traverse the right subtree.
            inorder(node.right, sortedInorder);
        }
    }

    // Public function to perform an inorder traversal starting from the root and store the result in a list.
    public void inorder(List<E> sortedInorder) {
        // Start the inorder traversal from the root of the tree.
        inorder(root, sortedInorder);
    }
}

