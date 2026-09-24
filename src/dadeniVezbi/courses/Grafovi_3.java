package dadeniVezbi.courses;

import dataStructures.AdjacencyListGraph;

import java.util.Scanner;

public class Grafovi_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        AdjacencyListGraph<Integer> graph = new AdjacencyListGraph<>();

        sc.nextLine();
        for (int i = 0; i < n; i++) {
            graph.addEdge(sc.nextInt(), sc.nextInt());
            sc.nextLine();
        }

        int start = sc.nextInt();
        int sum = sc.nextInt();

        System.out.println(findPaths(graph, start, start, sum));
    }

    public static int findPaths(AdjacencyListGraph<Integer> graph, int source, int currentSum, int targetValue) {
        if (currentSum == targetValue) {
            return 1;
        }
        if (currentSum > targetValue) {
            return 0;
        }
        int count = 0;
        for (int vertex : graph.getNeighbors(source)) {
            count += findPaths(graph, vertex, currentSum + vertex, targetValue);
        }
        return count;
    }

}
