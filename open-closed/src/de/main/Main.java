package de.main;

import java.util.Scanner;

import de.commands.Command;
import de.commands.CommandFactory;
import de.commands.CommandHistory;

public class Main {

	public static void main(String[] args) {
		final Scanner scanner = new Scanner(System.in);
		final CommandHistory history = new CommandHistory();
		
		while(true) {
			System.out.print("#>");
			String zeile = scanner.nextLine();
			if(zeile.equals("ende")) break;
			
			if(zeile.equals("undo")) {
				history.undo();
				continue;
			}
			
			if(zeile.equals("redo")) {
				history.redo();
				continue;
			}
			
			Command command = CommandFactory.createCommand(zeile);
			if(command == null) continue;
			
			command.execute();
			history.addCommand(command);
		}

		scanner.close();
	}

}
