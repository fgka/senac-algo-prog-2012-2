package br.com.senacrs.alp.exercicio;

import java.util.Comparator;

public class PessoaIdadeComparator implements Comparator<Pessoa> {
	
	private static Comparator<Pessoa> instancia = new PessoaIdadeComparator();
	
	private PessoaIdadeComparator() {

		super();
	}

	public int compare(Pessoa o1, Pessoa o2) {
		
		int resultado = 0;
		int idade1 = 0;
		int idade2 = 0;
		
		idade1 = o1.getIdade();
		idade2 = o2.getIdade();		
		resultado = idade1 - idade2;
		resultado = normalizar(resultado);		
		
		return resultado;
	}

	private int normalizar(int valor) {
		
		int resultado = 0;
		
		if (valor > 0) {
			resultado = 1;
		} else if (valor < 0) {
			resultado = -1;
		}

		return resultado;
	}
	
	public static Comparator<Pessoa> getInstancia() {
		
		return instancia;
	}
}
