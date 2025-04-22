package bt.an.HelloJPA.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import bt.an.HelloJPA.models.Customer;
import bt.an.HelloJPA.respositories.ICustomer;

@Controller
public class CustomerController {
	@Autowired
	ICustomer myCustomer;
	//Các action method
	
	@GetMapping("/customer/all")
	public String getAll(ModelMap model) {
		ArrayList<Customer> ds = new ArrayList<Customer>();
		ds.addAll(myCustomer.findAll());
		model.addAttribute("ds", ds);
		return null;
	}
}
