package book._05_Hashing.CBHT;

import dataStructures.CBHT;
import dataStructures.MapEntry;
import dataStructures.SLLNode;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/*На еден светски познат предавач секоjдневно му пристигнуваат понуди да држи
предавања. За секоjа понуда се дадени датуми, време на почеток, градот и изно-
сот на хонорарот за предавањето (во долари). Ваша задача е за даден датум да
го прикажете предавањето кое би му донело наjголема заработка на предавачот.
Доколку нема понуди за дадениот датум да се испечати „No offers”.
Влез: Во првиот ред од влезот е даден броjот на понуди, а во секоj нареден
ред се дадени: датумот и времето на предавањето (формат dd/mm/yyyyhh:mm),
градот во коj ´ке се одржува предавањето и износот на хонорарот. Во последниот
ред е даден датумот за коj треба да испечатите коjа понуда е наjдобра за тоj
датум.
Излез: Деталите на понудата за тоj датум.
Пример:
Влез:
7
27/01/2016 14:00 NewYork 6000
28/01/2016 08:00 Paris 3000
28/01/2016 14:00 Munich 5000
27/01/2016 09:00 Beijing 8000
27/01/2016 08:00 Seattle 4000
28/01/2016 09:00 SaltLakeCity 10000
28/01/2016 09:00 Lagos 12000
27/01/2016
Излез:
09:00 Beijing 8000*/
public class Zadaca2_NajdobraPonuda {
    static class Lecture implements Comparable<Lecture> {
        String date;
        String time;
        String place;
        Integer fee;

        public Lecture(String date, String time, String place, Integer fee) {
            this.date = date;
            this.time = time;
            this.place = place;
            this.fee = fee;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getPlace() {
            return place;
        }

        public void setPlace(String place) {
            this.place = place;
        }

        public Integer getFee() {
            return fee;
        }

        public void setFee(Integer fee) {
            this.fee = fee;
        }

        @Override
        public int compareTo(Lecture obj) {
            if (this.fee > obj.fee)
                return 1;
            else if (this.fee < obj.fee)
                return -1;
            else
                return 0;
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        CBHT<String, ArrayList<Lecture>> hashtable = new CBHT<String, ArrayList<Lecture>>(2 * N);

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            Lecture p = new Lecture(input[0], input[1], input[2], Integer.parseInt(input[3]));

            if (hashtable.search(input[0]) == null) {
                ArrayList<Lecture> lectures = new ArrayList<Lecture>();
                lectures.add(p);
                hashtable.insert(input[0], lectures);
            } else {
                SLLNode<MapEntry<String, ArrayList<Lecture>>> result = hashtable.search(input[0]);
                ArrayList<Lecture> lectures = result.getElement().getValue();
                lectures.add(p);
                Collections.sort(lectures, Collections.reverseOrder());
                hashtable.insert(input[0], lectures);
            }
        }

        String date = br.readLine();
        SLLNode<MapEntry<String, ArrayList<Lecture>>> tosearch =
                hashtable.search(date); //Сложеноста на оваа операциjа е O(1)
        // бидеj´ки низата е секогаш сортирана според хонорарот во опа´гачки редослед

        if (tosearch != null) {
            System.out.println(tosearch.getElement().getValue().get(0).getTime() + " " + tosearch.getElement().getValue().get(0).getPlace()
                    + " " + tosearch.getElement().getValue().get(0).getFee());
        } else {
            System.out.println("No offers");
        }

    }

}
