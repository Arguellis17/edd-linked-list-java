package simples;

public class MyLinkedList<E> {

    // Inicio del nodo. NUNCA debe moverse, pues se pierde su referencia
    private Node<E> head;
    // Tamaño de la lista enlazada
    private int size = 0;

    // Preguntar si la lista esta vacia
    public boolean isEmpty() {
        return (head == null);
    }

    /**
     * Agregar un nodo a la lista
     *
     * @param element: Valor del nodo
     */
    public void add(E element) {

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

    /**
     * Agregara a la lista un nodo como cabeza
     *
     * @param element: Valor del nodo
     */
    public void addFirst(E element) {

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

    /**
     * Agrega un nodo en una posicion especifica de la lista
     *
     * @param element: Nodo a agregar
     * @param index: Posicion a agregar
     */
    public void addNodePosition(E element, int index) {

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

    /**
     * Agrega un elemento a la lista de manera ordenada
     *
     * @param val valor a agregar
     */
    public void addOrdered(E val) {
        // Se crea el nuevo nodo
        Node nuevo = new Node((E) val);

        if (head == null) {
            head = nuevo;
            size++;
        } else {
            Node p = head;
            if (p.getData() instanceof Integer) {
                if ((int) p.getData() > (int) val) {
                    // Conecta a cabeza cuando es menor (añade al inicio
                    nuevo.setNext(p);
                    head = nuevo;
                } else {
                    // Conecta a la cola directamente cuando es mayor
                    if (p.getNext() == null) {
                        p.setNext(nuevo);
                    } else {
                        // Se agrega que p sea diferente de nulo, pues el seguira preguntando a medida que avance la lista
                        while (p != null && (int) p.getData() < (int) val) {
                            p = p.getNext();
                        }
                        //System.out.println("P: " + p.getData());
                        //System.out.println("Q: " + q);
                        Node q = head;

                        while (q.getNext() != p) {
                            q = q.getNext();
                        }

                        q.setNext(nuevo);
                        nuevo.setNext(p);
                        // System.out.println("q: " + q.getData() );
                        //System.out.println("p: " + p.getData());
                    }
                }

            } else if (p.getData() instanceof Object) {

                Comparable edadComparable = (Comparable) p.getData();
                if (edadComparable.compareTo((Comparable) val) > 0) {
                    // Conecta a cabeza cuando es menor (añade al inicio
                    nuevo.setNext(p);
                    head = nuevo;
                } else {
                    // Conecta a la cola directamente cuando es mayor
                    if (p.getNext() == null) {
                        p.setNext(nuevo);
                    } else {
                        // Se agrega que p sea diferente de nulo, pues el seguira preguntando a medida que avance la lista
                        while (p != null && edadComparable.compareTo((Comparable) val) < 0) {
                            p = p.getNext();
                        }
                        //System.out.println("P: " + p.getData());
                        //System.out.println("Q: " + q);
                        Node q = head;

                        while (q.getNext() != p) {
                            q = q.getNext();
                        }

                        q.setNext(nuevo);
                        nuevo.setNext(p);
                        // System.out.println("q: " + q.getData() );
                        //System.out.println("p: " + p.getData());
                    }
                }

            } else if (p.getData() instanceof String) {
                Comparable<String> strComparable = (Comparable<String>) p.getData();
                if (strComparable.compareTo((String) val) > 0) {
                    // Conecta a cabeza cuando es menor (añade al inicio)
                    nuevo.setNext(p);
                    head = nuevo;
                } else {
                    // Conecta a la cola directamente cuando es mayor
                    if (p.getNext() == null) {
                        p.setNext(nuevo);
                    } else {
                        // Se agrega que p sea diferente de nulo, pues él seguirá preguntando a medida que avance la lista
                        while (p != null && strComparable.compareTo((String) val) < 0) {
                            p = p.getNext();
                        }

                        Node q = head;

                        while (q.getNext() != p) {
                            q = q.getNext();
                        }

                        q.setNext(nuevo);
                        nuevo.setNext(p);
                    }
                }

            }
        }
    }

    /**
     * Elimina un nodo de la lista por su valor
     *
     * @param element: Valor del nodo a eliminar
     */
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

    /**
     * Elimina un nodo por su posicion
     *
     * @param index: Posicion del nodo a eliminar
     */
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

    /**
     * Devuelve el nodo de una lista por su posicion (NO elimina)
     *
     * @param index: Posicion del nodo a devolver
     * @return nodo buscado
     */
    public int getNodePosition(int index) {

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
        return (int) p.getData();

    }

    // Limpiar la lista enlazada
    public void clear() {
        // Si cabeza es nula, se limpiara la cabeza
        head = null;
        size = 0;
    }

    /**
     * Devuelve la cabeza de la lista
     *
     * @return
     */
    /**
     * Obtiene la cabeza de la lista
     *
     * @return devuelve el head
     */
    public Node getHead() {

        return head;
    }

    /**
     * Devuelve la cola de una lista
     *
     * @return retorna el dato de la cola
     */
    public E getTail() {

        Node p = head;

        while (p.getNext() != null) {
            p = p.getNext();

        }

        return (E) p.getData();

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

    /**
     * Imprime el elemento de mayor valor en una lista
     */
    public void imprimirMayor() {

        Node<E> p = head;
        if (p != null) {
            E mayor = p.getData();
            while (p != null) {

                Comparable cMayor = (Comparable) mayor;
                Comparable cDato = (Comparable) p.getData();

                if (cMayor.compareTo(cDato) < 0) {
                    mayor = p.getData();

                }

                p = p.getNext();
            }

            System.out.println(mayor);
        }

    }

    /**
     * Imprime los elementos que sean mayores a un valor de una lista
     *
     * @param valor: Imprime los elementos mayores al valor
     */
    public void imprimirMayores(E valor) {

        // Recorre cada nodo
        Node<E> p = head;
        // Se dice que mientras P sea diferente de nulo, para que P tome uno a uno correctamente
        // Ya que si se pregunta que lo siguiente de P no sea nulo y esta fuera de nuestra condicion
        // No tomaria el ultimo nodo 
        while (p != null) {
            // Verificar si el valor que se pasa en el metodo es un String
            if (valor instanceof String) {
                // Obtener el valor del nodo en un String
                String valorNodo = (String) p.getData();

                if (valorNodo.compareTo((String) valor) > 0) {
                    System.out.println(valorNodo + " - ");
                }
                // Si el valor es una instancia de un Integer
            } else if (valor instanceof Integer) {

                // Convertir el valor pasado en un entero
                int eValor = (Integer) valor;

                // Obtener el valor del nodo en un entero
                int eNodo = (Integer) p.getData();

                // Comparamos el valor de los nodos con el valor pasado en el argumento
                if (eNodo > eValor) {
                    System.out.println(eNodo + " - ");
                }

            } else {
                // Si se esta pasando un objeto se llama al metodo compareTo
                // que ya se encuentra sobreescrito en la clase Persona y Mascota, funcionando en función de la edad
                Comparable obtenerPersona = (Comparable) p.getData();
                // Ya una vez que se a obtenido una persona o Mascota, el valor pasado en el argumento es casteado a uno
                // Comparable, para que actue como la persona aux de nuestro metodo compareTo
                if (obtenerPersona.compareTo((Comparable) valor) > 0) {
                    System.out.println(p.getData() + " - ");
                }

            }
            // P avanzará mientras se cumpla la condicion
            p = p.getNext();

        }

    }

    /* 
    * Se obtiene el tamaño de la lista
     */
    public int getSize() {
        return size;
    }

    /**
     * Elimina un nodo dos posiciones despues
     *
     * @param pos: Posicion a eliminar (desplaza dos)
     */
    public void removeAfterTwo(int pos) {

        // Creacion de los punteros
        Node p = head;
        Node q = head;
        Node a = head;

        // Contador que nos permitira validar posiciones
        int contador = 0;

        // Mientras que el contador sea menor a la posicion, mover a P
        while (contador < pos - 1) {
            p = p.getNext();
            contador++;
        }
        // Cuando termina el while, signfica que lo encontro al nodo por su posicion
        if (p.getData().equals(head.getData())) { // Si la pos es cabeza

            // Q se posiciona una posicion despues de P
            q = p.getNext();

            // A se posiciona una posicion despues de Q
            a = q.getNext();

            // Q se conectara a lo que este despues de A
            q.setNext(a.getNext());

            // Se reduce la lista
            size--;

        } else {

            q = p.getNext();

            a = q.getNext();

            // Si la segunda posicion es un nulo, se informa que no se podria
            if (q.getNext() == null) {
                System.err.println("No hay nada por borrar");
                return;
            }
            q.setNext(a.getNext());

            size--;
        }
    }

    /**
     * Agrega un elemento a la lista y lo agrega dos posiciones despues
     *
     * @param val: Elemento a agregar
     * @param pos: Posicion de la lista (se desplaza dos)
     */
    public void addAfterTwo(E val, int pos) {

        Node p = head;
        Node q = head;
        Node a = head;
        Node nuevo = new Node(val);
        int contador = 0;

        while (contador < pos - 1 && p != null) {

            p = p.getNext();
            contador++;
        }
        if (p.getData().equals(head.getData())) {

            q = p.getNext().getNext();
            a = q.getNext();
            q.setNext(nuevo);
            nuevo.setNext(a);

            return;
        }
        if (p.getNext() == null) {

            p.setNext(nuevo);
            return;
        }
        a = p.getNext();
        q = p.getNext().getNext();
        if (q == null) {
            a.setNext(nuevo);

        } else {
            a = q.getNext();
            q.setNext(nuevo);
            nuevo.setNext(a);

        }
        size++;

    }

    /**
     * Crea una lista del tipo Integer de manera aleatoria
     *
     * @param list: Lista a crear
     * @param size: Tamaño a crear de la lista
     */
    public static void llenarAleatorio(MyLinkedList<Integer> list, int size) {

        // Dentro de la lista 
        for (int i = 0; i < size; i++) {
            int randomData = (int) (Math.random() * 10) + 1;
            list.add(randomData);
        }
    }

    /**
     * Crea una nueva lista a partir de los elementos de tres listas. Sumandolos
     * uno en uno, dos en dos y así sucesivamente.
     *
     * @param one: Lista Uno
     * @param two: Lista Dos
     * @param three: Lista Tres
     */
    public void devolverSumaLista(MyLinkedList<Integer> one, MyLinkedList<Integer> two, MyLinkedList<Integer> three) {

        // No supe como hacerlo para longitudes distintas :VVVVV
        if (one.getSize() != two.getSize() || one.getSize() != three.getSize()) {

            System.out.println("Las longiudes no coinciden");

        } else {

            // Se crea la nueva lista
            MyLinkedList<Integer> listaSuma = new MyLinkedList<>();

            // Estas variables enteras nos permitiran obtener los data de las listas y nos permitiran sumar
            int dataListOne = 0;
            int dataListTwo = 0;
            int dataListThree = 0;

            // Se crean unos apuntadores y a traves del metodo obtenerCabeza se posicionan al inicio de la lista
            Node p = one.getHead();
            Node q = two.getHead();
            Node a = three.getHead();

            // Se llenara hasta la penultima posicion
            while (p.getNext() != null && q.getNext() != null && a.getNext() != null) {

                dataListOne = (int) p.getData();
                dataListTwo = (int) q.getData();
                dataListThree = (int) a.getData();
                p = p.getNext();

                q = q.getNext();

                a = a.getNext();

                listaSuma.add(dataListOne + dataListTwo + dataListThree);

            }
            // Ahora falta llenar la ultima posicion XDD
            int lastPosOne = (int) one.getTail();
            int lastPosTwo = (int) two.getTail();
            int lastPosThree = (int) three.getTail();

            listaSuma.add(lastPosOne + lastPosTwo + lastPosThree);

            // Se imprime la lista con las sumas
            listaSuma.printList();

        }

    }

    /**
     * Suma los valores de una lista de tipo Integer
     *
     * @param listToSum: Se ingresa la lista a sumar todos sus elementos
     */
    public void sumarLista(MyLinkedList<Integer> listToSum) {

        Node p = head;
        int valPrev = 0;
        int valNext = 0;
        int sum = 0;
        // Recorre la lista
        while (p.getNext() != null) {

            // Obtiene el valor anterior
            valPrev = (int) p.getData();
            valPrev += valPrev; // Y lo ira sumando a medida de que lo obtenga

            // Cuando avance
            p = p.getNext();
            valNext = (int) p.getData(); // Obtiene el valor siguiente

            // Los valores anteriores que ya se encuentran sumados, se suman al siguiente
            sum = valPrev + valNext;

        }

        System.out.println("Suma Total: " + sum);

    }

    /**
     * Agregar un nodo de acuerdo a la posicion de un nodo buscado
     *
     * @param dataNodeToFind: Nodo a encontrar y agregar en la posicion
     * @param dataNodeToInsert: Nodo a insertar en la posicion del nodo buscado
     */
    public void addNodeForData(E dataNodeToFind, E dataNodeToInsert) {
        // Apuntador que inicia en la cabeza
        Node p = head;

        // Se convierten los valores genericos a un tipo nodo
        Node nuevo = new Node((E) dataNodeToInsert);
        Node find = new Node((E) dataNodeToFind);

        // Avanzara hasta encontrar el nodo que queremos buscar
        while (p.getData() != find.getData()) {
            p = p.getNext();

        }
        // Como se trabaja con generecidad, debemos evaluar que instancia de dato se pasa en el metodo

        // Cuando los datos son del tipo entero
        if (p.getData() instanceof Integer) {
            // Se castea el tipo de dato a entero 
            // OJO: RECORDAR QUE P YA ENCONTRO AL NODO Y OBTIENE ESE NODO ENCONTRADO AQUÍ
            int nodoEnteroFind = (int) p.getData();

            // Si el nodo esta en la cabeza
            if (nodoEnteroFind == (int) head.getData()) {
                // Se conectan los apuntadores
                nuevo.setNext(p);
                head = nuevo;
                size++;
            } else {
                // Si es diferente de cabeza 
                Node a = head;
                while (a.getNext() != p) {
                    a = a.getNext();
                }
                a.setNext(nuevo);
                nuevo.setNext(p);
                size++;

            }

            // Caso 2: Si la instancia del dato es del tipo String
        } else if (p.getData() instanceof String) {
            // Con el metodo equals, comparamos si el dato ingresado es igual a la cabeza
            if (p.getData().equals(head.getData())) {
                // Conectar apuntadores
                nuevo.setNext(p);
                head = nuevo;
                size++;
            } else {
                // Si es diferente de cabeza
                Node a = head;
                while (a.getNext() != p) {
                    a = a.getNext();
                }
                a.setNext(nuevo);
                nuevo.setNext(p);
                size++;

            }
            // Caso 3: Si la instancia del dato es del tipo Object (Persona o Mascota)
        } else if (p.getData() instanceof Object) {
            // Con el metodo equals, comparamos si el dato ingresado es igual a la cabeza
            if (p.getData().equals(head.getData())) {
                // Conectar apuntadores
                nuevo.setNext(p);
                head = nuevo;
                size++;
            } else {
                // Si la posicion es diferente de cabeza
                Node a = head;
                while (a.getNext() != p) {
                    a = a.getNext();
                }
                a.setNext(nuevo);
                nuevo.setNext(p);
                size++;
            }

        }
    }

    /**
     * Obtener un nodo de acuerdo a su posicion
     *
     * @param pos: Posicion a buscar en la lista
     * @return devuelve el nodo
     */
    public E get(int pos) {
        Node p = head;
        int contador = 0;
        if ((pos == 1 || pos == 0)) {
            return (E) p.getData();
        } else {
            while (contador < pos - 1) {
                p = p.getNext();
                contador++;
            }

        }
        return (E) p.getData();
    }

    /**
     * Imprime la lista completa.
     *
     * @return String con la información de los elementos contenidos
     */
    public String printTwo() {
        // Se crea un objeto que guardará el resultado
        // de la concatenación. Se podría haber usado un
        // String también.
        StringBuffer sb = new StringBuffer("[");

        Node<E> current = head;
        for (int i = 0; i < size; i++) {
            sb.append(current.getData());
            current = current.getNext();
            if (current != null) {
                sb.append(", ");
            } else {
                sb.append("]");
            }
        }

        return sb.toString();
    }

    /**
     * Remueve un nodo de la lista de acuerdo a su posicion
     * 
     * @param pos: Posicion del nodo a eliminarw
     */ 
    public void removePos(int pos) {
        // Se posiciona un apuntador en cabeza
        Node p = head;
        int contador = 0;
        // Si la posicion que se eliminara esta en la cabeza
        if ((pos == 1 || pos == 0)) {
            head = head.getNext();
            size--;
        } else {
            // Avanzara hasta ser igual a la posicion
            while (contador < pos - 1) {
                p = p.getNext();
                contador++;
            }
            // El apuntador Q sera igual a la posicion siguiente de P
            Node q = p.getNext();
            Node a = head;
            // El apuntador A avanzara hasta que lo siguiente de el no sea P (queda atras de P)
            while (a.getNext() != p) {
                a = a.getNext();
            }
            // Desde el apuntador A se conecta a Q, eliminando a P
            a.setNext(q);

        }

    }

}
