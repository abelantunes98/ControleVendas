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
	
	public double retornaValorFaturamentoPorFuncionario(String codigoFaturamento, String codigoFuncionario) {
		
		try {
			Faturamento faturamentoPassado = base.retornaFaturamento(codigoFaturamento);
			if (base.existeFuncionario(codigoFuncionario)) {
				double valorRetorno = 0;
				List<Venda> vendasFaturamento = faturamentoPassado.getVendas();
				for (Venda venda : vendasFaturamento) {
					if (venda.getCodigoFuncionario().equals(codigoFuncionario)) {
						valorRetorno += venda.getValorVenda();
					}
				}
				
				return valorRetorno;
			}
			
			else {
				throw new IllegalArgumentException("Funcionario inexistente");
			}
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
	
	public int retornaNumeroDeVendasPorFuncionario(String codigoFaturamento, String codigoFuncionario) {
		
		try {
			Faturamento faturamentoPassado = base.retornaFaturamento(codigoFaturamento);
			if (base.existeFuncionario(codigoFuncionario)) {
				int valorRetorno = 0;
				List<Venda> vendasFaturamento = faturamentoPassado.getVendas();
				for (Venda venda : vendasFaturamento) {
					if (venda.getCodigoFuncionario().equals(codigoFuncionario)) {
						valorRetorno++;
					}
				}
				
				return valorRetorno;
			}
			
			else {
				throw new IllegalArgumentException("Funcionario inexistente");
			}
		}
		catch(Exception e){
			throw e;
		}
	}
	
	/*
	 * Calcula a porcentagem que o funcionario deve receber em cima de suas vendas.
	 * Eh necessario passar a porcentagem adotada.
	 */
	public double retornaPorcentagemFuncionario(String codigoFaturamento, String codigoFuncionario, double porcentagem) {
		
		double valorRetorno = 0;
		
		try {
			double valorTotal = this.retornaValorFaturamentoPorFuncionario(codigoFaturamento, codigoFuncionario);
			valorRetorno = valorTotal * (porcentagem / 100);
			
			return valorRetorno; 
		} 
		catch (Exception e) {
			throw e;
		}
		
	}
}
