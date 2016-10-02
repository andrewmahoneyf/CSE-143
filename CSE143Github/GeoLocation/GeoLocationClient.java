// Andrew Mahoney-Fernandes
// Assignment 1 Part A
// 
// This is the client code for the Geo Location Class.

public class GeoLocationClient {
   public static void main(String[] args) {  
      
      // Objects to store coordinates of three locations. 
      GeoLocation stash = new GeoLocation(34.988889, -106.614444);   
      GeoLocation abq = new GeoLocation(34.989978, -106.614357);
      GeoLocation fbi = new GeoLocation(35.131281, -106.61263);
      
      // Prints out first three lines with locations of places. 
      System.out.println("the stash is at " + stash);
      System.out.println("ABQ studio is at " + abq);
      System.out.println("FBI building is at " + fbi);
   	
   	// Prints out calculated distances.
      System.out.println("distance in miles between:");
      System.out.println("    stash/studio = " + stash.distanceFrom(abq));
      System.out.println("    stash/fbi    = " + stash.distanceFrom(fbi));
   
   }
}
