package utils;

public class TuplaFaturamentoDataValor {
	
	private String codigoFaturamento;
	private String dataFaturamento;
	private double valorFaturamento;
	
	
	public TuplaFaturamentoDataValor(String codigoFaturamento, String dataFaturamento, double valorFaturamento) {
		super();
		this.codigoFaturamento = codigoFaturamento;
		this.dataFaturamento = dataFaturamento;
		this.valorFaturamento = valorFaturamento;
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


	public double getValorFaturamento() {
		return valorFaturamento;
	}


	public void setValorFaturamento(double valorFaturamento) {
		this.valorFaturamento = valorFaturamento;
	}


	@Override
	public String toString() {
		return "TuplaFaturamentoDataValor: \ncodigoFaturamento: " + codigoFaturamento + "\ndataFaturamento: "
				+ dataFaturamento + "\nvalorFaturamento: " + valorFaturamento + "\n";
	}
	
	
}
