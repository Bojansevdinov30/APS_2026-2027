package book._07_Graphs;
/*Да се имплементира тополошко сортирање на jазлите во даден граф, односно да
се подредат jазлите во графот така што сите ребра да покажуваат од лево кон
десно.*/
public class Zadaca5_TopoloskoSortiranje {
    // napisana e vo AdjacencyListGraph
    /*    public void topologicalSortBook() {
        Set<T> visited = new HashSet<>();

        Stack<T> s = new Stack<>();

        for (T vertex : adjacencyList.keySet()) {
            dfsVisit(vertex, visited, s);
        }

        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }

    private void dfsVisit(T vertex, Set<T> visited, Stack<T> s) {
        if (!visited.contains(vertex)) {
            visited.add(vertex);
            for (T v : getNeighbors(vertex)) {
                dfsVisit(v, visited, s);
            }
            s.push(vertex);
        }
    }*/
}
