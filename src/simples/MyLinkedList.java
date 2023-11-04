package simples;

public class MyLinkedList<E> {

    // Inicio del nodo. NUNCA debe moverse, pues de pierde su referencia
    private Node<E> head;
    // Tamaño de la lista enlazada
    private int size = 0;

    // Constructor de la lista enlazada
    public MyLinkedList() {
        // Es nula, porque no se ha añadido nada a la cabeza
        head = null;
    }

    // Preguntar si la lista esta vacia
    public boolean isEmpty() {
        return (head == null) ? true : false;
    }

    // Insertar de ultimo en una lista
    public void insert(E element) {

        // Preguntamos si se ha creado ya cabeza antes
        if (head == null) {
            // Si no es así, cabeza sera igual al nuevo nodo que creamos
            head = new Node(element);
            size++;
        } else {
            // Apuntador en head (referencia del inicio de la lista)
            Node<E> p = head;
            // Se crea un nuevo nodo
            Node<E> nuevo = new Node(element);
            // Preguntamos si lo siguiente de p (que esta en cabeza) es diferente a null
            while (p.getNext() != null) {
                // Si hay algo diferente a nulo (o sea, si ya hay una conexión previa) el avanzara
                p = p.getNext();
            }
            // Cuando llegue a null (fin de la lista) buscara crear el ultimo nodo creado
            p.setNext(nuevo);
            size++;
        }
    }

    // Insertar de primero en una lista
    public void insertFirst(E element) {

        // Si no hay cabeza, el nuevo nodo a agregar sera la cabeza
        if (head == null) {
            head = new Node(element);
            size++;
        } else {
            // Se crea el nodo nuevo a agregar   
            Node<E> nuevo = new Node(element);
            // Este nuevo nodo, se conectara directamente a la cabeza
            nuevo.setNext(head);
            // Cuando el nuevo nodo se haya conectado a la cabeza, la cabeza actual dejara de serlo, pues la nueva cabeza sera el nuevo nodo creado
            head = nuevo;
            // A medida que se llame este metodo, se repetira el mismo proceso, moviendo cabeza hacia el ultimo nuevo nodo instanciado
            size++;

        }

    }

    // Insertar un nodo en una posicion deseada por el usuario
    public void insertNodePosition(E element, int index) {

        // Si el nodo a agregar es en la posicion de la cabeza, el metodo funcionara como el insertFirst
        if (index == 1 || index == 0) {

            Node<E> nuevo = new Node(element);
            nuevo.setNext(head);
            head = nuevo;
            size++;

        } else {
            // Si la posicion a agregar es distinta a la cabeza, se crea un apuntador P en head
            Node<E> p = head;
            // Se crea un contador, para validar las posiciones de la lista e ir moviendo el puntero
            int conteo = 1;
            // Mientras la posicion de la lista sea menor a la posicion buscada, el apuntador y conteo aumentaran hasta llegar a la posicion ingresada
            while (conteo < index) {
                p = p.getNext();
                conteo++;
            }
            // Una vez que se haya encontrado al nodo, se crea un apuntador Q en cabeza
            Node<E> q = head;
            // Mientras lo que le siga al apuntador Q sea diferente al apuntador P, este se movera
            while (q.getNext().getData() != p.getData()) {
                q = q.getNext();
            }
            // Una vez que Q se haya frenado una posicion antes de P. Se crea el nuevo nodo con el valor que se le ha pasado dentro del metodo
            Node<E> nuevo = new Node(element);
            // Se conectan los punteros y aumenta la lista
            q.setNext(nuevo);
            nuevo.setNext(p);
            size++;

        }

    }

