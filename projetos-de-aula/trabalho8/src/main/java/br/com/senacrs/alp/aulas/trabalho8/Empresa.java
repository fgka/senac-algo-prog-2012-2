package br.com.senacrs.alp.aulas.trabalho8;

public interface Empresa {
	
	void adicionaFuncionario(Funcionario funcionario);
	
	Funcionario buscaFuncionario(String nome);
	
	int totalFolhaPgto();
}
