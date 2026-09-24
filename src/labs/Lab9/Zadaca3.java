package labs.Lab9;

import dataStructures.AdjacencyListGraph;

import java.util.Scanner;

// zadacata so poplaveni gradovi
public class Zadaca3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        AdjacencyListGraph<String> graph = new AdjacencyListGraph<>();

        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String cities = sc.nextLine();
            String city1 = cities.split(" ")[0];
            String city2 = cities.split(" ")[1];

            graph.addEdge(city1, city2);
        }

        int m = sc.nextInt();

        sc.nextLine();
        for(int i = 0; i < m; i++) {
            String cities = sc.nextLine();
            String city1 = cities.split(" ")[0];
            String city2 = cities.split(" ")[1];

            graph.removeEdge(city1, city2);
        }

        System.out.println(graph.findConnectedCities());
    }

}
