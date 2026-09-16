package book._05_Hashing.CBHT;

import dataStructures.CBHT;
import dataStructures.MapEntry;
import dataStructures.SLLNode;

import java.io.*;

/*Потребно е да се направи компjутерска апликациjа коjа ´ке му овозможи на ко-
рисникот брзо да пребарува низ базата на податоци на Заводот за статистика за
застапеност на имиња (машки и женски). Начинот на коj се пребарува е следен:
прво се внесува какво име ´ке пребарува, машко или женско, после тоа доволно е
да се внесат првите 2 букви од името за да може да се излистаат женските/маш-
ките имиња кои ги има во системот. Како резултат од пребарувањето треба да
се врати честотата на поjавување за даденото име. При секое евидентирање на
новороденче неговото име се запишува во базата на заводот за статистика. До-
колку името постои, се менува само броjот на застапеност, а доколку не постои,
се додава како ново.
Влез: Од стандарден влез прво се чита броj 𝑁 коj претставува броj на имиња
кои ´ке бидат внесени во системот. Во наредните 𝑁 редови се дадени имињата на
новороденчињата и од коj пол се (М за машки и F за женски) разделени со
празно место. Во наредниот ред е даден полот по коj ´ке се пребарува, а потоа се
дадени имињата кои се пребаруваат, секое во нов ред. За означување на краj е
даден зборот „END”.
Излез: На стандарден излез треба да се испечати за секоj од влезовите след-
ната информациjа: Листа на имиња кои ги дава начинот на пребарување како
сугестиjа, секое во нов ред. Доколку постои името во хеш табелата се печати во
нов ред ПОЛ ИМЕ ЗАСТАПЕНОСТ разделени со по едно празно место. Доколку
името не е пронаjдено се печати „No such name”.
Забелешка: Функциjата со коjа се врши мапирање на имињата во броj е
следна:
ℎ(𝑤) = (100 * ASCII(𝑐1) + ASCII(𝑐2))%9091, каде зборот 𝑤 = 𝑐1𝑐2𝑐3𝑐4𝑐5 . . . е
составен само од големи букви.
Пример:
Влез:
7
Hristina F
Magdalena F
Ivana F
Ivan M
Elena F
Ana F
Makedonka F
F
MARIJA
Ivana
Kristina
Anastasija
END
Излез:
MAKEDONKA
MAGDALENA
No such name
IVANA
F IVANA 1
No such name
ANA
No such name
*/
public class Zadaca5_ZastapenostNaIminja {
    static class Name implements Comparable<Name> {
        String name;

        public String getIme() {
            return name;
        }

        public void setIme(String name) {
            this.name = name;
        }

        public Name(String name) {
            this.name = name.toUpperCase();
        }

        @Override
        public boolean equals(Object obj) {
            Name temp = (Name) obj;
            return this.name.equals(temp.name);
        }

        @Override
        public int hashCode() {
            int hash = (100 * name.charAt(0) + name.charAt(1));
            return hash;
        }

        @Override
        public String toString() {
            return name;
        }

        @Override
        public int compareTo(Name arg0) {
            return name.compareTo(arg0.name);
        }
    }

    public static void main(String[] args) throws Exception, IOException {

        CBHT<Name, Integer> tableM, tableF;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        tableM = new CBHT<Name, Integer>(9091);
        tableF = new CBHT<Name, Integer>(9091);

        for (int i = 1; i <= N; i++) {
            String line = br.readLine();
            String[] input = line.split(" ");
            Name nameUpper = new Name(input[0].toUpperCase());

            if (input[1].compareTo("M") == 0) {
                SLLNode<MapEntry<Name, Integer>> resM = tableM.search(nameUpper);
                if (resM == null) {
                    tableM.insert(nameUpper, 1);
                } else {
                    int oldValue = resM.getElement().getValue();
                    tableM.insert(nameUpper, oldValue + 1);
                }
            }

            if (input[1].compareTo("F") == 0) {
                SLLNode<MapEntry<Name, Integer>> resF = tableF.search(nameUpper);
                if (resF == null) {
                    tableF.insert(nameUpper, 1);
                } else {
                    int oldValue = resF.getElement().getValue();
                    tableF.insert(nameUpper, oldValue + 1);
                }
            }
        }

        String sex = (br.readLine()).toUpperCase();
        String names = (br.readLine()).toUpperCase();

        while (names.compareTo("END") != 0) {
            if (sex.compareTo("M") == 0) {

                SLLNode<MapEntry<Name, Integer>> resM1 = tableM.getFirst(new Name(names));
                SLLNode<MapEntry<Name, Integer>> curr;

                for (curr = resM1; curr != null; curr = curr.getSucc()) {
                    System.out.println(curr.getElement().getKey().getIme());
                }

                SLLNode<MapEntry<Name, Integer>> resM2 = tableM.search(new Name(names));
                if (resM2 == null) {
                    System.out.println("No such name");
                    names = (br.readLine()).toUpperCase();
                } else {
                    System.out.println(sex + " " + resM2.getElement().getKey().toString()
                            + " " + resM2.getElement().getValue().toString());
                    names = (br.readLine()).toUpperCase();

                }

            }

            if (sex.compareTo("F") == 0) {

                SLLNode<MapEntry<Name, Integer>> resF1 = tableF.getFirst(new Name(names));
                SLLNode<MapEntry<Name, Integer>> curr1;

                for (curr1 = resF1; curr1 != null; curr1 = curr1.getSucc()) {
                    System.out.println(curr1.getElement().getKey().getIme());

                }
                SLLNode<MapEntry<Name, Integer>> resF2 = tableF.search(new Name(names));
                if (resF2 == null) {
                    System.out.println("No such name");
                    names = (br.readLine()).toUpperCase();

                } else {
                    System.out.println(sex + " " + resF1.getElement().getKey().toString()
                            + " " + resF1.getElement().getValue().toString());
                    names = (br.readLine()).toUpperCase();

                }

            }


        }

    }

}
