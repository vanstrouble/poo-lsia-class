public class Audifonos extends Producto {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String marca;
    private String tipo;

    public Audifonos(String SKU, String nombre, Float precio, String marca, String tipo) {
        super(SKU, nombre, precio);
        this.marca = marca;
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "\n\tDatos Audifionos: " +
                "\nSKU: " + SKU +
                "\nNombre: " + nombre +
                "\nPrecio: " + precio +
                "\nMarca: " + marca +
                "\nTipo: " + tipo;
    }
}
