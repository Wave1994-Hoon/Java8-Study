package me.kwanghoon.java;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Spliterator;

public class App {
    public static void main(String[] args) {
        Foo foo = new DefaultFoo("Hi");
        foo.printName();
        foo.printNameUpperCase();
        System.out.println("=========================");


        /* forEach */
        List<String> name = new ArrayList<>();
        name.add("AAA");
        name.add("BBB");
        name.add("CCC");
        name.add("DDD");

        name.forEach(s -> System.out.println(s));
        System.out.println("=========================");
        name.forEach(System.out::println);
        System.out.println("=========================");


        /* Spliterator */
        Spliterator<String> spliterator = name.spliterator();
        Spliterator<String> spliterator1 = name.spliterator().trySplit();
        while (spliterator.tryAdvance(System.out::println));
        System.out.println("=========================");
        while (spliterator1.tryAdvance(System.out::println));


        /* remove if*/
        System.out.println("=========================");
        name.removeIf(s -> s.startsWith("A"));
        name.forEach(System.out::println);


        /* comparator */
        Comparator<String> compareToIgnoreCase = String::compareToIgnoreCase;
        name.sort(compareToIgnoreCase.reversed());
        name.forEach(System.out::println);

    }
}
