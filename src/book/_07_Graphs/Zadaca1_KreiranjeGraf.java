package book._07_Graphs;

import dataStructures.AdjacencyMatrixGraph;

import java.util.Scanner;

/*Ваша задача е да креирате неориентиран нетежински граф со матрица на со-
седство, каде темињата како информациjа содржат буква. Графот го креирате
според наредбите кои се добиваат. ´Ке ви биде дадена низа од команди што можат
да бидат од следните типови:
CREATE [броj] - треба да креирате нов граф со дадениот броj на темиња.
Вредностите во темињата ´ке бидат буквите од англиската азбука, според нивниот
редослед. Така ако имате 3 темиња буквите ´ке бидат: A, B и C. ADDEDGE
[броj1] [броj2] - треба да креирате ребро ме´гу темињата со реден броj броj1 и
реден броj броj2. DELETEEDGE [броj1] [броj2] - треба да го избришете реброто
ме´гу темињата со реден броj броj1 и реден броj броj2. ADJACENT [броj1] [броj2] -
треба да испечатите 1 доколку темињата со реден броj броj1 и реден броj броj2 се
соседни, во спротивност 0. PRINTMATRIX - Треба да jа испечатите матрицата
на соседство PRINTNODE [броj] - Треба да jа испечатите информациjата (т.е.
буквата) за дадениот реден броj на теме
Во првата линиjа на влезот е даден броjот на команди кои ´ке следуваат.
Влез: Прво е даден броjот N на команди кои ´ке следуваат после креирањето
на графот. Потоа следува командата за инициjалното креирање на графот. На
краj следуваат N линии коишто ги претставуаваат командите што треба да се
извршат на креираниот празен граф граф.
Излез: Се печати излезот од оние команди кои вклучуваат некакво печатење.
Пример:
Влез:
5
CREATE 4
ADDEDGE 0 3
PRINTMATRIX
PRINTNODE 2
ADJACENT 0 2
DELETEEDGE 3 0
Излез:
0 0 0 1
0 0 0 0
0 0 0 0
1 0 0 0
C
0*/
public class Zadaca1_KreiranjeGraf {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine();

        String[] pom = sc.nextLine().split(" ");
        int brteminja = Integer.parseInt(pom[1]);
        AdjacencyMatrixGraph<Character> g = new AdjacencyMatrixGraph<Character>(brteminja);
        for (int j = 0; j < brteminja; j++)
            g.addVertex(j, (char) ((int) 'A' + j));

        for (int i = 1; i < N; i++) {
            pom = sc.nextLine().split(" ");
            switch (pom[0]) {
                case "ADDEDGE":
                    g.addEdge(Integer.parseInt(pom[1]), Integer.parseInt(pom[2]));
                    break;
                case "DELETEEDGE":
                    g.removeEdge(Integer.parseInt(pom[1]), Integer.parseInt(pom[2]));
                    break;
                case "ADJACENT":
                    System.out.println(g.isEdge(Integer.parseInt(pom[1]), Integer.parseInt(pom[2])) ? 1 : 0);
                    break;
                case "PRINTMATRIX":
                    g.printMatrix();
                    break;
                case "PRINTNODE":
                    System.out.println(g.getVertex(Integer.parseInt(pom[1])));
                    break;
                default:
                    System.out.println("Nevalidna komanda: " + pom[0]);
                    break;
            }
        }

        sc.close();

    }
}
