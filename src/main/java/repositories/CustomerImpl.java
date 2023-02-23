package repositories;

import models.Customer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Repository
public class CustomerImpl implements CustomerRepository {
    private final String url;
    private final String username;
    private final String password;
    private Connection conn = null;
    public CustomerImpl(
            @Value("${spring.datasource.url}") String url,
            @Value("${spring.datasource.username}") String username,
            @Value("${spring.datasource.password}") String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    @Override
    public List<Customer> listAll() throws SQLException {
        List<Customer> customers = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            PreparedStatement preparedStatement =
                conn.prepareStatement(
                        "SELECT customer_id, first_name, last_name, country, postal_code, phone, email from Customer"
                );
            ResultSet result = preparedStatement.executeQuery();
            // Set the values of the Customer object
            while (result.next()) {
                Customer customer = new Customer(
                        result.getInt("customer_id"),
                        result.getString("first_name"),
                        result.getString("last_name"),
                        result.getString("country"),
                        result.getString("postal_code"),
                        result.getString("phone"),
                        result.getString("email")
                );
                customers.add(customer);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customers;
    }

    @Override
    public Customer getById(Integer id) {
        Customer customer = null;
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            PreparedStatement preparedStatement =
                    conn.prepareStatement("SELECT customer_id, first_name, last_name, country, postal_code, phone, email from Customer WHERE CustomerId=?");
            preparedStatement.setInt(1, id);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                customer = new Customer(
                        result.getInt("customer_id"),
                        result.getString("first_name"),
                        result.getString("last_name"),
                        result.getString("country"),
                        result.getString("postal_code"),
                        result.getString("phone"),
                        result.getString("email")
                );
            }
            return customer;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean create(Customer customer) {
        int result;
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            PreparedStatement preparedStatement =
                    conn.prepareStatement("INSERT INTO customer (customer_id, first_name, last_name, country, postal_code, phone, email) VALUES (?, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setInt(1, customer.getCustomer_id());
            preparedStatement.setString(2, customer.getFirst_name());
            preparedStatement.setString(3, customer.getLast_name());
            preparedStatement.setString(4, customer.getCountry());
            preparedStatement.setString(5, customer.getPostal_code());
            preparedStatement.setString(6, customer.getPhone());
            preparedStatement.setString(7, customer.getEmail());
            result = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return result != 0;
    }

    @Override
    public boolean update(Customer customer) {
        int result;
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            PreparedStatement preparedStatement =
                    conn.prepareStatement("UPDATE customer SET first_name=?, last_name=?, country=?, postal_code=?, phone=?, email=? WHERE customer_id=?");
            preparedStatement.setString(1, customer.getFirst_name());
            preparedStatement.setString(2, customer.getLast_name());
            preparedStatement.setString(3, customer.getCountry());
            preparedStatement.setString(4, customer.getPostal_code());
            preparedStatement.setString(5, customer.getPhone());
            preparedStatement.setString(6, customer.getEmail());
            preparedStatement.setInt(7, customer.getCustomer_id());
            result = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return result != 0;
    }

    @Override
    public void delete(Integer id) {

    }
    @Override
    public Customer getByName(String name) {
        Customer customer = null;
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            PreparedStatement preparedStatement =
                    conn.prepareStatement("SELECT customer_id, first_name, last_name, country, postal_code, phone, email from Customer WHERE first_name || last_name LIKE ? ");
            preparedStatement.setString(1, "%" + name + "%");
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                customer = new Customer(
                        result.getInt("customer_id"),
                        result.getString("first_name"),
                        result.getString("last_name"),
                        result.getString("country"),
                        result.getString("postal_code"),
                        result.getString("phone"),
                        result.getString("email")
                );
            }
            return customer;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Customer> listCustomersOffsetLimit(int limit, int offset) throws SQLException {
        List<Customer> customers = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            PreparedStatement preparedStatement =
                    conn.prepareStatement(
                            "SELECT customer_id, first_name, last_name, country, postal_code, phone, email from Customer ORDER BY customer_id LIMIT ? OFFSET ?"
                    );
            preparedStatement.setInt(1, limit);
            preparedStatement.setInt(2, offset);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                Customer customer = new Customer(
                        result.getInt("customer_id"),
                        result.getString("first_name"),
                        result.getString("last_name"),
                        result.getString("country"),
                        result.getString("postal_code"),
                        result.getString("phone"),
                        result.getString("email")
                );
                customers.add(customer);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customers;
    }
}
