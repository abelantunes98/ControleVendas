package modelos;

import modelos.Desconto;

public class DescontoPorcentagem extends Desconto {
	
	private double porcentagemDesconto;
	
	public DescontoPorcentagem(String codigoDesconto, String nomeDesconto, String descricaoDesconto, double porcentagemDesconto) {
		super(codigoDesconto, nomeDesconto, descricaoDesconto, "Porcentagem");
		this.porcentagemDesconto = porcentagemDesconto;
	}

	public double getPorcentagemDesconto() {
		return porcentagemDesconto;
	}

	public void setPorcentagemDesconto(double porcentagemDesconto) {
		this.porcentagemDesconto = porcentagemDesconto;
	}

	@Override
	public String toString() {
		return super.toString() + "  " + porcentagemDesconto + "%";
	}

}
