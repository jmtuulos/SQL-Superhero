package repositories;

import models.Customer;
import models.CustomerCountry;
import models.CustomerGenre;
import models.CustomerSpender;

import java.util.List;

public interface CustomerRepository extends CRUDRepository<Customer, Integer>{


    boolean create(Customer customer);

    boolean update(Customer customer);

    CustomerCountry countryWithMostCustomers();

    CustomerSpender customerWithHighestTotal();
    List<Customer> listCustomersOffsetLimit(int offset, int limit);
    List<CustomerGenre> customerFavouriteGenre(Customer customer);

}
