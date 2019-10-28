// A Simple Java program to show working of user defined 
// Generic classes 

// We use < > to specify Parameter type 
class GenericClass<T> 
{

	// An object of type T is declared 
	T obj;

	GenericClass(T obj) { 
        this.obj = obj;
    } // constructor 


    public T getObject() {
        return this.obj; 
    } 
} 

// Driver class to GenericClass above 
class Generics 
{ 
	public static void main (String[] args) 
	{ 
		// instance of Integer type 
		GenericClass<Integer> iObj = new GenericClass<Integer>(15); 
		System.out.println(iObj.getObject()); 

		// instance of String type 
		GenericClass <String> sObj = new GenericClass<String>("GeeksForGeeks"); 
		System.out.println(sObj.getObject()); 
		
	} 
}
