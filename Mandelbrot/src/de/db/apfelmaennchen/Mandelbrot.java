package de.db.apfelmaennchen;

public class Mandelbrot {
	
	private static final int MAXITER = 255;
	
	private Komplex linkeUntereEcke;
	private double breite;
	
	public Mandelbrot() {
		linkeUntereEcke = new Komplex(-2.0, -1.25);
		breite = 2.5;
	}
	
	public Mandelbrot(Komplex linkeUntereEcke, double breite) {
		this.linkeUntereEcke = linkeUntereEcke;
		this.breite = breite;
	}
	
	public Komplex createC(int x, int y, int size) {
		double delta = breite / (double) size;
		return new Komplex(linkeUntereEcke.real + x * delta, linkeUntereEcke.imag + y * delta);
	}
	
	public int iterate(Komplex c) {
		int result = 0;
		Komplex z = new Komplex();
		while(z.abs() < 2.0 ) {
			z.malIstGleich(z);
			z.plusIstGleich(c);
			result ++;
			if (result > MAXITER) return 0;
		}
		return result;
	}

	
	
}
