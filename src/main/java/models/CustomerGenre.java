package models;

public class CustomerGenre {
    private int customerId;
    private String favouriteGenre;
    private int count;

    public CustomerGenre(int customerId, String favouriteGenre, int count) {
        this.favouriteGenre = favouriteGenre;
        this.customerId = customerId;
        this.count = count;
    }

    public String getFavouriteGenre() {
        return favouriteGenre;
    }

    public void setGenre(String genre) {
        this.favouriteGenre = genre;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
}
