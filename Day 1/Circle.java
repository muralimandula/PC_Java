import java.util.*;
/*Here we are creating a class nothing but we are defining our own type*/
class otherClassCircle {
   /*Declaring a variable which is used to hold radius and area of circle */
    double radius;
    double area;

   /*Defining a Method for calculating Area of Circle*/
    public double findArea(double r) {
       radius = r;
       return  3.14*radius *  radius;
    }

    public double myPartition(int nOfParts){
      area =  (3.14*radius *  radius);

      return (area*1.0)/0;
    }
}


// a driver class - usually the one having our starter/ driver /main method
public class Circle {

  public static void main(String...args) {
      /*Creating an object for the Userdefined class 'otherClassCircle'*/
      otherClassCircle c = new otherClassCircle();

      /*Methods are called by using Dot (.) operator*/
      c.findArea(3.5);

      // System.out.println(5/0);
      /*Creating another object for otherClassCircle*/
      otherClassCircle c2 = new otherClassCircle();
      c2.findArea(4.1);


      // System.out.println("my partition is : " + c2.myPartition(0) + " out of " + c2.findArea(4.1));


      try{
        System.out.println("my partition is : " + c2.myPartition(0) + " out of " + c2.findArea(4.1));
      } catch (Exception e){
        System.out.println(e);
      }
  }
}