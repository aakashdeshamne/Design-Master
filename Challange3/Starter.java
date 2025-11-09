package Challange3;

import java.util.List;
import java.util.Scanner;
import Challange3.Entity.Book;
import Challange3.Entity.Member;
import Challange3.Entity.Loan;

public class Starter {
    private static Scanner scanner = new Scanner(System.in);
    private static Library library = new Library();

    public static void main(String[] args) {
        System.out.println("Welcome to Library Management System");
        System.out.println("===================================");

        initializeSampleData();

        boolean running = true;
        while (running) {
            displayMainMenu();
            int choice = getIntInput("Enter your choice: ");

            try {
                switch (choice) {
                    case 1:
                        bookManagementMenu();
                        break;
                    case 2:
                        memberManagementMenu();
                        break;
                    case 3:
                        loanManagementMenu();
                        break;
                    case 4:
                        searchBooksMenu();
                        break;
                    case 5:
                        viewOverdueLoans();
                        break;
                    case 0:
                        System.out.println("Thank you for using the Library Management System!");
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid choice! Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

            if (running) {
                System.out.println("\nPress Enter to continue...");
                scanner.nextLine();
            }
        }

        scanner.close();
    }

    private static void displayMainMenu() {
        System.out.println("\n=== MAIN MENU ===");
        System.out.println("1. Book Management");
        System.out.println("2. Member Management");
        System.out.println("3. Loan Management");
        System.out.println("4. Search Books");
        System.out.println("5. View Overdue Loans");
        System.out.println("0. Exit");
    }

    private static void bookManagementMenu() {
        while (true) {
            System.out.println("\n=== BOOK MANAGEMENT ===");
            System.out.println("1. Add New Book");
            System.out.println("2. Remove Book");
            System.out.println("3. List All Books");
            System.out.println("0. Back to Main Menu");

            int choice = getIntInput("Enter your choice: ");
            switch (choice) {
                case 1:
                    addNewBook();
                    break;
                case 2:
                    removeBook();
                    break;
                case 3:
                    listAllBooks();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private static void memberManagementMenu() {
        while (true) {
            System.out.println("\n=== MEMBER MANAGEMENT ===");
            System.out.println("1. Register New Member");
            System.out.println("2. Unregister Member");
            System.out.println("3. List All Members");
            System.out.println("0. Back to Main Menu");

            int choice = getIntInput("Enter your choice: ");
            switch (choice) {
                case 1:
                    registerNewMember();
                    break;
                case 2:
                    unregisterMember();
                    break;
                case 3:
                    listAllMembers();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private static void loanManagementMenu() {
        while (true) {
            System.out.println("\n=== LOAN MANAGEMENT ===");
            System.out.println("1. Borrow Book");
            System.out.println("2. Return Book");
            System.out.println("3. View Active Loans");
            System.out.println("0. Back to Main Menu");

            int choice = getIntInput("Enter your choice: ");
            try {
                switch (choice) {
                    case 1:
                        borrowBook();
                        break;
                    case 2:
                        returnBook();
                        break;
                    case 3:
                        viewActiveLoans();
                        break;
                    case 0:
                        return;
                    default:
                        System.out.println("Invalid choice!");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static void searchBooksMenu() {
        while (true) {
            System.out.println("\n=== SEARCH BOOKS ===");
            System.out.println("1. Search by Title");
            System.out.println("2. Search by Author");
            System.out.println("3. Search by Subject");
            System.out.println("0. Back to Main Menu");

            int choice = getIntInput("Enter your choice: ");
            switch (choice) {
                case 1:
                    searchByTitle();
                    break;
                case 2:
                    searchByAuthor();
                    break;
                case 3:
                    searchBySubject();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // Book Management
    private static void addNewBook() {
        System.out.println("\nAdd New Book");
        int id = getIntInput("Enter Book ID: ");
        System.out.print("Enter Book Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Author Name: ");
        String author = scanner.nextLine();
        System.out.print("Enter Subject: ");
        String subject = scanner.nextLine();

        Book book = new Book(id, title, author, subject);
        library.addBook(book);
        System.out.println("Book added successfully!");
    }

    private static void removeBook() {
        int id = getIntInput("Enter Book ID to remove: ");
        library.removeBook(id);
        System.out.println("Book removed successfully!");
    }

    private static void listAllBooks() {
        System.out.println("\nAll Books in Library");
        System.out.printf("%-5s %-25s %-20s %-15s %-10s%n", "ID", "Title", "Author", "Subject", "Status");
        System.out.println("-----------------------------------------------------------------------");
        displayBooksForAllSubjects();
    }

    private static void displayBooksForAllSubjects() {
        String[] commonSubjects = {"Fiction", "Science", "History", "Technology", "Mathematics", "Literature", "Philosophy", "Art"};
        for (String subject : commonSubjects) {
            List<Book> books = library.getAvilableBooksBySubject(subject);
            for (Book book : books) {
                System.out.printf("%-5d %-25s %-20s %-15s %-10s%n",
                    book.getId(),
                    truncate(book.getTitle(), 25),
                    truncate(book.getAuthor(), 20),
                    truncate(book.getSubject(), 15),
                    book.isAvailable() ? "Available" : "Borrowed");
            }
        }
    }

    // Member Management
    private static void registerNewMember() {
        System.out.println("\nRegister New Member");
        int memberId = getIntInput("Enter Member ID: ");
        System.out.print("Enter Member Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        Member member = new Member(memberId, name, email, 0, 5);
        library.registerMember(member);
        System.out.println("Member registered successfully!");
    }

    private static void unregisterMember() {
        int memberId = getIntInput("Enter Member ID to unregister: ");
        library.unregisterMember(memberId);
        System.out.println("Member unregistered successfully!");
    }

    private static void listAllMembers() {
        System.out.println("\nAll Registered Members");
        System.out.printf("%-8s %-20s %-25s %-12s%n", "ID", "Name", "Email", "Books Out");
        System.out.println("------------------------------------------------------------");
        System.out.println("Member list feature not implemented (need getAllMembers).");
    }

    // Loan Management
    private static void borrowBook() throws Exception {
        int memberId = getIntInput("Enter Member ID: ");
        int bookId = getIntInput("Enter Book ID: ");
        library.borrowBook(memberId, bookId);
    }

    private static void returnBook() throws Exception {
        int bookId = getIntInput("Enter Book ID to return: ");
        library.returnBook(bookId);
    }

    private static void viewActiveLoans() {
        System.out.println("\nActive Loans");
        System.out.printf("%-10s %-10s %-10s %-12s %-12s %-10s%n",
            "Loan ID", "Book ID", "Member ID", "Loan Date", "Due Date", "Status");
        System.out.println("------------------------------------------------------------");
        System.out.println("Feature not implemented (need getAllLoans).");
    }

    // Search
    private static void searchByTitle() {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        List<Book> books = library.getAvilableBooksByTitle(title);
        displaySearchResults(books, "title: " + title);
    }

    private static void searchByAuthor() {
        System.out.print("Enter author name: ");
        String author = scanner.nextLine();
        List<Book> books = library.getAvilableBooksByAuthor(author);
        displaySearchResults(books, "author: " + author);
    }

    private static void searchBySubject() {
        System.out.print("Enter subject: ");
        String subject = scanner.nextLine();
        List<Book> books = library.getAvilableBooksBySubject(subject);
        displaySearchResults(books, "subject: " + subject);
    }

    private static void displaySearchResults(List<Book> books, String criteria) {
        System.out.println("\nSearch Results for " + criteria);
        if (books.isEmpty()) {
            System.out.println("No available books found.");
            return;
        }

        System.out.printf("%-5s %-25s %-20s %-15s%n", "ID", "Title", "Author", "Subject");
        for (Book book : books) {
            System.out.printf("%-5d %-25s %-20s %-15s%n",
                book.getId(),
                truncate(book.getTitle(), 25),
                truncate(book.getAuthor(), 20),
                truncate(book.getSubject(), 15));
        }
    }

    private static void viewOverdueLoans() {
        List<Loan> overdueLoans = library.getOverdueLoans();
        if (overdueLoans.isEmpty()) {
            System.out.println("No overdue loans.");
            return;
        }

        System.out.printf("%-10s %-10s %-10s %-12s %-12s%n",
            "Loan ID", "Book ID", "Member ID", "Loan Date", "Due Date");
        for (Loan loan : overdueLoans) {
            System.out.printf("%-10d %-10d %-10d %-12s %-12s%n",
                loan.getLoanId(),
                loan.getBookId(),
                loan.getMemberId(),
                loan.getLoanDate(),
                loan.getDueDate());
        }
    }

    // Initialize sample data
    private static void initializeSampleData() {
        library.addBook(new Book(1, "The Great Gatsby", "F. Scott Fitzgerald", "Literature"));
        library.addBook(new Book(2, "To Kill a Mockingbird", "Harper Lee", "Literature"));
        library.addBook(new Book(3, "1984", "George Orwell", "Fiction"));
        library.addBook(new Book(4, "Pride and Prejudice", "Jane Austen", "Fiction"));
        library.addBook(new Book(5, "The Catcher in the Rye", "J.D. Salinger", "Fiction"));
        library.addBook(new Book(6, "Introduction to Algorithms", "Thomas Cormen", "Technology"));
        library.addBook(new Book(7, "Clean Code", "Robert Martin", "Technology"));
        library.addBook(new Book(8, "A Brief History of Time", "Stephen Hawking", "Science"));

        library.registerMember(new Member(101, "John Doe", "john@email.com", 0, 5));
        library.registerMember(new Member(102, "Jane Smith", "jane@email.com", 0, 5));
        library.registerMember(new Member(103, "Bob Johnson", "bob@email.com", 0, 5));

        System.out.println("Sample data loaded successfully!");
    }

    // Utility
    private static int getIntInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.print("Please enter a valid number: ");
            scanner.next();
        }
        int input = scanner.nextInt();
        scanner.nextLine(); // consume newline
        return input;
    }

    private static String truncate(String str, int length) {
        return str.length() <= length ? str : str.substring(0, length - 3) + "...";
    }
}
