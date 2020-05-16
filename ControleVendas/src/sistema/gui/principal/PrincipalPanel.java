package sistema.gui.principal;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;

import principal.Principal;
import sistema.gui.JanelaFrame;

import javax.swing.JButton;

public class PrincipalPanel extends JPanel {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 8973928196405138319L;
	
	private JanelaFrame frame;
	Principal principal;	
	
	/**
	 * Create the panel.
	 */
	public PrincipalPanel(Principal principal, JanelaFrame frame) {
		
		this.frame = frame;
		this.principal = principal;
		
		JLabel titulo = new JLabel("Central CDV-AAN");
		titulo.setBounds(655, 16, 612, 222);
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		JLabel numeroFuncionarios = new JLabel("Funcionarios cadastrados:");
		numeroFuncionarios.setBounds(301, 381, 432, 58);
		numeroFuncionarios.setFont(new Font("Tahoma", Font.PLAIN, 25));
		numeroFuncionarios.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel valNumeroFuncionarios = new JLabel(Integer.toString(principal.retornaNumeroFuncionarios()));
		valNumeroFuncionarios.setBounds(629, 390, 128, 40);
		valNumeroFuncionarios.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		JLabel numeroProdutos = new JLabel("Produtos cadastrados:");
		numeroProdutos.setBounds(301, 460, 406, 52);
		numeroProdutos.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		JLabel valNumeroProdutos = new JLabel(Integer.toString(principal.retornaNumeroProdutos()));
		valNumeroProdutos.setBounds(629, 466, 91, 40);
		valNumeroProdutos.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		JLabel numeroMesas = new JLabel("Mesas cadastradas:");
		numeroMesas.setBounds(1188, 386, 250, 49);
		numeroMesas.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		JLabel numeroDescontos = new JLabel("Descontos cadastrados:");
		numeroDescontos.setBounds(1188, 463, 277, 46);
		numeroDescontos.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		JLabel valNumeroMesas = new JLabel(Integer.toString(principal.retornaNumeroMesas()));
		valNumeroMesas.setBounds(1480, 390, 109, 49);
		valNumeroMesas.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		JLabel valNumeroDescontos = new JLabel(Integer.toString(principal.retornaNumeroDescontos()));
		valNumeroDescontos.setBounds(1480, 466, 109, 46);
		valNumeroDescontos.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		JButton btnLimparBase = new JButton("Limpar base");
		btnLimparBase.setBounds(1307, 810, 210, 49);
		btnLimparBase.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		setLayout(null);
		
		add(titulo);
		add(numeroFuncionarios);
		add(valNumeroFuncionarios);
		add(numeroProdutos);
		add(valNumeroProdutos);
		add(numeroMesas);
		add(numeroDescontos);
		add(valNumeroMesas);
		add(valNumeroDescontos);
		add(btnLimparBase);
		
		JButton btnCentralDeVendas = new JButton("Central de vendas");
		btnCentralDeVendas.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCentralDeVendas.setBounds(301, 810, 210, 49);
		add(btnCentralDeVendas);
		
		btnLimparBase.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				limparBase();                       
			}
		});
		
		btnCentralDeVendas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				iniciaCentralDeVendas();                       
			}
		});
	}
	
	private void limparBase() {
		try {
			
			// Perguntando ao usuário se ele tem certeza que deseja limpar a base.
			int resposta = JOptionPane.showConfirmDialog(null, "Isso apagará toda a base de dados\nVocê tem certeza?", 
					"Atenção!", JOptionPane.YES_OPTION);
			
			if (resposta == JOptionPane.YES_OPTION) {
				this.principal.limparBase();
				this.frame.reloadAllPrincipal();
			}
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void iniciaCentralDeVendas() {
		try {
			this.frame.criaAbasVendas();
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}
}
