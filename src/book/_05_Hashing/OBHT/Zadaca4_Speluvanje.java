package book._05_Hashing.OBHT;

import dataStructures.OBHT;

import java.io.*;

/*За даден текст на англиски jазик, потребно е да се направи проверка дали е
правилно напишан, односно дали правилно се напишани зборовите. За таа цел
прво се внесува речник на зборови (односно листа на зборови кои ги содржи
англискиот jазик), а потоа е даден текст. Како резултат треба да се испечатат
сите зборови кои се неправилно напишани или ги нема во речникот.
Влез: Прво е даден броj 𝑁 на поими кои ´ке ги содржи речникот, а во наред-
ните 𝑁 реда се дадени зборовите кои ги содржи англискиот jазик. Потоа е даден
текст, коj треба да се провери дали е правилно напишан.
Излез: Се печати листа на зборови кои се неправилно напишани (секоj во
посебен ред). Доколку сите зборови се добро напишани се печати: Bravo.
Забелешка: Треба да се игнорираат интерпункциски знаци како точка (.),
запирка (,), извичник (!) и прашалник (?). Исто така, да се внимава на голема и
мала буква, односно иако зборовите во речникот се со мали букви, во реченица
може да поjават со голема почетна буква и притоа се сметаат за точни. Треба
да се одреди броjот на „кофички” и хеш функциjата.
Пример:
Влез:
4
where
is
my
cat
Where is my Ccat?
Излез:
Ccat
*/
public class Zadaca4_Speluvanje {
    static class Word implements Comparable<Word> {
        String word;

        public Word(String word) {
            this.word = word;
        }

        @Override
        public boolean equals(Object obj) {
            Word temp = (Word) obj;
            return this.word.equals(temp.word);
        }

        @Override
        public int hashCode() {
            int hash = 0;
            for (int i = 0; i < word.length(); i++) {
                hash += word.charAt(i); //Збир на ASCII вредностите на сите карактери
            }
            hash += word.length(); //Должина на зборот

            return hash;
        }

        @Override
        public String toString() {
            return word;
        }

        @Override
        public int compareTo(Word arg0) {
            return word.compareTo(arg0.word);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        OBHT<Word, String> hashtable = new OBHT<Word, String>(2 * N);

        for (int i = 0; i < N; i++) {
            Word word = new Word(br.readLine());
            String newWord = word.word.toLowerCase().replaceAll("\\?",
                    "").replaceAll("\\!", "").replaceAll("\\.",
                    "").replaceAll("\\,", "");
            hashtable.insert(new Word(newWord), word.word.replaceAll("\\?",
                    "").replaceAll("\\!", "").replaceAll("\\.",
                    "").replaceAll("\\,", ""));
        }

        String text = br.readLine();
        String[] p = text.split(" ");
        int m = 0;

        for (int i = 0; i < p.length; i++) {
            String original = p[i];
            p[i] = p[i].toLowerCase().replaceAll("\\?", "").replaceAll("\\!",
                    "").replaceAll("\\.", "").replaceAll("\\,", "");

            if (hashtable.search(new Word(p[i])) == -1) {
                System.out.println(original.replaceAll("\\?",
                        "").replaceAll("\\!", "").replaceAll("\\.",
                        "").replaceAll("\\,", ""));
            } else {
                m++;
            }

        }

        if (m == p.length)
            System.out.println("Bravo");
    }
}
