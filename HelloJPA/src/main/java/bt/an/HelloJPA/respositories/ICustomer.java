package bt.an.HelloJPA.respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bt.an.HelloJPA.models.Customer;

@Repository
public interface ICustomer extends JpaRepository<Customer, String>{
}
