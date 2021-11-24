package de.db;

public interface TimeMesuareService {

	void timeMesuareDecorator(Runnable runnable, String beforeMessage, String afterMessage);

}