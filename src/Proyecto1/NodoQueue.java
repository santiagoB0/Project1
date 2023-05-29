package Proyecto1;

public class NodoQueue {
    private Vertice element;
    private NodoQueue next;

    public NodoQueue(Vertice element) {
        this.element = element;
        this.next = null;
    }

    public Vertice getElement() {
        return element;
    }

    public void setElement(Vertice element) {
        this.element = element;
    }

    public NodoQueue getNext() {
        return next;
    }

    public void setNext(NodoQueue next) {
        this.next = next;
    }
}
