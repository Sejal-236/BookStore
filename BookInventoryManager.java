import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * BookInventoryManager
 */
public class BookInventoryManager {

    BookInventoryManagerRepository bookInventoryManagerRepository = new BookInventoryManagerRepository();

    public void addNewBook(Books book) {
        List<Books> bookList = new ArrayList<>();
        HashMap<Long, String> bookMap = new HashMap<>();
        bookList.add(book);
        bookMap.put(book.getISBN(), book.getTitle());
        bookInventoryManagerRepository.addbooks(book.getISBN(), book.getTitle(), book.getAuthor(), book.getGenre(),
                book.getPrice(), book.getQuantity());
    }

    public List<Books> displayBook() {
        bookInventoryManagerRepository.displayAllBooks();
    }

    public String findByISBN(Long ISBN) {
        
    }

    public String deleteByISBN(Long ISBN) {

        bookInventoryManagerRepository.deleteBook(ISBN);

        return "Book with ISBN: " + ISBN + " not found";
    }
}