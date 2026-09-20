package dataStructures;

import java.util.*;
import java.util.Stack;

public class AdjacencyListGraph<T> {

    /*
     * vertex -> (neighbor -> weight)
     *
     * Example:
     *
     * A -> {B=5, C=2}
     *
     * means:
     * A --5-- B
     * A --2-- C
     */
    private Map<T, Map<T, Integer>> adjacencyList;


    public AdjacencyListGraph() {
        adjacencyList = new HashMap<>();
    }


    // =========================================================
    // ADD VERTEX
    // =========================================================

    public void addVertex(T vertex) {

        if (!adjacencyList.containsKey(vertex)) {
            adjacencyList.put(vertex, new HashMap<>());
        }
    }


    // =========================================================
    // REMOVE VERTEX
    // =========================================================

    public void removeVertex(T vertex) {

        // Remove vertex from all neighbor maps
        for (Map<T, Integer> neighbors : adjacencyList.values()) {
            neighbors.remove(vertex);
        }

        // Remove the vertex itself
        adjacencyList.remove(vertex);
    }


    // =========================================================
    // ADD EDGE
    // =========================================================

    // Weighted edge
    public void addEdge(T source, T destination, int weight) {

        addVertex(source);
        addVertex(destination);

        adjacencyList.get(source).put(destination, weight);

        // UNDIRECTED GRAPH
        adjacencyList.get(destination).put(source, weight);

        /*
         * DIRECTED GRAPH:
         *
         * remove/comment:
         *
         * adjacencyList.get(destination).put(source, weight);
         */
    }


    // Optional:
    // If no weight is given, assume weight = 1
    public void addEdge(T source, T destination) {
        addEdge(source, destination, 1);
    }


    // =========================================================
    // REMOVE EDGE
    // =========================================================

    public void removeEdge(T source, T destination) {

        if (adjacencyList.containsKey(source)) {
            adjacencyList.get(source).remove(destination);
        }

        // UNDIRECTED GRAPH
        if (adjacencyList.containsKey(destination)) {
            adjacencyList.get(destination).remove(source);
        }

        /*
         * DIRECTED GRAPH:
         *
         * remove/comment the second part.
         */
    }


    // =========================================================
    // GET NEIGHBORS
    // =========================================================

    public Set<T> getNeighbors(T vertex) {

        if (!adjacencyList.containsKey(vertex)) {
            return new HashSet<>();
        }

        return adjacencyList.get(vertex).keySet();
    }


    // =========================================================
    // GET WEIGHT
    // =========================================================

    public Integer getWeight(T source, T destination) {

        if (!adjacencyList.containsKey(source)) {
            return null;
        }

        return adjacencyList.get(source).get(destination);
    }


    // =========================================================
    // DFS - RECURSIVE
    // =========================================================

    public void DFS(T startVertex) {

        Set<T> visited = new HashSet<>();

        DFSUtil(startVertex, visited);
    }


    private void DFSUtil(T vertex, Set<T> visited) {

        visited.add(vertex);

        System.out.print(vertex + " ");

        for (T neighbor : getNeighbors(vertex)) {

            if (!visited.contains(neighbor)) {
                DFSUtil(neighbor, visited);
            }
        }
    }


    // =========================================================
    // DFS - ITERATIVE
    // =========================================================

    public void DFSnonR(T startVertex) {

        Set<T> visited = new HashSet<>();

        LinkedStack<T> stack = new LinkedStack<>();

        stack.push(startVertex);

        while (!stack.isEmpty()) {

            T vertex = stack.pop();

            if (!visited.contains(vertex)) {

                visited.add(vertex);

                System.out.print(vertex + " ");

                for (T neighbor : getNeighbors(vertex)) {

                    if (!visited.contains(neighbor)) {
                        stack.push(neighbor);
                    }
                }
            }
        }
    }


    // =========================================================
    // BFS
    // =========================================================

    public void BFS(T startVertex) {

        Set<T> visited = new HashSet<>();

        LinkedQueue<T> queue = new LinkedQueue<>();

        visited.add(startVertex);

        queue.enqueue(startVertex);

        while (!queue.isEmpty()) {

            T vertex = queue.dequeue();

            System.out.print(vertex + " ");

            for (T neighbor : getNeighbors(vertex)) {

                if (!visited.contains(neighbor)) {

                    visited.add(neighbor);

                    queue.enqueue(neighbor);
                }
            }
        }
    }


    // =========================================================
    // BIDIRECTIONAL SEARCH
    // =========================================================

    public boolean bidirectionalSearch(T startVertex, T endVertex) {

        if (startVertex.equals(endVertex)) {
            return true;
        }

        Set<T> visitedFromStart = new HashSet<>();
        Set<T> visitedFromEnd = new HashSet<>();

        LinkedQueue<T> queueFromStart = new LinkedQueue<>();
        LinkedQueue<T> queueFromEnd = new LinkedQueue<>();


        visitedFromStart.add(startVertex);
        queueFromStart.enqueue(startVertex);

        visitedFromEnd.add(endVertex);
        queueFromEnd.enqueue(endVertex);


        while (!queueFromStart.isEmpty()
                && !queueFromEnd.isEmpty()) {

            if (pathExists(
                    queueFromStart,
                    visitedFromStart,
                    visitedFromEnd)) {

                return true;
            }

            if (pathExists(
                    queueFromEnd,
                    visitedFromEnd,
                    visitedFromStart)) {

                return true;
            }
        }

        return false;
    }


