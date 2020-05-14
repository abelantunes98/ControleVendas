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
	private boolean mesaDisponivel;
	private double totalGastoMesa;
	private List<Integer> vendasMesa;
	
	public Mesa(String codigoMesa, int lugaresMesa) {
		super();
		this.codigoMesa = codigoMesa;
		this.lugaresMesa = lugaresMesa;
		this.totalGastoMesa = 0;
		this.mesaDisponivel = true;
		this.vendasMesa = new ArrayList<Integer>();
	}
	
	public double getTotalGastoMesa() {
		return totalGastoMesa;
	}

	public void setTotalGastoMesa(double totalGastoMesa) {
		this.totalGastoMesa = totalGastoMesa;
	}
	
	public void addGastoMesa(double valor) {
		this.totalGastoMesa += valor;
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
	
	public boolean mesaDisponivel() {
		return this.mesaDisponivel;
	}

	public void setMesaDisponivel(boolean mesaDisponivel) {
		this.mesaDisponivel = mesaDisponivel;
	}
	
	public void adicionaVendaListaVendas(int keyVenda) {
		this.vendasMesa.add(keyVenda);
	}
	
	public void removerVendaListaVendas(int keyVenda) {
		if (!this.vendasMesa.contains(keyVenda)) {
			throw new IllegalArgumentException("Venda não existente na mesa.");
		}
		this.vendasMesa.remove(keyVenda);
	}
	
	public void zerarListaVendas() {
		this.vendasMesa = new ArrayList<Integer>();
	}
	
	@Override
	public String toString() {
		return "Código da Mesa: " + codigoMesa + "     Lugares na Mesa: " + lugaresMesa;
	}
	
}
