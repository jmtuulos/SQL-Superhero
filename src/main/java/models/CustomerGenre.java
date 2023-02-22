package models;

public class CustomerGenre {
    private String Genre;
    private int count;

    public CustomerGenre(String genre, int count) {
        this.Genre = genre;
        this.count = count;
    }

    public String getGenre() {
        return Genre;
    }

    public void setGenre(String genre) {
        this.Genre = genre;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
