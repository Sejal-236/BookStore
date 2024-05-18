import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookInventoryManagerRepository {
     // Define database connection parameters
     String url = "jdbc:mysql://localhost:3306/Bookstore";
     String username = "root";
     String password = "Sejal@236";
     private Connection conn;
     // Explicit constructor
    public BookInventoryManagerRepository() {
        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace(); 
        }
    }

    public  void addbooks(long isbn, String title, String author, String genre, double price, int quantity) {
        String sql = "INSERT into books (ISBN, title, author, genre, price, quantity) VALUES (?,?,?,?,?,?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            // Set values for the prepared statement parameters
            pstmt.setLong(1, isbn);
            pstmt.setString(2, title);
            pstmt.setString(3, author);
            pstmt.setString(4, genre);
            pstmt.setDouble(5, price);
            pstmt.setInt(6, quantity);

            // Execute the SQL statement
            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Book added successfully.");
            } else {
                System.out.println("Failed to add book.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteBook(Long ISBN) {
        String sql = "delete from books where ISBN = ?";
        
        try (PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setLong(1, ISBN);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    
}
}
