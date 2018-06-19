package com.programmer.gate.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.programmer.gate.model.TimerResponse;
import com.programmer.gate.repository.TimerRepository;

@RestController
@CrossOrigin
public class TimerController {
	
	@Autowired
	private TimerRepository timerRepo;
	
	@RequestMapping(value = "")
	public List<TimerResponse> result() {
		List<TimerResponse> response = new LinkedList<>();
		TimerResponse responseTemp = null;
		
		responseTemp = new TimerResponse("Hardcoded", timerRepo.findOne("Hardcoded").getDuration());
		response.add(responseTemp);
		
		responseTemp = new TimerResponse("Firmcoded", timerRepo.findOne("Firmcoded").getDuration());
		response.add(responseTemp);
		
		responseTemp = new TimerResponse("Softcoded", timerRepo.findOne("Softcoded").getDuration());
		response.add(responseTemp);
		
		responseTemp = new TimerResponse("Vrau do Spring", timerRepo.findOne("Vrau do Spring").getDuration());
		response.add(responseTemp);
		
		return response;
	}
}
