package PrethodniIspitni._2025;

import dataStructures.AdjacencyListGraph;

import java.util.*;

public class VtorKolokvium_2025_DopolnitelenDel_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        AdjacencyListGraph<String> graph = new AdjacencyListGraph<>();

        for (int i = 0; i < n; i++) {
            String node = sc.nextLine();
            graph.addVertex(node);
        }

        int m = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < m; i++) {
            String[] tokens = sc.nextLine().split("\\s+");
            graph.addEdge(tokens[0], tokens[1]);
        }

        System.out.println(isBipartite(graph) ? "YES" : "NO");
    }

    public static boolean isBipartite(AdjacencyListGraph<String> graph) {
        Set<String> visited = new HashSet<>();
        Map<String, Integer> color = new HashMap<>();
        Queue<String> queue = new LinkedList<>();

        for (String vertex : graph.getAdjacencyList().keySet()) {
            if (!visited.contains(vertex)) {
                queue.add(vertex);
                color.put(vertex, 1);
                visited.add(vertex);

                while (!queue.isEmpty()) {
                    String currentVertex = queue.poll();
                    int currentColor = color.get(currentVertex);
                    int neighborColor = currentColor == 1 ? 2 : 1;

                    for (String neighbor : graph.getNeighbors(currentVertex)) {
                        if (!visited.contains(neighbor)) {
                            visited.add(neighbor);
                            color.put(neighbor, neighborColor);
                            queue.add(neighbor);
                        } else if (color.get(neighbor) != neighborColor) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

//AdjacencyListGraph
}
