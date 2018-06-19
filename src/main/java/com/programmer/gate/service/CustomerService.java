package com.programmer.gate.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.programmer.gate.model.Customer;

public interface CustomerService {
	
	public void executar(int quantidade);
	
	public void prepararAmbiente(int quantidade);
	
	public void queryCustomersHardcoded();
	
	public void queryCustomersFirmcoded();
	
	public void queryCustomersSoftcoded();
	
	public void queryCustomersVrauDoSpring();
}
