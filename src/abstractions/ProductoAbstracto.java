package abstractions;

import interfaces.InterfazProducto;

public abstract  class ProductoAbstracto implements InterfazProducto {
    protected String nombre;
    protected String codigo;
    protected Double precio;
    protected String descripcion;

    public ProductoAbstracto(String nombre, String codigo, Double precio, String descripcion) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.precio = precio;
        this.descripcion = descripcion;
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }

    @Override
    public String getCodigo() {
        return this.codigo;
    }

    @Override
    public Double getPrecio() {
        return this.precio;
    }

    @Override
    public String getDescripcion() {
        return this.descripcion;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    @Override
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public void mostrarInformacion() {
        this.toString();
    }

    @Override
    public String toString() {
        return "Producto {" +
                "nombre='" + nombre + '\'' +
                ", codigo='" + codigo + '\'' +
                ", precio=" + precio +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }

}
