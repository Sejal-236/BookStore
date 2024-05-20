import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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

    public void addBooks(long isbn, String title, String author, String genre, double price, int quantity) {
        String sql = "INSERT into books (ISBN, title, author, genre, price, quantity) VALUES (?,?,?,?,?,?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            // Set values for the prepared statement parameters
            stmt.setLong(1, isbn);
            stmt.setString(2, title);
            stmt.setString(3, author);
            stmt.setString(4, genre);
            stmt.setDouble(5, price);
            stmt.setInt(6, quantity);

            // Execute the SQL statement
            int rowsInserted = stmt.executeUpdate();
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

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, ISBN);
            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Book deleted successfully.");
            } else {
                System.out.println("Failed to delete book.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<Books> displayAllBooks() {
        List<Books> bookList = new ArrayList<>();

        String sql = "SELECT * FROM books";
        try {
            Statement stmt = conn.createStatement();
            ResultSet resSet = stmt.executeQuery(sql);

            while (resSet.next()) {
                Books book = processResultSet(resSet);
                bookList.add(book);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookList;
    }

    public void updateBookByISBN(Long ISBN, int quantity) {
        String sql = "UPDATE books set quantity = ? where ISBN = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, quantity);
            stmt.setLong(2, ISBN);

            int RowsUpdated = stmt.executeUpdate();
            if (RowsUpdated > 0) {
                System.out.println("Book updated successfully.");
            } else {
                System.out.println("Failed to update book.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void findBookByISBN(Long ISBN) {
        String sql = "SELECT * FROM books where ISBN = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, ISBN);
            ResultSet resSet = stmt.executeQuery();
            if (!resSet.next()) {
                System.out.println("Book not found.");
            }
            while (resSet.next()) {
                Books book = processResultSet(resSet);
                System.out.println(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Books processResultSet(ResultSet resSet) throws SQLException {
        long iSBN = resSet.getLong("ISBN");
        String title = resSet.getString("title");
        String author = resSet.getString("author");
        String genre = resSet.getString("genre");
        double price = resSet.getDouble("price");
        int quantity = resSet.getInt("quantity");
        Books book = new Books(iSBN, title, author, genre, price, quantity);
        return book;
    }
}
