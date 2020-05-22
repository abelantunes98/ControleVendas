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

public class FaturamentoProdutoPanel extends JPanel {
	/**
	 * Serial
	 */
	private static final long serialVersionUID = 6438381988056465402L;

	private JTextField valCodigoProduto;
	private JTextField valDataFaturamento;
	private JLabel valValorTotal;
	private final ButtonGroup DiaFaturamentoGroup = new ButtonGroup();

	private JScrollPane scrollPane;
	private JRadioButton rdbtnFaturamentoAtual;
	private JRadioButton rdbtnBuscarPorData;
	private JButton btnBuscar;
	private JButton btnLimpar;

	private JTable tabelaVendasProduto;

	private Principal principal;

	/**
	 * Create the panel.
	 */
	public FaturamentoProdutoPanel(Principal principal) {

		this.principal = principal;

		setLayout(null);

		JLabel titulo = new JLabel("Faturamento de mesa");
		titulo.setBounds(754, 56, 369, 37);
		titulo.setFont(new Font("Tahoma", Font.PLAIN, 30));
		add(titulo);

		JLabel codigoProduto = new JLabel("C\u00F3digo do produto:");
		codigoProduto.setFont(new Font("Tahoma", Font.PLAIN, 25));
		codigoProduto.setBounds(108, 235, 266, 44);
		add(codigoProduto);

		valCodigoProduto = new JTextField();
		valCodigoProduto.setFont(new Font("Tahoma", Font.PLAIN, 25));
		valCodigoProduto.setBounds(461, 236, 146, 44);
		add(valCodigoProduto);
		valCodigoProduto.setColumns(10);

		JLabel dataFaturamento = new JLabel("Data do faturamento:");
		dataFaturamento.setFont(new Font("Tahoma", Font.PLAIN, 25));
		dataFaturamento.setBounds(108, 314, 266, 44);
		dataFaturamento.setVisible(false);
		add(dataFaturamento);

		JLabel dataFaturamentoFormato = new JLabel("(dd/mm/aaaa)");
		dataFaturamentoFormato.setFont(new Font("Tahoma", Font.PLAIN, 20));
		dataFaturamentoFormato.setBounds(146, 348, 156, 31);
		dataFaturamentoFormato.setVisible(false);
		add(dataFaturamentoFormato);

		valDataFaturamento = new JTextField();
		valDataFaturamento.setFont(new Font("Tahoma", Font.PLAIN, 25));
		valDataFaturamento.setBounds(461, 315, 146, 44);
		valDataFaturamento.setVisible(false);
		valDataFaturamento.setEnabled(false);
		add(valDataFaturamento);
		valDataFaturamento.setColumns(10);

		JLabel diaDoFaturamento = new JLabel("Dia do faturamento:");
		diaDoFaturamento.setFont(new Font("Tahoma", Font.PLAIN, 25));
		diaDoFaturamento.setBounds(108, 508, 246, 44);
		add(diaDoFaturamento);

		rdbtnFaturamentoAtual = new JRadioButton("Faturamento atual");
		DiaFaturamentoGroup.add(rdbtnFaturamentoAtual);
		rdbtnFaturamentoAtual.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnFaturamentoAtual.setBounds(219, 563, 203, 29);
		add(rdbtnFaturamentoAtual);

		rdbtnBuscarPorData = new JRadioButton("Buscar por data");
		DiaFaturamentoGroup.add(rdbtnBuscarPorData);
		rdbtnBuscarPorData.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnBuscarPorData.setBounds(445, 563, 174, 29);
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
		scrollPane.setBounds(995, 235, 755, 357);
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


		rdbtnFaturamentoAtual.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dataFaturamento.setVisible(false);
				dataFaturamentoFormato.setVisible(false);
				valDataFaturamento.setEnabled(false);
				valDataFaturamento.setVisible(false);
			}
		});

		rdbtnBuscarPorData.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dataFaturamento.setVisible(true);
				dataFaturamentoFormato.setVisible(true);
				valDataFaturamento.setEnabled(true);
				valDataFaturamento.setVisible(true);
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

		valCodigoProduto.setText("");
		valDataFaturamento.setText("");
		valValorTotal.setText("R$ 0");
		
		tabelaVendasProduto = new JTable();
		scrollPane.setViewportView(tabelaVendasProduto);
	}
	
	private void buscar() {
		try {
			String codProduto = this.valCodigoProduto.getText();
			String dataFatur = this.valDataFaturamento.getText();
			
			if (this.rdbtnFaturamentoAtual.isSelected()) {
				dataFatur = null;
			}
			else if (!this.rdbtnBuscarPorData.isSelected()) {
				throw new IllegalArgumentException("Selecione o dia do faturamento.");
			}
			
			if (codProduto.equals("") || (dataFatur != null && dataFatur.equals(""))) {
				throw new IllegalArgumentException("Campos passados vazios.");
			}
			
			//Evitando mensagens repetidas.
			carregaTabelaVendasProduto(codProduto, dataFatur);
			this.valValorTotal.setText(this.principal.retornaValorDeVendasDeProduto(codProduto, dataFatur));
			
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void carregaTabelaVendasProduto(String codigoProduto, String dataFaturamento) {

		try {
			String [] colunas = {"ID", "Produto", "Nome", "Quantidade", "Valor", "Desconto", "Funcionário", "Hora"};
			String [][] dados = this.principal.retornaVendasDeProduto(codigoProduto, dataFaturamento);

			tabelaVendasProduto = new JTable(dados, colunas);

			tabelaVendasProduto.setFont(new Font("Tahoma", Font.PLAIN, 20)); // Tamanho e tipo de letra.
			tabelaVendasProduto.setEnabled(false); // Evitando edição não desejada.
			tabelaVendasProduto.getColumnModel().getColumn(2).setPreferredWidth(200);
			tabelaVendasProduto.getColumnModel().getColumn(4).setPreferredWidth(100);
			tabelaVendasProduto.getColumnModel().getColumn(7).setPreferredWidth(100);
			tabelaVendasProduto.setBackground(SystemColor.info); // Cor da linha.
			tabelaVendasProduto.setRowHeight(30); // Aumentando altura das linhas.

			scrollPane.setViewportView(tabelaVendasProduto);
		}
		catch (Exception e) {
			throw e;
		}
	}

}
