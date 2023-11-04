package doubles;

public class Node<E> {

    // Valor del nodo
    private E data;
    // Puntero siguiente
    private Node<E> next;
    // Puntero anterior
    private Node<E> prev;

    // Constructor de la clase nodo
    public Node(E ele) {
        data = ele;
    }

    // Enlazar siguiente
    public void setNext(Node<E> next) {
        this.next = next;
    }

    // Obtener siguiente
    public Node<E> getNext() {
        return next;
    }

    // Asignar la data del nodo
    public void setData(E data) {
        this.data = data;
    }

    // Obtener el data del nodo
    public E getData() {
        return data;
    }

    // Obtener el anterior
    public Node<E> getPrev() {
        return prev;
    }

    // Enlazar anterior
    public void setPrev(Node<E> prev) {
        this.prev = prev;
    }

}
