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

		scrollPane = new JScrollPane();
		scrollPane.setBounds(129, 216, 1649, 710);
		add(scrollPane);
		
		// Carregando catálogo de produtos.
		carregaTabelaCatalogoProdutos();

	}

	private void carregaTabelaCatalogoProdutos() {

		try {
			String [] colunas = {"Código", "Nome", "Descriçao", "Valor"};
			String [][] dados = this.principal.retornaCatalogoProdutos();

			tableCatalogoProdutos = new JTable(dados, colunas);

			tableCatalogoProdutos.setFont(new Font("Tahoma", Font.PLAIN, 20)); // Tamanho e tipo de letra.
			tableCatalogoProdutos.setEnabled(false); // Evitando edição não desejada.
			tableCatalogoProdutos.getColumnModel().getColumn(0).setPreferredWidth(10);
			tableCatalogoProdutos.getColumnModel().getColumn(1).setPreferredWidth(300);
			tableCatalogoProdutos.getColumnModel().getColumn(2).setPreferredWidth(900);
			tableCatalogoProdutos.getColumnModel().getColumn(3).setPreferredWidth(10);
			tableCatalogoProdutos.setBackground(SystemColor.info); // Cor da linha.
			tableCatalogoProdutos.setRowHeight(30); // Aumentando altura das linhas.

			scrollPane.setViewportView(tableCatalogoProdutos);
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}
}
