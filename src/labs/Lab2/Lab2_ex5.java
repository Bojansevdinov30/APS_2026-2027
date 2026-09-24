package labs.Lab2;

import dataStructures.SLL;
import dataStructures.SLLNode;

import java.util.Scanner;

public class Lab2_ex5 {
    static class Card {
        private int id;
        private int power;
        private int numAttacks;

        public Card(int id, int power, int numAttacks) {
            this.id = id;
            this.power = power;
            this.numAttacks = numAttacks;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getPower() {
            return power;
        }

        public void setPower(int power) {
            this.power = power;
        }

        public int getNumAttacks() {
            return numAttacks;
        }

        public void setNumAttacks(int numAttacks) {
            this.numAttacks = numAttacks;
        }

        public int damage() {
            return power * numAttacks;
        }


        @Override
        public String toString() {
            return String.valueOf(id);
        }
    }


    public static void startHeroesGame(SLL<Card> firstFriendCards, SLL<Card> secondFriendCards) {

        SLLNode<Card> firstFriendCard = firstFriendCards.getHead(),
                secondFriendCard = secondFriendCards.getHead();

        SLLNode<Card> maxDamageCard = firstFriendCards.getHead();
        int maxDamage = firstFriendCard.element.damage();


        while (firstFriendCard != null) {
            if (maxDamage < firstFriendCard.element.damage()) {
                maxDamage = firstFriendCard.element.damage();
                maxDamageCard = firstFriendCard;

            }
            firstFriendCard = firstFriendCard.succ;
        }
        firstFriendCard = firstFriendCards.getHead();

        for (int i = 0; i < 3; i++) {
            secondFriendCard = secondFriendCard.succ;
        }
        secondFriendCards.insertBefore(maxDamageCard.element, secondFriendCard);
        firstFriendCards.delete(maxDamageCard);

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SLL<Card> firstFriendCards = new SLL<Card>();
        SLL<Card> secondFriendCards = new SLL<Card>();

        for (int i = 0; i < 6; i++) {
            String line = scanner.nextLine();
            String[] parts = line.split("\\s+");
            firstFriendCards.insertLast(new Card(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2])));
        }

        for (int i = 0; i < 6; i++) {
            String line = scanner.nextLine();
            String[] parts = line.split("\\s+");
            secondFriendCards.insertLast(new Card(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2])));
        }

        startHeroesGame(firstFriendCards, secondFriendCards);
        System.out.println(firstFriendCards.toString());
        System.out.println(secondFriendCards.toString());
    }

}
