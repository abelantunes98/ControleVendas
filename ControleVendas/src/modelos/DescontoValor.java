package modelos;

import modelos.Desconto;

import java.io.Serializable;
import java.text.DecimalFormat;

public class DescontoValor extends Desconto implements Serializable{
	
	/**
	 * Serial
	 */
	private static final long serialVersionUID = 7814155484356631225L;
	private double valorDesconto;
	
	private String formato = "R$ #,##0.00";
	private DecimalFormat d = new DecimalFormat(formato);
	
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
		return super.toString() + "  " + d.format(valorDesconto);
	}
	
	
}
