package dataStructures;

public class MapEntry<K extends Comparable<K>, E> implements Comparable<K> {
    //Секоj MapEntry обjект е пар од клуч и вредност.
    K key;
    E value;

    public MapEntry(K key, E val) {
        this.key = key;
        this.value = val;
    }

    public int compareTo(K that) {
        //Спореди jа тековната „кофичка” this со „кофичката” that.
        @SuppressWarnings("unchecked")
        MapEntry<K, E> other = (MapEntry<K, E>) that;
        return this.key.compareTo(other.key);
    }

    public String toString() {
        return "<" + key + "," + value + ">";
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }
}
/*
class MapEntry<K extends Comparable<K>, E>
        implements Comparable<MapEntry<K, E>> {

    K key;
    E value;

    public MapEntry(K key, E val) {
        this.key = key;
        this.value = val;
    }

    @Override
    public int compareTo(MapEntry<K, E> other) {
        return this.key.compareTo(other.key);
    }

    @Override
    public String toString() {
        return "<" + key + "," + value + ">";
    }
}
*/