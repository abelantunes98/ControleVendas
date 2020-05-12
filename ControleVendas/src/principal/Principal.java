package principal;

import controladores.*;

import baseDados.BaseDados;
import modelos.Faturamento;
import modelos.Venda;

public class Principal {
	
	private Faturamento faturamentoDia;
	private int codigoFaturamentoAtual;
	
	private ControleFaturamentos controleFaturamentos;
	private ControleProdutos controleProdutos;
	private ControleMesas controleMesas;
	private ControleFuncionarios controleFuncionarios;
	private ControleDescontos controleDescontos;
	
	private BaseDados base;
	
	public Principal() {
		this.base = new BaseDados();
		
		this.controleFaturamentos = new ControleFaturamentos(base);
		this.controleProdutos = new ControleProdutos(base);
		this.controleMesas = new ControleMesas(base);
		this.controleFuncionarios = new ControleFuncionarios(base);
		this.controleDescontos = new ControleDescontos(base);
	}
	
	public void iniciarFaturamento() {
		
		this.controleFaturamentos.adicionarFaturamento(Integer.toString(++codigoFaturamentoAtual));
	}
	
	public void adicionarFuncionario(String nome, String cpf, String telefone, String email, String codigo) {
		try {
			this.controleFuncionarios.adicionarFuncionario(nome, cpf, telefone, email, codigo);
		}
		catch (Exception e) {
			throw e;
		}
	}
	
	public void cadastrarProduto(String codigoProduto, String nomeProduto, double precoProduto, String descricaoProduto) {
		try {
			this.controleProdutos.adicionarProduto(codigoProduto, nomeProduto, precoProduto, descricaoProduto);
		}
		catch (Exception e) {
			throw e;
		}
	}
	
	public void cadastrarMesa(String codigoMesa, int lugaresMesa) {
		try {
			this.controleMesas.adicionarMesa(codigoMesa, lugaresMesa);
		}
		catch (Exception e) {
			throw e;
		}
	}
	
	public void cadastrarDescontoPorcentagem(String codigoDesconto, String nomeDesconto, String descricaoDesconto, double porcentagemDesconto) {
		try {
			this.controleDescontos.adicionarDescontoPorcentagem(codigoDesconto, nomeDesconto, descricaoDesconto, porcentagemDesconto);
		}
		catch (Exception e) {
			throw e;
		}
	}
	
	public void cadastrarDescontoValor(String codigoDesconto, String nomeDesconto, String descricaoDesconto, double valorDesconto) {
		try {
			this.controleDescontos.adicionarDescontoValor(codigoDesconto, nomeDesconto, descricaoDesconto, valorDesconto);
		}
		catch (Exception e) {
			throw e;
		}
	}
	
	/*
	 * Adiciona uma Venda após verificar a existência de todos os dados.
	 * Caso o codigo de desconto não seja null, verifica o tipo de desconto
	 * e o aplica no valor da Venda.
	 */
	public void adicionarVenda(String codigoFuncionario, String codigoProduto, String codigoMesa, int quantProdutos, String codigoDesconto) {
		
		if (!this.controleFuncionarios.funcionarioExiste(codigoFuncionario)) {
			throw new IllegalArgumentException("Funcionario inexistente.");
		}
		
		if (!this.controleProdutos.produtoExiste(codigoProduto)) {
			throw new IllegalArgumentException("Produto inexistente.");
		}
		
		if (!this.controleMesas.mesaExiste(codigoMesa)) {
			throw new IllegalArgumentException("Mesa inexistente.");
		}
		
		if (quantProdutos <= 0) {
			throw new IllegalArgumentException("Quantidade de produto invalida.");
		}
		
		double valorProduto = this.controleProdutos.retornaValorProduto(codigoProduto);
		
		if (codigoDesconto == null) {
			valorProduto *= quantProdutos;
		}
		else {
			if (!this.controleDescontos.descontoExiste(codigoDesconto)) {
				throw new IllegalArgumentException("Desconto inexistente.");
			}
			
			String tipoDesconto = this.controleDescontos.retornaTipoDesconto(codigoDesconto);
			if (tipoDesconto.equals("Valor")) {
				double valorDesconto = this.controleDescontos.retornaValorDesconto(codigoDesconto);
				valorProduto = ((valorProduto * quantProdutos) - valorDesconto);
			}
			else if (tipoDesconto.equals("Porcentagem")) {
				double porcentagemDesconto = this.controleDescontos.retornaPorcentagemDesconto(codigoDesconto);
				valorProduto = (porcentagemDesconto * (valorProduto * quantProdutos));
			}
		}
		
		Venda venda = new Venda(codigoFuncionario, codigoProduto, codigoMesa, quantProdutos, valorProduto);
		this.controleFaturamentos.adicionarVenda(Integer.toString(this.codigoFaturamentoAtual), venda);
	}
	
	public int retornaNumeroFuncionarios() {
		return controleFuncionarios.retornaNumeroFuncionarios();
	}
	
	public int retornaNumeroProdutos() {
		return controleProdutos.retornaNumeroProdutos();
	}
	
	public int retornaNumeroMesas() {
		return controleMesas.retornaNumeroMesas();
	}
	
	public int retornaNumeroDescontos() {
		return controleDescontos.retornaNumeroDescontos();
	}

	public int getCodigoFaturamentoAtual() {
		return codigoFaturamentoAtual;
	}

	public void setCodigoFaturamentoAtual(int codigoFaturamentoAtual) {
		this.codigoFaturamentoAtual = codigoFaturamentoAtual;
	}
	
	public String [][] retornaVetorToStringMesas() {
		
		try {
			String [][] retorno = this.controleMesas.retornaVetorToStringMesas();
			return retorno;
		}
		catch (Exception e) {
			throw e;
		}
	}
	
	public String [][] retornaVetorToStringDescontos() {
		
		try {
			String [][] retorno = this.controleDescontos.retornaVetorToStringDescontos();
			return retorno;
		}
		catch (Exception e) {
			throw e;
		}
	}
	
	public String [][] retornaVetorToStringProdutos() {
		
		try {
			String [][] retorno = this.controleProdutos.retornaVetorToStringProdutos();
			return retorno;
		}
		catch (Exception e) {
			throw e;
		}
		
	}
}
