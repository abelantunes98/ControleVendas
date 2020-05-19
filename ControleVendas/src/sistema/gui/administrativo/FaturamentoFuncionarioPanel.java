package sistema.gui.administrativo;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class FaturamentoFuncionarioPanel extends JPanel {
	private JTextField valCodigoCliente;
	private JTextField valDataFaturamento;
	private JLabel valValorTotal;
	private final ButtonGroup DiaFaturamentoGroup = new ButtonGroup();
	
	private JRadioButton rdbtnFaturamentoAtual;
	private JRadioButton rdbtnBuscarPorData;
	private JButton btnBuscar;
	private JButton btnLimpar;
	
	private JTable tabelaVendasFuncionario;

	/**
	 * Create the panel.
	 */
	public FaturamentoFuncionarioPanel() {
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
		valCodigoCliente.setBounds(406, 235, 146, 44);
		add(valCodigoCliente);
		valCodigoCliente.setColumns(10);
		
		JLabel dataFaturamento = new JLabel("Data do faturamento:");
		dataFaturamento.setFont(new Font("Tahoma", Font.PLAIN, 25));
		dataFaturamento.setBounds(108, 318, 266, 44);
		dataFaturamento.setVisible(false);
		add(dataFaturamento);
		
		JLabel dataFaturamentoFormato = new JLabel("(dd/mm/aaaa)");
		dataFaturamentoFormato.setFont(new Font("Tahoma", Font.PLAIN, 20));
		dataFaturamentoFormato.setBounds(165, 358, 156, 31);
		dataFaturamentoFormato.setVisible(false);
		add(dataFaturamentoFormato);
		
		valDataFaturamento = new JTextField();
		valDataFaturamento.setFont(new Font("Tahoma", Font.PLAIN, 25));
		valDataFaturamento.setBounds(406, 322, 146, 44);
		valDataFaturamento.setVisible(false);
		valDataFaturamento.setEnabled(false);
		add(valDataFaturamento);
		valDataFaturamento.setColumns(10);
	
		JLabel diaDoFaturamento = new JLabel("Dia do faturamento:");
		diaDoFaturamento.setFont(new Font("Tahoma", Font.PLAIN, 25));
		diaDoFaturamento.setBounds(108, 422, 246, 44);
		add(diaDoFaturamento);
		
		rdbtnFaturamentoAtual = new JRadioButton("Faturamento atual");
		DiaFaturamentoGroup.add(rdbtnFaturamentoAtual);
		rdbtnFaturamentoAtual.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnFaturamentoAtual.setBounds(218, 482, 203, 29);
		add(rdbtnFaturamentoAtual);
		
		rdbtnBuscarPorData = new JRadioButton("Buscar por data");
		DiaFaturamentoGroup.add(rdbtnBuscarPorData);
		rdbtnBuscarPorData.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnBuscarPorData.setBounds(428, 482, 174, 29);
		add(rdbtnBuscarPorData);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnBuscar.setBounds(286, 572, 166, 55);
		add(btnBuscar);
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnLimpar.setBounds(506, 572, 166, 55);
		add(btnLimpar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(1022, 235, 713, 357);
		add(scrollPane);
		
		tabelaVendasFuncionario = new JTable();
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
	}
}
