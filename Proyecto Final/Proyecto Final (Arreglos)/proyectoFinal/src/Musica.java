public class Musica extends Producto {
    private Integer anio;
    private String formato;
    private String trackList;
    private String artista;

    public Musica(String SKU, String nombre, Float precio, Integer anio, String formato, String trackList, String artista) {
        super(SKU, nombre, precio);
        this.anio = anio;
        this.formato = formato;
        this.trackList = trackList;
        this.artista = artista;
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

    public String getTrackList() {
        return trackList;
    }

    public void setTrackList(String trackList) {
        this.trackList = trackList;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    @Override
    public String toString() {
        return "\tDatos Música: " +
                "\nSKU: " + SKU +
                "\nNombre: " + nombre +
                "\nPrecio: " + precio +
                "\nFormato: " + formato +
                "\nArtista: " + artista +
                "\nAño: " + anio +
                "\nTrack List: " + trackList;
    }
}
