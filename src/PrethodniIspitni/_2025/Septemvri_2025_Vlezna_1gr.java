package PrethodniIspitni._2025;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
/* Sept. PAPS Vlezna Zadaca (od prilika)
Vo edna biblioteka se zacleneti N broj ucenici. Ucenicite se zapisani vo format - Ime Prezime ab12 (index).
Bibliotekata nudi popust na ucenicite koj sto ke ostanat podolgo od minimum T minuti.
Se vnesuva sekoj ucenik po indeks i kolku vreme ke ostanat vo bibliotekata. Ako nivnite minuti se pogolemi ili ednakvi od T, togas dobivaat popust i treba da se isprinta nivnoto ime. Se vnesuvaat ucenici se dodeka ne se vnese "kraj 0".
PRISTAPOT DO IMETO OD STUDENTOT MORA DA IMA O(1) KOMPLEKSNOST.

Pr:
INPUT:
3
Petar Petrov a1d3
Tome Tomislav j5ee
Ivan Ivanovski dn67
30
a1d3 15
j5ee 30
dn67 35

OUTPUT:
Tome Tomislav
Ivan Ivanovski*/
public class Septemvri_2025_Vlezna_1gr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        HashMap<String, String> indexToName = new HashMap<>();
        ArrayList<String> ans = new ArrayList<>();
        String name, index;
        for (int i = 0; i < n; i++) {
            String []parts = sc.nextLine().split(" ");
            index = parts[2];
            name = parts[0] + " " + parts[1];
            indexToName.put(index, name);
        }
        int t = Integer.parseInt(sc.nextLine());
        String line;
        while (!("kraj0").equals(line = sc.nextLine())){
            String[]parts = line.split(" ");
            int time = Integer.parseInt(parts[1]);
            if (time < t) continue;
            index = parts[0];
            ans.add(indexToName.get(index));
        }
        for (String a : ans){
            System.out.println(a);
        }
    }
}
