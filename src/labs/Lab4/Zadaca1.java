package labs.Lab4;

import dataStructures.ArrayQueue;

import java.util.Scanner;

/* Библиотека е посетена од студентите со цел да изнајмат еден или повеќе типови книги. Дадена книга може да
    припаѓа на една од трите категории: Наука, научна фантастика, историја. Кога библиотеката ќе започне со работа
    се услужуваат студенти од сите три типа ПАРАЛЕЛНО, но исто така сите три шалтера не одат со иста брзина па
    услужувањето е со следниот редослед: ДВА студента што бараат книга од тип НАУКА, ЕДЕН студент што бара книга од
    тип НАУЧНА ФАНТАСТИКА, ДВА студента што бараат книга од тип ИСТОРИЈА. Доколку студент чека ред за книги од
    различпен тип, тој чека првин во редицата за книга од тип НАУКА, потоа во редицата за книга од тип
    НАУЧНА ФАНТАСТИКА, и на крај во редицата за книга од тип ИСТОРИЈА (во зависност ако ги бара овие книги за
    позајмување).
    Влез: Во првата линија е даден број на студенти кои имаат дојдено во библиотека да позајмат книга. Потоа 4 редици
     се внесуваат за секој студент, каде првата линија е име на студентот, а во останатите 3 редици се внесува дали
     студентот ќе позајми книга од даден тип (Наука, Научна фантастика и Историја соодветно), каде 1 значи дека има
     за цел да ја позајми книгата од тој тип, а 0 значи дека нема да позајми книга од тој тип.

    Пример:
    Иван Ивановски
    1
    1
    0
    значи дека студентот Иван Ивановски има за цел да позајми книга од тип Наука и тип Научна фантастика, но нема за
    цел да позајми книга од тип Историја.
    Излез: Испечати го редоследот на студентите по редослед како завршуваат со позајмување на сите книги.  */
public class Zadaca1 {
    static class Student {
        String ime;
        int p, i, s;

        public Student(String ime, int p, int i, int d) {
            this.ime = ime;
            this.p = p;
            this.i = i;
            this.s = d;
        }

        int getP() {
            return p;
        }

        int getI() {
            return i;
        }

        int getS() {
            return s;
        }

        String getIme() {
            return ime;
        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        ArrayQueue<Student> nauka = new ArrayQueue<>(100);
        ArrayQueue<Student> fantastika = new ArrayQueue<>(100);
        ArrayQueue<Student> istorija = new ArrayQueue<>(100);
        int n = input.nextInt();
        for (int i = 0; i < n; i++) {
            input.nextLine();
            String ime = input.nextLine();
            int count = 0;
            int na = input.nextInt();
            if (na == 1) count++;
            int fa = input.nextInt();
            if (fa == 1) count++;
            int is = input.nextInt();
            if (is == 1) count++;
            Student tmp = new Student(ime, na, fa, is);
            if (count == 1) {
                if (na == 1) {
                    nauka.enqueue(tmp);
                } else if (fa == 1) {
                    fantastika.enqueue(tmp);
                } else istorija.enqueue(tmp);
            } else if (count == 2) {
                if (na == 1 && fa == 1 && is == 0) {
                    nauka.enqueue(tmp);
                } else if (na == 1 && is == 1 && fa == 0) {
                    nauka.enqueue(tmp);
                } else if (na == 0 && fa == 1 && is == 1) {
                    fantastika.enqueue(tmp);
                }
            } else {
                nauka.enqueue(tmp);
            }
        }
        //dotuka se vnesuvaat studentite, i vo redicite
        /*ДВА студента што бараат книга од тип НАУКА, ЕДЕН студент што бара книга од
          тип НАУЧНА ФАНТАСТИКА, ДВА студента што бараат книга од тип ИСТОРИЈА. */
        while (!nauka.isEmpty() || !fantastika.isEmpty() || !istorija.isEmpty()) {
            if (!nauka.isEmpty()) {
                Student tmp = nauka.dequeue();
                if (tmp.getI() == 1) {
                    fantastika.enqueue(tmp);
                } else if (tmp.getS() == 1) {
                    istorija.enqueue(tmp);
                } else {
                    System.out.println(tmp.getIme());
                }
            }
            if (!nauka.isEmpty()) {
                Student tmp2 = nauka.dequeue();
                if (tmp2.getI() == 1) {
                    fantastika.enqueue(tmp2);
                } else if (tmp2.getS() == 1) {
                    istorija.enqueue(tmp2);
                } else {
                    System.out.println(tmp2.getIme());
                }
            }
            if (!fantastika.isEmpty()) {
                Student tmp3 = fantastika.dequeue();
                if (tmp3.getS() == 1) {
                    istorija.enqueue(tmp3);
                } else {
                    System.out.println(tmp3.getIme());
                }
            }
            if (!istorija.isEmpty()) {
                Student tmp4 = istorija.dequeue();
                System.out.println(tmp4.getIme());
            }
            if (!istorija.isEmpty()) {
                Student tmp5 = istorija.dequeue();
                System.out.println(tmp5.getIme());
            }
        }
    }
}
