package W2.B2_7_PassbyReference_DeepCopy;

public class Product {
    private String id;
    private String name;
    private double price;

    public Product(String id, String name, double price) {
        this.id = id;
        this.name = name;
        setPrice(price);
    }
    public Product(Product other) {
        this.id = other.id;
        this.name = other.name;
        this.price = other.price;
    }

    public String getId()    { return id; }
    public String getName()  { return name; }
    public double getPrice() { return price; }
    public void setName(String name) { this.name = name; }
    public void setPrice(double price) {
        if (price < 0) {
            System.out.println("[LỖI] Giá không được âm. Giữ nguyên: " + this.price);
            return;
        }
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("Product[id=%s, name=%s, price=%.0f$]", id, name, price);
    }
}
