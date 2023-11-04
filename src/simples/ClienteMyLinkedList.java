package simples;

public class ClienteMyLinkedList {

    public static void main1(String[] args) {

        // Creando lista enlazada | Con Enteros
        MyLinkedList lista = new MyLinkedList();

        // Preguntar si esta vacia
        //System.out.println("Lista Vacia?: " + lista.isEmpty());
        
        // Agreando elementos a la lista
        lista.insert(1);
        lista.insert(2);
        lista.insert(3);
        lista.insert(4);

        // Preguntar si esta vacia
        //System.out.println("Lista Vacia?: " + lista.isEmpty());
        
        // Agregando elementos con insertFirst
//        lista.insertFirst(1);
//        lista.insertFirst(2);
//        lista.insertFirst(3);
//        lista.insertFirst(4);

        // Agregando un nodo en una posicion deseada
        lista.insertNodePosition(5, 4);

        // Eliminar un nodo de la lista
//        lista.remove(3);

        // Eliminar un nodo de la lista (Por Posicion)
//           lista.removeNodePosition(2);

        // Eliminar un nodo de la lista por su contenido
//        lista.remove(3);

        // Metodos varios        
//        System.out.println("Haz buscado a: " + lista.getNodePosition(2));
        System.out.println("Cabeza es: " + lista.getHead());
        System.out.println("Tail es: " + lista.getTail());
        System.out.println("El size de la lista es de: " + lista.getListSize());
        lista.printList();
//        System.out.println("\nLimpiando lista...");
//        lista.clear();

    }

    public static void main(String[] args) {

        // Creando lista enlazada | Con String
        MyLinkedList lista = new MyLinkedList();

        // Preguntar si esta vacia
//        System.out.println("Lista Vacia?: " + lista.isEmpty());
        // Agreando elementos a la lista
        lista.insert("Juan");
        lista.insert("Diego");
        lista.insert("Alex");
        lista.insert("Romer");

        // Agregando elementos con insertFirst
//        lista.insertFirst("Messi");

        // Preguntar si esta vacia
//        System.out.println("Lista Vacia?: " + lista.isEmpty());

        // Agregando un nodo en una posicion deseada
        lista.insertNodePosition("Andree", 4);

        // Eliminar un nodo de la lista
        // lista.remove("Juan");
        //lista.removeNodePosition(0);
        
        // Metodos varios
        lista.printList();
        System.out.println("Cabeza es: " + lista.getHead());
        System.out.println("Tail es: " + lista.getTail());
        System.out.println("El size de la lista es de: " + lista.getListSize());
        System.out.println("Haz buscado a: " + lista.getNodePosition(2));
        

    }
}
