package com.up.clinicavet.view;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import com.up.clinicavet.controller.ExibicaoAnimais;
import com.up.clinicavet.controller.ExibicaoEspecies;
import com.up.clinicavet.model.Animal;
import com.up.clinicavet.model.Especie;
import com.up.clinicavet.model.TipoAnimal;

public class ViewPrincipal extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JButton btnAnimais = new JButton("Animais");
	private JButton btnEspecies = new JButton("Espécies");
	private JPanel conteudoMenuPrincipal;
	
	private JPanel conteudoManutencaoAnimais;
	private JTable tabelaAnimais;
	private ExibicaoAnimais modeloExibicaoAnimaisTabela;
	private JButton btnVoltar = new JButton("Voltar");
	private JButton btnCadastrarAnimal = new JButton("Cadastrar");
	private JButton btnExcluirAnimal = new JButton("Excluir");
	
	private JPanel conteudoFormularioAnimais;
	private JLabel lblNomeAnimal = new JLabel("Nome do animal");
	private JLabel lblNascimentoAnimal = new JLabel("Nascimento do animal");
	private JLabel lblEspecieAnimal = new JLabel("Espécie do animal");
	private JTextField txtNomeAnimal = new JTextField();
	private JTextField txtNascimentoAnimal = new JTextField();
	private JComboBox<String> comboEspeciesAnimais = new JComboBox<>();
	private JButton btnSalvarAnimal = new JButton("Salvar");
	private JButton btnVoltarFormularioAnimal = new JButton("Voltar");
	
	private JPanel conteudoManutencaoEspecies;
	private JTable tabelaEspecies;
	private ExibicaoEspecies modeloExibicaoEspeciesTabela;
	private JButton btnVoltarEspecies = new JButton("Voltar");
	private JButton btnCadastrarEspecie = new JButton("Cadastrar");
	private JButton btnExcluirEspecie = new JButton("Excluir");
	
	private JPanel conteudoFormularioEspecies;
	private JLabel lblNomeEspecie = new JLabel("Nome da especie");
	private JLabel lblDescricaoEspecie = new JLabel("Descrição da espécie");
	private JLabel lblTipoAnimalAcronimo = new JLabel("Tipo espécie");
	private JTextField txtNomeEspecie = new JTextField();
	private JTextField txtDescricaoEspecie = new JTextField();
	private JComboBox<String> comboTipoAnimais = new JComboBox<>();
	private JButton btnSalvarEspecie = new JButton("Salvar");
	private JButton btnVoltarFormularioEspecie = new JButton("Voltar");
	
	public ViewPrincipal() {
		conteudoMenuPrincipal = new JPanel();
		SpringLayout layout = new SpringLayout();
		
		conteudoMenuPrincipal.setLayout(layout);
		conteudoMenuPrincipal.add(btnAnimais);
		conteudoMenuPrincipal.add(btnEspecies);
		
		layout.putConstraint(SpringLayout.WEST, btnAnimais, 5, SpringLayout.WEST, conteudoMenuPrincipal);
		layout.putConstraint(SpringLayout.NORTH, btnAnimais, 5, SpringLayout.NORTH, conteudoMenuPrincipal);
		layout.putConstraint(SpringLayout.WEST, btnEspecies, 5, SpringLayout.WEST, conteudoMenuPrincipal);
		layout.putConstraint(SpringLayout.NORTH, btnEspecies, 40, SpringLayout.NORTH, conteudoMenuPrincipal);
		 
		this.setTitle("Clínica Veterinária UP");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.exibirTelaInicial();
		
		InicializaLayoutManutencaoAnimais();
		InicializaFormularioAnimais();
		InicializaLayoutManutencaoEspecies();
		InicializaFormularioEspecies();
	}

	private void InicializaFormularioAnimais() {
		conteudoFormularioAnimais = new JPanel();
		
		SpringLayout layoutFormularioAnimais = new SpringLayout();
		conteudoFormularioAnimais.setLayout(layoutFormularioAnimais);
		
		conteudoFormularioAnimais.add(btnVoltarFormularioAnimal);
		conteudoFormularioAnimais.add(btnSalvarAnimal);
		
		conteudoFormularioAnimais.add(lblNomeAnimal);
		conteudoFormularioAnimais.add(lblNascimentoAnimal);
		conteudoFormularioAnimais.add(lblEspecieAnimal);	
		
		conteudoFormularioAnimais.add(txtNomeAnimal);
		conteudoFormularioAnimais.add(txtNascimentoAnimal);
		conteudoFormularioAnimais.add(comboEspeciesAnimais);	
		
		layoutFormularioAnimais.putConstraint(SpringLayout.WEST, lblNomeAnimal, 5, SpringLayout.WEST,
				conteudoFormularioAnimais);
		layoutFormularioAnimais.putConstraint(SpringLayout.WEST, lblNascimentoAnimal, 5, SpringLayout.WEST,
				conteudoFormularioAnimais);
		layoutFormularioAnimais.putConstraint(SpringLayout.WEST, lblEspecieAnimal, 5, SpringLayout.WEST,
				conteudoFormularioAnimais);
		layoutFormularioAnimais.putConstraint(SpringLayout.NORTH, lblNomeAnimal, 5, SpringLayout.NORTH,
				conteudoFormularioAnimais);
		layoutFormularioAnimais.putConstraint(SpringLayout.NORTH, lblNascimentoAnimal, 40, SpringLayout.NORTH,
				conteudoFormularioAnimais);
		layoutFormularioAnimais.putConstraint(SpringLayout.NORTH, lblEspecieAnimal, 80, SpringLayout.NORTH,
				conteudoFormularioAnimais);
		
		layoutFormularioAnimais.putConstraint(SpringLayout.WEST, txtNomeAnimal, 5, SpringLayout.WEST,
				conteudoFormularioAnimais);
		layoutFormularioAnimais.putConstraint(SpringLayout.EAST, txtNomeAnimal, -200, SpringLayout.EAST,
				conteudoFormularioAnimais);
		layoutFormularioAnimais.putConstraint(SpringLayout.NORTH, txtNomeAnimal, 20, SpringLayout.NORTH,
				conteudoFormularioAnimais);
		layoutFormularioAnimais.putConstraint(SpringLayout.WEST, txtNascimentoAnimal, 5, SpringLayout.WEST,
				conteudoFormularioAnimais);
		layoutFormularioAnimais.putConstraint(SpringLayout.EAST, txtNascimentoAnimal, -200, SpringLayout.EAST,
				conteudoFormularioAnimais);
		layoutFormularioAnimais.putConstraint(SpringLayout.NORTH, txtNascimentoAnimal, 60, SpringLayout.NORTH,
				conteudoFormularioAnimais);
		layoutFormularioAnimais.putConstraint(SpringLayout.WEST, comboEspeciesAnimais, 5, SpringLayout.WEST,
				conteudoFormularioAnimais);
		layoutFormularioAnimais.putConstraint(SpringLayout.EAST, comboEspeciesAnimais, -200, SpringLayout.EAST,
				conteudoFormularioAnimais);
		layoutFormularioAnimais.putConstraint(SpringLayout.NORTH, comboEspeciesAnimais, 100, SpringLayout.NORTH,
				conteudoFormularioAnimais);

		layoutFormularioAnimais.putConstraint(SpringLayout.NORTH, btnSalvarAnimal, 140, SpringLayout.NORTH,
				conteudoFormularioAnimais);
		layoutFormularioAnimais.putConstraint(SpringLayout.WEST, btnSalvarAnimal, 80, SpringLayout.WEST,
				conteudoFormularioAnimais);
		layoutFormularioAnimais.putConstraint(SpringLayout.NORTH, btnVoltarFormularioAnimal, 140, SpringLayout.NORTH,
				conteudoFormularioAnimais);	
	}

	private void InicializaLayoutManutencaoAnimais() {
		modeloExibicaoAnimaisTabela = new ExibicaoAnimais();
		tabelaAnimais = new JTable(modeloExibicaoAnimaisTabela);
		conteudoManutencaoAnimais = new JPanel();
		
		SpringLayout layoutManutencaoAnimais = new SpringLayout();
		conteudoManutencaoAnimais.setLayout(layoutManutencaoAnimais);
		conteudoManutencaoAnimais.add(tabelaAnimais);
		conteudoManutencaoAnimais.add(btnVoltar);
		conteudoManutencaoAnimais.add(btnExcluirAnimal);
		conteudoManutencaoAnimais.add(btnCadastrarAnimal);
		
		layoutManutencaoAnimais.putConstraint(SpringLayout.WEST, tabelaAnimais, 5, SpringLayout.WEST,
				conteudoManutencaoAnimais);
		layoutManutencaoAnimais.putConstraint(SpringLayout.WEST, btnVoltar, 350, SpringLayout.WEST,
				conteudoManutencaoAnimais);
		layoutManutencaoAnimais.putConstraint(SpringLayout.NORTH, btnVoltar, 100, SpringLayout.NORTH,
				conteudoManutencaoAnimais);
		layoutManutencaoAnimais.putConstraint(SpringLayout.WEST, btnExcluirAnimal, 350, SpringLayout.WEST,
				conteudoManutencaoAnimais);
		layoutManutencaoAnimais.putConstraint(SpringLayout.NORTH, btnExcluirAnimal, 40, SpringLayout.NORTH,
				conteudoManutencaoAnimais);
		layoutManutencaoAnimais.putConstraint(SpringLayout.WEST, btnCadastrarAnimal, 350, SpringLayout.WEST,
				conteudoManutencaoAnimais);
		layoutManutencaoAnimais.putConstraint(SpringLayout.NORTH, btnCadastrarAnimal, 10, SpringLayout.NORTH,
				conteudoManutencaoAnimais);
	}

	private void InicializaLayoutManutencaoEspecies() {
		modeloExibicaoEspeciesTabela = new ExibicaoEspecies();
		tabelaEspecies = new JTable(modeloExibicaoEspeciesTabela);
		conteudoManutencaoEspecies = new JPanel();
		
		SpringLayout layoutManutencaoEspecies = new SpringLayout();
		conteudoManutencaoEspecies.setLayout(layoutManutencaoEspecies);
		conteudoManutencaoEspecies.add(tabelaEspecies);
		conteudoManutencaoEspecies.add(btnVoltarEspecies);
		conteudoManutencaoEspecies.add(btnExcluirEspecie);
		conteudoManutencaoEspecies.add(btnCadastrarEspecie);
		
		layoutManutencaoEspecies.putConstraint(SpringLayout.WEST, tabelaEspecies, 5, SpringLayout.WEST,
				conteudoManutencaoEspecies);
		layoutManutencaoEspecies.putConstraint(SpringLayout.WEST, btnVoltarEspecies, 350, SpringLayout.WEST,
				conteudoManutencaoEspecies);
		layoutManutencaoEspecies.putConstraint(SpringLayout.NORTH, btnVoltarEspecies, 100, SpringLayout.NORTH,
				conteudoManutencaoEspecies);
		layoutManutencaoEspecies.putConstraint(SpringLayout.WEST, btnExcluirEspecie, 350, SpringLayout.WEST,
				conteudoManutencaoEspecies);
		layoutManutencaoEspecies.putConstraint(SpringLayout.NORTH, btnExcluirEspecie, 40, SpringLayout.NORTH,
				conteudoManutencaoEspecies);
		layoutManutencaoEspecies.putConstraint(SpringLayout.WEST, btnCadastrarEspecie, 350, SpringLayout.WEST,
				conteudoManutencaoEspecies);
		layoutManutencaoEspecies.putConstraint(SpringLayout.NORTH, btnCadastrarEspecie, 10, SpringLayout.NORTH,
				conteudoManutencaoEspecies);
	}
	
	private void InicializaFormularioEspecies() {
		conteudoFormularioEspecies = new JPanel();
		
		SpringLayout layoutFormularioEspecies = new SpringLayout();
		conteudoFormularioEspecies.setLayout(layoutFormularioEspecies);
		
		conteudoFormularioEspecies.add(btnVoltarFormularioEspecie);
		conteudoFormularioEspecies.add(btnSalvarEspecie);
		
		conteudoFormularioEspecies.add(lblNomeEspecie);
		conteudoFormularioEspecies.add(lblDescricaoEspecie);
		conteudoFormularioEspecies.add(lblTipoAnimalAcronimo);	
		
		conteudoFormularioEspecies.add(txtNomeEspecie);
		conteudoFormularioEspecies.add(txtDescricaoEspecie);
		conteudoFormularioEspecies.add(comboTipoAnimais);	
		
		layoutFormularioEspecies.putConstraint(SpringLayout.WEST, lblNomeEspecie, 5, SpringLayout.WEST,
				conteudoFormularioEspecies);
		layoutFormularioEspecies.putConstraint(SpringLayout.WEST, lblDescricaoEspecie, 5, SpringLayout.WEST,
				conteudoFormularioEspecies);
		layoutFormularioEspecies.putConstraint(SpringLayout.WEST, lblTipoAnimalAcronimo, 5, SpringLayout.WEST,
				conteudoFormularioEspecies);
		layoutFormularioEspecies.putConstraint(SpringLayout.NORTH, lblNomeEspecie, 5, SpringLayout.NORTH,
				conteudoFormularioEspecies);
		layoutFormularioEspecies.putConstraint(SpringLayout.NORTH, lblDescricaoEspecie, 40, SpringLayout.NORTH,
				conteudoFormularioEspecies);
		layoutFormularioEspecies.putConstraint(SpringLayout.NORTH, lblTipoAnimalAcronimo, 80, SpringLayout.NORTH,
				conteudoFormularioEspecies);
		
		layoutFormularioEspecies.putConstraint(SpringLayout.WEST, txtNomeEspecie, 5, SpringLayout.WEST,
				conteudoFormularioEspecies);
		layoutFormularioEspecies.putConstraint(SpringLayout.EAST, txtNomeEspecie, -200, SpringLayout.EAST,
				conteudoFormularioEspecies);
		layoutFormularioEspecies.putConstraint(SpringLayout.NORTH, txtNomeEspecie, 20, SpringLayout.NORTH,
				conteudoFormularioEspecies);
		layoutFormularioEspecies.putConstraint(SpringLayout.WEST, txtDescricaoEspecie, 5, SpringLayout.WEST,
				conteudoFormularioEspecies);
		layoutFormularioEspecies.putConstraint(SpringLayout.EAST, txtDescricaoEspecie, -200, SpringLayout.EAST,
				conteudoFormularioEspecies);
		layoutFormularioEspecies.putConstraint(SpringLayout.NORTH, txtDescricaoEspecie, 60, SpringLayout.NORTH,
				conteudoFormularioEspecies);
		layoutFormularioEspecies.putConstraint(SpringLayout.WEST, comboTipoAnimais, 5, SpringLayout.WEST,
				conteudoFormularioEspecies);
		layoutFormularioEspecies.putConstraint(SpringLayout.EAST, comboTipoAnimais, -200, SpringLayout.EAST,
				conteudoFormularioEspecies);
		layoutFormularioEspecies.putConstraint(SpringLayout.NORTH, comboTipoAnimais, 100, SpringLayout.NORTH,
				conteudoFormularioEspecies);

		layoutFormularioEspecies.putConstraint(SpringLayout.NORTH, btnSalvarEspecie, 140, SpringLayout.NORTH,
				conteudoFormularioEspecies);
		layoutFormularioEspecies.putConstraint(SpringLayout.WEST, btnSalvarEspecie, 80, SpringLayout.WEST,
				conteudoFormularioEspecies);
		layoutFormularioEspecies.putConstraint(SpringLayout.NORTH, btnVoltarFormularioEspecie, 140, SpringLayout.NORTH,
				conteudoFormularioEspecies);	
	}
	
	public void exibirTelaInicial() {
		this.setSize(new Dimension(600, 600));
		this.setContentPane(conteudoMenuPrincipal);
	}
	
	public void showError(String errMessage) {
		 JOptionPane.showMessageDialog(this, errMessage);
	}
	
	public void addBtnAnimaisListener(ActionListener animaisListener) {
		btnAnimais.addActionListener(animaisListener);
	}
	
	public void addBtnEspeciesListener(ActionListener especiesListener) {
		btnEspecies.addActionListener(especiesListener);
	}
	
	public void addBtnVoltarFormularioAnimaisListener(ActionListener animaisListener) {
		btnVoltarFormularioAnimal.addActionListener(animaisListener);
	}
	
	public void setJComboEspeciesValues(Map<Integer, String> values) {
		comboEspeciesAnimais.removeAllItems();		
		for (Entry<Integer, String> entry : values.entrySet()) {
			comboEspeciesAnimais.addItem(entry.getKey() + " - " + entry.getValue());
		}
	}
	
	public void setJComboTipoAnimalValues(List<String> values) {
		comboTipoAnimais.removeAllItems();
		for (String v : values) {
			comboTipoAnimais.addItem(v);
		}
	}
	
	public void exibirTelaAnimais(List<Animal> animaisParaExibir) {
		modeloExibicaoAnimaisTabela.setAnimaisTabela(animaisParaExibir);
		this.setPreferredSize(new Dimension(600, 600));
		this.setContentPane(conteudoManutencaoAnimais);
		this.pack();
	}
	
	public void exibirTelaEspecies(List<Especie> especies) {
		modeloExibicaoEspeciesTabela.setAnimaisTabela(especies);
		this.setPreferredSize(new Dimension(600, 600));
		this.setContentPane(conteudoManutencaoEspecies);
		this.pack();
	}
	
	public void exibirCadastroAnimais() {
		this.setPreferredSize(new Dimension(600, 600));
		this.setContentPane(conteudoFormularioAnimais);
		this.pack();
	}
	
	public void exibirCadastroEspecies() {
		this.setPreferredSize(new Dimension(600, 600));
		this.setContentPane(conteudoFormularioEspecies);
		this.pack();
	}
	
	public boolean confirmaExclusao() {
		int dialogButton = JOptionPane.YES_NO_OPTION;
		int dialogResult = JOptionPane.showConfirmDialog(null,
				"Você deseja realmente excluir o item?","Cuidado!", dialogButton);
		return dialogResult == JOptionPane.YES_OPTION;
	}
	
	public long pegarIdDoAnimalSelecionado() {
		int linhaSelecionada = tabelaAnimais.getSelectedRow();
		Integer idAnimal = (Integer) tabelaAnimais.getValueAt(linhaSelecionada, 0);
		
		return new Long(idAnimal).longValue();
	}
	
	public Animal carregaAnimalDoFormulario() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String currentEspecie = (String) comboEspeciesAnimais.getSelectedItem();
		int especieId = Integer.parseInt(currentEspecie.substring(0, 1));
		
		Animal m = new Animal();
		m.setNome(txtNomeAnimal.getText());
		m.setNascimento(sdf.parse(txtNascimentoAnimal.getText()));
		m.setEspecie(new Especie(especieId));
		
		limparCamposFormularioAnimais();
	
		return m;
	}
	
	public Especie carregaEspecieDoFormulario() {
		String currentTipoAnimal = (String) comboTipoAnimais.getSelectedItem();
		
		Especie especie = new Especie();
		especie.setNome_especie(txtNomeEspecie.getText());
		especie.setDescricao(txtDescricaoEspecie.getText());
		especie.setTipo_Animal(new TipoAnimal(currentTipoAnimal));
		
		limparCamposFormularioEspecies();
	
		return especie;
	}

	private void limparCamposFormularioAnimais() {
		txtNomeAnimal.setText("");
		txtNascimentoAnimal.setText("");
	}
	
	private void limparCamposFormularioEspecies() {
		txtNomeEspecie.setText("");
		txtDescricaoEspecie.setText("");
	}
	
	
	public long pegarIdDaEspecieSelecionada() {
		int linhaSelecionada = tabelaEspecies.getSelectedRow();
		Integer idAnimal = (Integer) tabelaEspecies.getValueAt(linhaSelecionada, 0);
		
		return new Long(idAnimal).longValue();
	}

	public void addBtnSalvarAnimalListener(ActionListener salvarListener) {
		btnSalvarAnimal.addActionListener(salvarListener);
	}
	
	public void addBtnCadastrarAnimalListener(ActionListener cadastrarListener) {
		btnCadastrarAnimal.addActionListener(cadastrarListener);
	}
	
	public void addBtnExcluirAnimalListener(ActionListener excluirListener) {
		btnExcluirAnimal.addActionListener(excluirListener);
	}
	
	public void addBtnVoltarListener(ActionListener voltarListener) {
		btnVoltar.addActionListener(voltarListener);
	}
	
	public void addBtnVoltarEspeciesListener(ActionListener voltarListener) {
		btnVoltarEspecies.addActionListener(voltarListener);
	}
	
	public void addBtnExcluirEspecieListener(ActionListener listener) {
		btnExcluirEspecie.addActionListener(listener);
	}
	
	public void addBtnCadastrarEspecieListener(ActionListener listener) {
		btnCadastrarEspecie.addActionListener(listener);
	}
	
	public void addBtnSalvarEspecieListener(ActionListener listener) {
		btnSalvarEspecie.addActionListener(listener);
	}
	
	public void addBtnVoltarFormularioEspeciesListener(ActionListener listener) {
		btnVoltarFormularioEspecie.addActionListener(listener);
	}
}
