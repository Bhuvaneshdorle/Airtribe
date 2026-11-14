# Campus Cafe Inventory

A simple Java program to manage products in a campus cafe. It can add and
display products, calculate stock value and average price, restock items,
and make a copy of a product. It stores up to 10 products.

## Run the program

Open a terminal in this folder and run:

```text
javac Main.java Product.java Warmup.java
java Main
```

To run the warm-up separately:

```text
java Warmup
```

Enter numbers when asked for a menu choice, price, quantity, or product number.
Enter 0 to exit.

## Warm-up prediction and output

Example prediction (replace this with your own prediction): `7 5.0 130`,
then `Two`. The actual first line is `7 5.0 -126`: casting 7.9 to int
removes the decimal part, 5 becomes 5.0 when stored as a double, and 130 becomes
-126 because it is outside the byte range of -128 to 127. Both `Two` and
`Three` print because there is no break after case 2.

Actual output:

```text
7 5.0 -126
Two
Three
```

## Static variable and instance variable

`totalProducts` belongs to the Product class, so all products share the same
counter. `name` belongs to each individual object, so Tea and Samosa can have
different names.

## Copy constructor

The copy constructor makes a new product with the same name, price, and quantity
as the original, and increases the counter. Changing `p2.name` only assigns
a new name to p2's field, so p1 keeps its old name.

## Casting the average to int

Java asks for an explicit cast because a double can have a decimal part that
an int cannot store. `(int) average` drops the decimal part toward zero,
so 12.75 becomes 12; for our positive prices, this is the rounded-down value.

## Testing

The full test session is saved in `output.txt`, with the inputs shown beside
the prompts. It covers all menu options, empty inventory, and invalid inputs.

With Samosa at Rs 15 and quantity 20, and Tea at Rs 10.5 and quantity 5:

- Total stock value: Rs 352.5
- Average price: Rs 12.75
- Rounded down: 12
- Tea quantity after adding 10: 15
- Duplicate name: Samosa (copy)
- Products created at exit: 3

The constructors and the 10-product limit were also checked separately.
