package ProductosElectronicos;

public class Microcomponente extends Electronico {
    private double potencia;
    private int nBocinas;

    public Microcomponente(String nS, String marca, String modelo, double potencia, int nBocinas) {
        super(nS, marca, modelo);
        this.potencia = potencia;
        this.nBocinas = nBocinas;
    }

    public double getPotencia() {
        return potencia;
    }

    public void setPotencia(double potencia) {
        this.potencia = potencia;
    }

    public int getnBocinas() {
        return nBocinas;
    }

    public void setnBocinas(int nBocinas) {
        this.nBocinas = nBocinas;
    }

    @Override
    public String toString() {
        return "Microcomponente…\n" + 
                super.toString() +
                "\nPotencia (Watts): " + potencia + 
                "\nNumero de bocinas: " + nBocinas;
    }
}
