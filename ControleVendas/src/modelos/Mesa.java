package modelos;

public class Mesa {
	
	private String codigoMesa;
	private int lugaresMesa;
	
	public Mesa(String codigoMesa, int lugaresMesa) {
		super();
		this.codigoMesa = codigoMesa;
		this.lugaresMesa = lugaresMesa;
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

	@Override
	public String toString() {
		return "Mesa: \ncodigoMesa: " + codigoMesa + "\nlugaresMesa: " + lugaresMesa + "\n";
	}
	
}
