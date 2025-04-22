package bt.an.HelloJPA.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import bt.an.HelloJPA.respositories.ICustomer;

@Controller
public class CustomerController {
	@Autowired
	ICustomer myCustomer;
	//Các action method
	
	@GetMapping("/customer/all")
	public String getAll() {
		myCustomer.count();
		return null;
	}
}
