package sistema.gui.vendas;

import javax.swing.JPanel;

import principal.Principal;
import sistema.gui.JanelaFrame;

import javax.swing.JLabel;
import java.awt.Font;

public class VendasPrincipalPanel extends JPanel {
	
	/**
	 * Serial
	 */
	private static final long serialVersionUID = -3758417757889926383L;
	
	private Principal principal;
	private JanelaFrame frame;
	
	/**
	 * Create the panel.
	 */
	public VendasPrincipalPanel(Principal principal, JanelaFrame frame) {
		
		this.principal = principal;
		this.frame = frame;
		
		// Iniciando faturamento.
		this.principal.iniciarFaturamento();
		
		setLayout(null);
		
		JLabel titulo = new JLabel("Central de vendas");
		titulo.setFont(new Font("Tahoma", Font.PLAIN, 30));
		titulo.setBounds(880, 96, 336, 132);
		add(titulo);
		
		JLabel numeroVendasDia = new JLabel("N\u00FAmero de vendas de hoje:");
		numeroVendasDia.setFont(new Font("Tahoma", Font.PLAIN, 25));
		numeroVendasDia.setBounds(223, 405, 317, 69);
		add(numeroVendasDia);
		
		JLabel valNumeroVendasDia = new JLabel(Integer.toString(this.principal.retornaNumeroDeVendasFaturamentoAtual()));
		valNumeroVendasDia.setFont(new Font("Tahoma", Font.PLAIN, 25));
		valNumeroVendasDia.setBounds(570, 412, 91, 55);
		add(valNumeroVendasDia);
		
		JLabel faturadoDia = new JLabel("Faturado de hoje:");
		faturadoDia.setFont(new Font("Tahoma", Font.PLAIN, 25));
		faturadoDia.setBounds(223, 501, 317, 63);
		add(faturadoDia);
		
		JLabel valFaturadoDia = new JLabel(Double.toString(this.principal.retornaValorApuradoFaturamentoAtual()) + " R$");
		valFaturadoDia.setFont(new Font("Tahoma", Font.PLAIN, 25));
		valFaturadoDia.setBounds(570, 515, 166, 49);
		add(valFaturadoDia);

	}
}
