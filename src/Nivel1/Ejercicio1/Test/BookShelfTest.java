package Nivel1.Ejercicio1.Test;

import Nivel1.Ejercicio1.Modules.Book;
import Nivel1.Ejercicio1.Modules.BookShelf;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

class BookShelfTest {
    private BookShelf bookShelf;

    @BeforeEach
    void setUp() {
        bookShelf = new BookShelf();
    }

    @Test
    void testBookShelfIsNotNullAfterCreation() {
        assertNotNull(bookShelf, "The bookshelf should not be null after creation.");
    }

    @Test
    void testBookShelfSizeAfterAddingBooks() {
        bookShelf.addBook(0, new Book("1984"));
        bookShelf.addBook(1, new Book("Brave New World"));
        assertEquals(2, bookShelf.bookShelfSize(), "The bookshelf size should match the number of books added.");
    }

    @Test
    void testBookPositionInList() {
        bookShelf.addBook(0, new Book("1984"));
        bookShelf.addBook(1, new Book("Brave New World"));
        assertEquals("Brave New World", bookShelf.getBookTitle(1), "The book at position 1 should be 'Brave New World'.");
    }

    @Test
    void testNoDuplicateTitles() {
        bookShelf.addBook(0, new Book("1984"));
        bookShelf.addBook(1, new Book("1984"));
        assertEquals(1, bookShelf.bookShelfSize(), "The bookshelf should not contain duplicate titles.");
    }

    @Test
    void testRetrieveTitleByPosition() {
        bookShelf.addBook(0, new Book("1984"));
        assertEquals("1984", bookShelf.getBookTitle(0), "The title at position 0 should be '1984'.");
    }

    @Test
    void testAddBookModifiesList() {
        bookShelf.addBook(0, new Book("1984"));
        assertEquals(1, bookShelf.bookShelfSize(), "Adding a book should increase the list size.");
    }

    @Test
    void testRemoveBookDecreasesSize() {
        bookShelf.addBook(0, new Book("1984"));
        bookShelf.addBook(1, new Book("Brave New World"));
        bookShelf.removeBookByTitle("1984");
        assertEquals(1, bookShelf.bookShelfSize(), "Removing a book should decrease the list size.");
    }

    @Test
    void testListRemainsAlphabeticallyOrdered() {
        bookShelf.addBook(0, new Book("Brave New World"));
        bookShelf.addBook(1, new Book("1984"));
        bookShelf.addBook(2, new Book("Fahrenheit 451"));
        ArrayList<String> titles = new ArrayList<>();
        for (int i = 0; i < bookShelf.bookShelfSize(); i++) {
            titles.add(bookShelf.getBookTitle(i));
        }
        ArrayList<String> sortedTitles = new ArrayList<>(titles);
        sortedTitles.sort(String::compareTo);
        assertEquals(sortedTitles, titles, "The list should remain alphabetically ordered.");
    }
}

