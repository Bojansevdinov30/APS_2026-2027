package PrethodniIspitni._2022;

import dataStructures.SLL;
import dataStructures.SLLNode;

import java.util.Scanner;

// banka zadaca
public class Juni_2022_Vlezna_banka {
    static class Client {
        private final int id;
        private final int loyalty;
        private final int accounts;

        public Client(int id, int loyalty, int accounts) {
            this.id = id;
            this.loyalty = loyalty;
            this.accounts = accounts;
        }

        public int getId() {
            return id;
        }

        public int getLoyalty() {
            return loyalty;
        }

        public int getAccounts() {
            return accounts;
        }

        @Override
        public String toString() {
            return String.valueOf(id);
        }

        public int importance() {
            return loyalty * 10 + accounts * 20;
        }
    }

    public static void bank(SLL<Client> normal, SLL<Client> golden) {
        SLLNode<Client> nodeNormal = normal.getHead();
        SLLNode<Client> nodeGolden = golden.getHead();

        SLLNode<Client> nodeNormalMax = normal.getHead();
        SLLNode<Client> nodeGoldenMin = golden.getHead();

        int maxImportanceNormal = nodeNormal.getElement().importance();
        while (nodeNormal != null) {
            if (nodeNormal.getElement().importance() > maxImportanceNormal) {
                maxImportanceNormal = nodeNormal.getElement().importance();
                nodeNormalMax = nodeNormal;
            }
            nodeNormal = nodeNormal.getSucc();
        }

        int minImportanceGolden = nodeGolden.getElement().importance();
        while (nodeGolden != null) {
            if (nodeGolden.getElement().importance() < minImportanceGolden) {
                minImportanceGolden = nodeGolden.getElement().importance();
                nodeGoldenMin = nodeGolden;
            }
            nodeGolden = nodeGolden.getSucc();
        }
        golden.insertLast(nodeNormalMax.getElement());
        normal.delete(nodeNormalMax);
        normal.insertLast(nodeGoldenMin.getElement());
        golden.delete(nodeGoldenMin);
    }

    public static void main(String[] args) {
        SLL<Client> Normal = new SLL<>();
        SLL<Client> Golden = new SLL<>();

        Scanner vnesi = new Scanner(System.in);
        int n = vnesi.nextInt();
        int m = vnesi.nextInt();

        for (int i = 0; i < n; i++) {
            int id = vnesi.nextInt();
            int loyalty = vnesi.nextInt();
            int accounts = vnesi.nextInt();
            Client c1 = new Client(id, loyalty, accounts);
            Normal.insertLast(c1);
        }
        for (int j = 0; j < m; j++) {
            int id = vnesi.nextInt();
            int loyalty = vnesi.nextInt();
            int accounts = vnesi.nextInt();
            Client c2 = new Client(id, loyalty, accounts);
            Golden.insertLast(c2);
        }
        bank(Normal, Golden);
        System.out.println(Normal.toString());
        System.out.println(Golden.toString());
    }

}

