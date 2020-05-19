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
	
	private JTextField valCodigoCliente;
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

	/**
	 * Create the panel.
	 */
	public FaturamentoFuncionarioPanel(Principal principal) {
		setLayout(null);
		
		JLabel titulo = new JLabel("Faturamento de funcion\u00E1rio");
		titulo.setBounds(754, 56, 369, 37);
		titulo.setFont(new Font("Tahoma", Font.PLAIN, 30));
		add(titulo);
		
		JLabel codigoFunionario = new JLabel("C\u00F3digo do funcion\u00E1rio:");
		codigoFunionario.setFont(new Font("Tahoma", Font.PLAIN, 25));
		codigoFunionario.setBounds(108, 235, 266, 44);
		add(codigoFunionario);
		
		valCodigoCliente = new JTextField();
		valCodigoCliente.setFont(new Font("Tahoma", Font.PLAIN, 25));
		valCodigoCliente.setBounds(461, 236, 146, 44);
		add(valCodigoCliente);
		valCodigoCliente.setColumns(10);
		
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
		scrollPane.setBounds(1022, 235, 713, 357);
		add(scrollPane);
		
		scrollPane.setViewportView(tabelaVendasFuncionario);
		
		JLabel valorTotal = new JLabel("Valor total:");
		valorTotal.setFont(new Font("Tahoma", Font.PLAIN, 25));
		valorTotal.setBounds(1236, 643, 166, 37);
		add(valorTotal);
		
		valValorTotal = new JLabel("R$ 0");
		valValorTotal.setFont(new Font("Tahoma", Font.PLAIN, 25));
		valValorTotal.setBounds(1410, 643, 197, 37);
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
	}
	
	
	private void limparCampos() {
		
		valCodigoCliente.setText("");
		valDataFaturamento.setText("");
		valPorcentagemFuncionario.setText("");
	}
	
private void carregaTabelaVendasFuncionario(String codigoFuncionario, String dataFaturamento) {
		
		try {
			String [] colunas = {"Código", "Nome", "Quantidade", "Valor", "Desconto", "Funcionário"};
			String [][] dados = this.principal.retornaVendasFuncionario(codigoFuncionario, dataFaturamento);
			
			tabelaVendasFuncionario = new JTable(dados, colunas);
			
			tabelaVendasFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 20)); // Tamanho e tipo de letra.
			tabelaVendasFuncionario.setEnabled(false); // Evitando edição não desejada.
			tabelaVendasFuncionario.getColumnModel().getColumn(1).setPreferredWidth(250);
			tabelaVendasFuncionario.setBackground(SystemColor.info); // Cor da linha.
			tabelaVendasFuncionario.setRowHeight(30); // Aumentando altura das linhas.
			
			scrollPane.setViewportView(tabelaVendasFuncionario);
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}
	
}
