package PrethodniIspitni._2022;

import dataStructures.SLL;
import dataStructures.SLLNode;

import java.util.Scanner;

public class Januari_2022_Vlezna_forum {
    static class Discussion {
        private int id;
        private int popularity;//1-100
        private int users;

        public Discussion(int id, int popularity, int users) {
            this.id = id;
            this.popularity = popularity;
            this.users = users;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getPopularity() {
            return popularity;
        }

        public void setPopularity(int popularity) {
            this.popularity = popularity;
        }

        public int getUsers() {
            return users;
        }

        public void setUsers(int users) {
            this.users = users;
        }

        @Override
        public String toString() {
            return String.valueOf(id);
        }
    }


    public static void forum(SLL<Discussion> health, SLL<Discussion> finance) {

        SLLNode<Discussion> nodeHealth = health.getHead();
        SLLNode<Discussion> nodeFinance = finance.getHead();

        SLLNode<Discussion> nodeHealthMax = health.getHead();
        SLLNode<Discussion> nodeFinanceMin = finance.getHead();

        int maxImportanceHealth =
                nodeHealth.getElement().getPopularity() * 10
                        + nodeHealth.getElement().getUsers() * 20;

        while (nodeHealth != null) {

            int importance =
                    nodeHealth.getElement().getPopularity() * 10
                            + nodeHealth.getElement().getUsers() * 20;

            if (importance > maxImportanceHealth) {
                maxImportanceHealth = importance;
                nodeHealthMax = nodeHealth;
            }

            nodeHealth = nodeHealth.getSucc();
        }

        int minImportanceFinance =
                nodeFinance.getElement().getPopularity() * 10
                        + nodeFinance.getElement().getUsers() * 20;

        while (nodeFinance != null) {

            int importance =
                    nodeFinance.getElement().getPopularity() * 10
                            + nodeFinance.getElement().getUsers() * 20;

            if (importance < minImportanceFinance) {
                minImportanceFinance = importance;
                nodeFinanceMin = nodeFinance;
            }

            nodeFinance = nodeFinance.getSucc();
        }

        finance.insertLast(nodeHealthMax.getElement());
        health.delete(nodeHealthMax);

        health.insertLast(nodeFinanceMin.getElement());
        finance.delete(nodeFinanceMin);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numHealth = Integer.parseInt(scanner.nextLine());
        int numFinance = Integer.parseInt(scanner.nextLine());

        SLL<Discussion> health = new SLL<Discussion>();
        SLL<Discussion> finance = new SLL<Discussion>();

        for (int i = 0; i < numHealth; i++) {
            String line = scanner.nextLine();
            String[] parts = line.split("\\s+");
            health.insertLast(new Discussion(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2])));
        }

        for (int i = 0; i < numFinance; i++) {
            String line = scanner.nextLine();
            String[] parts = line.split("\\s+");
            finance.insertLast(new Discussion(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2])));
        }

        forum(health, finance);
        System.out.println(health.toString());
        System.out.println(finance.toString());
    }

}
