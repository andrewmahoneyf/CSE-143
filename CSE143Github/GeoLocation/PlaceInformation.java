// Andrew Mahoney-Fernandes
// Assignment 1 Part B
// 
// This class stores information about places on a map and than uses a GeoLocation object to 
// compute distances from London and Kane.

public class PlaceInformation {
   private String name;
   private String address;
   private String tag;
   private GeoLocation coordinates;

   // constucts a Place Information object with given name, address, tags, and coordinates.
   // Stores Lat & Long inside the PlaceInformation object using a GeoLocation object
   public PlaceInformation(String name, String address, String	tag, double	latitude, double longitude){
      this.name = name;
      this.address = address;
      this.tag = tag;
      coordinates = new GeoLocation(latitude, longitude);
   }
   
   // returns the name of this place
   public String getName(){
      return name;
   }
   
   // returns the adress of this place
   public String getAddress(){
      return address;
   }
   
   // returns the tags for this place
   public String getTag(){
      return tag;
   }
   
   // returns a string representation of this place with name and coordinates in parentheses
   public String toString(){
      return name + " (" + coordinates + ")";
      
   }
   
   // returns a reference to the GeoLocation object
   public GeoLocation getLocation() {
      return coordinates;
   }
   
   // returns distance in miles from this place to spots on map using GeoLocation object to compute
   public double distanceFrom(GeoLocation	spot) {
      return coordinates.distanceFrom(spot);
   }      
}