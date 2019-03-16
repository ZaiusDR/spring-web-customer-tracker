package info.esuarez.springwebcustomertracker.service;

import info.esuarez.springwebcustomertracker.entity.Customer;
import info.esuarez.springwebcustomertracker.repository.CustomerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class CustomerService {

    private CustomerDAO customerDAO;

    @Autowired
    public CustomerService(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @Transactional
    public Iterable<Customer> getCustomers() {
        return customerDAO.findAllByOrderByLastNameAsc();
    }

    @Transactional
    public Customer getCustomerById(int id) {
        return customerDAO.findById(id).orElse(null);
    }

    @Transactional
    public void saveCustomer(Customer customer) {
        customerDAO.save(customer);

    }
}
