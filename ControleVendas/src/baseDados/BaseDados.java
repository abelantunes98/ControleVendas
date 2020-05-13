package baseDados;

import java.util.ArrayList;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import modelos.Funcionario;
import modelos.Produto;
import modelos.Desconto;
import modelos.Mesa;
import modelos.Faturamento;

import serializacao.Empacotamento;

public class BaseDados implements Serializable {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = -5652801087683821171L;
	
	private static HashMap<String, Funcionario> funcionarios;
	private static HashMap<String, Produto> produtos;
	private static HashMap<String, Desconto> descontos;
	private static HashMap<String, Mesa> mesas;
	private static HashMap<String, Faturamento> faturamentos;


	public BaseDados() {
		carregarDados();
	}

	public void inserirFuncionario(String codigoFuncionario, Funcionario funcionario) {

		if (codigoFuncionario != null && funcionario != null) {
			if (!funcionarios.containsKey(codigoFuncionario)) {
				BaseDados.funcionarios.put(codigoFuncionario, funcionario);
				
				// Serializando.
				try {
					Empacotamento.gravarArquivoBinario(funcionarios, "data/func.ser");
				}
				catch (Exception e) {
					throw e;
				}
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
				BaseDados.produtos.put(codigoProduto, produto);
				
				// Serializando.
				try  {
					Empacotamento.gravarArquivoBinario(produtos, "data/prod.ser");
				}
				catch (Exception e) {
					throw e;
				}
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
				BaseDados.descontos.put(codigoDesconto, desconto);
				
				// Serializando.
				try {
					Empacotamento.gravarArquivoBinario(descontos, "data/desc.ser");
				}
				catch (Exception e) {
					throw e;
				}
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
				BaseDados.mesas.put(codigoMesa, mesa);
				
				// Serializando.
				try {
					Empacotamento.gravarArquivoBinario(mesas, "data/mesas.ser");
				}
				catch (Exception e) {
					throw e;
				}
			}
			else {
				throw new IllegalArgumentException("Mesa ja cadastrado no sistema.");
			}
		}
		else {
			throw new IllegalArgumentException("Valores invalidos.");
		}

	}

	public void inserirFaturamento(String codigoFaturamento, Faturamento faturamento) {

		if (codigoFaturamento != null && faturamento != null) {
			if (!faturamentos.containsKey(codigoFaturamento)) {
				BaseDados.faturamentos.put(codigoFaturamento, faturamento);
				
				// Serializando.
				try {
					Empacotamento.gravarArquivoBinario(faturamentos, "data/fatur.ser");
				}
				catch (Exception e) {
					throw e;
				}
			}
			else {
				throw new IllegalArgumentException("Faturamento ja cadastrado no sistema.");
			}
		}
		else {
			throw new IllegalArgumentException("Valores invalidos.");
		}

	}

	public void removerFuncionario(String codigoFuncionario) {

		if (funcionarios.containsKey(codigoFuncionario)) {
			funcionarios.remove(codigoFuncionario);
			
			// Serializando.
			try {
				Empacotamento.gravarArquivoBinario(funcionarios, "data/func.ser");
			}
			catch (Exception e) {
				throw e;
			}
		}
		else {
			throw new IllegalArgumentException("Funcionario nao cadastrado.");
		}
	}

	public void removerProduto(String codigoProduto) {

		if (produtos.containsKey(codigoProduto)) {
			produtos.remove(codigoProduto);
			
			// Serializando.
			try  {
				Empacotamento.gravarArquivoBinario(produtos, "data/prod.ser");
			}
			catch (Exception e) {
				throw e;
			}
		}
		else {
			throw new IllegalArgumentException("Produto nao cadastrado.");
		}
	}

	public void removerDesconto(String codigoDesconto) {

		if (descontos.containsKey(codigoDesconto)) {
			descontos.remove(codigoDesconto);
			
			// Serializando.
			try {
				Empacotamento.gravarArquivoBinario(descontos, "data/desc.ser");
			}
			catch (Exception e) {
				throw e;
			}
		}
		else {
			throw new IllegalArgumentException("Desconto nao cadastrado.");
		}
	}

