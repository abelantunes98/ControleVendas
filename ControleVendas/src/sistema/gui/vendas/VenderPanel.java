package sistema.gui.vendas;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import principal.Principal;
import sistema.gui.JanelaFrame;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class VenderPanel extends JPanel {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 7595069762406358433L;

	private JTextField valCodigoFuncionario;
	private JTextField valCodigoProduto;
	private JTextField valQuantidadeProduto;
	private JTextField valCodigoMesa;
	private JTextField valCodigoDesconto;
	private final ButtonGroup buttonGroupTipoVenda = new ButtonGroup();
	private final ButtonGroup buttonGroupDesconto = new ButtonGroup();

	private JRadioButton rdbtnVendaMesa;
	private JRadioButton rdbtnVendaCaixa;
	private JRadioButton rdbtnDescontoSim;
	private JRadioButton rdbtnDescontoNao;

	private Principal principal;
	private JanelaFrame frame;
	private JTable tableVendasDia;
	private JScrollPane scrollPane;

	/**
	 * Create the panel.
	 */
	public VenderPanel(Principal principal, JanelaFrame frame) {

		this.principal = principal;
		this.frame = frame;

		setLayout(null);

		JLabel titulo = new JLabel("Cadastrar venda");
		titulo.setBounds(845, 53, 247, 96);
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
		valCodigoProduto.setFont(new Font("Tahoma", Font.PLAIN, 23));
		valCodigoProduto.setBounds(462, 322, 190, 42);
		add(valCodigoProduto);
		valCodigoProduto.setColumns(10);

		JLabel quantidadeProduto = new JLabel("Quantidade do produto:");
		quantidadeProduto.setFont(new Font("Tahoma", Font.PLAIN, 25));
		quantidadeProduto.setBounds(168, 380, 267, 56);
		add(quantidadeProduto);

		valQuantidadeProduto = new JTextField();
		valQuantidadeProduto.setFont(new Font("Tahoma", Font.PLAIN, 23));
		valQuantidadeProduto.setBounds(462, 391, 146, 42);
		add(valQuantidadeProduto);
		valQuantidadeProduto.setColumns(10);

		JLabel codigoMesa = new JLabel("C\u00F3digo da mesa:");
		codigoMesa.setFont(new Font("Tahoma", Font.PLAIN, 25));
		codigoMesa.setBounds(168, 452, 267, 51);
		add(codigoMesa);

		valCodigoMesa = new JTextField();
		valCodigoMesa.setFont(new Font("Tahoma", Font.PLAIN, 23));
		valCodigoMesa.setBounds(462, 460, 190, 42);
		add(valCodigoMesa);
		valCodigoMesa.setColumns(10);

		JLabel codigoDesconto = new JLabel("C\u00F3digo de desconto:");
		codigoDesconto.setFont(new Font("Tahoma", Font.PLAIN, 25));
		codigoDesconto.setBounds(168, 519, 267, 49);
		add(codigoDesconto);

		valCodigoDesconto = new JTextField();
		valCodigoDesconto.setFont(new Font("Tahoma", Font.PLAIN, 23));
		valCodigoDesconto.setBounds(462, 526, 190, 42);
		add(valCodigoDesconto);
		valCodigoDesconto.setColumns(10);

		JLabel tipoVenda = new JLabel("Tipo de venda:");
		tipoVenda.setFont(new Font("Tahoma", Font.PLAIN, 25));
		tipoVenda.setBounds(245, 621, 190, 42);
		add(tipoVenda);

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

		JLabel usarDesconto = new JLabel("Aplicar desconto:");
		usarDesconto.setFont(new Font("Tahoma", Font.PLAIN, 25));
		usarDesconto.setBounds(845, 621, 203, 42);
		add(usarDesconto);

		rdbtnDescontoSim = new JRadioButton("Sim");
		buttonGroupDesconto.add(rdbtnDescontoSim);
		rdbtnDescontoSim.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnDescontoSim.setBounds(833, 675, 85, 42);
		add(rdbtnDescontoSim);

		rdbtnDescontoNao = new JRadioButton("N\u00E3o");
		buttonGroupDesconto.add(rdbtnDescontoNao);
		rdbtnDescontoNao.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnDescontoNao.setBounds(969, 675, 79, 42);
		add(rdbtnDescontoNao);

		JButton btnAdicionarVenda = new JButton("Adicionar");
		btnAdicionarVenda.setFont(new Font("Tahoma", Font.PLAIN, 23));
		btnAdicionarVenda.setBounds(380, 787, 155, 56);
		add(btnAdicionarVenda);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 23));
		btnLimpar.setBounds(676, 787, 155, 56);
		add(btnLimpar);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(1156, 158, 594, 583);
		add(scrollPane);

		reloadTabelaVendas();

		// Desativando campos a partir de rádio buttons.
		rdbtnVendaMesa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				valCodigoMesa.setEnabled(true);                 
			}
		});

		rdbtnVendaCaixa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				valCodigoMesa.setEnabled(false);                 
			}
		});

		rdbtnDescontoNao.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				valCodigoDesconto.setEnabled(false);                 
			}
		});

		rdbtnDescontoSim.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				valCodigoDesconto.setEnabled(true);                 
			}
		});

		btnLimpar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				limparCampos();                       
			}
		});

		btnAdicionarVenda.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				adicionarVenda();                       
			}
		});

	}

	private void reloadTabelaVendas() {

		try {
			String [] colunas = {"Vendas do dia"};
			String [][] dados = this.principal.retornaVetorToStringVendasFaturamentoDia();

			tableVendasDia = new JTable(dados, colunas);

			tableVendasDia.setFont(new Font("Tahoma", Font.PLAIN, 20)); // Tamanho e tipo de letra.
			tableVendasDia.setEnabled(false); // Evitando edição não desejada.
			tableVendasDia.setBackground(SystemColor.info); // Cor da linha.
			tableVendasDia.setRowHeight(30); // Aumentando altura das linhas.

			scrollPane.setViewportView(tableVendasDia);
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void limparCampos() {

		valCodigoFuncionario.setText("");
		valCodigoProduto.setText("");
		valQuantidadeProduto.setText("");
		valCodigoMesa.setText("");	
		valCodigoDesconto.setText("");

	}

	private void adicionarVenda() {

		try {
			String codigoFuncionario = valCodigoFuncionario.getText();
			String codigoProduto = valCodigoProduto.getText();
			int quantidadeProduto = Integer.parseInt(valQuantidadeProduto.getText());
			String codigoMesa = valCodigoMesa.getText();
			String codigoDesconto = valCodigoDesconto.getText();
			
			/*
			 * Obrigando a escolher opção nos rádio buttons.
			 */
			if (!rdbtnVendaMesa.isSelected() && !rdbtnVendaCaixa.isSelected()) {
				throw new IllegalArgumentException("Escolha uma opção para tipo de venda.");
			}
			
			if (!rdbtnDescontoSim.isSelected() && !rdbtnDescontoNao.isSelected()) {
				throw new IllegalArgumentException("Escolha uma opção para uso de desconto.");
			}
			
			if (rdbtnDescontoNao.isSelected()) {
				codigoDesconto = null;
			}
			
			if (rdbtnVendaCaixa.isSelected()) {
				codigoMesa = null;
			}
			
			/*
			 * Verificando campos vazios.
			 */
			if ( codigoFuncionario.equals("") || codigoProduto.equals("") || 
					(codigoMesa != null && codigoMesa.equals("")) || 
					(codigoDesconto != null && codigoDesconto.equals("")) ) {

				throw new IllegalArgumentException("Campos passados vazios!");
			}
			
			if (rdbtnVendaMesa.isSelected()){
				if (this.principal.retornaMesaDisponivel(codigoMesa)) {
					int resposta = JOptionPane.showConfirmDialog(null, "A mesa não está iniciada.\nDeseja inicia-la?", 
							"Atenção!", JOptionPane.YES_OPTION);

					if (resposta == JOptionPane.YES_OPTION) {
						this.principal.ocuparMesa(codigoMesa);
					}
					else if (resposta == JOptionPane.NO_OPTION) {
						JOptionPane.showMessageDialog(null, "Cadastrado como venda em caixa.", "Informação", JOptionPane.INFORMATION_MESSAGE);
						rdbtnVendaCaixa.setSelected(true);
						codigoMesa = null;
					}
				}
			}

			this.principal.adicionarVenda(codigoFuncionario, codigoProduto, codigoMesa, 
					quantidadeProduto, codigoDesconto);

			JOptionPane.showMessageDialog(null, "Venda Cadastrada!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

			reloadTabelaVendas();
			limparCampos();
			this.frame.reloadVendas();
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}	
	}
}
