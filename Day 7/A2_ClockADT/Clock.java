/**
 * Clock data type. Write a data type Clock.java that
 * represents time on a 24-hour clock, such as 00:00, 13:30, or
 * 23:59. Time is measured in hours (00–23) and minutes (00–59).
 * To do so, implement the following public API:
 *
 * @author Siva Sankar
 */

final class Clock {
    /**.
     * Hours
     */
    private int hours;

    /**.
     * Minutes
     */
    private int minutes;
    // Creates a clock whose initial time is h hrs and m min.
    /**
     * This constructor will instatiates the object with the values of
     * the parameters h and m to the respective hrs nad min.
     * @param h hours
     * @param m minutes
     */
    Clock(final int h, final int m) {
        this.hours = h;
        this.minutes = m;
    }

    // Creates a clock whose initial time is specified as a string.
    //  using the format HH:MM.

    Clock(final String s) {
        final int zero = 0;
        final int two = 2;
        final int three = 3;
        final int five = 5;

        this.hours = Integer.parseInt(s.substring(zero, two));
        this.minutes = Integer.parseInt(s.substring(three, five));
    }

    // Returns a string representation of this clock, using the format HH:MM.
    public String toString() {
        String h = this.hours + "";
        String m = this.minutes + "";
        final int ten = 10;

        if (this.hours < ten) {
            h = "0" + this.hours;
        }
        if (this.minutes < ten) {
            m = "0" + this.minutes;
        }

        return h + ":" + m;
    }

    // Is the time on this clock earlier than the time on that one?
    public boolean isEarlierThan(final Clock that) {
        if (this.hours <= that.hours && this.minutes < that.minutes) {
            return true;
        }
        return false;
    }

    // Adds 1 minute to the time on this clock.
    public void tic() {
        final int zero = 0;
        final int tthree = 23;
        final int fnine = 59;

        if (this.minutes == fnine && this.hours == tthree) {
            this.hours = zero;
            this.minutes = zero;
        } else if (this.minutes == fnine) {
            this.minutes = zero;
            this.hours++;
        } else {
            this.minutes++;
        }
    }

    // Adds Δ min to the time on this clock.
    public void toc(final int delta) {
        final int sixty = 60;
        final int zero = 0;
        final int tfour = 24;

        if (delta > zero) {
            int minutesToAdd = delta % sixty;
            int hoursToAdd = (int) Math.floor(delta / sixty);

            this.minutes = this.minutes + minutesToAdd;
            this.hours = this.hours + hoursToAdd;

            if (this.minutes >= sixty) {
                this.hours++;
                this.minutes -= sixty;
            }

            if (this.hours >= tfour) {
                this.hours = this.hours % tfour;
            }
        }
    }

    // // Test client (see below).
    // public static void main(final String[] args) {
    //     final int
    //     Clock clock = new Clock("13:01");
    //     clock.toc(660);
    //     System.out.println(clock);
    // }
}
