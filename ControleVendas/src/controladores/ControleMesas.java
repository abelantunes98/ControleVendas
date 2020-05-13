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
	
	public boolean retornaMesaDisponivel(String codigoMesa) {
		try {
			Mesa mesa = this.base.retornaMesa(codigoMesa);
			return mesa.mesaDisponivel();
		}
		catch (Exception e) {
			throw e;
		}
	}
	
	public void ocuparMesa(String codigoMesa) {
		try {
			Mesa mesa = this.base.retornaMesa(codigoMesa);
			if (!mesa.mesaDisponivel()) {
				throw new IllegalArgumentException("A mesa já está ocupada.");
			}
			
			mesa.setMesaDisponivel(false);
			this.base.alteraMesa(codigoMesa, mesa);
		}
		catch (Exception e) {
			throw e;
		}
	}
	
	public void adicionaVendaEmMesa(String codigoMesa, int codigoVenda) {
		try {
			Mesa mesa = this.base.retornaMesa(codigoMesa);
			mesa.adicionaVendaListaVendas(codigoVenda);
		}
		catch (Exception e) {
			throw e;
		}
	}
	
	public void removerVendaEmMesa(String codigoMesa, int codigoVenda) {
		try {
			Mesa mesa = this.base.retornaMesa(codigoMesa);
			mesa.adicionaVendaListaVendas(codigoVenda);
		}
		catch (Exception e) {
			throw e;
		}
	}
	
	public void liberarMesa(String codigoMesa) {
		try {
			Mesa mesa = this.base.retornaMesa(codigoMesa);
			if (mesa.mesaDisponivel()) {
				throw new IllegalArgumentException("A mesa não está ocupada.");
			}
			
			mesa.setMesaDisponivel(true);
			this.base.alteraMesa(codigoMesa, mesa);
		}
		catch (Exception e) {
			throw e;
		}
	}
	
	/*
	 * Olha a disponibilidade da mesa e gera uma String de saída para cada
	 * mesa.
	 */
	public String [][] retornaDisponibilidadeMesas() {
		try {
			String [][] retorno = new String [this.retornaNumeroMesas()][];
			List<Mesa> mesas = this.base.retornaMesas();
			int indice = 0;
			String status;
			for (Mesa mesa : mesas) {
				
				if (mesa.mesaDisponivel()) {
					status = "Disponível";
				}
				else {
					status = "Ocupada";
				}
				String [] linha = {"Código: " + mesa.getCodigoMesa() + "  |  " + status}; 
				retorno[indice++] = linha;
			}
			
			return retorno;
		}
		catch (Exception e) {
			throw e;
		}
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
