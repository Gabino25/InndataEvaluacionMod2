import abstractions.ProductoAbstracto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Libreria {
    private String nombre;
    private List<Categoria> categorias;
    private Inventario<ProductoLibro> inventarioLibros = new Inventario<>("Libros", new ArrayList<>(Arrays.asList()));
    private Inventario<ProductoRevista> inventarioRevista = new Inventario<>("Revistas", new ArrayList<>(Arrays.asList()));

    public Libreria(String nombre, List<Categoria> categorias) {
        this.nombre = nombre;
        this.categorias = categorias;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void agregarCategoria(Categoria categoria) {
        this.categorias.add(categoria);
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public Inventario<ProductoLibro> getInventarioLibros() {
        return inventarioLibros;
    }
    public Inventario<ProductoRevista> getInventarioRevista() {
        return inventarioRevista;
    }
    public void agregarProductoLibro(ProductoLibro libro) {
        // Verificar si el libro ya existe en el inventario
        for (ProductoLibro producto : inventarioLibros.getProductos()) {
            if (producto.getCodigo().equals(libro.getCodigo())) {
                System.out.println("El libro con código " + libro.getCodigo() + " ya existe en el inventario.");
                return; // Salir del método si el libro ya existe
            }
        }

        List<ProductoLibro> productosLibros = this.inventarioLibros.getProductos();
        productosLibros.add(libro);
        // Actualizar el inventario con el nuevo libro
        this.inventarioLibros.setProductos(productosLibros);
    }
    public void agregarProductoRevista(ProductoRevista revista) {
        this.inventarioRevista.getProductos().add(revista);
    }

}
