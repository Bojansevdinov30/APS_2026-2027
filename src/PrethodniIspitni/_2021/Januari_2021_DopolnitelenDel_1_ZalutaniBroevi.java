package PrethodniIspitni._2021;

import java.util.ArrayList;
import java.util.Scanner;

/*Задачи од испитот за повисока оценка во јануарска сесија одржан на 10.2.2022
Време за решавање - 2H
Освен ограничувањето на сложеноста во првата задача, немаше никакви други ограничувања, беше дозволено користење на вградени класи
покрај материјалите од аудиториските.
1. Броеви- Јава:
Дадена е низа од „речиси“ сортирани броеви во растечки редослед, во смисол дека во сортирана низа има неколку залутани броеви кои се
надвор од редоследот.
Залутаните броеви се секогаш мали броеви кои се наоѓаат подесно од нивното вистинско место.
Ваша задача е да ги најдете залутаните броеви, како и бројот на места што залутаниот број треба да се помести во лево за низата
да биде сортирана.
НАПОМЕНА:Решението треба да биде имплементирано со сложеност која е помала од квадратна за да биде оценето со максимум поени.
Влез:
Во првиот ред е даден број N, големината на низата
Во наредните N редови се дадени броевите од низата.
Излез:
Во првиот ред се печати M, бројот на залутани броеви.
Во наредните M редови, се печати секој залутан број, како и бројот на места за кои треба да биде поместен во лево.
Забелешка: Залутаните броеви се растечки подредени еден во однос на друг, во смисол дека залутан број при поместување на лево нема
да премине преку друг залутан број.
Решенијата со квадратна или поголема сложеност нема да бидат оценети со максимум поени, дури и да работат целосно точно!
Пример:
input test primer1:
8
1
3
4
5
2
6
8
7
output test primer1:
2
2 3
7 1
input test primer2:
8
2
6
8
10
4
12
16
14
output test primer2:
2
4 3
14 1
Образложение:
Дадени се 8 броеви на влез. Од нив, бројот 2 и бројот 7 се надвор од своите места. Ако бројот 2 го поместиме за 3 места на лево,
а бројот 7 го поместиме за 1 место на лево, низата ќе биде во сортиран редослед.*/
public class Januari_2021_DopolnitelenDel_1_ZalutaniBroevi {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();

        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = input.nextInt();
        }

        ArrayList<Integer> normal = new ArrayList<>();

        ArrayList<Integer> strayNumbers = new ArrayList<>();
        ArrayList<Integer> displacements = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            // This number is stray
            if (i > 0 && numbers[i] < numbers[i - 1]) {

                int x = numbers[i];

                // Find first normal number greater than x
                int left = 0;
                int right = normal.size();

                while (left < right) {
                    int mid = (left + right) / 2;

                    if (normal.get(mid) <= x) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }

                // Everything from left to the end is greater than x
                int displacement = normal.size() - left;

                strayNumbers.add(x);
                displacements.add(displacement);

            } else {
                // Normal number
                normal.add(numbers[i]);
            }
        }

        System.out.println(strayNumbers.size());

        for (int i = 0; i < strayNumbers.size(); i++) {
            System.out.println(
                    strayNumbers.get(i) + " " + displacements.get(i)
            );
        }
    }
}
