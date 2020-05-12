package modelos;

public class Desconto {
	
	private String codigoDesconto;
	private String nomeDesconto;
	private String descricaoDesconto;
	private String tipoDesconto;
	

	public Desconto(String codigoDesconto, String nomeDesconto, String descricaoDesconto, String tipoDesconto) {
		super();
		this.codigoDesconto = codigoDesconto;
		this.nomeDesconto = nomeDesconto;
		this.descricaoDesconto = descricaoDesconto;
		this.tipoDesconto = tipoDesconto;
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

	
	public String getTipoDesconto() {
		return tipoDesconto;
	}


	public void setTipoDesconto(String tipoDesconto) {
		this.tipoDesconto = tipoDesconto;
	}


	@Override
	public String toString() {
		return "Código do desconto: " + codigoDesconto + "     Nome do Desconto: " + nomeDesconto + "    Tipo de desconto: "
				+ this.tipoDesconto;
	}
	
	

}
