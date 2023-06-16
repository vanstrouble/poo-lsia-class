package Ejercicio9;

public class Circulo extends Poligono {
    private double diametro;

    public Circulo(int numeroLados, double diametro) {
		super(0);
		this.diametro = diametro;
	}

    public double getDiametro() {
        return diametro;
    }

	@Override
	public String toString() {
		return "Circulo\n" + "\nDiametro = " + diametro;
	}

    @Override
    public double area() {
        return Math.PI * diametro;
    }

    @Override
    public double perimetro() {
        return (2 * Math.PI) * (diametro / 2);
    }
}
