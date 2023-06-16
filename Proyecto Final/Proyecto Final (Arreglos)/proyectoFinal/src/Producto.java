public class Producto {
    protected String SKU;
    protected String nombre;
    protected Float precio;

    public Producto(String SKU, String nombre, Float precio) {
        this.SKU = SKU;
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getSKU() {
        return SKU;
    }

    public void setSKU(String SKU) {
        this.SKU = SKU;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "\tDatos: " +
                "\nSKU: " + SKU +
                "\nNombre: " + nombre +
                "\nPrecio: " + precio;
    }
}
