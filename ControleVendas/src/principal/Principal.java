package principal;

import controladores.*;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import baseDados.BaseDados;

public class Principal {

	private int codigoFaturamentoAtual;

	private ControleFaturamentos controleFaturamentos;
	private ControleProdutos controleProdutos;
	private ControleMesas controleMesas;
	private ControleFuncionarios controleFuncionarios;
	private ControleDescontos controleDescontos;
	
	// Variável para não exibir a pergunta sobre iniciar um novo faturamento
	// Sempre que atualizar as vendas.
	private boolean manterFaturamentoAnterior;

	private BaseDados base;

	public Principal() {
		this.base = new BaseDados();
		this.controleFaturamentos = new ControleFaturamentos(base);
		this.controleProdutos = new ControleProdutos(base);
		this.controleMesas = new ControleMesas(base);
		this.controleFuncionarios = new ControleFuncionarios(base);
		this.controleDescontos = new ControleDescontos(base);
		this.manterFaturamentoAnterior = false;
	}

	/*
	 * O código de faturamento atual é obtido a partir do número de faturamentos cadastrados.
	 * Logo, se o código for 0 não existem faturamentos. Por isso um novo é criado.
	 * Se for um valor maior que 0, olha se o faturamento cadastrado anteriormente não
	 * pertence ao mesmo dia, já que pode-se fechar e abrir o programa no mesmo dia.
	 * 
	 * Caso seja a mesma data, o código atual passa a ser o do anterior. Caso não
	 * seja a mesma data, um novo faturamento é adicionado com o código atual.
	 * Esse código será usado para todas as funções relacionadas a faturamento.
	 */
	public void iniciarFaturamento() {

		try {	//Função que verifica a necessidade.
			if (this.retornaNecissidadeCriarNovoFaturamento()) {
				this.controleFaturamentos.adicionarFaturamento(Integer.toString(codigoFaturamentoAtual));
			}
			else {
				this.codigoFaturamentoAtual -= 1;
			}
		}
		catch (Exception e) {
			throw e;
		}

	}
	
	/*
	 * Para o caso em que o usuário deseje manter o faturamento do
	 * dia anterior.
	 */
	public void manterFaturamentoAtual() {
		try {
			this.codigoFaturamentoAtual--;
			this.manterFaturamentoAnterior = true;
		}
		catch (Exception e){
			throw e;
		}
	}
	
	/*
	 * Retorna a necessidade de perguntar ao usuário antes de criar
	 * um novo faturamento.
	 */
	public boolean retornaNecessidadePerguntaCriarFaturamento() {
		try {
			this.codigoFaturamentoAtual = this.controleFaturamentos.retornaNumeroFaturamentos();
			if (this.codigoFaturamentoAtual == 0) {
				return false;
			}
			else {
				return this.retornaNecissidadeCriarNovoFaturamento();
			}
		}
		catch (Exception e) {
			throw e;
		}
	}

	/*
	 * Verifica se a base está vazia ou se já foi gerado um faturamento
	 * no dia atual. Com isso, retorna a necessidade de iniciar
	 * um novo faturamento.
	 */
	private boolean retornaNecissidadeCriarNovoFaturamento() {
		try {
			this.codigoFaturamentoAtual = this.controleFaturamentos.retornaNumeroFaturamentos();
			if (this.codigoFaturamentoAtual == 0) {
				return true;
			}
			else {
				Date dataDia = new Date();
				SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
				formato.setLenient(false);

				String dataDiaFormatada = formato.format(dataDia);
				String dataFaturamentoAnterior = this.controleFaturamentos
						.retornaDataFaturamento(Integer.toString(this.codigoFaturamentoAtual - 1));

				if (!dataDiaFormatada.equals(dataFaturamentoAnterior)) {
					return true;
				}
				else {
					return false;
				}
			}
		}
		catch (Exception e) {
			throw e;
		}
	}

