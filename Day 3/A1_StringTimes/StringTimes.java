/**.
 * Given a string and an integer value n, repeat the string and concatenate
 * to the resultant string n times.
 *
 * Input : Hi, 2
 * Output : HiHi
 *
 * You can see the more test cases in the JUnit.java file.
 *
 * @author Siva Sankar
 *Im working */

final class StringTimes {
    /**
     *constructor.
     */
    private StringTimes() {

    }
    /**.
     * This method returns the String that is appending the String n
     * times
     * @param  str the given String
     * @param  n   the integer
     * @return the String that is appended n times to the resultant Stirng
     */
    public static String stringTimes(final String str, final int n) {
        //  Your code goes here....

        String out = "";
        for (int i = 0; i < n; i++) {
            out += str;
        }
        return out;
    }
}
