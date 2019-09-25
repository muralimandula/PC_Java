class Parent {
    int value = 45;

    public void get_value() {
        System.out.println("parent: "+value);
    }
}
/**
 * 
 */
class Child extends Parent {
    int value = super.value * 2;
    // super.value = updated *2 ;

    public void get_value() {                  //overrides the parent method
        System.out.println("child: "+(value)); //value is from this object
    }
}

public class MethodOverriding {
    public static void main(String...args) {
        
        //Creating object for parent class
        Parent obj1= new Parent();

        //instantiating Parent class object with child class reference
        Parent obj2 = new Child();  // on creation it holds the inherited content from the parent class

        obj1.get_value();
        obj2.get_value();
    }
}