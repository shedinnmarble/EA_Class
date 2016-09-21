package cs544.exercise10_1.client;

import java.util.Collection;

import cs544.exercise10_1.customer.Customer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cs544.exercise10_1.service.ICustomerService;

public class CustomerApp {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("springconfig.xml");
		ICustomerService remoteService = context.getBean("customerServiceProxy", ICustomerService.class);

		// TODO add 3 customers & print customers list
		Customer customer1=new Customer();
		customer1.setName("dewei");
		customer1.setCustomerNumber("123");
		remoteService.addCustomer(customer1);
//		Customer get=remoteService.getCustomer("123");
//		System.out.println(get.getName());
		// TODO update 1 customer & print customers list

		// TODO delete 1 customer & print customers list
	}

	public static void printCustomers(Collection<Customer> customers) {
		for (Customer customer : customers) {
			System.out.println(customer.getName() + " " + customer.getCustomerNumber());
		}
		System.out.println();
	}
}
