package dadeniVezbi.courses;

import dataStructures.CBHT;

import java.io.*;

public class ZadacaZaIspit_2 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(
                System.in));
        int N = Integer.parseInt(br.readLine());

        String rechnik[] = new String[N];
        for (int i = 0; i < N; i++) {
            rechnik[i] = br.readLine();
        }

        String tekst = br.readLine();

        //Vasiot kod tuka

        if(N == 0) {
            System.out.println(tekst);
            return;
        }

        CBHT<String, String> hashtable = new CBHT<>(N * 2);

        for (int i = 0; i < N; i++) {
            String kumZbor = rechnik[i].split(" ")[0];
            String litZbor = rechnik[i].split(" ")[1];

            hashtable.insert(kumZbor, litZbor);
        }

        String[] zboroviTekst = tekst.split(" ");

        for (int i = 0; i < zboroviTekst.length; i++) {
            Character lastChar = zboroviTekst[i].charAt(zboroviTekst[i].length() - 1);
            if (!Character.isLetterOrDigit(lastChar)) {
                if (hashtable.search(zboroviTekst[i].toLowerCase().substring(0, zboroviTekst[i].length() - 1)) != null) {
                    Character firstChar = zboroviTekst[i].charAt(0);

                    zboroviTekst[i] = hashtable.search(zboroviTekst[i].toLowerCase().substring(0, zboroviTekst[i].length() - 1)).getElement().getValue();

                    if (Character.isUpperCase(firstChar)) {
                        zboroviTekst[i] = zboroviTekst[i].substring(0, 1).toUpperCase() + zboroviTekst[i].substring(1);
                    }

                    zboroviTekst[i] += lastChar;
                }
            }

            if (hashtable.search(zboroviTekst[i].toLowerCase()) != null) {
                Character firstChar = zboroviTekst[i].charAt(0);

                zboroviTekst[i] = hashtable.search(zboroviTekst[i].toLowerCase()).getElement().getValue();

                if (Character.isUpperCase(firstChar)) {
                    zboroviTekst[i] = zboroviTekst[i].substring(0, 1).toUpperCase() + zboroviTekst[i].substring(1);
                }
            }
        }

        StringBuilder newText = new StringBuilder();

        for (int i = 0; i < zboroviTekst.length; i++) {
            newText.append(zboroviTekst[i]).append(" ");
        }

        System.out.println(newText);
    }

}
