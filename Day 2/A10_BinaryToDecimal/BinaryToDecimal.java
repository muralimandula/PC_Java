/**
 * Given a binary string that contains a sequence of 1's and 0's, returns an
 * equivalent to the decimal value in integer form.
 * 
 * Input : 1010
 * Output : 10
 * 
 * Input : 000000000000001010
 * Output : 10
 * 
 * @author Siva Sankar
 */

public class BinaryToDecimal {

    /**
     * This method reads in a Binary String and returns the equivalent to the
     * decimal value of the binary string.
     * @param s, the binary string that contains only sequence of 1's and 0's.
     * @return the decimal number n of the binary string.
     */
    public static int binaryToDecimal(String s) {

      // return Integer.parseInt(s,2);                                                                //If parsing used: solves in a one liner
      int num = 0;
      int power = 0;

      // char[] a = s.toCharArray();

      for(int i = s.length()-1; i >= 0; i--) {

        if(s.charAt(i) == '1'){
          num = num + (int)(Math.pow(2, power));                                                       //If only char is compared
        }
        // num = num + (int)(Integer.parseInt(Character.toString(a[i])) * Math.pow(2, power));         //If char[] a = s.toCharArray() used

        // num = num + (int)(Integer.parseInt(Character.toString(s.charAt(i))) * Math.pow(2, power));  //If s.charAt(index) used
        power++;

      }
      return num;
   }

}
