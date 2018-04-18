package com.up.clinicavet.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AnimalDAO implements IGenericDAO<Animal, Long> {

	@Override
	public List<Animal> listar() throws Exception {
		Connection con = ConnectionFactory.getConnection();
		String sql = "SELECT id, nome, nascimento, especie_id FROM ANIMAL";
		PreparedStatement statement = con.prepareStatement(sql);
		ResultSet rs = statement.executeQuery();

		List<Animal> animais = new ArrayList<>();

		while (rs.next()) {
			Animal animal = new Animal();
			animal.setId(rs.getInt("id"));
			animal.setNome(rs.getString("nome"));
			animal.setNascimento(rs.getDate("nascimento"));
				
			long especieId = rs.getLong("especie_id");
			Especie especie = new EspecieDAO().buscar(especieId);
			animal.setEspecie(especie);
			
			animais.add(animal);
		}
		return animais;
	}

	@Override
	public Animal buscar(Long id) throws Exception {
		Connection con = ConnectionFactory.getConnection();
		String sql = "SELECT id, nome, nascimento FROM ANIMAL WHERE id = ?";

		PreparedStatement statement = con.prepareStatement(sql);
		statement.setLong(1, id);
		ResultSet rs = statement.executeQuery();

		Animal animal = null;

		if (rs.next()) {
			animal = new Animal();
			animal.setId(rs.getInt("id"));
			animal.setNome(rs.getString("nome"));
			animal.setNascimento(rs.getDate("nascimento"));
		}

		return animal;
	}

	@Override
	public Animal remover(Long id) throws Exception {
		Animal animalToRemove = buscar(id);
		if (animalToRemove == null)
			return null;

		String sql = "delete from animal where ID = ?";

		try (Connection conn = ConnectionFactory.getConnection(); 
				PreparedStatement ps = conn.prepareStatement(sql);) {
			ps.setLong(1, id);
			ps.execute();
			return animalToRemove;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void atualizar(Animal objeto) throws Exception {

	}

	@Override
	public void persistir(Animal objeto) throws Exception {
		String sql = "insert into animal (nome, nascimento, especie_id) values(?, ?, ?)";

		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, objeto.getNome());
			ps.setDate(2, new java.sql.Date(objeto.getNascimento().getTime()));
			ps.setInt(3, objeto.getEspecie().getId());
			ps.execute();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
