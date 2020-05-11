package sistema.gui;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.SwingConstants;

import principal.Principal;
import sistema.gui.JanelaFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class AdicionarMesaPanel extends JPanel {
	
	private JTextField valCodigoMesa;
	private JTextField valLugaresMesa;
	
	private Principal principal;
	private JanelaFrame frame;
	private JTable tableMesas;
	
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(977, 259, 556, 417);
		add(scrollPane);
		
		
		String [] colunas = {"Mesas cadastradas"};
		String [][] dados = this.principal.retornaVetorToStringMesas();
		tableMesas = new JTable(dados, colunas);
		scrollPane.setViewportView(tableMesas);

	}
	
}
