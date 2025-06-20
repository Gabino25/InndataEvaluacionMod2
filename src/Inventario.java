import abstractions.ProductoAbstracto;
import java.util.List;

public class Inventario<E extends ProductoAbstracto> {
    private String nombre;
    private List<E> productos;

    public Inventario(String nombre, List<E> productos) {
        this.nombre = nombre;
        this.productos = productos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<E> getProductos() {
        return productos;
    }

    public void setProductos(List<E> productos) {
        this.productos = productos;
    }


}
