package PrethodniIspitni._2021;

import dataStructures.AdjacencyMatrixGraph;
import dataStructures.Edge;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/*Некоја држава одлучила да започне процес на реновирање на патишта помеѓу грдовите. Помеѓу секои два града постои пат кој или веќе е реновиран или треба да се реновира.
Притоа, за реновирањето да биде извршено побрзо, потребно е да се најдат најприоритетните патишта што треба да се реновираат,
со што сите градови би имале пристап до барем еден реновиран пат до другите градови.
Реновирањето треба да се направи по најниска можна цена.
Процесот на реновирање е веќе започнат.
Ваша задача е да се заврши тој процес, а притоа да се потрошат најмалку пари за поврзување на сите градови.

Влез:
Во првиот ред е даден бројот на градови, M.
Во вториот ред е даден бројот на патишта меѓу градовите, N
Во третиот ред е даден бројот на веќе реновирани патишта. P.
Во наредните M реда се дадени имињата на градовите.
Во следните N реда се дадени парови на имиња на градови, проследени со цел број што претставува цена на реновирање на патот меѓу тие два града.
Во последните P реда се дадени парови од градови помеѓу кои веќе постои  реновиран пат и за кои не треба ние да трошиме дополнителни пари.

Излез:
Во првиот ред се печатат два броја: бројот на патишта кои се останати да се реновираат, и цената на реновирање на тие патишта.
Потоа се печатат сите парови на градови помеѓу кои треба да бидат реновирани патиштата, секој во посебен ред.

Пример:

Влез:
5
6
3
Skopje
Kumanovo
SvetiNikole
Veles
Shtip
Skopje Veles 5
Skopje Kumanovo 3
Skopje SvetiNikole 6
Kumanovo SvetiNikole 4
Shtip Veles 4
Shtip SvetiNikole 2
Skopje SvetiNikole
Shtip SvetiNikole
Kumanovo SvetiNikole

Излез:
1 4
Veles Shtip

Објаснување:
Скопје, Свети Николе, Куманово и Штип се веќе поврзани со реновирани патишта.
Велес не е поврзан и има две опции за поврзување: кон Скопје или кон Штип.
Патот кон Штип е поевтин за реновирање, па доволно е да се реновира само тој за сите градови да бидат поврзани со барем еден реновиран пат.*/
public class Januari_2021_DopolnitelenDel_2_GradoviGraph {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int M = input.nextInt(); // number of cities
        int N = input.nextInt(); // number of roads
        int P = input.nextInt(); // already renovated roads

        AdjacencyMatrixGraph<String> graph =
                new AdjacencyMatrixGraph<>(M);

        HashMap<String, Integer> cityIndex = new HashMap<>();

        // Read cities
        for (int i = 0; i < M; i++) {
            String city = input.next();
            graph.addVertex(i, city);
            cityIndex.put(city, i);
        }

        // Read roads
        for (int i = 0; i < N; i++) {

            String city1 = input.next();
            String city2 = input.next();
            int cost = input.nextInt();

            int u = cityIndex.get(city1);
            int v = cityIndex.get(city2);

            graph.addEdge(u, v, cost);
        }

        // Initially every city is its own component
        int[] trees = new int[M];

        for (int i = 0; i < M; i++) {
            trees[i] = i;
        }

        // Add the already renovated roads to the components
        for (int i = 0; i < P; i++) {

            String city1 = input.next();
            String city2 = input.next();

            int u = cityIndex.get(city1);
            int v = cityIndex.get(city2);

            graph.union(u, v, trees);
        }

        // Run adapted Kruskal
        List<Edge> selected = graph.adaptedKruskal(trees);

        int totalCost = 0;

        for (Edge e : selected) {
            totalCost += e.getWeight();
        }

        System.out.println(selected.size() + " " + totalCost);

        for (Edge e : selected) {
            System.out.println(
                    graph.getVertex(e.getFromVertex()) + " " +
                            graph.getVertex(e.getToVertex())
            );
        }
    }
}
