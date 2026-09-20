package auds.auds10;

import dataStructures.AdjacencyMatrixGraph;
import dataStructures.Edge;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/*При обилни врнежи настануваат поплави со кои се оштетуваат
патиштата. Оштетувањата можат да бидат одрони, поплавени
патишта или срушени мостови. Во таков случаj патната мрежа во
една држава станува дисконектирана и задача на соодветните
служби е што е можно побрзо да обезбедат поврзаност на сите
градови помеѓу себе. Оштетувањата на патиштата не се од иста
категориjа на сериозност, т.е. за секое од оштетувањата е потребно
различно време за патот да се санира и да се направи прооден.
Поради обемот на штетите и итноста на поправка, ве´ке е
започнато воспоставување на поврзаноста и дел од патиштата се
санирани. Но, со цел оптимизациjа на процесот, на нас ни е
доделена задачата да наjдеме приоритетни патишта кои треба да
се санираат со цел сите градови да бидат поврзани поме´гу себе со
наjмалку еден пат.
Влез: Во првиот ред е даден броjот на градови, M. Во вториот ред
е даден броjот на патишта ме´гу градовите, N. Во третиот ред е
даден броjот на ве´ке санирани патишта. P. Во наредните M реда
се дадени имињата на градовите. Во следните N реда се дадени
парови на имиња на градови, проследени со цел броj што
претставува време кое е проценето дека е потребно за да се
расчисти- /санира делницата ме´гу тие два града. Во последните P
реда се дадени парови од градови каде е завршена санациjата на
патиштата (пред да ни го дадат проблемот на нас) и тие се ве´ке
проодни.
Излез: Во првиот ред се печатат два броjа: броjот на патишта кои
се останати да се санираат, и времето потребно за санациjа на тие
патишта. Потоа се печатат сите парови на градови поме´гу кои
треба да бидат поправени патиштата, секоj во посебен ред.*/
public class Zadaca3_Poplava {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();
        int N = sc.nextInt();
        int P = sc.nextInt();
        sc.nextLine();

        HashMap<String, Integer> map = new HashMap<String, Integer>();
        AdjacencyMatrixGraph<String> cityNetwork = new AdjacencyMatrixGraph<>(M);
        int[] trees = new int[M];

        for (int i = 0; i < M; i++) {
            String city = sc.nextLine();
            map.put(city, i);
            cityNetwork.addVertex(i, city);
            trees[i] = i + 1;
        }
        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            String[] parts = line.split(" ");
            cityNetwork.addEdge(map.get(parts[0]), map.get(parts[1]), Integer.parseInt(parts[2]));
        }

        for (int i = 0; i < P; i++) {
            String line = sc.nextLine();
            String[] parts = line.split(" ");

            int city1 = map.get(parts[0]);
            int city2 = map.get(parts[1]);

            cityNetwork.union(city1, city2, trees);
        }

        sc.close();

        List<Edge> resultEdges = cityNetwork.adaptedKruskal(trees);

        float suma = 0;
        for (Edge e : resultEdges) {
            suma += e.getWeight();
        }
        System.out.println(resultEdges.size() + " " + suma);
        for (Edge e : resultEdges) {
            System.out.println(cityNetwork.getVertex(e.getFromVertex()) + cityNetwork.getVertex(e.getToVertex()));
        }
    }
}