	public void adicionarFuncionario(String nome, String cpf, String telefone, String email, String codigo) {
		try {
			this.controleFuncionarios.adicionarFuncionario(nome, cpf, telefone, email, codigo);
		}
		catch (Exception e) {
			throw e;
		}
	}

	public void cadastrarProduto(String codigoProduto, String nomeProduto, double precoProduto, String descricaoProduto) {
		try {
			this.controleProdutos.adicionarProduto(codigoProduto, nomeProduto, precoProduto, descricaoProduto);
		}
		catch (Exception e) {
			throw e;
		}
	}

	public void cadastrarMesa(String codigoMesa, int lugaresMesa) {
		try {
			this.controleMesas.adicionarMesa(codigoMesa, lugaresMesa);
		}
		catch (Exception e) {
			throw e;
		}
	}

	public void cadastrarDescontoPorcentagem(String codigoDesconto, String nomeDesconto, String descricaoDesconto, double porcentagemDesconto) {
		try {
			this.controleDescontos.adicionarDescontoPorcentagem(codigoDesconto, nomeDesconto, descricaoDesconto, porcentagemDesconto);
		}
		catch (Exception e) {
			throw e;
		}
	}

	public void cadastrarDescontoValor(String codigoDesconto, String nomeDesconto, String descricaoDesconto, double valorDesconto) {
		try {
			this.controleDescontos.adicionarDescontoValor(codigoDesconto, nomeDesconto, descricaoDesconto, valorDesconto);
		}
		catch (Exception e) {
			throw e;
		}
	}

	/*
	 * Adiciona uma Venda após verificar a existência de todos os dados.
	 * Caso o codigo de desconto não seja null, verifica o tipo de desconto
	 * e o aplica no valor da Venda.
	 * A mesa é passada como null quando a venda é feita pelo caixa.
	 * Mesa vazia dá erro, porquê chega uma "".
	 */
	public void adicionarVenda(String codigoFuncionario, String codigoProduto, String codigoMesa, int quantProdutos, String codigoDesconto) {

		try {

			if (!this.controleFuncionarios.funcionarioExiste(codigoFuncionario)) {
				throw new IllegalArgumentException("Funcionario inexistente.");
			}

			if (!this.controleProdutos.produtoExiste(codigoProduto)) {
				throw new IllegalArgumentException("Produto inexistente.");
			}

			if (codigoMesa != null && !this.controleMesas.mesaExiste(codigoMesa)) {
				throw new IllegalArgumentException("Mesa inexistente.");
			}

			if (quantProdutos <= 0) {
				throw new IllegalArgumentException("Quantidade de produto invalida.");
			}

			double valorProduto = this.controleProdutos.retornaValorProduto(codigoProduto);
			String nomeProduto = this.controleProdutos.retornaNomeProduto(codigoProduto);

			if (codigoDesconto == null) {
				valorProduto *= quantProdutos;
			}
			else {
				if (!this.controleDescontos.descontoExiste(codigoDesconto)) {
					throw new IllegalArgumentException("Desconto inexistente.");
				}

				String tipoDesconto = this.controleDescontos.retornaTipoDesconto(codigoDesconto);
				if (tipoDesconto.equals("Valor")) {
					double valorDesconto = this.controleDescontos.retornaValorDesconto(codigoDesconto);
					valorProduto = ((valorProduto * quantProdutos) - valorDesconto);
				}
				else if (tipoDesconto.equals("Porcentagem")) {
					double porcentagemDesconto = this.controleDescontos.retornaPorcentagemDesconto(codigoDesconto);
					valorProduto = ((valorProduto * quantProdutos) - ((valorProduto * quantProdutos) * (porcentagemDesconto / 100)));
				}
			}

			/*
			 * Vou precisar desse valor para adicionar o id da venda na mesa.
			 * E esse valor é gerado a partir do número de vendas do faturamento.
			 */
			int codigoVenda = this.controleFaturamentos.retornaNumeroDeVendas(Integer.toString(this.controleFaturamentos.retornaNumeroFaturamentos() - 1));

			this.controleFaturamentos.criaVenda(Integer.toString(this.controleFaturamentos.retornaNumeroFaturamentos() - 1), codigoFuncionario, 
					codigoProduto, nomeProduto, codigoMesa, quantProdutos, valorProduto, codigoDesconto);

			/*
			 * Se a venda for no caixa, não adiciona em nenhuma mesa.
			 */
			if (codigoMesa != null) {
				this.controleMesas.adicionaVendaEmMesa(codigoMesa, codigoVenda, valorProduto);
			}
		}
		catch (Exception e) {
			throw e;
		}
	}

