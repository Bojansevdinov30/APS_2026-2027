package LeetCode.Graphs;

import java.util.*;

/*There are n servers numbered from 0 to n - 1 connected by undirected server-to-server connections forming a network where connections[i] = [ai, bi] represents a connection between servers ai and bi. Any server can reach other servers directly or indirectly through the network.

A critical connection is a connection that, if removed, will make some servers unable to reach some other server.

Return all critical connections in the network in any order.
Input: n = 4, connections = [[0,1],[1,2],[2,0],[1,3]]
Output: [[1,3]]
Explanation: [[3,1]] is also accepted.
Example 2:

Input: n = 2, connections = [[0,1]]
Output: [[0,1]]


Constraints:

2 <= n <= 105
n - 1 <= connections.length <= 105
0 <= ai, bi <= n - 1
ai != bi
There are no repeated connections.*/
public class CriticalConnectionInANetwork {
    // this solution is too inefficient (it is based on Kruskal's algorithm)
    /*
    public static void union(int u, int v, int[] trees) {
        int findWhat, replaceWith;
        if (u < v) {
            findWhat = trees[v];
            replaceWith = trees[u];
        } else {
            findWhat = trees[u];
            replaceWith = trees[v];
        }
        for (int i = 0; i < trees.length; i++) {
            if (trees[i] == findWhat) {
                trees[i] = replaceWith;
            }
        }
    }

    public static List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> result = new ArrayList<>();
        for (List<Integer> connection : connections) {
            int[] trees = new int[n];
            for (int i = 0; i < n; i++) {
                trees[i] = i;
            }
            for (List<Integer> otherConnection : connections) {
                if (otherConnection != connection) {
                    if (trees[otherConnection.get(0)] != trees[otherConnection.get(1)]) {
                        union(otherConnection.get(0), otherConnection.get(1), trees);
                    }

                }
            }

            // this is used because we dont want [0, 1] and [1, 0] both being in the result
            List<Integer> temp = new ArrayList<>();
            temp.add(connection.get(1));
            temp.add(connection.get(0));
            for (int i = 0; i < n - 1; i++) {
                if (trees[i] != trees[i + 1]) {

                    if (!result.contains(temp) && !result.contains(connection)) {
                        result.add(connection);
                    }
                    break;
                }
            }

        }

        return result;
    }*/
    public static List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (List<Integer> oneConnection : connections) {
            graph[oneConnection.get(0)].add(oneConnection.get(1));
            graph[oneConnection.get(1)].add(oneConnection.get(0));
        }
        HashSet<List<Integer>> connectionsSet = new HashSet<>(connections);
        int[] rank = new int[n];
        Arrays.fill(rank, -2);
        dfs(graph, 0, 0, rank, connectionsSet);
        return new ArrayList<>(connectionsSet);
    }

    static int dfs(List<Integer>[] graph, int node, int depth, int[] rank, HashSet<List<Integer>> connectionsSet) {
        if (rank[node] >= 0) {
            return rank[node]; // already visited node. return its rank
        }
        rank[node] = depth;
        int minDepthFound = depth; // can be Integer.MAX_VALUE also.
        for (Integer neighbor : graph[node]) {
            if (rank[neighbor] == depth - 1) { // ignore parent
                continue;
            }
            int minDepth = dfs(graph, neighbor, depth + 1, rank, connectionsSet);
            minDepthFound = Math.min(minDepthFound, minDepth);
            if (minDepth <= depth) {
                // to avoid the sorting just try to remove both combinations. of (x,y) and (y,x)
                connectionsSet.remove(Arrays.asList(node, neighbor));
                connectionsSet.remove(Arrays.asList(neighbor, node));
            }
        }
        return minDepthFound;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt(); // this is the thing that is given in LeetCode but we need it here - the number of connections
        List<List<Integer>> connections = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            ArrayList<Integer> connection = new ArrayList<>();
            connection.add(a);
            connection.add(b);
            connections.add(connection);
        }
        System.out.println(criticalConnections(n, connections));
    }
}
