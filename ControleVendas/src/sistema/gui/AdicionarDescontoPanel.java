package sistema.gui;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import principal.Principal;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class AdicionarDescontoPanel extends JPanel {

	private JTextField valCodigoDesconto;

	private Principal principal;
	private JanelaFrame frame;

	private JTable tableDescontos;
	private JTextField valValorDesconto;
	private JTextField valNomeDesconto;
	private JTextPane valDescricaoDesconto;
	private JRadioButton rdbBotaoPorcentagem;
	private JRadioButton rdbBotaoValor;
	private JScrollPane scrollPane;

	private final ButtonGroup buttonDescontoGroup = new ButtonGroup();

	/**
	 * Create the panel.
	 */
	public AdicionarDescontoPanel(Principal principal, JanelaFrame frame) {

		this.principal = principal;
		this.frame = frame;

		setLayout(null);

		JLabel titulo = new JLabel("Adicionar Desconto");
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setFont(new Font("Tahoma", Font.PLAIN, 30));
		titulo.setBounds(616, 16, 612, 222);
		add(titulo);

		JLabel codigoDesconto = new JLabel("C\u00F3digo para o desconto:");
		codigoDesconto.setFont(new Font("Tahoma", Font.PLAIN, 25));
		codigoDesconto.setBounds(66, 611, 277, 42);
		add(codigoDesconto);

		valCodigoDesconto = new JTextField();
		valCodigoDesconto.setFont(new Font("Tahoma", Font.PLAIN, 23));
		valCodigoDesconto.setColumns(10);
		valCodigoDesconto.setBounds(459, 612, 178, 43);
		add(valCodigoDesconto);

		JLabel nomeDesconto = new JLabel("Nome do desconto:");
		nomeDesconto.setFont(new Font("Tahoma", Font.PLAIN, 25));
		nomeDesconto.setBounds(66, 314, 347, 37);
		add(nomeDesconto);

		valNomeDesconto = new JTextField();
		valNomeDesconto.setFont(new Font("Tahoma", Font.PLAIN, 23));
		valNomeDesconto.setBounds(459, 315, 285, 37);
		add(valNomeDesconto);
		valNomeDesconto.setColumns(10);

		JLabel valorDesconto = new JLabel("Valor / Porcentagem Desconto:");
		valorDesconto.setFont(new Font("Tahoma", Font.PLAIN, 25));
		valorDesconto.setBounds(66, 365, 364, 56);
		add(valorDesconto);

		valValorDesconto = new JTextField();
		valValorDesconto.setFont(new Font("Tahoma", Font.PLAIN, 23));
		valValorDesconto.setBounds(459, 374, 137, 40);
		add(valValorDesconto);
		valValorDesconto.setColumns(10);

		JLabel descricaoDesconto = new JLabel("Descri\u00E7\u00E3o do desconto:");
		descricaoDesconto.setFont(new Font("Tahoma", Font.PLAIN, 25));
		descricaoDesconto.setBounds(66, 437, 347, 42);
		add(descricaoDesconto);

		valDescricaoDesconto = new JTextPane();
		valDescricaoDesconto.setFont(new Font("Tahoma", Font.PLAIN, 23));
		valDescricaoDesconto.setBounds(459, 438, 373, 130);
		add(valDescricaoDesconto);

		rdbBotaoPorcentagem = new JRadioButton("Porcentagem");
		buttonDescontoGroup.add(rdbBotaoPorcentagem);
		rdbBotaoPorcentagem.setFont(new Font("Tahoma", Font.PLAIN, 24));
		rdbBotaoPorcentagem.setBounds(396, 731, 178, 42);
		add(rdbBotaoPorcentagem);

		rdbBotaoValor = new JRadioButton("Valor");
		buttonDescontoGroup.add(rdbBotaoValor);
		rdbBotaoValor.setFont(new Font("Tahoma", Font.PLAIN, 24));
		rdbBotaoValor.setBounds(655, 731, 177, 42);
		add(rdbBotaoValor);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 23));
		btnSalvar.setBounds(372, 847, 125, 43);
		add(btnSalvar);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 23));
		btnLimpar.setBounds(655, 847, 125, 43);
		add(btnLimpar);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(941, 182, 622, 622);
		add(scrollPane);

		reloadTabelaDescontos();
		
		/*
		 * Ações dos botões.
		 */
		btnSalvar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cadastrarDesconto();
			}
		});
		
		btnLimpar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				limparCampos();                       
			}
		});



	}

	private void reloadTabelaDescontos() {
		
		try {
			String [] colunas = {"Descontos cadastrados"};
			String [][] dados = this.principal.retornaVetorToStringDescontos();
	
			tableDescontos = new JTable(dados, colunas);
	
			tableDescontos.setFont(new Font("Tahoma", Font.PLAIN, 20)); // Tamanho e tipo de letra.
			tableDescontos.setEnabled(false); // Evitando edição não desejada.
			tableDescontos.setBackground(SystemColor.info); // Cor da linha.
			tableDescontos.setRowHeight(30); // Aumentando altura das linhas.
	
			scrollPane.setViewportView(tableDescontos);
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}


	private void limparCampos() {

		valCodigoDesconto.setText("");
		valNomeDesconto.setText("");	
		valValorDesconto.setText("");
		valDescricaoDesconto.setText("");
	}

	private void cadastrarDesconto() {

		try {
			String codigoDesconto = valCodigoDesconto.getText();
			String nomeDesconto = valNomeDesconto.getText();
			double valorDesconto = Double.parseDouble(valValorDesconto.getText());
			String descricaoDesconto = valDescricaoDesconto.getText();
			
			// Verificando se botão de porcentagem foi selecionado.
			if (rdbBotaoPorcentagem.isSelected()) {
				this.principal.cadastrarDescontoPorcentagem(codigoDesconto, nomeDesconto, descricaoDesconto, valorDesconto);
			}
			else if (rdbBotaoValor.isSelected()) {
				this.principal.cadastrarDescontoValor(codigoDesconto, nomeDesconto, descricaoDesconto, valorDesconto);
			}
			else {
				throw new IllegalArgumentException("Tipo de desconto não selecionado.");
			}

			// Mensagem de sucesso.
			JOptionPane.showMessageDialog(null, "Desconto Cadastrado!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
			limparCampos();
			this.frame.reload();
			this.reloadTabelaDescontos();

		}
		// Mostrando erro.
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}
}
