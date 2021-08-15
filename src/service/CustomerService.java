package service;

import model.Customer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CustomerService {

    private static CustomerService customerService;
    private List<Customer> customers;

    /**
     * Implementation of Singleton
     */
    private CustomerService(){
        this.customers = new ArrayList<Customer>();
    }

    public static CustomerService getCustomerService(){

        if(customerService == null){

            customerService = new CustomerService();
        }
        return customerService;
    }

    /**
     * Method adds a Customer object to a Customer Collection
     * @param email customer email
     * @param firstName customer first name
     * @param lastName customer last name
     */
    public void addCustomer(String email, String firstName, String lastName){
            Customer customer = new Customer(email,firstName,lastName);
            customers.add(customer);
    }

    /**
     * Method gets a Customer object with a provided customer email
     * @param customerEmail customer email
     * @return foundCustomer
     */
    public Customer getCustomer(String customerEmail){

        Customer foundCustomer = null;

        for(Customer customer : customers){

            if(customer.getEmail().equals(customerEmail)){

                foundCustomer = customer;
            }
        }

        return foundCustomer;
    }

    /**
     * Method get all customers from Customer Collection
     * @return allCustomers
     */
    public Collection<Customer> getAllCustomers(){

        Collection<Customer> allCustomers;

            if(!customers.isEmpty()){

                allCustomers = customers;

            } else {

                allCustomers = null;
            }

        return allCustomers;
    }

}
