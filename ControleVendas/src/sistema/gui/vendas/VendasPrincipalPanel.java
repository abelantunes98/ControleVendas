package sistema.gui.vendas;

import javax.swing.JPanel;

import principal.Principal;
import sistema.gui.JanelaFrame;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.JButton;

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
		
		String formato = "R$ #,##0.00";
		DecimalFormat d = new DecimalFormat(formato);
		
		this.principal = principal;
		this.frame = frame;
		
		// Iniciando faturamento.
		this.abrirFaturamento();
		
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
		
		JLabel valFaturadoDia = new JLabel(d.format(this.principal.retornaValorApuradoFaturamentoAtual()));
		valFaturadoDia.setFont(new Font("Tahoma", Font.PLAIN, 25));
		valFaturadoDia.setBounds(570, 515, 308, 49);
		add(valFaturadoDia);
		
		JLabel mesasDisponiveis = new JLabel("Mesas dispon\u00EDveis:");
		mesasDisponiveis.setFont(new Font("Tahoma", Font.PLAIN, 25));
		mesasDisponiveis.setBounds(1246, 412, 227, 55);
		add(mesasDisponiveis);
		
		JLabel valMesasDisponiveis = new JLabel(Integer.toString(this.principal.retornaNumMesasDisponiveis()));
		valMesasDisponiveis.setFont(new Font("Tahoma", Font.PLAIN, 25));
		valMesasDisponiveis.setBounds(1488, 415, 127, 48);
		add(valMesasDisponiveis);
		
		JLabel mesasOcupadas = new JLabel("Mesas ocupadas:");
		mesasOcupadas.setFont(new Font("Tahoma", Font.PLAIN, 25));
		mesasOcupadas.setBounds(1246, 508, 210, 49);
		add(mesasOcupadas);
		
		JLabel valMesasOcupadas = new JLabel(Integer.toString(this.principal.retornaNumeroMesas() - this.principal.retornaNumMesasDisponiveis()));
		valMesasOcupadas.setFont(new Font("Tahoma", Font.PLAIN, 25));
		valMesasOcupadas.setBounds(1488, 508, 127, 49);
		add(valMesasOcupadas);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnVoltar.setBounds(223, 822, 149, 49);
		add(btnVoltar);
		
		btnVoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				carregarPainelPrincipal();                       
			}
		});

	}
	
	private void carregarPainelPrincipal() {
		try {
			this.frame.setTitulosPrincipal();
			this.frame.reloadAllPrincipal();
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/*
	 * Se já tiver sido criado um faturamento no mesmo dia,
	 * o sistema continua nele. Caso não tenha sido,
	 * é exibida uma perguta para saber se deve continuar no faturamento
	 * anterior ou criar um novo.
	 */
	private void abrirFaturamento() {	
		try {	
			boolean necessidadePergunta = this.principal.retornaNecessidadePerguntaCriarFaturamento();
			
			if (necessidadePergunta) {
				int resposta = JOptionPane.showConfirmDialog(null, "Deseja iniciar um novo faturamento?", 
						"Atenção!", JOptionPane.YES_OPTION);
				
				if (resposta == JOptionPane.YES_OPTION) {
					this.principal.iniciarFaturamento();
				}
			}
			else {
				this.principal.iniciarFaturamento();
			}
			
		}
		catch (Exception e) {
			throw e;
		}
	}
}
