package book._04_OneDimensionalDataStructures.Queue;

import dataStructures.ArrayQueue;
import dataStructures.ArrayStack;

import java.io.*;

/*На една железничка станица дошло до расипување на еден воз. За да се ис-
користат вагоните кои се во функционална состоjба, потребно е да се направи
прераспределување на истите за да се добие нов воз. Откачувањето на вагони-
те од расипаниот воз се прави еден по еден од страна на последниот вагон. На
истата шина во спротивна насока поставена е новата локомотива на коjа ´ке се
прикачуваат вагоните од стариот воз кои се во функционална состоjба (прика-
чувањето секогаш се врши на последниот вагон), т.е. со оваа нова локомотива
´ке прави новиот воз. Нека вагоните на расипаниот воз се обележани со сериски
броеви, освен оние кои се во нефункционална состоjба, тие се обележани се со 0.
При формирање на новиот воз треба да се внимава вагоните да бидат сортира-
ни според сериските броеви и тоа во опа´гачки редослед, гледаj´ки од страна на
локомотивата.
За да се изврши прераспределба на вагоните се користи една помошна кружна
шина (паралелна на онаа каj што се поставени стариот и новиот воз). На оваа
помошна кружна шина вагоните се вадат по истиот редослед по коj се додаваат.
Вагоните кои излегуваат од оваа помошна шина може или да се прикачуваат на
новиот воз на краj, или на стариот воз на краj или на краjот на самата шина (т.е.
да се прередат од почеток на краj на истата шина зошто е кружна). Вагоните од
стариот воз (кои се откачуваат) може да се прикачуваат на краj на помошната
шина или на краj на новиот воз. Истото важи и за вагоните на новиот воз. Ваша
задача е да направите алгоритам коj што ´ке го формира новиот воз со вагони во
функционална состоjба.
Влез: Во влезот е даден прво се вкупниот броj на вагони на расипаниот воз.
Следно се дава во секоj нареден ред соодветно сериските броеви на вагоните од
расипаниот воз.
Излез: На излез треба да се испечати состоjбата на новиот воз со сериските
броеви (почнуваj´ки од последниот вагон).
Пример:
Влез:
30
55
100
44
33
0
0
22
5
11
8
60
4
21
90
12
56
108
404
3
0
0
22
0
110
0
6
0
17
0
71
Излез:
3 4 5 6 8 11 12 17 21 22 22 33 44 55 56 60 71 90 100 108 110 404*/
public class Zadaca3_Voz {

    public static String rearrange(String[] input) {

        ArrayStack<Integer> oldTrain =
                new ArrayStack<>(input.length);

        ArrayStack<Integer> newTrain =
                new ArrayStack<>(input.length);

        ArrayQueue<Integer> track =
                new ArrayQueue<>(input.length);

        // Put wagons on old train
        for (String value : input) {
            oldTrain.push(Integer.parseInt(value));
        }

        while (true) {

            // Remove broken wagons from the end
            while (!oldTrain.isEmpty() && oldTrain.peek() == 0) {
                oldTrain.pop();
            }

            // Nothing remains
            if (oldTrain.isEmpty() && track.isEmpty()) {
                break;
            }

            /*
             * Find the largest wagon currently in oldTrain.
             * Keep the largest one in newTrain;
             * send all others to the auxiliary track.
             */
            if (!oldTrain.isEmpty()) {

                int max = oldTrain.pop();

                while (!oldTrain.isEmpty()) {

                    int wagon = oldTrain.pop();

                    if (wagon == 0) {
                        continue;
                    }

                    if (wagon > max) {
                        track.enqueue(max);
                        max = wagon;
                    } else {
                        track.enqueue(wagon);
                    }
                }

                newTrain.push(max);
            }

            /*
             * Move wagons from the queue back to oldTrain
             * so that another pass can be performed.
             */
            while (!track.isEmpty()) {
                oldTrain.push(track.dequeue());
            }
        }

        StringBuilder result = new StringBuilder();

        while (!newTrain.isEmpty()) {

            if (result.length() > 0) {
                result.append(" ");
            }

            result.append(newTrain.pop());
        }

        return result.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = Integer.parseInt(s);
        String[] vlez = new String[n];

        for (int i = 0; i < n; i++) {
            vlez[i] = br.readLine();
        }

        System.out.println(rearrange(vlez));
        br.close();
    }

}
