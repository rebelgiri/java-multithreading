package org.example;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class MyFutureTasks<V> extends FutureTask<V> {
    public MyFutureTasks(Callable<V> callable) {
        super(callable);
    }

    @Override
    protected void done() {
        try {
            System.out.println("Task Finished");
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }
}
