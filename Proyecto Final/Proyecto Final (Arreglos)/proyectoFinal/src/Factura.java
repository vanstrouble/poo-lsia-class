public class Factura {
    private String SKU;
    private String fecha;
    private String productos;
    private String nombreCliente;
    private Float total;

    public Factura(String SKU, String fecha, String productos, String nombreCliente, Float total) {
        this.SKU = SKU;
        this.fecha = fecha;
        this.productos = productos;
        this.nombreCliente = nombreCliente;
        this.total = total;
    }

    public String getSKU() {
        return SKU;
    }

    public void setSKU(String SKU) {
        this.SKU = SKU;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getProductos() {
        return productos;
    }

    public void setProductos(String productos) {
        this.productos = productos;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "\tFactura: " +
                "\nSKU: " + SKU +
                "\nFecha: " + fecha +
                "\nProductos: " + productos +
                "\nNombre del cliente: " + nombreCliente +
                "\nTotal: " + total;
    }
}
