/*
 * Yahtzee class
 *
 */
final class Yahtzee {
    /**.
     * dummy constructor
     */
    private Yahtzee() {
    }

    /**.
     * Main method
     * @param args just a string
     */
    public static void main(final String[] args) {

        int noOfAttempts = 1;
        int dice1 = roll();
        int dice2 = roll();
        int dice3 = roll();
        int dice4 = roll();
        int dice5 = roll();

        while ((dice1 != dice2) || (dice3 != dice4) || (dice4 != dice5)) {
            noOfAttempts++;
            dice1 = roll();
            dice2 = roll();
            dice3 = roll();
            dice4 = roll();
            dice5 = roll();
        }
        System.out.println(noOfAttempts + " attempts to met a Yahtzee.");
        System.out.println();
    }

    public static int roll() {
        final int six = 6;
        return (int) ((Math.random() + 1) * six);
    }
}
