package dadeniVezbi.courses;

import dataStructures.AdjacencyMatrixGraph;
import dataStructures.Edge;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Grafovi_6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        AdjacencyMatrixGraph<String> g = new AdjacencyMatrixGraph<>(n);
        Map<String, Integer> map = new HashMap<>();

        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String city = sc.nextLine();
            g.addVertex(i, city);
            map.put(city, i);
        }

        int m = sc.nextInt();

        sc.nextLine();
        for (int i = 0; i < m; i++) {
            String src = sc.next();
            String dest = sc.next();
            int weight = sc.nextInt();

            int srcId = map.get(src);
            int destId = map.get(dest);

            g.addEdge(srcId, destId, weight);

            sc.nextLine();
        }

        List<Edge> edges = g.kruskal();

        int totalWeight = 0;
        for(Edge e : edges) {
            totalWeight += e.getWeight();
        }

        System.out.println(totalWeight);
    }
}
