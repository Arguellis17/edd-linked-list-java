package doubles;

public class MyDoubleLinkedList<E> {

    private Node<E> head;
    private int size = 0; // Number of elements in the list

    /**
     * Agregar un nodo con el elemento correspondiente al final de la lista o
     * inicio de la lista
     *
     * @param element nodo a agregar
     */
    public void add(E element) {

        // Si no se ha instanciado una lista
        if (head == null) {
            // La cabeza sera el nuevo nodo creado
            head = new Node<E>(element);
            size++;
            // Se incluye return para que finalice el método
            return;
        } else {

            // Variable temporal apuntando a la cabeza
            Node<E> p = head;

            // El while finaliza cuando p llega hasta el ultimo nodo creado   
            while (p.getNext() != null) {
                p = p.getNext();
            }
            // Se crea el nuevo nodo
            Node<E> newNode = new Node<E>(element);
            // Desde P se conecta al nuevo nodo
            p.setNext(newNode);
            // El anterior del nuevo nodo creado sera P
            newNode.setPrev(p);
            size++;
        }

    }

    /**
     * Busca un elemento dentro de una lista, y lo elimina.
     * @param element nodo a eliminar
     */
    public void remove(E element) {

        // Creacion de los punteros
        Node p = head;
        Node q = head;
        Node a = head;

        // Se castea el elemento generico a un nodo
        Node<E> obtenerNodo = new Node(element);

        // Avanzara hasta encontrar el nodo
        while (!p.getData().equals(obtenerNodo.getData())) {

            p = p.getNext();

        }
        // Si el nodo a eliminar es la cabeza
        if (p.getData().equals(head.getData())) {

            // Se mueve la cabeza
            head = head.getNext();
            size--;
            System.out.println("sos");
        } else {
            // El apuntador Q siempre se queda una posicion despues de P
            q = p.getNext();
            // Si el elemento a eliminar esta en la cola 
            if (q == null) {
                // El apuntador A se queda una posicion antes de P
                while (a.getNext() != p) {
                    a = a.getNext();
                }
                // Como el apuntador Q esta en nulo, simplemente se indica que lo siguiente de A
                // sera un null o Q
                a.setNext(q);
                size--;

            } else {
                // Para cuando el elemento a eliminar esta en el medio de la lista
                while (a.getNext() != p) {
                    a = a.getNext();
                }
                // Como el apuntador A esta antes de P y el apuntador Q despues de P
                // Se conecta desde A hasta Q respectivamente
                a.setNext(q);
                q.setPrev(a);
                size--;

            }
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
        Node q = head;

        // Convertir los parametros a un tipo nodo
        Node obtenerNodo = new Node(elementToFind);
        Node nuevo = new Node(elementToAdd);

        // Avanzara hasta encontrar el nodo
        while (!p.getData().equals(obtenerNodo.getData())) {

            p = p.getNext();
        }
        // Si el elemento se encuentra en la cabeza
        if (p.getData().equals(head.getData())) {

            p.setPrev(p);
            nuevo.setNext(p);
            head = nuevo;
            size++;
        } else {
            // Si el elemento a agregar se encuentra en la cola o en medio de la lista
            while (q.getNext() != p) {

                q = q.getNext();
            }

            q.setNext(nuevo);
            nuevo.setPrev(q);
            nuevo.setNext(p);
            p.setPrev(nuevo);
            size++;

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

        // Creacion de los punteros
        Node p = head;
        Node q = head;

        // Convertir los parametros a un nodo
        Node<E> obtenerNodo = new Node(elementToFind);
        Node<E> nuevo = new Node(elementToAdd);

        // Avanzara hasta encontrar el nodo buscado
        while (!p.getData().equals(obtenerNodo.getData())) {

            p = p.getNext();
        }
        // El apuntador Q se posiciona una posicion despues de P
        q = p.getNext();

        // Si el nodo a encontrar es la cola, se pregunta si Q es nulo (porque siempre estara despues de P)
        if (q == null) {
            // P se conecta al nuevo nodo
            p.setNext(nuevo);
            // El nuevo nodo se conecta hasta P
            nuevo.setPrev(p);
            size++; // Aumenta la lista

        } else {
            // Si el nodo a agregar esta despues de la cabeza o en medio de la lista
            // P se conecta al nuevo nodo
            p.setNext(nuevo);
            // El nuevo nodo se conecta lo que seguia despues de P
            nuevo.setNext(q);
            // El anterior del nuevo sera P
            nuevo.setPrev(p);
            // Lo anterior de Q sera el nuevo nodo
            q.setPrev(nuevo);
            size++; // Aumenta la lista
        }

    }

    /**
     * Este método busca un nodo que contenga el valor elementToFind y elimina
     * el nodo siguiente.
     *
     * @param elementToFind Elemento a encontrar para eliminar el nodo
     * siguiente.
     */
    public void removeAfter(E elementToFind) {

        // Creacion de los parametros
        Node p = head;
        Node q = head;
        Node a = head;

        // Convertir el parametro a un tipo nodo
        Node obtenerNodo = new Node(elementToFind);

        // Avanzara hasta encontrar el nodo
        while (!p.getData().equals(obtenerNodo.getData())) {

            p = p.getNext();
        }
        // El apuntador Q se posiciona una posicion despues de P
        q = p.getNext();
        // El apuntador A se posiciona una posicion despues de Q
        a = q.getNext();
        // Si el apuntador A es nulo, significa que se desea eliminar el ante penultimo nodo de la lista
        if (a == null) {

            p.setNext(a);

            size--;
        } else {
            // Para eliminar en medio de la lista o tomar la referencia de la cabeza    
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

        // Creacion de los punteros
        Node p = head;
        Node q = head;
        Node a = head;

        // Convertir el parametro generico a un nodo
        Node obtenerNodo = new Node(elementToFind);

        // Avanzara hasta encontrar el nodo
        while (!p.getData().equals(obtenerNodo.getData())) {

            p = p.getNext();

        }
        // Q siempre se posicionara antes de Ps
        q = p.getPrev();

        // Se coloca este if para evitar un error en el codigo XDDDD
        if (p.getData().equals(head.getData())) {
            System.err.println("No hay nada que eliminar");
            return;
        }
        // Si el elemento a eliminar es la cabeza: Se pregunta si el dato es lo siguiente de cabeza
        if (p.getData().equals(head.getNext().getData())) {
            // Se mueve la cabeza
            head = head.getNext();
            size--;

        } else {
            // Si elemento a eliminar se encuentra en medio de la lista
            // A avanzara hasta quedar atras de Q
            while (a.getNext() != q) {
                a = a.getNext();
            }
            // Desde A se conecta P
            a.setNext(p);
            // El anterior de P sera A, omitiendo al apuntador Q (eliminandolo)
            p.setPrev(a);
            size--;

        }
    }

    /**
     * Actualize el valor de un nodo. Busca el nodo con el valor oldElement, y
     * lo reemplaza con el valor newElement. Es importante aclarar que este
     * método no crea un nodo, sino que reemplaza el valor del nodo encontrado.
     *
     * @param newElement valor a cambiar del nodo
     * @param oldElement valor del nodo a buscar
     */
    public void updateNode(E newElement, E oldElement) {

        // Creacion de los punteros
        Node p = head;
        Node q = head;
        Node a = head;

        // Conversion de los parametros
        Node nuevo = new Node(newElement);
        Node obtenerNodo = new Node(oldElement);

        // Avanzara hasta encontrar el nodo
        while (!p.getData().equals(obtenerNodo.getData())) {
            p = p.getNext();
        }
        // Una vez que lo encuentra, se le asigna el nuevo valor
        p.setData(nuevo.getData());

    }

    /**
     * Busca dentro de la lista en busca del elemento pasado por parámetro
     *
     * @param element Elemento a buscar en la lista
     * @return True/False dependiendo de si lo encuentra
     */
    public boolean find(E element) {
        
        // Apuntador inicial
        Node<E> current = head;

        do {
            E ele = current.getData();

            if (ele.equals(element)) {
                return true;
            } else {
                current = current.getNext();
            }

        } while (current != null);

        return false;
    }

    /*
     *Impresion de la lista inversamente
     */
    public void printReverse() {

        // Apuntador que inica en cabeza
        Node p = head;

        // Recorre toda la lista
        while (p.getNext() != null) {

            p = p.getNext();

        }
        // El apuntador Q se posiciona en la misma posicion de P (ultimo nodo)
        Node q = p;
        // Mientras que q no sea nulo avanzara inversamente, tomando los datos
        while (q != null) {
            System.out.print("[" + q.getData() + "]");
            q = q.getPrev();
        }

    }

    /*
     * Impresion de la lista doblemente enlzada
     */
    public void print() {

        Node p = head;

        while (p != null) {
            System.out.print("[" + p.getData() + "]");
            p = p.getNext();
        }

    }

    /**
     * @param printTwo impresion de la lista version 2
     */
    public void printTwo() {

        //Imprime el tipo de dato del nodo luego de la 
        //instanciación genérica.
        //System.out.println(head.getData().getClass().getTypeName());
        StringBuffer sb = new StringBuffer("[");
        Node<E> current = head;
        for (int i = 0; i < size; i++) {
            //System.out.println(current.getData());
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
