package com.up.clinicavet.controller;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.up.clinicavet.model.Especie;

public class ExibicaoEspecies extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	private static final int NUM_COLUNAS_ESPECIE = 3;
	private List<Especie> especiesTabela;

	public ExibicaoEspecies() {
	}

	public ExibicaoEspecies(List<Especie> especies) {
		especiesTabela = especies;
	}

	public List<Especie> getAnimaisTabela() {
		return especiesTabela;
	}

	public void setAnimaisTabela(List<Especie> especies) {
		this.especiesTabela = especies;
	}

	@Override
	public int getColumnCount() {
		return NUM_COLUNAS_ESPECIE;
	}

	@Override
	public int getRowCount() {
		if (especiesTabela != null)
			return especiesTabela.size();
		return 0;
	}

	@Override
	public String getColumnName(int coluna) {
		switch (coluna) {
		case 0:
			return "Identificador";
		case 1:
			return "Nome";
		case 2:
			return "Descrição";
		default:
			throw new RuntimeException("Solicitada uma coluna no JTable que não existe");
		}
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
		switch (coluna) {
		case 0:
			return especiesTabela.get(linha).getId();
		case 1:
			return especiesTabela.get(linha).getNome_especie();
		case 2:
			return especiesTabela.get(linha).getDescricao();
		default:
			throw new RuntimeException("Solicitada uma coluna no JTable que não existe");
		}
	}

}
