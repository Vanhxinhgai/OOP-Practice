package W2.B2_7_PassbyReference_DeepCopy;

public class Inventory {
    private Product[] items;
    public Inventory(Product[] initialItems) {
        if (initialItems == null) {
            this.items = new Product[0];
            return;
        }
        this.items = new Product[initialItems.length];
        for (int i = 0; i < initialItems.length; i++) {
            if (initialItems[i] != null) {
                this.items[i] = new Product(initialItems[i]);
            }
        }
    }
    public Product[] getItems() {
        Product[] copy = new Product[items.length];
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null) {
                copy[i] = new Product(items[i]);
            }
        }
        return copy;
    }

    public void printItems() {
        for (Product p : items) {
            System.out.println("  " + p);
        }
    }
}
