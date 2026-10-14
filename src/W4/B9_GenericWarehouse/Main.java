package W4.B9_GenericWarehouse;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Product {
    protected String id;
    protected String name;

    public Product(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId()   { return id; }
    public String getName() { return name; }

    public abstract String getInfo();
}

class Food extends Product {
    private String expiryDate;

    public Food(String id, String name, String expiryDate) {
        super(id, name);
        this.expiryDate = expiryDate;
    }

    @Override
    public String getInfo() {
        return name + " - " + expiryDate;
    }
}

class Electronics extends Product {
    private int warrantyMonths;

    public Electronics(String id, String name, int warrantyMonths) {
        super(id, name);
        this.warrantyMonths = warrantyMonths;
    }

    @Override
    public String getInfo() {
        return name + " - " + warrantyMonths + " tháng bảo hành";
    }
}

class Warehouse<T extends Product> {
    private String name;
    private List<T> items = new ArrayList<>();

    public Warehouse(String name) {
        this.name = name;
    }

    public void importItem(T item) {
        items.add(item);
    }

    public boolean exportItem(String id) {
        return items.removeIf(item -> item.getId().equals(id));
    }

    public void inventory() {
        System.out.println(name + ":");
        for (T item : items) {
            System.out.println(item.getInfo());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Warehouse<Food> foodWarehouse = new Warehouse<>("Kho Thực phẩm");
        Warehouse<Electronics> electronicsWarehouse = new Warehouse<>("Kho Điện tử");

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String id = sc.next();
            String name = sc.next();

            if (type.equals("F")) {
                String expiry = sc.next();
                foodWarehouse.importItem(new Food(id, name, expiry));
            } else {
                int months = sc.nextInt();
                electronicsWarehouse.importItem(new Electronics(id, name, months));
            }
        }

        foodWarehouse.inventory();
        System.out.println();
        electronicsWarehouse.inventory();
    }
}
