import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**.
 * Hangman Game class
 */
class Hangman {
    /**.
     * MovieLists
     * easy, medium, hard will be updated later...
     * on reading each category for first time.
     * 
     * size for whole movieList.
     */
    Movie[] movies;
    Movie[] easyMovies;
    Movie[] mediumMovies;
    Movie[] hardMovies;
    int size;

    Hangman() {
        final int numTwenty = 20;
        final int numZero = 0;
        this.movies = new Movie[numTwenty];
        this.size = numZero;
    }

    /**
     * 
     * @param m movie to br added to movies
     */
    public void add(final Movie m) {
        movies[size] = m;
        size++;
        if (size == movies.length) {
            this.movies = java.util.Arrays.copyOf(movies, size * 2);
        }
    }


    /**
     * To print a movieList if needed.
     * @param moviesList
     */
    public void printMovies(final Movie[] moviesList) {
        for (int i = 0; i < moviesList.length; i++) {
            if (moviesList[i] == null) {
                break;
            }
            System.out.println(moviesList[i].toString());
        }
    }


    /**
     * 
     * @param level each level/category
     * @return moviesList according to category/Level
     */
    public Movie[] getMovies(final String level) {

        //simply return previously updated easyMovies. Since same
        if (easyMovies != null && level.equals("Easy")) {
            return easyMovies;
        }

        //simply return previously updated mediumMovies. Since same
        if (mediumMovies != null && level.equals("Medium")) {
            return mediumMovies;
        }

        //simply return previously updated hardMovies. Since same
        if(hardMovies != null && level.equals("Hard")) {
            return hardMovies;
        }

        //retur all movies! since random and will be selected randomly
        if (level.equals("Random")) {
            return java.util.Arrays.copyOf(this.movies, this.size);
        }

        final int numTen = 10;
        Movie[] moviesToPlay = new Movie[numTen];
        int j = 0;
        for (int i = 0; i < size; i++) {
            if (movies[i] == null) {
                break;
            }
            if (movies[i].getLevel().equals(level)) {
                moviesToPlay[j++] = movies[i];
            }
        }

        // removing null values created by default in movieToPlay

        moviesToPlay = java.util.Arrays.copyOf(moviesToPlay, j);

        //Assigning to each Category/Level *Like Caching*
        if (level.equals("Easy")) {
            this.easyMovies = moviesToPlay;
        }else if (level.equals("Medium")) {
            this.mediumMovies = moviesToPlay;
        }else {
            this.hardMovies = moviesToPlay;
        }

        return moviesToPlay;
    }

    /**
     * 
     * Prints the Player[] according to score
     * Uses Collections.sort() that accepts ArrayList<>
     * @param players participated in Hangman
     */
    public void showLeaderBoard(final Player[] players) {

        ArrayList<Player> playersToSort = new ArrayList<Player>();
        for (Player eachPlayer : players) {
            playersToSort.add(eachPlayer);
        }
        Collections.sort(playersToSort);

        System.out.println("Leaderboard HANGMAN muiltiplayer!");
        System.out.println("");
        System.out.println("NAME \t LEVEL \t SCORE");
        System.out.println("-----------------------");

        for (Player p : playersToSort) {
            System.out.println(p.toString());
        }
    }

    
    /**
     * method, that adds movies to our HangMan Game
     * @param scannedInfo from the movies.txt
     */
    public void addMoviesToGame(final Scanner scannedInfo) {

        while (scannedInfo.hasNext()) {

            String name = scannedInfo.nextLine();
            String level = scannedInfo.nextLine();
            String info = scannedInfo.nextLine();
            String cast = scannedInfo.nextLine();

            Movie movie = new Movie(name, level, info, cast);
            //adding movie object
            add(movie);

            String dummyLine = scannedInfo.nextLine();
        }
    }

    /**
     * 
     * @param noOfPlayers no.of participants into Hangman
     * @param scan a scanner to read player Names from console
     * @return Player[] plaey array
     */
    public Player[] createPlayerObjects(final int noOfPlayers, final Scanner scan) {
        Player[]  players = new Player[noOfPlayers];
        Player player;

        //Creating player objects with names
        for (int i = 0; i < noOfPlayers; i++) {
            System.out.print("Enter name of player " + (i + 1) + " : ");
            String playerName = scan.nextLine();

            player = new Player(playerName);
            players[i] = player;
        }
        System.out.println("\n");

        return players;
    }
}


final class UtilityClass {
    /**.
     * Dummy constructor
     */
    private UtilityClass() {
    }
    public static void main(final String[] args) throws IOException {

        Hangman game = new Hangman();

        /**
         * Reading movies.txt using Scanner
         * scanFromFIle to load movies into game using addMoviesToGame()
         */
        File myFileToRead = new File("movies.txt");
        Scanner scanFromFile = new Scanner(myFileToRead);
        game.addMoviesToGame(scanFromFile);
        scanFromFile.close();
        // closing scanner on movie.txt after loading


        // ANother scan object to read from console
        Scanner scan = new Scanner(System.in);
        System.out.println("\n ---------Welcome"
                        + " to MultiPlayer HANGMAN---------------\n");

        
        // Reading no.of players / Participants on Hangman
        System.out.print("Enter no.of Players : ");
        int noOfPlayers = Integer.parseInt(scan.nextLine());
        System.out.println("");

        // Creating player objects passing scanner and no.of players
        Player[] players = game.createPlayerObjects(noOfPlayers, scan);

        int playerIndex = 0;
        boolean gameOn = true;

        do {

            System.out.println("\n" + players[playerIndex].getName()
                                + "! Your game starts now, Keep guessing!!!\n");

            //Readinf players choice of level
            System.out.println("\n 1.EASY  2.MEDIUM  3.HARD  4.RANDOM  5.EXIT");
            String playerChoice = scan.nextLine();


            String levelChoice;
            Movie[] moviesToPlay;
            Play playObj;

            switch (playerChoice) {

                case "1":
                    levelChoice = "Easy";

                    // Setting player level on choice
                    players[playerIndex].setLevel(levelChoice);

                    // getting movies accoring to the level
                    moviesToPlay = game.getMovies(levelChoice);

                    // Creating a play Object - Game runs here
                    playObj = new Play(players[playerIndex], moviesToPlay);

                    ///------------------------Play TIME : playNow
                    playObj.playNow();
                    playerIndex++;
                    break;

                case "2":
                    levelChoice = "Medium";
                    players[playerIndex].setLevel(levelChoice);
                    moviesToPlay = game.getMovies(levelChoice);
                    playObj = new Play(players[playerIndex], moviesToPlay);
                    playObj.playNow();
                    playerIndex++;
                    break;

                case "3":
                    levelChoice = "Hard";
                    players[playerIndex].setLevel(levelChoice);
                    moviesToPlay = game.getMovies(levelChoice);
                    playObj = new Play(players[playerIndex], moviesToPlay);
                    playObj.playNow();
                    playerIndex++;
                    break;

                case "4":
                    levelChoice = "Random";
                    players[playerIndex].setLevel(levelChoice);
                    moviesToPlay = game.getMovies(levelChoice);
                    playObj = new Play(players[playerIndex], moviesToPlay);
                    playObj.playNow();
                    playerIndex++;
                    break;

                case "5":
                    gameOn = false;
                    break;

                default:
                    break;
            }
        } while (gameOn && playerIndex < noOfPlayers);

        game.showLeaderBoard(players);
        scan.close();
    }
}
