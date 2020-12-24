package me.kwanghoon.java;

public interface Foo {

    void printName();

    /* 상속 받은 클래스에서 별도로 구현 안해도됨 */
    default  void printNameUpperCase() {
        System.out.println(getName().toUpperCase());
    }

    String getName();
}
