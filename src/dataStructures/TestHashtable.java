package dataStructures;

import java.util.Hashtable;

// koristi gi ako ti se dadeni od niv
// razlika megu HashMap i TreeMap e toa sto TreeMap gi cuva sortirani po klucot

public class TestHashtable {
    public static void main(String[] args) {
        Hashtable<Character, Integer> m =
                new Hashtable<Character, Integer>();
        String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (int i = 0; i < s.length(); i++) {
            m.put(s.charAt(i), i); //се полни хеш табелата
        }
        System.out.println(m);
        //ја земаме вредноста за буквата Z
        System.out.println("The value of letter Z is " + m.get('Z'));
    }

}