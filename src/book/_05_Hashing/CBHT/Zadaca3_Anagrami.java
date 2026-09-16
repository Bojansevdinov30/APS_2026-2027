package book._05_Hashing.CBHT;

import dataStructures.CBHT;
import dataStructures.MapEntry;
import dataStructures.SLLNode;

import java.io.*;
import java.util.Arrays;

/*Користеj´ки хеш табела да се групираат сите анаграми од дадена листа со зборови.
Анаграми се зборови кои се добиваат со преуредување на буквите од зборот. На
пример spar е анаграм на rasp.
Влез: Во првиот ред е даден броjот на зборови 𝑁 . Во наредните 𝑁 реда се
дадени зборовите кои треба да се додадат во табелата. Во следниот ред е даден
зборот за коj треба да се испечати броjот на анаграми во табелата.
Излез: Броjот на анаграми во табелата за дадениот збор.
Пример:
Влез:
6
eat
tea
tan
ate
nat
bat
ant
Излез:
2
*/
public class Zadaca3_Anagrami {
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        CBHT<String, Integer> hashtable = new CBHT<String, Integer>(2 * N);
        String input;

        for (int i = 1; i <= N; i++) {

            input = br.readLine();
            char[] letters = input.toCharArray();
            Arrays.sort(letters);
            String sortedLetters = new String(letters);

            if (hashtable.search(sortedLetters) == null) {
                hashtable.insert(sortedLetters, 1);
            } else {
                SLLNode<MapEntry<String, Integer>> result =
                        hashtable.search(sortedLetters);
                hashtable.insert(sortedLetters, result.getElement().getValue() + 1);

            }

        }

        String word = br.readLine();
        char[] letters = word.toCharArray();
        Arrays.sort(letters);
        String sortedLetters = new String(letters);
        SLLNode<MapEntry<String, Integer>> result = hashtable.search(sortedLetters);
        System.out.println(result.getElement().getValue());

    }
}
