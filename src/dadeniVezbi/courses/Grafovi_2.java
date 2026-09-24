package dadeniVezbi.courses;

import dataStructures.AdjacencyListGraph;

import java.util.Scanner;

public class Grafovi_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        AdjacencyListGraph<String> graph = new AdjacencyListGraph<>();

        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String name = sc.nextLine();
            graph.addVertex(name);
        }

        int m = sc.nextInt();

        sc.nextLine();
        for (int i = 0; i < m; i++) {
            String names = sc.nextLine();
            String name1 = names.split(" ")[0];
            String name2 = names.split(" ")[1];
            graph.addEdge(name1, name2);
        }
        System.out.println(graph.findGroups());
    }

}
