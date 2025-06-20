import abstractions.ProductoAbstracto;

import java.util.List;

public class Categoria {

    private String nombre;
    private List<ProductoAbstracto> productos;

    public Categoria(String nombre, List<ProductoAbstracto> productos) {
        this.nombre = nombre;
        this.productos = productos;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public List<ProductoAbstracto> getProductos() {
        return productos;
    }
    public void agregarProducto(ProductoAbstracto producto) {
        this.productos.add(producto);
    }

}
