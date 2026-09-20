package book._07_Graphs;

import dataStructures.AdjacencyListGraph;

import java.util.Scanner;

/*За дадено теме да се прикажат сите темиња кои припа´гаат на иста компонента на
сврзаност во даден граф. Темињата припа´гаат на иста компонента на сврзаност
во графот доколку постои пат поме´гу нив. На влез прво се внесува броjот на
темиња, потоа за секое теме се пишува броjот на темиња со кои е поврзано и
индексите на темињата. На краj се внесува индексот на темето за кое ´ке се бара
решението.
Пример:
Влез:
10
1 5
3 2 4 5
3 1 3 4
3 2 4 5
4 1 2 3 5
4 0 1 3 4
2 7 8
2 6 8
2 6 7
0
4
Излез: 0 1 2 3 4 5*/
public class Zadaca7_SvrzaniKomponenti {
    public static void dfs(
            AdjacencyListGraph<Integer> graph,
            int vertex,
            boolean[] visited) {

        visited[vertex] = true;

        for (Integer neighbor : graph.getNeighbors(vertex)) {
            if (!visited[neighbor]) {
                dfs(graph, neighbor, visited);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        AdjacencyListGraph<Integer> graph = new AdjacencyListGraph<>();

        for (int i = 0; i < n; i++) {
            graph.addVertex(i);
        }

        for (int i = 0; i < n; i++) {
            int numberOfNeighbors = sc.nextInt();

            for (int j = 0; j < numberOfNeighbors; j++) {
                int neighbor = sc.nextInt();
                graph.addEdge(i, neighbor);
            }
        }

        int startVertex = sc.nextInt();

        boolean[] visited = new boolean[n];

        dfs(graph, startVertex, visited);

        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                System.out.print(i + " ");
            }
        }

        sc.close();
    }
}
