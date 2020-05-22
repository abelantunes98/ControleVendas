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

public class FaturamentoFuncionarioPanel extends JPanel {
	/**
	 * Serial
	 */
	private static final long serialVersionUID = 6438381988056465402L;

	private JTextField valCodigoFuncionario;
	private JTextField valDataFaturamento;
	private JLabel valValorTotal;
	private final ButtonGroup DiaFaturamentoGroup = new ButtonGroup();

	private JScrollPane scrollPane;
	private JRadioButton rdbtnFaturamentoAtual;
	private JRadioButton rdbtnBuscarPorData;
	private JButton btnBuscar;
	private JButton btnLimpar;

	private JTable tabelaVendasFuncionario;
	private JLabel porcentagemFuncionario;
	private JTextField valPorcentagemFuncionario;
	private JLabel valorFuncionario;
	private JLabel valValorFuncionario;

	private Principal principal;

	/**
	 * Create the panel.
	 */
	public FaturamentoFuncionarioPanel(Principal principal) {

		this.principal = principal;

		setLayout(null);

		JLabel titulo = new JLabel("Faturamento de funcion\u00E1rio");
		titulo.setBounds(754, 56, 369, 37);
		titulo.setFont(new Font("Tahoma", Font.PLAIN, 30));
		add(titulo);

		JLabel codigoFunionario = new JLabel("C\u00F3digo do funcion\u00E1rio:");
		codigoFunionario.setFont(new Font("Tahoma", Font.PLAIN, 25));
		codigoFunionario.setBounds(108, 235, 266, 44);
		add(codigoFunionario);

		valCodigoFuncionario = new JTextField();
		valCodigoFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 25));
		valCodigoFuncionario.setBounds(461, 236, 146, 44);
		add(valCodigoFuncionario);
		valCodigoFuncionario.setColumns(10);

		porcentagemFuncionario = new JLabel("Porcentagem do funcion\u00E1rio:");
		porcentagemFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 25));
		porcentagemFuncionario.setBounds(108, 304, 328, 51);
		add(porcentagemFuncionario);

		valPorcentagemFuncionario = new JTextField();
		valPorcentagemFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 25));
		valPorcentagemFuncionario.setBounds(461, 308, 146, 44);
		add(valPorcentagemFuncionario);
		valPorcentagemFuncionario.setColumns(10);

		JLabel dataFaturamento = new JLabel("Data do faturamento:");
		dataFaturamento.setFont(new Font("Tahoma", Font.PLAIN, 25));
		dataFaturamento.setBounds(108, 393, 266, 44);
		dataFaturamento.setVisible(false);
		add(dataFaturamento);

		JLabel dataFaturamentoFormato = new JLabel("(dd/mm/aaaa)");
		dataFaturamentoFormato.setFont(new Font("Tahoma", Font.PLAIN, 20));
		dataFaturamentoFormato.setBounds(158, 428, 156, 31);
		dataFaturamentoFormato.setVisible(false);
		add(dataFaturamentoFormato);

		valDataFaturamento = new JTextField();
		valDataFaturamento.setFont(new Font("Tahoma", Font.PLAIN, 25));
		valDataFaturamento.setBounds(461, 394, 146, 44);
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
		scrollPane.setBounds(984, 235, 766, 357);
		add(scrollPane);

		scrollPane.setViewportView(tabelaVendasFuncionario);

		JLabel valorTotal = new JLabel("Valor total:");
		valorTotal.setFont(new Font("Tahoma", Font.PLAIN, 25));
		valorTotal.setBounds(1236, 643, 166, 37);
		add(valorTotal);

		valValorTotal = new JLabel("R$ 0");
		valValorTotal.setFont(new Font("Tahoma", Font.PLAIN, 25));
		valValorTotal.setBounds(1464, 643, 197, 37);
		add(valValorTotal);

		valorFuncionario = new JLabel("Valor funcion\u00E1rio:");
		valorFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 25));
		valorFuncionario.setBounds(1236, 716, 227, 44);
		add(valorFuncionario);

		valValorFuncionario = new JLabel("R$ 0");
		valValorFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 25));
		valValorFuncionario.setBounds(1464, 716, 203, 44);
		add(valValorFuncionario);


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

		valCodigoFuncionario.setText("");
		valDataFaturamento.setText("");
		valPorcentagemFuncionario.setText("");
		valValorTotal.setText("R$ 0");
		valValorFuncionario.setText("R$ 0");
		
		tabelaVendasFuncionario = new JTable();
		scrollPane.setViewportView(tabelaVendasFuncionario);
	}
	
	private void buscar() {
		try {
			String codFuncionario = this.valCodigoFuncionario.getText();
			double porcentagemFunc = Double.parseDouble(valPorcentagemFuncionario.getText());
			String dataFatur = this.valDataFaturamento.getText();
			
			if (this.rdbtnFaturamentoAtual.isSelected()) {
				dataFatur = null;
			}
			else if (!this.rdbtnBuscarPorData.isSelected()) {
				throw new IllegalArgumentException("Selecione o dia do faturamento.");
			}
			
			if (codFuncionario.equals("") || (dataFatur != null && dataFatur.equals(""))) {
				throw new IllegalArgumentException("Campos passados vazios.");
			}
			
			//Evitando mensagens repetidas.
			carregaTabelaVendasFuncionario(codFuncionario, dataFatur);
			this.valValorTotal.setText(this.principal.retornaValorDeVendasDeFuncionario(codFuncionario, dataFatur));
			this.valValorFuncionario.setText(this.principal.retornaPorcentagemDeVendasDeFuncionario(codFuncionario, dataFatur, porcentagemFunc));
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void carregaTabelaVendasFuncionario(String codigoFuncionario, String dataFaturamento) {

		try {
			String [] colunas = {"ID", "Produto", "Nome", "Quantidade", "Valor", "Desconto", "Funcionário", "Hora"};
			String [][] dados = this.principal.retornaVendasDeFuncionario(codigoFuncionario, dataFaturamento);

			tabelaVendasFuncionario = new JTable(dados, colunas);

			tabelaVendasFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 20)); // Tamanho e tipo de letra.
			tabelaVendasFuncionario.setEnabled(false); // Evitando edição não desejada.
			tabelaVendasFuncionario.getColumnModel().getColumn(2).setPreferredWidth(200);
			tabelaVendasFuncionario.getColumnModel().getColumn(4).setPreferredWidth(100);
			tabelaVendasFuncionario.getColumnModel().getColumn(7).setPreferredWidth(100);
			tabelaVendasFuncionario.setBackground(SystemColor.info); // Cor da linha.
			tabelaVendasFuncionario.setRowHeight(30); // Aumentando altura das linhas.

			scrollPane.setViewportView(tabelaVendasFuncionario);
		}
		catch (Exception e) {
			throw e;
		}
	}

}
