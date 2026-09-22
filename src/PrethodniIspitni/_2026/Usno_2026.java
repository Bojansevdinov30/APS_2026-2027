package PrethodniIspitni._2026;

import dataStructures.BNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*Usen ispit za 10-ka po APS, 23.02.2026:

1. Bellman Ford kako raboti i kako se spravuva so negativnite ciklusi
2. AVL drva kako funkcioniraat i koja e kompleksnosta na brisenje, dodavanje i prebaruvanje element vo prosecen i vo najlos slucaj
3. Kade se koristat B+ drvata, zosto se koristat itn., objasni detalno
4. Psevdo kod za naogjanje desno bratce/bratucedce na daden jazol vo binarno drvo (ja ima na leetcode)
5. Psevdo kod za left most view na binarno drvo, odnosno da se najdat najlevite jazli na sekoe nivo vo binarnoto drvo (ja ima na leetcode)
6. Psevdo kod za level order traversal, odnosno za sekoe nivo vo binarnoto drvo da se ispecatat site elementi na sekoe od nivoata,
odlevo nadesno (ja ima na leetcode)*/
public class Usno_2026 {
    // 1 prasanje
    /*After doing:
V - 1
rounds, we make one additional pass through all edges.
If we can still improve a distance:
dist[u] + weight < dist[v]
then there must be a reachable negative-weight cycle.
Why?
A shortest simple path cannot have more than V - 1 edges.
So if we're still finding improvements after V - 1 rounds,
the only explanation is that we can keep going around some cycle and making the total cost smaller.*/
    /*
    Pseudo code
    BellmanFord(G, source):

    for every vertex v:
        dist[v] = INFINITY

    dist[source] = 0

    repeat V - 1 times:

        for every edge (u, v, weight):

            if dist[u] != INFINITY
               AND dist[u] + weight < dist[v]:

                dist[v] = dist[u] + weight

    // Check for negative cycle

    for every edge (u, v, weight):

        if dist[u] != INFINITY
           AND dist[u] + weight < dist[v]:

            return "Negative cycle exists"

    return dist
    */
    static class Edge {
        int from;
        int to;
        int weight;

        Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    static int[] bellmanFord(int n, List<Edge> edges, int source) {

        int[] dist = new int[n];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        // Relax all edges V - 1 times
        for (int i = 0; i < n - 1; i++) {

            for (Edge edge : edges) {

                if (dist[edge.from] != Integer.MAX_VALUE &&
                        dist[edge.from] + edge.weight < dist[edge.to]) {

                    dist[edge.to] =
                            dist[edge.from] + edge.weight;
                }
            }
        }

        // Check for negative cycle
        for (Edge edge : edges) {

            if (dist[edge.from] != Integer.MAX_VALUE &&
                    dist[edge.from] + edge.weight < dist[edge.to]) {

                System.out.println("Negative cycle exists");
                return null;
            }
        }

        return dist;
    }

    // 2 prasanje
    /*
    An AVL tree is a self-balancing Binary Search Tree.
The normal BST problem is that it can become:
1
 \
  2
   \
    3
     \
      4
Its height becomes O(n).
Then search becomes: O(n)
An AVL tree prevents this by maintaining a balance condition.
For every node: balanceFactor = height(left subtree) - height(right subtree)
An AVL tree requires:
-1 <= balanceFactor <= 1
So allowed values are:
-1
 0
+1
If we get: +2 or :-2
we have to rebalance.
Rotations
There are four cases.
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
Left rotation:
   20
  /  \
10   30

LR
    30
   /
  10
    \
     20
First:
left rotation on 10
then:
right rotation on 30
Result:
    20
   /  \
 10   30

RL
Mirror image:
10
  \
   30
   /
  20
First right rotation on 30, then left rotation on 10.

AVL complexity
The important table:
Operation	Average	    Worst case
Search	    O(log n)	O(log n)
Insert	    O(log n)	O(log n)
Delete	    O(log n)	O(log n)

Why doesn't AVL have an O(n) worst case?
Because it guarantees logarithmic height.
More precisely:
height = O(log n)
and BST search/insert/delete follow a path from the root downward, so they depend on the height.*/

