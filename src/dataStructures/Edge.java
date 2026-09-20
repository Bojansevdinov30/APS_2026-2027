package dataStructures;

public class Edge {
    private int fromVertex, toVertex;
    private int weight;
    public Edge(int fromVertex, int toVertex, int weight) {
        this.fromVertex = fromVertex;
        this.toVertex = toVertex;
        this.weight = weight;
    }

    public int getFromVertex() {
        return fromVertex;
    }

    public int getToVertex() {
        return toVertex;
    }

    public int getWeight() {
        return weight;
    }

    public void setFromVertex(int fromVertex) {
        this.fromVertex = fromVertex;
    }

    public void setToVertex(int toVertex) {
        this.toVertex = toVertex;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

}

