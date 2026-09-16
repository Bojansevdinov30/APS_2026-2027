package book._05_Hashing.CBHT;

import dataStructures.CBHT;
import dataStructures.MapEntry;
import dataStructures.SLLNode;

import java.io.*;

/*Во магацинот на една фармацевтска компаниjа се чуваат наjразлични видови
лекови. За секоj лек потребно е да се чуваат податоци за името на лекот, цената
во денари и намената на лекот. За поефикасен пристап до податоците за лековите,
фармацевската компаниjа одлучила податоците да ги чува во една хеш табела
каде се сместуваат соодветните податоци.
Хеш табелата е достапна до краjните клиенти и истите може да пребаруваат
низ внесените податоци. Бидеj´ки на пазарот постоjат пове´ке лекови кои таргети-
раат иста болест, наjчесто клиентите го бараат оноj лек коj има наjниска цена.
Па вашата задача е со користење на хеш табелата, за дадена намена (болест), да
го испечатите лекот коj има наjниска цена на пазарот.
Влез: Наjпрво е даден броjот на лекови - 𝑁 , а потоа секоj лек е даден во нов
ред во форматот:
Име на лек@Намена@Цена во денари
На краj е дадена намената за коjа треба да се пронаjде лекот со наjниска
цена.
Излез: Името на лекот со наjмала цена.
Пример:
Влез:
5
Analgin@Headache@80
Daleron@Headache@90
Spazmeks@Stomachache@120
Lineks@Stomachache@150
Loratidin@Allergy@150
Headache
Излез:
Analgin
*/
public class Zadaca12_Magacin {
    static class Medicine {
        String name;
        int price;

        public Medicine(String name, int price) {
            this.name = name;
            this.price = price;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        CBHT<String, Medicine> table = new CBHT<>(2 * n);

        for (int i = 0; i < n; i++) {

            String[] parts = br.readLine().split("@");

            String name = parts[0];
            String purpose = parts[1];
            int price = Integer.parseInt(parts[2]);

            SLLNode<MapEntry<String, Medicine>> node =
                    table.search(purpose);

            if (node == null) {
                // First medicine for this purpose
                table.insert(
                        purpose,
                        new Medicine(name, price)
                );
            } else {
                Medicine cheapest = node.getElement().getValue();

                if (price < cheapest.price) {
                    table.insert(
                            purpose,
                            new Medicine(name, price)
                    );
                }
            }
        }

        String wantedPurpose = br.readLine();

        SLLNode<MapEntry<String, Medicine>> result =
                table.search(wantedPurpose);

        if (result != null) {
            System.out.println(result.getElement().getValue().name);
        }
    }
}