    private boolean pathExists(
            LinkedQueue<T> queue,
            Set<T> visitedFromThisEnd,
            Set<T> visitedFromOtherEnd) {

        T currentVertex = queue.dequeue();

        for (T neighbor : getNeighbors(currentVertex)) {

            if (visitedFromOtherEnd.contains(neighbor)) {
                return true;
            }

            if (!visitedFromThisEnd.contains(neighbor)) {

                visitedFromThisEnd.add(neighbor);

                queue.enqueue(neighbor);
            }
        }

        return false;
    }


    // =========================================================
    // TOPOLOGICAL SORT
    // =========================================================

    private void topologicalSortUtil(
            T vertex,
            Set<T> visited,
            Stack<T> stack) {

        visited.add(vertex);

        for (T neighbor : getNeighbors(vertex)) {

            if (!visited.contains(neighbor)) {

                topologicalSortUtil(
                        neighbor,
                        visited,
                        stack
                );
            }
        }

        // Push AFTER visiting all descendants
        stack.push(vertex);
    }


    public List<T> topologicalSort() {

        java.util.Stack<T> stack = new java.util.Stack<>();

        Set<T> visited = new HashSet<>();


        for (T vertex : adjacencyList.keySet()) {

            if (!visited.contains(vertex)) {

                topologicalSortUtil(
                        vertex,
                        visited,
                        stack
                );
            }
        }


        List<T> result = new ArrayList<>();

        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }

        return result;
    }


    // =========================================================
    // DIJKSTRA
    // =========================================================

    /*
     * Helper class used by the PriorityQueue.
     *
     * We store:
     *
     * vertex
     * distance from start
     */
    private static class NodeDistance<U> {

        U vertex;
        int distance;

        public NodeDistance(U vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
    }


    public Map<T, Integer> shortestPath(T startVertex) {

        // vertex -> shortest known distance from start
        Map<T, Integer> distances = new HashMap<>();


        // Initially all distances are infinity
        for (T vertex : adjacencyList.keySet()) {
            distances.put(vertex, Integer.MAX_VALUE);
        }


        // Start vertex has distance 0
        distances.put(startVertex, 0);


        // Smallest distance comes out first
        PriorityQueue<NodeDistance<T>> queue = new PriorityQueue<>(
                Comparator.comparingInt(node -> node.distance));


        queue.add(new NodeDistance<>(startVertex, 0));


        while (!queue.isEmpty()) {
            NodeDistance<T> currentEntry = queue.poll();
            T current = currentEntry.vertex;
            int currentDistance = currentEntry.distance;

            /*
             * We may have an old entry in the queue.
             *
             * Example:
             *
             * A initially found with distance 10
             * later found with distance 5
             *
             * Queue may contain:
             *
             * (A,5)
             * (A,10)
             *
             * When (A,10) eventually comes out,
             * we simply ignore it.
             */
            if (currentDistance != distances.get(current)) {
                continue;
            }

            /*
             * adjacencyList.get(current) is:
             *
             * Map<T,Integer>
             *
             * so entrySet() gives:
             *
             * neighbor -> weight
             */
            for (Map.Entry<T, Integer> neighborEntry : adjacencyList.get(current).entrySet()) {

                T neighbor = neighborEntry.getKey();
                int weight = neighborEntry.getValue();
                int newDistance = currentDistance + weight;

                /*
                 * RELAXATION
                 *
                 * Is going:
                 *
                 * start -> ... -> current -> neighbor
                 *
                 * shorter than the best known path
                 * to neighbor?
                 */
                if (newDistance < distances.get(neighbor)) {
                    distances.put(neighbor, newDistance);
                    queue.add(new NodeDistance<>(neighbor, newDistance));
                }
            }
        }


        return distances;
    }

    public void findPath(T startVertex, T endVertex) {
        Set<T> visited = new HashSet<>();
        Stack<T> invertedPath = new Stack<>();
        visited.add(startVertex);
        invertedPath.push(startVertex);

        while (!invertedPath.isEmpty() && !invertedPath.peek().equals(endVertex)) {
            T currentVertex = invertedPath.peek();
            T tmp = currentVertex;

            for (T vertex : getNeighbors(currentVertex)) {
                tmp = vertex;
                if (!visited.contains(vertex)) {
                    break;
                }
            }

            if (!visited.contains(tmp)) {
                visited.add(tmp);
                invertedPath.push(tmp);
            } else {
                invertedPath.pop();
            }
        }

        Stack<T> path = new Stack<>();

        while (!invertedPath.isEmpty()) {
            path.push(invertedPath.pop());
        }

        while (!path.isEmpty()) {
            System.out.println(path.pop());
        }
    }

    public void topologicalSortBook() {
        Set<T> visited = new HashSet<>();

        Stack<T> s = new Stack<>();

        for (T vertex : adjacencyList.keySet()) {
            dfsVisit(vertex, visited, s);
        }

        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }

    private void dfsVisit(T vertex, Set<T> visited, Stack<T> s) {
        if (!visited.contains(vertex)) {
            visited.add(vertex);
            for (T v : getNeighbors(vertex)) {
                dfsVisit(v, visited, s);
            }
            s.push(vertex);
        }
    }

}