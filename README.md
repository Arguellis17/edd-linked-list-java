# 🔗 Linked List 🔗
Una lista enlazada es una lista que utiliza __nodos conectados__ para mejorar la eficiencia de las operaciones de agregar y eliminar.  
Las Linked Lists (Listas Enlazadas) son estructuras de datos fundamentales en programación que permiten almacenar y organizar 
elementos de manera secuencial. A diferencia de los arrays estáticos, las Linked Lists ofrecen flexibilidad en la asignación de memoria 
y en la inserción/eliminación de elementos.

[![Howto-Implement-Generic-Linked-Listin-Java.png](https://i.postimg.cc/8CvFPjsk/Howto-Implement-Generic-Linked-Listin-Java.png)](https://postimg.cc/qtkB1B8W)  

En una lista enlazada, cada elemento esta contenido en un objeto, llamado __nodo__. Cuando se añade un elemento a la lista, se crea un nodo para contenerlo. Un nodo se caracteriza por tener un __dato__ y un __puntero__. Es importante mencionar, que se le llama ***head*** al nodo inicial de una Linked List, este nodo no debe de modificarse ni alterarse el comportamiento. Si ese fuera el caso, perderiamos nuestro punto de referencia en una linked list. Cuando un nodo apunta a _null_ significa que es el final de la lista o que no se ha instanciado una. Para enlazar un nodo con otro, utilizamos metodos como: "***getNext()***, y ***setNext()***. 

## 🔑 Características Clave 🔑
- Nodos enlazados: Los elementos se almacenan como nodos, cada uno conteniendo un valor y una referencia al siguiente nodo en la lista.  
- Flexibilidad: Las Linked Lists pueden crecer y encogerse dinámicamente según sea necesario, evitando el desperdicio de memoria.  
- Inserción/eliminación eficiente: Agregar o eliminar elementos en cualquier posición de la lista es eficiente, aunque requiere ajustar 
los enlaces entre los nodos.  
- Tipos: Existen varios tipos de Linked Lists, como Singly Linked Lists (un enlace por nodo), Doubly Linked Lists 
(enlaces a nodos previo y siguiente) y Circular Linked Lists (el último nodo se enlaza con el primero).  
- Punteros: Nos permiten manipular las linked list de acuerdo a nuestras necesidades.  
- Metodos: Una Linked List se compone por una clase llamada Node, posee como atrbuto el valor del nodo y su puntero. También, contiene métodos de suma importancia, como lo son los metodos de enlazar y obtener.


