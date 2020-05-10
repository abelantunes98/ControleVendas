package modelos;

public class Produto {
	
	private String codigoProduto;
	private String nomeProduto;
	private double precoProduto;
	private String descricaoProduto;
	
	
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
		return "Produto: \ncodigoProduto: " + codigoProduto + "\nnomeProduto: " + nomeProduto + "\nprecoProduto: "
				+ precoProduto + "\ndescricaoProduto: " + descricaoProduto + "\n";
	}
	
	
	
}
