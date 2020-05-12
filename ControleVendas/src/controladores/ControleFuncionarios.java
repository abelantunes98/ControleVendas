package controladores;

import modelos.Funcionario;
import baseDados.BaseDados;

public class ControleFuncionarios {
	
	BaseDados base;
	
	public ControleFuncionarios(BaseDados base) {
		
		this.base = base;
	}
	
	
	public void adicionarFuncionario(String nome, String cpf, String telefone, String email, String codigo) {
		
		try {
			if (nome.equals("") || cpf.equals("") || telefone.equals("") || email.equals("") 
					|| codigo.equals("")) {
				throw new IllegalArgumentException("Campos passados vazios!");
			}
			
			Funcionario funcionario = new Funcionario(nome, cpf, telefone, email, codigo);
			base.inserirFuncionario(codigo, funcionario);
		}
		catch(Exception e) {
			throw e;
		}
	}
	
	public void removerFuncionario(String codigoFuncionario) {
		
		try {
			base.removerFuncionario(codigoFuncionario);
		}
		catch (Exception e) {
			throw e;
		}
	}
	
	public boolean funcionarioExiste(String codigoFuncionario) {
		
		return base.existeFuncionario(codigoFuncionario);
	}
	
	public int retornaNumeroFuncionarios() {
		return base.retornaNumeroFuncionarios();
	}
	
	public void limparFuncionarios() {
		try {
			this.base.limparFuncionarios();
		}
		catch (Exception e) {
			throw e;
		}
	}
}
