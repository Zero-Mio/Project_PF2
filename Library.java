import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;

public class Library {
    // Add the missing implementation to this class
    /*
    TODO
     Implemet the following methods and test:
     -two constructors one with two args and one with file name
     - addbook method that calls upon the book class
     - println saying library hours from 9-5
     -call constructor for library address
     -borrowedBook method will call borrowed method from book.java
     -print title of available books (Through an array)
     - call returned method in book.java
     - see how many books are available
     */

    private String address, fileName;
    private ArrayList<Book> bookNames = new ArrayList<Book>();
    private ArrayList<String[]> bookName = new ArrayList<String[]>();


    public Library() {

    }

    public Library(String address) {
        this.address = address;
    }


    public static void printOpeningHours() {
        System.out.println("Libraries are open daily from 9am to 5pm. ");
    }

    public void printAddress() {
        System.out.println(address);
    }

    public void addBook(Book b){
        bookNames.add(b);
    }

    public Library(String libraryAddress, String catalogFile) {
        this(libraryAddress);
        loadCatalogFromFile(catalogFile);
    }
    // Load books from a CSV catalog file without external libraries

    private void loadCatalogFromFile(String catalogFile) {
        if (catalogFile == null || catalogFile.isEmpty()) {
            System.out.println("Catalog file not provided. Skipping catalog loading.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(catalogFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                if (parts.length >= 2) {
                    String bookTitle = parts[0].trim();
                    int numCopies = Integer.parseInt(parts[1].trim());

                    for (int i = 0; i < numCopies; i++) {
                        addBook(new Book(bookTitle));
                    }
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error loading catalog from file: " + e.getMessage());
        }
    }

    public void borrowBook(String bookTitle) {
        int availableCopies = countAvaliableBooks(bookTitle);
        if (availableCopies > 0) {
            for (Book book : bookNames) {
                if (book.getTitle().equals(bookTitle) && !book.isBorrowed()) {
                    book.borrowed();
                    System.out.println("You successfully borrowed " + bookTitle +
                            ". Remaining number of copies: " + (countAvaliableBooks(bookTitle)));
                    return;
                  }
                }
            }
        if (availableCopies == 0){
                System.out.println("Sorry, this book is already borrowed. ");
            }
            else {
                System.out.println("Sorry, this book is not in our catalog. ");
                }
            }


    private int countAvaliableBooks(String bookTitle){
        int count = 0;
        for(Book book : bookNames){
            if(book.getTitle().equals(bookTitle) && !book.isBorrowed()){
                count++;
            }
        }
        return count;

    }

    public void printAvailableBooks(){
        //using an array list as recommended
        List<String> usedNames = new ArrayList<>();

        for (Book book : bookNames){
            if(!book.isBorrowed() && !usedNames.contains(book.getTitle())){
                usedNames.add(book.getTitle());
                System.out.println(book.getTitle() + ", remaining number of copies: " + countAvaliableBooks(book.getTitle()));
            }
        }
    }

    public void returnBook(String bookTitle) {
        for (Book book : bookNames) {
            if (book.getTitle().equals(bookTitle) && book.isBorrowed()) {
                book.returned();
                System.out.println("You successfully returned " + bookTitle +
                        ", remaining number of copies: " + countAvaliableBooks(bookTitle));
                return;
            }
        }
    }


    public static void main(String[] args) throws IOException {
        // Create two libraries
        Library firstLibrary = new Library("10 Main St.");
        Library secondLibrary = new Library("228 Liberty St.");
        Library thirdLibrary = new Library("12 Broadway St.", "catalog.csv");

        // Add four books to the first library
        firstLibrary.addBook(new Book("The Da Vinci Code"));
        firstLibrary.addBook(new Book("The Da Vinci Code")); // second copy
        firstLibrary.addBook(new Book("Le Petit Prince"));
        firstLibrary.addBook(new Book("A Tale of Two Cities"));
        firstLibrary.addBook(new Book("The Lord of the Rings"));
        firstLibrary.addBook(new Book("The Lord of the Rings")); // second copy

        // Print opening hours and the addresses
        System.out.println("Library hours:");
        printOpeningHours();
        System.out.println();

        System.out.println("Library addresses:");
        firstLibrary.printAddress();
        secondLibrary.printAddress();
        thirdLibrary.printAddress();
        System.out.println();

        
        // Try to borrow The Lords of the Rings from both libraries
        System.out.println("Borrowing The Lord of the Rings:");
        firstLibrary.borrowBook("The Lord of the Rings");
        firstLibrary.borrowBook("The Lord of the Rings");
        firstLibrary.borrowBook("The Lord of the Rings");
        secondLibrary.borrowBook("The Lord of the Rings");
        System.out.println();

//        // Print the titles of all available books from both libraries
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
        System.out.println();
        System.out.println("Books available in the second library:");
        secondLibrary.printAvailableBooks();
        System.out.println("Books available in the third library:");
        thirdLibrary.printAvailableBooks();
        System.out.println();
//
//        // Return The Lords of the Rings to the first library
        System.out.println("Returning The Lord of the Rings:");
        firstLibrary.returnBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of available from the first library
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
    }
}