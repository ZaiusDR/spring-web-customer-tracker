package info.esuarez.springwebcustomertracker.repository;

import info.esuarez.springwebcustomertracker.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerDAO extends JpaRepository<Customer, Integer> {
    Iterable<Customer> findAllByOrderByLastNameAsc();
}
