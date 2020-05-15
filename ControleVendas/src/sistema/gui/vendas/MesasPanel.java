package sistema.gui.vendas;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JTextField;

import principal.Principal;
import sistema.gui.JanelaFrame;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class MesasPanel extends JPanel {
	
	/**
	 * Serial
	 */
	private static final long serialVersionUID = -2996858019062843508L;
	
	private JTextField valCodigoMesa;
	private final ButtonGroup buttonGroupOpcao = new ButtonGroup();
	private JTable tableMesas;
	
	private JLabel codigoMesa;
	private JRadioButton rdbtnOcuparMesa;
	private JRadioButton rdbtnLiberarMesa ;
	private JButton btnConfirmar;
	private JButton btnLimpar;
	
	private JLabel valorTotal;
	private JLabel valValorTotal;
	private JButton btnPago;
	private JButton btnVoltar;
	
	private JScrollPane scrollPane;
	
	private Principal principal;
	private JanelaFrame frame;
	private JLabel opcaoDesejada;

	/**
	 * Create the panel.
	 */
	public MesasPanel(Principal principal, JanelaFrame frame) {
		
		this.principal = principal;
		this.frame = frame;
		
		setLayout(null);
		
		JLabel titulo = new JLabel("Mesas");
		titulo.setFont(new Font("Tahoma", Font.PLAIN, 30));
		titulo.setBounds(979, 93, 169, 95);
		add(titulo);
		
		codigoMesa = new JLabel("C\u00F3digo da mesa:");
		codigoMesa.setFont(new Font("Tahoma", Font.PLAIN, 25));
		codigoMesa.setBounds(176, 346, 222, 68);
		add(codigoMesa);
		
		valCodigoMesa = new JTextField();
		valCodigoMesa.setFont(new Font("Tahoma", Font.PLAIN, 23));
		valCodigoMesa.setBounds(413, 362, 182, 41);
		add(valCodigoMesa);
		valCodigoMesa.setColumns(10);
		
		opcaoDesejada = new JLabel("Op\u00E7\u00E3o desejada:");
		opcaoDesejada.setFont(new Font("Tahoma", Font.PLAIN, 25));
		opcaoDesejada.setBounds(176, 558, 210, 41);
		add(opcaoDesejada);
		
		this.valorTotal = new JLabel("Valor total:");
		valorTotal.setFont(new Font("Tahoma", Font.PLAIN, 28));
		valorTotal.setBounds(1188, 734, 169, 55);
		valorTotal.setVisible(false);
		add(valorTotal);
		
		this.valValorTotal = new JLabel("0");
		valValorTotal.setFont(new Font("Tahoma", Font.PLAIN, 28));
		valValorTotal.setBounds(1410, 734, 198, 55);
		valValorTotal.setVisible(false);
		add(valValorTotal);
		
		rdbtnOcuparMesa = new JRadioButton("Ocupar mesa");
		buttonGroupOpcao.add(rdbtnOcuparMesa);
		rdbtnOcuparMesa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnOcuparMesa.setBounds(293, 632, 155, 41);
		add(rdbtnOcuparMesa);
		
		rdbtnLiberarMesa = new JRadioButton("Liberar mesa");
		buttonGroupOpcao.add(rdbtnLiberarMesa);
		rdbtnLiberarMesa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnLiberarMesa.setBounds(525, 632, 174, 41);
		add(rdbtnLiberarMesa);
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnConfirmar.setBounds(277, 774, 169, 55);
		add(btnConfirmar);
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnLimpar.setBounds(564, 774, 169, 55);
		add(btnLimpar);
		
		this.btnPago = new JButton("Pago");
		btnPago.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnPago.setBounds(1469, 846, 169, 51);
		btnPago.setEnabled(false);
		btnPago.setVisible(false);
		add(btnPago);
		
		this.btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnVoltar.setBounds(1188, 846, 169, 51);
		btnVoltar.setEnabled(false);
		btnVoltar.setVisible(false);
		add(btnVoltar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(979, 243, 783, 425);
		add(scrollPane);
		
		// Reload tabela de disponibilidade de mesas.
		reloadTabelaMesas();
		
		// Ouvindo botões.
		
		rdbtnOcuparMesa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				codigoMesa.setEnabled(true);
				valCodigoMesa.setEnabled(true);
			}
		});	
		
		rdbtnLiberarMesa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				codigoMesa.setEnabled(true);
				valCodigoMesa.setEnabled(true);
			}
		});
		

		btnLimpar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				limparCampos();                       
			}
		});
		
		btnConfirmar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				confirmar();                       
			}
		});

	}
	
	private void reloadTabelaMesas() {
		
		try {
			String [] colunas = {"Status das mesas"};
			String [][] dados = this.principal.retornaDisponibilidadeMesas();
			
			tableMesas = new JTable(dados, colunas);
			
			tableMesas.setFont(new Font("Tahoma", Font.PLAIN, 20)); // Tamanho e tipo de letra.
			tableMesas.setEnabled(false); // Evitando edição não desejada.
			tableMesas.setBackground(SystemColor.info); // Cor da linha.
			tableMesas.setRowHeight(30); // Aumentando altura das linhas.
			
			scrollPane.setViewportView(tableMesas);
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void carregaTabelaVendasMesa(String codigoMesa) {
		
		try {
			String [] colunas = {"Código", "Nome", "Quantidade", "Valor", "Desconto", "Funcionário"};
			String [][] dados = this.principal.retornaVendasDaMesa(codigoMesa);
			
			tableMesas = new JTable(dados, colunas);
			
			tableMesas.setFont(new Font("Tahoma", Font.PLAIN, 20)); // Tamanho e tipo de letra.
			tableMesas.setEnabled(false); // Evitando edição não desejada.
			tableMesas.getColumnModel().getColumn(1).setPreferredWidth(250);
			tableMesas.setBackground(SystemColor.info); // Cor da linha.
			tableMesas.setRowHeight(30); // Aumentando altura das linhas.
			
			scrollPane.setViewportView(tableMesas);
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void carregaInformacoesPagamento(String codigoMesa) {
		try {
			
			String formato = "R$ #,##0.00";
			DecimalFormat d = new DecimalFormat(formato);
			
			this.codigoMesa.setEnabled(false);
			this.opcaoDesejada.setEnabled(false);
			this.valCodigoMesa.setEnabled(false);
			this.rdbtnOcuparMesa.setEnabled(false);
			this.rdbtnLiberarMesa.setEnabled(false);
			this.btnConfirmar.setEnabled(false);
			this.btnLimpar.setEnabled(false);
			
			this.valorTotal.setVisible(true);
			this.valValorTotal.setVisible(true);
			this.valValorTotal.setText(d.format(this.principal.retornaTotalGastoMesa(codigoMesa)));
			
			this.btnPago.setEnabled(true);
			this.btnPago.setVisible(true);
			this.btnVoltar.setEnabled(true);
			this.btnVoltar.setVisible(true);
			
			this.btnPago.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					try {
						liberaMesa(codigoMesa);
						reload();
						JOptionPane.showMessageDialog(null, "Mesa liberada.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
					}
					catch (Exception e) {
						JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
					}
					
				}
			});
			
			this.btnVoltar.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					try {
						reload();
					}
					catch (Exception e) {
						JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
					}
					
				}
			});
			
		}
		catch (Exception e) {
			throw e;
		}
	}
	
	private void reload() {
		try {
			this.frame.reloadVendasMesas();
		}
		catch (Exception e) {
			throw e;
		}
	}
	
	private void liberaMesa(String codigoMesa) {
		try {
			this.principal.liberarMesa(codigoMesa);
		}
		catch (Exception e) {
			throw e;
		}
	}
	
	private void limparCampos() {
		
		valCodigoMesa.setText("");
	}
	
	
	private void confirmar() {
		
		try {
			
			// Verificando se algum rádio button foi selecionado.
			if (rdbtnOcuparMesa.isSelected() || rdbtnLiberarMesa.isSelected()) {
				
				String codigoMesaStr = valCodigoMesa.getText();		
				if ( codigoMesaStr.equals("") ) {
					throw new IllegalArgumentException("Campo passado vazio!");
				}
				
				if (rdbtnOcuparMesa.isSelected()) {
					this.principal.ocuparMesa(codigoMesaStr);
					this.reload();
					JOptionPane.showMessageDialog(null, "Mesa ocupada.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					
					/*
					 * Verificações de erro especiais.
					 * São necessárias pois há iterações antes da chamada do
					 * backend.
					 */
					if (!this.principal.retornaMesaExiste(codigoMesaStr)) {
						throw new IllegalArgumentException("Mesa inexistente.");
					}
					
					if (this.principal.retornaMesaDisponivel(codigoMesaStr)) {
						throw new IllegalArgumentException("A mesa não está ocupada.");
					}
					
					int resposta = JOptionPane.showConfirmDialog(null, "Deseja calcular os gastos da mesa?", 
							"Faturamento", JOptionPane.YES_OPTION);
					if (resposta == JOptionPane.NO_OPTION) {
						this.liberaMesa(codigoMesaStr);
						this.reload();
						JOptionPane.showMessageDialog(null, "Mesa liberada.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
					}
					/*
					 * Caso o usuario deseje calcular a conta da mesa,
					 * São chamadas as funções que mudam as informações na
					 * tela.
					 */
					else if (resposta == JOptionPane.YES_OPTION){
						this.carregaTabelaVendasMesa(codigoMesaStr);
						this.carregaInformacoesPagamento(codigoMesaStr);
					}
				}
			}
			else {
				throw new IllegalArgumentException("Selecione uma operação.");
			}
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}	
	}
}
