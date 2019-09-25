class Values  {
    int m = 0;
    int n = 0;
    
    public void values() {
      m = 12;
      n = 2;
      System.out.println("The values m, n are : " + m + ","+ n + "\n");
    }
  }

class ImMultiplying extends Values{      //ImMultiplying will inherit m,n from Values class along with Values() (that holds initialisation)
    public void multi() {
      System.out.println("The result of m * n = " + (m*n));
    }
}


class ImAdding extends ImMultiplying {
    public void add() {
      System.out.println("The result of m + n = " + (m+n));
    }
}


public class Inherit{
    public static void main(String[] args) {
        /* c object is created for ImAdding (knows add()) class extends 
                              ImMultiplying (knows multi()) which extends 
                              Values(knows values() m,n) */
    ImAdding c = new ImAdding();       

    // so, c finally can know m,n from Values(), m*n from multi(), m+n from add()

    c.values();        // Here, got m,n
    c.multi();         // multi will be done for m,n got above
    c.add();           // addition will be done for m,n got above
    }
}
