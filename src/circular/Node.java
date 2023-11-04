package circular;

public class Node<E> {

    // Valor del nodo
    private E data;
    // Puntero siguiente
    private Node<E> next;

    // Constructor de la clase nodo
    public Node(E ele) {
        data = ele;
    }

    // Enlazar siguiente
    public void setNext(Node<E> next) {
        this.next = next;
    }

    // Obtener anterior
    public Node<E> getNext() {
        return next;
    }

    // Obtener el dato del nodo
    public E getData() {
        return data;
    }

    // Actualizar la data del nodo
    public void setData(E data) {
        this.data = data;
    }

}
