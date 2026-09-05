package auds.auds1;

import dataStructures.SLL;
import dataStructures.SLLNode;

import java.util.Scanner;

// Zadaca 4 - vnesi iminja, po obraten redosled ispecati gi.
public class Auds1_ex4 {

    public static void main(String[] args) {
        SLL<String> names = new SLL<String>();
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();

        while (!line.equals("KRAJ")) {
            if (Character.isUpperCase(line.charAt(0))) {
                names.insertFirst(line);
            }
            line = input.nextLine();
        }

        System.out.println("Broj na vneseni validni iminja: " + names.size());

        SLLNode<String> temp = names.getHead();
        while (temp != null) {
            System.out.println(temp.getData());
            temp = temp.getNext();
        }
    }
}
