public class SLL<E> {
    private SLLNode<E> head;

    public SLL() {
        this.head = null;
    }

    @Override
    public String toString() {
        // O(n) complexity - it goes through them all
        if (this.head == null) {
            return "Prazna lista!";
        }
        String ret = new String();
        SLLNode<E> cur = this.head;
        ret += cur.data;
        while (cur.next != null) {
            cur = cur.next;
            ret += " -> " + cur.data;
        }
        return ret;
    }

    public void insertFirst(E object){
        SLLNode<E> newNode = new SLLNode<E>(object, null); // ili tuka direktno moze kaj next da stavime head
        newNode.next = head;
        head = newNode;
    }
}
