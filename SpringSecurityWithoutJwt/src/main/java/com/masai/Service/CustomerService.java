package com.masai.Service;

import java.util.List;

import com.masai.Exception.CustomerException;
import com.masai.model.Customer;

public interface CustomerService {
	
	 public Customer registerCustomer(Customer customer);
	 
	 public Customer getCustomerDetailByEmail(String email)throws CustomerException;
	 
	 public List<Customer> getAllCustomerDetails()throws CustomerException;

}
