package dynamicProgramming.book;

import java.util.PriorityQueue;
import java.util.Scanner;

/*
Хафмановите кодови се тип на кодови со променлива должина, што
значи дека за претставување на некои карактери се користат повеќе,
а за некои помалку битови. Природно е колку почесто се јавува некој
знак, толку помала бит низа да се користи за негова репрезентација,
па поради тоа, Хафмановиот алчен алгоритам, за оптимална
репрезентација на знаците како бинарни стрингови, работи над
дадена табела од фреквенции на појавување на знаците. Стратегијата
е знаците со поголема фреквенција да се кодираат со кратки бит-
низи, а карактерите кои имаат мала фреквенција со долги бит-низи.
*/
public class _6_4_HafmanovKod {
    public static class Elem implements Comparable<Elem> {
        public String c;
        public int f;
        public Elem levo;
        public Elem desno;

        public Elem(String c, int f) {
            this.c = c;
            this.f = f;
        }

        public Elem(String c, int f, Elem levo, Elem desno) {
            this.c = c;
            this.f = f;
            this.levo = levo;
            this.desno = desno;
        }

        @Override
        public int compareTo(Elem elem) {
            if (this.f > elem.f) {
                return 1;
            } else if (this.f < elem.f) {
                return -1;
            } else {
                return 0;
            }
        }

        @Override
        public String toString() {
            return "(" + this.c + ", " + this.f + ")";
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        String[] E = new String[n];
        int[] f = new int[n];

        for (int i = 0; i < n; i++)
            E[i] = scn.next();

        for (int i = 0; i < n; i++)
            f[i] = scn.nextInt();

        PriorityQueue<Elem> Q = new PriorityQueue<>();
        for (int i = 0; i < n; i++)
            Q.add(new Elem(E[i], f[i]));

        for (int i = 0; i < n; i++) {
            Elem x = Q.remove();
            Elem y = Q.remove();

            System.out.println(x + " " + y);

            int fz = x.f + y.f;
            String Ez = x.c + y.c;
            Q.add(new Elem(Ez, fz, x, y));
        }
    }
}
