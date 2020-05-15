package sistema.gui.vendas;

import javax.swing.JPanel;

import principal.Principal;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class CatalogoDescontos extends JPanel {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 8293344279255416313L;
	
	private Principal principal;
	
	private JScrollPane scrollPane;
	private JTable tableCatalogoDescontos;
	/**
	 * Create the panel.
	 */
	public CatalogoDescontos(Principal principal) {
		
		this.principal = principal;
		
		setLayout(null);
		
		JLabel titulo = new JLabel("Cat\u00E1logo de descontos:");
		titulo.setFont(new Font("Tahoma", Font.PLAIN, 40));
		titulo.setBounds(763, 90, 461, 75);
		add(titulo);
		
		this.scrollPane = new JScrollPane();
		this.scrollPane.setBounds(130, 209, 1648, 715);
		add(this.scrollPane);

		carregaTabelaCatalogoDescontos();
	}
	
	private void carregaTabelaCatalogoDescontos() {

		try {
			String [] colunas = {"Código", "Nome", "Descriçao", "Tipo", "Valor"};
			String [][] dados = this.principal.retornaCatalogoDescontos();

			this.tableCatalogoDescontos = new JTable(dados, colunas);

			this.tableCatalogoDescontos.setFont(new Font("Tahoma", Font.PLAIN, 20)); // Tamanho e tipo de letra.
			this.tableCatalogoDescontos.setEnabled(false); // Evitando edição não desejada.
			this.tableCatalogoDescontos.getColumnModel().getColumn(0).setPreferredWidth(10);
			this.tableCatalogoDescontos.getColumnModel().getColumn(1).setPreferredWidth(300);
			this.tableCatalogoDescontos.getColumnModel().getColumn(2).setPreferredWidth(850);
			this.tableCatalogoDescontos.getColumnModel().getColumn(3).setPreferredWidth(40);
			this.tableCatalogoDescontos.getColumnModel().getColumn(4).setPreferredWidth(40);
			this.tableCatalogoDescontos.setBackground(SystemColor.info); // Cor da linha.
			this.tableCatalogoDescontos.setRowHeight(30); // Aumentando altura das linhas.

			this.scrollPane.setViewportView(this.tableCatalogoDescontos);
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}
}
