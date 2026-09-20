package book._07_Graphs;

import dataStructures.AdjacencyListGraph;

import java.util.Scanner;

/*Во земjата Лапониjа живее Дедо Мраз. Во слободното време кога не е Нова
Година, додека џуџињата си работат на играчките за следната година, Дедо Мраз
има хоби. Тоj сака да одгледува рибички. Но тоj своите рибички ги одгледува во
природни езера. Езерата се ме´гусебно поврзани со рекички, и рекичките течат
од едно езерце до друго. Рибите од едно езеро слободно можат преку рекичките
да отидат во друго езеро. Секоjа пролет дедо мраз сака да прави порибување на
езерцата со нови рибички. Ваша задача е да му кажете на Дедо Мраз доколку тоj
пушти нови рибички во езерцето X, во колку други езерца ´ке можат рибичките
сами да стигнат, а со тоа да нема потреба тоj самиот да ги порибува тие езерца.
Влез: Во првата линиjа од влезот е даден броj N < 15 броjот на езерца. Во
втората линиjа е даден броj U < 20 броjот на реки ме´гу езерцата. Во следните
U линии се дадени парови од 2 броjа R и Q, што значи постои рекичка коjа тече
од R до Q, каде R и Q се броеви на езерцата. Во последната линиjа е даден броj
L, во кое езерце Дедо Мраз ´ке ги пушти рибичките.
Излез: Се испишува броjот, колку езерца освен почетното ´ке бидат порибени.
Пример:
Влез: 11 19 3 3 7 8 7 3 1 7 0 0 7 2 6 3 2 0 0 9 6 10 1 2 2 8 5 7 4 3 10 4 3 9 7 10
9 4 4 10 7
Излез: 7*/
public class Zadaca8_DedoMraz {
    public static void dfs(AdjacencyListGraph<Integer> graph,
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

        int N = sc.nextInt();
        int U = sc.nextInt();

        AdjacencyListGraph<Integer> graph = new AdjacencyListGraph<>();

        for (int i = 0; i < N; i++) {
            graph.addVertex(i);
        }

        for (int i = 0; i < U; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();

            graph.addEdge(from, to); // TODO: pazi tuka mora za orientiran da gledas, a ne za neorientiran
        }

        int L = sc.nextInt();

        boolean[] visited = new boolean[N];

        dfs(graph, L, visited);

        int count = 0;

        for (int i = 0; i < N; i++) {
            if (visited[i] && i != L) {
                count++;
            }
        }

        System.out.println(count);

        sc.close();
    }
}