    // Eliminar un nodo de la lista por su contenido en ella
    public void remove(E element) {
        // Si el nodo a elimianr es cabeza, se mueve a la siguiente posición y se elimina la cabeza anterior
        if (head.getData().equals(element)) {

            head = head.getNext();
            size--;

        } else {
            // Si es una posición distinta a cabeza, se crea un apuntador en cabeza
            Node<E> p = head;
            // Este apuntador, se movera mientras el dato ingresado sea diferente a uno de los datos del nodo
            while (!p.getData().equals(element)) {
                // Termina el ciclo cuando encuentra al nodo
                p = p.getNext();
            }
            // Se crea un apuntador que inicia desde cabeza
            Node<E> q = head;
            // Este apuntador, se movera con la intención de quedar un nodo antes del nodo a buscar
            while (q.getNext().getData() != p.getData()) {

                q = q.getNext();

            }
            // Una vez el apuntador Q quede antes que P. Se crea el apuntador C, y este se crea una posicion despues de P
            Node<E> c = p.getNext();
            // Por ultimo, se enlaza desde Q hacia C, eliminando el nodo donde estaba el apuntador P :)
            q.setNext(c);
            size--;

        }

    }

    // Eliminar un nodo de la lista por su posicion
    public void removeNodePosition(int index) {

        // Apuntador que comienza desde head
        Node<E> p = head;
        // Contador que se ira moviendo hasta ser igual a la posicion buscada
        int conteo = 1;

        // Mientras la posicion de la lista sea menor a la posicion buscada, el puntero se ira moviendo y la posicion de la lista aumenta
        while (conteo < index) {
            // Es importante recordar, que este while se detiene cuando se ha encontrado la posicion buscada, por lo tanto P ESTA SOBRE ESE NODO BUSCADO
            p = p.getNext();
            conteo++;
        }
        // Si la posicion que se quiere eliminar corresponde al inicio de la lista
        if (index == 1 || index == 0) {
            // Se mueve la cabeza y se elimina la posición
            head = head.getNext();
            size--;
        }
        // Cuando es una posición distinta a cabeza...
        if (conteo != 1) {
            // se crea un apuntador siguiente de p
            Node<E> q = p.getNext();
            // Se crea un apuntador que inicie desde cabeza
            Node<E> c = head;
            // Mientras el apuntador inicial sea diferente a p, se movera. Con el objetivo, que quede una posición antes de p
            while (c.getNext() != p) {

                c = c.getNext();
            }
            // Cuando el apuntador c ya esta detras del apuntador p, solo queda conectar c hacia q, pues es el que esta delante del apuntador p :)
            // En caso de que p sea la cola, c apuntara a nulo, cortando indirectamente en enlace que tenia p a la lista enlazada
            c.setNext(q);
            size--;

        }

    }

    // Obtener la posicion de un nodo de la lista
    public String getNodePosition(int index) {

        // Puntero que inicia en cabeza
        Node<E> p = head;
        // Un contador que nos ayudara a comparar la posición que estamos buscando con la que tenemos actualmente
        int conteo = 1;
        // Mientras nuestra posición sea menor a la que se busca, el apuntador se movera
        while (conteo < index) {
            p = p.getNext();
            conteo++;
        }
        // Si nuestra posicón es igual o superada por la buscada, significa que hemos encontrado nuestro nodo
        return p.getData().toString();

    }

    // Obtener tamaño de la lista enlazada
    public int getListSize() {

        return size;
    }

    // Limpiar la lista enlazada
    public void clear() {
        // Si cabeza es nula, se limpiara la cabeza
        head = null;
        size = 0;
    }

    // Obtener la cabeza de la lista
    public String getHead() {

        // Puntero en cabeza
        Node<E> p = head;
        // Un nodo que guarde el valor de la cabeza
        Node<E> save = new Node(p.getData());
        // Devolver el dato
        return save.getData().toString();
    }

    // Obtener la cola de la lista
    public String getTail() {
        // Puntero en cabeza
        Node<E> p = head;
        // Con este while, nos movemos hacia el final de la lista
        while (p.getNext() != null) {
            p = p.getNext();
        }
        // Cuando lleguemos al final de la lista, guardaremos el dato de ese nodo
        Node<E> save = new Node(p.getData());
        // Devolvemos el valor
        return save.getData().toString();

    }

    // Imprimir la lista enlazada
    public void printList() {
        Node<E> current = head; // Empezamos desde la cabeza

        System.out.print("Lista: ");

        while (current != null) {
            System.out.print("[" + current.getData() + "]");
            current = current.getNext(); // Mover al siguiente nodo
        }

        System.out.println(); // Salto de línea al final
    }

}
