package de.techem.io;

import java.util.logging.Logger;

public class ConsoleWriter implements Writer {


	Logger logger = Logger.getAnonymousLogger();
	@Override
	public void write(String message) {
		logger.info(message);

	}

}
