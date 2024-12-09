package Nivel1.Ejercicio1.Modules;

import java.util.ArrayList;
import java.util.Collection;

public class BookShelf {
    private ArrayList<Book> bookShelf;

    public BookShelf() {
        this.bookShelf = new ArrayList<>();
    }

    public int bookShelfSize() {
        return bookShelf.size();
    }

    public void addBook(int position, Book book) {
        if (!searchBook(book)) {
            bookShelf.add(position, book);
            System.out.println("The book " + book.getName() + " was added.");
        } else {
            System.out.println("The book " + book.getName() + " is already in the list.");
        }
    }

    public void listBooks() {
        if (bookShelf.isEmpty()) {
            System.out.println("The bookshelf is empty.");
            return;
        }
        for (Book book : bookShelf) {
            System.out.println(book.getName());
        }
    }

    public String getBookTitle(int position) {
        if (position < 0 || position >= bookShelf.size()) {
            return "Invalid position.";
        }
        return bookShelf.get(position).getName();
    }

    public boolean searchBook(Book book) {
        return bookShelf.contains(book);
    }

    public boolean removeBookByTitle(String title) {
        for (Book book : bookShelf) {
            if (book.getName().equalsIgnoreCase(title)) {
                bookShelf.remove(book);
                System.out.println("The book " + title + " was removed.");
                return true;
            }
        }
        System.out.println("The book " + title + " was not found.");
        return false;
    }
}
