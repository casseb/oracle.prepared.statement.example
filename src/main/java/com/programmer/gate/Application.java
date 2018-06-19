package com.programmer.gate;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.Transactional;

import com.programmer.gate.model.Timer;
import com.programmer.gate.service.CustomerService;
import com.programmer.gate.service.TimerService;

@SpringBootApplication
@EnableAsync
public class Application{

	@Autowired
	private TimerService timerService;
	
	@Autowired
	private CustomerService customerService;

	private Map<String, Long> timers = new HashMap<>();

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@PostConstruct
	@Transactional
	private void inicio() {
		customerService.prepararAmbiente(100000);
		
		startTimer("Hardcoded");
		customerService.queryCustomersHardcoded();
		stopTimer("Hardcoded");
		
		startTimer("Firmcoded");
		customerService.queryCustomersFirmcoded();
		stopTimer("Firmcoded");
		
		startTimer("Softcoded");
		customerService.queryCustomersSoftcoded();
		stopTimer("Softcoded");
		
		startTimer("Vrau do Spring");
		customerService.queryCustomersVrauDoSpring();
		stopTimer("Vrau do Spring");
	}
	
	@Bean
	public HibernateJpaSessionFactoryBean sessionFactory() {
	    return new HibernateJpaSessionFactoryBean();
	}
	
	private void startTimer(String i) {
		Long time = System.currentTimeMillis();
		timers.put(i, time);
	}

	private void stopTimer(String i) {
		Long time = System.currentTimeMillis();
		Timer timer = new Timer(i,time - timers.get(i));
		timerService.save(timer);
	}

}