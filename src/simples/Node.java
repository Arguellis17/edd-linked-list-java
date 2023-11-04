package simples;

public class Node<E> {

    // Valor del nodo
    private E data;
    // Puntero del nodo
    private Node<E> next;

    public Node(E value) {
        // Inicializa el valor del nodo
        data = value;
        // Puntero iniciado en null
        this.next = null;
    }

    // Enlazar el puntero a otro nodo
    public void setNext(Node<E> next) {
        this.next = next;
    }

    // Obtener la posicion siguiente del puntero (Sirve para mover el puntero de su posicion)
    public Node<E> getNext() {
        return next;
    }

    // Obtener el valor del nodo
    public E getData() {
        return data;
    } 

}
