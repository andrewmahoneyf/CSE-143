// Andrew Mahoney-Fernandes
// 8/09/16
// CSE 143
// Assignment #3 Book Cataloging System
// Book Class
// Represents one book

public class Book {
   private double price;
   private String last, first, title, code;
   private int year;
   
   // Constructor for test book to check ISBN code validation before the rest of the inputs
   public Book(String code) {
      this.code = code;
   }
   
   // constructor for a book. takes in ISBN, Authors last and first name, book title, year and price
   public Book(String code, String last, String first, String title, int year, double price) {
         this.code = code;
         this.last = last;
         this.first = first;
         this.title = title;
         this.year = year;
         this.price = price;
   }
   
   // access last name   
   public String authorLast() {
      return last;
   }
   
   // access first name
   public String authorFirst() {
      return first;
   }
   
   // access book title
   public String title() {
      return title;
   }
   
   // access ISBN
   public String bookCode() {
      return code;
   }
   
   // access price
   public double price() {
      return price;
   }
   
   // access year
   public int year() {
      return year;
   }
   
   // over ride toString to make a easy to read catalog
   public String toString() {
      return "ISBN: " + code + "\t Author: " + last + ", " + first + "\t Title: " + title + "\t Year: " + year + "\t $" + price;
   }
}