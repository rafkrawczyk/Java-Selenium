package oop;

import java.util.*;

/**
 * Represents a book with ISBN, title, and author information.
 */
class Book {
    private String isbn;
    private String title;
    private String author;
    
    /**
     * Constructor to create a new Book.
     * 
     * @param isbn   The unique ISBN number
     * @param title  The book title
     * @param author The author's name
     */
    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }
    
    // Getters
    public String getIsbn() {
        return isbn;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getAuthor() {
        return author;
    }
    
    // Setters (optional, for updating book details)
    public void setTitle(String title) {
        this.title = title;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }
    
    @Override
    public String toString() {
        return String.format("ISBN: %s | Title: %s | Author: %s", isbn, title, author);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Book book = (Book) obj;
        return isbn.equals(book.isbn);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }
}

/**
 * Manages a collection of books using HashMap and LinkedHashMap.
 */
class Library {
    // HashMap for fast retrieval by ISBN
    private HashMap<String, Book> bookStore;
    
    // LinkedHashMap to maintain insertion order
    private LinkedHashMap<String, Book> bookInsertionOrder;
    
    /**
     * Constructor to initialize the library.
     */
    public Library() {
        bookStore = new HashMap<>();
        bookInsertionOrder = new LinkedHashMap<>();
    }
    
    /**
     * Adds a book to the library.
     * 
     * @param book The book to add
     */
    public void addBook(Book book) {
        if (book == null || book.getIsbn() == null) {
            System.out.println("Error: Cannot add null book or book with null ISBN");
            return;
        }
        
        bookStore.put(book.getIsbn(), book);
        bookInsertionOrder.put(book.getIsbn(), book);
        System.out.println("Added: " + book);
    }
    
    /**
     * Retrieves a book by its ISBN number.
     * 
     * @param isbn The ISBN to search for
     * @return The book if found, null otherwise
     */
    public Book getBookByISBN(String isbn) {
        Book book = bookStore.get(isbn);
        if (book == null) {
            System.out.println("Book with ISBN " + isbn + " not found.");
        }
        return book;
    }
    
    /**
     * Displays all books in the order they were added (insertion order).
     */
    public void displayBooksInInsertionOrder() {
        System.out.println("\n=== Books in Insertion Order ===");
        if (bookInsertionOrder.isEmpty()) {
            System.out.println("No books in the library.");
            return;
        }
        
        for (Book book : bookInsertionOrder.values()) {
            System.out.println(book);
        }
    }
    
    /**
     * Displays all books sorted alphabetically by their titles.
     */
    public void displayBooksSortedByTitle() {
        System.out.println("\n=== Books Sorted by Title ===");
        if (bookStore.isEmpty()) {
            System.out.println("No books in the library.");
            return;
        }
        
        // Convert HashMap values to a List
        List<Book> bookList = new ArrayList<>(bookStore.values());
        
        // Sort the list by title using a Comparator
        Collections.sort(bookList, new Comparator<Book>() {
            @Override
            public int compare(Book b1, Book b2) {
                return b1.getTitle().compareToIgnoreCase(b2.getTitle());
            }
        });
        
        // Alternative using lambda expression (Java 8+):
        // bookList.sort((b1, b2) -> b1.getTitle().compareToIgnoreCase(b2.getTitle()));
        
        // Display sorted books
        for (Book book : bookList) {
            System.out.println(book);
        }
    }
    
    /**
     * Returns the total number of books in the library.
     * 
     * @return The number of books
     */
    public int getTotalBooks() {
        return bookStore.size();
    }
    
    /**
     * Removes a book from the library by ISBN.
     * 
     * @param isbn The ISBN of the book to remove
     * @return true if the book was removed, false otherwise
     */
    public boolean removeBook(String isbn) {
        Book removed = bookStore.remove(isbn);
        bookInsertionOrder.remove(isbn);
        
        if (removed != null) {
            System.out.println("Removed: " + removed);
            return true;
        } else {
            System.out.println("Book with ISBN " + isbn + " not found.");
            return false;
        }
    }
}