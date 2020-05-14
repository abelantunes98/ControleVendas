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

public class MesasPanel extends JPanel {
	
	/**
	 * Serial
	 */
	private static final long serialVersionUID = -2996858019062843508L;
	
	private JTextField valCodigoMesa;
	private JTextField valCodigosMesas;
	private final ButtonGroup buttonGroupOpcao = new ButtonGroup();
	private JTable tableMesas;
	
	private JLabel codigoMesa;
	private JLabel codigosMesas;
	private JLabel codigosMesas2;
	private JRadioButton rdbtnOcuparMesa;
	private JRadioButton rdbtnLiberarMesa ;
	private JRadioButton rdbtnJuntarMesas;
	private JButton btnConfirmar;
	private JButton btnLimpar;
	
	private JLabel valorTotal;
	private JLabel valValorTotal;
	private JButton btnPago;
	
	private JScrollPane scrollPane;
	
	private Principal principal;
	private JanelaFrame frame;

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
		
		codigosMesas = new JLabel("C\u00F3digos das mesas:");
		codigosMesas.setFont(new Font("Tahoma", Font.PLAIN, 25));
		codigosMesas.setBounds(176, 474, 222, 68);
		codigosMesas.setEnabled(false);
		add(codigosMesas);
		
		codigosMesas2 = new JLabel("(Separados por espa\u00E7o)");
		codigosMesas2.setFont(new Font("Tahoma", Font.PLAIN, 19));
		codigosMesas2.setBounds(186, 523, 212, 41);
		codigosMesas2.setEnabled(false);
		add(codigosMesas2);
		
		valCodigosMesas = new JTextField();
		valCodigosMesas.setFont(new Font("Tahoma", Font.PLAIN, 23));
		valCodigosMesas.setBounds(413, 493, 288, 41);
		add(valCodigosMesas);
		valCodigosMesas.setColumns(10);
		valCodigosMesas.setEnabled(false);
		
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
		rdbtnOcuparMesa.setBounds(243, 686, 155, 41);
		add(rdbtnOcuparMesa);
		
		rdbtnLiberarMesa = new JRadioButton("Liberar mesa");
		buttonGroupOpcao.add(rdbtnLiberarMesa);
		rdbtnLiberarMesa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnLiberarMesa.setBounds(483, 686, 174, 41);
		add(rdbtnLiberarMesa);
		
		rdbtnJuntarMesas = new JRadioButton("Juntar mesas");
		buttonGroupOpcao.add(rdbtnJuntarMesas);
		rdbtnJuntarMesas.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnJuntarMesas.setBounds(717, 686, 169, 41);
		add(rdbtnJuntarMesas);
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnConfirmar.setBounds(283, 846, 169, 55);
		add(btnConfirmar);
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnLimpar.setBounds(569, 846, 169, 55);
		add(btnLimpar);
		
		this.btnPago = new JButton("Pago");
		btnPago.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnPago.setBounds(1282, 846, 169, 51);
		btnPago.setEnabled(false);
		btnPago.setVisible(false);
		add(btnPago);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(979, 243, 783, 425);
		add(scrollPane);
		
		// Reload tabela de disponibilidade de mesas.
		reloadTabelaMesas();
		
		// Ouvindo bot�es.
		
		rdbtnOcuparMesa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				codigoMesa.setEnabled(true);
				valCodigoMesa.setEnabled(true);
				valCodigosMesas.setEnabled(false);
				codigosMesas.setEnabled(false);
				codigosMesas2.setEnabled(false);
			}
		});	
		
		rdbtnLiberarMesa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				codigoMesa.setEnabled(true);
				valCodigoMesa.setEnabled(true);
				valCodigosMesas.setEnabled(false);
				codigosMesas.setEnabled(false);
				codigosMesas2.setEnabled(false);
			}
		});
		
		rdbtnJuntarMesas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				codigoMesa.setEnabled(false);
				valCodigoMesa.setEnabled(false);
				valCodigosMesas.setEnabled(true);
				codigosMesas.setEnabled(true);
				codigosMesas2.setEnabled(true);
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
			tableMesas.setEnabled(false); // Evitando edi��o n�o desejada.
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
			String [] colunas = {"C�digo", "Nome", "Quantidade", "Valor", "Desconto", "Funcion�rio"};
			String [][] dados = this.principal.retornaVendasDaMesa(codigoMesa);
			
			tableMesas = new JTable(dados, colunas);
			
			tableMesas.setFont(new Font("Tahoma", Font.PLAIN, 20)); // Tamanho e tipo de letra.
			tableMesas.setEnabled(false); // Evitando edi��o n�o desejada.
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
			this.codigoMesa.setEnabled(false);
			this.codigosMesas.setEnabled(false);
			this.valCodigoMesa.setEnabled(false);
			this.valCodigosMesas.setEnabled(false);
			this.rdbtnOcuparMesa.setEnabled(false);
			this.rdbtnLiberarMesa.setEnabled(false);
			this.rdbtnJuntarMesas.setEnabled(false);
			this.btnConfirmar.setEnabled(false);
			this.btnLimpar.setEnabled(false);
			
			this.valorTotal.setVisible(true);
			this.valValorTotal.setVisible(true);
			this.btnPago.setEnabled(true);
			this.btnPago.setVisible(true);
			
			this.btnPago.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					liberaMesa(codigoMesa);
					reload();
					JOptionPane.showMessageDialog(null, "Mesa liberada.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
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
		valCodigosMesas.setText("");
	}
	
	
	private void confirmar() {
		
		try {
			//String codigosMesas = valCodigosMesas.getText();
			
			if (rdbtnOcuparMesa.isSelected() || rdbtnLiberarMesa.isSelected()) {
				
				String codigoMesaStr = valCodigoMesa.getText();		
				if ( codigoMesaStr.equals("") ) {
					throw new IllegalArgumentException("Campos passados vazios!");
				}
				
				if (rdbtnOcuparMesa.isSelected()) {
					this.principal.ocuparMesa(codigoMesaStr);
					JOptionPane.showMessageDialog(null, "Mesa ocupada.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					
					if (!this.principal.retornaMesaExiste(codigoMesaStr)) {
						throw new IllegalArgumentException("Mesa inexistente.");
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
					 * S�o chamadas as fun��es que mudam as informa��es na
					 * tela.
					 */
					else if (resposta == JOptionPane.YES_OPTION){
						this.carregaTabelaVendasMesa(codigoMesaStr);
						this.carregaInformacoesPagamento(codigoMesaStr);
					}
				}
			}
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}	
	}
}