    // 3 prasanje
    /*
    A B+ tree is a balanced multi-way search tree designed particularly for storage systems and databases.
Instead of each node having only:
left child
right child
like a binary tree, a B+ tree node can have many children.
For example:
             [20 | 40 | 60]
           /      |      |      \
        ...      ...    ...     ...
Why are B+ trees used?
The biggest reason is:
They minimize the number of expensive disk/page accesses.
Imagine you have millions of database records.
You don't want:
disk → read node
disk → read node
disk → read node
disk → read node
...
every time you search.
A B+ tree has a very high branching factor, meaning each node can contain many keys and point to many children.
Therefore the tree is very short.
For example, instead of:
        50
       /  \
     25    75
    / \    / \
   ...
you might have:
       [10 20 30 40 50 60 70 80]
      /   |  |  |  |  |  |  |   \
A single disk page can contain many keys.
The defining property of B+ Trees:
Internal nodes contain keys for navigation.
Actual records/data are stored in the leaves.
For example:
                 [20 | 40]
                /    |    \
               /     |     \
       [5 10 15] [20 25 30] [40 50 60]
The internal nodes essentially tell us:
Which child should I follow?
The actual data is at the leaf level.
Leaves are linked
Another very important B+ tree characteristic:
[5 10 15] → [20 25 30] → [40 50 60] → ...
The leaf nodes are connected.
This makes range queries extremely efficient.
For example:
SELECT *
FROM students
WHERE grade >= 7
AND grade <= 10;
Once you find the leaf containing 7, you can simply follow the leaf links:
7 → 8 → 9 → 10
instead of repeatedly searching from the root.
Where are B+ trees used?
Primarily:
Database indexes
File systems
Disk-based storage systems
Large datasets stored on secondary storage
For example, a database might have:
CREATE INDEX idx_student_name
ON Students(name);
Internally, the database can use a B+ tree to efficiently locate records by name.

Why not AVL?
AVL is great when data is primarily in RAM.
B+ trees are designed around external storage.
The difference is essentially:
AVL
↓
RAM-oriented
↓
binary
↓
height O(log n)

versus:

B+ tree
↓
disk/page-oriented
↓
many children per node
↓
very small height
↓
excellent range queries*/

    // 4 prasanje
    /*Pseudo code
    findRightNode(root, target):

    queue = empty queue
    queue.add(root)

    while queue is not empty:

        size = queue.size()

        for i = 0 to size - 1:

            current = queue.remove()

            if current == target:

                if i == size - 1:
                    return null

                return queue.peek()

            if current.left != null:
                queue.add(current.left)

            if current.right != null:
                queue.add(current.right)

    return null*/
    // time & space complexity O(n)
    static BNode<Integer> findRightNode(BNode<Integer> root, BNode<Integer> target) {

        if (root == null) {
            return null;
        }

        Queue<BNode<Integer>> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                BNode<Integer> current = queue.poll();

                if (current == target) {

                    if (i == size - 1) {
                        return null;
                    }

                    return queue.peek();
                }

                if (current.left != null) {
                    queue.offer(current.left);
                }

                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
        }

        return null;
    }

    // 5 prasanje
    /*Pseudo code
    leftMostView(root):

    queue = empty queue
    queue.add(root)

    while queue is not empty:

        size = queue.size()

        for i = 0 to size - 1:

            current = queue.remove()

            if i == 0:
                print current

            if current.left != null:
                queue.add(current.left)

            if current.right != null:
                queue.add(current.right)
                */
    // time & space complexity O(n)
    static void leftMostView(BNode<Integer> root) {

        if (root == null) {
            return;
        }

        Queue<BNode<Integer>> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                BNode<Integer> current = queue.poll();

                if (i == 0) {
                    System.out.print(current.info + " ");
                }

                if (current.left != null) {
                    queue.offer(current.left);
                }

                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
        }
    }

    // 6 prasanje
    /*levelOrder(root):

    if root is null:
        return

    queue = empty queue
    queue.add(root)

    while queue is not empty:

        size = queue.size()

        for i = 0 to size - 1:

            current = queue.remove()

            print current

            if current.left != null:
                queue.add(current.left)

            if current.right != null:
                queue.add(current.right)

        print new line*/
    static void levelOrder(BNode<Integer> root) {

        if (root == null) {
            return;
        }

        Queue<BNode<Integer>> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                BNode<Integer> current = queue.poll();

                System.out.print(current.info + " ");

                if (current.left != null) {
                    queue.offer(current.left);
                }

                if (current.right != null) {
                    queue.offer(current.right);
                }
            }

            System.out.println();
        }
    }

}
