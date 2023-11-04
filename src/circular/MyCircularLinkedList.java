package circular;

public class MyCircularLinkedList<E> {

    private Node<E> head;
    private int size = 0; // Number of elements in the list

    /**
     * Agregar un nodo con el elemento correspondiente al final de la lista o
     * inicio de la lista
     *
     * @param element valor del nodo
     */
    public void add(E element) {

        // Si no se ha creado una lista, se creara con el valor pasado dentro del parametro
        if (head == null) {
            // Se indica que la cabeza sera el nuevo nodo
            head = new Node<E>(element);
            size++; // Aumenta la lista
            // Se incluye return para que finalice el método -> "un else"
            return;
        }

        // Variable temporal apuntando a la cabeza
        Node<E> p = head;

        // En una lista circular, el fin de la misma es la cabeza. Se reemplaza el null de la instrucción por head
        while (p.getNext() != head && size > 1) {
            p = p.getNext(); // Avanzara mientras lo siguiente del ultimo nodo no sea cabeza
        }
        // Se crea un nuevo nodo con el valor pasado
        Node<E> nuevo = new Node<E>(element);
        // Desde el apuntador P conectamos se indica que lo siguiente sera el nuevo nodo
        p.setNext(nuevo);
        // Para indicar que la lista termina. Decimos que lo siguiente del nuevo sera la cabeza
        nuevo.setNext(head);
        size++; // Aumento de la lista

    }

    /**
     * Este metodo añade un nodo como cabeza. Es decir, se agrega de primero
     *
     * @param element
     */
    public void addFirst(E element) {

        // Si la cabeza es igual a nulo y el size es 0. Significa que no se ha creado una lista
        if (head == null && size == 0) {

            // Se crea el nuevo nodo con el valor del parametro
            Node nuevo = new Node(element);
            // Indicamos que la cabeza sera el nuevo nodo
            head = nuevo;
            // Debemos indicar que el final de la lista sera ese mismo nodo (la cabeza)
            nuevo.setNext(nuevo); // De esa manera, se cumple el funcionamiento de la lista circulara
            size++; // Aumenta el size

        } else {
            // Si ya hay una lista. Se crea un apuntador P
            Node p = head;
            // Creacion del nodo
            Node nuevo = new Node(element);
            // Avanzara hasta la ultima posicion. Recordemos que el fin de la lista es la cabeza
            while (p.getNext() != head) {
                p = p.getNext();
            }
            // Cuando ya se encuentra en la ultima posicion hara lo siguiente:

            // Se conecta P con el nuevo nodo
            p.setNext(nuevo);
            // El nuevo se conectara a la cabeza (la antigua)
            nuevo.setNext(head);
            // Se sobreescribe con el nuevo nodo
            head = nuevo;
            size++; // Aumenta el size

        }

    }

