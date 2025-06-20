import abstractions.ProductoAbstracto;

public class ProductoRevista extends ProductoAbstracto {

    public ProductoRevista(String nombre, String codigo, Double precio, String descripcion) {
        super(nombre, codigo, precio, descripcion);
    }

    @Override
    public String toString() {
        return "Revista {" +
                "nombre='" + nombre + '\'' +
                ", codigo='" + codigo + '\'' +
                ", precio=" + precio +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }

}
