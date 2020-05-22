package controladores;

import java.text.DecimalFormat;
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

	public ControleFaturamentos(BaseDados base) {

		this.base = base;
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
	 * Pega a chave da venda pelo método getNewKey da classe Faturamento.
	 */
	private void adicionarVenda(String codigoFaturamento, Venda venda) {
		
		try {
			Faturamento faturamentoDia = base.retornaFaturamento(codigoFaturamento);
			int key = faturamentoDia.getNewKey();
			faturamentoDia.adicionaVenda(venda, key);
			
			double novoApurado = faturamentoDia.getValorApurado();
			novoApurado += venda.getValorVenda();
			faturamentoDia.setValorApurado(novoApurado);
			
			base.alteraFaturamento(codigoFaturamento, faturamentoDia);
		}
		catch (Exception e) {
			throw e;
		}
	}
	
	/*
	 * Cria uma venda para adiciona-la.
	 * O codigo da mesa é passado como null caso a venda seja
	 * realizada pelo caixa.
	 */
	public void criaVenda(String codigoFaturamento, String codigoFuncionario, String codigoProduto, 
			String nomeProduto, String codigoMesa, int quantProdutos, double valorVenda, String codigoDesconto) {
		try {
			Venda venda = new Venda(codigoFuncionario, codigoProduto, nomeProduto, quantProdutos, valorVenda);
			
			if (codigoDesconto != null) {
				venda.setCodigoDesconto(codigoDesconto);
			}
			if (codigoMesa != null) {
				venda.setCodigoMesa(codigoMesa);
			}
			
			this.adicionarVenda(codigoFaturamento, venda);
		}
		catch (Exception e) {
			new IllegalArgumentException("Erro ao adicionar venda.");
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
				List<Venda> vendasFaturamento = faturamentoPassado.getListVendas();
				for (Venda venda : vendasFaturamento) {
					if (venda.getCodigoFuncionario().equals(codigoFuncionario)) {
						valorRetorno += venda.getValorVenda();
					}
				}
				
				return valorRetorno;
			}
			
			else {
				throw new IllegalArgumentException("Funcionario inexistente.");
			}
		}
		catch(Exception e){
			throw e;
		}
	}
	
	public double retornaValorFaturamentoPorMesa(String codigoFaturamento, String codigoMesa) {
		
		try {
			Faturamento faturamentoPassado = base.retornaFaturamento(codigoFaturamento);
			if (base.existeMesa(codigoMesa)) {
				double valorRetorno = 0;
				List<Venda> vendasFaturamento = faturamentoPassado.getListVendas();
				for (Venda venda : vendasFaturamento) {
					if (venda.getCodigoMesa().equals(codigoMesa)) {
						valorRetorno += venda.getValorVenda();
					}
				}
				
				return valorRetorno;
			}
			
			else {
				throw new IllegalArgumentException("Mesa inexistente.");
			}
		}
		catch(Exception e){
			throw e;
		}
	}
	
	public double retornaValorFaturamentoPorProduto(String codigoFaturamento, String codigoProduto) {
		
		try {
			Faturamento faturamentoPassado = base.retornaFaturamento(codigoFaturamento);
			if (base.existeProduto(codigoProduto)) {
				double valorRetorno = 0;
				List<Venda> vendasFaturamento = faturamentoPassado.getListVendas();
				for (Venda venda : vendasFaturamento) {
					if (venda.getCodigoProduto().equals(codigoProduto)) {
						valorRetorno += venda.getValorVenda();
					}
				}
				
				return valorRetorno;
			}
			
			else {
				throw new IllegalArgumentException("Produto inexistente.");
			}
		}
		catch(Exception e){
			throw e;
		}
	}

	public int retornaNumeroDeVendas(String codigoFaturamento) {
		
		try {
			Faturamento faturamentoPassado = base.retornaFaturamento(codigoFaturamento);
			return faturamentoPassado.getNewKey();
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
				List<Venda> vendasFaturamento = faturamentoPassado.getListVendas();
				for (Venda venda : vendasFaturamento) {
					if (venda.getCodigoFuncionario().equals(codigoFuncionario)) {
						valorRetorno++;
					}
				}
				
				return valorRetorno;
			}
			
			else {
				throw new IllegalArgumentException("Funcionario inexistente.");
			}
		}
		catch(Exception e){
			throw e;
		}
	}
	
	public int retornaNumeroDeVendasPorMesa(String codigoFaturamento, String codigoMesa) {
		
		try {
			Faturamento faturamentoPassado = base.retornaFaturamento(codigoFaturamento);
			if (base.existeMesa(codigoMesa)) {
				int valorRetorno = 0;
				List<Venda> vendasFaturamento = faturamentoPassado.getListVendas();
				for (Venda venda : vendasFaturamento) {
					if (venda.getCodigoMesa().equals(codigoMesa)) {
						valorRetorno++;
					}
				}
				
				return valorRetorno;
			}
			
			else {
				throw new IllegalArgumentException("Mesa inexistente.");
			}
		}
		catch(Exception e){
			throw e;
		}
	}
	
	public int retornaNumeroDeVendasPorProduto(String codigoFaturamento, String codigoProduto) {
		
		try {
			Faturamento faturamentoPassado = base.retornaFaturamento(codigoFaturamento);
			if (base.existeProduto(codigoProduto)) {
				int valorRetorno = 0;
				List<Venda> vendasFaturamento = faturamentoPassado.getListVendas();
				for (Venda venda : vendasFaturamento) {
					if (venda.getCodigoProduto().equals(codigoProduto)) {
						valorRetorno++;
					}
				}
				
				return valorRetorno;
			}
			
			else {
				throw new IllegalArgumentException("Produto inexistente.");
			}
		}
		catch(Exception e){
			throw e;
		}
	}
	
	/*
	 * Trás os detalhes de cada venda que tenha seu id contido na lista passada.
	 * Claro que é necessário a venda está presente no faturamento.
	 */
	public String [][] retornaDadosVendasPorListaDeIds(String codigoFaturamento, List<Integer> lista) {
		
		try {
			Faturamento faturamento = this.base.retornaFaturamento(codigoFaturamento);
			String [][] saida = new String[lista.size()][6];
			
			int indice = 0;
			for (int id : lista) {
				String [] detalhe = faturamento.retornaDetalhesVenda(id);
				saida[indice++] = detalhe;
			}
			
			return saida;
		}
		catch (Exception e) {
			throw e;
		}
	}
	
	/*
	 * Retorna detalhes das vendas de um funcionário em um determinado faturamento.
	 */
	public String [][] retornaDadosVendasPorFuncionario(String codigoFaturamento, String codigoFuncionario) {
		
		try {
			Faturamento faturamento = this.base.retornaFaturamento(codigoFaturamento);
			
			int numVendas = this.retornaNumeroDeVendasPorFuncionario(codigoFaturamento, codigoFuncionario);
			if (numVendas == 0) {
				throw new IllegalArgumentException("Não há vendas do funcionário nesse faturamento.");
			}
			String [][] saida = new String[numVendas][6];
			
			String formato = "R$ #,##0.00";
			DecimalFormat d = new DecimalFormat(formato);
			List<Venda> vendas = faturamento.getListVendas();
			int indice = 0;
			for (Venda venda : vendas) {
				if (venda.getCodigoFuncionario().equals(codigoFuncionario)) {	
					String [] detalhe = new String[6];
					detalhe[0] = venda.getCodigoProduto();
					detalhe[1] = venda.getNomeProduto();
					detalhe[2] = Integer.toString(venda.getQuantProdutos());
					detalhe[3] = (d.format(venda.getValorVenda()));
					detalhe[4] = venda.getCodigoDesconto();
					detalhe[5] = codigoFuncionario;
		
					saida[indice++] = detalhe;
				}
			}
			
			return saida;
		}
		catch (Exception e) {
			throw e;
		}
	}
	
	/*
	 * Retorna detalhes das vendas em uma mesa em um determinado faturamento.
	 */
	public String [][] retornaDadosVendasPorMesa(String codigoFaturamento, String codigoMesa) {
		
		try {
			Faturamento faturamento = this.base.retornaFaturamento(codigoFaturamento);
			
			int numVendas = this.retornaNumeroDeVendasPorMesa(codigoFaturamento, codigoMesa);
			if ( numVendas == 0) {
				throw new IllegalArgumentException("Não há vendas na mesa nesse faturamento.");
			}
			String [][] saida = new String[numVendas][6];
			
			String formato = "R$ #,##0.00";
			DecimalFormat d = new DecimalFormat(formato);
			List<Venda> vendas = faturamento.getListVendas();
			int indice = 0;
			for (Venda venda : vendas) {
				if (venda.getCodigoMesa().equals(codigoMesa)) {	
					String [] detalhe = new String[6];
					detalhe[0] = venda.getCodigoProduto();
					detalhe[1] = venda.getNomeProduto();
					detalhe[2] = Integer.toString(venda.getQuantProdutos());
					detalhe[3] = (d.format(venda.getValorVenda()));
					detalhe[4] = venda.getCodigoDesconto();
					detalhe[5] = venda.getCodigoFuncionario();
		
					saida[indice++] = detalhe;
				}
			}
			
			return saida;
		}
		catch (Exception e) {
			throw e;
		}
	}
	
	/*
	 * Retorna detalhes das vendas de um produto em um determinado faturamento.
	 */
	public String [][] retornaDadosVendasPorProduto(String codigoFaturamento, String codigoProduto) {
		
		try {
			Faturamento faturamento = this.base.retornaFaturamento(codigoFaturamento);
			
			int numVendas = this.retornaNumeroDeVendasPorProduto(codigoFaturamento, codigoProduto);
			if ( numVendas == 0) {
				throw new IllegalArgumentException("Não há vendas do produto nesse faturamento.");
			}
			String [][] saida = new String[numVendas][6];
			
			String formato = "R$ #,##0.00";
			DecimalFormat d = new DecimalFormat(formato);
			List<Venda> vendas = faturamento.getListVendas();
			int indice = 0;
			for (Venda venda : vendas) {
				if (venda.getCodigoProduto().equals(codigoProduto)) {	
					String [] detalhe = new String[6];
					detalhe[0] = venda.getCodigoProduto();
					detalhe[1] = venda.getNomeProduto();
					detalhe[2] = Integer.toString(venda.getQuantProdutos());
					detalhe[3] = (d.format(venda.getValorVenda()));
					detalhe[4] = venda.getCodigoDesconto();
					detalhe[5] = venda.getCodigoFuncionario();
		
					saida[indice++] = detalhe;
				}
			}
			
			return saida;
		}
		catch (Exception e) {
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
				String key = keys.get(indice++);
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
				String key = keys.get(indice++);
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
	
	public void limparFaturamentos() {
		try {
			this.base.limparFaturamentos();
		}
		catch (Exception e) {
			throw e;
		}
	}
	
	public int retornaNumeroFaturamentos() {
		try {
			return this.base.retornaNumeroFaturamentos();
		}
		catch (Exception e) {
			throw e;
		}
	}
	
	public String retornaDataFaturamento(String codigoFaturamento) {
		try {
			Faturamento faturamento = this.base.retornaFaturamento(codigoFaturamento);
			String retorno = faturamento.getDataFaturamento();
			return retorno;
		}
		catch (Exception e) {
			throw e;
		}
	}
	
	public String [][] retornaVetorToStringVendas(String codigoFaturamento) {

		try {
			String [][] retorno = new String [this.retornaNumeroDeVendas(codigoFaturamento)][];
			int indice = 0;
			List<Venda> vendas = this.base.retornaFaturamento(codigoFaturamento).getListVendas();
			for (Venda venda : vendas) {
				String [] linha = {venda.toString()}; 
				retorno[indice++] = linha;
			}

			return retorno;
		}
		catch (Exception e) {
			throw e;
		}
	}
}
