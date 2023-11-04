package cicular.doubles;

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
