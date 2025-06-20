package interfaces;

public interface InterfazProducto {
    String getNombre();

    String getCodigo();

    Double getPrecio();

    String getDescripcion();

    void setNombre(String nombre);

    void setCodigo(String codigo);

    void setPrecio(Double precio);

    void setDescripcion(String descripcion);

    void mostrarInformacion();
}
