package book._05_Hashing.OBHT;

import dataStructures.OBHT;

import java.io.*;

/*Во рамки на една хуманитарна организациjа, потребно е да се направи статис-
тика за крвните групи кои се на располагање за донациjа, и од кои донатори.
Подгрупите А1+, А2+ припа´гаат на крвна група А+, додека А1- , А2- припа´гаат
на група А-.
Влез: Во првиот ред од влезот е даден броjот на парови 𝑁 , а во секоj нареден
ред се дадени паровите (донатор, крвна група).
Излез: Да се испечати по колку донатори има од секоjа крвна група согласно
внесените податоци.
Пример:
Влез:
5
Alek A1+
Dejan B−
Sandra A+
Trajce 0+
Rebeka A1−
Излез:
A+=2
B−=1
0+=1
A−=1
*/
public class Zadaca1_CrvenKrst {
    public static void main(String[] args) throws IOException {
        OBHT<String, Integer> hashtable = new OBHT<String, Integer>(11);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String input;

        for (int i = 1; i <= N; i++) {

            input = br.readLine();
            String[] row = input.split(" ");
            String key = row[1];
            key = key.replaceAll("[1-2]", "");

            if (hashtable.search(key) == -1) {

                hashtable.insert(key, 1);

            } else {

                hashtable.insert(key,
                        hashtable.getBucket(hashtable.search(key)).getValue() + 1);

            }

        }

        System.out.println(hashtable);
    }
}
