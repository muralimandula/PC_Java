// Java program to illustrate the 
// concept of abstract class 

import java.io.*; 

abstract class Shape { 

	String name = "";
	
	Shape(String name) { 
		this.name = name; 
	} 
	
	// non-abstract/ default methods 
    // can be accessed directly, since inheritance happens
	public String getName() {
        return this.name;
    }

    public String define() {
        return "Im an Abstract class for shape, I say areaFormual() and noOfSides() are mandatory";
    }

	// methods to be overridden/ mandatory methods
	abstract public String areaFormula();
	abstract public int noOfSides();
} 


class Rectangle extends Shape { 
	
	int length, width; 
    // String name;   obtained virtually form iheritance
	
	// constructor 
	Rectangle(int length, int width, String name) { 
		super(name);
		this.length = length; 
		this.width = width; 
	} 
	
    // overriding 

	@Override
	public String areaFormula() { 
		return "length * breadth"; 
	}

	@Override
	public int noOfSides() {
		return 4;
	} 

} 

class Circle extends Shape 
{ 
	double pi = 3.14; 
	int radius; 
	
	//constructor 
	Circle(int radius, String name) 
	{ 
		
		super(name); 
		this.radius = radius; 
	} 

	@Override
	public String areaFormula() { 
		return "Pi * r^2";
	}

	@Override
	public int noOfSides() {
		return 0;
	} 
} 

class AbstractClass 
{ 
	public static void main (String[] args) 
	{ 
		// creating the Object of Rectangle class 
		// and using shape class reference. 
		Shape rect = new Rectangle(2,3, "Rectangle");

        System.out.println("Im a shape of type : " + rect.getName());
        System.out.println("Formula for area   : " + rect.areaFormula());
        System.out.println("No.of sides        : " + rect.noOfSides());
		
        System.out.println(rect.define());
		System.out.println(" ");
		
		// creating the Objects of circle class 
		Shape circle = new Circle(2, "Cicle");
        System.out.println("Im a shape of type : " + circle.getName());
        System.out.println("Formula for area   : " + circle.areaFormula());
        System.out.println("No.of sides        : " + circle.noOfSides());
	} 
} 
