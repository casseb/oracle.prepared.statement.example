package com.programmer.gate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Timer {
	
	@Id
	private String id;
	
	@Column(name = "duration")
	private Long duration;

	public Timer() {
		super();
	}

	public Timer(String id, Long duration) {
		super();
		this.id = id;
		this.duration = duration;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getDuration() {
		return duration;
	}

	public void setDuration(Long duration) {
		this.duration = duration;
	}
	
}