	/*
	 * Funções relacionadas as mesas.
	 */
	public int retornaNumMesasDisponiveis() {
		try {
			return this.controleMesas.retornaNumMesasDisponiveis();
		}
		catch (Exception e) {
			throw e;
		}
	}

	public boolean retornaMesaDisponivel(String codigoMesa) {
		try {
			return this.controleMesas.retornaMesaDisponivel(codigoMesa);
		}
		catch (Exception e) {
			throw e;
		}
	}

	public double retornaTotalGastoMesa(String codigoMesa) {
		try {
			return this.controleMesas.retornaTotalGastoMesa(codigoMesa);
		}
		catch (Exception e) {
			throw e;
		}
	}

	public void ocuparMesa(String codigoMesa) {

		try {
			if ( codigoMesa.equals("") ) {
				throw new IllegalArgumentException("Campos passados vazios!");
			}
			this.controleMesas.ocuparMesa(codigoMesa);
		}
		catch (Exception e) {
			throw e;
		}
	}

	public boolean retornaMesaExiste(String codigoMesa) {
		try {
			return this.controleMesas.mesaExiste(codigoMesa);
		}
		catch (Exception e) {
			throw e;
		}
	}

	public void liberarMesa(String codigoMesa) {
		try {
			if ( codigoMesa.equals("") ) {
				throw new IllegalArgumentException("Campos passados vazios!");
			}
			this.controleMesas.liberarMesa(codigoMesa);
		}
		catch (Exception e) {
			throw e;
		}
	}

	public String [][] retornaVendasDaMesa(String codigoMesa) {

		try {
			List<Integer> idsVendas = this.controleMesas.retornaIdsVendasMesa(codigoMesa);
			if (idsVendas.isEmpty()) {
				throw new IllegalArgumentException("Não há vendas na mesa.");
			}

			return this.controleFaturamentos.retornaDadosVendasPorListaDeIds(Integer.toString(this.controleFaturamentos.retornaNumeroFaturamentos() - 1), idsVendas);
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
			String [][] retorno = this.controleMesas.retornaDisponibilidadeMesas();
			return retorno;
		}
		catch (Exception e) {
			throw e;
		}
	}

	/*
	 * Funções relacionadas a catálogos.
	 * 
	 */	
	public String [][] retornaCatalogoProdutos() {
		try {
			return this.controleProdutos.retornaDetalhesProdutos();
		}
		catch (Exception e) {
			throw e;
		}
	}

	public String [][] retornaCatalogoDescontos() {
		try {
			return this.controleDescontos.retornaDetalhesDescontos();
		}
		catch (Exception e) {
			throw e;
		}
	}
	
	/*
	 * Funções administrativas
	 */
	
