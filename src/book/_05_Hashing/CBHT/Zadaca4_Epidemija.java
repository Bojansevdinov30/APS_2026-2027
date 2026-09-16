package book._05_Hashing.CBHT;

import dataStructures.CBHT;
import dataStructures.MapEntry;
import dataStructures.SLLNode;

import java.io.*;

/*Поради епидемиjа на сезонски грип при секое тестирање на даден пациент се
зачувува општината во коjа живее, неговото презиме и информациjа дали е по-
зитивен или негативен на вирусот. Потребни се статистички податоци за да се
одреди ризик факторот за дадена општина. Ваша задача е за дадена општина на
излез да го испечатите ризик факторот во дадената општина. Ризик факторот
се пресметува на следниот начин:
Ризик фактор = броj на позитивни пациенти
броj на негативни пациенти + броj на позитивни пациенти
Забелешка: Можно е да се поjават пациенти со исто презиме. Истите треба
да се земат како посебни вредности во статистиката.
Влез: На влез наjпрво е даден броjот на пациенти 𝑁 , а потоа секоj пациент е
даден во нов ред во форматот: „Општина во коjа живее” „Презиме на пациент”
„Резултати од тестот(positive/negative)”. На краj е дадена општината за коjа
треба да се пресмета ризик факторот.
Излез: Децимален броj заокружен на две децимали коj го претставува ризик
факторот за дадената општина.
Пример:
Влез:
6
Centar Stojanoski negative
Centar Trajkovski positive
Centar Petkovski positive
Karpos Stojanoski positive
Karpos Trajkovski negative
Centar Trajkovski positive
Centar
Излез:
0.75
*/
public class Zadaca4_Epidemija {
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        CBHT<String, Integer> positivePatients = new CBHT<>(100);
        CBHT<String, Integer> negativePatients = new CBHT<>(100);

        for (int i = 0; i < N; i++) {
            String input[] = bf.readLine().split(" ");
            if (input[2].equals("positive")) {
                SLLNode<MapEntry<String, Integer>>
                        positiveRes = positivePatients.search(input[0]);

                if (positiveRes == null) {
                    positivePatients.insert(input[0], 1);
                } else {
                    Integer numPositive = positiveRes.getElement().getValue() + 1;
                    positivePatients.insert(input[0], numPositive);
                }

            } else {
                SLLNode<MapEntry<String, Integer>>
                        negativeRes = negativePatients.search(input[0]);

                if (negativeRes == null) {
                    negativePatients.insert(input[0], 1);
                } else {
                    Integer numNegative = negativeRes.getElement().getValue() + 1;
                    positivePatients.insert(input[0], numNegative);
                }
            }
        }

        String municipality = bf.readLine();
        SLLNode<MapEntry<String, Integer>> positiveRes = positivePatients.search(municipality);
        SLLNode<MapEntry<String, Integer>> negativeRes = negativePatients.search(municipality);

        Integer positiveCount = positiveRes.getElement().getValue();
        Integer negativeCount = negativeRes.getElement().getValue();

        System.out.println(String.format("%.2f", positiveCount * 1.00 / (negativeCount + positiveCount)));
    }
}
