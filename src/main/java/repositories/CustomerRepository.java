package repositories;

import models.Customer;

public interface CustomerRepository extends CRUDRepository<Customer, Integer>{


    Object getById(Object id);

    void test();
}
