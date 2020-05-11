package controladores;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import baseDados.BaseDados;
import modelos.Faturamento;
import modelos.Venda;
import utils.Util;
import utils.TuplaFaturamentoDataValor;

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
	
	/*
	 * Retorna, caso exista, o código do faturamento na data passada.
	 * Converte a data passada e a data armazenada em cada Faturamento
	 * para Date. Pois com Date a comparação é mais exata.
	 * 
	 */
	public String retornaCodigoFaturamentoPorData(String data) {
		
		try {
			Date dataFormatada = Util.stringToDate(data);
			
			String retorno = null;
			List<String> keys = base.retornaCodigosFaturamento();
			int indice = 0;
			int tamanhoSet = keys.size();
			while (indice < tamanhoSet && retorno == null) {
				String key = keys.get(indice);
				Faturamento faturamentoKey = base.retornaFaturamento(key);
				String dataFaturamentoKey = faturamentoKey.getDataFaturamento();
				Date dataFaturamentoKeyDate = Util.stringToDate(dataFaturamentoKey);
				
				if (dataFormatada.getTime() == dataFaturamentoKeyDate.getTime()) {
					retorno = key;
				}
			}
			
			if (retorno != null) {
				return retorno;
			}
			else {
				throw new IllegalArgumentException("Sem Faturamento na data passada.");
			}	
		}
		catch (Exception e) {
			throw e;
		}
	}
	
	/*
	 * Recebe duas datas, uma inicial e uma final.
	 * Retorna uma lista de tuplas que contém o código de faturamento,
	 * a data do faturamento e o valor do faturamento.
	 * Isso para os faturamentos que foram criados entre as datas passadas.
	 */
	public List<TuplaFaturamentoDataValor> retornaFaturamentosPorIntervaloDatas(String dataInicio, String dataFinal) {
		
		try {
			Date dataInicioFormatada = Util.stringToDate(dataInicio);
			Date dataFinalFormatada = Util.stringToDate(dataFinal);
			
			double valorFaturamento;
			List<TuplaFaturamentoDataValor> retorno = new ArrayList<TuplaFaturamentoDataValor>();
			List<String> keys = base.retornaCodigosFaturamento();
			int indice = 0;
			int tamanhoSet = keys.size();
			while (indice < tamanhoSet) {
				String key = keys.get(indice);
				Faturamento faturamentoKey = base.retornaFaturamento(key);
				String dataFaturamentoKey = faturamentoKey.getDataFaturamento();
				Date dataFaturamentoKeyDate = Util.stringToDate(dataFaturamentoKey);
				
				if (dataFaturamentoKeyDate.getTime() >= dataInicioFormatada.getTime() 
						&& dataFaturamentoKeyDate.getTime() <= dataFinalFormatada.getTime()) {
					
					valorFaturamento = faturamentoKey.getValorApurado();
					
					TuplaFaturamentoDataValor elementoTupla = new TuplaFaturamentoDataValor(key, dataFaturamentoKey, valorFaturamento);
					retorno.add(elementoTupla);
				}
			}
			
			if (retorno.size() > 0) {
				return retorno;
			}
			else {
				throw new IllegalArgumentException("Sem Faturamentos nas datas passadas.");
			}	
		}
		catch (Exception e) {
			throw e;
		}
	}
}
