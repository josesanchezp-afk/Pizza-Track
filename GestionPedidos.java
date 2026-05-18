import java.util.Scanner;

public class GestionPedidos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Creación de las dos pilas manuales
        Pila pilaPrincipal = new Pila();   // Maneja el Undo (Deshacer)
        Pila pilaSecundaria = new Pila();  // Maneja el Redo (Rehacer)
        
        int opcion;

        do {
            System.out.println("\n=== PIZZA-TRACK: Gestión de Pedidos ===");
            System.out.println("1. Registrar Nombre del cliente, para su pedido DE PIZZA");
            System.out.println("2. Deshacer (Undo)");
            System.out.println("3. Rehacer (Redo)");
            System.out.println("4. Mostrar Pedido Actual");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            
            // Validación básica para evitar errores si el usuario ingresa letras
            while (!scanner.hasNextInt()) {
                System.out.print("Por favor, ingrese un número válido: ");
                scanner.next();
            }
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer del scanner

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre de la pizza: ");
                    String nombre = scanner.nextLine();
                    
                    String[] ingredientes = new String[3];
                    System.out.println("Ingrese exactamente 3 ingredientes:");
                    for (int i = 0; i < 3; i++) {
                        System.out.print("Ingrediente " + (i + 1) + ": ");
                        ingredientes[i] = scanner.nextLine();
                    }
                    Pizza nuevaPizza = new Pizza(nombre, ingredientes);
                    pilaPrincipal.push(nuevaPizza); // Push a la principal
                    
                    // IMPORTANTE: Al registrar una nueva acción, el historial de "Rehacer" se limpia.
                    pilaSecundaria = new Pila(); 
                    System.out.println("-> ¡Pedido registrado exitosamente!");
                    break;

                case 2: // UNDO (Deshacer)
                    if (!pilaPrincipal.isEmpty()) {
                        Pizza pizzaDeshechada = pilaPrincipal.pop();
                        pilaSecundaria.push(pizzaDeshechada);
                        System.out.println("-> Acción Deshecha. Se movió a espera: " + pizzaDeshechada.getNombre());
                    } else {
                        System.out.println("-> No hay pedidos en la pila principal para deshacer.");
                    }
                    break;

                case 3: // REDO (Rehacer)
                    if (!pilaSecundaria.isEmpty()) {
                        Pizza pizzaRehecha = pilaSecundaria.pop();
                        pilaPrincipal.push(pizzaRehecha);
                        System.out.println("-> Acción Rehecha. Se recuperó: " + pizzaRehecha.getNombre());
                    } else {
                        System.out.println("-> No hay pedidos en la pila secundaria para rehacer.");
                    }
                    break;

                case 4: // PEEK (Mostrar actual)
                    if (!pilaPrincipal.isEmpty()) {
                        System.out.println("\n--- PEDIDO ACTUAL EN PRODUCCIÓN ---");
                        pilaPrincipal.peek().mostrarDetalles();
                        System.out.println("-----------------------------------");
                    } else {
                        System.out.println("-> La pila de pedidos activos está vacía.");
                    }
                    break;

                case 0:
                    System.out.println("Cerrando el sistema Pizza-Track... ¡Hasta pronto!");
                    break;

                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }

        } while (opcion != 0);

        scanner.close();
    }
}