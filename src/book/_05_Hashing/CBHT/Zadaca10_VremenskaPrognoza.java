package book._05_Hashing.CBHT;

import dataStructures.CBHT;
import dataStructures.MapEntry;
import dataStructures.SLLNode;

import java.io.*;
import java.util.LinkedList;

/*За различни градови дадени се мерењата на температурата (степени Целзиусови)
во одредени временски интервали. Ваша задача е за даден град да се прикаже
листа од сите температурни мерења. Притоа, ако се случи при внес два интер-
вали да се исти, тогаш се зема средната вредност од измерените температури во
интервалите.
Влез: Во првиот ред од влезот е даден броjот на мерења 𝑁 (𝑁 <= 10000),
а во секоj нареден ред е даден прво градот, потоа почеток на интервал, краj на
интервал и температурата разделени со празно место. Во последниот ред е даден
градот за коj треба да се испечати соодветнота информациjа.
Излез: Листата од мерењата за даден град. Да се испечати во следниов фор-
мат:
G:
HH:MM – XX:YY Z
HH:MM – XX:YY Z
...
каде што G е градот, HH:MM e почетокот на интервалот, XX:YY е краjот на
интервалот, а Z e температурата во степени Целзиусови.
Пример 1:
Влез:
4
Ohrid 10:00 12:00 23.1
Skopje 09:00 10:30 24
Ohrid 12:00 13:00 25
Skopje 10:00 11:00 26.2
Ohrid
Излез:
Ohrid:
10:00 - 12:00 23.10
12:00 - 13:00 25.00
Пример 2:
Влез:
4
Ohrid 10:00 12:00 23.1
Skopje 09:00 10:30 24
Ohrid 12:00 13:00 25
Skopje 10:00 11:00 26.2
Strumica
Излез:
Strumica: does not exist
*/
public class Zadaca10_VremenskaPrognoza {
    static class Measurement {
        String start;
        String end;
        double averageTemperature;
        int count;

        public Measurement(String start, String end, double temperature) {
            this.start = start;
            this.end = end;
            this.averageTemperature = temperature;
            this.count = 1;
        }

        public boolean sameInterval(String start, String end) {
            return this.start.equals(start) && this.end.equals(end);
        }

        public void addTemperature(double temperature) {
            averageTemperature =
                    (averageTemperature * count + temperature) / (count + 1);

            count++;
        }

        @Override
        public String toString() {
            return String.format(
                    "%s - %s %.2f",
                    start,
                    end,
                    averageTemperature
            );
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        CBHT<String, LinkedList<Measurement>> table =
                new CBHT<>(2 * n);

        for (int i = 0; i < n; i++) {

            String[] parts = br.readLine().split("\\s+");

            String city = parts[0];
            String start = parts[1];
            String end = parts[2];
            double temperature = Double.parseDouble(parts[3]);

            SLLNode<MapEntry<String, LinkedList<Measurement>>> node =
                    table.search(city);

            // First measurement for this city
            if (node == null) {

                LinkedList<Measurement> measurements =
                        new LinkedList<>();

                measurements.add(
                        new Measurement(start, end, temperature)
                );

                table.insert(city, measurements);

            } else {

                LinkedList<Measurement> measurements =
                        node.getElement().getValue();

                boolean found = false;

                for (Measurement m : measurements) {

                    if (m.sameInterval(start, end)) {
                        m.addTemperature(temperature);
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    measurements.add(
                            new Measurement(start, end, temperature)
                    );
                }
            }
        }

        String wantedCity = br.readLine();

        SLLNode<MapEntry<String, LinkedList<Measurement>>> result =
                table.search(wantedCity);

        if (result == null) {
            System.out.println(wantedCity + ": does not exist");
        } else {

            System.out.println(wantedCity + ":");

            for (Measurement m : result.getElement().getValue()) {
                System.out.println(m);
            }
        }
    }

}
