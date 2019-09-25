class A {
  int integerA;
  public A(int a) {     // this class A constructor() takes one argument for creation
    integerA = a;       // assigns it to integerA [a class A variable]
    System.out.println("In constructor A");
  } 

  public void method(int a) {                               // method(argument1)
      System.out.println("Im with one argument : "+ a);
  }
}
class B extends A {
  int integerB;
  public B(int a,int b) {  // this class B constructor() takes two argument for creation
    super(a);
    integerB = b;
    System.out.println(super.integerA + " " + integerB);
  }
  public void method(int a, int b) {                       // method(argument1, argument2)
    System.out.println("Im with two argument : " + a + " " + b);
}

 public void method(double a, double b){
    System.out.println("Im with two arguments that are double : " + a + " " + b);
 }
}

public class Super {
    public static void main(String[] args) {
        B nB = new B(5, 10);
        System.out.println(nB.integerA + "  " +nB.integerB);

        //the below teo exhibits method overloading
        nB.method(50);                                            // calls the one with only one argument
        nB.method(50, 100);                                       // calls the one with two arguments
        nB.method(10.0, 2.5);                                     // calls the one with two arguments that are double
    }
}