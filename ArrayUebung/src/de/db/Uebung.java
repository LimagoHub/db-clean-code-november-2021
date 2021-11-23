package de.db;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Uebung {

    private int feld[] = new int[Integer.MAX_VALUE >> 1];
    private final Random random = new Random();

    public static void main(String[] args) {
        new Uebung().run();
    }

    private void run() {

        try {
            System.out.println(Runtime.getRuntime().availableProcessors());
            Instant start = Instant.now();

            for(int i = 0; i < feld.length; i++) {
                feld[i] = random.nextInt();
            }

            ExecutorService service = Executors.newFixedThreadPool(16);
            service.execute(new MyWorker());
            service.execute(this::methodWorker);
            service.shutdown();
            service.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);


            Instant ende = Instant.now();
            Duration duration = Duration.between(start, ende);
            System.out.println(duration.toMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void methodWorker() {
        try {
            Thread.sleep(1000);
            System.out.println("Method");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    class MyWorker implements Runnable {

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
                System.out.println("Fettisch");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
