import java.util.*;
import java.io.*;

public class Enigma {
	
   public static final String outerRotor = "#BDFHJLNPRTVXZACEGIKMOQSUWY"; 
	//required instance members go here 
	//for example, all three rotors are declared here 
	//instance member to keep count to move middle rotor
   private String middleRotor;
   private String innerRotor;
   private int counter;
   private String encryptedMessage = "";
   private String decryptedMessage = "";
	   	
   //default constructor - constructs enigma machine as shown in spec 
   public Enigma(){
      middleRotor = "#EJOTYCHMRWAFKPUZDINSXBGLQV";
      innerRotor = "#GNUAHOVBIPWCJQXDKRYELSZFMT";
   }
   
   // non-default constructor - constructs machine with user specified inner and middle rotors
   // calls isRotorValid method to make sure rotors meet requirements
   public Enigma(String s1, String s2){
      if(isRotorValid(s1)){
         this.middleRotor = s1;
      }
      if(isRotorValid(s2)){
         this.innerRotor = s2;
      }
   }
	
   //verify that rotStr is exactly 27 chars long 
   //verify that all chars from english alphbet occur only once 
   //verify that rotor starts with a # char
   // throws exepetion or returns fale if these arent met
   private boolean isRotorValid (String rotStr){
      for(int i = 0; i < rotStr.length(); i++) {
         for(int j = 0; j < rotStr.length(); j++) {
            if(rotStr.charAt(i) == rotStr.charAt(j)) {
               return false;
            }
         }
      }
      if(rotStr.length() != 27 || rotStr.charAt(0) != '#') {
         throw new IndexOutOfBoundsException();
      }
      return true;            
   } 
	
   // This takes in the message from the user and encypts it.
   // forloop runs through every character and calls encodeChar method to encypt it
   // rotates the rotors clockwise
   public String encrypt (String message){
      message = message.toUpperCase();  
      for(int i = 0; i < message.length(); i++){			
         encryptedMessage += encodeChar(message.charAt(i));
         rotateClockwise();
      }
      reset();
      return encryptedMessage;
   }
	
   // This takes in the message from the user that needs to be decripted.
   // forloop runs through every character and calls decode method to decode it
   // With the examples provided in the assignment rotateAntiClockwise doesnt work
   // So I rotated it clockwise. returns decrypted new message
   public String decrypt (String message){ 
      for(int i = 0; i < message.length(); i++){			
         decryptedMessage += decodeChar(message.charAt(i));
         rotateClockwise();
      }
      reset();
      return decryptedMessage;
   } 
   
   // this finds the code character for ch (as per spec)
   // takes in character from message and returns encrypted version
   private char encodeChar (char ch){
      if (ch == ' '){
         ch = '#';
      }
      char c = outerRotor.charAt(innerRotor.indexOf(ch));
      ch = outerRotor.charAt(middleRotor.indexOf(c));
      return ch;
   } 
	
   // this finds the original character for the code ch (as per spec)
   // Takes in character from message and returns the decoded version
   private char decodeChar (char ch){
      char c = middleRotor.charAt(outerRotor.indexOf(ch));
      ch = innerRotor.charAt(outerRotor.indexOf(c));
      if (ch == '#'){
         return ' ';
      } 
      return ch;
   } 
	
   // rotates the clockwise and once inner makes full loop middle rotates once
   private void rotateClockwise(){
      innerRotor = innerRotor.charAt(innerRotor.length() - 1) + innerRotor.substring(0, innerRotor.length() - 1);
         counter ++;
      if (counter % 27 == 0) {
         middleRotor = middleRotor.charAt(middleRotor.length() - 1) + middleRotor.substring(0, middleRotor.length() - 1);
      }
   } 
	
   // rotates inner counter clockwise and than middle once the inner is back at end point
   private void rotateAntiClockwise(){ 
      innerRotor = innerRotor.substring(1) + innerRotor.charAt(0);
      if (innerRotor.charAt(26) == '#') {
         middleRotor = middleRotor.substring(1) + middleRotor.charAt(0);
      }
   } 
	
   // resets to align all # chars on all rotors (returns rotors to initial configuration)
   // by rotating clockwise until it's back at starting position
   public void reset (){
      while(innerRotor.charAt(0) != '#') {
         rotateClockwise();
      }
      while(middleRotor.charAt(0) != '#') {
         rotateClockwise();
      }
      counter = 0;
   }
}
