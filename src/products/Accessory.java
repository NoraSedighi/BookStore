package products;

public class Accessory extends Product{
    private String color;
    private static int count = 0;

    public Accessory(String title, Double price, String color) {
        super(title, price);
        setColor(color);
        setId(generateId());
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return super.toString() + " | Color: " + getColor();
    }

    @Override
    public String generateId() {
        count++;

        if(count > 99){
            setId("3" + String.format("%01d", count));
            return "3" + String.format("%01d", count);
        }

        if(count > 9){
            setId("3" + String.format("%02d",count));
            return "3" + String.format("%02d",count);
        }

        setId("3" + String.format("%03d",count));
        return "3" + String.format("%03d",count);
    }
}
