package dataStructures;

public class BTree<E> {
    // prebaruvanje e O(n)
    // vmetnuvanje e O(n)
    // brisenje e O(n)
    public BNode<E> root;

    public BTree() {
        root = null;
    }

    public BTree(E info) {
        root = new BNode<>(info);
    }

    public void makeRoot(E elem) {
        root = new BNode<E>(elem);
    }

    public BNode<E> addChild(BNode<E> node, int where, E elem) {
        // O(n) complexity
        // BNode<E> temp = new BNode<E>(elem);
        BNode<E> temp = new BNode<E>(elem, node); // za zadaca9 e ova
        if (where == BNode.LEFT) {
            if (node.left != null) { // veke postoi element
                return null;
            }
            node.left = temp;
        } else {
            if (node.right != null) { // veke postoi element
                return null;
            }
            node.right = temp;
        }
        return temp;
    }

    public void inorder() {
        System.out.print("Inorder: ");
        inorderR(root);
        System.out.println();
    }

    public void inorderR(BNode<E> node) {
        if (node == null) return;
        inorderR(node.left);
        System.out.print(node.info.toString() + " ");
        inorderR(node.right);
    }

    public void preorder() {
        System.out.print("Preorder: ");
        preorderR(root);
        System.out.println();
    }

    public void preorderR(BNode<E> node) {
        if (node == null) return;
        System.out.print(node.info.toString() + " ");
        preorderR(node.left);
        preorderR(node.right);
    }

    public void postorder() {
        System.out.print("Postorder: ");
        postorderR(root);
        System.out.println();
    }

    public void postorderR(BNode<E> node) {
        if (node == null) return;
        postorderR(node.left);
        postorderR(node.right);
        System.out.print(node.info.toString() + " ");
    }

    // zadaca3 od auditoriskite
    public void inorderNonRecursive() {
        ArrayStack<BNode<E>> s = new ArrayStack<BNode<E>>(100);
        BNode<E> p = root;
        System.out.print("INORDER (nonrecursive): ");

        while (true) {
            while (p != null) {
                // treba do kraj vo levo da odime
                s.push(p);
                p = p.left;
            }

            if (s.isEmpty()) {
                break;
            }
            p = s.peek();
            // pecatenje
            System.out.print(p.info.toString() + " ");
            // brisenje
            s.pop();
            // odime do kraj vo desno
            p = p.right;
        }
        System.out.println();
    }

    // zadaca4 od auditoriskite
    public int insideNodes() {
        return insideNodesR(root);
    }

    public int insideNodesR(BNode<E> node) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return 0;
        return insideNodesR(node.left) + insideNodesR(node.right) + 1;
    }


    // zadaca5 od auditoriskite
    public int leaves() {
        return leavesR(root);
    }

    public int leavesR(BNode<E> node) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return 1;
        return leavesR(node.left) + leavesR(node.right);
    }

    // zadaca6 od auditoriskite
    public int depth() {
        return depthR(root);
    }

    int depthR(BNode<E> node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return 0; // se broi vo edges, a ne vo nodes, zatoa e 0 tuka
        }
        return 1 + Math.max(depthR(node.left), depthR(node.right));
    }

    // zadaca7 od auditoriskite
    public void mirror() {
        mirrorR(root);
    }

    public void mirrorR(BNode<E> node) {
        BNode<E> temp;
        if (node == null) return;

        // odime levo i desno
        mirrorR(node.left);
        mirrorR(node.right);

        // smena na ulogite
        temp = node.left;
        node.left = node.right;
        node.right = temp;
    }

    // zadaca7 od kniga
    public static int sumOnlyLeft(BNode<Integer> node) {

        if (node == null) {
            return 0;
        }

        int sum = 0;

        if (node.left != null && node.right == null) {
            sum += node.info;
        }

        return sum
                + sumOnlyLeft(node.left)
                + sumOnlyLeft(node.right);
    }

    // Zadaca8 od kniga
    public static int sum(BNode<Integer> node) {
        if (node == null) {
            return 0;
        }

        return node.info + sum(node.left) + sum(node.right);
    }

    public static boolean isSumTree(BNode<Integer> node) {
        if (node == null) {
            return true;
        }

        // A leaf is automatically a SumTree
        if (node.left == null && node.right == null) {
            return true;
        }

        int leftSum = sum(node.left);
        int rightSum = sum(node.right);

        return node.info == leftSum + rightSum
                && isSumTree(node.left)
                && isSumTree(node.right);
    }

    // zadaca9 od kniga
    public static int sumNumbers(BNode<Integer> node, int currentNumber) {

        if (node == null) {
            return 0;
        }

        currentNumber = currentNumber * 10 + node.info;

        // We have completed one root-to-leaf number
        if (node.left == null && node.right == null) {
            return currentNumber;
        }

        return sumNumbers(node.left, currentNumber)
                + sumNumbers(node.right, currentNumber);
    }

    // Helper function to find the LCA
    public static BNode<String> findLCA(BNode<String> root, String n1, String n2) {
        if (root == null) return null;

        // If either node matches the root, this is part of the LCA path
        if (root.info.equals(n1) || root.info.equals(n2)) {
            return root;
        }

        // Recurse for left and right subtrees
        BNode<String> leftLCA = findLCA(root.left, n1, n2);
        BNode<String> rightLCA = findLCA(root.right, n1, n2);

        // If both subtrees return non-null, this is the LCA
        if (leftLCA != null && rightLCA != null) {
            return root;
        }

        // Otherwise, propagate non-null result upwards
        return (leftLCA != null) ? leftLCA : rightLCA;
    }

    // Helper function to find the distance from a node to a target
    public static int findDistance(BNode<String> root, String target, int distance) {
        if (root == null) return -1;

        if (root.info.equals(target)) return distance;

        int leftDist = findDistance(root.left, target, distance + 1);
        if (leftDist != -1) return leftDist;

        return findDistance(root.right, target, distance + 1);
    }

    public void makeRootNode(BNode<E> node) {
        root = node;
    }

    public BNode<E> addChildNode(BNode<E> node, int where, BNode<E> tmp) {

        if (where == BNode.LEFT) {
            if (node.left != null)  // veke postoi element
                return null;
            node.left = tmp;
        } else {
            if (node.right != null) // veke postoi element
                return null;
            node.right = tmp;
        }

        return tmp;
    }


}
