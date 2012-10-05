package br.com.senacrs.alp.exercicio;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import junit.framework.Assert;

import org.junit.Test;

public class PessoaIdadeComparatorTest {
	
	private static String PREFIXO_NOME_PESSOA = "Pessoa_";
	private static int IDADE_MAXIMA = 150;
	private static Random rand = new Random(0); 

	@Test
	public void testComparatorMesmo() {
		
		Pessoa p = null;
		Comparator<Pessoa> comp = null;
		int resultado = 0;
		
		p = new Pessoa("p", 10);
		comp = comparator();
		resultado = comp.compare(p, p);		
		Assert.assertEquals(0, resultado);
	}

	private Comparator<Pessoa> comparator() {

		return PessoaIdadeComparator.getInstancia();
	}

	@Test
	public void testComparatorIguais() {
		
		Pessoa p1 = null;
		Pessoa p2 = null;
		Comparator<Pessoa> comp = null;
		int resultado = 0;
		
		p1 = new Pessoa("p1", 10);
		p2 = new Pessoa("p2", 10);
		comp = comparator();
		resultado = comp.compare(p1, p2);		
		Assert.assertEquals(0, resultado);
	}

	@Test
	public void testComparatorP1Menor() {
		
		Pessoa p1 = null;
		Pessoa p2 = null;
		Comparator<Pessoa> comp = null;
		int resultado = 0;
		
		p1 = new Pessoa("p1", 10);
		p2 = new Pessoa("p2", 20);
		comp = comparator();
		resultado = comp.compare(p1, p2);		
		Assert.assertEquals(-1, resultado);
	}

	@Test
	public void testComparatorP1Maior() {
		
		Pessoa p1 = null;
		Pessoa p2 = null;
		Comparator<Pessoa> comp = null;
		int resultado = 0;
		
		p1 = new Pessoa("p1", 20);
		p2 = new Pessoa("p2", 10);
		comp = comparator();
		resultado = comp.compare(p1, p2);		
		Assert.assertEquals(1, resultado);
	}

	@Test
	public void testComparatorListSort() {
		
		List<Pessoa> lista = null;
		Comparator<Pessoa> comp = null;
		int idadeAnt = 0;
		int idadeAtual = 0;
				
		lista = criarLista(10);
		comp = comparator();
		Collections.sort(lista, comp);
		idadeAnt = -1;
		for (Pessoa p : lista) {
			idadeAtual = p.getIdade();
			Assert.assertTrue(String.valueOf(lista), idadeAnt < idadeAtual);
			idadeAnt = idadeAtual;
		}
	}

	private List<Pessoa> criarLista(int quantidade) {
		
		List<Pessoa> resultado = new LinkedList<Pessoa>();
		Pessoa p = null;
		
		for (int i = 0; i < quantidade; i++) {
			p = criarPessoaIdadeAleatoria(i);
			resultado.add(p);
		}

		return resultado;
	}

	private Pessoa criarPessoaIdadeAleatoria(int indice) {
		
		Pessoa resultado = null;
		String nome = null;
		int idade = 0;
		
		nome = PREFIXO_NOME_PESSOA + String.valueOf(indice);
		idade = rand.nextInt(IDADE_MAXIMA);
		resultado = new Pessoa(nome, idade); 

		return resultado;
	}
}
