package de.commands;

import de.math.Calculator;
import de.math.CalculatorMemento;

public class ClearCommand extends AbstractCommand {

	private CalculatorMemento state;
	
	
	@Override
	public void execute() {
		state = Calculator.getInstance().getMemento();
		Calculator.getInstance().clear();
	}
	
	@Override
	public boolean isQuery() {
		return false;
	}
	
	@Override
	public void undo() {
		Calculator.getInstance().setMemento(state);
	}
}
