package de.commands;

import java.util.ArrayDeque;
import java.util.Deque;

public class CommandHistory {
	
	private Deque<Command> undoStack = new  ArrayDeque<>();
	private Deque<Command> redoStack = new ArrayDeque<>();
	
	
	public void addCommand(Command command) {
		if(command.isQuery()) return;
		undoStack.push(command);
		redoStack.clear();
	}
	
	public void undo() {
		if(undoStack.isEmpty())
			System.out.println("can't undo");
		else {
			Command command = undoStack.pop();
			command.undo();
			redoStack.push(command);
		}
	}
	
	public void redo() {
		if(redoStack.isEmpty())
			System.out.println("can't redo");
		else {
			Command command = redoStack.pop();
			command.execute();
			undoStack.push(command);
		}
	}
	

}
