package java21.switchPattern;

//java --source 21 --enable-preview .\SwitchPattern.java

public class SwitchPattern {

    static void main(String[] args) {

        // As of Java 21
        testFooBarNew("abc");
        testFooBarNew(null);
        testInteger(-1);
        testInteger(2);
    }

    static void testFooBarNew(String s) {
        switch (s) {
            case null -> System.out.println("Oops");
            case "Foo", "Bar" -> System.out.println("Great");
            default -> System.out.println("Ok");

            // case null, default -> "n/a";
        }
    }

    static void testInteger(Integer val){

        switch (val) {
            // previous cases are unchanged
            case null   -> System.out.println("Oops");
            case 23, 42 -> System.out.println("23");

            // the default case splits into two:
            // 1. handle positive numbers
            case Integer i when i > 0 -> System.out.println("Greater than 0");


            default -> System.out.println("Less than");
}
    }
}
