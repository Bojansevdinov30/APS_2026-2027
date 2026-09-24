package labs.Lab9;

import dataStructures.AdjacencyListGraph;

import java.util.Scanner;

public class Zadaca4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        AdjacencyListGraph<Integer> graph = new AdjacencyListGraph<>();

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            graph.addEdge(sc.nextInt(), sc.nextInt());
        }

        int startV = sc.nextInt();
        int sum = sc.nextInt();

        System.out.println(dfsFindNum(graph, startV, sum, startV));
    }

    public static int dfsFindNum(AdjacencyListGraph<Integer> graph, int currV, int targetSum, int currentSum) {
        if (currentSum == targetSum) {
            return 1;
        }

        if (currentSum > targetSum) {
            return 0;
        }

        int count = 0;

        for (int neighbor : graph.getNeighbors(currV)) {
            count += dfsFindNum(graph, neighbor, targetSum, currentSum + neighbor);
        }

        return count;
    }


}
