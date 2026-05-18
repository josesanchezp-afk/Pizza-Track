/**
 * Clase Pizza - Modelo de datos para representar una pizza
 * 
 * Esta clase representa una pizza con su nombre y lista de ingredientes.
 * Cada pizza contiene exactamente 3 ingredientes como se requiere en el
 * sistema de gestión de pedidos Pizza-Track.
 * 
 * Funcionalidades:
 * - getNombre(): Obtener el nombre de la pizza
 * - getIngredientes(): Obtener el arreglo de ingredientes
 * - mostrarDetalles(): Mostrar la información completa de la pizza
 * 
 * @author Pizza-Track Team
 * @version 1.0
 */
public class Pizza {
    
    private String nombre;
    private String[] ingredientes;
    
    /**
     * Constructor de Pizza
     * 
     * Crea una nueva instancia de Pizza con un nombre e ingredientes específicos.
     * Los ingredientes deben ser un arreglo de exactamente 3 elementos.
     * 
     * @param nombre El nombre o tipo de pizza (ej: "Pepperoni", "Hawaiana", etc.)
     * @param ingredientes Arreglo de 3 ingredientes que componen la pizza
     */
    public Pizza(String nombre, String[] ingredientes) {
        this.nombre = nombre;
        this.ingredientes = ingredientes;
    }
    
    /**
     * Obtiene el nombre de la pizza
     * 
     * @return String con el nombre de la pizza
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * Obtiene el arreglo de ingredientes de la pizza
     * 
     * @return Arreglo de String[] con los 3 ingredientes
     */
    public String[] getIngredientes() {
        return ingredientes;
    }
    
    /**
     * Muestra los detalles completos de la pizza en consola
     * 
     * Imprime:
     * - Nombre de la pizza
     * - Cada uno de los 3 ingredientes numerados
     * 
     * Formato de salida:
     * Nombre de la pizza: [nombre]
     * Ingredientes:
     *   1. [ingrediente1]
     *   2. [ingrediente2]
     *   3. [ingrediente3]
     */
    public void mostrarDetalles() {
        System.out.println("Nombre de la pizza: " + nombre);
        System.out.println("Ingredientes:");
        for (int i = 0; i < ingredientes.length; i++) {
            System.out.println("  " + (i + 1) + ". " + ingredientes[i]);
        }
    }
}