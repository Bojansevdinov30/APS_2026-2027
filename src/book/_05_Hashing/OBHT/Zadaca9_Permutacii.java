package book._05_Hashing.OBHT;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;

/*Користеj´ки хеш табела да се направи групирање на зборовите кои се пермутации
еден на друг од дадена листа со зборови. Пермутациjа на даден збор е збор коj
се добива со преуредување на буквите од зборот. На пример pots е пермутациjа
на stop.
Влез: Во првиот ред е даден броjот на зборови 𝑁 . Во наредните 𝑁 реда се
дадени зборовите кои треба да се додадат во табелата. Во следниот ред е даден
зборот за коj треба да се испечати броjот на зборови во табелата кои се негови
пермутации.
Излез: Броjот на зборови во табелата кои се пермутации на дадениот збор.
Пример:
Влез:
4
stop
tsop
ooos
toos
tosp
Излез:
2
*/
public class Zadaca9_Permutacii {
    public static void main (String [] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> permutations = new HashMap<String, Integer>();

        int n = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            char[] chars = line.toCharArray();
            Arrays.sort(chars); // по азбучен ред ќе ми ги сортира
            line = String.valueOf(chars); // ќе го врати назад во стринг
            if (!permutations.containsKey(line)) permutations.put(line, 1);
            else permutations.put(line, permutations.get(line) + 1);
        }

        String query = br.readLine();
        char[] chars = query.toCharArray();
        Arrays.sort(chars);
        query = new String(chars);
        if (permutations.containsKey(query)) System.out.println(permutations.get(query));
        else System.out.println(0);

        // Слична задача како задачата со анаграми
        // целата финта е да ги сортираме азбучно така што
        // сите зборови да се исти
        // (stop и tosp се различни но истите букви ги содржат,
        // па следува дека треба во истиот клуч да одат)

    }

}
