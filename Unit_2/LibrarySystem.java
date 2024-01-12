import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class LibrarySystem {
    
    public static void main (String[] args) {
        
        Library library = new Library();

        System.out.println("Test 1 addBook");
        library.addBook("To Kill a Mockingbird", "Harper Lee", 5);

        System.out.println("Test 2 addBook");
        library.addBook("1984", "George Orwell", 5);

        System.out.println("Test 3 borrowBook(Error)");
        library.borrowBook("The Great Gatsby", 2);

        System.out.println("Test 4 borrowBook");
        library.borrowBook("To Kill a Mockingbird", 4);

        System.out.println("Test 5 borrowBook(Error)");
        library.borrowBook("1984", 10);

        System.out.println("Test 6 returnBook(Error)");
        library.returnBook("The Great Gatsby", 3);

        System.out.println("Test 7 returnBook");
        library.returnBook("To Kill a Mockingbird", 4);

        System.out.println("Test 8 returnBook(Error)");
        library.returnBook("To Kill a Mockingbird", 2);
    } 

}