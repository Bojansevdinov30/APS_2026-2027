package dataStructures;

import java.util.*;
import java.util.Queue;

public class AdjacencyMatrixGraph<T> {
    private int numVertices;
    private int[][] matrix;
    private T[] vertices;

    @SuppressWarnings("unchecked")
    public AdjacencyMatrixGraph(int numVertices) {
        this.numVertices = numVertices;
        matrix = new int[numVertices][numVertices];
        vertices = (T[]) new Object[numVertices];
    }

    public void addVertex(int index, T data) {
        vertices[index] = data;
    }

    public T getVertex(int index) {
        return vertices[index];
    }

    public void addEdge(int source, int destination, int weight) {
        matrix[source][destination] = weight;
        matrix[destination][source] = weight; // For undirected graph
    }

    public void addEdge(int source, int destination) {
        matrix[source][destination] = 0;
        matrix[destination][source] = 0; // For undirected graph
    }

    public boolean isEdge(int source, int destination) {
        return matrix[source][destination] == 1;
    }

    public void removeEdge(int source, int destination) {
        matrix[source][destination] = 0;
        matrix[destination][source] = 0; // For undirected graph
    }

    @SuppressWarnings("unchecked")
    public void removeVertex(int vertexIndex) {

        if (vertexIndex < 0 || vertexIndex >= numVertices) {
            throw new IndexOutOfBoundsException("Vertex index out of bounds!");
        }

        int[][] newMatrix = new int[numVertices - 1][numVertices - 1];
        T[] newVertices = (T[]) new Object[numVertices - 1];

        // Copy the vertices and matrix excluding the given vertex
        int ni = 0;
        for (int i = 0; i < numVertices; i++) {
            if (i == vertexIndex) continue;

            int nj = 0;
            for (int j = 0; j < numVertices; j++) {
                if (j == vertexIndex) continue;

                newMatrix[ni][nj] = matrix[i][j];
                nj++;
            }

            newVertices[ni] = vertices[i];
            ni++;
        }

        // Replace the old matrix and vertices with the new ones
        matrix = newMatrix;
        vertices = newVertices;
        numVertices--;
    }

    // Function to get all neighbors of a vertex


    public List<T> getNeighbors(int vertexIndex) {
        List<T> neighbors = new ArrayList<>();
        for (int i = 0; i < matrix[vertexIndex].length; i++) {
            if (matrix[vertexIndex][i] == 1) {
                neighbors.add(vertices[i]);

            }

        }
        return neighbors;

    }

    //Kruskal Algorithm
    private List<Edge> getAllEdges() {
        List<Edge> edges = new ArrayList<>();

        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                if (isEdge(i, j)) {
                    edges.add(new Edge(i, j, matrix[i][j]));
                }
            }
        }
        return edges;
    }

    public void union(int u, int v, int[] trees) {
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

    public List<Edge> kruskal() {
        List<Edge> mstEdges = new ArrayList<>();
        List<Edge> allEdges = getAllEdges();
        allEdges.sort(Comparator.comparingInt(Edge::getWeight));

        int[] trees = new int[numVertices];

        for (int i = 0; i < numVertices; i++) {
            trees[i] = i;
        }

        for (Edge e : allEdges) {
            if (trees[e.getFromVertex()] != trees[e.getToVertex()]) {
                mstEdges.add(e);

                union(e.getFromVertex(), e.getToVertex(), trees);
            }
        }

        return mstEdges;

    }

    //Prim Algorithm
    public List<Edge> prim(int startVertexIndex) {
        List<Edge> mstEdges = new ArrayList<>();
        Queue<Edge> q = new PriorityQueue<>(Comparator.comparingInt(Edge::getWeight));

        boolean[] included = new boolean[numVertices];

        for (int i = 0; i < numVertices; i++) {
            included[i] = false;
        }

        included[startVertexIndex] = true;

        for (int i = 0; i < numVertices; i++) {
            if (isEdge(startVertexIndex, i)) {
                q.add(new Edge(startVertexIndex, i, matrix[startVertexIndex][i]));
            }
        }

        while (!q.isEmpty()) {
            Edge e = q.poll();

            if (!included[e.getToVertex()]) {
                included[e.getToVertex()] = true;
                mstEdges.add(e);
                for (int i = 0; i < numVertices; i++) {
                    if (!included[i] && isEdge(e.getToVertex(), i)) {
                        q.add(new Edge(e.getToVertex(), i, matrix[e.getToVertex()][i]));
                    }
                }
            }
        }

        return mstEdges;
    }

    public List<Edge> adaptedKruskal(int[] trees) {
        List<Edge> mstEdges = new ArrayList<>();
        List<Edge> allEdges = getAllEdges();

        allEdges.sort(Comparator.comparingInt(Edge::getWeight));
        for (Edge e : allEdges) {
            if (trees[e.getFromVertex()] != trees[e.getToVertex()]) {
                mstEdges.add(e);

                union(e.getFromVertex(), e.getToVertex(), trees);
            }
        }
        return mstEdges;
    }

    //raboti so negativni tezini, ama ne i so negativni ciklusi
    public int[][] floydWarshall() {
        int[][] dist = new int[numVertices][numVertices];
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                dist[i][j] = matrix[i][j];
            }
        }

        for (int k = 0; k < numVertices; k++) {
            for (int i = 0; i < numVertices; i++) {
                for (int j = 0; j < numVertices; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        return dist;
    }

    public void printMatrix() {
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public AdjacencyListGraph<T> toAdjacencyList() {
        AdjacencyListGraph<T> result = new AdjacencyListGraph<>();

        for (int i = 0; i < numVertices; i++) {
            result.addVertex(vertices[i]);
        }

        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                if (matrix[i][j] > 0) {
                    result.addEdge(vertices[i], vertices[j]);
                }
            }
        }

        return result;
    }

    public int shortestPathsFrom(int vertexIndex) {
        boolean[] visited = new boolean[numVertices];
        int[] distances = new int[numVertices];
        for (int i = 0; i < numVertices; i++) {
            visited[i] = false;
            distances[i] = -1;
        }
        visited[vertexIndex] = true;
        distances[vertexIndex] = 0;
        System.out.println(vertexIndex + ": " + vertices[vertexIndex]);

        LinkedQueue<Integer> q = new LinkedQueue<>();
        q.enqueue(vertexIndex);

        int tmp;

        while (!q.isEmpty()) {
            tmp = q.dequeue();
            for (int i = 0; i < numVertices; i++) {
                if (isEdge(tmp, i)) {
                    if (!visited[i]) {
                        visited[i] = true;
                        distances[i] = distances[tmp] + 1;
                        System.out.println(i + ": " + vertices[i]);
                        q.enqueue(i);
                    }
                }
            }
        }
        return distances[vertexIndex];
    }

}