	/*
	 * Retorna detalhes das vendas de um funcionário em um determinado dia.
	 */
	public String [][] retornaVendasDeFuncionario(String codigoFuncionario, String dataFaturamento) {

		try {
			String codigoFaturamento;
			if (dataFaturamento == null) {
				codigoFaturamento = Integer.toString(this.controleFaturamentos.retornaNumeroFaturamentos() - 1);
			}
			else {
				codigoFaturamento = this.controleFaturamentos.retornaCodigoFaturamentoPorData(dataFaturamento);
			}
			
			return this.controleFaturamentos.retornaDadosVendasPorFuncionario(codigoFaturamento, codigoFuncionario);
		}
		catch (Exception e) {
			throw e;
		}

	}
	
	
	public String retornaValorDeVendasDeFuncionario(String codigoFuncionario, String dataFaturamento) {
		try {
			String codigoFaturamento;
			if (dataFaturamento == null) {
				codigoFaturamento = Integer.toString(this.controleFaturamentos.retornaNumeroFaturamentos() - 1);
			}
			else {
				codigoFaturamento = this.controleFaturamentos.retornaCodigoFaturamentoPorData(dataFaturamento);
			}
			
			String formato = "R$ #,##0.00";
			DecimalFormat d = new DecimalFormat(formato);
			double retorno = this.controleFaturamentos.retornaValorFaturamentoPorFuncionario(codigoFaturamento, codigoFuncionario);
			return d.format(retorno);
		}
		catch (Exception e) {
			throw e;
		}
	}
	
	
	public String retornaPorcentagemDeVendasDeFuncionario(String codigoFuncionario, String dataFaturamento, double porcentagem) {
		try {
			if (porcentagem < 0) {
				throw new IllegalArgumentException("Porcentagem inválida.");
			}
			
			String codigoFaturamento;
			if (dataFaturamento == null) {
				codigoFaturamento = Integer.toString(this.controleFaturamentos.retornaNumeroFaturamentos() - 1);
			}
			else {
				codigoFaturamento = this.controleFaturamentos.retornaCodigoFaturamentoPorData(dataFaturamento);
			}
			
			String formato = "R$ #,##0.00";
			DecimalFormat d = new DecimalFormat(formato);
			double retorno = this.controleFaturamentos.retornaPorcentagemFuncionario(codigoFaturamento, codigoFuncionario, porcentagem);
			return d.format(retorno);
		}
		catch (Exception e) {
			throw e;
		}
	}
	
	
	/*
	 * Retorna detalhes das vendas em uma Mesa em um determinado dia.
	 */
	public String [][] retornaVendasEmMesa(String codigoMesa, String dataFaturamento) {

		try {
			String codigoFaturamento;
			if (dataFaturamento == null) {
				codigoFaturamento = Integer.toString(this.controleFaturamentos.retornaNumeroFaturamentos() - 1);
			}
			else {
				codigoFaturamento = this.controleFaturamentos.retornaCodigoFaturamentoPorData(dataFaturamento);
			}
			
			return this.controleFaturamentos.retornaDadosVendasPorMesa(codigoFaturamento, codigoMesa);
		}
		catch (Exception e) {
			throw e;
		}

	}
	
	public String retornaValorDeVendasEmMesa(String codigoMesa, String dataFaturamento) {
		try {
			String codigoFaturamento;
			if (dataFaturamento == null) {
				codigoFaturamento = Integer.toString(this.controleFaturamentos.retornaNumeroFaturamentos() - 1);
			}
			else {
				codigoFaturamento = this.controleFaturamentos.retornaCodigoFaturamentoPorData(dataFaturamento);
			}
			
			String formato = "R$ #,##0.00";
			DecimalFormat d = new DecimalFormat(formato);
			double retorno = this.controleFaturamentos.retornaValorFaturamentoPorMesa(codigoFaturamento, codigoMesa);
			return d.format(retorno);
		}
		catch (Exception e) {
			throw e;
		}
	}

	/*
	 * Retorna detalhes das vendas de um produto em um determinado dia.
	 */
	public String [][] retornaVendasDeProduto(String codigoProduto, String dataFaturamento) {

		try {
			String codigoFaturamento;
			if (dataFaturamento == null) {
				codigoFaturamento = Integer.toString(this.controleFaturamentos.retornaNumeroFaturamentos() - 1);
			}
			else {
				codigoFaturamento = this.controleFaturamentos.retornaCodigoFaturamentoPorData(dataFaturamento);
			}
			
			return this.controleFaturamentos.retornaDadosVendasPorProduto(codigoFaturamento, codigoProduto);
		}
		catch (Exception e) {
			throw e;
		}

	}
	
