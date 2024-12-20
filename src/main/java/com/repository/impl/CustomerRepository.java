package com.repository.impl;

import com.model.Customer;
import com.repository.ICustomerRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class CustomerRepository implements ICustomerRepository {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Customer> findAll() {
		TypedQuery<Customer> query = entityManager.createQuery("from Customer", Customer.class);
		return query.getResultList();
	}

	@Override
	public Customer findById(Long id) {
		String hql = "from Customer c where c.id = " + id;
		TypedQuery<Customer> query = entityManager.createQuery(hql, Customer.class);
		try {
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public void save(Customer customer) {
		if (customer.getId() != null) {
			entityManager.merge(customer);
		} else {
			entityManager.persist(customer);
		}
	}

	@Override
	public void remove(Long id) {
		Customer customer = findById(id);
		if (customer != null) {
			entityManager.remove(customer);
		}
	}
}
