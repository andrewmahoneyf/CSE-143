import java.util.*; // scanner
import java.io.*; // files

public class BabyNames {
   public static void main(String[] args) throws FileNotFoundException {

   HashSet<String> girlNames = new HashSet<>();
   HashSet<String> boyNames = new HashSet<>();
   Map<Integer, String> Andrew = new HashMap<>();

   Scanner input = new Scanner(new File("names_2013.txt")); // access file with names
   while(input.hasNext()) {
      String person = input.next();
      person = person.replace(',' , ' ');
      Scanner linescan = new Scanner(person);
      String name = linescan.next();
      String gender = linescan.next();
      int num = linescan.nextInt();
      if (name.equals("Andrew")) {
         Andrew.put(num, gender);
      }
      if (gender.equals("F")) {
         girlNames.add(name);
      } else {
         boyNames.add(name);
      }
   }
   System.out.println("Number of unique female names = " + girlNames.size());
   System.out.println("Number of unique boy names = " + boyNames.size());
   Set intersect = new TreeSet(girlNames);
   intersect.retainAll(boyNames);
   System.out.println("Number of unisex names = " + intersect.size());
   System.out.println("Number of babies with the name Andrew: " + Andrew);



   }
}