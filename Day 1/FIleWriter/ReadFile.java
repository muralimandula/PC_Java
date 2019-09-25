// import java.io.File;
// import java.util.Scanner;

// public class ReadFile{
//   public static void main(String args[]) throws FileNotFoundException{
//     File f= new File("Credits.txt");
//     Scanner sc= new Scanner(f);
//     while(sc.hasNextLine()){
//         System.out.println(sc.nextLine());
//     }
//   }
// }

import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class ReadFile{
    public static void main(String[] args) throws IOException {

        File myFileToRead = new File("Credits.txt");

        // Scanner scan = new Scanner(System.in);        // this Scanner(System.in); will be for scanning through input in console
        
        Scanner scan2 = new Scanner(myFileToRead);      // this Scanner(file_name);  will be for scanning through content in the file

        while(scan2.hasNextLine()) {
            System.out.println(scan2.nextLine());
        }
        scan2.close();                                  //since, scanning a file to read, must be closed at some instance
    }
}