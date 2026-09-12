package book._04_OneDimensionalDataStructures.Queue;

import dataStructures.ArrayQueue;

import java.util.ArrayList;
import java.util.Scanner;

/*Се организира колоквиумска недела на ФИНКИ и за таа цел асистентите се до-
делуваат за чување на испити. За таа цел се прави редица од асистентите во коjа
на почеток се наjмладите асистенти, а на краj се наjвозрасните. Потоа се даваат
предметите и по колку асистенти се потребни за чување на секоj предмет. Има
некои асистенти кои се отсутни во тековната колоквиумска недела. Затоа допол-
нително се дава список кои од асистентите се отсутни. Асистентите се доделуваат
на следниот начин: Прво се доделуваат наjмладите, а на краj наjстарите, со тоа
што ако некоj асистент е отсутен тоj се игнорира во редицата. После секое доде-
лување на предмет асистентот се сместува на краj на редицата (т.е. ако на секоj
асистент му се доделил за чување предмет, а има потреба од уште асистенти,
повторно се започнува од наjмладите).

Влез: Во влезот е даден прво броjот на асистенти и имињата на асистентите
од наjмлад до наjстар. Следно се дава броjот на предмети за кои се потребни
асистенти, па се наведуваат предметите и по колку асистенти се потребни за
секоj предмет. Потоа се дава броjот на асистенти кои се отсутни и списокот на
тековно отсутните асистенти.

Излез: На излез треба да се испечати предмет, па асистенти задолжени за
чување на тоj предмет (за секоj од дадените предмети).

Пример:
Влез:
4
IlinkaIvanoska
IgorKulev
MagdalenaKostoska
HristinaMihajloska
3
APS 3
MIS 1
OOS 2
1
HristinaMihajloska
Излез:
APS
3
IlinkaIvanoska
IgorKulev
MagdalenaKostoska
MIS
1
IlinkaIvanoska
OOS
2
IgorKulev
MagdalenaKostoska
*/
public class Zadaca7_KolokviumskaNedela {
    public static class Polaganje {
        private String name;
        private int nrAssistants;

        public Polaganje(String name, int nrAssistants) {
            this.name = name;
            this.nrAssistants = nrAssistants;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getNrAssistants() {
            return nrAssistants;
        }

        public void setNrAssistants(int nrAssistants) {
            this.nrAssistants = nrAssistants;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        ArrayQueue<String> assistants = new ArrayQueue<>(n);
        for (int i = 0; i < n; i++) {
            assistants.enqueue(input.next());
        }
        int m = input.nextInt();
        ArrayList<Polaganje> polaganja = new ArrayList<>(m);
        for (int i = 0; i < m; i++) {
            polaganja.add(new Polaganje(input.next(), input.nextInt()));
        }
        int o = input.nextInt();
        ArrayList<String> abscent = new ArrayList<>(o);
        for (int i = 0; i < o; i++) {
            abscent.add(input.next());
        }
        for(Polaganje p : polaganja) {
            int i =0;
            System.out.println(p.getName());
            System.out.println(p.getNrAssistants());
            while(i < p.getNrAssistants()){
                String assistant = assistants.peek();
                if(abscent.contains(assistant)){
                    assistants.dequeue();
                    continue;
                }
                System.out.println(assistant);
                assistant = assistants.dequeue();
                assistants.enqueue(assistant);
                i++;
            }
        }

    }
}
