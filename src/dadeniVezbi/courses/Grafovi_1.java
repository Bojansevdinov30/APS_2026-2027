package dadeniVezbi.courses;

import dataStructures.AdjacencyListGraph;

import java.util.Scanner;

public class Grafovi_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        AdjacencyListGraph<String> graph = new AdjacencyListGraph<>();

        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String building = sc.nextLine();
            graph.addVertex(building);
        }

        int m = sc.nextInt();

        sc.nextLine();
        for (int i = 0; i < m; i++) {
            String fromTo = sc.nextLine();
            String from = fromTo.split(" ")[0];
            String to = fromTo.split(" ")[1];

            graph.addEdge(from, to);
        }

        System.out.println(graph.findConnectedCities());
    }
}


