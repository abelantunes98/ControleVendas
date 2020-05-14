package modelos;

import java.text.SimpleDateFormat;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.io.Serializable;

import modelos.Venda;

public class Faturamento implements Serializable{
	
	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1153012768297252642L;
	
	private String codigoFaturamento;
	private String dataFaturamento;
	private double valorApurado;
	
	private HashMap<Integer, Venda> vendas;
	
	public Faturamento(String codigoFaturamento) {
		this.vendas = new HashMap<Integer, Venda>();
		
		Date data = new Date();
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        formato.setLenient(false);
        
		this.dataFaturamento = formato.format(data);
		
		this.codigoFaturamento = codigoFaturamento;
	}
	
	public void adicionaVenda(Venda venda, int key) {
		this.vendas.put(key, venda);
	}
	
	public void removeVenda(int key) {
		if (!this.vendas.containsKey(key)) {
			throw new IllegalArgumentException("Venda n�o cadastrada.");
		}
		
		this.vendas.remove(key);
	}
	
	// Vai retornar um array separado por campos, que ser�o usados em tabelas.
	public String[] retornaDetalhesVenda(int key) {
		try {
			if (!this.vendas.containsKey(key)) {
				throw new IllegalArgumentException("Venda n�o cadastrada.");
			}
			
			String [] saida = new String[6];
			Venda venda = this.vendas.get(key);
			saida[0] = venda.getCodigoProduto();
			saida[1] = venda.getNomeProduto();
			saida[2] = Integer.toString(venda.getQuantProdutos());
			saida[3] = Double.toString(venda.getValorVenda()) + " R$";
			saida[4] = venda.getCodigoDesconto();
			saida[5] = venda.getCodigoFuncionario();
			
			return saida;
		}
		catch (Exception e) {
			throw e;
		}
	}

	public String getCodigoFaturamento() {
		return codigoFaturamento;
	}

	public void setCodigoFaturamento(String codigoFaturamento) {
		this.codigoFaturamento = codigoFaturamento;
	}

	public String getDataFaturamento() {
		return dataFaturamento;
	}

	public void setDataFaturamento(String dataFaturamento) {
		this.dataFaturamento = dataFaturamento;
	}

	public double getValorApurado() {
		return valorApurado;
	}

	public void setValorApurado(double valorApurado) {
		this.valorApurado = valorApurado;
	}

	public HashMap<Integer, Venda> getVendas() {
		return vendas;
	}

	public void setVendas(HashMap<Integer, Venda> vendas) {
		this.vendas = vendas;
	}
	
	public int getNewKey() {
		return this.vendas.size();
	}
	
	public List<Venda> getListVendas() {
		List<Venda> retorno = new ArrayList<Venda>();
		retorno.addAll(this.vendas.values());
		return retorno;
	}

	@Override
	public String toString() {
		return "Faturamento: \ncodigoFaturamento: " + codigoFaturamento + "\ndataFaturamento: " + dataFaturamento
				+ "\nvalorApurado=" + valorApurado + "\n";
	}
	
	
	
}
