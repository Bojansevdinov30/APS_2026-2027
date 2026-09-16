package dataStructures;

public class OBHT<K extends Comparable<K>, E> {
    // O(1) vo najdobar (mislam i prosecen slucaj), a O(n) vo najlos
    //Табелата се состои од MapEntry обjекти.

    private MapEntry<K, E>[] buckets;
    //buckets[b] е null ако „кофичката” b не била никогаш зафатена.
    //buckets[b] е претходно зафатена ако во „кофичката” b имало претходно
    // елемент коj е избришан и моментално нема елемент во оваа „кофичка”.

    static final int NONE = -1; //... различно од било коj индекс на „кофичка”.

    private static final MapEntry former = new MapEntry(null, null);
    //Ова гарантира дека за било коj елемент e e.key.equals(former.key) е false.

    private int occupancy = 0;
    //броj на зафатени или претходно зафатени „кофички”.

    @SuppressWarnings("unchecked")
    public OBHT(int m) {
        //Се креира празна OBHT со m „кофички”.
        buckets = (MapEntry<K, E>[]) new MapEntry[m];

    }

    //методи на OBHT

    private int hash(K key) {
        //Го преведува клучот во индекс на низата buckets.
        return Math.abs(key.hashCode()) % buckets.length;
    }

    public int search(K targetKey) {
        int b = hash(targetKey);
        int n_search = 0;
        for (; ; ) {
            MapEntry<K, E> oldEntry = buckets[b];
            if (oldEntry == null)
                return NONE;
            else if (targetKey.equals(oldEntry.key))
                return b;
            else {
                b = (b + 1) % buckets.length;
                n_search++;
                if (n_search == buckets.length)
                    return NONE;

            }
        }
    }

    public MapEntry<K, E> getBucket(int i) {
        return buckets[i];
    }

    public void insert(K key, E val) {
        MapEntry<K, E> newEntry = new MapEntry<K, E>(key, val);
        int b = hash(key);
        int n_search = 0;
        for (; ; ) {
            MapEntry<K, E> oldEntry = buckets[b];
            if (oldEntry == null) {
                if (++occupancy == buckets.length) {
                    System.out.println("Hash table is full!!!");
                }
                buckets[b] = newEntry;
                return;
            } else if (oldEntry == former || key.equals(oldEntry.key)) {
                buckets[b] = newEntry;
                return;
            } else {
                b = (b + 1) % buckets.length;
                n_search++;
                if (n_search == buckets.length)
                    return;

            }
        }
    }

    @SuppressWarnings("unchecked")
    public void delete(K key) {
        int b = hash(key);
        int n_search = 0;
        for (; ; ) {
            MapEntry<K, E> oldEntry = buckets[b];

            if (oldEntry == null)
                return;
            else if (key.equals(oldEntry.key)) {
                buckets[b] = former; //(MapEntry<K,E>)former;
                return;
            } else {
                b = (b + 1) % buckets.length;
                n_search++;
                if (n_search == buckets.length)
                    return;

            }
        }
    }

    public String toString() {
        // O(n) ama so vakov string poveke e
        String temp = "";
        for (int i = 0; i < buckets.length; i++) {
            temp += i + ":";
            if (buckets[i] == null)
                temp += "\n";
            else if (buckets[i] == former)
                temp += "former\n";
            else
                temp += buckets[i] + "\n";
        }
        return temp;
    }
}
