import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * BookInventoryManager
 */
public class BookInventoryManager {

    List<Books> bookList = new ArrayList<>();
    HashMap<Long, String> bookMap = new HashMap<>();
    public void addNewBook (Books book){
        bookList.add(book);
        bookMap.put(book.getISBN(), book.getTitle());
    }

    public List<Books> displayBook (){
        return bookList;
    }

    public String findByISBN (Long ISBN){
        if(bookMap.containsKey(ISBN)){
            return bookMap.get(ISBN);
        }
        return "Book not found";
    }
    // public String findByISBN (Long ISBN){
    // //     for(Books book: bookList){
    // //       if(book.getISBN()==ISBN){
    // //         return book.getTitle();
    // //       }
    // //     }
    // //   return "Book not found";
    // }
}