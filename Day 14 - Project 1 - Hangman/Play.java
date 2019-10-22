import java.util.Random;
import java.util.Set;
import java.util.HashSet;
import java.util.Scanner;


class Play {
    Movie[] moviesToPlay;
    Player player;

    Play() {
    }

    Play(Player player, Movie[] movieList) {
        this.moviesToPlay = movieList;
        this.player = player;
    }

    public void playNow() {

        Random rand = new Random();

        int randomMovieIndex = rand.nextInt(this.moviesToPlay.length);
        Movie movieToPlay = this.moviesToPlay[randomMovieIndex];

        String playerLevel = this.player.getLevel();


        if(playerLevel.equals("Random")) {
                 playerLevel = movieToPlay.getLevel();
        }


        int bonus;
        // System.out.println("Movie to guess : " + movieToPlay.getName());
        if(playerLevel.equals("Easy")) {
            bonus = 2;
        }else if(playerLevel.equals("Medium")) {
            bonus = 3;
        }else {
            bonus = 4;
        }

        String abc = "abcdefghijklmnopqrstuvwxyz";
        
        String originalMovieName = movieToPlay.getName();
        String temp = originalMovieName.toLowerCase();

        char[] movieCharArrToCheck = movieToPlay.getName().toLowerCase().toCharArray();
        char[] movieCharArrToDisplay = movieToPlay.getName().toCharArray();

        int toGuess = originalMovieName.length() -  Math.floorDiv(originalMovieName.length(), bonus);
        Set<Character> charSet = new HashSet<Character>();

        while(toGuess > 0) {
            int pos = rand.nextInt(movieCharArrToDisplay.length);
            if(movieCharArrToDisplay[pos] != ' ' && movieCharArrToDisplay[pos] != '_' && movieCharArrToDisplay[pos] != '\'') {
                charSet.add(movieCharArrToDisplay[pos]);
                movieCharArrToDisplay[pos] = '_';
                toGuess--;
            }
        }

        int noOfGuess = charSet.size() + bonus;
        String displayMovie = new String(movieCharArrToDisplay);

        //play loop starts here
        Scanner scan = new Scanner(System.in);
        int hints = 2;

        while(noOfGuess > 0 && !guessed(displayMovie, temp)) {

            System.out.println("Movie to guess : " + displayMovie   + "\t (" + noOfGuess + " left)");
            System.out.println("Choose from " + abc + "\n");

            if(hints > 0) {
                System.out.println("Type 'HINT' for a Hint. \t(" + hints + " left)" );
            }

            System.out.print("Enter your guess Character : ");
            String inputGuess = scan.nextLine().toLowerCase();

            while(inputGuess.equals("")){
                System.out.println("        Invalid input, Please enter a character from above.");
                System.out.print("Enter your guess Character : ");
                inputGuess = scan.nextLine().toLowerCase();
            };
            
            char guessChar = inputGuess.charAt(0);

            boolean isCharGuessed = false;
            System.out.println("---------------------------------------------------");

            if(inputGuess.length() > 1 && !inputGuess.equals("hint")) {
                System.out.println("Invalid input!!! Lost one Guess.\n");
            
            
            }else if(inputGuess.equals("hint")){
                giveHint(hints, movieToPlay);
                hints--;

            }else if(abc.contains(Character.toString(guessChar))) {
                
                char[] tempArr = displayMovie.toCharArray();

                for (int i = 0; i < movieCharArrToCheck.length; i++) {
                    // System.out.println(guessChar + " " +movieCharArr[i]);
                    if(guessChar == movieCharArrToCheck[i]) {
                        isCharGuessed = true;
                        tempArr[i] = guessChar;
                        player.setScore(player.getScore() + 1);
                    }
                }
                if(isCharGuessed) {
                    System.out.println("                 Good Guess!!\n");
                } else {
                    System.out.println("             Oops!! Lost one choice.\n");
                }

                abc = abc.replace(guessChar, '_');
                displayMovie = new String(tempArr);

            }else {
                System.out.println("             Oops!! Lost one choice.\n");
            }
            noOfGuess--;
        }

        if(guessed(displayMovie, temp)) {

            player.setScore(player.getScore() + (hints * bonus));
            System.out.println("\n-----YOU WON----\n");

        }else {
            this.player.setScore(0);
            System.out.println("\n" + player.getName() + "!! It's  '" + originalMovieName + "'");
            System.out.println("-----YOU LOST----\n");

        }
    }
    

    public void giveHint(final int hints, final Movie movieToPlay) {

        if (hints == 2) {
            System.out.println("HINT\n \t HINT : " + movieToPlay.getInfo() + "\n");
        }else if (hints == 1) {
            System.out.println("HINT\n \t HINT : " + movieToPlay.getCast() + "\n");
        }else {
            System.out.println("No Hints LEFT!!");
        }
    }

    public boolean guessed(String displayMovie, String originalMovieName) {
        displayMovie = displayMovie.toLowerCase();
        originalMovieName = originalMovieName.toLowerCase();
        return displayMovie.equals(originalMovieName);
    }
}
