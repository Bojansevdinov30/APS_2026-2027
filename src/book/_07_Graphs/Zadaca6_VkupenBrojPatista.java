package book._07_Graphs;

import dataStructures.AdjacencyListGraph;

import java.util.Scanner;

/*Да се испечати вкупниот броj на патишта со должина N кои почнуваат од некое
фиксно теме V во неориентиран нетежински граф. Влез: Во првиот ред е даден
броjот на jазли, во вториот ред е даден броjот на ребра, а потоа во следните
редови се дадени ребрата во графот. Во претпоследниот ред се дадени темето V
и во последниот ред, должината N на патиштата. Излез: Испечатете го вкупниот
броj на патишта со должина N. Jазлите во патот можат да се повторуваат.
Пример:
Влез:
4 5 0 1 1 2 2 3 0 2 1 3 3 2
Излез: 6
Во дадениот пример, постоjат 6 патишта - 3 2 1, 3 2 3, 3 2 0, 3 1 0, 3 1 2 и 3 1
3, кои почнуваат од jазолот 3 и имаат должина 2*/
public class Zadaca6_VkupenBrojPatista {
    public static int countPaths(
            AdjacencyListGraph<Integer> graph,
            int vertex,
            int length) {

        if (length == 0) {
            return 1;
        }

        int count = 0;

        for (Integer neighbor : graph.getNeighbors(vertex)) {
            count += countPaths(graph, neighbor, length - 1);
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int vertices = sc.nextInt();
        int edges = sc.nextInt();

        AdjacencyListGraph<Integer> graph = new AdjacencyListGraph<>();

        for (int i = 0; i < vertices; i++) {
            graph.addVertex(i);
        }

        for (int i = 0; i < edges; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();

            graph.addEdge(from, to);
        }

        int V = sc.nextInt();
        int N = sc.nextInt();

        System.out.println(countPaths(graph, V, N));

        sc.close();
    }
}
