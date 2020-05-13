package sistema.gui.vendas;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class VenderPanel extends JPanel {
	private JTextField valCodigoFuncionario;
	private JTextField valCodigoProduto;
	private JTextField valQuantidadeProduto;
	private JTextField valCodigoMesa;
	private JTextField valCodigoDesconto;
	private final ButtonGroup buttonGroupTipoVenda = new ButtonGroup();
	private final ButtonGroup buttonGroupDesconto = new ButtonGroup();
	private JTable tableVendasDia;
	
	private JRadioButton rdbtnVendaMesa;
	private JRadioButton rdbtnVendaCaixa;

	/**
	 * Create the panel.
	 */
	public VenderPanel() {
		setLayout(null);
		
		JLabel titulo = new JLabel("Cadastrar venda");
		titulo.setBounds(928, 63, 247, 96);
		titulo.setFont(new Font("Tahoma", Font.PLAIN, 30));
		add(titulo);
		
		JLabel codigoFuncionario = new JLabel("C\u00F3digo do funcion\u00E1rio:");
		codigoFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 25));
		codigoFuncionario.setBounds(168, 257, 267, 42);
		add(codigoFuncionario);
		
		valCodigoFuncionario = new JTextField();
		valCodigoFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 23));
		valCodigoFuncionario.setBounds(462, 257, 190, 42);
		add(valCodigoFuncionario);
		valCodigoFuncionario.setColumns(10);
		
		JLabel codigoProduto = new JLabel("C\u00F3digo do produto:");
		codigoProduto.setFont(new Font("Tahoma", Font.PLAIN, 25));
		codigoProduto.setBounds(168, 315, 227, 49);
		add(codigoProduto);
		
		valCodigoProduto = new JTextField();
		valCodigoProduto.setBounds(462, 322, 190, 42);
		add(valCodigoProduto);
		valCodigoProduto.setColumns(10);
		
		JLabel quantidadeProduto = new JLabel("Quantidade do produto:");
		quantidadeProduto.setFont(new Font("Tahoma", Font.PLAIN, 25));
		quantidadeProduto.setBounds(168, 380, 267, 56);
		add(quantidadeProduto);
		
		valQuantidadeProduto = new JTextField();
		valQuantidadeProduto.setBounds(462, 391, 146, 42);
		add(valQuantidadeProduto);
		valQuantidadeProduto.setColumns(10);
		
		JLabel codigoMesa = new JLabel("C\u00F3digo da mesa:");
		codigoMesa.setFont(new Font("Tahoma", Font.PLAIN, 25));
		codigoMesa.setBounds(168, 452, 267, 51);
		add(codigoMesa);
		
		valCodigoMesa = new JTextField();
		valCodigoMesa.setBounds(462, 460, 190, 42);
		add(valCodigoMesa);
		valCodigoMesa.setColumns(10);
		
		JLabel codigoDesconto = new JLabel("C\u00F3digo de desconto:");
		codigoDesconto.setFont(new Font("Tahoma", Font.PLAIN, 25));
		codigoDesconto.setBounds(168, 519, 267, 49);
		add(codigoDesconto);
		
		valCodigoDesconto = new JTextField();
		valCodigoDesconto.setBounds(462, 526, 190, 42);
		add(valCodigoDesconto);
		valCodigoDesconto.setColumns(10);
		
		rdbtnVendaMesa = new JRadioButton("Mesa");
		buttonGroupTipoVenda.add(rdbtnVendaMesa);
		rdbtnVendaMesa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnVendaMesa.setBounds(234, 675, 106, 42);
		add(rdbtnVendaMesa);
		
		rdbtnVendaCaixa = new JRadioButton("Caixa");
		buttonGroupTipoVenda.add(rdbtnVendaCaixa);
		rdbtnVendaCaixa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnVendaCaixa.setBounds(354, 675, 115, 42);
		add(rdbtnVendaCaixa);
		
		JRadioButton rdbtnDescontoSim = new JRadioButton("Sim");
		buttonGroupDesconto.add(rdbtnDescontoSim);
		rdbtnDescontoSim.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnDescontoSim.setBounds(833, 675, 85, 42);
		add(rdbtnDescontoSim);
		
		JRadioButton rdbtnDescontoNao = new JRadioButton("N\u00E3o");
		buttonGroupDesconto.add(rdbtnDescontoNao);
		rdbtnDescontoNao.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnDescontoNao.setBounds(969, 675, 79, 42);
		add(rdbtnDescontoNao);
		
		JLabel tipoVenda = new JLabel("Tipo de venda:");
		tipoVenda.setFont(new Font("Tahoma", Font.PLAIN, 25));
		tipoVenda.setBounds(245, 621, 190, 42);
		add(tipoVenda);
		
		JLabel usarDesconto = new JLabel("Aplicar desconto:");
		usarDesconto.setFont(new Font("Tahoma", Font.PLAIN, 25));
		usarDesconto.setBounds(845, 621, 203, 42);
		add(usarDesconto);
		
		JButton btnAdicionarVenda = new JButton("Adicionar");
		btnAdicionarVenda.setFont(new Font("Tahoma", Font.PLAIN, 23));
		btnAdicionarVenda.setBounds(380, 787, 155, 56);
		add(btnAdicionarVenda);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 23));
		btnLimpar.setBounds(676, 787, 155, 56);
		add(btnLimpar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(1156, 158, 594, 583);
		add(scrollPane);
		
		tableVendasDia = new JTable();
		scrollPane.setViewportView(tableVendasDia);

	}
}
