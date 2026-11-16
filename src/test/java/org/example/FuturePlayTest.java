package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

class FuturePlayTest {
    private FuturePlay futurePlay;
    @BeforeEach
    void setUp() {

        futurePlay = new FuturePlay();
    }


    @Test
    void createPipeline() {
        Supplier<TaskResult> task1 = () -> {
            try {
                return futurePlay.doTask("task 1", 3);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        Supplier<TaskResult> task2 = () -> {
            try {
                return futurePlay.doTask("task 2", 5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        CompletableFuture<Void> pipeline =
                CompletableFuture.supplyAsync(task1)
                .thenCombine(
                        CompletableFuture.supplyAsync(task2),
                        (result1, result2) -> fuze(result1.taskName(), result2.taskName()))
                        .thenApply(data -> data + " :: Handled Apply")
                        .thenAccept(data -> {
                            System.out.println(data + " :: Handled Accept");
                        });

    }


    @Test
    void testAllOfAnyOf() {







    }

    private static String fuze( String first, String second) {
        return String.format("Combined (%s : %s)", first, second);
    }
}