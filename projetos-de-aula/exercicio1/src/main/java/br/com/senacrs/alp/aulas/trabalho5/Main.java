package br.com.senacrs.alp.aulas.trabalho5;

public class Main {

	public static void main(String[] args) {

		Pessoa pessoaCliente = new Cliente();
		Pessoa pessoaFuncionario = new Funcionario();
		Cliente cliente = null;
		Funcionario funcionario = null;

		imprimeTipo("pC", pessoaCliente);
		imprimeTipo("pF", pessoaFuncionario);
		cliente = (Cliente) pessoaCliente;
		funcionario = (Funcionario) pessoaFuncionario;
		try {
			cliente = (Cliente) pessoaFuncionario;
		} catch (ClassCastException e) {
			System.out.println("pessoaFuncionario não é do tipo Cliente, cast inválido");
		}
	}

	private static void imprimeTipo(String id, Pessoa pessoa) {

		if (pessoa instanceof Cliente) {
			System.out.println(id + " é uma pessoa");
		} else if (pessoa instanceof Funcionario) {
			System.out.println(id + " é um funcionário");
		}
	}
}
