import inventory.Inventory;
import products.Accessory;
import products.Book;
import products.Notebook;
import products.Product;

public class Main {
    public static void main(String[] args) {
        Inventory<Book> bookInventory = new Inventory<>();
        Inventory<Notebook> notebookInventory = new Inventory<>();
        Inventory<Accessory> accessoryInventory = new Inventory<>();

        Book book1 = new Book("Harry Potter", 150.0, "J.K.Rowling", "Bloomsbury", "Fantasy");
        Book book2 = new Book("Lord of the Rings", 200.0, "J.R.R.Tolkien", "Allen & Unwin", "Fantasy");

        Notebook notebook1 = new Notebook("College Ruled Notebook", 20.0, 200, true);
        Notebook notebook2 = new Notebook("Spiral Notebook", 15.0, 150, false);

        Accessory accessory1 = new Accessory("Pen", 5.0, "Blue");
        Accessory accessory2 = new Accessory("Pencil", 3.0, "Red");

        bookInventory.addItem(book1);
        bookInventory.addItem(book2);
        bookInventory.displayAll();

        notebookInventory.addItem(notebook1);
        notebookInventory.addItem(notebook2);
        notebookInventory.displayAll();

        accessoryInventory.addItem(accessory1);
        accessoryInventory.addItem(accessory2);
        accessoryInventory.displayAll();

        bookInventory.removeItemsById(book2.getId());
        accessoryInventory.removeItemsById(accessory2.getId());

        System.out.println("\nTotal Price of Books: " + calculateTotalPrice(bookInventory));
        System.out.println("Total Price of Notebooks: " + calculateTotalPrice(notebookInventory));
        System.out.println("Total Price of Accessories: " + calculateTotalPrice(accessoryInventory));

        Product foundProduct = notebookInventory.findItemById(notebook1.getId());
        if (foundProduct != null) {
            System.out.println("Found product: " + foundProduct);
        }

        Product notFoundProduct = accessoryInventory.findItemById("2003");
         if (notFoundProduct != null){
             System.out.println("Product : " + notebook1.getTitle() + " not found");
         }

        bookInventory.applyDiscount("Harry Potter", 10);
        notebookInventory.applyDiscount("Spiral Notebook", 20);


        System.out.println("\n--- Book Inventory ---");
        bookInventory.displayAll();

        System.out.println("\n--- Notebook Inventory ---");
        notebookInventory.displayAll();

        System.out.println("\n--- Accessory Inventory ---");
        accessoryInventory.displayAll();
    }

    public static double calculateTotalPrice(Inventory<? extends Product> inventory) {
        double total = 0;
        for (Product item : inventory.getItems()) {
            total += item.getPrice();
        }
        return total;
    }
}
