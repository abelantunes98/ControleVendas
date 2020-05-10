package baseDados;

import java.util.HashMap;

import modelos.Funcionario;
import modelos.Produto;
import modelos.Desconto;
import modelos.Mesa;

public class BaseDados {

	private HashMap<String, Funcionario> funcionarios;
	private HashMap<String, Produto> produtos;
	private HashMap<String, Desconto> descontos;
	private HashMap<String, Mesa> mesas;


	public BaseDados() {
		this.funcionarios = new HashMap<String, Funcionario>();
		this.produtos = new HashMap<String, Produto>();
		this.descontos = new HashMap<String, Desconto>();
		this.mesas = new HashMap<String, Mesa>();
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
	
	public void inserirMesa(String codigoMesa, Mesa mesa) {

		if (codigoMesa != null && mesa != null) {
			if (!mesas.containsKey(codigoMesa)) {
				this.mesas.put(codigoMesa, mesa);
			}
			else {
				throw new IllegalArgumentException("Mesa ja cadastrado no sistema.");
			}
		}
		else {
			throw new IllegalArgumentException("Valores invalidos.");
		}

	}

	public void removerFuncionario(String codigoFuncionario) {

		if (funcionarios.containsKey(codigoFuncionario)) {
			funcionarios.remove(codigoFuncionario);
		}
		else {
			throw new IllegalArgumentException("Funcionario nao cadastrado.");
		}
	}

	public void removerProduto(String codigoProduto) {

		if (produtos.containsKey(codigoProduto)) {
			produtos.remove(codigoProduto);
		}
		else {
			throw new IllegalArgumentException("Produto nao cadastrado.");
		}
	}

	public void removerDesconto(String codigoDesconto) {

		if (descontos.containsKey(codigoDesconto)) {
			descontos.remove(codigoDesconto);
		}
		else {
			throw new IllegalArgumentException("Desconto nao cadastrado.");
		}
	}
	
	public void removerMesa(String codigoMesa) {

		if (mesas.containsKey(codigoMesa)) {
			mesas.remove(codigoMesa);
		}
		else {
			throw new IllegalArgumentException("Mesa nao cadastrada.");
		}
	}
	
	public Funcionario retornaFuncionario(String codigoFuncionario) {
		if (funcionarios.containsKey(codigoFuncionario)) {
			Funcionario funcionario = funcionarios.get(codigoFuncionario);
			return funcionario;
		}
		else {
			throw new IllegalArgumentException("Funcionario inexistente.");
		}
	}
	
	public Produto retornaProduto(String codigoProduto) {
		if (produtos.containsKey(codigoProduto)) {
			Produto produto = produtos.get(codigoProduto);
			return produto;
		}
		else {
			throw new IllegalArgumentException("Produto inexistente.");
		}
	}
	
	public Desconto retornaDesconto(String codigoDesconto) {
		if (descontos.containsKey(codigoDesconto)) {
			Desconto desconto = descontos.get(codigoDesconto);
			return desconto;
		}
		else {
			throw new IllegalArgumentException("Desconto inexistente.");
		}
	}
	
	public Mesa retornaMesa(String codigoMesa) {
		if (mesas.containsKey(codigoMesa)) {
			Mesa mesa = mesas.get(codigoMesa);
			return mesa;
		}
		else {
			throw new IllegalArgumentException("Mesa inexistente.");
		}
	}
	
	public void alteraFuncionario(String codigoFuncionario, Funcionario funcionario) {
		
		if (codigoFuncionario != null && funcionario != null) {
			if (funcionarios.containsKey(codigoFuncionario)) {
				this.funcionarios.replace(codigoFuncionario, funcionario);
			}
			else {
				throw new IllegalArgumentException("Funcionario nao cadastrado no sistema.");
			}
		}
		else {
			throw new IllegalArgumentException("Valores invalidos.");
		}
	}
	
	public void alteraProduto(String codigoProduto, Produto produto) {
		
		if (codigoProduto != null && produto != null) {
			if (produtos.containsKey(codigoProduto)) {
				this.produtos.replace(codigoProduto, produto);
			}
			else {
				throw new IllegalArgumentException("Produto nao cadastrado no sistema.");
			}
		}
		else {
			throw new IllegalArgumentException("Valores invalidos.");
		}
	}
	
	public void alteraDesconto(String codigoDesconto, Desconto desconto) {
		
		if (codigoDesconto != null && desconto != null) {
			if (descontos.containsKey(codigoDesconto)) {
				this.descontos.replace(codigoDesconto, desconto);
			}
			else {
				throw new IllegalArgumentException("Desconto nao cadastrado no sistema.");
			}
		}
		else {
			throw new IllegalArgumentException("Valores invalidos.");
		}
	}
	
	public void alteraMesa(String codigoMesa, Mesa mesa) {
		
		if (codigoMesa != null && mesa != null) {
			if (mesas.containsKey(codigoMesa)) {
				this.mesas.replace(codigoMesa, mesa);
			}
			else {
				throw new IllegalArgumentException("Mesa nao cadastrada no sistema.");
			}
		}
		else {
			throw new IllegalArgumentException("Valores invalidos.");
		}
	}
}
