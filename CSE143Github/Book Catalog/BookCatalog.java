// Andrew Mahoney-Fernandes
// 8/09/16
// CSE 143
// Assignment #3 Book Cataloging System
// Book Catalog Class
// Represents a collection of books

import java.util.*;
import java.io.*;

public class BookCatalog {
   private LinkedList<Book> list;
   
   // Contructor fot the catalog. takes in the catalog file and turns it into linked list
   public BookCatalog(File booklist) throws FileNotFoundException{
      this.list = new LinkedList<Book>();
      Scanner lineScan = new Scanner(booklist);
      while(lineScan.hasNextLine()) {
         String code = lineScan.next();
         String last = lineScan.next();
         String first = lineScan.next();
         String title = lineScan.next();
         while (!lineScan.hasNextInt())
            title += " " + lineScan.next();
         int year = lineScan.nextInt();
         double price = lineScan.nextDouble();
         lineScan.nextLine();
         Book next = new Book(code, last, first, title, year, price);
         list.add(next);
      }
   }
   
   // method for adding a book to the catalog, checks if book is in catalog and if valid inputs were given
   public void addBook(Book newBook) {
      for (Book book : list) {
         if (book.bookCode().equals(newBook.bookCode())) {
            System.out.println("That book is already in the catalog!");
            return;
         }
      }
      if (Character.isDigit(newBook.authorLast().charAt(0)) || Character.isDigit(newBook.authorFirst().charAt(0)) || newBook.title().length() < 1 || newBook.price() <= 0 || newBook.year() > 2013) { 
         System.out.println("Invalid book.");
         return;
      }
      if (validIsbn(newBook)) {
         System.out.println("Book added!");
         list.add(newBook);
      }
   }
   
   // method tests if the ISBN code is valid
   public boolean validIsbn(Book test) {
      String isbn = test.bookCode();
      isbn = isbn.replace("-", "");
      if (isbn.length() != 10) {
         System.out.println("Incorrect amount of digits in ISBN code.");
         return false;
      }
      int sum = 0;
      for(int i = 0; i < isbn.length()-1; i++) {
         if (Character.isDigit(isbn.charAt(i))){
            int digit = Integer.parseInt(isbn.substring(i, i+1));
            sum += digit * (i+1);
         } else {
            System.out.println("Invalid digit in ISBN code.");
            return false;
         }
      }
      sum = sum % 11;
      String temp = isbn.substring(isbn.length()-1);
      if (temp.equals("X"))
         temp = temp.replace("X", "10");
      int checkSum = Integer.parseInt(temp);
      if(sum != checkSum){
         System.out.println("Wrong check sum in ISBN code.");
         return false;   
      }
      return true;
   }
   
   // Method to search for a book in the cataog with the books title   
   public void findBook(String input) {
      for (Book book : list) {
         if (book.authorLast().equals(input) || book.authorFirst().equals(input) || book.bookCode().equals(input)) {
            System.out.println(book);
            return;
         }
      }
      System.out.println("The book you are looking for isn't in our catalog.");
   }
   
   // Method to delete a book from the catalog
   public void deleteBook(String title) {
      for (Book book : list) {
         if (book.title().equals(title)) {
            System.out.println("Book removed!");
            list.remove(book);
            return;
         }
      }
      System.out.println("Book is already not in the catalog.");
   }
   
   // toString method to print out the entire catalog
   public String toString() {
      Iterator i = list.iterator();
      String catalog = "";
      while (i.hasNext()) 
         catalog += i.next() + "\n";
      return catalog;
   }
   
}