package ProductosElectronicos;

public class Television extends Electronico {
    private int pulgadas;
    private String tipoPanel;

    public Television(String nS, String marca, String modelo, int pulgadas, String tipoPanel) {
        super(nS, marca, modelo);
        this.pulgadas = pulgadas;
        this.tipoPanel = tipoPanel;
    }

    public int getPulgadas() {
        return pulgadas;
    }

    public void setPulgadas(int pulgadas) {
        this.pulgadas = pulgadas;
    }

    public String getTipoPanel() {
        return tipoPanel;
    }

    public void setTipoPanel(String tipoPanel) {
        this.tipoPanel = tipoPanel;
    }

    @Override
    public String toString() {
        return "Television…\n" +
                super.toString() + 
                "\nPulgadas: " + pulgadas + 
                "\nTipo de panel: " + tipoPanel;
    }
}
