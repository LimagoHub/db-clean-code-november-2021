package de.db;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Uebung {

    private int feld[] = new int[Integer.MAX_VALUE >> 2];
    private final Random random = new Random();

    public static void main(String[] args) {
        new Uebung().run();
    }

    private void run() {

        new ArrayServiceImpl(new TimeMesuareSericeImpl()).fillArrayWithRandomNumbersParallel(feld);
    }


}
