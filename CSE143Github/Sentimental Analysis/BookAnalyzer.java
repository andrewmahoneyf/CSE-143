import java.io.*;
import java.util.*;


public class BookAnalyzer{
   private Set<String> posWords;
   private Set<String> negWords;
   private ArrayList<String> bookWords;
   private int negCount, posCount, mostNeg, mostPos; // variables for counting words
   private long startTime, endTime, duration; // variables to keep track of time
   
   // constructor takes in files for posWords, negWords, and a book
   // constructs an array list for words in the book and turns pos/neg files to HashSets
   // takes time of whole operation
   public BookAnalyzer(File positive, File negative, File book) throws FileNotFoundException{
      this.bookWords = new ArrayList<String>();
      this.posWords = new HashSet<String>();
      this.negWords = new HashSet<String>();
      startTime = System.nanoTime();
      Scanner bookScan = new Scanner(book);
      while(bookScan.hasNext()) {
         String word = bookScan.next().toLowerCase();
         bookWords.add(word);
      }
      Scanner posScan = new Scanner(positive);
      while(posScan.hasNext()) {
         String word = posScan.next().toLowerCase();
         posWords.add(word);
      }
      Scanner negScan = new Scanner(negative);
      while(negScan.hasNext()) {
         String word = negScan.next().toLowerCase();
         negWords.add(word);
      }
      counter();
      endTime = System.nanoTime();
      duration = (endTime - startTime);
   }
   
   // returns the array size of bookWords for the total word count of the book
   public int totalCount() {
      return bookWords.size();
   }
   
   // goes through all the words in the book and counts if they are pos or neg
   public void counter(){
      for(int i = 0; i < bookWords.size(); i++){
         if (negWords.contains(bookWords.get(i))){
            negCount++;
         }
         if (posWords.contains(bookWords.get(i))){
            posCount++;
         }
      }
   }
   
   // getter method for total negative word count
   public int negCount() {
      return negCount;
   }
   
   // getter method for total positive word count
   public int posCount() {
      return posCount;
   }
   
   // Decides genre of book based upon total count of neg and pos words
   public String genre() {
      if(posCount > negCount)
         return "Comedy";
      else if (posCount < negCount)
         return "Tragedy";
      else
         return "Boring";
   }
   
   // gets the duration of the analysis
   public long totalTime() {
      return duration;
   }
   
   // finds positive word used the most and returns it with the amount of times
   public String mostPos()	{
	   int max = 0;
      String commonWord = "no positive words found";
	   java.util.Iterator<String> iter = posWords.iterator();
	   while(iter.hasNext())	{
		   String temp = iter.next();
		   mostPos= Collections.frequency(bookWords, temp);
		   if(mostPos > max)	{
			   commonWord = temp;
			   max = mostPos;
		   }
      mostPos = max;
	   }
	   return commonWord + ", " + mostPos;
   }
   
   // finds negative word used the most and returns it with the amount of times
   public String mostNeg()	{
	   int max = 0;
      String commonWord = "no negative words found";
	   java.util.Iterator<String> iter = negWords.iterator();
	   while(iter.hasNext())	{
		   String temp = iter.next();
		   mostNeg= Collections.frequency(bookWords, temp);
		   if(mostNeg > max)	{
			   commonWord = temp;
			   max = mostNeg;
		   }
      mostNeg = max;
	   }
	   return commonWord + ", " + mostNeg;
   }
}

