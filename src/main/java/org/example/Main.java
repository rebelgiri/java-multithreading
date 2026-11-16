package org.example;

import org.eclipse.paho.client.mqttv3.MqttException;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.concurrent.*;

import static org.example.Beeper.createAndShowGUI;


public class Main {
    public static void main(String[] args) throws InterruptedException, MqttException {
//        SimpleThread simpleThread = new SimpleThread("SimpleThread", 10);
//        simpleThread.start();
//
//        SimpleRunnable simpleRunnable = new SimpleRunnable();
//        Thread thread = new Thread(simpleRunnable);
//        thread.start();
//
//        Runnable r = new SimpleRunnable();
//        Thread thread1 = Thread.ofPlatform().name("Runnable").daemon(false).start(r);
//
//        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
//
//            // Submit a Callable task that returns a value
//            Future<Integer> future = executor.submit(() -> {
//                Thread.sleep(2000); // Simulate long computation
//                return 42;
//            });
//
//            System.out.println("Task submitted... doing other work");
//
//            // Wait for the result
//            //Integer result = future.get(20000, TimeUnit.MILLISECONDS);
//            Throwable result = future.exceptionNow();
//            System.out.println("Result: " + result);
//
//        }


//        Start:
//        Executor service with new fixed thread pool
//        try (ExecutorService executorService = Executors.newFixedThreadPool(3)) {
//            CompletionService<Integer> completionService = new ExecutorCompletionService<>(executorService);
//
//            completionService.submit(() -> {
//                Thread.sleep(1000);
//                System.out.println("Task 1 is finished");
//                return 10;
//            });
//
//            completionService.submit(() -> {
//                Thread.sleep(2000);
//                System.out.println("Task 2 is finished");
//                return 20;
//            });
//
//            completionService.submit(() -> {
//                Thread.sleep(1500);
//                System.out.println("Task 3 is finished");
//                return 30;
//            });
//
//            int total = 0;
//
//            for (int i = 0; i < 3; i++) {
//                Future<Integer> future = completionService.take();
//                Integer result = future.get();
//                System.out.println("Result = " + result);
//                total += result;
//            }
//            System.out.println(total);
//            executorService.shutdown();
//
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//        End:
//        Executor service with new fixed thread pool


//        SimpleRunnable simpleRunnable1 = new SimpleRunnable();
//        CompletableFuture<Integer> taskFuture = CompletableFuture.supplyAsync(simpleRunnable1::doSimpleTaskAndReturnConstant);
//        System.out.println(taskFuture.isCancelled());
//
//
//        //CompletableFuture Pipeline
//        CompletableFuture<Void> pipeline =
//                CompletableFuture.supplyAsync(simpleRunnable1::doSimpleTaskAndReturnConstant)
//                        .thenApply(result -> result + 10)
//                        .thenApply(result -> result + 100)
//                        .thenAccept(result -> {
//                            System.out.println("Pipeline result is = " + result);
//                        });
//
//
//        pipeline.join();
//
//        SimpleCompletableFuture simpleCompletableFuture = new SimpleCompletableFuture();
//        try {
//            System.out.println(simpleCompletableFuture.thenCombineAsync().get());
//        } catch (InterruptedException | ExecutionException e) {
//            throw new RuntimeException(e);
//        }
//
//
//        SimpleCompletableFuture simpleCompletableFuture2 = new SimpleCompletableFuture();
//
//        var future1 = simpleCompletableFuture2.thenCombineAsync();
//        var future2 = simpleCompletableFuture2.theApplyAsync();
//
//
//        CompletableFuture<Void> future = CompletableFuture.allOf(future1, future2);
//
//
//        CompletableFuture<Void> pipeline1 = future.thenAccept(unused -> {
//            System.out.println(List.of(future1.join(), future2.join()));
//        });
//
//
//        try (HttpClient client = HttpClient.newHttpClient()) {
//            HttpRequest request = HttpRequest.newBuilder().GET()
//                    .uri(new URI("https://httpbin.org/delay/10"))
//                    .build();
//
//            CompletableFuture<Void> pipeline2 = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
//                    .whenComplete((r1, throwable) -> {
//                        if (throwable == null) {
//                            if (r1.statusCode() >= 400) {
//                                throw new RuntimeException("HTTP request responded with error");
//                            }
//                        }
//                    })
//                    .thenApply(r1-> r1.body())
//                    .thenAccept(System.out::println);
//
//
//        } catch (URISyntaxException e) {
//            throw new RuntimeException(e);
//        }
//
//        CompletableFuture<String> future4
//                = CompletableFuture.supplyAsync(() -> "Hello");
//        CompletableFuture<String> future5
//                = CompletableFuture.supplyAsync(() -> "Beautiful");
//        CompletableFuture<String> future6
//                = CompletableFuture.supplyAsync(() -> "World");
//
//        CompletableFuture<Void> combinedFuture
//                = CompletableFuture.allOf(future4, future5, future6);
//
//        try {
//            combinedFuture.get();
//        } catch (ExecutionException e) {
//            throw new RuntimeException(e);
//        }
//
//        System.out.println("future1.isDone() = " + future4.isDone());
//        System.out.println("future2.isDone() = " + future5.isDone());
//        System.out.println("future3.isDone() = " + future6.isDone());
//
//
//        StreamTerminalOperationsExample streamTerminalOperationsExample = new StreamTerminalOperationsExample();
//
//        streamTerminalOperationsExample.run();


//        Schedule a job for the event -dispatching thread:
//        creating and showing this application 's GUI.
//        javax.swing.SwingUtilities.invokeLater(new Runnable() {
//            public void run() {
//                createAndShowGUI();
//            }
//        });


//        Base base = new Base("Base", 10);
//        Child child = new Child("Child", 100);
//        child.update();
//        child.printData();


//        MqttPublisher mqttPublisher = new MqttPublisher();
//        mqttPublisher.publishDeviceInfo();



        //ReplayService replayService = new ReplayService();
        //replayService.play();
        //replayService.test();







    }
}