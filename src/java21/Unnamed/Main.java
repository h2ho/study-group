
//java --source 21 --enable-preview .\Main.java

import java.util.List;

public record Car(
    String name, String color) {

  }

  static void main() {

    if (staticVariable) {
      System.out.println("static variable");
    }

    staticMethod();

    List<Integer> test = List.of(1, 2, 3);
    for (var _ : test) {
      System.out.println("count");
    }

    try {
      throw new Exception("");
    } catch (Exception _) {
      System.out.println("abc");
    }

    var car = new Car("abc", "blue");
    System.out.println(getObjectsColorWithUnnamedPattern(car));
    System.out.println(getObjectsColorWithSwitchAndUnnamedPattern(car));
  }

  static boolean staticVariable = true;

  static void staticMethod() {
    System.out.println("static method");
  }

  static String getObjectsColorWithUnnamedPattern(Object object) {
    if (object instanceof Car(_, String color)) {
        return color;
    }
    return "No color!";
}

static String getObjectsColorWithSwitchAndUnnamedPattern(Object object) {
  return switch (object) {
      case Car(_, String color) -> color;
      default -> "No color!";
  };
}