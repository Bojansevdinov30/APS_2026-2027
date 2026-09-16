package book._05_Hashing.OBHT;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

/*Министерството за внатрешни работи добило модерна опрема со коjа може да
врши анализа на ДНК доказите од местата на злосторствата. Со оваа опрема
МВР изградиле база на податоци и за секоj криминалец се чуваат 2 карактерис-
тични примероци (нишки од карактеристични делови од ДНК), а секоj од овие
примероци се состои од низа од 4 можни нуклеотиди: A, C, G или T. Ваша задача
е за дадените примероци (нишки) од ДНК наjдени на местото на злосторството
да проверите дали ве´ке ги имате во базата на податоци и коj е сопственикот
на наjдените примероци. Доколку и двата извадени примероци припа´гаат на
еден сопственик, се испишува името на сопственикот, во спротивно се испишува:
„Unknown”.
Влез: Во првиот ред е даден броjот 𝑁 на криминалци кои ги содржи базата на
податоци. Во наредните редови за секоj криминалец прво е дадено неговото име
и презиме, а потоа во двата наредни реда се дадени неговите примероци од ДНК.
На краj се дадени двата примероци кои се наjдени на местото на злосторството.
Излез: Се печати името и презимето на криминалецот доколку и двата при-
мероци на ДНК се совпа´гаат. Во спротивно се печати: „Unknown”.
Пример 1:
Влез:
3
IvanIvanovski
ACGTGTACCATGATAG
GGTACGATCCT
ElenaPetrevska
GTACCGATGCTAGGATC
ACGTAGCTCCGGATCG
KostaKostovski
CGCTAATTTAAAGC
TAGACTCGATCGCT
ACGTGTACCATGATAG
GGTACGATCCT
Излез: IvanIvanovski
Пример 2:
Влез:
3
IvanIvanovski
ACGTGTACCATGATAG
GGTACGATCCT
ElenaPetrevska
GTACCGATGCTAGGATC
ACGTAGCTCCGGATCG
KostaKostovski
CGCTAATTTAAAGC
TAGACTCGATCGCT
ACGTACCATGATAG
A
Излез: Unknown
*/
public class Zadaca8_KriminalecDNK {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, ArrayList<String>> dna = new HashMap<>();

        int n = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < n; i++) {
            String name = br.readLine();
            String dnaOne = br.readLine();
            String dnaTwo = br.readLine();
            if (!dna.containsKey(name)) {
                dna.put(name, new ArrayList<>());
                dna.get(name).add(dnaOne);
                dna.get(name).add(dnaTwo);
            } else {
                dna.get(name).add(dnaOne);
                dna.get(name).add(dnaTwo);
            }
        }

        String queryDnaOne = br.readLine();
        String queryDnaTwo = br.readLine();
        boolean found = false;

        for (String s : dna.keySet()) { // ги пребарувам сите клучеви
            if (dna.get(s).contains(queryDnaOne) && dna.get(s).contains(queryDnaTwo)) {
                found = true;
                System.out.println(s);
                break;
            }
        }
        if (!found) System.out.println("Unknown");

        // Од нас се бара да го најдеме криминалецот.
        // Итерирам низ сите клучеви на хеш мапата,
        // и гледам дали некое мапирање (низа)
        // ги содржи тие две ДНК нишки
        // ако ги содржи, го печатам криминалецот
        // инаку печатам Unknown

    }
}

//uste polesna ama pospecificna verzija
/* public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        HashMap<String, String> dnaDatabase = new HashMap<>();

        for (int i = 0; i < n; i++) {

            String name = sc.next();
            String dna1 = sc.next();
            String dna2 = sc.next();

            dnaDatabase.put(dna1, name);
            dnaDatabase.put(dna2, name);
        }

        String foundDNA1 = sc.next();
        String foundDNA2 = sc.next();

        String owner1 = dnaDatabase.get(foundDNA1);
        String owner2 = dnaDatabase.get(foundDNA2);

        if (owner1 != null && owner1.equals(owner2)) {
            System.out.println(owner1);
        } else {
            System.out.println("Unknown");
        }
    }
    */
