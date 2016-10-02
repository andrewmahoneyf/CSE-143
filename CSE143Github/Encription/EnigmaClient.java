import java.util.*; // scanner
import java.io.*;

public class EnigmaClient {
   public static void main(String[] args) {
      
      giveIntro();
      Scanner console = new Scanner(System.in); // user input
      Enigma input = rotorSettings(console); 
      codeMessage(console, input);
   }
   
   // method to give introduction to user 
   public static void giveIntro() {
      System.out.println("Welcome to Enigma!");
      System.out.println("This program will help you encode or decode ");
      System.out.println("messages using an Enigma three-ring model.");
      System.out.println();
      System.out.println("Please select from the menu below:");
      System.out.println("   1. Use default rotor setings");
      System.out.println("   2. Input custom rotor settings");
      System.out.print("Selection: ");
   }
   
   // takes in scanner and uses user input to determind which rotor settings they want
   // returns an Enigma object with desired rotor settings
   public static Enigma rotorSettings(Scanner console) {     
      int select = console.nextInt();
      System.out.println();
      if (select == 1){
         System.out.println("Using default settings.");
         System.out.println("The Enigma model will use the following settings:");
         System.out.println("       Outer ring: #BDFHJLNPRTVXZACEGIKMOQSUWY");
         System.out.println("       Middle ring: #EJOTYCHMRWAFKPUZDINSXBGLQV");
         System.out.println("       Inner ring: #GNUAHOVBIPWCJQXDKRYELSZFMT");
         System.out.println();
         Enigma input = new Enigma();
         return input;
      } else {
         System.out.println("Using user settings.");
         System.out.println("The outer ring is: #BDFHJLNPRTVXZACEGIKMOQSUWY");
         System.out.print("Please input middle ring: ");
         String middle = console.next();
         System.out.print("Please input inner ring: ");
         String inner = console.next();
         System.out.println();
         Enigma input = new Enigma(middle, inner);
         return input;
      }
   }
   
   // takes in scanner and the enigma object
   // Asks to encrypt or decrypt than calls Enigma e=methods to complete
   public static void codeMessage(Scanner console, Enigma input) {
      System.out.println("Would you like to:");
      System.out.println("   1. Encript");
      System.out.println("   2. Decript");
      System.out.println("   3. Run Default Example");
      System.out.print("Selection: ");
      int selection = console.nextInt();
      System.out.println();
      if(selection == 1) {
         System.out.println("What message do you want to encrypt?");
         console.nextLine();
         System.out.println("Your encrypted code is: " + input.encrypt(console.nextLine()));
      } else if (selection == 2) {
         System.out.println("What message do you want to decrypt?");
         System.out.println("Your message is: " + input.decrypt(console.next()));
      } else {
         String example = "Computer Programing is Lots of Fun";
         System.out.println("You have chosen to use the default string: " + example);
         String encrypted = input.encrypt(example);
         System.out.println("After encrypting, your code is: " + encrypted);
         System.out.println("If we decrypt this code we get back to: " + input.decrypt(encrypted));  
      }
   }
} 