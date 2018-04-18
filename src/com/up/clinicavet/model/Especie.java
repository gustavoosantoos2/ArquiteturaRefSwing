package com.up.clinicavet.model;

import java.util.List;

public class Especie {
	private int id;
	private String nome_especie;
	private String descricao;
	private List<Animal> animais;
	
	private TipoAnimal tipo_Animal;

	public Especie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Especie(int id, String nome_especie, String descricao, List<Animal> animais, TipoAnimal tipo_Animal) {
		super();
		this.id = id;
		this.nome_especie = nome_especie;
		this.descricao = descricao;
		this.animais = animais;
		this.tipo_Animal = tipo_Animal;
	}

	public Especie(int especieId) {
		this.id = especieId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome_especie() {
		return nome_especie;
	}

	public void setNome_especie(String nome_especie) {
		this.nome_especie = nome_especie;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Animal> getAnimais() {
		return animais;
	}

	public void setAnimais(List<Animal> animais) {
		this.animais = animais;
	}

	public TipoAnimal getTipo_Animal() {
		return tipo_Animal;
	}

	public void setTipo_Animal(TipoAnimal tipo_Animal) {
		this.tipo_Animal = tipo_Animal;
	}

	
}
