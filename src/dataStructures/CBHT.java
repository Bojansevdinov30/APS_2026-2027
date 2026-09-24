package dataStructures;

public class CBHT<K extends Comparable<K>, E> {
    //Табелата (со кофички) се состои од низа од jазли (SLLNode jазли) кои во
    // себе чуваат MapEntry обjекти.
    private SLLNode<MapEntry<K, E>>[] buckets;

    public SLLNode<MapEntry<K, E>>[] getBuckets() {
        return buckets;
    }

    public void setBuckets(SLLNode<MapEntry<K, E>>[] buckets) {
        this.buckets = buckets;
    }

    @SuppressWarnings("unchecked")
    public CBHT(int m) {
        //Креира празна хеш табела со m „кофички”.
        buckets = (SLLNode<MapEntry<K, E>>[]) new SLLNode[m];
    }

    //методи на CBHT

    private int hash(K key) {
        //Го преведува клучот во индекс на низата buckets.
        return Math.abs(key.hashCode()) % buckets.length;
    }

    public SLLNode<MapEntry<K, E>> getFirst(K targetKey) {
        int b = hash(targetKey);
        return buckets[b];
    }

    public SLLNode<MapEntry<K, E>> search(K targetKey) {
        // O(1) najdobar, O(n) najlos slucaj
        // Го нао´га jазолот од CBHT коj содржи елемент чиj клуч е еднаков на
        // targetKey. Вра´ка врска до тоj jазол (или null ако нема таков
        // jазол).
        int b = hash(targetKey);
        for (SLLNode<MapEntry<K, E>> curr = buckets[b]; curr != null; curr = curr.succ) {
            if (targetKey.equals(((MapEntry<K, E>) curr.element).key))
                return curr;
        }
        return null;
    }

    public void insert(K key, E val) {
        // O(1) najdobar, O(n) najlos slucaj
        //Вметнување на парот <key, val> во CBHT.
        MapEntry<K, E> newEntry = new MapEntry<K, E>(key, val);
        int b = hash(key);
        for (SLLNode<MapEntry<K, E>> curr = buckets[b]; curr != null; curr = curr.succ) {
            if (key.equals(((MapEntry<K, E>) curr.element).key)) {
                //newEntry го заменува постоечкиот елемент со клуч key.
                curr.element = newEntry;
                return;
            }
        }
        //Додавање на newEntry на почетокот на листата во домашната „кофичка” со индекс b.
        buckets[b] = new SLLNode<MapEntry<K, E>>(newEntry, buckets[b]);
    }

    public void delete(K key) {
        // O(1) najdobar, O(n) najlos slucaj
        int b = hash(key);
        for (SLLNode<MapEntry<K, E>> pred = null, curr = buckets[b]; curr != null; pred = curr, curr = curr.succ) {
            if (key.equals(((MapEntry<K, E>) curr.element).key)) {
                if (pred == null)
                    buckets[b] = curr.succ;
                else
                    pred.succ = curr.succ;
                return;
            }
        }
    }

    public String toString() {
        // O(n^2) vo najlos slucaj ako site se vo edna koficka
        String temp = "";
        for (int i = 0; i < buckets.length; i++) {
            temp += i + ":";
            for (SLLNode<MapEntry<K, E>> curr = buckets[i]; curr != null; curr = curr.succ) {
                temp += curr.element.toString() + " ";
            }
            temp += "\n";
        }
        return temp;
    }

}
