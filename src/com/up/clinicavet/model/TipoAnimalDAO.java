package com.up.clinicavet.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TipoAnimalDAO {

	public List<TipoAnimal> listar() throws SQLException {
		Connection con = ConnectionFactory.getConnection();
		String sql = "SELECT acronimo, nome, descricao FROM TIPO_ANIMAL";
		PreparedStatement statement = con.prepareStatement(sql);
		ResultSet rs = statement.executeQuery();
		
		List<TipoAnimal> tipos = new ArrayList<>();
		
		while(rs.next()) {
			TipoAnimal tipoAnimal = new TipoAnimal();
			tipoAnimal.setAcronimo(rs.getString("acronimo"));
			tipoAnimal.setDescricao(rs.getString("descricao"));
			tipoAnimal.setNome_tipoAnimal(rs.getString("nome"));
			
			tipos.add(tipoAnimal);
		}
		
		return tipos;
	}
}
