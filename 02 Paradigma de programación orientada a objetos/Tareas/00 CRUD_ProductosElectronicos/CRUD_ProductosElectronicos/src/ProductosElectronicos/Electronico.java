package ProductosElectronicos;

public class Electronico {
    protected String NS;
    protected String marca;
    protected String modelo;
	public int length;

    public Electronico(String nS, String marca, String modelo) {
        NS = nS;
        this.marca = marca;
        this.modelo = modelo;
    }

    public String getNS() {
        return NS;
    }

    public void setNS(String nS) {
        NS = nS;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return  "Numero Serie: " + NS +
                "\nMarca: " + marca + 
                "\nModelo: " + modelo;
    }
}