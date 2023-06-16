public class Videojuego extends Producto {
    private String plataforma;
    private Integer anio;
    private String compania;

    public Videojuego(String SKU, String nombre, Float precio, String plataforma, Integer anio, String compania) {
        super(SKU, nombre, precio);
        this.plataforma = plataforma;
        this.anio = anio;
        this.compania = compania;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public String getCompania() {
        return compania;
    }

    public void setCompania(String compania) {
        this.compania = compania;
    }

    @Override
    public String toString() {
        return "\tDatos Videojuego: " +
                "\nSKU: " + SKU +
                "\nNombre: " + nombre +
                "\nPrecio: " + precio +
                "\nPlataforma: " + plataforma +
                "\nAño: " + anio +
                "\nCompañia: " + compania;
    }
}
