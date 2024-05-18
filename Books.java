/**
 * Books
 */
public class Books {

    private long ISBN;
    private String title;
    private String author;
    private String genre;
    private double price;
    private int quantity;

    

    public Books(long ISBN, String title, String author, String genre, double price, int quantity) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.price = price;
        this.quantity = quantity;
    }

    public void setISBN(long ISBN) {
        this.ISBN = ISBN;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public long getISBN() {
        return ISBN;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Books [ISBN=" + ISBN + ", title=" + title + ", author=" + author + ", genre=" + genre + ", price="
                + price + ", quantity=" + quantity + "]";
    }
}
