package controladores;

import modelos.Produto;

import java.text.DecimalFormat;
import java.util.List;

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
	
	public String retornaNomeProduto(String codigoProduto) {
		
		try {
			Produto produto = this.base.retornaProduto(codigoProduto);
			return produto.getNomeProduto();
		}
		catch (Exception e) {
			throw e;
		}
	}
	
	public boolean produtoExiste(String codigoProduto) {
		
		return base.existeProduto(codigoProduto);
	}
	
	public int retornaNumeroProdutos() {
		return base.retornaNumeroProdutos();
	}
	
	/*
	 * Retornando dados de produtos para tabelas.
	 */
	public String [][] retornaDetalhesProdutos() {
		
		try {
			// Formatando sa�da Double.
			String formato = "R$ #,##0.00";
			DecimalFormat d = new DecimalFormat(formato);
			
			String [][] retorno = new String [this.retornaNumeroProdutos()][4];
			int indice = 0;
			List<Produto> produtos = this.base.retornaProdutos();
			for (Produto produto : produtos) {
				String [] linha = new String[4];
				linha[0] = produto.getCodigoProduto();
				linha[1] = produto.getNomeProduto();
				linha[2] = produto.getDescricaoProduto();
				linha[3] = d.format(produto.getPrecoProduto());
				retorno[indice++] = linha;
			}
			
			return retorno;
		}
		catch (Exception e) {
			throw e;
		}
	}
	
	public String [][] retornaVetorToStringProdutos() {
		
		try {
			String [][] retorno = new String [this.retornaNumeroProdutos()][];
			int indice = 0;
			List<Produto> produtos = this.base.retornaProdutos();
			for (Produto produto : produtos) {
				String [] linha = {produto.toString()}; 
				retorno[indice++] = linha;
			}
			
			return retorno;
		}
		catch (Exception e) {
			throw e;
		}
	}
	
	public void limparProdutos() {
		try {
			this.base.limparProdutos();
		}
		catch (Exception e) {
			throw e;
		}
	}
}


