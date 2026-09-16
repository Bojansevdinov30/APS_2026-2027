package book._05_Hashing.CBHT;

import dataStructures.CBHT;
import dataStructures.MapEntry;
import dataStructures.SLLNode;

import java.io.*;

/*Потребно е да се направи компjутерска апликациjа со коjа ´ке се забрза работе-
њето на една аптека. Притоа апликациjата треба да му овозможи на корисникот
(фармацевтот) брзо да пребарува низ огромното множество со лекови кои се вне-
сени во системот. Начинот на коj тоj треба да пребарува е следен: доволно е да
ги внесе првите 3 букви од името на лекот за да може да се прикаже листа од
лекови кои ги има во системот.
Работата на фармацевтот е да провери дали внесениот лек го има во системот
и да му даде информациjа на клиентот. Информациjата што треба да му jа даде
на клиентот е дали лекот се нао´га на позитивната листа на лекови, коjа е цената
и колку парчиња од лекот има на залиха. Доколку лекот постои, клиентот го
нарачува со што кажува колку парчиња ´ке купи. Оваа акциjа фармацевтот треба
да jа евидентира во системот (односно да jа намали залихата на лекови за онолку
парчиња колку што му издал на клиентот). Доколку нарачката на клиентот е
поголема од залихата на лекот што jа има во системот, не се презема никаква
акциjа.
Влез: Од стандарден влез прво се чита броj 𝑁 коj претставува броj на лекови
кои ´ке бидат внесени во системот. Во наредните 𝑁 реда се дадени имињата на
лековите, дали ги има на позитивната листа (1/0), цената и броj на парчиња, сите
разделени со по едно празно место. Потоа се дадени редови со имиња на лекови
и броj на парчиња нарачани од клиентот. За означување на краj се наведува
зборот „END”.
Излез: На стандарден излез треба да се испечати за секоj од влезовите след-
ната информациjа: ИМЕ POS/NEG ЦЕНА КОЛИЧИНА. Доколку лекот не е
наjден се печати „No such drug”. Доколку нарачката на клиентот е поголема од
залихата се печати „No drugs available”, инаку „Order made”.
Забелешка: Функциjата со коjа се врши мапирање на имињата на лековите
во броj е следна:
ℎ(𝑤) = (100*(100*(100*0+ASCII(𝑐_3))+ASCII(𝑐_2))+ASCII(𝑐_1))%656565,
каде зборот 𝑤 = 𝑐1𝑐2𝑐3𝑐4𝑐5 . . . е составен само од големи букви.
Исто така, за лековите да се направи посебна класа коjа како атрибути ´ке ги
има наведените карактеристики на лекот во системот.
Пример:
Влез:
5
ACEROLA 0 100 1000
ACIKLOVIR 1 1650 87
HYDROCYKLIN 0 55 10
GENTAMICIN 1 152 90
HYDROCYKLIN20 0 113 20
hydroCyklinn
2
hydroCyklin20
2
END
Излез: No such drug
HYDROCYKLIN20 NEG 113 20
Order made
*/
public class Zadaca6_Apteka {
    static class Drug {
        String name;
        int posList;
        int price;
        int quantity;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public int getPosList() {
            return posList;
        }

        public Drug(String name, int posList, int price, int quantity) {
            this.name = name.toUpperCase();
            this.posList = posList;
            this.price = price;
            this.quantity = quantity;
        }

        @Override
        public boolean equals(Object obj) {
            Drug temp = (Drug) obj;
            return this.name.equals(temp.name);
        }


        @Override
        public String toString() {
            if (posList == 1)
                return name + " " + "POS" + " " + price + " " + quantity;
            else
                return name + " " + "NEG" + " " + price + " " + quantity;
        }

    }

    static class Name implements Comparable<Name> {
        String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
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
            int hash = (100 * (100 * (100 * 0 + (name).charAt(2)) + (name).charAt(1)) + (name).charAt(0));
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

        CBHT<Name, Drug> hashtable = new CBHT<Name, Drug>(656565);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            String line = br.readLine();
            String[] input = line.split(" ");
            Drug drug = new Drug(input[0], Integer.parseInt(input[1]),
                    Integer.parseInt(input[2]), Integer.parseInt(input[3]));
            hashtable.insert(new Name(input[0].toUpperCase()), drug);
        }

        String order = (br.readLine()).toUpperCase();

        while (order.compareTo("END") != 0) {

            int quantity = Integer.parseInt(br.readLine());
            SLLNode<MapEntry<Name, Drug>> result = hashtable.search(new Name(order));

            if (result == null) {

                System.out.println("No such drug");
                order = (br.readLine()).toUpperCase();
            } else if (result.getElement().getValue().getName().equals(order)) {
                System.out.println(result.getElement().getValue().toString());
                if (result.getElement().getValue().getQuantity() < quantity) {
                    System.out.println("No drugs available");
                } else {

                    int oldQuantity = result.getElement().getValue().getQuantity();
                    result.getElement().getValue().setQuantity(oldQuantity - quantity);
                    hashtable.insert(new Name(order), result.getElement().getValue());
                    System.out.println("Order made");
                }
                order = (br.readLine()).toUpperCase();
            } else {
                order = br.readLine();
            }
        }
    }

}
