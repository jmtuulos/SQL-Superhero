package repositories;

import models.Customer;

public interface CustomerRepository extends CRUDRepository<Customer, Integer>{


    boolean create(Customer customer);

    boolean update(Customer customer);
}
