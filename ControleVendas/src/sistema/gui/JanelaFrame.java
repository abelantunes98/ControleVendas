package sistema.gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import principal.Principal;
import sistema.gui.principal.AdicionarDescontoPanel;
import sistema.gui.principal.AdicionarFuncionarioPanel;
import sistema.gui.principal.AdicionarMesaPanel;
import sistema.gui.principal.AdicionarProdutoPanel;
import sistema.gui.principal.PrincipalPanel;

// Imports de vendas
import sistema.gui.vendas.VendasPrincipalPanel;
import sistema.gui.vendas.VenderPanel;
import sistema.gui.vendas.CatalogoDescontos;
import sistema.gui.vendas.CatalogoProdutos;
import sistema.gui.vendas.MesasPanel;

// Imports Administrativo
import sistema.gui.administrativo.FaturamentoFuncionarioPanel;

import java.awt.Font;

public class JanelaFrame extends JFrame {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 8994104213026018445L;

	private JPanel contentPane;

	private Principal principal;

	private PrincipalPanel principalPanel;
	private AdicionarFuncionarioPanel adicionarFuncionarioPanel;
	private AdicionarProdutoPanel adicionarProdutoPanel;
	private AdicionarMesaPanel adicionarMesaPanel;
	private AdicionarDescontoPanel adicionarDescontoPanel;

	// Panels de vendas
	private VendasPrincipalPanel vendasPrincipalPaner;
	private VenderPanel venderPanel;
	private MesasPanel mesasPanel;
	private CatalogoProdutos catalogoProdutos;
	private CatalogoDescontos catalogoDescontos;
	
	// Panels Administrativo
	private FaturamentoFuncionarioPanel faturamentoFuncionarioPanel;

	private JTabbedPane tabbedPane;

	/**
	 * Create the frame.
	 */
	public JanelaFrame() {

		this.principal = new Principal();

		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		this.principalPanel = new PrincipalPanel(this.principal, this);
		this.adicionarFuncionarioPanel = new AdicionarFuncionarioPanel(this.principal, this);
		this.adicionarProdutoPanel = new AdicionarProdutoPanel(this.principal, this);
		this.adicionarMesaPanel = new AdicionarMesaPanel(this.principal, this);
		//this.adicionarDescontoPanel = new AdicionarDescontoPanel(this.principal, this);
		this.faturamentoFuncionarioPanel = new FaturamentoFuncionarioPanel();

		iniciaContentPane();

		criaAbasPrincipal();

	}

	public void iniciaContentPane() {

		/*
		 * Iniciando contentPane.
		 */
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}


	public void reload() {
		//Setando o container com valores atualizados.
		this.principalPanel = new PrincipalPanel(this.principal, this);
		this.tabbedPane.setComponentAt(0, this.principalPanel);
	}

	public void reloadVendas() {
		this.vendasPrincipalPaner = new VendasPrincipalPanel(principal, this);	
		this.venderPanel = new VenderPanel(principal, this);
		this.mesasPanel = new MesasPanel(principal, this);

		this.tabbedPane.setComponentAt(0, this.vendasPrincipalPaner);
		this.tabbedPane.setComponentAt(1, this.venderPanel);
		this.tabbedPane.setComponentAt(2, this.mesasPanel);
	}

	public void reloadVendasMesas() {
		this.vendasPrincipalPaner = new VendasPrincipalPanel(principal, this);	
		this.mesasPanel = new MesasPanel(principal, this);

		this.tabbedPane.setComponentAt(0, this.vendasPrincipalPaner);
		this.tabbedPane.setComponentAt(2, this.mesasPanel);
	}

	/*
	 * Alterando apenas os títulos das abas principais.
	 */
	public void setTitulosPrincipal() {
		this.tabbedPane.setTitleAt(0, "Principal");
		this.tabbedPane.setTitleAt(1, "Cadastrar funcionário");
		this.tabbedPane.setTitleAt(2, "Adicionar produto");
		this.tabbedPane.setTitleAt(3, "Adicionar mesa");
		this.tabbedPane.setTitleAt(4, "Adicionar desconto");
	}

	public void reloadAllPrincipal() {
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

	public void criaAbasPrincipal() {
		/*
		 * Adicionando abas.
		 */
		iniciaContentPane();
		this.tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		this.tabbedPane.setFont(new Font("Tahoma", Font.PLAIN, 25));

		this.tabbedPane.addTab("Principal", this.principalPanel);
		this.tabbedPane.addTab("Cadastrar funcionário", this.adicionarFuncionarioPanel);
		this.tabbedPane.addTab("Adicionar produto", this.adicionarProdutoPanel);
		this.tabbedPane.addTab("Adicionar mesa", this.adicionarMesaPanel);
		this.tabbedPane.addTab("Adicionar desconto", this.faturamentoFuncionarioPanel);

		this.contentPane.add(tabbedPane, BorderLayout.CENTER);
	}

	public void criaAbasVendas() {

		/*
		 * Criando Abas.
		 */
		this.vendasPrincipalPaner = new VendasPrincipalPanel(this.principal, this);
		this.venderPanel = new VenderPanel(this.principal, this);
		this.mesasPanel = new MesasPanel(this.principal, this);
		this.catalogoProdutos = new CatalogoProdutos(this.principal);
		this.catalogoDescontos = new CatalogoDescontos(this.principal);

		this.tabbedPane.setTitleAt(0, "Central de vendas");
		this.tabbedPane.setTitleAt(1, "Adicionar venda");
		this.tabbedPane.setTitleAt(2, "Painel de mesas");
		this.tabbedPane.setTitleAt(3, "Catálogo de produtos");
		this.tabbedPane.setTitleAt(4, "Catálogo de descontos");

		this.tabbedPane.setComponentAt(0, this.vendasPrincipalPaner);
		this.tabbedPane.setComponentAt(1, this.venderPanel);
		this.tabbedPane.setComponentAt(2, this.mesasPanel);
		this.tabbedPane.setComponentAt(3, this.catalogoProdutos);
		this.tabbedPane.setComponentAt(4, this.catalogoDescontos);
	}

}
