package book._05_Hashing.OBHT;

import dataStructures.OBHT;

import java.io.*;
import java.util.ArrayList;

/*Дадени се мерења на PM10 честички за населбите во Скопjе. Ваша задача е за
дадена населба да jа наjдете просечната концентрациjа на PM10 честички.
Влез: Во првиот ред од влезот е даден броjот на мерења, а во секоj наре-
ден ред се дадени населбата и концентрациjата на PM10 честички разделени со
празно место. Во последниот ред е дадена населбата за коjа треба да наjдете
просечна концентрациjа на PM10 честички.
Излез: Просечната концентрациjа на PM10 честички за дадената населба
(заокружена на 2 децимали, притоа прво нао´гате просечна концентрациjа, па
заокружувате).
Пример:
Влез:
8
Centar 319.61
Karposh 296.74
Centar 531.98
Karposh 316.44
GaziBaba 384.05
GaziBaba 319.3
Karposh 393.37
GaziBaba 326.42
Karposh
Излез:
355.52*/
public class Zadaca2_KvalitetNaVozduh {
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        OBHT<String, ArrayList<Double>> hashtable = new OBHT<String, ArrayList<Double>>(2 * N);
        String input;

        for (int i = 1; i <= N; i++) {

            input = br.readLine();
            String[] row = input.split(" ");
            String neighbourhood = row[0];
            String pm10 = row[1];
            ArrayList<Double> list = new ArrayList<Double>();

            if (hashtable.search(neighbourhood) == -1) {
                list.add(Double.parseDouble(pm10));
                hashtable.insert(neighbourhood, list);
            } else {
                list = hashtable.getBucket(hashtable.search(neighbourhood)).getValue();
                list.add(Double.parseDouble(pm10));
                hashtable.insert(neighbourhood, list);
            }

        }

        String neighbourhoodSearch = br.readLine();
        ArrayList<Double> result = hashtable.getBucket(hashtable.search(neighbourhoodSearch)).getValue();
        double sum = 0;
        if (result.size() > 0) {
            for (int i = 0; i < result.size(); i++) {
                sum += result.get(i);
            }

            System.out.printf("%.2f", sum / result.size());
        } else {
            System.out.println("No info");
        }

    }
}

