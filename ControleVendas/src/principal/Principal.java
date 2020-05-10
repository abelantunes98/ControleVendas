package principal;

import controladores.*;
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
	
	public Principal() {
		this.controleFaturamentos = new ControleFaturamentos();
		this.controleProdutos = new ControleProdutos();
		this.controleMesas = new ControleMesas();
		this.controleFuncionarios = new ControleFuncionarios();
		this.controleDescontos = new ControleDescontos();
	}
	
	public void iniciarFaturamento() {
		
		this.controleFaturamentos.adicionarFaturamento(Integer.toString(++codigoFaturamentoAtual));
	}
	
	/*
	 * 
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

	public int getCodigoFaturamentoAtual() {
		return codigoFaturamentoAtual;
	}

	public void setCodigoFaturamentoAtual(int codigoFaturamentoAtual) {
		this.codigoFaturamentoAtual = codigoFaturamentoAtual;
	}
	
	
}
