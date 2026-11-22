
import java.util.ArrayList;
import java.util.Scanner;

// Abstract class
abstract class LibraryItem {
    private int id;
    private String title;

    LibraryItem(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    abstract void displayDetails();
}

// Interface
interface LibraryOperations {
    void addBook(LibraryItem book);
    void displayBooks();
    void borrowBook(int id);
    void returnBook(int id);
}

// Inheritance
class Book extends LibraryItem {

    private boolean available = true;

    Book(int id, String title) {
        super(id, title);
    }

    // Polymorphism (Method Overriding)
    @Override
    void displayDetails() {
        System.out.println("Book ID: " + getId());
        System.out.println("Book Name: " + getTitle());
        System.out.println("Status: " +
            (available ? "Available" : "Borrowed"));
        System.out.println("--------------------");
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}

// Library class implementing interface
class Library implements LibraryOperations {

    ArrayList<LibraryItem> books = new ArrayList<>();

    public void addBook(LibraryItem book) {
        books.add(book);
        System.out.println("Book added successfully!");
    }

    public void displayBooks() {

        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        for (LibraryItem book : books) {
            book.displayDetails();
        }
    }

    public void borrowBook(int id) {

        for (LibraryItem item : books) {

            if (item.getId() == id) {

                Book book = (Book) item;

                if (book.isAvailable()) {
                    book.setAvailable(false);
                    System.out.println("Book borrowed successfully!");
                } else {
                    System.out.println("Book is already borrowed.");
                }

                return;
            }
        }

        System.out.println("Book not found!");
    }

    public void returnBook(int id) {

        for (LibraryItem item : books) {

            if (item.getId() == id) {

                Book book = (Book) item;

                if (!book.isAvailable()) {
                    book.setAvailable(true);
                    System.out.println("Book returned successfully!");
                } else {
                    System.out.println("Book is already available.");
                }

                return;
            }
        }

        System.out.println("Book not found!");
    }
}

// Main class
public class LibraryManagementSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Library library = new Library();

        int choice;

        do {
            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Book");
            System.out.println("2. Display Books");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Book ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Book Name: ");
                    String name = sc.nextLine();

                    library.addBook(new Book(id, name));
                    break;

                case 2:
                    library.displayBooks();
                    break;

                case 3:
                    System.out.print("Enter Book ID: ");
                    library.borrowBook(sc.nextInt());
                    break;

                case 4:
                    System.out.print("Enter Book ID: ");
                    library.returnBook(sc.nextInt());
                    break;

                case 5:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}