    /**
     * Este metodo remueve un nodo de la lista por su valor
     *
     * @param element valor del nodo
     */
    public void remove(E element) {

        // Se crean dos apuntadores en cabeza
        Node p = head; // Este apuntador encuentra al nodo que se va a eliminar de la lista
        Node a = head; // Este apuntador se posiciona detras de P
        // Se toma el valor generico y se crea un nodo con ese valor
        Node obtenerValor = new Node(element);

        // Si el valor a eliminar es igual al de cabeza, la cabeza se eliminara
        if (obtenerValor.getData().equals(head.getData())) {

            head = head.getNext();
            size--;

        } else {
            // Si es un elemento en la mitad o la cola :)

            // Mientras que el nodo que estemos buscando no sea la cabeza y no sea el valor pasado se movera P
            while (p.getNext() != head && p.getData() != obtenerValor.getData()) {
                //System.out.println("e: " + p.getData());
                p = p.getNext();
            }
            // Si sale del ciclo, significa que ha encontrado el nodo
            Node q = p.getNext(); // Este apuntador, se posiciona una posicion despues de P
            // Funcionamiento del apuntador A
            while (a.getNext() != p) {
                a = a.getNext();
            }
            // Desde A, conectamos a Q. Que recordemos que Q, esta una posicion despues y A una posicion antes
            a.setNext(q);
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

        // Creacion de los apuntadores
        Node p = head;
        Node q = head;
        Node a = head;

        // Convertir los datos genericos a un tipo nodo para operar sobre ellos
        Node encontrarNodo = new Node(elementToFind);
        Node nuevo = new Node(elementToAdd);

        // Avanzara hasta encontrar el nodo y termina cuando P lo encontro
        while (!p.getData().equals(encontrarNodo.getData())) {
            p = p.getNext();
        }
        // Avanzara hasta quedar una poisicion antes de P
        while (q.getNext() != p) {

            q = q.getNext();
        }
        // Si P (que cumple el rol de encontrar el nodo) es cabeza hara lo siguiente:
        if (p.getData().equals(head.getData())) {
            // El apuntador A se posiciona una posicion despues de P (o la cabeza como tal)
            a = p.getNext();
            // P se conecta al nuevo nodo
            p.setNext(nuevo);
            // El nuevo nodo se conecta a A para conectar la lista
            nuevo.setNext(a);
            // Se indica que la nueva cabeza es el nuevo nodo
            head = nuevo;
            size++;

        } else {
            // Cuando el nodo a encontrar esta en la cola o en medio
            // Q (que se queda una posicion antes de P) se conecta al nuevo nodo
            System.out.println("q: " + q.getData());
            q.setNext(nuevo);
            // El nuevo nodo se conecta a P
            nuevo.setNext(p);
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

        // Creacion de los tres apuntadores
        Node p = head;
        Node q = head;

        // Convertir los datos genericos a un tipo nodo para operar sobre ellos
        Node encontrarNodo = new Node(elementToFind);
        Node nuevo = new Node(elementToAdd);

        // Avanzara hasta encontrar el nodo
        while (!p.getData().equals(encontrarNodo.getData())) {

            p = p.getNext();
        }
        // Q se posiciona una posicion despues del nodo encontrado (P)
        q = p.getNext();
        // P se conecta al nuevo nodo
        p.setNext(nuevo);
        // El nuevo nodo se conecta a Q (que esta una posicion despues de P)
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

        // Creacion de los apuntadores
        Node p = head;
        Node q = head;
        // Se convierte el valor generico a un tipo nodo
        Node obtenerValor = new Node(elementToFind);

        // Si el elemento a borrar es la cabeza
        if (obtenerValor.getData().equals(head.getData())) {
            // Se crea un apuntador P que se posiciona una posicion despues de la cabeza
            p = head.getNext();
            // Como Q se encuentra en la cabeza. El se conecta a lo siguiente que sea P
            q.setNext(p.getNext());
            size--;

        } else {
            // Avanzara hasta encontrar el nodo 
            while (p.getData() != obtenerValor.getData() && p.getNext() != head) {

                p = p.getNext();

            }

            // El apuntador Q se posiciona una posicion despues de P
            q = p.getNext();

            // El apuntador P conecta lo que este despues de Q
            p.setNext(q.getNext());
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
        Node a = head;
        Node obtenerValor = new Node(elementToFind);

        // Si se ingresa la cabeza
        if (obtenerValor.getData().equals(head.getData())) {

            // Avanzara hasta la ultima posicion
            while (p.getNext() != head) {
                p = p.getNext();
            }
            // Avanzara una posicion antes de p
            while (q != p) {
                q = q.getNext();
            }
            // Desde Q se conecta a la cabeza
            q.setNext(head);
            size--;

        } else {
            // Avanzara mientras no sea el valor a encontrar y no sea la cabeza
            // Este ciclo termina cuando P encuentra el valor del nodo pasado por el parametro
            while (p.getData() != obtenerValor.getData() && p.getNext() != head) {

                p = p.getNext();

            }
            // Avanzara hasta quedar una posicion antes de P
            while (q.getNext() != p) {
                q = q.getNext();
            }
            // Si P a quedado una posicion despues de la cabeza. Q esta apuntando en cabeza. Entonces
            // se pregunta si Q esta en esa posicion, si es asi. Se mueve la cabeza
            if (q.getData().equals(head.getData())) {
                // No es necesario el size-- porque ya se pierde la referencia de head
                head = head.getNext();

            }
            // Avanzara hasta quedar una posicion antes de Q 
            while ((a.getNext() != q) && (a.getNext() != p)) {
                a = a.getNext();

            }
            // Desde A (que esta antes de Q) se conecta a P (que es el nodo a encontrar) Eliminando a Q
            // que sería el nodo anterior
            a.setNext(p);
            size--;

        }

        // return null;
    }

    /**
     * Actualize el valor de un nodo. Busca el nodo con el valor oldElement, y
     * lo reemplaza con el valor newElement. Es importante aclarar que este
     * método no crea un nodo, sino que reemplaza el valor del nodo encontrado.
     *
     * @param newElement valor del nuevo nodo
     * @param oldElement valor del nodo a encontar y cambiar
     */
    public void updateNode(E newElement, E oldElement) {

        // Completar
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

    public void printTwo(int times) {

        // Imprime el tipo de dato del nodo luego de la 
        // instanciación genérica.
        System.out.println(head.getData().getClass().getTypeName());

        StringBuffer sb = new StringBuffer("[");

        Node<E> current = head;
        sb.append(current.getData());
        current = current.getNext();
        if (current != null) {
            sb.append(", ");
        } else {
            sb.append("]");
        }

        for (int i = 0; i < times; i++) {
            sb.append(current.getData());
            current = current.getNext();
            if (current != head) {
                sb.append(", ");
            } else {
                sb.append("]");
            }
        }

        System.out.println(sb.toString());

    }

}
