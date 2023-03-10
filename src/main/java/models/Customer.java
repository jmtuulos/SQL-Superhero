package models;

public class Customer {
    private int customer_id;
    private String first_name;
    private String last_name;
    private String country;
    private String postal_code;
    private String phone;
    private String email;

    public Customer(int customer_id,
                    String first_name,
                    String last_name,
                    String country,
                    String postal_code,
                    String phone,
                    String email) {
        this.customer_id = customer_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.country = country;
        this.postal_code = postal_code;
        this.phone = phone;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public Integer getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Integer customer_id) {
        this.customer_id = customer_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
