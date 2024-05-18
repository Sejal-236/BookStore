import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


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
        manager.displayBook();

    }
}
