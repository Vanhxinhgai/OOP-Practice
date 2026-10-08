package W2.B2_5_EqualsMethod;

import java.util.Objects;

public class Book {
    private String title;
    private String author;
    private double price;

    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public String getTitle()  { return title; }
    public String getAuthor() { return author; }
    public double getPrice()  { return price; }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Book other = (Book) obj;
        return Double.compare(price, other.price) == 0
                && Objects.equals(title, other.title)
                && Objects.equals(author, other.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, price);
    }

    @Override
    public String toString() {
        return "Book[title=" + title + ", author=" + author + ", price=" + price + "]";
    }
}
