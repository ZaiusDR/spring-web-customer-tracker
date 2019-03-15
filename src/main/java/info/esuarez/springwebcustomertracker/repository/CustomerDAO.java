package info.esuarez.springwebcustomertracker.repository;

import info.esuarez.springwebcustomertracker.entity.Customer;

import java.util.List;

public interface CustomerDAO {

    List<Customer> getCustomers();
}
