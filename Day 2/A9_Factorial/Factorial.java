/**
 * 
 */

 public class Factorial {

    /**
     * This method finds the factorial of a value n. If n is in the range of 
     * 1 to 20 (inclusive) and retuns the factorial otherwise -1
     * @param n, the integer n.
     * @return factorial of n if n is in 1 to 20 (inclusive) and -1 otherwise.
     */
   public static long factorial(int n) {

      if (n == 0 || n == 1){
         return 1;

      }else if(n > 1 && n <= 20){
         // long a = (long)n;
         return fact(n);
      }else{
         return -1;
      }

   }

   public static long fact(int n){

      if (n == 1)
         return 1;
      // long nn = (long)n;
      return n * fact(n-1);
   }

 }