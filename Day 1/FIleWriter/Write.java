import java.io.FileWriter;
import java.io.PrintWriter;

class Write{
  public static void main(String args[]){
    try{
      FileWriter fw= new FileWriter("Credits.txt");
      PrintWriter pw= new PrintWriter(fw);
      pw.println("Hello, this is first line");
      pw.println("this is second line");
      pw.close();
    }catch(Exception ex){
      System.out.println("error occured");
    }
  }
}