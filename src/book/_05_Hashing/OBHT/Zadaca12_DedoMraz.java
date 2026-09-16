package book._05_Hashing.OBHT;

import java.io.*;
import java.util.HashMap;

/*Дедо Мраз преку целата година води список на деца кои биле добри, а ги има
и нивните адреси за да им достави подароци. Така е и со децата од Скопjе, но
градот Скопjе решил да менува имиња на улици и Дедо Мраз во последен момент
добил листа со изменети имиња на улици. Проверете за дадено дете дали Дедо
Мраз треба да му достави подарок (дали го има детето во списокот на добри
деца) и ако треба, на коjа адреса ´ке му го достави.
Влез: Во првата линиjа е даден броj 𝑁 на деца кои биле добри. Во наредните
𝑁 линии се дадени името на детето и неговата адреса (адресата е во формат
ИмеНаУлица Броj). Потоа е даден броj 𝑀 на улици од Скопjе кои го промениле
своето име. Во наредните 𝑀 линии дадени се прво старите, па новите имиња на
улиците. Во последниот ред е дадено името на детето кое треба да се провери.
Излез: Ако даденото дете не било добро (т.е. го нема во списокот на добри
деца) да се испечати „No gift”, а ако било добро да се испечати валидната адреса
на коjа ´ке се достави подарокот (т.е. ако името на улицата се променило, да се
испечати адресата со новото име на улицата).
Пример:
Влез:
3
Ivana Vodnjanska 4
Marko Leninova 18/2
Elena StivNaumov 10
4
Vodnjanska MajkaTereza
Leninova AmintaTreti
StivNaumov SlavkoJanevski
AdolfCiborovski GoranStefanovski
Elena
Излез:
SlavkoJanevski 10
*/
public class Zadaca12_DedoMraz {
    static class Street {
        String name;
        String number;

        Street(String name, String number) {
            this.name = name;
            this.number = number;
        }

        @Override
        public String toString() {
            return name + " " + number;
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Street> kidToStreet = new HashMap<>(); // од дете во адреса на живеење
        HashMap<String, String> oldToNewStreet = new HashMap<>(); // од старата во новата улица

        int n = Integer.parseInt(br.readLine().trim()); // број на деца кои се добри
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            String[] tokens = line.split(" ");
            String kid = tokens[0]; // детето
            String name = tokens[1]; // име на улица
            String number = tokens[2]; // број на улица
            Street street = new Street(name, number);  // објект од класата улица
            kidToStreet.putIfAbsent(kid, street); // мапирање од дете во адреса на живеење
        }

        int m = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < m; i++) {
            String line = br.readLine();
            String[] tokens = line.split(" ");
            String oldStreet = tokens[0]; // име на стара улица
            String newStreet = tokens[1]; // име на нова улица
            oldToNewStreet.putIfAbsent(oldStreet, newStreet); // мапирање на имиња од стари во нови
        }

        String query = br.readLine();
        if (kidToStreet.containsKey(query)) { // ако го има на листата за добри деца
            Street street = kidToStreet.get(query); // земи ја улицата што е асоцирана со тоа дете
            if (oldToNewStreet.containsKey(street.name)) street.name = oldToNewStreet.get(street.name);
            // ако постои мапирање за таа улица (значи сменето е името), тогаш смени го името на улицата со новото
            System.out.println(street); // испечати ја улицата
        }

        // Имам две хешмапи, една за дете во улица, друга за старо име на улица во ново
        // ги ставам најнормално во мапите
        // Ако детето воопшто го има на листата за добри деца
        // ја земам улицата, и гледам ако името на улицата го има во
        // мапата за нови улици, тогаш го менувам името на улицата во ново
        // ја печатам улицата <3

    }
}
