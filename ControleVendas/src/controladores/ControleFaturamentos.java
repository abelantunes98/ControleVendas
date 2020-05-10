package controladores;

import java.util.List;

import baseDados.BaseDados;
import modelos.Faturamento;
import modelos.Venda;

public class ControleFaturamentos {
	
	BaseDados base;

	public ControleFaturamentos() {

		base = new BaseDados();
	}


	public void adicionarFaturamento(String codigoFaturamento) {

		try {
			Faturamento faturamento = new Faturamento(codigoFaturamento);
			base.inserirFaturamento(codigoFaturamento, faturamento);
		}
		catch(Exception e) {
			throw e;
		}
	}
	
	public void removerFaturamento(String codigoFaturamento) {
		
		try {
			base.removerFaturamento(codigoFaturamento);
		}
		catch (Exception e) {
			throw e;
		}
	}
	
	/*
	 * Adiciona uma nova venda na lista de vendas do Faturamento em questao
	 * e adiciona o valor da venda no valor do Faturamento.
	 */
	public void adicionarVenda(String codigoFaturamento, Venda venda) {
		
		try {
			Faturamento faturamentoDia = base.retornaFaturamento(codigoFaturamento);
			List<Venda> vendasDia = faturamentoDia.getVendas();
			vendasDia.add(venda);
			
			double novoApurado = faturamentoDia.getValorApurado();
			novoApurado += venda.getValorVenda();
			faturamentoDia.setValorApurado(novoApurado);
			
			faturamentoDia.setVendas(vendasDia);
			base.alteraFaturamento(codigoFaturamento, faturamentoDia);
		}
		catch (Exception e) {
			throw e;
		}
	}
	
	public double retornaValorFaturamento(String codigoFaturamento) {
		
		try {
			Faturamento faturamentoPassado = base.retornaFaturamento(codigoFaturamento);
			return faturamentoPassado.getValorApurado();
		}
		catch(Exception e){
			throw e;
		}
	}
	
	public int retornaNumeroDeVendas(String codigoFaturamento) {
		
		try {
			Faturamento faturamentoPassado = base.retornaFaturamento(codigoFaturamento);
			List<Venda> vendas = faturamentoPassado.getVendas();
			return vendas.size();
		}
		catch(Exception e){
			throw e;
		}
	}
}
