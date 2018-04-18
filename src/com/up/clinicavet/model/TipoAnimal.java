package com.up.clinicavet.model;

import java.util.List;

public class TipoAnimal {
	private String acronimo;
	private String nome_tipoAnimal;
	private String descricao;
	private List<Especie> especies;
	
	public TipoAnimal() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TipoAnimal(String acronimo, String nome_tipoAnimal, String descricao, List<Especie> especies) {
		super();
		this.acronimo = acronimo;
		this.nome_tipoAnimal = nome_tipoAnimal;
		this.descricao = descricao;
		this.especies = especies;
	}
	public TipoAnimal(String acronimo) {
		this.acronimo = acronimo;
	}
	
	public String getAcronimo() {
		return acronimo;
	}
	public void setAcronimo(String acronimo) {
		this.acronimo = acronimo;
	}
	public String getNome_tipoAnimal() {
		return nome_tipoAnimal;
	}
	public void setNome_tipoAnimal(String nome_tipoAnimal) {
		this.nome_tipoAnimal = nome_tipoAnimal;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public List<Especie> getEspecies() {
		return especies;
	}
	public void setEspecies(List<Especie> especies) {
		this.especies = especies;
	}
	
}
