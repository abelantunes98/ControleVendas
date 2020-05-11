package sistema.gui;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import principal.Principal;

public class PrincipalPanel extends JPanel {

	Principal principal;	
	
	/**
	 * Create the panel.
	 */
	public PrincipalPanel(Principal principal) {
		
		this.principal = principal;
		setLayout(null);
		
		JLabel titulo = new JLabel("Controle de Vendas");
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setFont(new Font("Tahoma", Font.PLAIN, 30));
		titulo.setBounds(655, 16, 612, 222);
		add(titulo);
		
		JLabel numeroFuncionarios = new JLabel("Funcionarios cadastrados:");
		numeroFuncionarios.setFont(new Font("Tahoma", Font.PLAIN, 25));
		numeroFuncionarios.setHorizontalAlignment(SwingConstants.LEFT);
		numeroFuncionarios.setBounds(301, 381, 432, 58);
		add(numeroFuncionarios);
		
		JLabel valNumeroFuncionarios = new JLabel(Integer.toString(principal.retornaNumeroFuncionarios()));
		valNumeroFuncionarios.setFont(new Font("Tahoma", Font.PLAIN, 25));
		valNumeroFuncionarios.setBounds(629, 390, 128, 40);
		add(valNumeroFuncionarios);
		
		JLabel numeroProdutos = new JLabel("Produtos cadastrados:");
		numeroProdutos.setFont(new Font("Tahoma", Font.PLAIN, 25));
		numeroProdutos.setBounds(301, 460, 406, 52);
		add(numeroProdutos);
		
		JLabel valNumeroProdutos = new JLabel(Integer.toString(principal.retornaNumeroProdutos()));
		valNumeroProdutos.setFont(new Font("Tahoma", Font.PLAIN, 25));
		valNumeroProdutos.setBounds(629, 466, 91, 40);
		add(valNumeroProdutos);
		
		JLabel numeroMesas = new JLabel("Mesas cadastradas:");
		numeroMesas.setFont(new Font("Tahoma", Font.PLAIN, 25));
		numeroMesas.setBounds(1188, 386, 250, 49);
		add(numeroMesas);
		
		JLabel numeroDescontos = new JLabel("Descontos cadastrados:");
		numeroDescontos.setFont(new Font("Tahoma", Font.PLAIN, 25));
		numeroDescontos.setBounds(1188, 463, 277, 46);
		add(numeroDescontos);
		
		JLabel valNumeroMesas = new JLabel(Integer.toString(principal.retornaNumeroMesas()));
		valNumeroMesas.setFont(new Font("Tahoma", Font.PLAIN, 25));
		valNumeroMesas.setBounds(1480, 390, 109, 49);
		add(valNumeroMesas);
		
		JLabel valNumeroDescontos = new JLabel(Integer.toString(principal.retornaNumeroDescontos()));
		valNumeroDescontos.setFont(new Font("Tahoma", Font.PLAIN, 25));
		valNumeroDescontos.setBounds(1480, 466, 109, 46);
		add(valNumeroDescontos);

	}
	
}
