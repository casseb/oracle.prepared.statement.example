package com.programmer.gate.model;

public class TimerResponse {

	private String nome;
	private long valor;
	
	public TimerResponse() {
		super();
	}
	public TimerResponse(String nome, long valor) {
		super();
		this.nome = nome;
		this.valor = valor;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public long getValor() {
		return valor;
	}
	public void setValor(long valor) {
		this.valor = valor;
	}
	
	
	
}
