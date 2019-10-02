// Java program to illustrate the 
// concept of interface 
import java.io.*; 

interface Shape 
{   
    // abstract method
    String getName();
	String areaFormula(); 
	int noOfSides();
} 



class Rectangle implements Shape { 
	String name;
	int length, width; 
    // String name;   obtained virtually form iheritance
	
	// constructor 
	Rectangle(int length, int width, String name) { 
		this.name = name;
		this.length = length; 
		this.width = width;
	} 
    
    public String getName() {
        return name;
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

class Circle implements Shape 
{   
    String name;
	double pi = 3.14; 
	int radius; 
	
	//constructor 
	Circle(int radius, String name) {
		this.name = name;
		this.radius = radius; 
	} 

    public String getName() {
        return name;
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

class Interface 
{ 
	public static void main (String[] args) 
	{ 
		// creating the Object of Rectangle class 
		// and using shape class reference. 
		Shape rect = new Rectangle(2,3, "Rectangle");

        System.out.println("Im a shape of type : " + rect.getName());
        System.out.println("Formula for area   : " + rect.areaFormula());
        System.out.println("No.of sides        : " + rect.noOfSides());
		
		System.out.println(" ");
		
		// creating the Objects of circle class 
		Shape circle = new Circle(2, "Cicle");
        System.out.println("Im a shape of type : " + circle.getName());
        System.out.println("Formula for area   : " + circle.areaFormula());
        System.out.println("No.of sides        : " + circle.noOfSides());
	} 
} 
