package controladores;

import modelos.Funcionario;
import baseDados.BaseDados;

public class ControleFuncionarios {
	
	BaseDados base;
	
	public ControleFuncionarios() {
		
		base = new BaseDados();
	}
	
	
	public void adicionarFuncionario(String nome, String cpf, String telefone, String email, String codigo) {
		
		try {
			Funcionario funcionario = new Funcionario(nome, cpf, telefone, email, codigo);
			base.inserirFuncionario(codigo, funcionario);
		}
		catch(Exception e) {
			throw e;
		}
	}
}
