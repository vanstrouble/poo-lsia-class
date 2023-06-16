package ProductosElectronicos;

public class Computadora extends Electronico {
    private String procesador;
    private String grafica;
    private int almacenamiento;
    private int ram;
	public int length;

    public Computadora(String nS, String marca, String modelo, String procesador, String grafica, int almacenamiento,
            int ram) {
        super(nS, marca, modelo);
        this.procesador = procesador;
        this.grafica = grafica;
        this.almacenamiento = almacenamiento;
        this.ram = ram;
    }

    public String getProcesador() {
        return procesador;
    }

    public void setProcesador(String procesador) {
        this.procesador = procesador;
    }

    public String getGrafica() {
        return grafica;
    }

    public void setGrafica(String grafica) {
        this.grafica = grafica;
    }

    public int getAlmacenamiento() {
        return almacenamiento;
    }

    public void setAlmacenamiento(int almacenamiento) {
        this.almacenamiento = almacenamiento;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    @Override
    public String toString() {
        return "Computadora… \n" +
                super.toString() + 
                "\nProcesador: " + procesador + 
                "\nGrafica: " + grafica +
                "\nAlmacenamiento: " + almacenamiento + 
                "\nMemoria RAM: " + ram;
    }
}
