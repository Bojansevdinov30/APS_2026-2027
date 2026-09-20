package book._07_Graphs;

import java.util.*;

/*Боjан сака да го посети Берлин. Но, Боjан има ограничени средства, па истиот
мора да избира по коj пат е наjповолно да се движи. За таа цел, тоj изнаjмил
автомобил и купил мапа на Европа. На неа има ‘N‘ градови. Поме´гу секои два
града може да има наjмногу еден директен транспортен пат (патот е двонасочен).
За секоj од тие патишта, Боjан знае колкав броj патарини треба да се поминат
при изминување на соодветниот пат. Можете ли да му помогнете на Боjан, и
да jа откриете рутата од Скопjе до Берлин, на коj треба да се поминат наjмал
можен броj на патарини?
Влез: Во првата линиjа е запишан еден цел броj ‘N‘ (2 <= N <= 1000), коj
го означува броjот на градови. Секоj од градовите е означен со единствен броj
id - коj се движи од 1 до N. Во втората линиjа се запишани два цели броjа ‘A‘
и ‘B‘ (1 <= A, B <= N), кои ги означуваат id-ата на градовите Скопjе (А) и
Берлин (B). Во третата линиjа е запишан еден цел броj ‘M‘ (N <= M <= 1500),
коj го означува броjот на директни патишта. Во секоj од следните M редови се
запишани по три цели броjа ‘X‘, ‘Y‘ (1 <= X, Y <= N) и ‘K‘ (1 <= K <= 1000),
кои означуваат дека постои двонасочен пат од X до Y, и на истиот се нао´гаат K
патарини.
Излез: Отпечатете го бараниот наjмал можен броj на патарини.
Забелешка: Дозволено е користење на готови класи од Java API.
Пример:
Влез:
10
7 8
13
1 2 387
2 3 831
4 1 820
5 4 204
5 6 304
4 7 381
5 8 238
9 5 214
9 10 126
8 6 709
4 3 3
6 7 732
3 1 488
Излез:
823*/
public class Zadaca9_Patarini {
    static class Edge {
        int to;
        int weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static class Node implements Comparable<Node> {
        int vertex;
        int distance;

        public Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.distance, other.distance);
        }
    }

    public static int dijkstra(List<List<Edge>> graph, int start, int end) {
        int n = graph.size();

        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>();

        distance[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {

            Node current = pq.poll();

            int currentVertex = current.vertex;
            int currentDistance = current.distance;

            if (currentDistance > distance[currentVertex]) {
                continue;
            }

            if (currentVertex == end) {
                return currentDistance;
            }

            for (Edge edge : graph.get(currentVertex)) {

                int neighbor = edge.to;
                int newDistance = currentDistance + edge.weight;

                if (newDistance < distance[neighbor]) {
                    distance[neighbor] = newDistance;
                    pq.add(new Node(neighbor, newDistance));
                }
            }
        }

        return distance[end];
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int A = sc.nextInt();
        int B = sc.nextInt();

        int M = sc.nextInt();

        List<List<Edge>> graph = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {

            int X = sc.nextInt();
            int Y = sc.nextInt();
            int K = sc.nextInt();

            graph.get(X).add(new Edge(Y, K));
            graph.get(Y).add(new Edge(X, K));
        }

        System.out.println(dijkstra(graph, A, B));

        sc.close();
    }
}
