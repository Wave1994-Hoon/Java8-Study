package me.kwanghoon.java;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Foo {
    public static void main(String[] args) {
        List<String> name = new ArrayList<>();
        name.add("AAA");
        name.add("BBB");
        name.add("CCC");
        name.add("DDD");

        /* 중계형 오퍼레이터 종료 오퍼레이터가 없으면 실행되지 않음 */
        List<String> collect = name
            .stream()
            .map(String::toLowerCase)
            .collect(Collectors.toList());

        collect.forEach(System.out::println);
        System.out.println("============================");

        name.forEach(System.out::println);


        /*
        * # parallelStream
        * 쓰레드를 만드는 것에 대한 비용 때문에 무조건 빠른건 아님
        * 데이터가 정말 방대한 때는 유용하지만 데이터가 적으면 stream()이 더 빠를 수 있음
        */
        List<String> collect2 = name.parallelStream().map((s) -> {
            System.out.println(s + " " + Thread.currentThread().getName());
            return s.toLowerCase();
        }).collect(Collectors.toList());
        collect2.forEach(System.out::println);



        /* Stream API Example */
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "rest api development", false));

        List<OnlineClass> javaClasses = new ArrayList<>();
        javaClasses.add(new OnlineClass(6,"Tha Java Test",true));
        javaClasses.add(new OnlineClass(7,"The Java Code manipulation",true));
        javaClasses.add(new OnlineClass(8,"The Java 8 to 11",false));

        List<List<OnlineClass>> keesunEvents = new ArrayList<>();
        keesunEvents.add(springClasses);
        keesunEvents.add(javaClasses);


        /* spring 으로 시작하는 수업 */
        springClasses
            .stream()
            .filter(c -> c.getTitle().startsWith("spring"))
            .forEach(c -> System.out.println(c.getTitle()));



        /* 종료되지 않은 수업 */
        springClasses
            .stream()
            .filter(c -> !c.isClosed()) // java 11: filter(Predicate.not(OnlineClass::isClodes))
            .forEach(c -> System.out.println(c.getTitle()));


        /* 수업 이름만 모아서 스트림 만들기 */
        springClasses
            .stream()
            .map(OnlineClass::getTitle) // String 으로 타입 변경
            .forEach(System.out::println);


        /* 두 수업 목록에 있는 모든 수업 타이틀 출력 */
        keesunEvents
            .stream()
            .flatMap(Collection::stream) // List<OnlineClass> --> OnlineClass 로 분할
            .forEach(c -> System.out.println(c.getTitle()));


        /* 10부터 1씩 증가하는 무제한 스트림 중에서 앞에 10개 빼고 최대 10개 까지만 */
        Stream
            .iterate(10, i -> i + 1)
            .skip(10)
            .limit(10)
            .forEach(System.out::println);


        /* 자바 수업 중에 Test가 들어있는 수업이 있는지 확인 */
        Boolean hasClass = javaClasses
            .stream()
            .anyMatch(c -> c.getTitle().contains("Test"));
        System.out.println(hasClass);


        /* 스프링 수업 중에 제목에 spring 이 들어간 제목만 것만 모아서 List 만들기 */
        List<String> classesIncludeSpring = springClasses
            .stream()
            .map(OnlineClass::getTitle)
            .filter(s -> s.contains("spring"))
            .collect(Collectors.toList());

        classesIncludeSpring.forEach(System.out::println);
    }
}
