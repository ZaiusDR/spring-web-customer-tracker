package info.esuarez.springwebcustomertracker.controller;

import info.esuarez.springwebcustomertracker.entity.Customer;
import info.esuarez.springwebcustomertracker.repository.CustomerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.logging.Logger;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private final Logger LOGGER = Logger.getLogger(CustomerController.class.getName());

    private final CustomerDAO customerDAO;

    @Autowired
    public CustomerController(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @GetMapping("/list")
    public String listCustomers(Model model) {
        LOGGER.info("[CustomerController] GET - /customer/list");

        Iterable<Customer> customers = customerDAO.findAll();

        model.addAttribute("customers", customers);

        return "list-customers";
    }
}
