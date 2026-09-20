package auds.auds10;

import dataStructures.AdjacencyMatrixGraph;
import dataStructures.LinkedStack;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
Совршен лавиринт е лавиринт во кој има само еден пат
од една точка до било која друга.

Да се генерира граф и со DFS да се најде патеката
од S до E.
*/
public class Zadaca1_SovrsenLavirint {

    static AdjacencyMatrixGraph<Integer> graph;

    static int start;
    static int end;

    // coordinate -> vertex number
    static Map<String, Integer> map = new HashMap<>();


    private static void generateGraph(int rows, int columns, String[] in) {

        int nrNodes = 0;

        // 1. Give every free cell a vertex number
        for (int i = 1; i < rows - 1; i++) {

            for (int j = 1; j < columns - 1; j++) {

                if (in[i].charAt(j) != '#') {

                    String key = i + ", " + j;

                    map.put(key, nrNodes);

                    if (in[i].charAt(j) == 'S') {
                        start = nrNodes;
                    }

                    if (in[i].charAt(j) == 'E') {
                        end = nrNodes;
                    }

                    nrNodes++;
                }
            }
        }


        graph = new AdjacencyMatrixGraph<>(nrNodes);


        // IMPORTANT:
        // getNeighbors() returns vertex DATA,
        // so we must initialize the vertices.
        for (int i = 0; i < nrNodes; i++) {
            graph.addVertex(i, i);
        }


        // 2. Connect neighboring free cells
        for (int i = 1; i < rows - 1; i++) {

            for (int j = 1; j < columns - 1; j++) {

                if (in[i].charAt(j) != '#') {

                    String x = i + ", " + j;

                    // LEFT
                    if (in[i].charAt(j - 1) != '#') {

                        String y = i + ", " + (j - 1);

                        graph.addEdge(
                                map.get(x),
                                map.get(y)
                        );
                    }

                    // RIGHT
                    if (in[i].charAt(j + 1) != '#') {

                        String y = i + ", " + (j + 1);

                        graph.addEdge(
                                map.get(x),
                                map.get(y)
                        );
                    }

                    // UP
                    if (in[i - 1].charAt(j) != '#') {

                        String y = (i - 1) + ", " + j;

                        graph.addEdge(
                                map.get(x),
                                map.get(y)
                        );
                    }

                    // DOWN
                    if (in[i + 1].charAt(j) != '#') {

                        String y = (i + 1) + ", " + j;

                        graph.addEdge(
                                map.get(x),
                                map.get(y)
                        );
                    }
                }
            }
        }
    }


    private static void findPath() {

        Set<Integer> visited = new HashSet<>();

        // child -> parent
        Map<Integer, Integer> parent = new HashMap<>();

        LinkedStack<Integer> stack = new LinkedStack<>();

        stack.push(start);
        visited.add(start);

        boolean found = false;

        while (!stack.isEmpty()) {

            int vertex = stack.pop();

            if (vertex == end) {
                found = true;
                break;
            }

            for (int neighbor : graph.getNeighbors(vertex)) {

                if (!visited.contains(neighbor)) {

                    visited.add(neighbor);

                    parent.put(neighbor, vertex);

                    stack.push(neighbor);
                }
            }
        }


        if (!found) {
            System.out.println("Ne postoi pateka.");
            return;
        }


        // Reconstruct path:
        // end -> parent -> parent -> ... -> start

        LinkedStack<Integer> path = new LinkedStack<>();

        int current = end;

        while (current != start) {

            path.push(current);

            current = parent.get(current);
        }

        path.push(start);


        while (!path.isEmpty()) {
            System.out.print(path.pop() + " ");
        }
    }


    public static void main(String[] args) {

        int rows = 6;
        int columns = 6;

        String[] in = new String[rows];

        in[0] = "######";
        in[1] = "# # ##";
        in[2] = "# # S#";
        in[3] = "# # ##";
        in[4] = "# E  #";
        in[5] = "######";

        generateGraph(rows, columns, in);

        System.out.println("Pateka:");

        findPath();

        System.out.println();
    }
}
// nivna verzija
/*import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Maze {

    int start;
    int end;
    Graph graph;
    Map<String, Integer> map;    // 1,1 -> 0

    public Maze() {
        map = new HashMap<>();
    }

    private void generateGraph(int rows, int columns, String[] in) {
        int totalNodes = 0;

        for (int i = 1; i < rows - 1; i++) {
            for (int j = 1; j < columns - 1; j++) {
                if (in[i].charAt(j) != '#') {
                    String key = i + "," + j;
                    map.put(key, totalNodes);

                    if (in[i].charAt(j) == 'S') start = totalNodes;
                    if (in[i].charAt(j) == 'E') end = totalNodes;

                    totalNodes++;
                }
            }
        }
        graph = new Graph(totalNodes);

        for (int i = 1; i < rows - 1; i++) {
            for (int j = 1; j < columns - 1; j++) {
                if (in[i].charAt(j) != '#') {
                    if (in[i].charAt(j - 1) != '#') {
                        String x = i + "," + j;
                        String y = i + "," + (j - 1);
                        graph.addEdge(map.get(x), map.get(y));
                    }
                    if (in[i].charAt(j + 1) != '#') {
                        String x = i + "," + j;
                        String y = i + "," + (j + 1);
                        graph.addEdge(map.get(x), map.get(y));
                    }
                    if (in[i - 1].charAt(j) != '#') {
                        String x = i + "," + j;
                        String y = (i - 1) + "," + j;
                        graph.addEdge(map.get(x), map.get(y));
                    }
                    if (in[i + 1].charAt(j) != '#') {
                        String x = i + "," + j;
                        String y = (i + 1) + "," + j;
                        graph.addEdge(map.get(x), map.get(y));
                    }
                }
            }
        }
    }

    private void findPath() {
        boolean visited[] = new boolean[graph.num_nodes];
        for (int i = 0; i < graph.num_nodes; i++)
            visited[i] = false;

        visited[start] = true;
        Stack<Integer> s = new Stack<Integer>();
        s.push(start);
        int pom;

        while (!s.isEmpty() && s.peek() != end) {
            pom = s.peek();
            int pom1 = pom;
            for (int i = 0; i < graph.num_nodes; i++) {
                if (graph.adjacent(pom, i) == 1) {
                    pom1 = i;
                    if (!visited[i]) break;
                }
            }
            if (!visited[pom1]) {
                visited[pom1] = true;
                s.push(pom1);
            } else
                s.pop();
        }

        Stack<Integer> path = new Stack<>();
        while (!s.isEmpty())
            path.push(s.pop());

        while (!path.isEmpty())
            System.out.println(path.pop());
    }

    public static void main(String args[]) {
        Maze m = new Maze();
        int rows = 6;
        int columns = 6;
        String[] in = new String[rows];

        in[0] = "######";
        in[1] = "# # ##";
        in[2] = "# # S#";
        in[3] = "# # ##";
        in[4] = "# E  #";
        in[5] = "######";

        m.generateGraph(rows, columns, in);
        System.out.println("Pateka:");
        m.findPath();
    }
}*/