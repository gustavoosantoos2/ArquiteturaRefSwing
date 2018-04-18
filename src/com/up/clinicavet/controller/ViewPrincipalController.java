package com.up.clinicavet.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.w3c.dom.ranges.RangeException;

import com.up.clinicavet.model.Animal;
import com.up.clinicavet.model.AnimalDAO;
import com.up.clinicavet.model.Especie;
import com.up.clinicavet.model.EspecieDAO;
import com.up.clinicavet.model.TipoAnimal;
import com.up.clinicavet.model.TipoAnimalDAO;
import com.up.clinicavet.view.ViewPrincipal;

public class ViewPrincipalController {
	private ViewPrincipal view;
	private AnimalDAO animalDAO = new AnimalDAO();
	private EspecieDAO especieDAO = new EspecieDAO();
	private TipoAnimalDAO tipoAnimalDao = new TipoAnimalDAO();

	public ViewPrincipalController(ViewPrincipal view) {
		this.view = view;
		this.view.addBtnAnimaisListener(new BtnAnimaisListener());
		this.view.addBtnVoltarListener(new BtnVoltarListener());
		this.view.addBtnExcluirAnimalListener(new BtnExcluirAnimalListener());
		this.view.addBtnCadastrarAnimalListener(new BtnCadastrarAnimaisListener());
		this.view.addBtnVoltarFormularioAnimaisListener(new BtnVoltarListener());
		this.view.addBtnSalvarAnimalListener(new BtnSalvarAnimalListener());
		this.view.addBtnEspeciesListener(new BtnEspeciesListener());
		this.view.addBtnVoltarEspeciesListener(new BtnVoltarListener());
		this.view.addBtnExcluirEspecieListener(new BtnExcluirEspecieListener());
		this.view.addBtnCadastrarEspecieListener(new BtnCadastrarEspecieListener());
		this.view.addBtnSalvarEspecieListener(new BtnSalvarEspecieListener());
		this.view.addBtnVoltarFormularioAnimaisListener(new BtnVoltarListener());
	}
	
	

	private class BtnCadastrarAnimaisListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				Map<Integer, String> especies = especieDAO.listar()
						.stream().collect(Collectors.toMap(Especie::getId, Especie::getNome_especie));
				
				view.setJComboEspeciesValues(especies);
				view.exibirCadastroAnimais();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		
	}
	
	private class BtnSalvarAnimalListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				Animal m = view.carregaAnimalDoFormulario();
				animalDAO.persistir(m);
				view.exibirTelaAnimais(animalDAO.listar());
			} catch (Exception e1) {
				throw new RuntimeException(e1);
			}
		}
		
	}
	
	private class BtnAnimaisListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				List<Animal> animais = animalDAO.listar();
				view.exibirTelaAnimais(animais);
			} catch (Exception ex) {
				throw new RuntimeException(ex);
			}
		}
	}

	private class BtnExcluirAnimalListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				if (view.confirmaExclusao() == false)
					return;

				animalDAO.remover(view.pegarIdDoAnimalSelecionado());
				view.exibirTelaInicial();
			} catch (Exception ex) {
				throw new RuntimeException(ex);
			}
		}

	}

	private class BtnVoltarListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			view.exibirTelaInicial();
		}

	}
	
	private class BtnEspeciesListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				view.exibirTelaEspecies(especieDAO.listar());
			} catch (Exception e1) {
				throw new RuntimeException(e1);
			}
		}
		
	}
	
	private class BtnExcluirEspecieListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if (view.confirmaExclusao()) {
				try {
					especieDAO.remover(view.pegarIdDaEspecieSelecionada());
					view.exibirTelaInicial();
				} catch (SQLIntegrityConstraintViolationException ex) {
					view.showError("Existem animais dependentes dessa espécie. Delete os animais dessa espécie antes.");
				} catch (Exception e1) {
					throw new RuntimeException(e1);
				}
			}
		}
	}
	
	private class BtnCadastrarEspecieListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			List<String> especies;
			try {
				especies = tipoAnimalDao.listar()
						.stream().map(TipoAnimal::getAcronimo).collect(Collectors.toList());

				view.setJComboTipoAnimalValues(especies);
				view.exibirCadastroEspecies();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			
		}
	}
	
	private class BtnSalvarEspecieListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				Especie m = view.carregaEspecieDoFormulario();
				especieDAO.persistir(m);
				view.exibirTelaEspecies(especieDAO.listar());
			} catch (Exception e1) {
				throw new RuntimeException(e1);
			}
		}
		
	}
}
