package org.example;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ReplayService {
    private ScheduledFuture<?> playBackFuture = null;
    private final ScheduledExecutorService scheduler =
            Executors.newSingleThreadScheduledExecutor();

    public void play() {
        AtomicInteger count = new AtomicInteger();
                playBackFuture = scheduler.scheduleAtFixedRate(() -> {
            System.out.println("Playing.... at " + System.currentTimeMillis());
            count.incrementAndGet();

            if(count.get() == 2) {
                playBackFuture.cancel(true);
            }

            if(playBackFuture.isCancelled()) {
                System.out.println("Playback cancelled...");
                playBackFuture = null;
            }

        }, 0, 750, TimeUnit.MILLISECONDS);

    }


    public boolean doSomething() {
        System.out.println("Playing.... at " + System.currentTimeMillis());
        return false;
    }

    public void test() {
        MyFutureTasks<?> task =  new MyFutureTasks<>(this::doSomething);
        try (var service = Executors.newCachedThreadPool()) {

            Future<?> future = service.submit(task);
            

            if(future.isCancelled()) {
                System.out.println("test future cancelled...");
            }

        } catch (Exception e) {
            // handle exceptions
        }


    }
}
