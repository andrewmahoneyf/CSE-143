import java.io.*;
import java.util.*;
import java.text.*;


public class SentimentReport {
   public static final boolean TEST_MODE = false; // false = off ,  true = on
   public static final DecimalFormat df = new DecimalFormat("#.00"); // formats decimal for percentage
   
   public static void main(String[] args) throws IOException {
      intro();
      // with test mode on the default books are used, when off user is asked for txt file for book
      if (TEST_MODE)	{
         getReport(new File("Macbeth.txt"));
         getReport(new File("MuchAdoAboutNothing.txt"));
      } else {
         try {
            Scanner input = new Scanner(System.in);	
            String more ="yes";
            while(more.startsWith("y")){
               System.out.print("Enter the name of book to be analyzed: ");
               File book = new File(input.next());
               System.out.println();
               getReport(book);
               System.out.print("Enter \"yes\" if you want to analyze another book ");
               more = input.next();
            }
         }
         catch(IOException e){
            System.out.println("File not found");
         }
      }
   }
   
   // Intro method briefly introduces user to program   
   public static void intro() {
      System.out.println("This program will analyze the words used in books");
      System.out.println("using sentimental analysis to test if the book is a");
      System.out.println("comedy, tragedy, or a nuetral book with word counts.");
      System.out.println();
   }
   
   // takes in the file for the book text being analyzed. 
   // Creates BookAnalyzer object using posWords, negWords and book txt
   // Prints out analysis for the book
   public static void getReport(File book) throws IOException {
      BookAnalyzer analyze = new BookAnalyzer(new File("posWords.txt"), new File("negWords.txt"), book);
      System.out.println("The book file being analyzed is: " + book);
      System.out.println("The total number of words in the book is: " + analyze.totalCount());
      System.out.println("The total number of positive words in the book is: " + analyze.posCount());
      System.out.println("The percentage of total words that are positive is: " + df.format(100*((double)analyze.posCount()/(double)analyze.totalCount())) + "%");
   	System.out.println("The most commonly occurring positive word and the number of times it occured is: "+ analyze.mostPos());    
      System.out.println("The total number of negative words in the book is: " + analyze.negCount());
      System.out.println("The percentage of total words that are negative is: " + df.format(100*((double)analyze.negCount()/(double)analyze.totalCount())) + "%");
   	System.out.println("The most commonly occurring negative word and the number of times it occurs is: "+ analyze.mostNeg());
      System.out.println("The genre of the book analyzed is: "+ analyze.genre());
   	System.out.println("The total time used in completing the book analysis was: "+ analyze.totalTime() + " milliseconds");
      System.out.println();
   }
}