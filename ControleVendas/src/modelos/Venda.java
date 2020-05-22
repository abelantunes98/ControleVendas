package modelos;

import java.util.Date;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

public class Venda implements Serializable{
	
	/**
	 * Serial
	 */
	private static final long serialVersionUID = 8462348413260624595L;
	private String codigoFuncionario;
	private String codigoProduto;
	private String codigoMesa;
	private String codigoDesconto;
	private String nomeProduto;
	private int id;
	
	private int quantProdutos;
	
	private double valorVenda;
	
	private String horaVenda;
	
	private String formato = "R$ #,##0.00";
	private DecimalFormat d = new DecimalFormat(formato);
	private SimpleDateFormat formatoHora = new SimpleDateFormat("hh:mm:ss");

	
	public Venda(String codigoFuncionario, String codigoProduto, String nomeProduto, int quantProdutos,
			double valorVenda) {
		super();
		this.codigoFuncionario = codigoFuncionario;
		this.codigoProduto = codigoProduto;
		this.nomeProduto = nomeProduto;
		this.codigoDesconto = "";
		this.quantProdutos = quantProdutos;
		this.valorVenda = valorVenda;
		Date data = new Date();
		this.horaVenda = formatoHora.format(data);
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getCodigoFuncionario() {
		return codigoFuncionario;
	}


	public void setCodigoFuncionario(String codigoFuncionario) {
		this.codigoFuncionario = codigoFuncionario;
	}


	public String getCodigoProduto() {
		return codigoProduto;
	}


	public void setCodigoProduto(String codigoProduto) {
		this.codigoProduto = codigoProduto;
	}
	
	public String getNomeProduto() {
		return nomeProduto;
	}


	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getCodigoMesa() {
		return codigoMesa;
	}


	public void setCodigoMesa(String codigoMesa) {
		this.codigoMesa = codigoMesa;
	}


	public String getCodigoDesconto() {
		return codigoDesconto;
	}


	public void setCodigoDesconto(String codigoDesconto) {
		this.codigoDesconto = codigoDesconto;
	}


	public int getQuantProdutos() {
		return quantProdutos;
	}


	public void setQuantProdutos(int quantProdutos) {
		this.quantProdutos = quantProdutos;
	}


	public double getValorVenda() {
		return valorVenda;
	}


	public void setValorVenda(double valorVenda) {
		this.valorVenda = valorVenda;
	}


	public String getHoraVenda() {
		return horaVenda;
	}


	public void setHoraVenda(String dataVenda) {
		this.horaVenda = dataVenda;
	}


	@Override
	public String toString() {
		return "Funcionario: " + codigoFuncionario + " | Produto: " + codigoProduto + " | Quantidade: " + quantProdutos
				+ " | Valor: " + d.format(valorVenda);
	}
	
	
	
	
}
