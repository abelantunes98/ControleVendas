package sistema.gui.vendas;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

public class VendasPrincipalPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public VendasPrincipalPanel() {
		setLayout(null);
		
		JLabel titulo = new JLabel("Central de vendas");
		titulo.setFont(new Font("Tahoma", Font.PLAIN, 30));
		titulo.setBounds(880, 96, 336, 132);
		add(titulo);
		
		JLabel numeroVendasDia = new JLabel("N\u00FAmero de vendas de hoje:");
		numeroVendasDia.setFont(new Font("Tahoma", Font.PLAIN, 25));
		numeroVendasDia.setBounds(223, 405, 317, 69);
		add(numeroVendasDia);
		
		JLabel valNumeroVendasDia = new JLabel("New label");
		valNumeroVendasDia.setFont(new Font("Tahoma", Font.PLAIN, 25));
		valNumeroVendasDia.setBounds(570, 412, 91, 55);
		add(valNumeroVendasDia);
		
		JLabel faturadoDia = new JLabel("Faturado de hoje:");
		faturadoDia.setFont(new Font("Tahoma", Font.PLAIN, 25));
		faturadoDia.setBounds(223, 501, 317, 63);
		add(faturadoDia);
		
		JLabel valFaturadoDia = new JLabel("New label");
		valFaturadoDia.setFont(new Font("Tahoma", Font.PLAIN, 25));
		valFaturadoDia.setBounds(570, 515, 91, 49);
		add(valFaturadoDia);

	}
}
