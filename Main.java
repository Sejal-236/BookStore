import java.util.List;

public class Main {
    public static void main(String[] args) {
        BookInventoryManager manager = new BookInventoryManager();
 
        // Create
        Books book1 = new Books();
        book1.setISBN(123456789);
        book1.setTitle("Book Title 1");
        book1.setAuthor("Author 1");
        book1.setGenre("Genre 1");
        book1.setPrice(19.99);
        book1.setQuantity(10);
        manager.addNewBook(book1);
        //manager.displayBook();

        Books book2 = new Books();
        book2.setISBN(124556789);
        book2.setTitle("Book Title 2");
        book2.setAuthor("Author 2");
        book2.setGenre("Genre 2");
        book2.setPrice(29.99);
        book2.setQuantity(20);
        manager.addNewBook(book2);

        List<Books> bookAttributes = manager.displayBook();
        for (Books book : bookAttributes) {
            System.out.println(book);
        }
        System.out.println(manager.findByISBN(124556789L));
    }
}
