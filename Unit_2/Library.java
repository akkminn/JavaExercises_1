import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Library {

    // Private instance variable of type Map
    private Map<String, ArrayList<Object>> bookMap;

    public Library() {
        bookMap = new HashMap<>();
    }

    /**
     * Create a method called addBook that takes
     * the book title, author, and quantity as parameters.
     * The method adds the book to the library system, considering 
     * the quantity of books provided. If the book already exists 
     * in the system, the quantity will be updated accordingly.
     */
    public void addBook (String title, String author, int quantity) {
        
        // Check whether the book is already in the bookMap
        if (bookMap.containsKey(title)) {
            // Retrieve the existing book details
            ArrayList<Object> bookDetails = bookMap.get(title);

            // Update the quantity
            int availableQuantity = (Integer) bookDetails.get(1);
            int newAvailableQuantity = availableQuantity + quantity;
            bookDetails.set(1, newAvailableQuantity);
            
        } else {
            // Create a new book entry
            ArrayList<Object> bookDetails = new ArrayList<>();
            bookDetails.add(author);
            bookDetails.add(quantity);
            bookMap.put(title, bookDetails);
        }

    }

    /**
     * Create a method called borrowBook that takes the book title and the number 
     * of books to be borrowed as parameters. The method will check if the requested 
     * number of books is available in the library system. If the books are available, 
     * the quantity will be updated accordingly. If the requested number of books 
     * is not available or the book does not exist, an appropriate error message 
     * should be displayed.
     */
    public void borrowBook(String title, int quantity) {

        // Check whether the book is already in the bookMap
        if (bookMap.containsKey(title)) {
            // Retrieve the existing book details
            ArrayList<Object> bookDetails = bookMap.get(title);

            // Check whether the book is available in the bookMap 
            int availableQuantity = (Integer) bookDetails.get(1);
            if (availableQuantity >= quantity) {

                // Update the quantity
                int oldQuantity = (Integer) bookDetails.get(1);
                int newQuantity = oldQuantity - quantity;
                bookDetails.set(1, newQuantity);

                // Check if the borrowed quantity element exists
                if (bookDetails.size() < 3) {
                    bookDetails.add(quantity); // Add borrowed quantity
                } else {
                    // Update the borrowed quantity
                    int borrowedQuantity = (Integer) bookDetails.get(2);
                    int newBorrowedQuantity = borrowedQuantity + quantity;
                    bookDetails.set(2, newBorrowedQuantity);
                }

                System.out.println("You have borrowed " + quantity + " copies of " + title);
            }  
            else { // Error meassage if the book doesn't enough
                System.err.println("Sorry! We don't have enough copies of " + title + " to borrow.");
            }
        }
        else { // Error meassage if the book doesn't exist
            System.err.println("Sorry! The book " + title + " does not exist in the library.");
        }
    }

    /**
     * Create a method called returnBook that takes the book title and 
     * the number of books to be returned as parameters.The method checks
     * if the books being returned belong to the library system. If 
     * they do, the quantity will be updated accordingly. If the books 
     * being returned do not exist in the system or the quantity to be 
     * returned is greater than the borrowed quantity, 
     * an appropriate error message should be displayed.
     */
    public void returnBook(String title, int quantity) {
        // Check whether the book is already in the bookMap
        if (bookMap.containsKey(title)) {
            // Retrieve the existing book details
            ArrayList<Object> bookDetails = bookMap.get(title);

            // Check whether the book is borrowed
            int borrowedQuantity = (Integer) bookDetails.get(2);

            if (borrowedQuantity >= quantity) {
                // Update the quantity
                int newBorrowedQuantity = borrowedQuantity - quantity;
                bookDetails.set(2, newBorrowedQuantity);

                // Increment the available quantity
                int availableQuantity = (Integer) bookDetails.get(1);
                int newAvailableQuantity = availableQuantity + quantity;
                bookDetails.set(1, newAvailableQuantity);

                System.out.println("You have returned " + quantity + " copies of " + title);
            } else { // Error message if the returned book amount exceed the borrowed book.
                System.err.println("Sorry! You cannot return more copies than borrowed.");
            }
        } else { // Error message if the book doen't exist in the library
            System.err.println("Sorry! The book " + title + " does not exist in the library.");
        }
    }

}