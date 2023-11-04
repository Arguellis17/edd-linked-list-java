package circular;

public class ClienteMyCircularLinkedList {

    public static void main(String[] args) {

        // Lista circular | Con Integer
        MyCircularLinkedList<Integer> listOne = new MyCircularLinkedList<>();

        listOne.add(1);
        listOne.add(2);
        listOne.add(3);
        listOne.add(4);

        System.out.println("Lista Original");
        listOne.print();

        try {

            System.out.println("\nLista Nueva");
            //listOne.addBefore(3, 5);
            //listOne.addAfter(3, 5);
            //listOne.remove(20);
            //listOne.removeAfter(1);
            //listOne.removeBefore(2);
            listOne.print();
            System.out.println();
        } catch (Exception e) {
            System.err.println("Nodo no valido");

        }

    }
    
    public static void main2(String[] args) {
        
        // Creando lista enlazada | Con String
        MyCircularLinkedList<String> listTwo = new MyCircularLinkedList<>();
        
        // Agreando elementos a la lista
        listTwo.add("Perro");
        listTwo.add("Gato");
        listTwo.add("Oso");
        listTwo.add("Panda");

        // Impresion de la lista
        listTwo.print();
    }
    
    public static void main3(String[] args) {
        
        // Creando lista enlaza | Con Persona
      MyCircularLinkedList<Persona> listThree = new MyCircularLinkedList<>();
      
      // Agregando elementos a la lista
      listThree.add(new Persona("Juan", 19));
      listThree.add(new Persona("Diego", 19));
      listThree.add(new Persona("Alex",18));
      listThree.add(new Persona("Romer",20));
      
      // Impresion de la lista
      listThree.print();
        
    }

}
