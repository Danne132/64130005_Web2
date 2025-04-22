package bt.an.HelloJPA.respositories;

import org.springframework.data.jpa.repository.JpaRepository;

import bt.an.HelloJPA.models.Customer;

public interface ICustomer extends JpaRepository<Customer, Integer>{

}
