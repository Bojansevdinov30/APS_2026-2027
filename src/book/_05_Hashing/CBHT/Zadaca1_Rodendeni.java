package book._05_Hashing.CBHT;

import dataStructures.CBHT;
import dataStructures.MapEntry;
import dataStructures.SLLNode;

import java.io.*;

/*Во заводот на статистика се прави ново истражување каде што се открива броjот
на лу´ге родени во секоj месец. Ваша задача е за даден месец да прикажете колку
лу´ге се родени во тоj месец.
Влез: Во првиот ред од влезот е даден броjот на лу´ге 𝑁 , а во секоj нареден
ред е даден датумот на ра´гање. Во последниот ред е даден месецот за коj треба
да се прикаже броjот на лу´ге родени во тоj месец.
Излез: Броj на лу´ге кои се родени во тоj месец. Доколку нема лу´ге родени
во тоj месец да се испечати „Empty”.
Пример:
Влез:
4
20.7.1976
16.7.1988
18.7.1966
5.6.1988
7
Излез: 3
*/
public class Zadaca1_Rodendeni {
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        CBHT<String, Integer> birthdays = new CBHT<>(23);

        for (int i = 0; i < N; i++) {

            String[] p = bf.readLine().split("\\.");

            //доколку елементот со клуч p[1] не постои во хеш табелата
            if (birthdays.search(p[1]) == null) {
                birthdays.insert(p[1], 1);
            } else {
                //доколку елементот со клуч p[1] постои во хеш табелата
                SLLNode<MapEntry<String, Integer>> br = birthdays.search(p[1]);
                birthdays.insert(p[1], br.getElement().getValue() + 1);
            }

        }

        String month = bf.readLine();
        SLLNode<MapEntry<String, Integer>> result = birthdays.search(month);

        //доколку не постои елемент со клуч mesec
        if (result == null) {
            System.out.println("Empty");
        } else {
            System.out.println(result.getElement().getValue());
        }

    }
}
