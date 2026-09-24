package PrethodniIspitni._2023;

import dataStructures.ArrayQueue;
import dataStructures.ArrayStack;

import java.io.*;

public class RandomZadaca6_trikSoKarti {
    public static int count(int N){
        // Vasiot kod tuka
        ArrayQueue<Integer> deck = new ArrayQueue<>(51);
        for (int i = 1; i <= 51; i++) {
            deck.enqueue(i);
        }
        int ctr = 0;
        ArrayStack<Integer> stack = new ArrayStack<>(7);
        while (deck.peek() != N){
            for (int i = 0; i < 7; i++) {
                stack.push(deck.dequeue());
            }
            while(!stack.isEmpty()){
                deck.enqueue(stack.pop());
                deck.enqueue(deck.dequeue());
            }
            ctr++;
        }
        return ctr;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in) );
        System.out.println(count(Integer.parseInt(br.readLine())));
    }
}
