package PrethodniIspitni._2026;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

/*Vlezna Vtor Kolokvium 2026

Potrebno e da se testira statusot na klucot (dali e missing, ili ne e missing).
Sekoj kluc se karakterizira so poseben keyID. keyID e objekt
sostaven od:
kod za zgrada
broj na soba
tag

primer B:101:blue (B - zgrada, 101 - soba, tag - blue)

sekoj kluc moze da bide prijaven kako zaguben ili pronajden. Pokraj keyID se
zapisuva i imeto na sopstvenikot koj posledno go prijavil klucot.
Primer:
LOST <keyID, Person>
FOUND <keyID, Person>
Dokolku ima obid za
prijavuvanje na klucot kako pronajden, no prethodno klucot NE bil prijaven kako izguben
togas obidot se ignorira

vlez n, vo narednite n redovi prijavuvanje na klucevite, q, vo narednite q redovi
testiranje na statusot na klucevite (Missing + ime na koj go prijavil ili Not missing)

test case:
input:
6
LOST B:101:blue Elena
LOST A:12:silver Peter
FOUND B:101:blue Marko
FOUND A:12:silver Ana
LOST B:101:blue Viktor
FOUND LAB:3:master Simona
4
B:101:blue
A:12:silver
LAB:3:master
A:99:red

output:
Missing Viktor
Not missing
Not missing
Not missing*/
public class VtorKolokvium_2026_Vlezna {
    static class KeyID {

        private String building;
        private int room;
        private String tag;

        public KeyID(String building, int room, String tag) {
            this.building = building;
            this.room = room;
            this.tag = tag;
        }

        @Override
        public boolean equals(Object obj) {

            if (this == obj) {
                return true;
            }

            if (!(obj instanceof KeyID)) {
                return false;
            }

            KeyID other = (KeyID) obj;

            return building.equals(other.building)
                    && room == other.room
                    && tag.equals(other.tag);
        }

        @Override
        public int hashCode() {
            return Objects.hash(building, room, tag);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Map<KeyID, String> missingKeys = new HashMap<>();

        for (int i = 0; i < n; i++) {

            String command = sc.next();
            String key = sc.next();
            String person = sc.next();

            KeyID keyID = parseKeyID(key);

            if (command.equals("LOST")) {

                missingKeys.put(keyID, person);

            } else if (command.equals("FOUND")) {

                if (missingKeys.containsKey(keyID)) {
                    missingKeys.remove(keyID);
                }
            }
        }

        int q = sc.nextInt();

        for (int i = 0; i < q; i++) {

            String key = sc.next();

            KeyID keyID = parseKeyID(key);

            if (missingKeys.containsKey(keyID)) {

                System.out.println(
                        "Missing " + missingKeys.get(keyID)
                );

            } else {

                System.out.println("Not missing");
            }
        }
    }

    public static KeyID parseKeyID(String key) {

        String[] parts = key.split(":");

        String building = parts[0];
        int room = Integer.parseInt(parts[1]);
        String tag = parts[2];

        return new KeyID(building, room, tag);
    }
}
