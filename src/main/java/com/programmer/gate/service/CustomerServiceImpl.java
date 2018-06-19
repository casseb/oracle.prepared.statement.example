package com.programmer.gate.service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

import javax.persistence.EntityManagerFactory;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.programmer.gate.model.Customer;
import com.programmer.gate.model.Timer;
import com.programmer.gate.repository.CustomerRepository;

@Service("customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepository customerRepo;
	
	private final SessionFactory sf;

    @Autowired
    public CustomerServiceImpl(SessionFactory sf) {
        this.sf=sf;
    }

	@Override
	public void executar(int quantidade) {
		prepararAmbiente(quantidade);
	}

	@Transactional
	public void prepararAmbiente(int quantidade) {
		customerRepo.deleteAll();
		createNRandomCustomer(quantidade);
	}

	private void createNRandomCustomer(int n) {
		for (int i = 0; i < n; i++) {
			createRandomCustomer();
		}
	}

	@Transactional
	private void createRandomCustomer() {
		Customer customer = new Customer(generateRandomWord(), 12099);
		customerRepo.save(customer);
	}

	private String generateRandomWord() {
		Random random = new Random();
		char[] word = new char[random.nextInt(8) + 3];
		for (int j = 0; j < word.length; j++) {
			word[j] = (char) ('a' + random.nextInt(26));
		}
		return new String(word) + " by Casseb";
	}
	
	@Transactional
	public void queryCustomersHardcoded() {
		for(Customer customer : customerRepo.findAll()) {
			Session session = this.sf.getCurrentSession();
	        Query query = session.createQuery("from Customer c where c.id = "+customer.getId().toString());
	        query.getFirstResult();
	        System.out.println("Realizado select do customer "+customer.getName());
		}
	}
	
	@Transactional
	public void queryCustomersFirmcoded() {
		for(Customer customer : customerRepo.findAll()) {
			Session session = this.sf.getCurrentSession();
	        Query query = session.createQuery("from Customer c where c.id = :id");
	        query.setParameter("id", customer.getId());
	        query.getFirstResult();
	        System.out.println("Realizado select do customer "+customer.getName());
		}
	}
	
	@Transactional
	public void queryCustomersSoftcoded() {
		Session session = this.sf.getCurrentSession();
        Query query = session.createQuery("from Customer c where c.id = :id");
		
		for(Customer customer : customerRepo.findAll()) {
	        query.setParameter("id", customer.getId());
	        query.getFirstResult();
	        System.out.println("Realizado select do customer "+customer.getName());
		}
	}
	
	@Transactional
	public void queryCustomersVrauDoSpring() {
		for(Customer customer : customerRepo.findAll()) {
	        customerRepo.findOne(customer.getId());
	        System.out.println("Realizado select do customer "+customer.getName());
		}
	}
}
