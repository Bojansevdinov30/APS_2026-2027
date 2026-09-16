package book._05_Hashing.OBHT;

import dataStructures.OBHT;

import java.io.*;
import java.text.*;
import java.util.*;

/*На семафорите низ градот, планирано е да се постават радари со камери кои ´ке
ги забележуваат возилата што возат над дозволената брзина. За таа цел, пот-
ребно е да се чуваат информации за регистарските таблички со информациите
на сопственикот на возилото (име и презиме), така што во моментот кога ´ке
биде забележана регистарската табличка на возило што jа надминало дозволе-
ната брзина, треба да се добиjат информациите за сопственикот на возилото со
сложеност O(1).
Влез: Во првиот ред е даден броjот на регистарски таблички 𝑁 . Секоjа од
следните 𝑁 линии содржи информациjа за регистарската табличка и името и
презимето на сопственикот на возилото. Во следниот ред е дадена максималната
дозволена брзина, а потоа во нов ред е даден дневниот извештаj од радарот, од-
носно, листа од возила со регистарски таблички што биле забележани од радарот,
со коjа брзина поминале и точното време, одвоени со празно место (редоследот
не е хронолошки).
Излез: Дневниот извештаj од радарот треба да се преработи, така што треба
да се добиjат информации за возачите кои направиле престап. Излезот треба да
биде во формат: име и презиме на сопствениците на возила кои jа надминале
дозволената брзина, одвоени со празно место и подредени според времето кога
радарот ги забележал.
Забелешка: За времето може да искористите некоjа од следните класи на
Java: SimpleDateFormat или Date.
Пример:
Влез:
5
SK1234AA Anita Angelovska
OH1212BE Aleksandar Antov
ST0989OO Ognen Spirovski
ST0000AB Sara Spasovska
SK8888KD Dino Ackov
50
SK8888KD 48 14:00:00 ST0000AB 55 12:00:02 ST0989OO 60 08:10:00 SK1234AA
65 20:00:10 OH1212BE 50 22:00:21
Излез:
Ognen Spirovski
Sara Spasovska
Anita Angelovska
*/
public class Zadaca6_Semafori {
    static class Driver implements Comparable<Driver> {
        String name;
        String surname;
        Date time;

        public Driver(String name, String surname, Date time) {
            this.name = name;
            this.surname = surname;
            this.time = time;
        }

        public Date getTime() {
            return time;
        }

        @Override
        public String toString() {
            return name + " " + surname;
        }

        @Override
        public int compareTo(Driver o) {

            return this.getTime().compareTo(o.getTime());
        }
    }

    public static void main(String[] args) throws IOException, ParseException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        OBHT<String, String> hashtable = new OBHT<String, String>(2 * N);

        for (int i = 0; i < N; i++) {
            String[] p = bf.readLine().split(" ");
            hashtable.insert(p[0], p[1] + " " + p[2]);
        }
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");

        int speed = Integer.parseInt(bf.readLine());
        String[] traffic = bf.readLine().split(" ");
        LinkedList<Driver> drivers = new LinkedList<Driver>();

        for (int i = 0; i < (traffic.length - 2); i += 3) {

            String plateDriver = traffic[i];
            int speedDriver = Integer.parseInt(traffic[i + 1]);
            String timeDriver = traffic[i + 2];

            if (speedDriver > speed) {
                String[] pom = hashtable.getBucket(hashtable.search((plateDriver))).getValue().split(" ");
                drivers.add(new Driver(pom[0], pom[1], formatter.parse(timeDriver)));
            }
        }

        Collections.sort(drivers);
        ListIterator<Driver> listIterator = drivers.listIterator();

        while (listIterator.hasNext()) {
            System.out.println(listIterator.next().toString());
        }
    }
}
