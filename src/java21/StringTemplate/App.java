package java21.StringTemplate;

public class App {

    // javac --enable-preview --release 21 -Xlint:preview App.java
    // cd .\java21\
    // java --enable-preview java21.App

    public static void main(String[] args) throws Exception {

        stringTemplateDemo();
        System.out.println(interpolationWithExpressions());
        System.out.println(interpolationOfJSONBlockWithFMT("feelslike", 22.5F, "C"));

    }

    static void stringTemplateDemo() {
        // https://dev.java/playground/
        String name = "Joan";
        String info = STR. "\{name}";
        System.out.println(info);

    }

    static String interpolationWithExpressions() {
        return STR
          . "Today's weather is \{ getFeelsLike() }, with a temperature of \{ getTemperature() } degrees ";
    }

    static String getFeelsLike() {
        return "feelslike";
    }

    static String getTemperature() {
        return "21";
    }

}
