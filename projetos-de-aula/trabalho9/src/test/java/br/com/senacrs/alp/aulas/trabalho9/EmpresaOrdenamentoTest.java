package br.com.senacrs.alp.aulas.trabalho9;

import java.util.List;
import java.util.Random;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.senacrs.alp.aulas.trabalho9.Empresa;
import br.com.senacrs.alp.aulas.trabalho9.EmpresaImpl;
import br.com.senacrs.alp.aulas.trabalho9.Funcionario;
import br.com.senacrs.alp.aulas.trabalho9.FuncionarioFactory;
import br.com.senacrs.alp.aulas.trabalho9.FuncionarioFactoryImpl;

public class EmpresaOrdenamentoTest {

	private static Random random = new Random(System.currentTimeMillis());
	private Empresa empresa = null;
	private FuncionarioFactory factory = null;

	@Before
	public void setUp() throws Exception {

		this.empresa = new EmpresaImpl();
		this.factory = FuncionarioFactoryImpl.getInstancia();
	}

	@After
	public void tearDown() throws Exception {

		this.empresa = null;
		this.factory = null;
	}
	
	@Test
	public void testOrdemCrescenteSalario() {
		
		int qtd = 10;
		List<Funcionario> resultado = null;
		int salarioAnt = 0;
		int salarioAtual = 0;
		
		for (int i = 0; i < qtd; i++) {			
			this.adicionarFuncionariosAleatorios(qtd);
		}
		resultado = this.empresa.ordemCrescenteSalario();
		Assert.assertEquals(qtd, resultado.size());
		salarioAnt = -1;
		for (Funcionario f : resultado) {
			salarioAtual = f.getSalario();
			Assert.assertFalse(salarioAtual < salarioAnt);
			salarioAnt = salarioAtual;
		}
	}

	private void adicionarFuncionariosAleatorios(int qtd) {

		String nome = null;
		int salario = 0;

		nome = criarString(qtd);
		salario = random.nextInt(1000);
		this.adicionarFuncionario(nome, salario);
	}
	
	private String criarString(int quantidade) {
		
		StringBuffer resultado = new StringBuffer();
		
		for (int i = 0; i < quantidade; i++) {
			resultado.append(criarChar());
		}
		
		return resultado.toString();
	}
	
	private char criarChar() {
		
		char resultado = '\0';
		
		resultado = (char)((int)'A' + random.nextInt((int)'Z' - (int)'A'));
		
		return resultado;
	}

	private Funcionario adicionarFuncionario(String nome, int salario) {

		Funcionario resultado = null;
		
		resultado = this.factory.criaFuncionario(nome, salario);
		this.empresa.adicionaFuncionario(resultado);
		
		return resultado;
	}
	
	@Test
	public void testOrdemDecrescenteSalario() {
		
		int qtd = 10;
		List<Funcionario> resultado = null;
		int salarioAnt = 0;
		int salarioAtual = 0;
		
		for (int i = 0; i < qtd; i++) {			
			this.adicionarFuncionariosAleatorios(qtd);
		}
		resultado = this.empresa.ordemDecrescenteSalario();
		Assert.assertEquals(qtd, resultado.size());
		salarioAnt = -1;
		for (Funcionario f : resultado) {
			salarioAtual = f.getSalario();
			Assert.assertFalse(salarioAtual > salarioAnt);
			salarioAnt = salarioAtual;
		}
	}
	
	@Test
	public void testOrdemAlfabetica() {
		
		int qtd = 10;
		List<Funcionario> resultado = null;
		String nomeAnt = null;
		String nomeAtual = null;
		
		for (int i = 0; i < qtd; i++) {			
			this.adicionarFuncionariosAleatorios(qtd);
		}
		resultado = this.empresa.ordemAlfabetica();
		Assert.assertEquals(qtd, resultado.size());
		nomeAnt = "";
		for (Funcionario f : resultado) {
			nomeAtual = f.getNome();
			Assert.assertFalse(nomeAtual.compareTo(nomeAnt) > 0);
			nomeAnt = nomeAtual;
		}
	}
}
