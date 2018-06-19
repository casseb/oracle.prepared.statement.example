package com.programmer.gate.model;

public class ResultResponse {

	private long hardcoded;
	private long firmcoded;
	private long softcoded;
	private long vrauDoSpring;
	
	public ResultResponse() {
		super();
	}

	public ResultResponse(long hardcoded, long firmcoded, long softcoded, long vrauDoSpring) {
		super();
		this.hardcoded = hardcoded;
		this.firmcoded = firmcoded;
		this.softcoded = softcoded;
		this.vrauDoSpring = vrauDoSpring;
	}

	public long getHardcoded() {
		return hardcoded;
	}

	public void setHardcoded(long hardcoded) {
		this.hardcoded = hardcoded;
	}

	public long getFirmcoded() {
		return firmcoded;
	}

	public void setFirmcoded(long firmcoded) {
		this.firmcoded = firmcoded;
	}

	public long getSoftcoded() {
		return softcoded;
	}

	public void setSoftcoded(long softcoded) {
		this.softcoded = softcoded;
	}

	public long getVrauDoSpring() {
		return vrauDoSpring;
	}

	public void setVrauDoSpring(long vrauDoSpring) {
		this.vrauDoSpring = vrauDoSpring;
	}
	
	
	
	
	
}
