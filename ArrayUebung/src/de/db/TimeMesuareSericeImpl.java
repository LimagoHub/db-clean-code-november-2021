package de.db;

import java.time.Duration;
import java.time.Instant;


/**
 * Messe die Laufzeit von run
 * 
 * @author JoachimWagner
 *
 */
public class TimeMesuareSericeImpl implements TimeMesuareService {




	@Override
	public void timeMesuareDecorator(Runnable runnable, String beforeMessage, String afterMessage) {
		System.out.println(beforeMessage);
		final Instant start = Instant.now();

		runnable.run();

		final Instant ende = Instant.now();
		final Duration duration = Duration.between(start, ende);
		System.out.println(String.format(afterMessage , duration.toMillis()));
	}
}
