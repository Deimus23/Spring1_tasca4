package Nivel1.Ejercicio1.Test;

import Nivel1.Ejercicio1.Modules.Book;
import Nivel1.Ejercicio1.Modules.BookShelfAlphabetical;
import Nivel1.Ejercicio1.Modules.BookShelfPosition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookShelfTest {
    private BookShelfPosition bookShelf;
    private BookShelfAlphabetical bookShelfAlphabetical;

    @BeforeEach
    void setUp() {
        bookShelf = new BookShelfPosition();
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

    void testListRemainsAlphabeticallyOrdered() {

        bookShelfAlphabetical.addBookA(new Book("Brave New World"));
        bookShelfAlphabetical.addBookA(new Book("1984"));
        bookShelfAlphabetical.addBookA(new Book("Fahrenheit 451"));

        List<String> titles = new ArrayList<>();
        for (Book book : bookShelfAlphabetical) {
            titles.add(book.getName());
        }
        List<String> sortedTitles = new ArrayList<>(titles);
        sortedTitles.sort(String::compareTo);
        assertEquals(sortedTitles, titles, "The list should remain alphabetically ordered.");
    }
}