	/*
	 * Retorna o valor total das vendas de um produto em um determinado dia. 
	 */
	public String retornaValorDeVendasDeProduto(String codigoProduto, String dataFaturamento) {
		try {
			String codigoFaturamento;
			if (dataFaturamento == null) {
				codigoFaturamento = Integer.toString(this.controleFaturamentos.retornaNumeroFaturamentos() - 1);
			}
			else {
				codigoFaturamento = this.controleFaturamentos.retornaCodigoFaturamentoPorData(dataFaturamento);
			}
			
			String formato = "R$ #,##0.00";
			DecimalFormat d = new DecimalFormat(formato);
			double retorno = this.controleFaturamentos.retornaValorFaturamentoPorProduto(codigoFaturamento, codigoProduto);
			return d.format(retorno);
		}
		catch (Exception e) {
			throw e;
		}
	}
	
	/*
	 * Retorna dados de vendas de um faturamento por sua data.
	 */
	
	public String [][] retornaDadosVendasDeUmFaturamento(String dataFaturamento) {
		try {
			String codigoFaturamento;
			if (dataFaturamento == null) {
				codigoFaturamento = Integer.toString(this.controleFaturamentos.retornaNumeroFaturamentos() - 1);
			}
			else {
				codigoFaturamento = this.controleFaturamentos.retornaCodigoFaturamentoPorData(dataFaturamento);
			}
			
			return this.controleFaturamentos.retornaDadosVendasDeUmFaturamento(codigoFaturamento);
		}
		catch (Exception e) {
			throw e;
		}
	}
	
	/*
	 * Retorna o valor total das vendas em um determinado dia. 
	 */
	public String retornaValorFaturamento(String dataFaturamento) {
		try {
			String codigoFaturamento;
			if (dataFaturamento == null) {
				codigoFaturamento = Integer.toString(this.controleFaturamentos.retornaNumeroFaturamentos() - 1);
			}
			else {
				codigoFaturamento = this.controleFaturamentos.retornaCodigoFaturamentoPorData(dataFaturamento);
			}
			
			String formato = "R$ #,##0.00";
			DecimalFormat d = new DecimalFormat(formato);
			double retorno = this.controleFaturamentos.retornaValorFaturamento(codigoFaturamento);
			return d.format(retorno);
		}
		catch (Exception e) {
			throw e;
		}
	}
	
	/*
	 * Função que retorna dados de faturamentos em um intervalo de datas.
	 */
	public String [][] retornaDadosVendasDeUmIntervaloDeFaturamentos(String dataInicio, String dataFinal) {
		try {
			return this.controleFaturamentos.retornaDadosVendasDeUmIntervaloDeFaturamentos(dataInicio, dataFinal);
		}
		catch (Exception e) {
			throw e;
		}
	}
	
	/*
	 * Retorna o valor somado de faturamentos em um intervalo de datas.
	 */
	public String retornaValorIntervaloFaturamentos(String dataInicio, String dataFinal) {
		try {
			
			String formato = "R$ #,##0.00";
			DecimalFormat d = new DecimalFormat(formato);
			double retorno = this.controleFaturamentos.retornaValorIntervaloFaturamentos(dataInicio, dataFinal);
			return d.format(retorno);
		}
		catch (Exception e) {
			throw e;
		}
	}
	
	/*
	 * Retornos de números de entidades armazenadas.
	 */
	public int retornaNumeroFuncionarios() {
		return controleFuncionarios.retornaNumeroFuncionarios();
	}

	public int retornaNumeroProdutos() {
		return controleProdutos.retornaNumeroProdutos();
	}

