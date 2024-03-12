
//java --source 21 --enable-preview .\Main.java


static void main() {

    if(staticVariable) {
      System.out.println("static variable");
    }
    
    staticMethod();
}


static boolean staticVariable = true;
  
  static void staticMethod(){
    System.out.println("static method");
  }