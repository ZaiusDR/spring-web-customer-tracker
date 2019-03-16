package info.esuarez.springwebcustomertracker.repository;

import info.esuarez.springwebcustomertracker.entity.Customer;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface CustomerDAO extends CrudRepository<Customer, Integer> {
    
}
