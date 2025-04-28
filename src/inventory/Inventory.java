package inventory;

import products.Product;

import java.util.ArrayList;

public class Inventory<T extends Product>{
    private ArrayList<T> items = new ArrayList<>();

    public void setItems(ArrayList<T> items) {
        this.items = items;
    }

    public ArrayList<T> getItems() {
        return items;
    }

    public void applyDiscount(String productName, int discount){
        for (T item : items){
            if (item.getTitle().equals(productName)){
                double originalPrice = item.getPrice();
                double discountedPrice = originalPrice * ((100 - discount) / 100.0);
                item.setPrice(discountedPrice);
                return;
            }
        }
        System.out.println("Product with name '" + productName + "' not found");
    }

    public void addItem (T product){
        items.add(product);
    }

    public void removeItemsById(String id){
        T toRemove = null;
        for (T item : items){
            if (item.getId().equals(id)){
                toRemove = item;
                break;
            }
        }

        if (toRemove != null)
            items.remove(toRemove);
        else
            System.out.println("Item with ID " + id + " not found");
    }

    public T findItemById(String id){
        for(T item : items) {
            if (item.getId().equals(id))
                return item;
        }
        System.out.println("Item with ID " + id + " not found");
        return null;
    }

    public void displayAll(){
        if (items.isEmpty()) {
            System.out.println("No products in inventory");
            return;
        }

        for(T item : items){
            System.out.println(item);
        }
    }
}
