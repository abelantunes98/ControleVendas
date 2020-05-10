package controladores;

import baseDados.BaseDados;
import modelos.Desconto;

public class ControleDescontos {

	BaseDados base;

	public ControleDescontos() {

		base = new BaseDados();
	}


	public void adicionarDesconto(String codigoDesconto, String nomeDesconto, String descricaoDesconto, double valorDesconto) {

		try {
			Desconto desconto = new Desconto(codigoDesconto, nomeDesconto, descricaoDesconto, valorDesconto);
			base.inserirDesconto(codigoDesconto, desconto);
		}
		catch(Exception e) {
			throw e;
		}
	}

}
