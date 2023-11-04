package simples;

public class ClienteMyLinkedList {

    public static void main(String[] args) {

        // Creando lista enlazada | Con Enteros
        MyLinkedList lista = new MyLinkedList();

        // Preguntar si esta vacia
        //System.out.println("Lista Vacia?: " + lista.isEmpty());
        // Agreando elementos a la lista
        lista.add(1);
        lista.add(2);
        lista.add(3);
        lista.add(4);

        // Imprimiendo la lista
        lista.printList();

        // Metodos 
//        System.out.print("Mayor: ");lista.imprimirMayor();
//        lista.imprimirMayores(2);
//        System.out.println("Size: " + lista.getSize());
//        System.out.println("Head: " + lista.getHead());
//        lista.removeAfterTwo(3);
//        lista.printList();

        // Se deja la estructura de un try-catch para manejar futuras excepciones
//          try{
//          System.out.println(lista.getNodePosition(2));
//          }catch(Exception e){
//              System.err.println("Nodo no valido");   
//          }
    }

    public static void main1(String[] args) {

        // Creando lista enlazada | Con String
        MyLinkedList lista = new MyLinkedList();

        // Preguntar si esta vacia
//        System.out.println("Lista Vacia?: " + lista.isEmpty());
        // Agreando elementos a la lista
        lista.add("Juan");
        lista.add("Diego");
        lista.add("Alex");
        lista.add("Romer");

        lista.printList();

    }
}
