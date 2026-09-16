package book._05_Hashing.OBHT;

import java.util.HashMap;
import java.util.Scanner;

/*Ваша задача е при повик од даден броj да испечатите од коjа земjа потекнува
броjот. Секоjа земjа има своj повикувачки код (за Македониjа е 389), но ко-
га го гледате броjот на екран напред има + (ако ве бара броj од Македониjа
+389XXXXXXXX). Повикувачките кодови на земjите можат да бидат едноциф-
рени, двоцифрени или троцифрени. Нека броjот на цифри на кодовите на земjите
се одредува според следните правила: Ако првата цифра на повикувачкиот код
е 1, тогаш кодот е едноцифрен и се работи за САД. Ако првата цифра е 2 тогаш
кодот е двоцифрен и ако првата цифра е 3 тогаш кодот е троцифрен.
Влез: Во првата линиjа од влезот даден е броjот на повикувачки кодови за
земjи - 𝑁 . Во следните 𝑁 линии се дадени повикувачките кодови и нивните земjи
соодветно (разделени со празно место). Во последната линиjа е даден броjот за
коj треба да одредите од коjа земjа доа´га според неговиот повикувачки код.
Излез: На излез се печати земjата за дадениот броj.
Забелешка: Сами треба да jа имплементирате хеш функциjата, како и да jа
дефинирате големината на хеш табелата.
Пример:
Влез:
12
1 SoedinetiAmerikanskiDrzavi
20 Egipet
21 Maroko
26 Zambija
351 Portugalija
355 Albanija
359 Bugarija
372 Estonija
381 Srbija
385 Hrvatska
387 BosnaiHercegovina
389 Makedonija
+2611332345678
Излез: Zambija
*/
public class Zadaca7_TelefonskiBroj {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        HashMap<String, String> countries = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String code = sc.next();
            String country = sc.next();

            countries.put(code, country);
        }

        String phone = sc.next();

        // Remove the +
        phone = phone.substring(1);

        char firstDigit = phone.charAt(0);

        int codeLength;

        if (firstDigit == '1') {
            codeLength = 1;
        } else if (firstDigit == '2') {
            codeLength = 2;
        } else {
            codeLength = 3;
        }

        String code = phone.substring(0, codeLength);

        System.out.println(countries.get(code));
    }
}
