package PrethodniIspitni._2025;

import dataStructures.Edge;
import dataStructures.TreeNode;

import java.util.*;

/*
1. Kako ke napravish stek so 2 redici (queues), i da kazesh kompleksnostite za pop, peek, push (PAPS)
2. AVL drva kako rabotat i kompleksnosta na niv za baranje, brishenje i vmetnuvanje
3. BellmanFord kako raboti
4. Psevdo kod za left most view na binarno drvo (right view ama obratno od leetcode)
5. Psevdo kod za level order traversal
6. Psevdo kod za da najdesh desniot brat na daden node u binarno drvo
7. Psevdo kod za da najdesh djametar na binarno drvo (leetcode)*/
public class Usno_2025 {
    // 1 prasanje
    public static class StackWithTwoQueues<T> {

        Queue<T> q1 = new LinkedList<>();
        Queue<T> q2 = new LinkedList<>();

        public void push(T x) {
            // O(n) complexity
            q2.add(x);

            while (!q1.isEmpty()) {
                q2.add(q1.remove());
            }

            Queue<T> temp = q1;
            q1 = q2;
            q2 = temp;
        }

        public T pop() {
            // O(1) complexity
            if (q1.isEmpty()) {
                return null;
            }

            return q1.remove();
        }

        public T peek() {
            // O(1) complexity
            if (q1.isEmpty()) {
                return null;
            }

            return q1.peek();
        }
    }

    // 2 prasanje
    /* An AVL tree is a self-balancing Binary Search Tree.
The normal BST rule remains:
left < node < right
The special AVL rule is:
BF = height(left) - height(right)
For every node:
 BF \in \{-1,0,1\}
So the left and right subtrees can differ in height by at most 1.
Why does AVL need balancing?
A normal BST can become:
1
 \
  2
   \
    3
     \
      4
This is basically a linked list.
Search becomes:
O(n)
AVL prevents this by performing rotations.
Four rotation cases
LL
    30
   /
  20
 /
10
Right rotation:
   20
  /  \
10   30
RR
10
  \
   20
     \
      30
Left rotation.
LR
    30
   /
  10
    \
     20
First left rotation on 10, then right rotation on 30.
RL
10
  \
   30
  /
 20
First right rotation on 30, then left rotation on 10.
Complexities
Because AVL always remains balanced:
Operation	Average	    Worst
Search	    O(log n)	O(log n)
Insert	    O(log n)	O(log n)
Delete	    O(log n)	O(log n)
The important exam point:
AVL guarantees O(log n) height, therefore search, insertion and deletion are O(log n) in the worst case.
Rotations themselves are O(1).*/

    // 3 prasanje
    /*Bellman-Ford is an algorithm for finding shortest paths from one source vertex to all other vertices.

Its major advantage over Dijkstra is:

Bellman-Ford can handle negative edge weights.

It can also detect a negative cycle reachable from the source.

How it works

Suppose we have:

A --4--> B
A --2--> C
C --1--> B

Start with:

dist[A] = 0
dist[B] = ∞
dist[C] = ∞

Then repeatedly relax every edge.

For an edge:

u → v with weight w

we check:

if dist[u] + w < dist[v]
    dist[v] = dist[u] + w

We do this V - 1 times, where V is the number of vertices.

Why V - 1?

Because the longest possible simple path contains at most V - 1 edges.

Negative cycle detection

After doing V - 1 iterations, do one additional pass through all edges.

If we can still improve a distance:

dist[u] + weight < dist[v]

then there is a negative cycle reachable from the source.

Complexity

There are:

V vertices
E edges

We examine all E edges V-1 times:

$$ O(VE) $$

Space:

$$ O(V) $$

for the distance array.*/
    static void bellmanFord(int V, ArrayList<Edge> edges, int source) {

        int[] dist = new int[V];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        // Relax all edges V - 1 times
        for (int i = 1; i <= V - 1; i++) {

            for (Edge edge : edges) {

                if (dist[edge.getFromVertex()] != Integer.MAX_VALUE &&
                        dist[edge.getFromVertex()] + edge.getWeight() < dist[edge.getToVertex()]) {

                    dist[edge.getToVertex()] =
                            dist[edge.getFromVertex()] + edge.getWeight();
                }
            }
        }

        // Check for negative cycle
        for (Edge edge : edges) {

            if (dist[edge.getFromVertex()] != Integer.MAX_VALUE &&
                    dist[edge.getFromVertex()] + edge.getWeight() < dist[edge.getToVertex()]) {

                System.out.println("Negative cycle exists");
                return;
            }
        }

        System.out.println(Arrays.toString(dist));
    }

    // 4 prasanje
    public static void leftMostView(TreeNode<Integer> root) {

        if (root == null) {
            return;
        }

        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                TreeNode<Integer> node = queue.remove();

                //The rightmost view is exactly the same, except:
                //
                //if (i == size - 1)

                if (i == 0) {
                    System.out.println(node.getData());
                }

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
    }

    // 5 prasanje
    public static void levelOrder(TreeNode<Integer> root) {

        if (root == null) {
            return;
        }

        Queue<TreeNode<Integer>> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {

            TreeNode<Integer> node = queue.remove();

            System.out.print(node.getData() + " ");

            if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    // 6 prasanje
    public static TreeNode<Integer> rightSibling(TreeNode<Integer> root, TreeNode<Integer> target) {

        if (root == null || target == null) {
            return null;
        }

        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                TreeNode<Integer> node = queue.remove();

                if (node == target) {

                    if (i == size - 1) {
                        return null;
                    }

                    return queue.peek();
                }

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }

        return null;
    }

    // 7 prasanje
    static int diameter = 0;
    public static int height(TreeNode<Integer> node) {

        if (node == null) {
            return 0;
        }

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        diameter = Math.max(
                diameter,
                leftHeight + rightHeight
        );

        return 1 + Math.max(leftHeight, rightHeight);
    }
    public static int diameterOfBinaryTree(TreeNode<Integer> root) {

        diameter = 0;

        height(root);

        return diameter;
    }

}
