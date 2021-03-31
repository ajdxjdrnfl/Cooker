package korea.co.cooker;

public class SearchResult {
    String name;
    String author;
    String date;
    int image;

    public SearchResult(String name, String author, String date, int image) {
        this.name = name;
        this.author = author;
        this.date = date;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getDate() {
        return date;
    }

    public int getImage() {
        return image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
