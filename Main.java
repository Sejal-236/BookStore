import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Main {
    public static void main(String[] args) {

         // Define database connection parameters
         String url = "jdbc:mysql://localhost:3306/Bookstore";
         String username = "root";
         String password = "Sejal@236";

         
 
         // Establish connection
         try (Connection connection = DriverManager.getConnection(url, username, password)) {
             System.out.println("Connected to the database successfully");
         } catch (SQLException e) {
             System.out.println("Error connecting to the database: " + e.getMessage());
         }
        BookInventoryManager manager = new BookInventoryManager();
 
        // // Create
        Books book1 = new Books();
        book1.setISBN(12345678900L);
        book1.setTitle("Book Title 1");
        book1.setAuthor("Author 1");
        book1.setGenre("Genre 1");
        book1.setPrice(19.99);
        book1.setQuantity(10);
        manager.addNewBook(book1);
        // //manager.displayBook();
        Books book2 = new Books();
        book2.setISBN(124556789);
        book2.setTitle("Book Title 2");
        book2.setAuthor("Author 2");
        book2.setGenre("Genre 2");
        book2.setPrice(29.99);
        book2.setQuantity(20);
        // manager.addNewBook(book2);

        // List<Books> bookAttributes = manager.displayBook();
        // for (Books book : bookAttributes) {
        //     System.out.println(book);
        // }
        // System.out.println(manager.findByISBN(124556789L));
        System.out.println(manager.deleteByISBN(123456789L)); 
        // System.out.println(manager.findByISBN(124556789L));

    }
}