	public void removerMesa(String codigoMesa) {

		if (mesas.containsKey(codigoMesa)) {
			mesas.remove(codigoMesa);
			
			// Serializando.
			try {
				Empacotamento.gravarArquivoBinario(mesas, "data/mesas.ser");
			}
			catch (Exception e) {
				throw e;
			}
		}
		else {
			throw new IllegalArgumentException("Mesa nao cadastrada.");
		}
	}

	public void removerFaturamento(String codigoFaturamento) {

		if (faturamentos.containsKey(codigoFaturamento)) {
			faturamentos.remove(codigoFaturamento);
			
			// Serializando.
			try {
				Empacotamento.gravarArquivoBinario(faturamentos, "data/fatur.ser");
			}
			catch (Exception e) {
				throw e;
			}
		}
		else {
			throw new IllegalArgumentException("Faturamento nao cadastrado.");
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

	public Faturamento retornaFaturamento(String codigoFaturamento) {
		if (faturamentos.containsKey(codigoFaturamento)) {
			Faturamento faturamento = faturamentos.get(codigoFaturamento);
			return faturamento;
		}
		else {
			throw new IllegalArgumentException("Faturamento inexistente.");
		}
	}

	public void alteraFuncionario(String codigoFuncionario, Funcionario funcionario) {

		if (codigoFuncionario != null && funcionario != null) {
			if (funcionarios.containsKey(codigoFuncionario)) {
				BaseDados.funcionarios.replace(codigoFuncionario, funcionario);
				
				// Serializando.
				try {
					Empacotamento.gravarArquivoBinario(funcionarios, "data/func.ser");
				}
				catch (Exception e) {
					throw e;
				}
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
				BaseDados.produtos.replace(codigoProduto, produto);
				
				// Serializando.
				try  {
					Empacotamento.gravarArquivoBinario(produtos, "data/prod.ser");
				}
				catch (Exception e) {
					throw e;
				}
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
				BaseDados.descontos.replace(codigoDesconto, desconto);
				
				// Serializando.
				try {
					Empacotamento.gravarArquivoBinario(descontos, "data/desc.ser");
				}
				catch (Exception e) {
					throw e;
				}
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
				BaseDados.mesas.replace(codigoMesa, mesa);
				
				// Serializando.
				try {
					Empacotamento.gravarArquivoBinario(mesas, "data/mesas.ser");
				}
				catch (Exception e) {
					throw e;
				}
			}
			else {
				throw new IllegalArgumentException("Mesa nao cadastrada no sistema.");
			}
		}
		else {
			throw new IllegalArgumentException("Valores invalidos.");
		}
	}

	public void alteraFaturamento(String codigoFaturamento, Faturamento faturamento) {

		if (codigoFaturamento != null && faturamento != null) {
			if (faturamentos.containsKey(codigoFaturamento)) {
				BaseDados.faturamentos.replace(codigoFaturamento, faturamento);
				
				// Serializando.
				try {
					Empacotamento.gravarArquivoBinario(faturamentos, "data/fatur.ser");
				}
				catch (Exception e) {
					throw e;
				}
			}
			else {
				throw new IllegalArgumentException("Faturamento nao cadastrado no sistema.");
			}
		}
		else {
			throw new IllegalArgumentException("Valores invalidos.");
		}
	}

	public boolean existeFuncionario(String codigoFuncionario) {
		return funcionarios.containsKey(codigoFuncionario);
	}

	public boolean existeProduto(String codigoProduto) {
		return produtos.containsKey(codigoProduto);
	}

	public boolean existeDesconto(String codigoDesconto) {
		return descontos.containsKey(codigoDesconto);
	}

	public boolean existeMesa(String codigoMesa) {
		return mesas.containsKey(codigoMesa);
	}

	public boolean existeFaturamento(String codigoFaturamento) {
		return faturamentos.containsKey(codigoFaturamento);
	}

	public List<String> retornaCodigosFaturamento() {
		List<String> retorno = new ArrayList<String>();
		retorno.addAll(BaseDados.faturamentos.keySet());

		return retorno;
	}

	public int retornaNumeroFuncionarios() {
		return BaseDados.funcionarios.size();
	}

	public int retornaNumeroProdutos() {
		return BaseDados.produtos.size();
	}

	public int retornaNumeroMesas() {
		return BaseDados.mesas.size();
	}

	public int retornaNumeroDescontos() {
		return BaseDados.descontos.size();
	}
	
	public int retornaNumeroFaturamentos() {
		return BaseDados.faturamentos.size();
	}

	public List<Mesa> retornaMesas() {
		
		try {
			List<Mesa> retorno = new ArrayList<Mesa>();
			retorno.addAll(mesas.values());

			return retorno;
		}
		catch (Exception e) {
			throw e;
		}
	}
	
	public List<Desconto> retornaDescontos() {
		
		try {
			List<Desconto> retorno = new ArrayList<Desconto>();
			retorno.addAll(descontos.values());

			return retorno;
		}
		catch (Exception e) {
			throw e;
		}
	}
	
	public List<Produto> retornaProdutos() {
			
		try {
			List<Produto> retorno = new ArrayList<Produto>();
			retorno.addAll(produtos.values());

			return retorno;
		}
		catch (Exception e) {
			throw e;
		}
	}
	
	/*
	 * Funções que podem ser usadas para apagar todas as informações de
	 * uma entidade. Ou na função que zera o banco.
	 */
	
	public void limparFuncionarios() {
		funcionarios = new HashMap<String, Funcionario>();
		
		// Serializando.
		try {
			Empacotamento.gravarArquivoBinario(funcionarios, "data/func.ser");
		}
		catch (Exception e) {
			throw e;
		}
	}
	
	public void limparProdutos() {
		produtos = new HashMap<String, Produto>();
		
		// Serializando.
		try  {
			Empacotamento.gravarArquivoBinario(produtos, "data/prod.ser");
		}
		catch (Exception e) {
			throw e;
		}
	}
	
	public void limparDescontos() {
		descontos = new HashMap<String, Desconto>();
		
		// Serializando.
		try {
			Empacotamento.gravarArquivoBinario(descontos, "data/desc.ser");
		}
		catch (Exception e) {
			throw e;
		}
	}
	
	public void limparMesas() {
		mesas = new HashMap<String, Mesa>();
		
		// Serializando.
		try {
			Empacotamento.gravarArquivoBinario(mesas, "data/mesas.ser");
		}
		catch (Exception e) {
			throw e;
		}
	}
	
	public void limparFaturamentos() {
		faturamentos = new HashMap<String, Faturamento>();
		
		// Serializando.
		try {
			Empacotamento.gravarArquivoBinario(faturamentos, "data/fatur.ser");
		}
		catch (Exception e) {
			throw e;
		}
	}
	
	private void carregarDados() {
		
		try {
			funcionarios = (HashMap<String, Funcionario>) Empacotamento.lerArquivoBinario("data/func.ser");
		}
		catch (Exception e) {
			funcionarios = new HashMap<String, Funcionario>();
		}		
		try {
			produtos = (HashMap<String, Produto>) Empacotamento.lerArquivoBinario("data/prod.ser");
		}
		catch (Exception e) {
			produtos = new HashMap<String, Produto>();
		}
		try {
			descontos = (HashMap<String, Desconto>) Empacotamento.lerArquivoBinario("data/desc.ser");
		}
		catch (Exception e) {
			descontos = new HashMap<String, Desconto>();
		}
		try {
			mesas = (HashMap<String, Mesa>) Empacotamento.lerArquivoBinario("data/mesas.ser");
		}
		catch (Exception e) {
			mesas = new HashMap<String, Mesa>();
		}
		try {
			faturamentos = (HashMap<String, Faturamento>) Empacotamento.lerArquivoBinario("data/fatur.ser");
		}
		catch (Exception e) {
			faturamentos = new HashMap<String, Faturamento>();
		}		
	}

}
