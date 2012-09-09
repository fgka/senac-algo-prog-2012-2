package br.com.senac.alp.aulas.aula3;

public interface Empresa {
	
	void adicionaFuncionario(Funcionario funcionario);
	
	Funcionario buscaFuncionario(String nome);
	
	int totalFolhaPgto();
}
