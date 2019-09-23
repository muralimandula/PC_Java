import java.util.Random;

// public class MainClass {
//   public static void main(String args[]) {
//     // for (int counter = 0; counter <= 10; counter++)
//     int counter = 6;
//     System.out.printf("%d! = %d\n", counter, factorial(counter));

//   }

//   // recursive declaration of method factorial
//   public static long factorial(long number) {
//     if (number <= 1) // test for base case
//       return 1; // base cases: 0! = 1 and 1! = 1
//     else
//       // recursion step
//       return number * factorial(number - 1);
//   }
// }


// --------Random Generation


// class Apples {
//  public static void main(String[] args) {
//    Random dice = new Random();
//    int number;
//    int range = 6;
//    for(int counter = 1; counter <= 10; counter++) {
//        number = dice.nextInt(range + 1); // 0 - range( range is exclusive, then +1)
//        System.out.println(number +" ");
//    }
//  }
// }

// ====================================== Constructor

class Person {
  /*Class constructors are special methods.
  They are executed whenever new objects of
  that class created*/

   String name;
   int age;
   String address;

   /*A Constructor's name is identical to the class name in Java*/
   public Person() {
       /*Assiging default values for the variables*/
      name = "viviz";
      age = 1;
      address = null;
      System.out.println("Im printing at the time of constructor");

   }

  public void display() {
      System.out.println(name);
      System.out.println(age);
      System.out.println(address);
  }
}


public class MainClass {
  public static void main(String...args) {

     /*Creating an object of Person class and at the same time calling the Constructor*/
     // Person one = new Person();
      /*now we are trying to print the value we have assigned in the Constructor*/
     new Person().display(); //can do like this
  }
}

