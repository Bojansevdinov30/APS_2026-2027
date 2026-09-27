package labs.Lab10;

import dataStructures.AdjacencyListGraph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*Група на луѓе сака да сподели некоја информација. Дадени се парови на луѓе кои се познаваат. Да се одреди колку најмалку време е потребно
за сите луѓе да ја дознаат информацијата почнувајќи од било кој човек, ако за споделување помеѓу било кој пар на луѓе е потребно исто време.
Ако не е можно сите луѓе да ја дознаат информацијата, вратете -1.
Влез: Во првиот ред е даден бројот на луѓе N. Во следните N редови се дадени имињата на луѓето. Потоа е даден бројот на познанства M,
а во следните M редови се дадени имињата на луѓето што се познаваат. Потребно е да го избришете бројот на познанства.
Излез:  Најмалиот број на чекори потребни за сите луѓе да ја дознаат информацијата. Ако не е можно сите луѓе да ја дознаат информацијата,
вратете -1.
Пример:
Влез:
7
Alice
Bob
Charlie
Frank
George
David
Eve
6
Alice Bob
Bob Charlie
Charlie Frank
Frank George
Charlie David
David Eve
Излез: 2*/
public class Zadaca6 {
    public static int bfs(AdjacencyListGraph<String> graph, String start, int n) {

        Queue<String> queue = new LinkedList<>();
        HashMap<String, Integer> distance = new HashMap<>();
        queue.add(start);
        distance.put(start, 0);
        while (!queue.isEmpty()) {
            String current = queue.remove();
            for (String neighbor : graph.getNeighbors(current)) {
                if (!distance.containsKey(neighbor)) {
                    distance.put(neighbor, distance.get(current) + 1);
                    queue.add(neighbor);
                }
            }
        }

        // If we did not reach everybody
        if (distance.size() != n) {
            return -1;
        }

        // Find the farthest person from start
        int maximumDistance = 0;

        for (int d : distance.values()) {
            maximumDistance = Math.max(maximumDistance, d);
        }

        return maximumDistance;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        AdjacencyListGraph<String> graph = new AdjacencyListGraph<>();
        // Read people
        for (int i = 0; i < n; i++) {
            String person = input.next();
            graph.addVertex(person);
        }
        int m = input.nextInt();
        // Read acquaintances
        for (int i = 0; i < m; i++) {
            String person1 = input.next();
            String person2 = input.next();
            graph.addEdge(person1, person2);
        }
        int answer = Integer.MAX_VALUE;
        // Try every person as the starting person
        for (String person : graph.getAdjacencyList().keySet()) {
            int result = bfs(graph, person, n);
            if (result == -1) {
                System.out.println(-1);
                return;
            }
            answer = Math.min(answer, result);
        }
        System.out.println(answer);
    }
}
