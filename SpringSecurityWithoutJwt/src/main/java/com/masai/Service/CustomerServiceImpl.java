package com.masai.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exception.CustomerException;
import com.masai.model.Customer;
import com.masai.repository.CustomerRepo;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepo customerRepo;

	@Override
	public Customer registerCustomer(Customer customer) {
		
		return customerRepo.save(customer);
	}

	@Override
	public Customer getCustomerDetailByEmail(String email) throws CustomerException {
		
//		Optional<Customer> opt = customerRepo.findByEmail(email);
//		
//		if(opt==null) {
//			throw new CustomerException("Cusomter does not exist with this email id");
//		}else {
//			return opt.get();
//		}
		
		
		return customerRepo.findByEmail(email).orElseThrow(()-> new CustomerException("customer does not exist with this email id"));
		
		
		
	}

	@Override
	public List<Customer> getAllCustomerDetails() throws CustomerException {
		
		return customerRepo.findAll();
		
		
	}
	
	

}
