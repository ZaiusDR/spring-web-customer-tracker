package info.esuarez.springwebcustomertracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.logging.Logger;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private final Logger LOGGER = Logger.getLogger(CustomerController.class.getName());

    @GetMapping("/list")
    public String listCustomers() {
        LOGGER.info("[CustomerController] GET - /customer/list");
        return "list-customers";
    }
}
