package Nivel1.Ejercicio1.Modules;

import java.util.ArrayList;

public class BookShelfPosition {
    private ArrayList<Book> bookShelfPosition;

    public BookShelfPosition() {
        this.bookShelfPosition = new ArrayList<>();
    }

    public int bookShelfSize() {
        return bookShelfPosition.size();
    }

    public void addBook(int position, Book book) {
        if (!searchBook(book)) {
            bookShelfPosition.add(position, book);
            System.out.println("The book " + book.getName() + " was added.");
        } else {
            System.out.println("The book " + book.getName() + " is already in the list.");
        }
    }

    public void listBooks() {
        if (bookShelfPosition.isEmpty()) {
            System.out.println("The bookshelf is empty.");
            return;
        }
        for (Book book : bookShelfPosition) {
            System.out.println(book.getName());
        }
    }

    public String getBookTitle(int position) {
        if (position < 0 || position >= bookShelfPosition.size()) {
            return "Invalid position.";
        }
        return bookShelfPosition.get(position).getName();
    }

    public boolean searchBook(Book book) {
        return bookShelfPosition.contains(book);
    }

    public boolean removeBookByTitle(String title) {
        for (Book book : bookShelfPosition) {
            if (book.getName().equalsIgnoreCase(title)) {
                bookShelfPosition.remove(book);
                System.out.println("The book " + title + " was removed.");
                return true;
            }
        }
        System.out.println("The book " + title + " was not found.");
        return false;
    }
}
