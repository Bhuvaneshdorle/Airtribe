public class Product {
    static int totalProducts = 0; // Shared by all Product objects
    String name;
    double price;
    int quantity;

    Product() {
        name = "Unknown";
        price = 0;
        quantity = 0;
        totalProducts++;
    }

    Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        totalProducts++;
    }

    // Make a separate product using the values from another product.
    Product(Product other) {
        name = other.name;
        price = other.price;
        quantity = other.quantity;
        totalProducts++;
    }

    double stockValue() {
        return price * quantity;
    }

    void display() {
        System.out.println(name + " | Rs " + price + " | qty " + quantity);
    }
}

