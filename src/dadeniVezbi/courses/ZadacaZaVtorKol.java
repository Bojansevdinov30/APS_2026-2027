package dadeniVezbi.courses;

import dataStructures.AdjacencyListGraph;

import java.util.Scanner;

public class ZadacaZaVtorKol {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int q = sc.nextInt();

        AdjacencyListGraph<Integer> graph = new AdjacencyListGraph<>();

        for(int i = 0; i < q; i++) {
            graph.addEdge(sc.nextInt(), sc.nextInt());
        }

        int k = sc.nextInt();

        graph.DFS(k);
    }

}
