package service;

import model.Customer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CustomerService {

    private static CustomerService customerService;
    private List<Customer> customers;

    private CustomerService(){
        this.customers = new ArrayList<Customer>();
    }

    public static CustomerService getCustomerService(){

        if(customerService == null){

            customerService = new CustomerService();
        }
        return customerService;
    }


    public void addCustomer(String email, String firstName, String lastName){
            Customer customer = new Customer(email,firstName,lastName);
            customers.add(customer);
    }

    public Customer getCustomer(String customerEmail){

        Customer foundCustomer = null;

        for(Customer customer : customers){

            if(customer.getEmail().equals(customerEmail)){

                foundCustomer = customer;
            }
        }

        return foundCustomer;
    }

    public Collection<Customer> getAllCustomers(){

        Collection<Customer> customers1;

            if(!customers.isEmpty()){

                customers1 = customers;

            } else {

                customers1 = null;
            }

        return customers1;
    }

}
