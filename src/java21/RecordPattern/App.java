package java21.RecordPattern;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.SequencedCollection;

public class App {


    // javac --enable-preview --release 21 -Xlint:preview App.java
    // cd ..
    // java --enable-preview java21.RecordPattern.App

    record Point(int x, int y) {
    }

    public record GPSPoint(double lat, double lng) {
    }

    public record Location(String name, GPSPoint gpsPoint) implements ILocation {
    }

    public sealed interface ILocation permits Location {
        default String getName() {
            return switch (this) {
                case Location(var name, var ignored) -> name;
            };
        }
    }

    public static void main(String[] args) throws Exception {

        Object object = new Location("Home", new GPSPoint(1.0, 2.0));

        String result = switch (object) {
            case Location(var name, var ignored) when name.equals("Home") -> new Location("Test", new GPSPoint(1.0, 2.0)).getName();
            case Location(var name, var ignored) -> name;
            default -> "default";
        };

        System.out.println(result);
    }

    

}
