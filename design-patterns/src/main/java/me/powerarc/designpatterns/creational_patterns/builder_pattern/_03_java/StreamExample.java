package me.powerarc.designpatterns.creational_patterns.builder_pattern._03_java;

import java.util.stream.Stream;

public class StreamExample {

    public static void main(String[] args) {
        Stream.Builder<String> builder = Stream.builder();
        Stream<String> names = builder.add("kwonho").add("powerarc").build();
        names.forEach(System.out::println);

        Stream<String> stringStream = Stream.<String>builder().add("kwonho").add("powerarc").build();
        stringStream.forEach(System.out::println);
    }
}
