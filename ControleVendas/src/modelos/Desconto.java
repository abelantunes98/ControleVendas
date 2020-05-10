package modelos;

public class Desconto {
	
	private String codigoDesconto;
	private String nomeDesconto;
	private String descricaoDesconto;
	private double valorDesconto;
	
	
	public Desconto(String codigoDesconto, String nomeDesconto, String descricaoDesconto, double valorDesconto) {
		super();
		this.codigoDesconto = codigoDesconto;
		this.nomeDesconto = nomeDesconto;
		this.descricaoDesconto = descricaoDesconto;
		this.valorDesconto = valorDesconto;
	}


	public String getCodigoDesconto() {
		return codigoDesconto;
	}


	public void setCodigoDesconto(String codigoDesconto) {
		this.codigoDesconto = codigoDesconto;
	}


	public String getNomeDesconto() {
		return nomeDesconto;
	}


	public void setNomeDesconto(String nomeDesconto) {
		this.nomeDesconto = nomeDesconto;
	}


	public String getDescricaoDesconto() {
		return descricaoDesconto;
	}


	public void setDescricaoDesconto(String descricaoDesconto) {
		this.descricaoDesconto = descricaoDesconto;
	}


	public double getValorDesconto() {
		return valorDesconto;
	}


	public void setValorDesconto(double valorDesconto) {
		this.valorDesconto = valorDesconto;
	}


	@Override
	public String toString() {
		return "Desconto: \ncodigoDesconto: " + codigoDesconto + "\nnomeDesconto: " + nomeDesconto + "\ndescricaoDesconto: "
				+ descricaoDesconto + "\nvalorDesconto: " + valorDesconto + "\n";
	}
	
	

}
