package Nivel1.Ejercicio1.Modules;

import java.util.ArrayList;
import java.util.Collections;

public class BookShelfAlphabetical {
    private ArrayList<Book> bookSelfAlphabetical;
    public  BookShelfAlphabetical() {
        this.bookSelfAlphabetical = new ArrayList<>();
    }

    public void addBookA( Book book) {
        if (!searchBook(book)) {
            bookSelfAlphabetical.add(book);
            Collections.sort(bookSelfAlphabetical);
            System.out.println("The book " + book.getName() + " was added.");
        } else {
            System.out.println("The book " + book.getName() + " is already in the list.");
        }
    }
    public boolean removeBookAlphabetical(String title) {
        for (Book book : bookSelfAlphabetical) {
            if (book.getName().equalsIgnoreCase(title)) {
                bookSelfAlphabetical.remove(book);
                Collections.sort(bookSelfAlphabetical);
                System.out.println("The book " + title + " was removed.");
                return true;
            }
        }
        System.out.println("The book " + title + " was not found.");
        return false;
    }
    public boolean searchBook(Book book) {
        return bookSelfAlphabetical.contains(book);
    }
}
