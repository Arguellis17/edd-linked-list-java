package cicular.doubles;

public class MyDoubleCircularLinkedList<E> {

    private Node<E> head;
    private int size = 0; // Number of elements in the list

    /**
     * Agregar un nodo con el elemento correspondiente al final de la lista o
     * inicio de la lista
     *
     * @param element valor del nodo
     */
    public void add(E element) {

        // Si la lista no se ha instanciado, se crea a partir del valor pasado
        if (head == null) {

            Node<E> nuevo = new Node<>(element);
            head = nuevo;
            head.setNext(nuevo);
            head.setPrev(nuevo);
            size++;
        } else {
            // Si ya se ha instanciado la lista
            Node p = head;
            // Avanzara hasta el ultimo nodo creado
            while (p.getNext() != head) {

                p = p.getNext();
            }
            // Creacion del nuevo nodo
            Node<E> nuevo = new Node<>(element);
            // P se conectara al nuevo nodo
            p.setNext(nuevo);
            // El anterior del nuevo nodo sera P
            nuevo.setPrev(p);
            // Lo siguiente del nuevo nodo sera la cabeza
            nuevo.setNext(head);
            // Lo anterior de la cabeza sera el nuevo nodo
            head.setPrev(nuevo);
            size++;

        }

    }

    /**
     * Busca un elemento dentro de una lista, y lo elimina.
     *
     * @param element nodo a eliminar
     */
    public void remove(E element) {

        Node p = head;
        Node q = head;

        Node obtenerNodo = new Node(element);

        while (!p.getData().equals(obtenerNodo.getData())) {

            p = p.getNext();
        }
        if (p.getData().equals(head.getData())) {
            //System.out.println("sonas");
            head.setPrev(p.getPrev());
            head.setNext(p.getNext());
            head = p.getNext();
            if (head != null) {
                head.setPrev(p.getPrev()); // Actualiza el puntero 'prev' del nuevo nodo inicial
            }

            size--;

        } else {
            q = p.getPrev();
            q.setNext(p.getNext());
            size--;

        }
    }

    /**
     * Este método busca un nodo que contenga el valor elementToFind y agrega un
     * nodo antes, con el valor elementToAdd.
     *
     * @param elementToFind Elemento a encontrar para agregar un nodo antes.
     * @param elementToAdd Valor del nodo a insertar.
     */
    public void addBefore(E elementToFind, E elementToAdd) {

        // Creacion de los punteros
        Node p = head;

        // Obtener los nodos 
        Node obtenerNodo = new Node(elementToFind);
        Node nuevo = new Node(elementToAdd);

        // Caso especial: si el nodo a agregar antes es la cabeza
        if (head != null && head.getData().equals(obtenerNodo.getData())) {
            nuevo.setNext(head);
            head.setPrev(nuevo);
            head = nuevo;
            size++;
            return;
        }

        while (p != null && !p.getData().equals(obtenerNodo.getData())) {
            p = p.getNext();
        }

        // Validar si se encontró el nodo
        if (p != null) {
            Node q = p.getPrev();
            nuevo.setNext(p);
            p.setPrev(nuevo);

            // Validar si no es el primer nodo
            if (q != null) {
                q.setNext(nuevo);
                nuevo.setPrev(q);
            }

            size++;
        } else {
            // Elemento no encontrado, puedes manejarlo de acuerdo a tus necesidades
            System.out.println("El elemento a agregar antes no se encuentra en la lista.");
        }
    }

    /**
     * Este método busca un nodo que contenga el valor elementToFind y agrega un
     * nodo después, con el valor elementToAdd.
     *
     * @param elementToFind Elemento a encontrar para agregar un nodo después.
     * @param elementToAdd Valor del nodo a insertar.
     */
    public void addAfter(E elementToFind, E elementToAdd) {

        // Creacion punteros
        Node p = head;
        Node q = head;

        // Obtener los nodos 
        Node obtenerNodo = new Node(elementToFind);
        Node nuevo = new Node(elementToAdd);

        // Avanzara hasta encontrar el nodo
        while (!p.getData().equals(obtenerNodo.getData())) {
            p = p.getNext();
        }

        // Se posiciona delante de P
        q = p.getNext();

        // Conexiones
        p.setNext(nuevo);
        q.setPrev(nuevo);
        nuevo.setPrev(p);
        nuevo.setNext(q);
        size++;

    }

    /**
     * Este método busca un nodo que contenga el valor elementToFind y elimina
     * el nodo siguiente.
     *
     * @param elementToFind Elemento a encontrar para eliminar el nodo
     * siguiente.
     */
    public void removeAfter(E elementToFind) {

        Node p = head;
        Node q = head;
        Node a = head;

        Node obtenerNodo = new Node(elementToFind);

        while (!p.getData().equals(obtenerNodo.getData())) {
            p = p.getNext();
        }
        q = p.getNext();

        if (p.getData().equals(obtenerCola())) {

            a = head.getNext();
            p.setNext(a);
            a.setPrev(p);
            head = a;
            size--;
            return;
        }
        if (q.getNext() == head) {

            p.setNext(head);
            head.setPrev(p);
            size--;
        } else {
            a = q.getNext();
            p.setNext(a);
            a.setPrev(p);
            size--;

        }

    }

    /**
     * Este método busca un nodo que contenga el valor elementToFind y elimina
     * el nodo anterior.
     *
     * @param elementToFind Elemento a encontrar para eliminar el nodo anterior.
     */
    public void removeBefore(E elementToFind) {

        Node p = head;
        Node q = head;

        Node obtenerNodo = new Node(elementToFind);

        while (!p.getData().equals(obtenerNodo.getData())) {

            p = p.getNext();
        }
        q = p.getPrev();
        System.out.println("P: " + p.getData());
        System.out.println("Q: " + q.getData());
    }

    /**
     * Actualize el valor de un nodo. Busca el nodo con el valor oldElement, y
     * lo reemplaza con el valor newElement. Es importante aclarar que este
     * método no crea un nodo, sino que reemplaza el valor del nodo encontrado.
     *
     * @param newElement
     * @param oldElement
     */
    public void updateNode(E newElement, E oldElement) {

    }

    public E obtenerCabeza() {

        return (E) head.getData();
    }

    public E obtenerCola() {

        Node p = head;
        while (p.getNext() != head) {
            p = p.getNext();
        }
        return (E) p.getData();
    }

    public void print() {

        // Se crea una variable contador
        int contador = 0;
        // El apuntador P que nos permitira sacar los data de los nodos
        Node p = head;
        // Mientras nuestro contador sea menor a la cantidad de nodos de la lista
        while (contador < size) {
            // Se imprimiran los datos, con un p.getData y avanzando mientras se cumpla lo del while
            System.out.print("[" + p.getData() + "]");
            contador++;
            p = p.getNext();

        }
    }

    /**
     * }
     * Imprime la lista en el sentido inverso, iniciando por la cabeza.
     */
    public void printReverse() {

    }

    public void printAll(int times) {

        // Imprime el tipo de dato del nodo luego de la 
        // instanciación genérica.
        System.out.println(head.getData().getClass().getTypeName());

        StringBuffer sb = new StringBuffer("[");

        Node<E> current = head;
        for (int i = 0; i < times; i++) {
            sb.append(current.getData());
            current = current.getNext();
            if (current != null) {
                sb.append(", ");
            } else {
                sb.append("]");
            }
        }

        System.out.println(sb.toString());

    }
}
