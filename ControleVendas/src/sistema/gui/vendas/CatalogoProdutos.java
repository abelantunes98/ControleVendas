package sistema.gui.vendas;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import principal.Principal;

public class CatalogoProdutos extends JPanel {
	
	/**
	 * Serial
	 */
	private static final long serialVersionUID = -2229015372306856418L;
	
	private JScrollPane scrollPane;
	private JTable tableCatalogoProdutos;

	private Principal principal;
	
	/**
	 * Create the panel.
	 */
	public CatalogoProdutos(Principal principal) {
		
		this.principal = principal;
		
		setLayout(null);

		JLabel titulo = new JLabel("Cat\u00E1logo de produtos:");
		titulo.setBounds(782, 86, 429, 95);
		titulo.setFont(new Font("Tahoma", Font.PLAIN, 40));
		add(titulo);

		this.scrollPane = new JScrollPane();
		this.scrollPane.setBounds(129, 216, 1649, 710);
		add(this.scrollPane);
		
		// Carregando catálogo de produtos.
		carregaTabelaCatalogoProdutos();

	}

	private void carregaTabelaCatalogoProdutos() {

		try {
			String [] colunas = {"Código", "Nome", "Descriçao", "Valor"};
			String [][] dados = this.principal.retornaCatalogoProdutos();

			this.tableCatalogoProdutos = new JTable(dados, colunas);

			this.tableCatalogoProdutos.setFont(new Font("Tahoma", Font.PLAIN, 20)); // Tamanho e tipo de letra.
			this.tableCatalogoProdutos.setEnabled(false); // Evitando edição não desejada.
			this.tableCatalogoProdutos.getColumnModel().getColumn(0).setPreferredWidth(10);
			this.tableCatalogoProdutos.getColumnModel().getColumn(1).setPreferredWidth(300);
			this.tableCatalogoProdutos.getColumnModel().getColumn(2).setPreferredWidth(900);
			this.tableCatalogoProdutos.getColumnModel().getColumn(3).setPreferredWidth(10);
			this.tableCatalogoProdutos.setBackground(SystemColor.info); // Cor da linha.
			this.tableCatalogoProdutos.setRowHeight(30); // Aumentando altura das linhas.

			this.scrollPane.setViewportView(this.tableCatalogoProdutos);
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}
}
