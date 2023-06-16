public class Bocinas extends Producto {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String marca;
    private Integer potencia;
    private String tamanio;

    public Bocinas(String SKU, String nombre, Float precio, String marca, Integer potencia, String tamanio) {
        super(SKU, nombre, precio);
        this.marca = marca;
        this.potencia = potencia;
        this.tamanio = tamanio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Integer getPotencia() {
        return potencia;
    }

    public void setPotencia(Integer potencia) {
        this.potencia = potencia;
    }

    public String getTamanio() {
        return tamanio;
    }

    public void setTamanio(String tamanio) {
        this.tamanio = tamanio;
    }

    @Override
    public String toString() {
        return "\n\tDatos Bocina: " +
                "\nSKU: " + SKU +
                "\nNombre: " + nombre +
                "\nPrecio: " + precio +
                "\nMarca: " + marca +
                "\nPotencia: " + potencia +
                "\nTamaño: " + tamanio;
    }
}
