package book._04_OneDimensionalDataStructures.Queue;

import dataStructures.ArrayQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

/*За да се организира августовскиот испит по предметот Алгоритми и податочни
структури, треба да се спроведе анкета. Во анкетата се дадени 2 избори:
1) Полагам само АПС
2) Полагам и АПС и Математика
Сите студенти сакаат да полагаат колку е можно порано, па затоа дел од
студентите лажат и во анкетата наведуваат дека истиот ден полагаат и АПС и
Математика. Асистентите го имаат вистинскиот список на студенти кои во исти-
от ден полагаат и АПС и Математика. Распределбата на студентите во термините
се прави редоследно според следните чекори:
1. Наjнапред се распределуваат студентите кои во анкетата се приjавиле дека
полагаат и АПС и Математика и тоа е навистина така (студентите не лажеле).
Редоследот по коj овие студенти се додаваат во термините е идентичен со редос-
ледот по коj jа пополниле анкетата.
2. Следно во термините се распределуваат студентите кои избрале дека по-
лагаат само АПС, по редослед идентичен со редоследот по коj jа пополниле
анкетата.
3. На краj се додаваат оние студенти кои лажеле дека полага и АПС и Мате-
матика, по редослед идентичен со редоследот по коj jа пополниле анкетата.
Влез: Во влезот е даден прво капацитетот на студенти по термин (т.е. броjот
на студенти што може да полагаат во еден термин). Следно се дава броjот и
списокот на студенти кои на анкетата пополниле дека истиот ден полагаат и АПС
и Математика (според редоследот по коj се приjавиле). Потоа се дава броjот и
списокот на останатите студенти (според редоследот по коj се приjавиле). На
краj се дава броj и список на студенти кои во истиот ден, навистина полагаат и
АПС и Математика.
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
Излез:
1
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
public class Zadaca9_Ispit_istaSoKolokvium {
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
