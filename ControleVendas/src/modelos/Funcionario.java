package modelos;

public class Funcionario {

	private String nomeFuncionario;
	private String cpfFuncionario;
	private String telefoneFuncionario;
	private String emailFuncionario;
	private String codigoFuncionario;
	
	
	public Funcionario(String nome, String cpf, String telefone, String email, String codigo) {
		
		this.nomeFuncionario = nome;
		this.cpfFuncionario = cpf;
		this.telefoneFuncionario = telefone;
		this.codigoFuncionario = codigo;
	}


	public String getNomeFuncionario() {
		return nomeFuncionario;
	}


	public void setNomeFuncionario(String nomeFuncionario) {
		this.nomeFuncionario = nomeFuncionario;
	}


	public String getCpfFuncionario() {
		return cpfFuncionario;
	}


	public void setCpfFuncionario(String cpfFuncionario) {
		this.cpfFuncionario = cpfFuncionario;
	}


	public String getTelefoneFuncionario() {
		return telefoneFuncionario;
	}


	public void setTelefoneFuncionario(String telefoneFuncionario) {
		this.telefoneFuncionario = telefoneFuncionario;
	}


	public String getEmailFuncionario() {
		return emailFuncionario;
	}


	public void setEmailFuncionario(String emailFuncionario) {
		this.emailFuncionario = emailFuncionario;
	}


	public String getCodigoFuncionario() {
		return codigoFuncionario;
	}


	public void setCodigoFuncionario(String codigoFuncionario) {
		this.codigoFuncionario = codigoFuncionario;
	}


	@Override
	public String toString() {
		return  "Código: " + codigoFuncionario + "   Nome: " + nomeFuncionario;
	}
	
	
}

