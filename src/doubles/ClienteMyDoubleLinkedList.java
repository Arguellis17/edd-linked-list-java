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
            listOne.print();
            System.out.println();
        } catch (Exception e) {
            System.err.println("Nodo no valido");
        }

    }

}
