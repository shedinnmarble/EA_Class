package cs544.exercise10_1.client;

import java.util.Collection;

import org.springframework.web.client.RestTemplate;

import cs544.exercise10_1.customer.Customer;
import cs544.exercise10_1.service.ICustomerService;

public class CustomerServiceProxy implements ICustomerService {

	private static final String customersURL = "http://localhost:8080/exercise10_1-service/rest/customers";
	private static final String newCustomersURL = "http://localhost:8080/exercise10_1-service/rest/customers";
	private static final String customerURL = "http://localhost:8080/exercise10.1-service/rest/customer/{customerNumber}";

	private RestTemplate restTemplate;

	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public CustomerServiceProxy() {
		// TODO Auto-generated constructor stub
	}

	public void addCustomer(Customer customer) {
		restTemplate.postForLocation(newCustomersURL, customer);
	}

	public void deleteCustomer(String customerNumber) {
		restTemplate.delete(customerURL, customerNumber);
	}

	public Customer getCustomer(String customerNumber) {
		return restTemplate.getForObject(customerURL, Customer.class, customerNumber);
	}

	public Collection<Customer> getCustomers() {
		Customer customers = restTemplate.getForObject(customersURL,Customer.class);
				 
		 return null;

	}

	public void updateCustomer(Customer customer) {
		restTemplate.put(customerURL, customer, customer.getCustomerNumber());
	}

}
