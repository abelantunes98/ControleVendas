package baseDados;

import java.util.HashMap;

import modelos.Funcionario;
import modelos.Produto;
import modelos.Desconto;

public class BaseDados {

	private HashMap<String, Funcionario> funcionarios;
	private HashMap<String, Produto> produtos;
	private HashMap<String, Desconto> descontos;


	public BaseDados() {

	}

	public void inserirFuncionario(String codigoFuncionario, Funcionario funcionario) {

		if (codigoFuncionario != null && funcionario != null) {
			if (!funcionarios.containsKey(codigoFuncionario)) {
				this.funcionarios.put(codigoFuncionario, funcionario);
			}
			else {
				throw new IllegalArgumentException("Funcionario ja cadastrado no sistema.");
			}
		}
		else {
			throw new IllegalArgumentException("Valores invalidos.");
		}

	}

	public void inserirProduto(String codigoProduto, Produto produto) {

		if (codigoProduto != null && produto != null) {
			if (!produtos.containsKey(codigoProduto)) {
				this.produtos.put(codigoProduto, produto);
			}
			else {
				throw new IllegalArgumentException("Produto ja cadastrado no sistema.");
			}
		}
		else {
			throw new IllegalArgumentException("Valores invalidos.");
		}

	}

	public void inserirDesconto(String codigoDesconto, Desconto desconto) {

		if (codigoDesconto != null && desconto != null) {
			if (!descontos.containsKey(codigoDesconto)) {
				this.descontos.put(codigoDesconto, desconto);
			}
			else {
				throw new IllegalArgumentException("Desconto ja cadastrado no sistema.");
			}
		}
		else {
			throw new IllegalArgumentException("Valores invalidos.");
		}

	}
}
