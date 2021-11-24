package de.db.apfelmaennchen;

public class Komplex {

	public double real, imag;
	
	public Komplex() {
		this(0,0);
	}
	public Komplex(double real) {
		this(real,0);
	}
	public Komplex(double real, double imag) {
		this.real = real;
		this.imag = imag;
	}
	
	public Komplex plusIstGleich(Komplex a){
		this.real += a.real;
		this.imag += a.imag;
		return this;
	}
	
	public Komplex malIstGleich(Komplex a) {
		double realhelp = this.real * a.real - this.imag * a.imag;
		this.imag = this.real * a.imag + this.imag * a.real;
		this.real = realhelp;
		return this;
	}
	
	public double abs() {
		return Math.sqrt(real*real + imag * imag);
	}
}
