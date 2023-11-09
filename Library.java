import java.util.ArrayList;

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
    static ArrayList<Object> bookNames = new ArrayList<Object>();

    public Library() {
    }

    public Library(String address) {
        this(address,null);
    }

    public Library(String address, String fileName) {
        this.address = address;
        this.fileName = fileName;
    }

    public static void printOpeningHours() {
        System.out.println("Libraris are open daily from 9am to 5pm. ");
    }

    public void addBook(Book b){
        bookNames.add(b.getTitle());
    }

    public static void main(String[] args) {
//        // Create two libraries
        Library firstLibrary = new Library("10 Main St.");
//        Library secondLibrary = new Library("228 Liberty St.");
//        Library thirdLibrary = new Library("12 Broadway St.", "catalog.txt");
//
//        // Add four books to the first library
        firstLibrary.addBook(new Book("The Da Vinci Code"));
        firstLibrary.addBook(new Book("The Da Vinci Code")); // second copy
        firstLibrary.addBook(new Book("Le Petit Prince"));
        firstLibrary.addBook(new Book("A Tale of Two Cities"));
        firstLibrary.addBook(new Book("The Lord of the Rings"));
        firstLibrary.addBook(new Book("The Lord of the Rings")); // second copy
//
//        // Print opening hours and the addresses
//        System.out.println("Library hours:");
//        printOpeningHours();
//        System.out.println();

//        System.out.println("Library addresses:");
//        firstLibrary.printAddress();
//        secondLibrary.printAddress();
//        thirdLibrary.printAddress();
//        System.out.println();
//
//        // Try to borrow The Lords of the Rings from both libraries
//        System.out.println("Borrowing The Lord of the Rings:");
//        firstLibrary.borrowBook("The Lord of the Rings");
//        firstLibrary.borrowBook("The Lord of the Rings");
//        firstLibrary.borrowBook("The Lord of the Rings");
//        secondLibrary.borrowBook("The Lord of the Rings");
//        System.out.println();
//
//        // Print the titles of all available books from both libraries
//        System.out.println("Books available in the first library:");
//        firstLibrary.printAvailableBooks();
//        System.out.println();
//        System.out.println("Books available in the second library:");
//        secondLibrary.printAvailableBooks();
//        System.out.println("Books available in the third library:");
//        thirdLibrary.printAvailableBooks();
//        System.out.println();
//
//        // Return The Lords of the Rings to the first library
//        System.out.println("Returning The Lord of the Rings:");
//        firstLibrary.returnBook("The Lord of the Rings");
//        System.out.println();
//
//        // Print the titles of available from the first library
//        System.out.println("Books available in the first library:");
//        firstLibrary.printAvailableBooks();
    }
}