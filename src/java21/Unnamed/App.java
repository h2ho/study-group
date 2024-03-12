package java21.Unnamed;

public class App {

    // javac --enable-preview --release 21 -Xlint:preview App.java
    // cd .\java21\
    // java --enable-preview java21.App

    public record Car<T extends Engine>(String name, String color, T engine) {
    }

    abstract class Engine {
    }

    class GasEngine extends Engine {
    }

    class ElectricEngine extends Engine {
    }

    class HybridEngine extends Engine {
    }

    public static void main(String[] args) throws Exception {

    }

    static String getObjectsColorWithNamedPattern(Object object) {
        if (object instanceof Car(_, String color, _)) {
            return color;
        }
        return "No color!";
    }

}
