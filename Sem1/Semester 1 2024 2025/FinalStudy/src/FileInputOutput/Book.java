package FileInputOutput;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Book {
    String title;
    String author;
    String ISBN;
    boolean isAvailable;

    public Book(String title, String author, String ISBN) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.isAvailable = true; // By default, a book is available when added
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public boolean isIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    @Override
    public String toString() {
        return String.format("Title: %s | Author: %s | ISBN: %s | Available: %s",
                title, author, ISBN, isAvailable);
    }
}

class Library {
    List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(String title, String author, String ISBN) {
        Book newBook = new Book(title, author, ISBN);
        books.add(newBook);
    }

    public void removeBook(String ISBN) {
        books.removeIf(book -> book.getISBN().equals(ISBN));
    }

    public void searchTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Book found: " + book);
                return;
            }
        }
        System.out.println("Book not found with title: " + title);
    }

    public void searchAuthor(String author) {
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                System.out.println("Book found: " + book);
                return;
            }
        }
        System.out.println("No books found by author: " + author);
    }

    public void checkOutBook(String ISBN) {
        for (Book book : books) {
            if (book.getISBN().equals(ISBN)) {
                if (book.isIsAvailable()) {
                    book.setIsAvailable(false);
                    System.out.println("Book checked out: " + book.getTitle());
                } else {
                    System.out.println("Book is already checked out: " + book.getTitle());
                }
                return;
            }
        }
        System.out.println("Book not found with ISBN: " + ISBN);
    }

    public void returnBook(String ISBN) {
        for (Book book : books) {
            if (book.getISBN().equals(ISBN)) {
                if (!book.isIsAvailable()) {
                    book.setIsAvailable(true);
                    System.out.println("Book returned: " + book.getTitle());
                } else {
                    System.out.println("Book is already available: " + book.getTitle());
                }
                return;
            }
        }
        System.out.println("Book not found with ISBN: " + ISBN);
    }

    public void saveToFile(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileOutputStream(filename))) {
            for (Book book : books) {
                writer.println(book.getTitle() + "|" + book.getAuthor() + "|" + book.getISBN() + "|" + book.isIsAvailable());
            }
            System.out.println("Library saved to file: " + filename);
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found - " + e.getMessage());
        }
    }

    public void loadFromFile(String filename) {
        try (Scanner scanner = new Scanner(new FileInputStream(filename))) {
            while (scanner.hasNextLine()) {
                String[] data = scanner.nextLine().split("\\|");
                if (data.length == 4) {
                    Book book = new Book(data[0], data[1], data[2]);
                    book.setIsAvailable(Boolean.parseBoolean(data[3]));
                    books.add(book);
                }
            }
            System.out.println("Library loaded from file: " + filename);
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found - " + e.getMessage());
        }
    }
}
 class Tester {
    public static void main(String[] args) {
        Library library = new Library();

        // Load library data from file (if it exists)
        library.loadFromFile("library.txt");

        // Add some books
        library.addBook("1984", "George Orwell", "123456");
        library.addBook("The Great Gatsby", "F. Scott Fitzgerald", "654321");

        // Demonstrate functionality
        library.searchTitle("1984");
        library.searchAuthor("F. Scott Fitzgerald");
        library.checkOutBook("123456");
        library.returnBook("123456");

        // Save library data to file
        library.saveToFile("library.txt");
    }
}