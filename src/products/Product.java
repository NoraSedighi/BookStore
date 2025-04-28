package products;

public abstract class Product {
    private String title;
    private Double price;
    private String id;

    public Product(String title, Double price){
        this.title = title;
        this.price = price;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public abstract String generateId();

    @Override
    public String toString() {
        return "Title: " + getTitle() + " | Price: " + getPrice() + " | ID: " + getId();
    }
}
