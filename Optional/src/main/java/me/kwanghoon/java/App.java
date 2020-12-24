package me.kwanghoon.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class App {
    public static void main(String[] args) {
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(5, "rest api development", false));

        Optional<OnlineClass> onlineClass = springClasses
            .stream()
            .filter(c -> c.getTitle().startsWith("spring"))
            .findFirst();

        /* 값이 존재하는자 체크 */
        boolean isPresent = onlineClass.isPresent();
        System.out.println(isPresent);

        /* 값만 가져옴 */
        OnlineClass onlineClass1 = onlineClass.get();
        System.out.println(onlineClass1.getTitle());


    }
}
