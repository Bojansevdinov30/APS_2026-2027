package auds.auds7;

import dataStructures.CBHT;
import dataStructures.MapEntry;
import dataStructures.SLLNode;

import java.util.Scanner;

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
public class Zadaca3_NajdobraPonuda {
    static class Lecture {
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
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        // Клуч: датумот во стринг формат
        // Хеш функција: дефолтната хеш функција за String класата од Java
        // Вредност: Предавање со максимална заработка
        CBHT<String, Lecture> hashtable = new CBHT<String, Lecture>(2 * N);
        for (int i = 0; i < N; i++) {
            Lecture p = new Lecture(sc.next(), sc.next(), sc.next(), sc.nextInt());
            if (hashtable.search(p.getDate()) == null) {
                hashtable.insert(p.getDate(), p);
            } else {
                SLLNode<MapEntry<String, Lecture>> best_for_date = hashtable.search(p.getDate());
                Lecture best_lecture_for_date = best_for_date.getElement().getValue();
                if (p.getFee() > best_lecture_for_date.getFee())
                    hashtable.insert(p.getDate(), p);
            }
        }
        String date = sc.next();
        SLLNode<MapEntry<String, Lecture>> result = hashtable.search(date);
        if (result != null) {
            Lecture best = result.getElement().getValue();
            System.out.println(best.getTime() + " " + best.getPlace() + " " + best.getFee());
        } else {
            System.out.println("No offers");
        }
    }
}
