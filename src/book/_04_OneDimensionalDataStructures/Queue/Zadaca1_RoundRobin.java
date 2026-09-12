package book._04_OneDimensionalDataStructures.Queue;

import dataStructures.LinkedQueue;

import java.util.*;
import java.io.*;

/*
Во оперативните системи за распределување на процеси се користи распределу-
вачки алгоритам Round-Robin. Да се имплементира модифициран Round-robin
алгоритам коj што работи на следниот принцип: Сите процеси кои треба да би-
дат распределени како атрибути имаат име, време на извршување и време на
пристигнување. Алгоритамот ги распределува процесите според нивното време
на пристигнување, односно логиката на извршување е “прв доjден, прв услужен”.
Првиот процес коj ´ке биде распределен од распределувачот е оноj процес коj што
има наjмало време на пристигнување во системот. На овоj процес распределува-
чот му дава определен квантум на време за кое може да се извршува. Откако
времето ´ке заврши, ако процесот не се извршил целосно, истиот се прекинува
и притоа се менува неговото време на извршување (кое сега е првичното вре-
ме – квантумот доделен од алгоритамот RR за извршување), и овоj процес се
става последен во процесите кои чекаат за распределување. Истата постапка се
применува и за следните процеси кои чекаат за распределба. Оваа постапка се
применува с´e додека сите процеси не се извршат, односно нивното време на из-
вршување не стане 0. Доколку два процеси имаат исто време на пристигнување,
распределувачот ´ке го земе оноj процес коj што има поголемо време на извршу-
вање.
Влез: Во влезот е даден во првата линиjа цел броj N>0, коj претставува
броj на процеси кои треба да се распределуваат, a потоа се внесуваат во посебни
линии соодветно: името на процесот (стринг), времето на извршување (цел броj)
и времето на пристигнување (цел броj) за секоj од процесите. Во последната
линиjа се дава еден цел броj, коj го означува квантумот на време Т коj што
алгоритамот RR им го доделува на процесите за извршување.
Излез: На излез треба да се испечати редоследот на распределување на про-
цесите со помош на алгоритамот RR, и тоа во иста линиjа само имињата на
процесите одделени со празно место.
Пример:
Влез:
5
A 40 2
B 35 0
C 28 10
D 45 4
E 32 2
10
Излез:
B A E D C B A E D C B A E D C B A E D D
*/
public class Zadaca1_RoundRobin {

    static class Process implements Comparable<Process> {
        private String name;
        private int arrival_time, execution_time;

        public Process(String n, int at, int et) {
            this.name = n;
            this.arrival_time = at;
            this.execution_time = et;
        }

        public void updateTime(int quantum) {
            if (this.execution_time < quantum)
                this.execution_time = 0;
            else
                this.execution_time -= quantum;
        }

        public int get_arrivalTime() {
            return this.arrival_time;
        }


        public int get_executionTime() {
            return this.execution_time;
        }

        public String getName() {
            return this.name;
        }

        @Override
        public String toString() {
            return name;
        }

        @Override
        public int compareTo(Process o) {
            // TODO Auto-generated method stub
            if (this.arrival_time > o.get_arrivalTime())
                return 1;
            else if (this.arrival_time == o.get_arrivalTime()) {
                if (this.execution_time > o.get_executionTime())
                    return -1;
                else
                    return 1;

            } else
                return -1;

        }

    }


    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<Process> pList = new LinkedList<Process>();
        Process p = null;

        LinkedQueue<Process> q = new LinkedQueue<Process>();

        int N = Integer.parseInt(br.readLine());

        String input;
        for (int i = 0; i < N; i++) {
            input = br.readLine();
            String[] atrb = input.split(" ");
            int arrivalT = Integer.parseInt(atrb[2]);
            int executionT = Integer.parseInt(atrb[1]);
            p = new Process(atrb[0], arrivalT, executionT);
            pList.add(p);

        }
        int quantum = Integer.parseInt(br.readLine());

        Collections.sort(pList);
        for (int i = 0; i < N; i++) {
            //System.out.println(pList.get(i).getName());
            q.enqueue(pList.get(i));

        }

        while (!q.isEmpty()) {
            p = q.dequeue();
            p.updateTime(quantum);
            if (p.get_executionTime() != 0)
                q.enqueue(p);
            System.out.print(p.toString() + " ");

        }

    }


}
