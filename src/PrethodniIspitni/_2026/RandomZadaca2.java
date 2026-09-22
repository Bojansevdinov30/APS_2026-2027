package PrethodniIspitni._2026;

import dataStructures.LinkedQueue;

import java.util.Scanner;

public class RandomZadaca2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        int zafateni = 0;
        LinkedQueue<String> kju = new LinkedQueue<>();
        for (int i = 0; i < n; i++) {
            String izraz = sc.nextLine();
            String[] delovi = izraz.split(" ");
            String komanda = delovi[0];
            String broj = "";
            if (delovi.length > 1) {
                broj = delovi[1];
            }

            if (komanda.equals("call")) {
                kju.enqueue(broj);
            }
            if (komanda.equals("start")) {
                zafateni++;
                kju.dequeue();
            }
            if (komanda.equals("end")) {
                zafateni--;
            }
            if (komanda.equals("status")) {
                System.out.println("status: " + "\n" + "busy operatos: " + zafateni + "\n" +
                        "clients waiting: " + kju.size());
            }
        }
    }
    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        sc.nextLine();

        Deque<String> clients = new ArrayDeque<>();
        int busyOperators = 0;

        for(int i = 0; i < n; i++) {
            String input = sc.nextLine();
            String[] inputs = input.split(" ");

            if(inputs[0].equals("call"))
                clients.addLast(inputs[1]);
            else if(inputs[0].equals("start")) {
                clients.removeFirst();
                busyOperators++;
            }
            else if(inputs[0].equals("end"))
                busyOperators--;
            else if(inputs[0].equals("status")) {
                System.out.println("busy operators: " + busyOperators);
                System.out.println("clients waiting: " + clients.size());
            }
        }
    }*/
}
