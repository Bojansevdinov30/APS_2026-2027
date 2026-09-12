package book._04_OneDimensionalDataStructures.Queue;

import dataStructures.ArrayQueue;

import java.io.*;
import java.util.LinkedList;

/*Се организира прв колоквиум по предметот Алгоритми и структури на податоци.
За таа цел се отвара анкета по предметот на коjа студентите се приjавуваат.
Анкетата има дадено 2 избори:
1) Полагам во било коj термин
2) Испитот ми се преклопува со Математика
Студентите се поставуваат во термините според редоследите во кои се при-
мени (почнуваj´ки од првиот). Сите студенти сакаат да полагаат колку е можно
порано па затоа дел од студентите мамат и во анкетата наведуваат дека истиот
ден полагаат и Математика. Асистентите бараат список на студенти кои пола-
гаат Математика и добиваат. Потоа се започнува со распределба на студентите
во термини: прво во термините се доделуваат студентите кои се приjавиле дека
полагаат и Математика (по редоследот по коj се приjавиле), ме´гутоа секоj од
овие студенти се проверува дали навистина полага и Математика и ако мамел
се сместува на краj од списокот на студенти кои избрале дека полагаат било коj
термин. Потоа се изминуваат останатите студенти и се доделуваат во термини.
Влез: Во влезот е даден прво капацитетот на студенти по термин (т.е. по кол-
ку студенти во еден термин може да полагаат). Следно се дава броjот и списокот
на студенти кои истиот ден полагаат и Математика (според редоследот по коj
се приjавиле). Потоа се дава броjот и списокот на останатите студенти (според
редоследот по коj се приjавиле). На краj се дава броj и список на студенти кои
навистина полагаат Математика.
Излез: На излез треба да се испечати броj на термин, па студентите кои
полагаат во тоj термин.
Пример:
Влез:
2
4
IlinkaIvanoska
IgorKulev
MagdalenaKostoska
HristinaMihajloska
3
VladimirTrajkovik
SlobodanKalajdziski
AnastasMisev
1
IlinkaIvanoska
Излез: 1
IlinkaIvanoska
VladimirTrajkovik
2
SlobodanKalajdziski
AnastasMisev
3
IgorKulev
MagdalenaKostoska
4
HristinaMihajloska
*/
public class Zadaca4_Kolokvium {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String vlez;

        ArrayQueue<String> redMath = new ArrayQueue<String>(100);
        ArrayQueue<String> redOstanati = new ArrayQueue<String>(100);
        LinkedList<String> listRealMath = new LinkedList<String>();

        int i;
        int brStudentiTermin, brStudentiMath, brOstanati, brRealMath;

        brStudentiTermin = Integer.parseInt(br.readLine());
        brStudentiMath = Integer.parseInt(br.readLine());
        for (i = 0; i < brStudentiMath; i++) {
            vlez = br.readLine();
            redMath.enqueue(vlez);
        }

        brOstanati = Integer.parseInt(br.readLine());
        for (i = 0; i < brOstanati; i++) {
            vlez = br.readLine();
            redOstanati.enqueue(vlez);
        }

        brRealMath = Integer.parseInt(br.readLine());
        for (i = 0; i < brRealMath; i++) {
            vlez = br.readLine();
            listRealMath.add(vlez);
        }

        String elem;
        int t = 1;

        while (!redMath.isEmpty()) {
            System.out.println(t);
            for (i = 0; i < brStudentiTermin; ) {
                if (!redMath.isEmpty()) {
                    elem = redMath.peek();
                    if (!listRealMath.contains(elem))
                        redOstanati.enqueue(redMath.dequeue());
                    else {
                        elem = redMath.dequeue();
                        i++;
                        System.out.println(elem);
                    }
                } else if (!redOstanati.isEmpty()) {
                    elem = redOstanati.dequeue();
                    i++;
                    System.out.println(elem);

                } else break;

            }
            t++;
            if (redMath.isEmpty())
                break;

        }
        if (redMath.isEmpty()) {
            while (!redOstanati.isEmpty()) {
                System.out.println(t);
                for (i = 0; i < brStudentiTermin; ) {
                    if (!redOstanati.isEmpty()) {
                        elem = redOstanati.dequeue();
                        i++;
                        System.out.println(elem);

                    } else break;

                }
                t++;

            }

        }

    }
}
