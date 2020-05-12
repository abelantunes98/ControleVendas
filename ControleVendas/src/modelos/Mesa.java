package modelos;

import java.util.ArrayList;
import java.io.Serializable;
import java.util.List;

public class Mesa implements Serializable {
	
	/**
	 * Serial
	 */
	private static final long serialVersionUID = 4751170594807362672L;
	private String codigoMesa;
	private int lugaresMesa;
	private List<Integer> vendasMesa;
	
	public Mesa(String codigoMesa, int lugaresMesa) {
		super();
		this.codigoMesa = codigoMesa;
		this.lugaresMesa = lugaresMesa;
		this.vendasMesa = new ArrayList<Integer>();
	}

	public String getCodigoMesa() {
		return codigoMesa;
	}

	public void setCodigoMesa(String codigoMesa) {
		this.codigoMesa = codigoMesa;
	}

	public int getLugaresMesa() {
		return lugaresMesa;
	}

	public void setLugaresMesa(int lugaresMesa) {
		this.lugaresMesa = lugaresMesa;
	}

	public List<Integer> getVendasMesa() {
		return vendasMesa;
	}

	public void setVendasMesa(List<Integer> vendasMesa) {
		this.vendasMesa = vendasMesa;
	}
	
	public void adicionaVendaListaVendas(int keyVenda) {
		this.vendasMesa.add(keyVenda);
	}
	
	public void zerarListaVendas() {
		this.vendasMesa = new ArrayList<Integer>();
	}
	
	@Override
	public String toString() {
		return "Código da Mesa: " + codigoMesa + "     Lugares na Mesa: " + lugaresMesa;
	}
	
}
