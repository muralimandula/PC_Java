import java.util.*;

public class MySetClass {
    public static void main(String args[]) { 
   /*Sets are used for storing collections of elements.
     Duplicate elements are not allowed in Sets */

        /*Creating an Object of HashSet Class*/
        HashSet name = new HashSet();

        /*Adding an element to the Set name*/
        name.add("Mark");
        name.add("tom");
        name.add("jack");
        name.add("july");
        name.add("patrik");
        System.out.println(name); /*Printing the set */
    }
}