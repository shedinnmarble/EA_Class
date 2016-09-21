package cs544.exercise10_1.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import cs544.exercise10_1.customer.Customer;

@Controller
@RequestMapping(value = "/rest")

public class CustomerController implements ICustomerService {
	private ICustomerService customerService = new CustomerService();

	public void setCustomerService(ICustomerService customerService) {
		this.customerService = new CustomerService();
	}

	@RequestMapping(value = "/customer", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void addCustomer(@RequestBody Customer customer) {
		customerService.addCustomer(customer);
	}

	@RequestMapping(value = "/customer/{customerNumber}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void deleteCustomer(@PathVariable("customerNumber") String customerNumber) {
		customerService.deleteCustomer(customerNumber);

	}

	@RequestMapping(value = "/customer/{customerNumber}", method = RequestMethod.GET)
	public @ResponseBody Customer getCustomer(@PathVariable("customerNumber") String customerNumber) {
		return customerService.getCustomer(customerNumber);
	}

	@RequestMapping(value = "/customers", method = RequestMethod.GET)
	public @ResponseBody Collection<Customer> getCustomers() {
		return customerService.getCustomers();
	}

	@RequestMapping(value = "/customer/{customerNumber}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public void updateCustomer(@RequestBody Customer customer) {
		customerService.updateCustomer(customer);
	}

}
