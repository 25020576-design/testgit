

import java.util.*;

abstract class Product {
    protected String id;
    protected String name;

    public Product(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

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

class Electronic extends Product {
    private int warrantyMonths;

    public Electronic(String id, String name, int warrantyMonths) {
        super(id, name);
        this.warrantyMonths = warrantyMonths;
    }

    @Override
    public String getInfo() {
        return name + " - " + warrantyMonths + " tháng bảo hành";
    }
}

class Warehouse<T extends Product> {
    private List<T> items = new ArrayList<>();

    public void importItem(T item) {
        items.add(item);
    }

    public void exportItem(T item) {
        items.remove(item);
    }

    public void inventory() {
        for (T item : items) {
            System.out.println(item.getInfo());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Warehouse<Food> foodWarehouse = new Warehouse<>();
        Warehouse<Electronic> electronicWarehouse = new Warehouse<>();

        int n = Integer.parseInt(sc.nextLine().trim());

        for (int i = 0; i < n; i++) {
            String[] data = sc.nextLine().trim().split("\\s+");

            String type = data[0];
            String id = data[1];
            String name = data[2];

            if (type.equals("F")) {
                String expiryDate = data[3];

                Food food = new Food(id, name, expiryDate);
                foodWarehouse.importItem(food);

            } else if (type.equals("E")) {
                int warrantyMonths = Integer.parseInt(data[3]);

                Electronic electronic =
                    new Electronic(id, name, warrantyMonths);

                electronicWarehouse.importItem(electronic);
            }
        }

        System.out.println("Kho Thực phẩm:");
        foodWarehouse.inventory();

        System.out.println("Kho Điện tử:");
        electronicWarehouse.inventory();

        sc.close();
    }
}
