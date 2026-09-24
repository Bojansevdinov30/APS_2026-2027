package labs.Lab10;

import dataStructures.AdjacencyListGraph;

import java.util.*;

public class Zadaca5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine();

        Map<String, Integer> moduleTime = new HashMap<>();
        AdjacencyListGraph<String> graph = new AdjacencyListGraph<>();
        for (int i = 0; i < N; i++) {
            String[] input = sc.nextLine().split(" ");
            String moduleName = input[0];
            int time = Integer.parseInt(input[1]);
            moduleTime.put(moduleName, time);
            graph.addVertex(moduleName);
        }

        int M = sc.nextInt();
        sc.nextLine();

        Map<String, List<String>> prerequisites = new HashMap<>();
        for (String module : moduleTime.keySet()) {
            prerequisites.put(module, new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            String[] dependency = sc.nextLine().split(" ");
            String dependent = dependency[0];
            String prerequisite = dependency[1];
            graph.addEdge(prerequisite, dependent);
            prerequisites.get(dependent).add(prerequisite);
        }

        List<String> topoOrder = graph.topologicalSort();

        Map<String, Integer> compileTime = new HashMap<>();
        int totalTime = 0;

        for (String module : topoOrder) {
            int maxPrerequisiteTime = 0;

            for (String prerequisite : prerequisites.get(module)) {
                maxPrerequisiteTime = Math.max(maxPrerequisiteTime, compileTime.get(prerequisite));
            }

            compileTime.put(module, maxPrerequisiteTime + moduleTime.get(module));
            totalTime = Math.max(totalTime, compileTime.get(module));
        }

        System.out.println(totalTime);
    }

}
