package sistema.gui.administrativo;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import principal.Principal;

import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class FaturamentoDataPanel extends JPanel {
	/**
	 * Serial
	 */
	private static final long serialVersionUID = 6438381988056465402L;

	private JTextField valDataFaturamento1;
	private JTextField valDataFaturamento2;
	private JLabel valValorTotal;
	private final ButtonGroup diaFaturamentoGroup = new ButtonGroup();

	private JScrollPane scrollPane;
	private JRadioButton rdbtnFaturamentoAtual;
	private JRadioButton rdbtnBuscarPorData;
	private JButton btnBuscar;
	private JButton btnLimpar;
	private JRadioButton rdbtnIntervaloDatas;
	private JRadioButton rdbtnUmaData;

	private JTable tabelaVendasProduto;

	private Principal principal;
	private final ButtonGroup tipoBuscaGroup = new ButtonGroup();

	/**
	 * Create the panel.
	 */
	public FaturamentoDataPanel(Principal principal) {

		this.principal = principal;

		setLayout(null);

		JLabel titulo = new JLabel("Faturamento por data");
		titulo.setBounds(754, 56, 369, 37);
		titulo.setFont(new Font("Tahoma", Font.PLAIN, 30));
		add(titulo);

		JLabel dataFaturamento1 = new JLabel("Data de in\u00EDcio:");
		dataFaturamento1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		dataFaturamento1.setBounds(108, 235, 186, 44);
		add(dataFaturamento1);

		JLabel dataFaturamentoFormato = new JLabel("(dd/mm/aaaa)");
		dataFaturamentoFormato.setFont(new Font("Tahoma", Font.PLAIN, 20));
		dataFaturamentoFormato.setBounds(128, 267, 138, 31);
		add(dataFaturamentoFormato);

		valDataFaturamento1 = new JTextField();
		valDataFaturamento1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		valDataFaturamento1.setBounds(370, 236, 146, 44);
		valDataFaturamento1.setVisible(false);
		valDataFaturamento1.setEnabled(false);
		add(valDataFaturamento1);
		valDataFaturamento1.setColumns(10);

		JLabel dataFaturamento2 = new JLabel("Data do final:");
		dataFaturamento2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		dataFaturamento2.setBounds(108, 383, 203, 44);
		dataFaturamento2.setVisible(false);
		add(dataFaturamento2);

		JLabel dataFaturamentoFormato2 = new JLabel("(dd/mm/aaaa)");
		dataFaturamentoFormato2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		dataFaturamentoFormato2.setBounds(118, 417, 138, 31);
		dataFaturamentoFormato2.setVisible(false);
		add(dataFaturamentoFormato2);

		valDataFaturamento2 = new JTextField();
		valDataFaturamento2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		valDataFaturamento2.setBounds(370, 384, 146, 44);
		valDataFaturamento2.setVisible(false);
		valDataFaturamento2.setEnabled(false);
		add(valDataFaturamento2);
		valDataFaturamento2.setColumns(10);

		rdbtnFaturamentoAtual = new JRadioButton("Faturamento atual");
		diaFaturamentoGroup.add(rdbtnFaturamentoAtual);
		rdbtnFaturamentoAtual.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnFaturamentoAtual.setBounds(128, 323, 203, 29);
		add(rdbtnFaturamentoAtual);

		rdbtnBuscarPorData = new JRadioButton("Buscar por data");
		diaFaturamentoGroup.add(rdbtnBuscarPorData);
		rdbtnBuscarPorData.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnBuscarPorData.setBounds(370, 323, 174, 29);
		add(rdbtnBuscarPorData);

		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnBuscar.setBounds(286, 634, 166, 55);
		add(btnBuscar);

		btnLimpar = new JButton("Limpar");
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnLimpar.setBounds(517, 634, 166, 55);
		add(btnLimpar);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(989, 235, 761, 357);
		add(scrollPane);

		scrollPane.setViewportView(tabelaVendasProduto);

		JLabel valorTotal = new JLabel("Valor total:");
		valorTotal.setFont(new Font("Tahoma", Font.PLAIN, 25));
		valorTotal.setBounds(1236, 643, 166, 37);
		add(valorTotal);

		valValorTotal = new JLabel("R$ 0");
		valValorTotal.setFont(new Font("Tahoma", Font.PLAIN, 25));
		valValorTotal.setBounds(1464, 643, 197, 37);
		add(valValorTotal);

		JLabel tipoBusca = new JLabel("Tipo de busca:");
		tipoBusca.setFont(new Font("Tahoma", Font.PLAIN, 25));
		tipoBusca.setBounds(128, 472, 166, 43);
		add(tipoBusca);

		rdbtnUmaData = new JRadioButton("Um dia");
		tipoBuscaGroup.add(rdbtnUmaData);
		rdbtnUmaData.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnUmaData.setBounds(216, 527, 115, 29);
		add(rdbtnUmaData);

		rdbtnIntervaloDatas = new JRadioButton("Intervalo");
		tipoBuscaGroup.add(rdbtnIntervaloDatas);
		rdbtnIntervaloDatas.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnIntervaloDatas.setBounds(370, 527, 122, 29);
		add(rdbtnIntervaloDatas);			

		rdbtnFaturamentoAtual.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				valDataFaturamento1.setEnabled(false);
				valDataFaturamento1.setVisible(false);
			}
		});

		rdbtnBuscarPorData.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				valDataFaturamento1.setEnabled(true);
				valDataFaturamento1.setVisible(true);
			}
		});

		rdbtnUmaData.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dataFaturamento2.setVisible(false);
				dataFaturamentoFormato2.setVisible(false);
				valDataFaturamento2.setEnabled(false);
				valDataFaturamento2.setVisible(false);
			}
		});

		rdbtnIntervaloDatas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dataFaturamento2.setVisible(true);
				dataFaturamentoFormato2.setVisible(true);
				valDataFaturamento2.setEnabled(true);
				valDataFaturamento2.setVisible(true);
			}
		});

		btnLimpar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				limparCampos();                       
			}
		});

		btnBuscar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				buscar();                       
			}
		});
	}


	private void limparCampos() {

		valDataFaturamento1.setText("");
		valDataFaturamento2.setText("");
		valValorTotal.setText("R$ 0");

		tabelaVendasProduto = new JTable();
		scrollPane.setViewportView(tabelaVendasProduto);
	}

	private void buscar() {
		try {
			String dataFatur = this.valDataFaturamento1.getText();
			String dataFatur2 = this.valDataFaturamento2.getText();

			if (this.rdbtnFaturamentoAtual.isSelected()) {
				dataFatur = null;
			}
			else if (!this.rdbtnBuscarPorData.isSelected()) {
				throw new IllegalArgumentException("Selecione uma opção para data de inicio.");
			}
			
			if (this.rdbtnUmaData.isSelected()) {
				dataFatur2 = null;
			}
			else if (!this.rdbtnIntervaloDatas.isSelected()) {
				throw new IllegalArgumentException("Selecione uma opção para tipo de busca.");
			}

			if ((dataFatur != null && dataFatur.equals("")) || (dataFatur2 != null && dataFatur2.equals(""))) {
				throw new IllegalArgumentException("Campos passados vazios.");
			}

			if (rdbtnUmaData.isSelected()) {
				carregaTabelaUmFaturamento(dataFatur);
			}
			
			//this.valValorTotal.setText(this.principal.retornaValorDeVendasDeProduto(codProduto, dataFatur));

		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void carregaTabelaUmFaturamento(String dataFaturamento) {

		try {
			String [] colunas = {"Código", "Nome", "Quantidade", "Valor", "Desconto", "Funcionário", "Hora"};
			String [][] dados = this.principal.retornaDadosVendasDeUmFaturamento(dataFaturamento);

			tabelaVendasProduto = new JTable(dados, colunas);

			tabelaVendasProduto.setFont(new Font("Tahoma", Font.PLAIN, 20)); // Tamanho e tipo de letra.
			tabelaVendasProduto.setEnabled(false); // Evitando edição não desejada.
			tabelaVendasProduto.getColumnModel().getColumn(1).setPreferredWidth(210);
			tabelaVendasProduto.getColumnModel().getColumn(3).setPreferredWidth(100);
			tabelaVendasProduto.setBackground(SystemColor.info); // Cor da linha.
			tabelaVendasProduto.setRowHeight(30); // Aumentando altura das linhas.

			scrollPane.setViewportView(tabelaVendasProduto);
		}
		catch (Exception e) {
			throw e;
		}
	}
}
