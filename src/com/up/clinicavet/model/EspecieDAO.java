package com.up.clinicavet.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EspecieDAO implements IGenericDAO<Especie, Long>{

	@Override
	public List<Especie> listar() throws Exception {
		Connection con = ConnectionFactory.getConnection();
		String sql = "SELECT id, nome, descricao, tipo_animal_acronimo FROM especie";
		PreparedStatement statement = con.prepareStatement(sql);
		ResultSet rs = statement.executeQuery();
		
		List<Especie> especies = new ArrayList<>();
		
		while(rs.next()) {
			Especie e = new Especie();
			e.setId(rs.getInt("id"));
			e.setNome_especie(rs.getString("nome"));
			e.setDescricao(rs.getString("descricao"));
			
			especies.add(e);
		}
		
		return especies;
	}

	@Override
	public Especie buscar(Long id) throws Exception {
		String sql = "SELECT id, nome, descricao, tipo_animal_acronimo FROM especie WHERE id = ?";

		try(Connection conn = ConnectionFactory.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);){
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				Especie e = new Especie();
				e.setId(rs.getInt("id"));
				e.setNome_especie(rs.getString("nome"));
				e.setDescricao(rs.getString("descricao"));
				
				return e;
			}
			return null;
		}
	}

	@Override
	public Especie remover(Long id) throws Exception {
		Especie especieToRemove = buscar(id);
		if (especieToRemove == null)
			return null;

		String sql = "delete from especie where ID = ?";

		try (Connection conn = ConnectionFactory.getConnection(); 
				PreparedStatement ps = conn.prepareStatement(sql);) {
			ps.setLong(1, id);
			ps.execute();
			return especieToRemove;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void atualizar(Especie objeto) throws Exception {
		
	}

	@Override
	public void persistir(Especie objeto) throws Exception {
		String sql = "insert into especie (nome, descricao, tipo_animal_acronimo) values(?, ?, ?)";

		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, objeto.getNome_especie());
			ps.setString(2, objeto.getDescricao());
			ps.setString(3, objeto.getTipo_Animal().getAcronimo());
			ps.execute();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
