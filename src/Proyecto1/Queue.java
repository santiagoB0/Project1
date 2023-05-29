package Proyecto1;

public class Queue {

    private NodoQueue head;
    private NodoQueue tail;
    private int length;

    public Queue() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public NodoQueue getHead() {
        return head;
    }

    public void setHead(NodoQueue head) {
        this.head = head;
    }

    public NodoQueue getTail() {
        return tail;
    }

    public void setTail(NodoQueue tail) {
        this.tail = tail;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void enqueue(Vertice vertice){
        NodoQueue newNodo = new NodoQueue(vertice);
        if (isEmpty()) {
            setHead(newNodo);
            setTail(newNodo);
        } else {
            getTail().setNext(newNodo);
            setTail(newNodo);
        } length++;
    }

    public void dispatch() {
        setHead(getHead().getNext());

    }


}
