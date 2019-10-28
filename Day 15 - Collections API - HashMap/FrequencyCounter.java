import java.util.Scanner;
import java.io.IOException;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;


final class FrequencyCounter {

    /**.
     * Dummy Constructor.
     */
    private FrequencyCounter() {

    }
    /**.
     *
     * @param args final arguments
     * @throws IOException fro reading a file
     */
    public static void main(final String[] args) throws IOException {

        /*
         * Reading tale.txt using Scanner
         */
        File myFileToRead = new File("tale.txt");

        // throws will throw an exception if file not found.
        Scanner scanFromFile = new Scanner(myFileToRead);


        // HashMap to hold words and their count
        HashMap<String, Integer> wordCount = new HashMap<String, Integer>();

        /* HashMap to hold alphabets and ArrayList of tits corresponding words
        * 
        * { a : {"a", "apple", "and", "anaali"},
        *   b : {"be", "been", "behave", "biyyam"},
        *   c : {"", ....},
        *   d : {...},
        *   }
        */
        HashMap<Character, ArrayList<String>> wordOnChar = new HashMap<Character, ArrayList<String>>();

        String line;

        while (scanFromFile.hasNext()) {

            line = scanFromFile.nextLine().toLowerCase();
            if (line != "") {

                line = line.replaceAll("[!@#$%^&*()_+=;':,.\'\"`1-9]", "");
                line = line.replaceAll("-", "");
                
                for (String eachString : line.split(" ")) {

                    if (wordCount.containsKey(eachString)) {
                        int existingCount = wordCount.get(eachString);
                        wordCount.put(eachString, (existingCount + 1));


                    } else { 
                        try {
                            char firstChar = eachString.charAt(0);

                            if(wordOnChar.containsKey(firstChar)) {
                                wordOnChar.get(firstChar).add(eachString);
                            } else {
                                if (firstChar != '[' && firstChar != ']' && firstChar != '/' && firstChar != '0') {
                                    ArrayList<String> wordsOnEachChar = new  ArrayList<String>();
                                    wordsOnEachChar.add(eachString);
                                    wordOnChar.put(firstChar, wordsOnEachChar);  
                                }
                            }
                            wordCount.put(eachString, 1);
                        } catch(Exception e) {

                        }
                    }
                }
            }
        }

        scanFromFile.close();
        // closing scanner on movie.txt after loading

        final int numZero = 0;
        final int numTen = 10;
        int i = numZero;

        System.out.println("Showing few words from the map!!");
        for (String string : wordCount.keySet()) {
            System.out.println(string + " : " + wordCount.get(string));
            i++;
            if (i == numTen) {
                break;
            }
        }

        System.out.println("\n\nList of alphabets" 
                    + " with count of their corresponding words.");

        for (char eachChar : wordOnChar.keySet()) {
            System.out.println(eachChar + " : " 
                                + wordOnChar.get(eachChar).size());
            }
    }
}

