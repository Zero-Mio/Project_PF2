import java.util.ArrayList;

public class Book {
    /*****
    TODO
     Implement the following methods and test:
     -Book
     -borrowed
     -returned
     -isBorrowed
     -getTitle
     -rented
     *****/

    String title;
    boolean borrowed;
    static ArrayList<String> books = new ArrayList<String>();
    static ArrayList<Integer> numOfBooks = new ArrayList<Integer>();

    // Creates a new Book

    
    public Book(String bookTitle) {
        // Implement this method
        //add the created books to a String array list
        //add another array list that keeps track of the amount of books in the first array; the index for both arrays should be the same
        books.add(bookTitle);
        numOfBooks.add(1);
    }

    // Marks the book as rented
    public void borrowed() {
        // Implement this method
        //add for loop that will increment through the first array list that will compare the titles of the books until it finds it
        //add and else statement that will be outputed if the book is not in this library
    }

    // Marks the book as not rented
    public void returned() {
        // Implement this method
    }

    // Returns true if the book is rented, false otherwise
    public boolean isBorrowed() {
        // Implement this method
    }

    // Returns the title of the book
    public String getTitle() {
        // Implement this method

    }

    public static void main(String[] arguments) {
        // Small test of the Book class
        Book example = new Book("The Da Vinci Code");
        System.out.println("Title (should be The Da Vinci Code): " + example.getTitle());
        System.out.println("Borrowed? (should be false): " + example.isBorrowed());
        example.borrowed();
        System.out.println("Borrowed? (should be true): " + example.isBorrowed());
        example.returned();
        System.out.println("Borrowed? (should be false): " + example.isBorrowed());
    }
}