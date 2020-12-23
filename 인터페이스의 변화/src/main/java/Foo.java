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
    }
}
