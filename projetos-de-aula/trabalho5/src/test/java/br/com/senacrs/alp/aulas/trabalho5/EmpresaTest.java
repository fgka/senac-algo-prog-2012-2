package br.com.senacrs.alp.aulas.trabalho5;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.senacrs.alp.aulas.trabalho5.Empresa;
import br.com.senacrs.alp.aulas.trabalho5.Funcionario;
import br.com.senacrs.alp.aulas.trabalho5.FuncionarioFactory;

public class EmpresaTest {

	private static Random random = new Random(System.currentTimeMillis());
	private Empresa empresa = null;
	private FuncionarioFactory factory = null;

	@Before
	public void setUp() throws Exception {

		this.empresa = null; // substituir por new EmpresaImp();
		this.factory = null; // colocar seu
								// FuncionarioFactoryImpl.getInstancia();
	}

	@After
	public void tearDown() throws Exception {

		this.empresa = null;
		this.factory = null;
	}

	@Test
	public void testAdicionaFuncionarioNull() {

		try {
			this.empresa.adicionaFuncionario(null);
			fail("Não deveria aceitar funcionario null");
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
		}
	}

	@Test
	public void testAdicionaFuncionario() {

		Funcionario funcionario = null;
		String nome = null;
		int salario = 0;

		nome = "Nome";
		salario = random.nextInt(1000);
		funcionario = this.factory.criaFuncionario(nome, salario);
		try {
			this.empresa.adicionaFuncionario(funcionario);
			Assert.assertTrue(true);
		} catch (IllegalArgumentException e) {
			fail("Deveria ter aceitado o funcionario");
		}
	}

	@Test
	public void testBuscaFuncionarioNull() {

		Funcionario busca = null;
		
		busca = this.empresa.buscaFuncionario(null);
		Assert.assertNull(busca);
	}

	@Test
	public void testBuscaFuncionarioNaoExiste() {

		Funcionario busca = null;
		
		busca = this.empresa.buscaFuncionario("nome");
		Assert.assertNull(busca);
	}

	@Test
	public void testBuscaFuncionario() {

		Funcionario busca = null;		
		Funcionario adicionado = null;		
		String nome = null;
		int salario = 0;

		nome = "Nome";
		salario = random.nextInt(1000);
		adicionado = this.adicionarFuncionario(nome, salario);
		busca = this.empresa.buscaFuncionario(nome);
		Assert.assertEquals(adicionado, busca);
	}
	
	private Funcionario adicionarFuncionario(String nome, int salario) {

		Funcionario resultado = null;
		
		resultado = this.factory.criaFuncionario(nome, salario);
		this.empresa.adicionaFuncionario(resultado);
		
		return resultado;
	}

	@Test
	public void testTotalFolhaPgtoSemFuncionarios() {

		int total = 0;
		
		total = this.empresa.totalFolhaPgto();
		Assert.assertEquals(0, total);
	}

	@Test
	public void testTotalFolhaPgtoComUmFuncionario() {

		int total = 0;		
		String nome = null;
		int salario = 0;

		nome = "Nome";
		salario = random.nextInt(1000);
		this.adicionarFuncionario(nome, salario);
		total = this.empresa.totalFolhaPgto();
		Assert.assertEquals(salario, total);
	}

	@Test
	public void testTotalFolhaPgtoComVariosFuncionario() {

		int total = 0;		
		String nome = null;
		int salario = 0;
		int esperado = 0;

		esperado = 0;
		for (int i = 0; i < 10; i++) {			
			nome = "Nome" + i;
			salario = random.nextInt(1000);
			this.adicionarFuncionario(nome, salario);
			esperado += salario;
		}
		total = this.empresa.totalFolhaPgto();
		Assert.assertEquals(esperado, total);
	}
}
