package sistema.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import principal.Principal;
import java.awt.Font;

public class JanelaFrame extends JFrame {

	private JPanel contentPane;

	private Principal principal;
	
	private PrincipalPanel principalPanel;
	private AdicionarFuncionarioPanel adicionarFuncionarioPanel;
	private AdicionarProdutoPanel adicionarProdutoPanel;
	private AdicionarMesaPanel adicionarMesaPanel;
	private AdicionarDescontoPanel adicionarDescontoPanel;
	
	private JTabbedPane tabbedPane;

	/**
	 * Create the frame.
	 */
	public JanelaFrame() {

		this.principal = new Principal();

		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.contentPane.setLayout(new BorderLayout(0, 0));

		this.principalPanel = new PrincipalPanel(this.principal, this);
		this.adicionarFuncionarioPanel = new AdicionarFuncionarioPanel(this.principal, this);
		this.adicionarProdutoPanel = new AdicionarProdutoPanel(this.principal, this);
		this.adicionarMesaPanel = new AdicionarMesaPanel(this.principal, this);
		this.adicionarDescontoPanel = new AdicionarDescontoPanel(this.principal, this);

		setContentPane(contentPane);

		/*
		 * Adicionando abas.
		 */
		this.tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		this.tabbedPane.setFont(new Font("Tahoma", Font.PLAIN, 20));

		this.tabbedPane.addTab("Principal", this.principalPanel);
		this.tabbedPane.addTab("Cadastrar funcionário", this.adicionarFuncionarioPanel);
		this.tabbedPane.addTab("Adicionar produto", this.adicionarProdutoPanel);
		this.tabbedPane.addTab("Adicionar mesa", this.adicionarMesaPanel);
		this.tabbedPane.addTab("Adicionar desconto", this.adicionarDescontoPanel);

		
		this.contentPane.add(tabbedPane, BorderLayout.CENTER);

	}

	public void reload() {
		//Setando o container com valores atualizados.
		this.principalPanel = new PrincipalPanel(this.principal, this);
		this.tabbedPane.setComponentAt(0, this.principalPanel);
	}
	
	public void reloadAll() {
		//Setando o container com valores atualizados.
		this.principalPanel = new PrincipalPanel(this.principal, this);
		this.adicionarFuncionarioPanel = new AdicionarFuncionarioPanel(this.principal, this);
		this.adicionarProdutoPanel = new AdicionarProdutoPanel(this.principal, this);
		this.adicionarMesaPanel = new AdicionarMesaPanel(this.principal, this);
		this.adicionarDescontoPanel = new AdicionarDescontoPanel(this.principal, this);
		
		this.tabbedPane.setComponentAt(0, this.principalPanel);
		this.tabbedPane.setComponentAt(1, this.adicionarFuncionarioPanel);
		this.tabbedPane.setComponentAt(2, this.adicionarProdutoPanel);
		this.tabbedPane.setComponentAt(3, this.adicionarMesaPanel);
		this.tabbedPane.setComponentAt(4, this.adicionarDescontoPanel);
	}

}
