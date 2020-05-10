package controladores;

import baseDados.BaseDados;
import modelos.Mesa;

public class ControleMesas {
	
	
	BaseDados base;

	public ControleMesas() {

		base = new BaseDados();
	}


	public void adicionarMesa(String codigoMesa, int lugaresMesa) {

		try {
			Mesa mesa = new Mesa(codigoMesa, lugaresMesa);
			base.inserirMesa(codigoMesa, mesa);
		}
		catch(Exception e) {
			throw e;
		}
	}
	
	public void removerMesa(String codigoMesa) {
		
		try {
			base.removerMesa(codigoMesa);
		}
		catch (Exception e) {
			throw e;
		}
	}
	
	public boolean mesaExiste(String codigoMesa) {
		
		return base.existeMesa(codigoMesa);
	}

}
