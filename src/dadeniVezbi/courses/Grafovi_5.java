package dadeniVezbi.courses;

import dataStructures.AdjacencyListGraph;

import java.util.Map;
import java.util.Scanner;

public class Grafovi_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        AdjacencyListGraph<String> graph = new AdjacencyListGraph<>();
        String[][] transformations = new String[n][2];

        sc.nextLine();
        for (int i = 0; i < n; i++) {
            transformations[i][0] = sc.next();
            transformations[i][1] = sc.next();
            sc.nextLine();
        }

        int m = sc.nextInt();

        sc.nextLine();
        for (int i = 0; i < m; i++) {
            graph.addEdge(sc.next(), sc.next(), sc.nextInt());
            sc.nextLine();
        }

        int totalWeight = 0;

        for (String[] pair : transformations) {
            String src = pair[0];
            String dest = pair[1];

            Map<String, Integer> map = graph.shortestPath(src);

            int cost = map.get(dest);
            totalWeight += cost;
        }

        System.out.println(totalWeight);
    }
}
