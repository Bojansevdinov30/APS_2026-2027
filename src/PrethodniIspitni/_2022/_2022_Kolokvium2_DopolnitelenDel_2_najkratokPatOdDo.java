package PrethodniIspitni._2022;

import dataStructures.AdjacencyListGraph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class _2022_Kolokvium2_DopolnitelenDel_2_najkratokPatOdDo {
    public static int shortestPath(
            AdjacencyListGraph<Integer> graph,
            int S,
            int E) {

        Queue<Integer> queue = new LinkedList<>();
        HashMap<Integer, Integer> distance = new HashMap<>();

        queue.add(S);
        distance.put(S, 0);

        while (!queue.isEmpty()) {
            int current = queue.remove();

            if (current == E) {
                return distance.get(current);
            }

            for (Integer neighbor : graph.getNeighbors(current)) {

                if (!distance.containsKey(neighbor)) {
                    distance.put(neighbor, distance.get(current) + 1);
                    queue.add(neighbor);
                }
            }
        }

        return -1;
    }
}
