/**
 * Clase Nodo - Elemento de la lista enlazada de la Pila
 * 
 * Representa un nodo individual en la estructura de lista enlazada de la pila.
 * Cada nodo contiene un objeto Pizza y una referencia al siguiente nodo.
 * 
 * Esta es una clase auxiliar utilizada internamente por la clase Pila
 * para implementar la estructura de datos LIFO (Last In, First Out).
 * 
 * @author Pizza-Track Team
 * @version 1.0
 */
public class Nodo {
    
    /**
     * Referencia al objeto Pizza almacenado en este nodo
     * 
     * Acceso: package-private (visible dentro del mismo paquete)
     */
    Pizza pizza;
    
    /**
     * Referencia al siguiente nodo en la lista enlazada
     * 
     * - Si es null: este es el último nodo de la pila
     * - Si no es null: apunta al siguiente nodo en la cadena
     * 
     * Acceso: package-private (visible dentro del mismo paquete)
     */
    Nodo siguiente;
    
    /**
     * Constructor de Nodo
     * 
     * Crea un nuevo nodo con una pizza específica e inicializa
     * la referencia al siguiente nodo como null.
     * 
     * @param pizza El objeto Pizza a almacenar en este nodo
     * 
     * Ejemplo:
     *   String[] ingredientes = {"Tomate", "Queso", "Pepperoni"};
     *   Pizza p = new Pizza("Pepperoni", ingredientes);
     *   Nodo n = new Nodo(p);
     *   // n.pizza = p, n.siguiente = null
     */
    Nodo(Pizza pizza) {
        this.pizza = pizza;
        this.siguiente = null;
    }
}