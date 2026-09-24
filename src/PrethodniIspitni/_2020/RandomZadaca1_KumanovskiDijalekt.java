package PrethodniIspitni._2020;

import dataStructures.CBHT;
import dataStructures.MapEntry;
import dataStructures.SLLNode;

import java.io.*;

public class RandomZadaca1_KumanovskiDijalekt {
    public static void prevedi(CBHT<String, String> map, String tekst) {
        String[] split = tekst.split("\\s+");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < split.length; i++) {
            String kumanovskiZbor = split[i];

            if (kumanovskiZbor.endsWith(".") || kumanovskiZbor.endsWith(",") || kumanovskiZbor.endsWith("!") || kumanovskiZbor.endsWith("?")) {
                String zbor = kumanovskiZbor.substring(0, kumanovskiZbor.length() - 1);

                if (Character.isUpperCase(zbor.charAt(0))) {
                    SLLNode<MapEntry<String, String>> search = map.search(zbor.toLowerCase());
                    if (search == null) {
                        sb.append(kumanovskiZbor).append(" ");
                    } else {
                        String add = Character.toUpperCase(search.element.value.charAt(0)) + search.element.value.substring(1) + kumanovskiZbor.charAt(kumanovskiZbor.length() - 1);
                        sb.append(add).append(" ");
                    }
                } else {
                    SLLNode<MapEntry<String, String>> search = map.search(zbor.toLowerCase());
                    if (search == null) {
                        sb.append(kumanovskiZbor).append(" ");
                    } else {
                        String add = search.element.value + kumanovskiZbor.charAt(kumanovskiZbor.length() - 1);
                        sb.append(add).append(" ");
                    }
                }

            } else {
                SLLNode<MapEntry<String, String>> search = map.search(kumanovskiZbor.toLowerCase());
                if (search == null) {
                    sb.append(kumanovskiZbor).append(" ");
                } else {
                    if (Character.isUpperCase(kumanovskiZbor.charAt(0))) {
                        String add = Character.toUpperCase(search.element.value.charAt(0)) + search.element.value.substring(1);
                        sb.append(add).append(" ");
                    } else {
                        sb.append(search.element.value).append(" ");
                    }
                }
            }
        }
//        System.out.println(map);
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(
                System.in));
        int N = Integer.parseInt(br.readLine());

        String[] rechnik = new String[N];
        CBHT<String, String> map = new CBHT<>(rechnik.length * 2);
        for (int i = 0; i < N; i++) {
            rechnik[i] = br.readLine();
            String[] split = rechnik[i].split("\\s+");
            map.insert(split[0], split[1]);
        }

        String tekst = br.readLine();

        //Vasiot kod tuka
        if (N == 0) {
            System.out.println(tekst);
        } else {
            prevedi(map, tekst);
        }

    }
}
