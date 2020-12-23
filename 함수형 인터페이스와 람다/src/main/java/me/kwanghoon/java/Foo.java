package me.kwanghoon.java;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Foo {

    public static void main(String[] args) {
        /* 익명 내부 클래스 */
        RunSomething runSomething = new RunSomething() {
            @Override
            public void doIt() {
                System.out.println("hello");
            }
        };
        runSomething.doIt();

        /* 람다 표현식 */
        RunSomething runSomething1 = () -> System.out.println("hello");
        runSomething1.doIt();

        /* Function 함수 인터페이스 -> 자바에서 제공하는 함수형 인터페이스 */
        Plus10 plus10 = new Plus10();
        System.out.println(plus10.apply(1));




        /* 람다 표현식 */
        Function<Integer, Integer> plus20 = (number) -> number + 10;
        System.out.println(plus20.apply(1));

        Function<Integer, Integer> multiply2 = (number) -> number * 2;

        /* compose example */
        Function<Integer, Integer> multiply2AndPlus20 = plus20.compose(multiply2);
        System.out.println(multiply2AndPlus20.apply(2));

        /* and then example */
        System.out.println(plus20.andThen(multiply2));




        /* UnaryOperator: 입력 값, 리턴 값 타입 같음 */
        UnaryOperator<String> hi = (s) -> "hi" + s;
        UnaryOperator<String> hi2 = Greeting::hi;
        System.out.println(hi.apply("dd"));


        /* 임의 객체의 인스턴스 메소드 참조 */
        /* comparator -> 자바 8 부터 FunctionalInterface 됨*/
        String[] names = {"AAA", "BBB", "CCC"};
        Arrays.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        });

        Arrays.sort(names, (o1, o2) -> 0);
        Arrays.sort(names, String::compareToIgnoreCase);



    }


}
