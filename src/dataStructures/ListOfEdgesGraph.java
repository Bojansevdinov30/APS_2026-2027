package dataStructures;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class ListOfEdgesGraph<T> {

    private static class Edge<U> {
        U source;
        U destination;

        // WEIGHTED GRAPH:
        // int weight;

        public Edge(U source, U destination) {
            this.source = source;
            this.destination = destination;
        }

        /*
        // WEIGHTED GRAPH:
        public Edge(U source, U destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
        */

        public boolean involves(U vertex) {
            return source.equals(vertex) || destination.equals(vertex);
        }
    }

    private List<Edge<T>> edges;

    public ListOfEdgesGraph() {
        edges = new ArrayList<>();
    }

    // UNWEIGHTED GRAPH
    public void addEdge(T source, T destination) {
        edges.add(new Edge<>(source, destination));
    }

    /*
    // WEIGHTED GRAPH:
    public void addEdge(T source, T destination, int weight) {
        edges.add(new Edge<>(source, destination, weight));
    }
    */

    public List<Edge<T>> getEdges() {
        return edges;
    }

    public List<T> getNeighbors(T vertex) {

        List<T> neighbors = new ArrayList<>();

        for (Edge<T> edge : edges) {

            // UNDIRECTED GRAPH:
            if (edge.source.equals(vertex)) {
                neighbors.add(edge.destination);

            } else if (edge.destination.equals(vertex)) {
                neighbors.add(edge.source);
            }


            /*
            // DIRECTED GRAPH:
            // We only care about outgoing edges:
            // vertex -> destination

            if (edge.source.equals(vertex)) {
                neighbors.add(edge.destination);
            }
            */
        }

        return neighbors;
    }

    public void removeEdge(T source, T destination) {

        Iterator<Edge<T>> iterator = edges.iterator();

        while (iterator.hasNext()) {

            Edge<T> edge = iterator.next();

            // UNDIRECTED GRAPH:
            if ((edge.source.equals(source) &&
                    edge.destination.equals(destination)) ||
                    (edge.destination.equals(source) &&
                            edge.source.equals(destination))) {

                iterator.remove();
            }


            /*
            // DIRECTED GRAPH:
            // Only remove source -> destination.
            // destination -> source is a completely different edge.

            if (edge.source.equals(source) &&
                    edge.destination.equals(destination)) {

                iterator.remove();
            }
            */
        }
    }

    public void removeVertex(T vertex) {

        Iterator<Edge<T>> iterator = edges.iterator();

        while (iterator.hasNext()) {

            Edge<T> edge = iterator.next();

            if (edge.involves(vertex)) {
                iterator.remove();
            }
        }
    }


    /*
    // WEIGHTED GRAPH:
    // Returns the weight of source -> destination.
    //
    // For an UNDIRECTED graph we also check destination -> source.
    public Integer getWeight(T source, T destination) {

        for (Edge<T> edge : edges) {

            if ((edge.source.equals(source) &&
                    edge.destination.equals(destination)) ||
                    (edge.destination.equals(source) &&
                            edge.source.equals(destination))) {

                return edge.weight;
            }
        }

        return null;
    }
    */


    /*
    // DIRECTED + WEIGHTED VERSION of getWeight:
    public Integer getWeight(T source, T destination) {

        for (Edge<T> edge : edges) {

            if (edge.source.equals(source) &&
                    edge.destination.equals(destination)) {

                return edge.weight;
            }
        }

        return null;
    }
    */
}