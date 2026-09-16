package auds.auds7;

import dataStructures.CBHT;
import dataStructures.OBHT;

import java.util.HashMap;
import java.util.Scanner;

/*За различни градови дадени се мерењата на температурата (степени Целзиусови) во одредени
временски интервали. Ваша задача е за даден град да се наjде наjтоплиот период од денот.
Влез: Во првиот ред од влезот е даден броjот на мерења 𝑁 (𝑁 <= 10000), а во секоj нареден ред е
даден прво градот, потоа почеток на интервал, краj на интервал и температурата разделени со
празно место.
Во последниот ред е даден градот за коj треба да наjдете наjтопол период од денот и истиот
период да се испечати. Сложеноста на оваа операциjа треба да биде O(1).
Излез: Наjтоплиот период од денот за даден град. Да се испечати во следниов формат: G: HH:MM
– XX:YY Z, каде што G е градот, HH:MM e почетокот на интервалот, XX:YY е краjот на интервалот, а Z
e температурата во степени Целзиусови.
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
public class Zadaca5_Temperatura {
    static class Measurement {
        String name, from, to;
        double temp;

        public Measurement(String name, String from, String to, double temp) {
            this.name = name;
            this.from = from;
            this.to = to;
            this.temp = temp;
        }
    }

    static class MyKeyForOBHT implements Comparable<MyKeyForOBHT> {
        String name;

        public MyKeyForOBHT(String name) {
            this.name = name;
        }

        @Override // одлучуваме да ја користиме само државата за хеш-кодирање
        public int hashCode() {
            return name.split(",")[1].hashCode();
        }

        @Override
        public int compareTo(MyKeyForOBHT o) {
            return name.compareTo(o.name);
        }

        @Override // мора да биде имплементирано за да работи правилно CBHT/OBHT
        public boolean equals(Object obj) {
            return obj instanceof MyKeyForOBHT && this.name.equals(((MyKeyForOBHT) obj).name);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        CBHT<String, Measurement> cbht = new CBHT<>(2 * N);
        OBHT<MyKeyForOBHT, Measurement> obht = new OBHT<>(2 * N);
        HashMap<String, Measurement> hm = new HashMap<>(2 * N);
        for (int i = 0; i < N; i++) {
            Measurement m = new Measurement(sc.next(), sc.next(), sc.next(), sc.nextDouble());
            Measurement prev;
            prev = null;
            if (cbht.search(m.name) != null) prev = cbht.search(m.name).getElement().getValue();
            if (prev == null || m.temp > prev.temp) cbht.insert(m.name, m);
            prev = null;
            MyKeyForOBHT key1 = new MyKeyForOBHT(m.name);
            if (obht.search(key1) != -1) prev = obht.getBucket(obht.search(key1)).getValue();
            if (prev == null || m.temp > prev.temp) obht.insert(key1, m);
            prev = hm.get(m.name);
            if (prev == null || m.temp > prev.temp) hm.put(m.name, m);
        }
        String target = sc.next();
        Measurement m;
        m = null;
        if (cbht.search(target) != null) m = cbht.search(target).getElement().getValue();
        System.out.println(m == null ? "Not found" : m.name + ": " + m.from + " - " + m.to + " " + m.temp);
        m = null;
        MyKeyForOBHT key1 = new MyKeyForOBHT(target);
        if (obht.search(key1) != -1) m = obht.getBucket(obht.search(key1)).getValue();
        System.out.println(m == null ? "Not found" : m.name + ": " + m.from + " - " + m.to + " " + m.temp);
        m = hm.get(target);
        System.out.println(m == null ? "Not found" : m.name + ": " + m.from + " - " + m.to + " " + m.temp);
    }

}
