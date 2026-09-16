package book._05_Hashing.CBHT;

import java.io.*;
import java.util.*;

/*Во заводот на статистика се прави ново истражување каде што се открива за-
висноста на месецот на ра´гање со имињата на лу´гето родени во тоj месец. Ваша
задача е за даден месец да ги прикажете сите различни имиња на лу´ге родени
во тоj месец.
Влез: Во првиот ред од влезот е даден броjот на лу´ге 𝑁 (𝑁 <= 10000), а
во секоj нареден ред се дадени името на човекот и датумот на неговото ра´гање,
разделени со празно место. Во последниот ред е даден месецот за коj треба да
се прикажат сите различни имиња на лу´гето родени во тоj месец.
Излез: Листа со различни имиња на лу´ге родени во дадениот месец. Доколку
нема лу´ге родени во тоj месец да се испечати „Empty”.
Пример 1:
Влез:
4
Ivan 20.7.1976
Ivan 16.7.1988
Ana 18.7.1966
Ivan 5.6.1988
7
Излез:
Ivan Ana
Пример 2:
Влез:
4
Vesna 13.4.2015
Katerina 12.3.1945
Milan 14.2.1996
Olja 13.2.1988
1
Излез: Empty
*/
public class Zadaca8_Rodendeni2 {
    public static void main (String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer, ArrayList<String>> monthsAndNames = new HashMap<>();

        int n = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            String[] tokens = line.split(" ");
            String name = tokens[0];
            String dateOfBirth = tokens[1];
            int month = Integer.parseInt(dateOfBirth.split("\\.")[1]); // уште splitting
            if (!monthsAndNames.containsKey(month)) {
                monthsAndNames.put(month, new ArrayList<>());
                monthsAndNames.get(month).add(name);
            } else if (!monthsAndNames.get(month).contains(name)) monthsAndNames.get(month).add(name);
            // само ако го нема името стави го
        }

        int month = Integer.parseInt(br.readLine().trim());
        if (!monthsAndNames.containsKey(month)) System.out.println("Empty");
        else for (String name : monthsAndNames.get(month)) System.out.print(name + " ");

        // Во задачата клучен збор е „различни“ имиња. Доколку постои веќе името во низата
        // не го додавам. Го додавам само ако не постои веќе во низата
        // Кога го читам влезот, прво правам едно делење на стрингот,
        // па на dateOfBirth, правам уште едно делење.
    }

}
