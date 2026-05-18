/**
 * Clase Pila - Estructura de datos de pila genérica
 * 
 * Implementa una pila (stack) manual sin usar colecciones de Java.
 * Una pila es una estructura de datos LIFO (Last In, First Out) donde
 * el último elemento insertado es el primero en ser retirado.
 * 
 * Funcionalidades:
 * - push(objeto): Agregar un elemento a la pila
 * - pop(): Remover y retornar el elemento del tope de la pila
 * - peek(): Obtener el elemento del tope sin removerlo
 * - isEmpty(): Verificar si la pila está vacía
 * 
 * Esta pila es utilizada en GestionPedidos para manejar el historial
 * de pedidos de pizzas con operaciones de Undo y Redo.
 * 
 * @author Pizza-Track Team
 * @version 1.0
 */
public class Pila {
    
    /**
     * Nodo interno para la pila enlazada
     */
    private class Nodo {
        Pizza pizza;
        Nodo siguiente;
        
        /**
         * Constructor de Nodo
         * @param pizza Objeto Pizza a almacenar
         */
        Nodo(Pizza pizza) {
            this.pizza = pizza;
            this.siguiente = null;
        }
    }
    
    private Nodo tope;
    
    /**
     * Constructor de Pila
     * Inicializa la pila vacía estableciendo el tope en null
     */
    public Pila() {
        this.tope = null;
    }
    
    /**
     * Agrega un elemento al tope de la pila
     * 
     * @param pizza El objeto Pizza a insertar en la pila
     */
    public void push(Pizza pizza) {
        Nodo nuevoNodo = new Nodo(pizza);
        nuevoNodo.siguiente = tope;
        tope = nuevoNodo;
    }
    
    /**
     * Remueve y retorna el elemento del tope de la pila
     * 
     * @return La Pizza que estaba en el tope de la pila
     * @throws IllegalStateException si la pila está vacía
     */
    public Pizza pop() {
        if (isEmpty()) {
            throw new IllegalStateException("No se puede hacer pop en una pila vacía");
        }
        Pizza pizza = tope.pizza;
        tope = tope.siguiente;
        return pizza;
    }
    
    /**
     * Retorna el elemento del tope sin removerlo de la pila
     * 
     * @return La Pizza que está en el tope de la pila
     * @throws IllegalStateException si la pila está vacía
     */
    public Pizza peek() {
        if (isEmpty()) {
            throw new IllegalStateException("La pila está vacía, no hay elemento para ver");
        }
        return tope.pizza;
    }
    
    /**
     * Verifica si la pila está vacía
     * 
     * @return true si la pila no contiene elementos, false en caso contrario
     */
    public boolean isEmpty() {
        return tope == null;
    }
}