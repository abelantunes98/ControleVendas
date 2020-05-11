package controladores;

import modelos.Produto;
import baseDados.BaseDados;

public class ControleProdutos {

	BaseDados base;

	public ControleProdutos(BaseDados base) {

		this.base = base;
	}


	public void adicionarProduto(String codigoProduto, String nomeProduto, double precoProduto, String descricaoProduto) {

		try {
			
			if ( codigoProduto.equals("") || nomeProduto.equals("") || descricaoProduto.equals("")) {
				throw new IllegalArgumentException("Campos passados vazios!");
			}
			Produto produto = new Produto(codigoProduto, nomeProduto, precoProduto, descricaoProduto);
			base.inserirProduto(codigoProduto, produto);
		}
		catch(Exception e) {
			throw e;
		}
	}
	
	public void removerProduto(String codigoProduto) {
		
		try {
			base.removerProduto(codigoProduto);
		}
		catch (Exception e) {
			throw e;
		}
	}
	
	public double retornaValorProduto(String codigoProduto) {
		
		if (base.existeProduto(codigoProduto)) {
			Produto produto = base.retornaProduto(codigoProduto);
			return produto.getPrecoProduto();
		}
		else {
			throw new IllegalArgumentException("Produto inexistente.");
		}
	}
	
	public boolean produtoExiste(String codigoProduto) {
		
		return base.existeProduto(codigoProduto);
	}
	
	public int retornaNumeroProdutos() {
		return base.retornaNumeroProdutos();
	}
}


