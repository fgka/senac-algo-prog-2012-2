package br.com.senacrs.alp.exercicio;

public class Pessoa {

	private final String nome;
	private final int idade;
	
	public Pessoa(String nome, int idade) {
		
		super();
		
		this.nome = nome;
		this.idade = idade;
	}

	public String getNome() {
		return nome;
	}

	public int getIdade() {
		return idade;
	}
		
	@Override
	public String toString() {
		
		String result = "";
		
		result = "[" + getNome() + " : " + getIdade() + "]";
		
		return result;
	}
}
