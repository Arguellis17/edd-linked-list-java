package doubles;

public class ClienteMyDoubleLinkedList {

    public static void main(String[] args) {

        // Double Linked List de Enteros
        MyDoubleLinkedList<Integer> listOne = new MyDoubleLinkedList<>();

        // Agregando elementos
        listOne.add(1);
        listOne.add(2);
        listOne.add(3);
        listOne.add(4);

        System.out.println("Lista Original");
        listOne.print();

        // Probando metodos
        try {
            System.out.println("\nLista Nueva");
            //listOne.addAfter(4, 5);
            //listOne.addBefore(4, 5);
            //listOne.remove(4);
            //listOne.removeAfter(3);
            //listOne.removeBefore(3);
            //listOne.updateNode(5, 1);
            //System.out.println("Existe dentro de la lista?: " + listOne.find(3));
            listOne.printReverse();
            System.out.println();
        } catch (Exception e) {
            System.err.println("Nodo no valido");
        }

    }

    public static void main2(String[] args) {
        
        // Creando lista enlazada | Con String
        MyDoubleLinkedList<String> lista = new MyDoubleLinkedList<>();
        
        // Agreando elementos a la lista
        lista.add("Perro");
        lista.add("Gato");
        lista.add("Oso");
        lista.add("Panda");

        // Impresion de la lista
        lista.print();
    }
    
    public static void main3(String[] args) {
        
        // Creando lista enlaza | Con Persona
      MyDoubleLinkedList<Persona> lista = new MyDoubleLinkedList<>();
      
      // Agregando elementos a la lista
      lista.add(new Persona("Juan", 19));
      lista.add(new Persona("Diego", 19));
      lista.add(new Persona("Alex",18));
      lista.add(new Persona("Romer",20));
      
      // Impresion de la lista
      lista.print();
        
    }
}
