package book._07_Graphs;
// implementirana e vo AdjacencyListGraph
public class bidirectionalSearch {
    /*    public boolean bidirectionalSearch(T startVertex, T endVertex) {
        if (startVertex.equals(endVertex)) {
            return true;
        }

        Set<T> visitedFromStart = new HashSet<>();
        Set<T> visitedFromEnd = new HashSet<>();

        LinkedQueue<T> queueFromStart = new LinkedQueue<>();
        LinkedQueue<T> queueFromEnd = new LinkedQueue<>();

        visitedFromStart.add(startVertex);
        queueFromStart.enqueue(startVertex);

        visitedFromEnd.add(endVertex);
        queueFromEnd.enqueue(endVertex);

        while (!queueFromStart.isEmpty() && !queueFromEnd.isEmpty()) {
            if (pathExists(queueFromStart, visitedFromStart, visitedFromEnd)) {
                return true;
            }

            if (pathExists(queueFromEnd, visitedFromEnd, visitedFromStart)) {
                return true;
            }
        }

        return false;
    }

    private boolean pathExists(Queue<T> queue, Set<T> visitedFromThisEnd, Set<T> visitedFromOtherEnd) {
        T currentVertex = queue.dequeue();

        for (T neighbor : getNeighbors(currentVertex)) {
            if (visitedFromOtherEnd.contains(neighbor)) {
                return true;
            }
            if (!visitedFromThisEnd.contains(neighbor)) {
                visitedFromThisEnd.add(neighbor);
                queue.enqueue(neighbor);
            }
        }

        return false;
    }*/
}
