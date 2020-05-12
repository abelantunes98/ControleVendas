package sistema.gui;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;

import principal.Principal;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class AdicionarMesaPanel extends JPanel {
	
	private JTextField valCodigoMesa;
	private JTextField valLugaresMesa;
	
	private Principal principal;
	private JanelaFrame frame;
	private JTable tableMesas;
	
	JScrollPane scrollPane;
	
	/**
	 * Create the panel.
	 * 1632x960
	 */
	public AdicionarMesaPanel(Principal principal, JanelaFrame frame) {
		
		this.principal = principal;
		this.frame = frame;
		
		setLayout(null);
		
		JLabel titulo = new JLabel("Adicionar Mesa");
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setFont(new Font("Tahoma", Font.PLAIN, 30));
		titulo.setBounds(670, 36, 612, 222);
		add(titulo);
		
		JLabel codigoProduto = new JLabel("C\u00F3digo para mesa:");
		codigoProduto.setFont(new Font("Tahoma", Font.PLAIN, 25));
		codigoProduto.setBounds(123, 324, 277, 42);
		add(codigoProduto);
		
		valCodigoMesa = new JTextField();
		valCodigoMesa.setFont(new Font("Tahoma", Font.PLAIN, 23));
		valCodigoMesa.setColumns(10);
		valCodigoMesa.setBounds(376, 325, 178, 43);
		add(valCodigoMesa);
		
		JLabel lugaresMesa = new JLabel("Lugares na mesa:");
		lugaresMesa.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lugaresMesa.setBounds(123, 481, 223, 56);
		add(lugaresMesa);
		
		valLugaresMesa = new JTextField();
		valLugaresMesa.setFont(new Font("Tahoma", Font.PLAIN, 23));
		valLugaresMesa.setColumns(10);
		valLugaresMesa.setBounds(376, 489, 178, 43);
		add(valLugaresMesa);
		
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 23));
		btnSalvar.setBounds(691, 787, 125, 43);
		add(btnSalvar);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 23));
		btnLimpar.setBounds(933, 787, 125, 43);
		add(btnLimpar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(977, 259, 556, 417);
		add(scrollPane);
		
		this.reloadTabelaMesas();
		
		/*
		 * Ações dos botões.
		 */
		btnSalvar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cadastrarMesa();
			}
		});

		btnLimpar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				limparCampos();                       
			}
		});

	}
	
	public void reloadTabelaMesas() {
		
		String [] colunas = {"Mesas cadastradas"};
		String [][] dados = this.principal.retornaVetorToStringMesas();
		
		tableMesas = new JTable(dados, colunas);
		
		tableMesas.setFont(new Font("Tahoma", Font.PLAIN, 20)); // Tamanho e tipo de letra.
		tableMesas.setEnabled(false); // Evitando edição não desejada.
		tableMesas.setBackground(SystemColor.info); // Cor da linha.
		tableMesas.setRowHeight(30); // Aumentando altura das linhas.
		
		scrollPane.setViewportView(tableMesas);
	}
	
	
	private void limparCampos() {
		
		valCodigoMesa.setText("");
		valLugaresMesa.setText("");		
	}
	
	private void cadastrarMesa() {
		
		try {
			String codigoMesa = valCodigoMesa.getText();
			Integer lugaresMesa = Integer.parseInt(valLugaresMesa.getText());
			
			this.principal.cadastrarMesa(codigoMesa, lugaresMesa);
			// Mensagem de sucesso.
			JOptionPane.showMessageDialog(null, "Mesa Cadastrada!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
			limparCampos();
			this.frame.reload();
			this.reloadTabelaMesas();

		}
		// Mostrando erro.
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}
	
}
