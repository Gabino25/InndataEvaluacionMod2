import abstractions.ProductoAbstracto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
         Libreria libreria = new Libreria("Mi Libreria", new ArrayList<>(Arrays.asList()));
         System.out.println("Programa que gestiona una librería");

         imprimirMenuPrincipal();

         Scanner scanner = new Scanner(System.in);
         String input = scanner.nextLine();

         while(!"6".equals(input)){
              switch (input){
                   case "1":
                        // Agregar categoría
                        agregarCategoria(scanner, libreria);
                        imprimirMenuPrincipal();
                        input = scanner.nextLine();
                        break;
                   case "2":
                         agregarLibro(scanner, libreria);
                         imprimirMenuPrincipal();
                         input = scanner.nextLine();
                         break;
                     case "3":
                        // Agregar revista
                         agregarRevista(scanner, libreria);
                         imprimirMenuPrincipal();
                         input = scanner.nextLine();
                         break;
                     case "4":
                        System.out.println("Listar categorías");
                        for (Categoria categoriaItem : libreria.getCategorias()) {
                            System.out.println("Categoría: " + categoriaItem.getNombre());
                        }
                         imprimirMenuPrincipal();
                         input = scanner.nextLine();
                        break;
                     case "5":
                        System.out.println("Listar libros");
                        for (ProductoLibro libroItem : libreria.getInventarioLibros().getProductos()) {
                            System.out.println("Libro: " + libroItem.getNombre() + ", Código: " + libroItem.getCodigo() + ", Precio: " + libroItem.getPrecio() + ", Descripción: " + libroItem.getDescripcion());
                        }
                        System.out.println("Listar revistas");
                        for (ProductoRevista revistaItem : libreria.getInventarioRevista().getProductos()) {
                            System.out.println("Revista: " + revistaItem.getNombre() + ", Código: " + revistaItem.getCodigo() + ", Precio: " + revistaItem.getPrecio() + ", Descripción: " + revistaItem.getDescripcion());
                        }
                         imprimirMenuPrincipal();
                         input = scanner.nextLine();
                        break;
                  default:
                        System.out.println("Opción no válida. Intente nuevamente.");
                        imprimirMenuPrincipal();
                        input = scanner.nextLine();
              }
         }


            System.out.println("Saliendo del programa. ¡Hasta luego!");

    }

    private static void agregarRevista(Scanner scanner, Libreria libreria) {

        System.out.println("Agregar revista");
        System.out.print("Ingrese el nombre de la revista: ");
        String revistaNombre = scanner.nextLine();

        while (revistaNombre.isEmpty()) {
            System.out.println("El nombre de la revista no puede estar vacío.");
            revistaNombre = scanner.nextLine();
        }

        System.out.println("Ingrese el codigo de la revista:");
        String codigoRevista = scanner.nextLine();
        while (codigoRevista.isEmpty()) {
            System.out.println("El código de la revista no puede estar vacío.");
            codigoRevista = scanner.nextLine();
        }

        System.out.println("Ingrese el precio de la revista:");
        String precioRevistaStr = scanner.nextLine();
        double precioRevista = 0;
        while(precioRevista>0){
            try {
                precioRevista = Double.parseDouble(precioRevistaStr);
            } catch (NumberFormatException e) {
                precioRevista = 0; // Si no es un número válido, se asigna 0
                System.out.println("El precio debe ser un número válido.");
            }
        }

        System.out.println("Ingrese la descripción de la revista:");
        String descripcionRevista = scanner.nextLine();
        while (descripcionRevista.isEmpty()) {
            System.out.println("La descripción de la revista no puede estar vacía.");
            descripcionRevista = scanner.nextLine();
        }

        ProductoRevista nuevaRevista = new ProductoRevista(revistaNombre, codigoRevista, precioRevista, descripcionRevista);

        libreria.agregarProductoRevista(nuevaRevista);
        System.out.println("Producto agregado: " + nuevaRevista);


    }

    private static void agregarCategoria(Scanner scanner, Libreria libreria) {

        System.out.println("Agregar categoría");
        System.out.print("Ingrese el nombre de la categoría: ");
        String categoriaNombre = scanner.nextLine();

        while (categoriaNombre.isEmpty()) {
            System.out.println("El nombre de la categoría no puede estar vacío.");
            categoriaNombre = scanner.nextLine();
        }

        List<ProductoAbstracto> productos = Arrays.asList(); // Inicializar la lista de productos como vacía

        imprimirMenuCategoria();

        String input = scanner.nextLine();
        while(!"3".equals(input)){
            switch (input){
                case "1":
                    System.out.println("Agregar producto a la categoría: " + categoriaNombre);
                    agregarLibro(scanner,  libreria);
                    imprimirMenuCategoria();
                    input = scanner.nextLine();
                    break;
                case "2":
                    System.out.println("Agregar revista a la categoría: " + categoriaNombre);
                    agregarRevista(scanner, libreria);
                    imprimirMenuCategoria();
                    input = scanner.nextLine();
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
                    imprimirMenuCategoria();
                    input = scanner.nextLine();
            }
        }

        Categoria categoria = new Categoria(categoriaNombre,productos);
        libreria.agregarCategoria(categoria);
        System.out.println("Categoría agregada: " + categoria);


    }

    private static void agregarLibro(Scanner scanner, Libreria libreria) {

        System.out.println("Agregar libro");
        System.out.print("Ingrese el nombre del libro: ");
        String libroNombre = scanner.nextLine();

        while(libroNombre.isEmpty()) {
            System.out.println("El nombre del libro no puede estar vacío.");
            libroNombre = scanner.nextLine();
        }

        System.out.println("Ingrese el codigo del libro:");
        String codigoLibro = scanner.nextLine();
       while (codigoLibro.isEmpty()) {
            System.out.println("El código del libro no puede estar vacío.");
            codigoLibro = scanner.nextLine();
        }

        System.out.println("Ingrese el precio del libro:");
        String precioLibroStr = scanner.nextLine();
        double precioLibro = 0;
        while(precioLibro<=0){
            try {
                precioLibro = Double.parseDouble(precioLibroStr);
            } catch (NumberFormatException e) {
                precioLibro = 0; // Si no es un número válido, se asigna 0
                precioLibroStr = scanner.nextLine();
                System.out.println("El precio debe ser un número válido.");
            }
        }

        System.out.println("Ingrese la descripción del libro:");
        String descripcionLibro = scanner.nextLine();
        while (descripcionLibro.isEmpty()) {
            System.out.println("La descripción del libro no puede estar vacía.");
            descripcionLibro = scanner.nextLine();
        }

        ProductoLibro nuevoLibro = new ProductoLibro(libroNombre, codigoLibro, precioLibro, descripcionLibro);

        libreria.agregarProductoLibro(nuevoLibro);
        System.out.println("Producto agregado: " + nuevoLibro);
    }



    private static void imprimirMenuCategoria(){
        System.out.println("Menu Categoría Ingrese una opción (1-3):");
        System.out.println("1. Agregar libro");
        System.out.println("2. Agregar revista");
        System.out.println("3. Salir");
    }

    private static void imprimirMenuPrincipal() {
        System.out.println("Menu Principal Ingrese una opción (1-5):");
        System.out.println("1. Agregar categoría");
        System.out.println("2. Agregar libro");
        System.out.println("3. Agregar revista");
        System.out.println("4. Listar categorías");
        System.out.println("5. Listar productos");
        System.out.println("6. Salir del programa");
    }
}