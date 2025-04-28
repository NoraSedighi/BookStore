package products;

public class Notebook extends Product{
    private int pageCount;
    private boolean isHardCover;
    private static int count = 0;

    public Notebook(String title, Double price, int pageCount, boolean isHardCover) {
        super(title, price);
        setPageCount(pageCount);
        setId(generateId());
        setHardCover(isHardCover);
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setHardCover(boolean hardCover) {
        isHardCover = hardCover;
    }

    public boolean isHardCover() {
        return isHardCover;
    }

    @Override
    public String toString() {
        return super.toString() + " | Page Count: " + getPageCount() + " | is hard cover: " + isHardCover();
    }

    @Override
    public String generateId() {
        count++;

        if(count > 99){
            setId("3" + String.format("%01d", count));
            return "3" + String.format("%01d", count);
        }

        if(count > 9){
            setId("2" + String.format("%02d", count));
            return "2" + String.format("%02d", count);
        }

        setId("2" + String.format("%03d", count));
        return "2" + String.format("%03d", count);
    }
}
