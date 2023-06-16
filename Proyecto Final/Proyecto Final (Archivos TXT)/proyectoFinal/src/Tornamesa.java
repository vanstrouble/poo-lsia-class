public class Tornamesa extends Producto {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String marca;
    private String parada;
    private Float velocidadRotacion;

    public Tornamesa(String SKU, String nombre, Float precio, String marca, String parada, Float velocidadRotacion) {
        super(SKU, nombre, precio);
        this.marca = marca;
        this.parada = parada;
        this.velocidadRotacion = velocidadRotacion;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getParada() {
        return parada;
    }

    public void setParada(String parada) {
        this.parada = parada;
    }

    public Float getVelocidadRotacion() {
        return velocidadRotacion;
    }

    public void setVelocidadRotacion(Float velocidadRotacion) {
        this.velocidadRotacion = velocidadRotacion;
    }

    @Override
    public String toString() {
        return "\n\tDatos Tornamesa: " +
                "\nSKU: " + SKU +
                "\nNombre: " + nombre +
                "\nPrecio: " + precio +
                "\nMarca: " + marca +
                "\nTipo de parada: " + parada +
                "\nVelocidad de rotación: " + velocidadRotacion;
    }
}
