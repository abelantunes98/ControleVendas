package modelos;

import modelos.Desconto;

public class DescontoValor extends Desconto{
	
	private double valorDesconto;
	
	public DescontoValor(String codigoDesconto, String nomeDesconto, String descricaoDesconto, double valorDesconto) {
		super(codigoDesconto, nomeDesconto, descricaoDesconto, "Valor");
		this.valorDesconto = valorDesconto;
	}

	public double getValorDesconto() {
		return valorDesconto;
	}

	public void setValorDesconto(double valorDesconto) {
		this.valorDesconto = valorDesconto;
	}

	@Override
	public String toString() {
		return super.toString() + "valorDesconto: " + valorDesconto + "\n";
	}
	
	
}
