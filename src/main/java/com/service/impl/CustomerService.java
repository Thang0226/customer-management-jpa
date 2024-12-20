package com.service.impl;

import com.model.Customer;
import com.repository.ICustomerRepository;
import com.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {

	@Autowired
	private ICustomerRepository customerRepo;

	@Override
	public List<Customer> findAll() {
		return customerRepo.findAll();
	}

	@Override
	public void save(Customer customer) {
		customerRepo.save(customer);
	}

	@Override
	public Customer findById(Long id) {
		return customerRepo.findById(id);
	}

	@Override
	public void remove(Long id) {
		customerRepo.remove(id);
	}
}
