package de.db.apfelmaennchen.services.impl;

import de.db.apfelmaennchen.math.Komplex;
import de.db.apfelmaennchen.services.ComplexFunction;

public class MandelbrotFunction implements ComplexFunction {
	private static final int MAXITER = 255;

	@Override
	public Integer apply(Komplex c) {
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
