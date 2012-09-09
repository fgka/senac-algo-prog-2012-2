package br.com.senacrs.alp.aulas.trabalho5;

import static org.junit.Assert.*;

import java.util.Random;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.senacrs.alp.aulas.trabalho5.Funcionario;
import br.com.senacrs.alp.aulas.trabalho5.FuncionarioFactory;

public class FuncionarioFactoryTest {

	private static Random random = new Random(System.currentTimeMillis()); 
	private FuncionarioFactory factory = null;

	@Before
	public void setUp() throws Exception {

		this.factory = null; // colocar seu
								// FuncionarioFactoryImpl.getInstancia();
	}

	@After
	public void tearDown() throws Exception {

		this.factory = null; // manter assim
	}

	@Test
	public void testCriaFuncionarioNomeNull() {

		try {
			this.factory.criaFuncionario(null, 0);
			fail("Não pode aceitar funcionario com nome null");
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
		}
	}

	@Test
	public void testCriaFuncionarioSemNome() {

		try {
			this.factory.criaFuncionario("", 0);
			fail("Não pode aceitar funcionario sem nome");
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
		}
	}

	@Test
	public void testCriaFuncionarioSalarioNegativo() {
		
		int salario = 0;
		
		try {
			salario = 0 - Math.abs(random.nextInt(100));
			this.factory.criaFuncionario("Nome", salario);
			fail("Não pode aceitar funcionario com salario negativo: " + salario);
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
		}
	}

	@Test
	public void testCriaFuncionario() {
		
		Funcionario funcionario = null;

		funcionario = this.factory.criaFuncionario("Nome", random.nextInt(100));
		Assert.assertNotNull(funcionario);
	}
}
