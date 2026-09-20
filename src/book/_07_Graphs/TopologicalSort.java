package book._07_Graphs;

import java.util.Stack;

/*raboti samo so DAG*/
public class TopologicalSort {

    /*void dfsVisit(Stack<Integer> s, int i, boolean[] visited){
        if(!visited[i]){
            visited[i] = true;
            Iterator<GraphNode<E>> it = adjList[i].getNeighbours().iterator();
            System.out.println("dfsVisit: " + i + " Stack: " + s);
            while (it.hasNext()){
                dfsVisit(s, it.next().getIndex(), visited);
            }
            s.push(i);
            System.out.println("dfsVisit: " + i + " Stack: " + s);
        }
    }

    void topologicalSortDfs(){
        boolean[] visited = new boolean[num_nodes];
        for (int i = 0; i < num_nodes; i++) {
            visited[i] = false;
        }
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < visited.length; i++) {
            dfsVisit(s, i, visited);
        }
        System.out.println("Stack: " + s);
        while (!s.isEmpty()) {
            System.out.print(adjList[s.pop()]);
        }
    }*/
}
