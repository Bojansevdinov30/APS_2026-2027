package dataStructures;

import java.util.HashMap;
import java.util.Map;

// razlikata megu HashMap i HashTable e toa sto HashMap dozvoluva null vrednost za kluc i vrednost

public class TestHashMap {
    public static void main(String[] args) {
        Map<Character, Integer> m = new HashMap<Character, Integer>();
        String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (int i = 0; i < s.length(); i++) {
            m.put(s.charAt(i), i); //се полни хеш табелата
        }
        System.out.println(m);
        //ја земаме вредноста за буквата Z
        System.out.println("The value of letter Z is " + m.get('Z'));
    }
}