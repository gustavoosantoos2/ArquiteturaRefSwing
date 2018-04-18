package com.up.clinicavet.model;

import java.util.Date;

public class Animal {
	private int id;
	private String nome;
	private Date nascimento;
	private Especie especie;
	
	public Animal() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Animal(int id, String nome, Date nascimento, Especie especie) {
		super();
		this.id = id;
		this.nome = nome;
		this.nascimento = nascimento;
		this.especie = especie;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) throws Exception{ 
		if(nome==null || nome.isEmpty())
				throw new Exception ("Animal deve ter um nome");
		
		if(nome.length() >50)
				throw new Exception ("O nome do animal deve ter no"
						+ "	máximo 50 caracteres.");
		
		this.nome = nome;
	}
	public Date getNascimento() {
		return nascimento;
	}
	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}
	public Especie getEspecie() {
		return especie;
	}
	public void setEspecie(Especie especie) {
		this.especie = especie;
	}
	
	
}
