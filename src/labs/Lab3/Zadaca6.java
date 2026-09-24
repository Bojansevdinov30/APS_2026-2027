package labs.Lab3;

import java.util.Scanner;
/* Fractional Knapsack basically
Given n jobs, where each job has a duration (in hours) and an amount of money earned by completing it, find the maximum amount of money that can be earned by working for at most 40 hours.

Each job can be performed completely, but if there is not enough remaining time to complete a job, the available remaining time can be used to perform a portion of that job and earn the corresponding proportional amount of money.

Jobs should be considered in decreasing order of their earnings per hour.

Input:

An integer n, the number of jobs.
For each job, two integers: its duration and its earnings.

Output:

The maximum amount of money that can be earned in 40 hours.*/
public class Zadaca6 {
    public static class Zadaca {
        public int vremetraenje;
        public int zarabotka;

        public Zadaca(int vremetraenje, int zarabotka) {
            this.vremetraenje = vremetraenje;
            this.zarabotka = zarabotka;
        }

        public double pariPoCas() {
            return (double) zarabotka / vremetraenje;
        }
    }

    public static void sort(Zadaca[] lista) {
        for (int i = 0; i < lista.length - 1; i++) {
            for (int j = i + 1; j < lista.length; j++) {
                if (lista[i].pariPoCas() < lista[j].pariPoCas()) {
                    Zadaca temp = lista[i];
                    lista[i] = lista[j];
                    lista[j] = temp;
                }
            }
        }
    }

    public static int maxZarabotka(Zadaca[] zadaci, int n) {
        int maxVreme = 40;
        int zarabotka = 0;

        sort(zadaci);

        for (int i = 0; i < n; i++) {
            if (maxVreme >= zadaci[i].vremetraenje) {
                maxVreme -= zadaci[i].vremetraenje;
                zarabotka += zadaci[i].zarabotka;
            } else {
                zarabotka += ((double) maxVreme / zadaci[i].vremetraenje) * zadaci[i].zarabotka;
                break;
            }
        }

        return zarabotka;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Zadaca[] zadaci = new Zadaca[n];

        for (int i = 0; i < n; i++) {
            zadaci[i] = new Zadaca(sc.nextInt(), sc.nextInt());
        }

        System.out.println(maxZarabotka(zadaci, n));
    }
}

