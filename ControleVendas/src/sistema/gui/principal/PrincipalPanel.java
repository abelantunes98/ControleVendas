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
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

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
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{301, 210, 118, 128, 43, 210, 178, 277, 109, 0};
		gridBagLayout.rowHeights = new int[]{381, 58, 52, 298, 49, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel numeroFuncionarios = new JLabel("Funcionarios cadastrados:");
		numeroFuncionarios.setFont(new Font("Tahoma", Font.PLAIN, 25));
		numeroFuncionarios.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_numeroFuncionarios = new GridBagConstraints();
		gbc_numeroFuncionarios.fill = GridBagConstraints.BOTH;
		gbc_numeroFuncionarios.insets = new Insets(0, 0, 5, 5);
		gbc_numeroFuncionarios.gridwidth = 3;
		gbc_numeroFuncionarios.gridx = 1;
		gbc_numeroFuncionarios.gridy = 1;
		add(numeroFuncionarios, gbc_numeroFuncionarios);
		
		JLabel valNumeroFuncionarios = new JLabel(Integer.toString(principal.retornaNumeroFuncionarios()));
		valNumeroFuncionarios.setFont(new Font("Tahoma", Font.PLAIN, 25));
		GridBagConstraints gbc_valNumeroFuncionarios = new GridBagConstraints();
		gbc_valNumeroFuncionarios.fill = GridBagConstraints.HORIZONTAL;
		gbc_valNumeroFuncionarios.insets = new Insets(0, 0, 5, 5);
		gbc_valNumeroFuncionarios.gridx = 3;
		gbc_valNumeroFuncionarios.gridy = 1;
		add(valNumeroFuncionarios, gbc_valNumeroFuncionarios);
		
		JLabel numeroMesas = new JLabel("Mesas cadastradas:");
		numeroMesas.setFont(new Font("Tahoma", Font.PLAIN, 25));
		GridBagConstraints gbc_numeroMesas = new GridBagConstraints();
		gbc_numeroMesas.fill = GridBagConstraints.BOTH;
		gbc_numeroMesas.insets = new Insets(0, 0, 5, 5);
		gbc_numeroMesas.gridx = 6;
		gbc_numeroMesas.gridy = 1;
		add(numeroMesas, gbc_numeroMesas);
		
		JLabel valNumeroMesas = new JLabel(Integer.toString(principal.retornaNumeroMesas()));
		valNumeroMesas.setFont(new Font("Tahoma", Font.PLAIN, 25));
		GridBagConstraints gbc_valNumeroMesas = new GridBagConstraints();
		gbc_valNumeroMesas.fill = GridBagConstraints.BOTH;
		gbc_valNumeroMesas.insets = new Insets(0, 0, 5, 5);
		gbc_valNumeroMesas.gridx = 7;
		gbc_valNumeroMesas.gridy = 1;
		add(valNumeroMesas, gbc_valNumeroMesas);
		
		JLabel numeroProdutos = new JLabel("Produtos cadastrados:");
		numeroProdutos.setFont(new Font("Tahoma", Font.PLAIN, 25));
		GridBagConstraints gbc_numeroProdutos = new GridBagConstraints();
		gbc_numeroProdutos.fill = GridBagConstraints.BOTH;
		gbc_numeroProdutos.insets = new Insets(0, 0, 5, 5);
		gbc_numeroProdutos.gridwidth = 3;
		gbc_numeroProdutos.gridx = 1;
		gbc_numeroProdutos.gridy = 2;
		add(numeroProdutos, gbc_numeroProdutos);
		
		JLabel valNumeroProdutos = new JLabel(Integer.toString(principal.retornaNumeroProdutos()));
		valNumeroProdutos.setFont(new Font("Tahoma", Font.PLAIN, 25));
		GridBagConstraints gbc_valNumeroProdutos = new GridBagConstraints();
		gbc_valNumeroProdutos.fill = GridBagConstraints.HORIZONTAL;
		gbc_valNumeroProdutos.insets = new Insets(0, 0, 5, 5);
		gbc_valNumeroProdutos.gridx = 3;
		gbc_valNumeroProdutos.gridy = 2;
		add(valNumeroProdutos, gbc_valNumeroProdutos);
		
		JLabel numeroDescontos = new JLabel("Descontos cadastrados:");
		numeroDescontos.setFont(new Font("Tahoma", Font.PLAIN, 25));
		GridBagConstraints gbc_numeroDescontos = new GridBagConstraints();
		gbc_numeroDescontos.fill = GridBagConstraints.BOTH;
		gbc_numeroDescontos.insets = new Insets(0, 0, 5, 5);
		gbc_numeroDescontos.gridx = 6;
		gbc_numeroDescontos.gridy = 2;
		add(numeroDescontos, gbc_numeroDescontos);
		
		JLabel valNumeroDescontos = new JLabel(Integer.toString(principal.retornaNumeroDescontos()));
		valNumeroDescontos.setFont(new Font("Tahoma", Font.PLAIN, 25));
		GridBagConstraints gbc_valNumeroDescontos = new GridBagConstraints();
		gbc_valNumeroDescontos.fill = GridBagConstraints.BOTH;
		gbc_valNumeroDescontos.insets = new Insets(0, 0, 5, 5);
		gbc_valNumeroDescontos.gridx = 7;
		gbc_valNumeroDescontos.gridy = 2;
		add(valNumeroDescontos, gbc_valNumeroDescontos);
		
		JButton btnCentralDeVendas = new JButton("Central de vendas");
		btnCentralDeVendas.setHorizontalAlignment(SwingConstants.LEFT);
		btnCentralDeVendas.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_btnCentralDeVendas = new GridBagConstraints();
		gbc_btnCentralDeVendas.anchor = GridBagConstraints.WEST;
		gbc_btnCentralDeVendas.insets = new Insets(0, 0, 5, 5);
		gbc_btnCentralDeVendas.gridx = 1;
		gbc_btnCentralDeVendas.gridy = 3;
		add(btnCentralDeVendas, gbc_btnCentralDeVendas);
		
		btnCentralDeVendas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				iniciaCentralDeVendas();                       
			}
		});
		
		JButton btnCentralAdministrativo = new JButton("Administrativo");
		btnCentralAdministrativo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_btnCentralAdministrativo = new GridBagConstraints();
		gbc_btnCentralAdministrativo.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCentralAdministrativo.insets = new Insets(0, 0, 5, 5);
		gbc_btnCentralAdministrativo.gridx = 4;
		gbc_btnCentralAdministrativo.gridy = 3;
		add(btnCentralAdministrativo, gbc_btnCentralAdministrativo);
		
		btnCentralAdministrativo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				iniciaCentralAdministrativo();                       
			}
		});
		
		JButton btnLimparBase = new JButton("Limpar base");
		btnLimparBase.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_btnLimparBase = new GridBagConstraints();
		gbc_btnLimparBase.insets = new Insets(0, 0, 5, 5);
		gbc_btnLimparBase.gridwidth = 2;
		gbc_btnLimparBase.gridx = 6;
		gbc_btnLimparBase.gridy = 3;
		add(btnLimparBase, gbc_btnLimparBase);
		
		btnLimparBase.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			limparBase();                       
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
	
	private void iniciaCentralAdministrativo() {
		try {
			this.frame.criaAbasAdministrativo();
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}
}
