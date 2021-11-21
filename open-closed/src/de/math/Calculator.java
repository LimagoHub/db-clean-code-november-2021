package de.math;

public class Calculator {
	
	private static Calculator instance = new Calculator();
	
	private Calculator() {
		
	}
	
	
	
	public static Calculator getInstance() {
		return instance;
	}



	private double memory = 0;

	public double getMemory() {
		return memory;
	}

	
	
	public void add(double value) {
		memory += value;
	}
	public void sub(double value) {
		memory -= value;
	}

	public void mult(double value) {
		memory *= value;
	}

	public void div(double value) {
		memory /= value;
	}

	public void clear() {
		memory = 0;
	}

	public void print() {
		System.out.println(memory);
	}
	
	

	public CalculatorMemento getMemento() {
		return new MyCalculatorMemento(memory);
	}



	public void setMemento(CalculatorMemento memento) {
		memory = ((MyCalculatorMemento) memento).getMemory();
	}
	
	private static class MyCalculatorMemento implements CalculatorMemento {
		private final double memory;

		public MyCalculatorMemento(double memory) {
			super();
			this.memory = memory;
		}

		public double getMemory() {
			return memory;
		}
		
		
	}
}
