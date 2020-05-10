package modelos;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import modelos.Venda;

public class Faturamento {
	
	private String codigoFaturamento;
	private String dataFaturamento;
	private double valorApurado;
	
	private List<Venda> vendas;
	
	public Faturamento(String codigoFaturamento) {
		this.vendas = new ArrayList<Venda>();
		
		Date data = new Date();
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        formato.setLenient(false);
        
		this.dataFaturamento = formato.format(data);
		
		this.codigoFaturamento = codigoFaturamento;
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
