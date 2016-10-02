// Andrew Mahoney-Fernandes
// 8/09/16
// CSE 143
// Assignment #3 Book Cataloging System
// Book Catalog Client Class
// This class contains the main method

import java.io.*;
import java.util.*;

public class BookCatalogClient {
   public static void main(String[] args) throws FileNotFoundException {
   
   BookCatalog catalog = new BookCatalog(new File("booklist.txt"));
   Scanner input = new Scanner(System.in);
   intro();
   String goAgain = "yes";
   while (goAgain.startsWith("y")) {
      int selection = menu(input);
      System.out.println();
      accessCatalog(input, selection, catalog);
      System.out.println("Enter \"yes\" if you want to return to main menu");
      goAgain = input.next();
   }
   System.out.println("Do you want to save the above changes? yes/no ");
   if (input.next().startsWith("y")) {
      System.out.println("Changes saved.");
   } else {
      System.out.println("Changes not saved.");
   }
   
   }
   
   // gives intro to the user
   public static void intro() {
      System.out.println("Hello, welcome to my book catalog program!");
      System.out.println("This program will allow you to search the catalog for a");
      System.out.println("book with the authors first or last name or the book code.");
      System.out.println("If the book you are looking for isn't in our catalog you can add it.");
      System.out.println("Also feel free to remove a book at anytime if you want to check it out!");
      System.out.println();
   }
   
   // menu with 4 options, takes in scanner, returns int for users selection
   public static int menu(Scanner input) {
      System.out.println("Please select what you would like to do:");
      System.out.println("    1.) Find a book from the catalog");
      System.out.println("    2.) Add a book to the catalog");
      System.out.println("    3.) Remove a book from the catalog");
      System.out.println("    4.) View the current catalog");
      System.out.print("Selection: ");
      return input.nextInt();
   }
   
   // takes in scanner, the users selection from the menu and the catalog.
   // depending on users selection it will access the catalog and do what the user wants
   public static void accessCatalog(Scanner input, int selection, BookCatalog catalog){
      if (selection == 1) {
         System.out.println("Enter the authors first or last name or the book code: ");
         catalog.findBook(input.next());
         System.out.println();
      } else if (selection == 2) {
         System.out.println("What is the books ISBN? ");
         String code = input.next();
         Book test = new Book(code);
         if (!catalog.validIsbn(test))
            return;
         System.out.println("What is the authors last name? ");
         String last = input.next();
         System.out.println("What is the authors first name? ");
         String first = input.next();
         System.out.println("What is the book title? ");
         input.nextLine();
         String title = input.nextLine();
         System.out.println("What is the year of publication? ");
         int year = input.nextInt();
         System.out.println("What is the books price? ");
         double price = input.nextDouble();
         Book newBook = new Book(code, last, first, title, year, price);
         catalog.addBook(newBook);
         System.out.println();
      } else if (selection == 3) {
         System.out.println("Enter the title of the book you would like to remove");
         input.nextLine();
         catalog.deleteBook(input.nextLine());
         System.out.println();
      } else {
         System.out.println(catalog.toString());
      }
   }
}
  