	public int retornaNumeroMesas() {
		return controleMesas.retornaNumeroMesas();
	}

	public int retornaNumeroDescontos() {
		return controleDescontos.retornaNumeroDescontos();
	}

	public int getCodigoFaturamentoAtual() {
		return codigoFaturamentoAtual;
	}

	public void setCodigoFaturamentoAtual(int codigoFaturamentoAtual) {
		this.codigoFaturamentoAtual = codigoFaturamentoAtual;
	}

	public String [][] retornaVetorToStringMesas() {

		try {
			String [][] retorno = this.controleMesas.retornaVetorToStringMesas();
			return retorno;
		}
		catch (Exception e) {
			throw e;
		}
	}

	public String [][] retornaVetorToStringDescontos() {

		try {
			String [][] retorno = this.controleDescontos.retornaVetorToStringDescontos();
			return retorno;
		}
		catch (Exception e) {
			throw e;
		}
	}

	public String [][] retornaVetorToStringProdutos() {

		try {
			String [][] retorno = this.controleProdutos.retornaVetorToStringProdutos();
			return retorno;
		}
		catch (Exception e) {
			throw e;
		}	
	}

	public String [][] retornaVetorToStringVendasFaturamento(String codigoFaturamento) {

		try {
			String [][] retorno = this.controleFaturamentos.retornaVetorToStringVendas(codigoFaturamento);
			return retorno;
		}
		catch (Exception e) {
			throw e;
		}	
	}

	public String [][] retornaVetorToStringVendasFaturamentoDia() {
		try {
			return retornaVetorToStringVendasFaturamento(Integer.toString(this.controleFaturamentos.retornaNumeroFaturamentos() - 1));
		}
		catch (Exception e) {
			throw e;
		}
	}

	public void limparBase() {

		try {
			this.controleDescontos.limparDescontos();
			this.controleFaturamentos.limparFaturamentos();
			this.controleFuncionarios.limparFuncionarios();
			this.controleMesas.limparMesas();
			this.controleProdutos.limparProdutos();
		}
		catch (Exception e) {
			throw e;
		}
	}

	/*
	 * Funções relacionadas a vendas:
	 */

	/*
	 * Verificando se o valor de um desconto do tipo valor é maior que
	 * o valor do produto.
	 */
	public boolean retornaDescontoMaiorQueValorProduto(String codigoProduto, int quantidadeProduto, 
			String codigoDesconto) {
		try {
			String tipoDesconto = this.controleDescontos.retornaTipoDesconto(codigoDesconto);
			if (!tipoDesconto.equals("Valor")) {
				return false;
			}

			Double valorDesconto = this.controleDescontos.retornaValorDesconto(codigoDesconto);
			Double valorProduto = this.controleProdutos.retornaValorProduto(codigoProduto);

			if (valorDesconto <= (valorProduto*quantidadeProduto)) {
				return false;
			}

			return true;
		}
		catch (Exception e) {
			throw e;
		}
	}

	public int retornaNumeroDeVendasFaturamentoAtual() {
		try {
			int retorno = this.controleFaturamentos.retornaNumeroDeVendas(
					Integer.toString(this.controleFaturamentos.retornaNumeroFaturamentos() - 1));
			return retorno;
		}
		catch (Exception e){
			throw e;
		}
	}

	public double retornaValorApuradoFaturamentoAtual() {
		try {
			double retorno = this.controleFaturamentos.retornaValorFaturamento(
					Integer.toString(this.controleFaturamentos.retornaNumeroFaturamentos() - 1));
			return retorno;
		}
		catch (Exception e) {
			throw e;
		}
	}

	public boolean getManterFaturamentoAnterior() {
		return manterFaturamentoAnterior;
	}

	public void setManterFaturamentoAnterior(boolean manterFaturamentoAnterior) {
		this.manterFaturamentoAnterior = manterFaturamentoAnterior;
	}
	
	
}
