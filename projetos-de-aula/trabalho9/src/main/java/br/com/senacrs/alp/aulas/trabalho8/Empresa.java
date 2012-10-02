package br.com.senacrs.alp.aulas.trabalho8;

import java.util.List;

public interface Empresa {
	
	void adicionaFuncionario(Funcionario funcionario);
	
	Funcionario buscaFuncionario(String nome);
	
	int totalFolhaPgto();
	
	List<Funcionario> ordemCrescenteSalario();

	List<Funcionario> ordemDecrescenteSalario();

	List<Funcionario> ordemAlfabetica();
}
