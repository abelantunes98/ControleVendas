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

		this.principalPanel = new PrincipalPanel(principal);
		this.adicionarFuncionarioPanel = new AdicionarFuncionarioPanel(principal, this);

		setContentPane(contentPane);

		/*
		 * Adicionando abas.
		 */
		this.tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		this.tabbedPane.setFont(new Font("Tahoma", Font.PLAIN, 20));

		this.tabbedPane.addTab("Principal", this.principalPanel);
		this.tabbedPane.addTab("Cadastrar funcionário", this.adicionarFuncionarioPanel);

		this.contentPane.add(tabbedPane, BorderLayout.CENTER);

	}

	public void reload() {
		//Setando o container com valores atualizados.
		this.principalPanel = new PrincipalPanel(this.principal);
		this.tabbedPane.setComponentAt(0, this.principalPanel);
	}

}
