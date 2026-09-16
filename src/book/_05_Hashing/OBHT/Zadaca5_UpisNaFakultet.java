package book._05_Hashing.OBHT;

import dataStructures.OBHT;

import java.io.*;

/*Секоj кандидат коj сака да се запише на факултет поднесува електронска приjа-
ва на системот за упис на Универзитетот. Потоа комисиjата за упис ги проверува
еден по еден кандидатите и нивните внесени податоци, а посебно го проверува
успехот на кандидатот од средно во апликациjата Е-Дневник (коjа содржи по-
датоци за сите ученици во сите средни училишта во Македониjа). Ваша задача
е за даден кандидат да проверите дали е валиден внесениот просек од средно
училиште во апликациjата за уписи.
Влез: Во првата линиjа е даден броj 𝑁 на кандидати кои сакаат да се запишат
на факултет. Во наредните 𝑁 линии се дадени матичните броеви на кандидатите
и просек од средно образование коj го внеле во апликациjата за уписи. Потоа
е даден броj 𝑀 на податоци во Е-Дневник. Во наредните 𝑀 линии се дадени
матичните броеви на средношколците и нивниот вистински просек од средно
образование. Во последниот ред е даден матичниот броj на кандидатот чиj просек
треба да се провери.
Излез: Да се испечати дали кандидатот со дадениот матичен броj го внел
точниот просек од средно образование („OK”), дали просекот е погрешно внесен
(„Error”) или пак кандидатот воопшто го нема во Е-Дневник („Empty”).
Пример 1:
Влез:
2
0610992333666 5.0
0901993222233 4.78
4
2205990121212 2.45
0901993222233 4.68
0610992333666 5.0
1511989984256 3.45
0901993222233
Излез:
Error
Пример 2:
Влез:
2
0610992333666 5.0
0901993222233 4.78
4
2205990121212 2.45
0901993222233 4.68
0610992333666 5.0
1511989984256 3.45
0610992333666
Излез:
OK
Пример 3:
Влез:
2
0610992333666 5.0
0901993222233 4.78
4
2205990121212 2.45
0901993222233 4.68
0610992333663 5.0
1511989984256 3.45
0610992333666
Излез:
Empty
*/
public class Zadaca5_UpisNaFakultet {
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        OBHT<String, Double> candidates = new OBHT<String, Double>(2 * N);
        String input;

        for (int i = 0; i < N; i++) {
            input = br.readLine();
            String[] p = input.split(" ");
            candidates.insert(p[0], Double.parseDouble(p[1]));
        }

        int M = Integer.parseInt(br.readLine());
        OBHT<String, Double> gradebook = new OBHT<String, Double>(2 * M);
        for (int i = 0; i < M; i++) {
            input = br.readLine();
            String[] p = input.split(" ");
            gradebook.insert(p[0], Double.parseDouble(p[1]));
        }

        String PIN = br.readLine();

        if (candidates.search(PIN) != -1) {
            if (gradebook.search(PIN) != -1) {
                if (candidates.getBucket(candidates.search(PIN)).getValue().equals(gradebook.getBucket(gradebook.search(PIN)).getValue()))
                    System.out.println("OK");
                else
                    System.out.println("Error");
            } else
                System.out.println("Empty");
        } else
            System.out.println("Empty");
    }
}
