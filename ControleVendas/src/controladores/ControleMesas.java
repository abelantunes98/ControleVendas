package controladores;

import java.util.List;

import baseDados.BaseDados;
import modelos.Mesa;

public class ControleMesas {
	
	
	BaseDados base;

	public ControleMesas(BaseDados base) {

		this.base = base;
	}


	public void adicionarMesa(String codigoMesa, int lugaresMesa) {

		try {
			if ( codigoMesa.equals("")) {
				throw new IllegalArgumentException("Campos passados vazios!");
			}
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
	
	public int retornaNumeroMesas() {
		return base.retornaNumeroMesas();
	}
	
	public String [][] retornaVetorToStringMesas() {
		
		try {
			String [][] retorno = new String [this.retornaNumeroMesas()][];
			int indice = 0;
			List<Mesa> mesas = this.base.retornaMesas();
			for (Mesa mesa : mesas) {
				String [] linha = {mesa.toString()}; 
				retorno[indice++] = linha;
			}
			
			return retorno;
		}
		catch (Exception e) {
			throw e;
		}
	}
	
	public void limparMesas() {
		try {
			this.base.limparMesas();
		}
		catch (Exception e) {
			throw e;
		}
	}
}
