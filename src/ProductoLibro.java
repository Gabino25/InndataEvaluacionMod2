import abstractions.ProductoAbstracto;

public class ProductoLibro extends ProductoAbstracto {

    public ProductoLibro(String nombre, String codigo, Double precio, String descripcion) {
        super(nombre, codigo, precio, descripcion);
    }


    @Override
    public String toString() {
        return "Libro {" +
                "nombre='" + nombre + '\'' +
                ", codigo='" + codigo + '\'' +
                ", precio=" + precio +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }

}
