package org.example;
import java.util.*;
import java.util.stream.Collectors;


public class StreamTerminalOperationsExample {

    public void run(){
        // List of lists of names
        List<List<String>> listOfLists = Arrays.asList(
                Arrays.asList("Reflection", "Collection", "Stream"),
                Arrays.asList("Structure", "State", "Flow"),
                Arrays.asList("Sorting", "Mapping", "Reduction", "Stream")
        );


        List<String> sampleList = new ArrayList<>(List.of());
        sampleList.add("Bombay");
        sampleList.add("Mumbai");


        System.out.println(sampleList.get(1));



        // Create a set to hold intermediate results
        Set<String> intermediateResults = new HashSet<>();

        // Stream pipeline demonstrating various intermediate operations
        List<String> result = listOfLists.stream()
                .flatMap(List::stream)
                .filter(s -> s.startsWith("S"))
                .map(String::toUpperCase)
                .distinct()
                .sorted()
                .peek(intermediateResults::add)
                .toList();

        // Print the intermediate results
        System.out.println("Intermediate Results:");
        intermediateResults.forEach(System.out::println);

        // Print the final result
        System.out.println("Final Result:");
        result.forEach(System.out::println);
    }

}
