package auds.auds7;

import dataStructures.OBHT;

import java.util.Scanner;

/*Во рамки на една хуманитарна организација,
потребно е да се направи статистика за крвните групи
кои се на располагање за донација, и од кои
донатори. Подгрупите А1+, А2+ припаѓаат на крвна
група А+, додека А1- , А2- припаѓаат на група А-.
Влез: Во првиот ред од влезот е даден бројот на
парови N, а во секој нареден ред се дадени паровите
(донатор, крвна група).
Излез: Да се испечати по колку донатори има од
секоја крвна група согласно внесените податоци.
Пример
Влез:
5
Alek A1+
Dejan B-
Sandra A+
Trajce 0+
Rebeka A1-
Излез:
A+ = 2
B- = 1
0+ = 1
A- = 1
*/
public class Zadaca4_CrvenKrst {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        OBHT<String, Integer> hashtable = new OBHT<String, Integer>(11);
        int N = sc.nextInt();
        for (int i = 1; i <= N; i++) {
            String name = sc.next();
            String key = sc.next().replaceAll("[1-2]", "");
            int bucket = hashtable.search(key);
            if (bucket == -1) hashtable.insert(key, 1);
            else hashtable.insert(key, hashtable.getBucket(bucket).getValue() + 1);
        }
        System.out.println(hashtable);
    }
}
