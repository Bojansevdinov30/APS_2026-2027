package book._05_Hashing.OBHT;

import java.util.HashMap;
import java.util.Scanner;

/*Еден веб домен како „courses.finki.ukim.mk” се состои од пове´ке поддомени. На
наjвисокото ниво е „mk”, потоа на следното ниво е „ukim.mk”, па „finki.ukim.mk”,
а на наjниското ниво е „courses.finki.ukim.mk”. Кога jа посетуваме страната
„courses.finki.ukim.mk”, имплицитно ги посетуваме и „finki.ukim.mk”, „ukim.mk”
и „mk”.
Треба да се изброjат посетите на дадените домени. Еден пример на броj на
посети за даден домен може да биде: „5043 courses.finki.ukim.mk” каде 5043
е броjот на посети за веб доменот „courses.finki.ukim.mk”.
Влез: На влез се добива листа (со големина 𝑁 ) во коjа се чуваат домените
и броjот на нивните посети. Потоа се читаат 𝑀 зборови за кои сакаме да го
добиеме броjот на посетите при што експлицитно ´ке се броjат посетите на сите
поддомени.
Излез: За секоj збор што се пребарува да се испечати броjот на посети од
сите поддомени. Доколку поддоменот не постои да се испечати „Not found”.
Пример 1:
Влез:
1
5043 courses.finki.ukim.mk
3
courses.finki.ukim.mk
finki.ukim.mk
ukim.mk
mk
Излез:
5043
5043
5043
5043
Поjаснување:
Имаме еден веб домен: „courses.finki.ukim.mk”. Како што е обjаснето погоре,
поддоменот „finki.ukim.mk”, „ukim.mk”, „mk” исто така ´ке бидат посетени. Затоа
сите тие ´ке бидат посетени 5043 пати.
Пример 2:
Влез:
4
900 google.mail.com
50 yahoo.com
1 intel.mail.com
5 wiki.org
5
mail.com
com
org
yahoo.com
test
Излез:
901
951
5
50
Not found
Поjаснување: Го посетуваме „google.mail.com” 900 пати, „yahoo.com” 50 па-
ти, „intel.mail.com” еднаш и „wiki.org” 5 пати. За поддомените, ´ке го посетиме
„mail.com” 900 + 1 = 901 пати, „com” ´ке го посетиме 900 + 50 + 1 = 951 пати, и
„org” 5 пати. Поддоменот „test” не постои па затоа се печати „Not found”.
*/
public class Zadaca13_WebDomeni {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        HashMap<String, Integer> visits = new HashMap<>();

        for (int i = 0; i < n; i++) {

            int count = sc.nextInt();
            String domain = sc.next();

            String current = domain;

            while (true) {

                visits.put(
                        current,
                        visits.getOrDefault(current, 0) + count
                );

                int dot = current.indexOf('.');

                if (dot == -1) {
                    break;
                }

                current = current.substring(dot + 1);
            }
        }

        int m = sc.nextInt();

        for (int i = 0; i < m; i++) {

            String query = sc.next();

            if (visits.containsKey(query)) {
                System.out.println(visits.get(query));
            } else {
                System.out.println("Not found");
            }
        }
    }
}

