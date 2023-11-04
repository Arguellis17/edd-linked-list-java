package cicular.doubles;

/*
¿Que es una Lista Circular Doble?
Una lista enlazada doble circular es una estructura de datos en la que cada nodo tiene dos enlaces: 
uno que apunta al siguiente nodo y otro que apunta al nodo anterior en la secuencia. 
La característica adicional es que el último nodo de la lista enlaza con el primer nodo, 
creando un bucle o ciclo. 

Esta estructura permite la navegación en ambas direcciones (hacia adelante y hacia atrás) a lo largo 
de la lista, y al ser circular, no tiene un nodo final clásico. Esto puede ser beneficioso en 
situaciones en las que se necesitan operaciones cíclicas o repetitivas en la lista.

*/
public class ClienteMyDoubleCircularLinkedList {

    public static void main(String[] args) {

        // Lista Circular Doble de Enteros
        MyDoubleCircularLinkedList<Integer> listOne = new MyDoubleCircularLinkedList<>();

        listOne.add(1);
        listOne.add(2);
        listOne.add(3);
        listOne.add(4);

        System.out.println("Lista Orginal");
        listOne.print();

        try {
            System.out.println("\nLista Nueva");
            //listOne.addBefore(2, 5);
            //listOne.addAfter(4,5);
            //listOne.remove(4);
            //listOne.removeAfter(4);
            //listOne.removeBefore(3);
            listOne.print();
            System.out.println();
        } catch (Exception e) {
            System.err.println("Nodo no valido");
        }

    }

    public static void main2(String[] args) {

        // Creando Circular Linked List | Con String
        MyDoubleCircularLinkedList<String> listTwo = new MyDoubleCircularLinkedList<>();

        // Agreando elementos a la lista
        listTwo.add("Perro");
        listTwo.add("Gato");
        listTwo.add("Oso");
        listTwo.add("Panda");

        // Impresion de la lista
        listTwo.print();

    }

    public static void main3(String[] args) {

        // Creando Circular Linked List | Con Persona
        MyDoubleCircularLinkedList<Persona> listThree = new MyDoubleCircularLinkedList<>();

        // Agregando elementos a la lista
        listThree.add(new Persona("Juan", 19));
        listThree.add(new Persona("Diego", 19));
        listThree.add(new Persona("Alex", 18));
        listThree.add(new Persona("Romer", 20));

        // Impresion de la lista
        listThree.print();

    }

}
