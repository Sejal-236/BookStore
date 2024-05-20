import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * BookInventoryManager
 */
public class BookInventoryManager {

    BookInventoryManagerRepository bookInventoryManagerRepository = new BookInventoryManagerRepository();

    public void addNewBook(Books book) {
        bookInventoryManagerRepository.addBooks(book.getISBN(), book.getTitle(), book.getAuthor(), book.getGenre(),
                book.getPrice(), book.getQuantity());
    }

    public void displayBook() {
        List<Books> bookList = new ArrayList<>();
        bookList = bookInventoryManagerRepository.displayAllBooks();
        for (Books books : bookList) {
            System.out.println(books);
        }
    }

    public void findByISBN(Long ISBN) {
        bookInventoryManagerRepository.findBookByISBN(ISBN);
    }

    public void deleteByISBN(Long ISBN) {
        bookInventoryManagerRepository.deleteBook(ISBN);
    }

    public void updateBook(Long ISBN, int quantity) {
        bookInventoryManagerRepository.updateBookByISBN(ISBN, quantity);
    }
}