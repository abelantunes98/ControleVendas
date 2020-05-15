package modelos;

import java.io.Serializable;
import java.text.DecimalFormat;

public class Produto implements Serializable {
	
	/**
	 * Serial
	 */
	private static final long serialVersionUID = -6119229037137421820L;
	private String codigoProduto;
	private String nomeProduto;
	private double precoProduto;
	private String descricaoProduto;
	
	private String formato = "R$ #,##0.00";
	private DecimalFormat d = new DecimalFormat(formato);
	
	public Produto(String codigoProduto, String nomeProduto, double precoProduto, String descricaoProduto) {
		super();
		this.codigoProduto = codigoProduto;
		this.nomeProduto = nomeProduto;
		this.precoProduto = precoProduto;
		this.descricaoProduto = descricaoProduto;
	}


	public String getCodigoProduto() {
		return codigoProduto;
	}


	public void setCodigoProduto(String codigoProduto) {
		this.codigoProduto = codigoProduto;
	}


	public String getNomeProduto() {
		return nomeProduto;
	}


	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}


	public double getPrecoProduto() {
		return precoProduto;
	}


	public void setPrecoProduto(double precoProduto) {
		this.precoProduto = precoProduto;
	}


	public String getDescricaoProduto() {
		return descricaoProduto;
	}


	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}


	@Override
	public String toString() {
		return "Código: " + codigoProduto + " | Nome: " + nomeProduto + " | Preço: "
				+ d.format(precoProduto);
	}
	
	
	
}
