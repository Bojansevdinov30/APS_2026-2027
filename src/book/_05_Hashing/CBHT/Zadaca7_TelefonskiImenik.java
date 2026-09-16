package book._05_Hashing.CBHT;

import java.io.*;
import java.util.HashMap;

/*Даден е телефонски именик од вашиот мобилен телефон. Во тоj телефонски
именик за секоj броj е дадено името на сопственикот. Некои телефони при повик
го даваат целосниот броj (заедно со повикувачкиот броj на земjата, на пример за
Македониjа +389 X XXX XXX), а некои само локалниот броj (0XX XXX XXX).
Ова значи дека ако во некои телефони броjот започнува со +389, во други би
започнувал само со 0. Ваша задача е независно од тоа како вашиот мобилен броj
го прикажува броjот да го пронаjдете сопственикот на броjот. Доколку го нема,
треба да испечатите: „Unknown number”.
Влез: Во првиот ред е даден броj на мобилни броеви 𝑁 . Во следните 𝑁 редови
се дадени броеви (во формат 0XXXXXXXX) и нивните сопственици разделени
со празно место. Во последниот ред е даден броjот за коj треба да го одредите
сопственикот.
Излез: Се печати сопственикот за дадениот броj или „Unknown number” до-
колку го нема дадениот броj во именикот.
Пример 1:
Влез:
3
070111222 IvanIvanoski
071222333 PetrePetrevski
022333444 TrajceTrajkovski
+38970111222
Излез: IvanIvanoski
Пример 2:
Влез:
3
070111222 IvanIvanoski
071222333 PetrePetrevski
022333444 TrajceTrajkovski
+38977111222
Излез: Unknown number
*/
public class Zadaca7_TelefonskiImenik {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, String> phoneBook = new HashMap<String, String>();

        int n = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            String[] token = line.split(" ");
            String phone = token[0];
            String name = token[1];
            phoneBook.put(phone, name);
        }

        String query = br.readLine();
        if (query.charAt(0) == '+') {
            query = "0" + query.substring(4); // +3890
            System.out.println(phoneBook.getOrDefault(query, "Unknown number"));
        } else System.out.println(phoneBook.getOrDefault(query, "Unknown number"));

        // Доста едноставна задача
        // „Тешкиот дел“ од задачата е да видиме на крај кога го бараме бројот
        // да видиме дали влезот почнува со +389. То ест дали почнува со +
        // ако почнува со +, значи дека нас не интересира substring од тој string
        // почнувајќи од 4ти индекс и притоа додавајќи нула на почеток за да
        // се поклопи со внесовите во хеш мапата.

    }

}
