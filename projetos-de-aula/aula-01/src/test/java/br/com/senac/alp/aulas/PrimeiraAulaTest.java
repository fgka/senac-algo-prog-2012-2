package br.com.senac.alp.aulas;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Random;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class PrimeiraAulaTest {
	
	private PrimeiraAula obj = null;

	@Before
	public void setUp() throws Exception {

		obj = PrimeiraAula.getInstancia();
	}

	@After
	public void tearDown() throws Exception {

		obj = null;
	}

	@Test
	public void testSomaResultadoArgumentoNulo() {

		double[] valores = null;		
		double esperado = 0.0;
		double resultado = 0.0;
		int comparacao = 0;
		
		esperado = Double.NaN;
		resultado = this.obj.somaTotal(valores);
		comparacao = Double.compare(resultado, esperado);
		Assert.assertEquals(
				"Quando o argumento for nulo deve retornar " + String.valueOf(esperado) 
				+ ", valor retornando: " + String.valueOf(resultado),
				comparacao, 0);
		
	}

	@Test
	public void testSomaResultadoArgumentoVazio() {

		double[] valores = null;		
		double esperado = 0.0;
		double resultado = 0.0;
		int comparacao = 0;
		
		valores = new double[0];
		resultado = this.obj.somaTotal(valores);
		comparacao = Double.compare(resultado, esperado);
		Assert.assertEquals(
				"Quando o argumento for vazio deve retornar " + String.valueOf(esperado) 
				+ ", valor retornando: " + String.valueOf(resultado),
				comparacao, 0);
		
	}

	@Test
	public void testSomaResultadoArgumentoArrayUnitario() {

		double[] valores = null;		
		double esperado = 0.0;
		double resultado = 0.0;
		int comparacao = 0;
		
		valores = new double[1];
		valores[0] = Math.random();
		esperado = valores[0];
		resultado = this.obj.somaTotal(valores);
		comparacao = Double.compare(resultado, esperado);
		Assert.assertEquals(
				"Esperado valor: " + String.valueOf(esperado) 
				+ ", mas retornado valor: " + String.valueOf(resultado),
				comparacao, 0);
		
	}

	@Test
	public void testSomaResultadoArgumentoArray() {

		double[] valores = null;		
		double esperado = 0.0;
		double resultado = 0.0;
		int comparacao = 0;
		
		valores = new double[10];
		for (int i = 0; i < valores.length; i++) {
			double val = Math.random();
			valores[i] = val;
			esperado += val;
		}
		resultado = this.obj.somaTotal(valores);
		comparacao = Double.compare(resultado, esperado);
		Assert.assertEquals(
				"Esperado valor: " + String.valueOf(esperado) 
				+ ", mas retornado valor: " + String.valueOf(resultado)
				+ " array completo: " + Arrays.toString(valores),
				comparacao, 0);
		
	}
}
