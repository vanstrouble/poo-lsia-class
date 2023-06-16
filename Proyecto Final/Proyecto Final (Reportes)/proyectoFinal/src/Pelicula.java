public class Pelicula extends Producto{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private Integer region;
    private Integer anio;
    private String formato;
    private String actores;

    public Pelicula(String SKU, String nombre, Float precio, Integer region, Integer anio, String formato, String actores) {
        super(SKU, nombre, precio);
        this.region = region;
        this.anio = anio;
        this.formato = formato;
        this.actores = actores;
    }

    public Integer getRegion() {
        return region;
    }

    public void setRegion(Integer region) {
        this.region = region;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public String getActores() {
        return actores;
    }

    public void setActores(String actores) {
        this.actores = actores;
    }

    @Override
    public String toString() {
        return "\n\tDatos película: " +
                "\nSKU: " + SKU +
                "\nNombre: " + nombre +
                "\nPrecio: " + precio +
                "\nFormato: " + formato +
                "\nRegion: " + region +
                "\nAño: " + anio +
                "\nActores: " + actores;
    }
}
