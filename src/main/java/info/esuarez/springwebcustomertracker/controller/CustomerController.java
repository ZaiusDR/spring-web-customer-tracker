package info.esuarez.springwebcustomertracker.controller;

import info.esuarez.springwebcustomertracker.entity.Customer;
import info.esuarez.springwebcustomertracker.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.logging.Logger;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private final Logger LOGGER = Logger.getLogger(CustomerController.class.getName());

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/list")
    public String listCustomers(Model model) {
        LOGGER.info("[CustomerController] GET - /customer/list");

        Iterable<Customer> customers = customerService.getCustomers();

        model.addAttribute("customers", customers);

        return "list-customers";
    }

    @GetMapping("/addCustomer")
    public String addCustomer(Model model) {
        LOGGER.info("[CustomerController] GET - /customer/addCustomer");

        if (!model.containsAttribute("customer")) {
            model.addAttribute("customer", new Customer());
        }

        return "add-customer";
    }

    @PostMapping("/processCustomer")
    public String processCustomer(
            @Valid @ModelAttribute("customer") Customer customer,
            BindingResult bindingResult,
            RedirectAttributes attributes) {

        LOGGER.info("[CustomerController] GET - /customer/addCustomer");

        if (bindingResult.hasErrors()) {
            attributes.addFlashAttribute("org.springframework.validation.BindingResult.customer", bindingResult);
            attributes.addFlashAttribute("customer", customer);
            return "redirect:/customer/addCustomer";
        }

        customerService.saveCustomer(customer);

        return "redirect:/customer/list";
    }
}
