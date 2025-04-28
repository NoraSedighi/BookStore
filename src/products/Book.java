package products;

public class Book extends Product{
    private String author;
    private String publication;
    private String genre;
    private static int count = 0;

    public Book(String title, Double price, String author, String publication, String genre) {
        super(title, price);
        this.author = author;
        this.publication =publication;
        this.genre = genre;
        setId(generateId());
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setPublication(String publication) {
        this.publication = publication;
    }

    public String getPublication(){
        return publication;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public String generateId() {
        count++;

        if(count > 99){
            setId("1" + String.format("%01d", count));
            return "1" + String.format("%01d", count);
        }

        if(count > 9){
            setId("1" + String.format("%02d", count));
            return "1" + String.format("%02d", count);
        }

        setId("1" + String.format("%03d", count));
        return "1" + String.format("%03d", count);
    }

    @Override
    public String toString() {
        return super.toString() + " | Author: " + getAuthor() + " | Publication: " + getPublication() + " | Genre: " + getGenre();
    }
}
