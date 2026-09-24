package labs.Lab7;
/*
2
23.3.3.3 10.10.10.0
192.168.1.1 20.2.2.0
3
192.168.1.1 20.3.2.0
192.168.1.1 20.2.2.1
13.13.3.3 192.2.2.2
 */

import dataStructures.CBHT;
import dataStructures.MapEntry;
import dataStructures.SLLNode;

import java.io.*;

public class Zadaca6 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        CBHT<String, String> tabela = new CBHT<>(2 * N);

        for (int i = 0; i < N; i++) {
            //mozev dva pati read line deka e sekoja vo poseben red
            String line = br.readLine();
            String[] pom = line.split(" ");
            tabela.insert(pom[0], pom[1]);
        }
        //System.out.println(tabela);

        int obidi = Integer.parseInt(br.readLine());

        for (int i = 0; i < obidi; i++) {
            String line = br.readLine();
            String[] ruter = line.split(" ");
            SLLNode<MapEntry<String, String>> pogodok = tabela.search(ruter[0]);

            String[] mreza = ruter[1].split("\\.");

            if (pogodok == null) {
                System.out.println("ne postoi");
            } else {
                String[] pogodokMreza = pogodok.element.value.split("\\.");

                String prv = mreza[0] + "." + mreza[1] + "." + mreza[2];
                String vtor = pogodokMreza[0] + "." + pogodokMreza[1] + "." + pogodokMreza[2];

                if (prv.equals(vtor)) {
                    System.out.println("postoi");
                } else {
                    System.out.println("NE postoi");
                }


            }

        }
    }

}
