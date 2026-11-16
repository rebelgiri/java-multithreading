package org.example;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

public class SynchronizedMethodsTest {

    @Test
    public void givenMultiThread_whenNonSyncMethod() throws InterruptedException {
        try(ExecutorService service = Executors.newFixedThreadPool(3)) {
            SynchronizedMethods summation = new SynchronizedMethods();

            IntStream.range(0, 1000)
                    .forEach(count -> service.submit(summation::calculate));
            boolean value = service.awaitTermination(1000, TimeUnit.MILLISECONDS);

            assertEquals(1000, summation.getSum());
        }

    }

    @Test
    public void givenMultiThread_whenStaticSyncMethod() throws InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();

        IntStream.range(0, 1000)
                .forEach(count ->
                        service.submit(SynchronizedMethods::syncStaticCalculate));
        boolean value = service.awaitTermination(100, TimeUnit.MILLISECONDS);

        assertEquals(1000, SynchronizedMethods.staticSum);
    }
}