package controladores;

import java.util.List;

import baseDados.BaseDados;

import modelos.Desconto;
import modelos.DescontoValor;
import modelos.DescontoPorcentagem;

public class ControleDescontos {

	BaseDados base;

	public ControleDescontos(BaseDados base) {
		
		this.base = base;
	}


	public void adicionarDescontoValor(String codigoDesconto, String nomeDesconto, String descricaoDesconto, double valorDesconto) {

		try {
			if ( codigoDesconto.equals("") || nomeDesconto.equals("") || descricaoDesconto.equals("")) {
				throw new IllegalArgumentException("Campos passados vazios!");
			}
			DescontoValor desconto = new DescontoValor(codigoDesconto, nomeDesconto, descricaoDesconto, valorDesconto);
			base.inserirDesconto(codigoDesconto, desconto);
		}
		catch(Exception e) {
			throw e;
		}
	}
	
	public void adicionarDescontoPorcentagem(String codigoDesconto, String nomeDesconto, String descricaoDesconto, double porcentagemDesconto) {

		try {
			if ( codigoDesconto.equals("") || nomeDesconto.equals("") || descricaoDesconto.equals("")) {
				throw new IllegalArgumentException("Campos passados vazios!");
			}
			DescontoPorcentagem desconto = new DescontoPorcentagem(codigoDesconto, nomeDesconto, descricaoDesconto, porcentagemDesconto);
			base.inserirDesconto(codigoDesconto, desconto);
		}
		catch(Exception e) {
			throw e;
		}
	}
	
	public void removerDesconto(String codigoDesconto) {
		
		try {
			base.removerDesconto(codigoDesconto);
		}
		catch (Exception e) {
			throw e;
		}
	}
	
	public boolean descontoExiste(String codigoDesconto) {
		
		return base.existeDesconto(codigoDesconto);
	}
	
	public String retornaTipoDesconto(String codigoDesconto) {
		
		try {
			Desconto desconto = base.retornaDesconto(codigoDesconto);
			return desconto.getTipoDesconto();
		}
		catch (Exception e) {
			throw e;
		}
	}
	
	public double retornaValorDesconto(String codigoDesconto) {
		
		try {
			Desconto desconto = base.retornaDesconto(codigoDesconto);
			
			if (desconto.getTipoDesconto().equals("Valor")) {
				return ((DescontoValor) desconto).getValorDesconto();
			}
			else {
				throw new IllegalArgumentException("Tipo desconto errado.");
			}
		}
		catch (Exception e) {
			throw e;
		}
	}
	
	public double retornaPorcentagemDesconto(String codigoDesconto) {
		
		try {
			Desconto desconto = base.retornaDesconto(codigoDesconto);
			
			if (desconto.getTipoDesconto().equals("Porcentagem")) {
				return ((DescontoPorcentagem) desconto).getPorcentagemDesconto();
			}
			else {
				throw new IllegalArgumentException("Tipo desconto errado.");
			}
		}
		catch (Exception e) {
			throw e;
		}
	}
	
	public int retornaNumeroDescontos() {
		return base.retornaNumeroDescontos();
	}
	
	public String [][] retornaVetorToStringDescontos() {
		
		try {
			String [][] retorno = new String [this.retornaNumeroDescontos()][];
			int indice = 0;
			List<Desconto> descontos = this.base.retornaDescontos();
			for (Desconto desconto : descontos) {
				String [] linha = {desconto.toString()}; 
				retorno[indice++] = linha;
			}
			
			return retorno;
		}
		catch (Exception e) {
			throw e;
		}
	}

}
