package PrethodniIspitni._2020;

import dataStructures.AdjacencyListGraph;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*Дадени се N градови што се поврзани со N-1 патишта. Постои пат помеѓу градовите [i, i + 1], за сите i од 1 до N-1. Задачата е
да поставите поврзување за снабдување со вода на градовите. Поставете снабдување со вода во еден град и водата се транспортира од
него во други градови користејќи патен транспорт. Одредени градови се блокирани, што значи дека водата не може да помине низ тој град.
Одредете го максималниот број градови коишто може да се снабдат со вода.
Влез:
Првата линија содржи цел број N што го означува бројот на градови. Следните линии N-1 содржат два броја u и v што означува дека
постои пат меѓу градот u и градот v. Следната линија содржи N броја каде што 1 означува дека градот е блокиран, инаку е 0.
Излез:
Испечатете го максималниот број градови до кои може да се снабдува вода.
Пример:
Влез:
4
1 2
2 3
3 4
0 1 1 0
Излез:
2*/
public class Januari_2020_DopolnitelenDel_2_ {
    // WATER CANNOT MOVE THROUGH BLOCKED CITIES
    public static int dfs(
            AdjacencyListGraph<Integer> graph,
            int city,
            Set<Integer> visited,
            boolean[] blocked) {

        visited.add(city);

        int count = 1;

        for (Integer neighbor : graph.getNeighbors(city)) {

            if (!blocked[neighbor] && !visited.contains(neighbor)) {
                count += dfs(graph, neighbor, visited, blocked);
            }
        }

        return count;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int n = input.nextInt();

        AdjacencyListGraph<Integer> graph =
                new AdjacencyListGraph<>();

        for (int i = 1; i <= n; i++) {
            graph.addVertex(i);
        }

        // Roads
        for (int i = 0; i < n - 1; i++) {
            int u = input.nextInt();
            int v = input.nextInt();

            graph.addEdge(u, v);
        }

        // Blocked cities
        boolean[] blocked = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            blocked[i] = input.nextInt() == 1;
        }

        Set<Integer> visited = new HashSet<>();

        int maxCities = 0;

        for (int i = 1; i <= n; i++) {

            if (!blocked[i] && !visited.contains(i)) {

                int componentSize =
                        dfs(graph, i, visited, blocked);

                maxCities = Math.max(
                        maxCities,
                        componentSize
                );
            }
        }

        System.out.println(maxCities);
    }
}
// WATER CAN MOVE THROUGH BLOCKED CITIES
/*public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int n = input.nextInt();

        AdjacencyListGraph<Integer> graph =
                new AdjacencyListGraph<>();

        for (int i = 1; i <= n; i++) {
            graph.addVertex(i);
        }

        // Roads
        for (int i = 0; i < n - 1; i++) {
            int u = input.nextInt();
            int v = input.nextInt();

            graph.addEdge(u, v);
        }

        int suppliedCities = 0;

        // 0 = not blocked
        // 1 = blocked
        for (int i = 1; i <= n; i++) {

            int blocked = input.nextInt();

            if (blocked == 0) {
                suppliedCities++;
            }
        }

        System.out.println(suppliedCities);
    }*/