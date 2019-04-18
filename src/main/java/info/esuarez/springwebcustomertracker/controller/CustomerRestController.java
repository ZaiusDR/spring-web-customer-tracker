package info.esuarez.springwebcustomertracker.controller;

import info.esuarez.springwebcustomertracker.entity.Customer;
import info.esuarez.springwebcustomertracker.exception.CustomerNotFoundException;
import info.esuarez.springwebcustomertracker.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class CustomerRestController {

    private final CustomerService customerService;

    @Autowired
    public CustomerRestController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public Iterable<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    @GetMapping("/customers/{customerId}")
    public Customer getCustomer(@PathVariable int customerId) {
        Customer customer = customerService.getCustomerById(customerId);

        if (customer == null) {
            throw new CustomerNotFoundException("Customer id not found - " + customerId);
        }

        return customer;
    }
}
