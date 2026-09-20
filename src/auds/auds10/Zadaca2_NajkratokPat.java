package auds.auds10;

import dataStructures.AdjacencyListGraph;

import java.util.Map;
import java.util.Scanner;

/*Дадена е една мапа со патишта меѓу градови во
Македонија. За секој пат се знае должината на
патот. Да се најде должината на минималниот
пат од Скопје до друг град кој се вчитува на влез.
Влез: Во првиот ред е даден бројот на патишта.
Потоа во секој нареден ред се дадени градовите
кои ги поврзува тој пат и неговата должина. Во
последниот ред е даден градот до кој треба да
се пресмета минималната должина на пат.
Излез: Должината на минималниот пат од Скопје
до градот во последниот ред од влезот.*/
public class Zadaca2_NajkratokPat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        AdjacencyListGraph<String> graph = new AdjacencyListGraph<>();
        for (int i = 0; i < n; i++) {
            graph.addEdge(sc.next(), sc.next(), sc.nextInt());
        }
        Map<String, Integer> paths = graph.shortestPath("Skopje");
        System.out.println(paths.get(sc.next()));
    }
}
