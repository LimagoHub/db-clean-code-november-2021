package de.db;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ArrayServiceImpl {

	private int[] data;
	private final int availableProcessors = Runtime.getRuntime().availableProcessors();
	private int threadCount;

	private final TimeMesuareService timeMesuareService;

	public ArrayServiceImpl(TimeMesuareService timeMesuareService) {
		this.timeMesuareService = timeMesuareService;
	}



	public void fillArrayWithRandomNumbersParallel(int[] data) {
		this.data = data;

		for (threadCount = 1; threadCount <= availableProcessors + 1; threadCount++) {
			timeMesuareService.timeMesuareDecorator(this::startExcecuterServiceForParallelProceesing,
					"Starte Messung mit " + threadCount + " Threads",
					"Dauer mit " + threadCount + " Threads = %s Millisekunden");
		}
	}

	

	private void startExcecuterServiceForParallelProceesing()  {
		try {
			final ExecutorService service = Executors.newFixedThreadPool(threadCount);

			startSegmentWorker(service);

			service.shutdown();
			service.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}

	private void startSegmentWorker(final ExecutorService service) {
		for (int currentThreadNumber = 0; currentThreadNumber < threadCount; currentThreadNumber++) {
			calculateSegmentAndStartSingeleSegmentWorker(service, currentThreadNumber);
		}
	}

	private void calculateSegmentAndStartSingeleSegmentWorker(final ExecutorService service, final int currentThreadNumber) {
		final int segmentSize = data.length / threadCount;
		final int segmentStart = currentThreadNumber * segmentSize;
		final int segmentEnd = (currentThreadNumber + 1) * segmentSize;

		service.execute(new FillSegmentWorker(segmentStart,segmentEnd));
	}

	class FillSegmentWorker implements Runnable {
		private final Random random = new Random();
		private final int start;
		private final int ende;

		public FillSegmentWorker(int start, int ende) {
			this.start = start;
			this.ende = ende;
		}

		@Override
		public void run() {
			for (int i = start; i < ende; i++) {
				data[i] = random.nextInt();
			}
		}
	}

}
