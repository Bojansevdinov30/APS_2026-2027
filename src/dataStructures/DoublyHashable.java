package dataStructures;

public interface DoublyHashable<K> extends Comparable<K> {

    public int hashCode();
    //Вра´ка хеш код за клучот.


    public int stepCode();
    //Вра´ка должина на чекор за клучот.

}