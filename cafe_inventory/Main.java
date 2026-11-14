import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Product[] products = new Product[10];
        int count = 0; // Number of slots used in the array
        int choice;

        do {
            System.out.println("\n--- Campus Cafe Inventory ---");
            System.out.println("1. Add product");
            System.out.println("2. Display all products");
            System.out.println("3. Total stock value");
            System.out.println("4. Average price");
            System.out.println("5. Restock a product");
            System.out.println("6. Duplicate a product");
            System.out.println("0. Exit");
            System.out.print("Choose: ");
            choice = sc.nextInt();
            sc.nextLine(); // Read the newline left after nextInt()

            if (choice < 0 || choice > 6) {
                System.out.println("Invalid choice, try again.");
            }

            switch (choice) {
                case 1:
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Price: ");
                    double price = sc.nextDouble();
                    System.out.print("Quantity: ");
                    int quantity = sc.nextInt();
                    sc.nextLine();

                    if (count == products.length) {
                        System.out.println("Inventory is full (maximum 10 products).");
                    } else if (price <= 0 || quantity < 0) {
                        System.out.println("Invalid input: price must be above 0 and quantity cannot be negative.");
                    } else {
                        products[count] = new Product(name, price, quantity);
                        count++;
                        System.out.println("Product added.");
                    }
                    break;

                case 2:
                    if (count == 0) {
                        System.out.println("No products available.");
                    } else {
                        for (int i = 0; i < count; i++) {
                            System.out.print((i + 1) + ". ");
                            products[i].display();
                        }
                    }
                    break;

                case 3:
                    if (count == 0) {
                        System.out.println("No products available.");
                    } else {
                        double total = 0;
                        for (int i = 0; i < count; i++) {
                            total += products[i].stockValue();
                        }
                        System.out.println("Total stock value: Rs " + total);
                    }
                    break;

                case 4:
                    if (count == 0) {
                        System.out.println("No products available.");
                    } else {
                        double sum = 0;
                        for (int i = 0; i < count; i++) {
                            sum += products[i].price;
                        }
                        double average = sum / count;
                        System.out.println("Exact average price: Rs " + average);
                        System.out.println("Rounded down: " + (int) average);
                    }
                    break;

                case 5:
                    System.out.print("Product number: ");
                    int num = sc.nextInt();
                    System.out.print("Quantity to add: ");
                    int extra = sc.nextInt();
                    sc.nextLine();

                    if (num < 1 || num > count || extra <= 0) {
                        System.out.println("Invalid input: choose an existing product and a quantity above 0.");
                    } else {
                        // Product numbers start at 1, but array indexes start at 0.
                        products[num - 1].quantity += extra;
                        System.out.println("Product restocked.");
                    }
                    break;

                case 6:
                    System.out.print("Product number: ");
                    int n = sc.nextInt();
                    sc.nextLine();

                    if (n < 1 || n > count) {
                        System.out.println("Invalid product number.");
                    } else if (count == products.length) {
                        System.out.println("Inventory is full (maximum 10 products).");
                    } else {
                        Product copy = new Product(products[n - 1]);
                        copy.name = copy.name + " (copy)";
                        products[count] = copy;
                        count++;
                        System.out.println("Product duplicated.");
                    }
                    break;

                case 0:
                    System.out.println("Goodbye!");
                    break;
            }
        } while (choice != 0);

        System.out.println("Products created in total: " + Product.totalProducts);
        sc.close();
    }
}

