package modelos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import modelos.Venda;

public class Faturamento {
	
	private String codigoFaturamento;
	private Date dataFaturamento;
	private double valorApurado;
	
	private List<Venda> vendas;
	
	public Faturamento(String codigoFaturamento) {
		vendas = new ArrayList<Venda>();
		dataFaturamento = new Date();
		
		this.codigoFaturamento = codigoFaturamento;
	}

	public String getCodigoFaturamento() {
		return codigoFaturamento;
	}

	public void setCodigoFaturamento(String codigoFaturamento) {
		this.codigoFaturamento = codigoFaturamento;
	}

	public Date getDataFaturamento() {
		return dataFaturamento;
	}

	public void setDataFaturamento(Date dataFaturamento) {
		this.dataFaturamento = dataFaturamento;
	}

	public double getValorApurado() {
		return valorApurado;
	}

	public void setValorApurado(double valorApurado) {
		this.valorApurado = valorApurado;
	}

	public List<Venda> getVendas() {
		return vendas;
	}

	public void setVendas(List<Venda> vendas) {
		this.vendas = vendas;
	}

	@Override
	public String toString() {
		return "Faturamento: \ncodigoFaturamento: " + codigoFaturamento + "\ndataFaturamento: " + dataFaturamento
				+ "\nvalorApurado=" + valorApurado + "\n";
	}
	
	
	
}
