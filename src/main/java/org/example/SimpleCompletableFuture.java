package org.example;

import java.util.concurrent.*;

public class SimpleCompletableFuture {

    public CompletableFuture<String> calculateAsync() throws InterruptedException {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();

        try (ExecutorService executor = Executors.newCachedThreadPool()) {
            CompletableFuture.supplyAsync(() -> completableFuture.complete("Just Completed...."), executor);
        }

        return completableFuture;
    }


    public CompletableFuture<String> theApplyAsync() throws InterruptedException {

        try (ExecutorService executor = Executors.newCachedThreadPool()) {
            return CompletableFuture.supplyAsync(() -> "Just Completed....", executor)
                    .thenApply(s -> s + " theApplyAsync");
        }
    }

    public void thenAcceptAsync() throws InterruptedException {

        try (ExecutorService executor = Executors.newCachedThreadPool()) {
            CompletableFuture.supplyAsync(() -> "Just Completed....", executor)
                    .thenApply(s -> s + " World")
                    .thenAccept(s -> System.out.println("OK"));
        }
    }

    public CompletableFuture<String> thenCombineAsync() throws InterruptedException {

        try (ExecutorService executor = Executors.newCachedThreadPool()) {
            return CompletableFuture.supplyAsync(() -> "Just Completed....", executor)
                    .thenCombine(CompletableFuture.supplyAsync(
                            () -> " thenCombineAsync"), (s1, s2) -> s1 + s2);
        }
    }
}