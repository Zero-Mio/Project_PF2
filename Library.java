import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;

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
    static ArrayList<Book> bookNames = new ArrayList<Book>();
    static ArrayList<String[]> bookName = new ArrayList<String[]>();


    public Library() {

    }

    public Library(String address) {
        this.address = address;
    }

    public Library(String address, String fileName) {
        this.address = address;
        this.fileName = fileName;
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
    public void readData() throws IOException {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line = "";
            while ((line = br.readLine()) != null) {

                bookName.add(line.split(","));

            }
        }
        catch (FileNotFoundException e) {

        }
    }

    public void test () throws IOException {
        readData();
        for(int i = 0; i < bookName.size(); i++){
            System.out.println(bookName.get(i));
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


        thirdLibrary.test();
        // Try to borrow The Lords of the Rings from both libraries
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