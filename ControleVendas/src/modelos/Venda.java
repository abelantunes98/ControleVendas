package modelos;

import java.util.Date;

public class Venda {
	
	private String codigoFuncionario;
	private String codigoProduto;
	private String codigoMesa;
	private String codigoDesconto;
	
	private int quantProdutos;
	
	private double valorVenda;
	
	private Date dataVenda;

	
	public Venda(String codigoFuncionario, String codigoProduto, String codigoMesa, int quantProdutos,
			double valorVenda) {
		super();
		this.codigoFuncionario = codigoFuncionario;
		this.codigoProduto = codigoProduto;
		this.codigoMesa = codigoMesa;
		this.quantProdutos = quantProdutos;
		this.valorVenda = valorVenda;
		this.dataVenda = new Date();
	}


	public String getCodigoFuncionario() {
		return codigoFuncionario;
	}


	public void setCodigoFuncionario(String codigoFuncionario) {
		this.codigoFuncionario = codigoFuncionario;
	}


	public String getCodigoProduto() {
		return codigoProduto;
	}


	public void setCodigoProduto(String codigoProduto) {
		this.codigoProduto = codigoProduto;
	}


	public String getCodigoMesa() {
		return codigoMesa;
	}


	public void setCodigoMesa(String codigoMesa) {
		this.codigoMesa = codigoMesa;
	}


	public String getCodigoDesconto() {
		return codigoDesconto;
	}


	public void setCodigoDesconto(String codigoDesconto) {
		this.codigoDesconto = codigoDesconto;
	}


	public int getQuantProdutos() {
		return quantProdutos;
	}


	public void setQuantProdutos(int quantProdutos) {
		this.quantProdutos = quantProdutos;
	}


	public double getValorVenda() {
		return valorVenda;
	}


	public void setValorVenda(double valorVenda) {
		this.valorVenda = valorVenda;
	}


	public Date getDataVenda() {
		return dataVenda;
	}


	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}


	@Override
	public String toString() {
		return "Venda: \ncodigoFuncionario: " + codigoFuncionario + "\ncodigoProduto: " + codigoProduto + "\ncodigoMesa: "
				+ codigoMesa + "\ncodigoDesconto: " + codigoDesconto + "\nquantProdutos: " + quantProdutos
				+ "\nvalorVenda: " + valorVenda + "\ndataVenda: " + dataVenda + "\n";
	}
	
	
	
	
}
