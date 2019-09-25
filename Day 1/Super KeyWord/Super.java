/** hi.
 * this is
 * Class A */
class A {
    /**.
     * integer A*/
    private int integerA;
    // this class A constructor() takes one argument for creation

    A(final int a) {
        this.integerA = a;       // assigns it to integerA [a class A variable]
        System.out.println("In constructor A");
    }

    // method(argument1)
    public void method(final int a) {
        System.out.println("Im with one argument : " + a);
    }

    public int getIntegerA() {
        return this.integerA;
    }
}

/* Class B extending A*/
class B extends A {
    /**.
     * integer B*/
    private int integerB;

    // this class B constructor() takes two argument for creation
    /* Constructor for class A*/
    B(final int a, final int b) {
        super(a);
        integerB = b;
        System.out.println(A.getIntegerA + " " + integerB);
    }

    // method(argument1, argument2)
    public void method(final int a, final int b) {
        System.out.println("Im with two argument : " + a + " " + b);
    }

    public void method(final double a, final double b) {
        System.out.println("Im with two double arguments: " + a + " " + b);
    }

    public int getIntegerB() {
        return this.integerB;
    }
}

/*hi.
*Super class */
final class Super {

  /*
  *constructor */
    private Super() {
    }

  /* Main Function*/
    public static void main(final String[] args) {
        final int arg1 = 5;
        final int arg2 = 10;
        B nB = new B(arg1, arg2);
        System.out.println(nB.getIntegerA() + "  " + nB.getIntegerB());

        //the below calls exhibits method overloading

        // calls the one with only one argument
        nB.method(arg1);

        // calls the one with two arguments
        nB.method(arg1, arg2);

        // call two arguments double
        nB.method((double) arg1, (double) arg2);
    }
}
