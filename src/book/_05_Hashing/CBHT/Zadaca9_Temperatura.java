package book._05_Hashing.CBHT;

import dataStructures.CBHT;
import dataStructures.MapEntry;
import dataStructures.SLLNode;

import java.io.*;

/*
За различни градови дадени се мерењата на температурата (степени Целзиусо-
ви) во одредени временски интервали. Ваша задача е за даден град да се наjде
наjтоплиот период од денот.
Влез: Во првиот ред од влезот е даден броjот на мерења 𝑁 (𝑁 <= 10000),
а во секоj нареден ред е даден прво градот, потоа почеток на интервал, краj на
интервал и температурата разделени со празно место. Во последниот ред е даден
градот за коj треба да наjдете наjтопол период од денот и истиот период да се
испечати. Сложеноста на оваа операциjа треба да биде O(1).
Излез: Наjтоплиот период од денот за даден град. Да се испечати во след-
ниов формат: G: HH:MM – XX:YY Z, каде што G е градот, HH:MM e почетокот
на интервалот, XX:YY е краjот на интервалот, а Z e температурата во степени
Целзиусови.
Пример:
Влез:
4
Ohrid,Macedonia 10:00 12:00 23.1
Skopje,Macedonia 09:00 10:30 24
Ohrid,Macedonia 12:00 13:00 25
Skopje,Macedonia 10:00 11:00 26.2
Ohrid,Macedonia
Излез:
Ohrid,Macedonia: 12:00 - 13:00 25.0
*/
public class Zadaca9_Temperatura {
    static class Period {
        String start;
        String end;
        double temperature;

        public Period(String start, String end, double temperature) {
            this.start = start;
            this.end = end;
            this.temperature = temperature;
        }

        @Override
        public String toString() {
            return start + " - " + end + " " + temperature;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        CBHT<String, Period> table = new CBHT<>(2 * n);

        for (int i = 0; i < n; i++) {

            String[] parts = br.readLine().split(" ");

            String city = parts[0];
            String start = parts[1];
            String end = parts[2];
            double temperature = Double.parseDouble(parts[3]);

            SLLNode<MapEntry<String, Period>> node = table.search(city);

            if (node == null) {
                // First measurement for this city
                table.insert(city, new Period(start, end, temperature));
            } else {
                Period currentHottest = node.getElement().getValue();
                if (temperature > currentHottest.temperature) {
                    table.insert(city, new Period(start, end, temperature));
                }
            }
        }

        String wantedCity = br.readLine();

        SLLNode<MapEntry<String, Period>> result = table.search(wantedCity);

        if (result != null) {
            System.out.println(wantedCity + ": " + result.getElement().getValue());
        }
    }
}
