import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Clase que representa un producto con ID, nombre y precio
class Producto {
    private int id;
    private String nombre;
    private double precio;

    // Constructor para inicializar un producto con ID, nombre y precio
    public Producto(int id, String nombre, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    // Métodos getter para obtener los valores de los atributos
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    // Métodos setter para actualizar los valores de los atributos
    public void setNombre(String nuevoNombre) {
        this.nombre = nuevoNombre;
    }

    public void setPrecio(double nuevoPrecio) {
        this.precio = nuevoPrecio;
    }
}

// Clase principal que contiene el método main
public class inventario1 {
    public static void main(String[] args) {
        // Lista para almacenar los productos
        List<Producto> listaProductos = new ArrayList<>();
        // Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // Bucle infinito para mostrar el menú y realizar operaciones
        while (true) {
            System.out.println("=== Menú de Inventario ===");
            System.out.println("1. Agregar producto");
            System.out.println("2. Consultar productos");
            System.out.println("3. Actualizar producto");
            System.out.println("4. Eliminar producto");
            System.out.println("5. Salir");
            System.out.print("Elige una opción (1-5): ");
            int opcion = scanner.nextInt();

            // Switch para manejar las opciones del menú
            switch (opcion) {
                case 1:
                    agregarProducto(scanner, listaProductos);
                    break;
                case 2:
                    consultarProductos(listaProductos);
                    break;
                case 3:
                    actualizarProducto(scanner, listaProductos);
                    break;
                case 4:
                    eliminarProducto(scanner, listaProductos);
                    break;
                case 5:
                    System.out.println("¡Hasta luego!");
                    return; // Termina el programa
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        }
    }

    // Método para agregar un producto a la lista
    private static void agregarProducto(Scanner scanner, List<Producto> listaProductos) {
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Precio: ");
        double precio = scanner.nextDouble();
        listaProductos.add(new Producto(id, nombre, precio));
        System.out.println("Producto agregado correctamente.");
    }

    // Método para consultar y mostrar todos los productos de la lista
    private static void consultarProductos(List<Producto> listaProductos) {
        System.out.println("=== Lista de Productos ===");
        for (Producto producto : listaProductos) {
            System.out.println(producto.getId() + " - " + producto.getNombre() + " ($" + producto.getPrecio() + ")");
        }
    }

    // Método para actualizar un producto en la lista
    private static void actualizarProducto(Scanner scanner, List<Producto> listaProductos) {
        System.out.print("ID del producto a actualizar: ");
        int idActualizar = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        // Buscar el producto por ID y actualizar sus valores
        for (Producto producto : listaProductos) {
            if (producto.getId() == idActualizar) {
                System.out.print("Nuevo nombre: ");
                String nuevoNombre = scanner.nextLine();
                System.out.print("Nuevo precio: ");
                double nuevoPrecio = scanner.nextDouble();

                producto.setNombre(nuevoNombre);
                producto.setPrecio(nuevoPrecio);
                System.out.println("Producto actualizado correctamente.");
                return;
            }
        }
        System.out.println("Producto no encontrado.");
    }

    // Método para eliminar un producto de la lista
    private static void eliminarProducto(Scanner scanner, List<Producto> listaProductos) {
        System.out.print("ID del producto a eliminar: ");
        int idEliminar = scanner.nextInt();

        // Buscar el producto por ID y eliminarlo de la lista
        for (Producto producto : listaProductos) {
            if (producto.getId() == idEliminar) {
                listaProductos.remove(producto);
                System.out.println("Producto eliminado correctamente.");
                return;
            }
        }
        System.out.println("Producto no encontrado.");
    }
}
