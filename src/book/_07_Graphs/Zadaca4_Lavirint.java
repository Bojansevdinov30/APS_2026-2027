package book._07_Graphs;

import dataStructures.AdjacencyListGraph;

import java.util.Scanner;

/*Нека е даден еден совршен лавиринт, односно лавиринт коj има само еден пат
од една точка на лавиринтот до било коjа друга. Нека лавиринтот биде даден во
следната форма (како влез од карактери).
6,6
######
# # ##
# # S#
# # ##
# E #
######
Првите 2 броjки се димензиите на лавиринтот, а потоа следува самиот лави-
ринт. Во лавиринтот секое поле е означено со даден знак. Доколку знакот е ’#’,
тоа значи дека на тоа поле од лавиринтот не смее да се стапнува, а на сите други
полиња може да се оди. Полето означено со ’S’ е стартното поле, односно полето
од каде што треба да се почне со изминување, додека полето означено со ’E’ е
краjното поле на изминување.
Треба да се наjде единствениот пат од полето ’S’ до полето ’E’.*/
public class Zadaca4_Lavirint {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String tmp = sc.nextLine();
        String parts[] = tmp.split(",");

        int m = Integer.parseInt(parts[0]);
        int n = Integer.parseInt(parts[1]);

        String lines[] = new String[m];

        AdjacencyListGraph<String> mazeGraph = new AdjacencyListGraph<>();

        String startVertex ="", endVertex="";
        for (int i = 0; i < m; i++) {
            lines[i] = sc.next();

            for (int j = 0; j < n; j++) {
                if (lines[i].charAt(j) != '#') {
                    mazeGraph.addVertex(i + "," + j);

                    if (lines[i].charAt(j) == 'S') {
                        startVertex = i + "," + j;
                    } else if (lines[i].charAt(j) == 'E') {
                        endVertex = i + "," + j;
                    }
                    if (i > 0 && lines[i - 1].charAt(j) != '#') {
                        mazeGraph.addEdge((i - 1) + "," + j, i + "," + j);
                    }
                    if (j > 0 && lines[i].charAt(j - 1) != '#') {
                        mazeGraph.addEdge(i + "," + (j - 1), i + "," + j);
                    }
                }
            }
        }

        sc.close();

        mazeGraph.findPath(startVertex, endVertex);
    }
}
