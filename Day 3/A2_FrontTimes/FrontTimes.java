/**
 * Given a string and a non-negative int n, we'll say that the front
 * of the string is the first 3 chars, or whatever is there if the
 * string is less than length 3. Return n copies of the front;
 *
 * Input : frontTimes("Chocolate", 2)
 * Output : ChoCho
 *
 * Input : frontTimes("Chocolate", 3)
 * Output : ChoChoCho
 *
 * Input : frontTimes("Abc", 3)
 * Output : AbcAbcAbc
 *
 * @author: Siva Sankar
 */

public final class FrontTimes {

    /**.
     * dummy constructor
     */
    private FrontTimes() {

    }

    /**
     * This method returns n copies of the front.
     * @param str the string to be considered.
     * @param n the non-negative integer value.
     * @return the n copies of the front string.
     */
    public static String frontTimes(final String str, final int n) {
        //  Your code goes here....
        String s = "";
        final int three = 3;

        if (str.length() > three) {
            for (int i = 0; i < three; i++) {
                s = s + str.charAt(i);
            }
        } else {
            s = str;
        }

        String out = "";
        for (int i = 0; i < n; i++) {
            out = out + s;
        }
        return out;
    }
}
