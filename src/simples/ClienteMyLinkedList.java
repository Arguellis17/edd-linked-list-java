package simples;

/*
¿Que es una Lista Simple?
Una lista enlazada simple es una estructura de datos que consta de nodos, donde cada nodo 
contiene un dato y un enlace al siguiente nodo en la secuencia. En otras palabras, los elementos 
están "enlazados" uno tras otro, y el último nodo generalmente apunta a null para indicar el final de 
la lista. 

Este tipo de estructura facilita la inserción y eliminación de elementos en cualquier posición de la 
lista, pero acceder a un elemento específico puede requerir recorrer la lista desde el principio
*/
public class ClienteMyLinkedList {

    public static void main3(String[] args) {

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
        
        // Agreando elementos a la lista
        lista.add("Perro");
        lista.add("Gato");
        lista.add("Oso");
        lista.add("Panda");

        // Impresion de la lista
        lista.printList();

    }
    
    public static void main(String[] args) {
        
      // Creando lista enlaza | Con Persona
      MyLinkedList<Persona> lista = new MyLinkedList<>();
      
      // Agregando elementos a la lista
      lista.add(new Persona("Juan", 19));
      lista.add(new Persona("Diego", 19));
      lista.add(new Persona("Alex",18));
      lista.add(new Persona("Romer",20));
      
      // Impresion de la lista
      lista.printList();
      
    }
}
