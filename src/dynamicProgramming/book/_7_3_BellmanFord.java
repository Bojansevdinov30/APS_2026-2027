package dynamicProgramming.book;

import java.util.Scanner;

import java.util.*;
import java.lang.*;
import java.io.*;

class _7_3_BellmanFord {
    static class Edge {
        int src, dest, weight;

        Edge() {
            src = dest = weight = 0;
        }
    }

    int V, E;
    Edge[] edge;

    _7_3_BellmanFord(int v, int e) {
        V = v;
        E = e;
        edge = new Edge[e];
        for (int i = 0; i < e; ++i) edge[i] = new Edge();
    }

    void BellmanFord(_7_3_BellmanFord graph, int src) {
        int V = graph.V, E = graph.E;
        int[] dist = new int[V];
        for (int i = 0; i < V; ++i) dist[i] = Integer.MAX_VALUE;
        dist[src] = 0;
        for (int i = 1; i < V; ++i) {
            for (int j = 0; j < E; ++j) {
                int u = graph.edge[j].src;
                int v = graph.edge[j].dest;
                int weight = graph.edge[j].weight;
                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) dist[v] = dist[u] + weight;
            }
        }
        for (int j = 0; j < E; ++j) {
            int u = graph.edge[j].src;
            int v = graph.edge[j].dest;
            int weight = graph.edge[j].weight;
            if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                System.out.println("Grafot sodrzhi negativen ciklus.");
                return;
            }
        }
        printArr(dist, V);
    }

    void printArr(int[] dist, int V) {
        System.out.println("Rastojanie od izvorot");
        for (int i = 0; i < V; ++i) System.out.println(i + "\t\t" + dist[i]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V;
        int E;
        V = sc.nextInt();
        E = sc.nextInt();
        _7_3_BellmanFord graph = new _7_3_BellmanFord(V, E);
        for (int i = 0; i < E; i++) {
            int s = sc.nextInt();
            int d = sc.nextInt();
            int w = sc.nextInt();
            graph.edge[i].src = s;
            graph.edge[i].dest = d;
            graph.edge[i].weight = w;
        }
        graph.BellmanFord(graph, 0);
    }
}