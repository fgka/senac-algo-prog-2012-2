package br.com.senacrs.alp.aulas.trabalho10;

import static org.junit.Assert.*;

import java.io.File;
import java.util.Arrays;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GerenciadorDeArquivosTest {

	private final static String DIRETORIO_ENTRADA = System
			.getProperty("user.dir")
			+ File.separatorChar
			+ "diretorio"
			+ File.separatorChar;
	private final static String NOME_ARQUIVO_ENTRADA = "entrada.txt";
	private final static String NOME_ARQUIVO_SAIDA = "saida.txt";
	private final static String ARQUIVO_ENTRADA = DIRETORIO_ENTRADA
			+ NOME_ARQUIVO_ENTRADA;
	private final static String ARQUIVO_SAIDA = DIRETORIO_ENTRADA
			+ NOME_ARQUIVO_SAIDA;
	private final static String LIDO = "ler";
	private final static String RETORNADO = "manipular";
	private final static String[] CONTEUDO = new String[] {
			"Este e o arquivo de entrada e deve", // 0
			"ser utilizado nos testes", // 1
			"Verifique que voce nao apagou o mesmo", // 2
			"", // 3
			"Eu consigo ler o arquivo", // 4
			"Eu consigo escrever no arquivo", // 5
	};
	private static String SUBISTITUICAO = "Eu consigo " + RETORNADO
			+ " o arquivo";

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCriarNulo() {

		try {
			criarGerenciadoDeArquivo(null);
			fail("Deveria ter abortado");
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
		}
	}

	private GerenciadorDeArquivo criarGerenciadoDeArquivo(String arquivo) {

		return new GerenciadorDeArquivo(arquivo);
	}

	@Test
	public void testCriarDiretorio() {

		try {
			criarGerenciadoDeArquivo(DIRETORIO_ENTRADA);
			fail("Deveria ter abortado");
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
		}
	}

	@Test
	public void testCriarArquivoValido() {

		criarGerenciadoDeArquivo(ARQUIVO_ENTRADA);
	}

	@Test
	public void testLerArquivoInexistente() {

		GerenciadorDeArquivo obj = null;

		try {
			obj = criarGerenciadoDeArquivo(ARQUIVO_SAIDA);
			obj.lerArquivo();
			fail("Deveria ter abortado");
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
		}
	}

	@Test
	public void testLerArquivo() {

		GerenciadorDeArquivo obj = null;
		String[] resultado = null;
		String msg = null;

		obj = criarGerenciadoDeArquivo(ARQUIVO_ENTRADA);
		resultado = obj.lerArquivo();
		msg = "Resultado :" + Arrays.toString(resultado);
		msg += " Esperado :" + Arrays.toString(CONTEUDO);
		Assert.assertTrue(msg, Arrays.deepEquals(CONTEUDO, resultado));
	}

	@Test
	public void testLerArquivoComSubstituicaoInexistente() {

		GerenciadorDeArquivo obj = null;

		try {
			obj = criarGerenciadoDeArquivo(ARQUIVO_SAIDA);
			obj.lerArquivoComSubstituicao(LIDO, RETORNADO);
			fail("Deveria ter abortado");
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
		}
	}

	@Test
	public void testLerArquivoComSubstituicao() {

		GerenciadorDeArquivo obj = null;
		String[] resultado = null;
		String[] esperado = null;
		String msg = null;

		obj = criarGerenciadoDeArquivo(ARQUIVO_ENTRADA);
		resultado = obj.lerArquivoComSubstituicao(LIDO, RETORNADO);
		esperado = corrigirConteudo();
		msg = "Resultado :" + Arrays.toString(resultado);
		msg += " Esperado :" + Arrays.toString(esperado);
		Assert.assertTrue(msg, Arrays.deepEquals(esperado, resultado));
	}

	private String[] corrigirConteudo() {
		String[] esperado;
		esperado = Arrays.copyOf(CONTEUDO, CONTEUDO.length);
		esperado[4] = SUBISTITUICAO;
		return esperado;
	}

	@Test
	public void testEscreverArquivo() {

		GerenciadorDeArquivo entrada = null;
		GerenciadorDeArquivo saida = null;
		GerenciadorDeArquivo entradaDaSaida = null;
		String[] conteudo = null;
		String[] resultado = null;
		String[] esperado = null;
		String msg = null;

		entrada = criarGerenciadoDeArquivo(ARQUIVO_ENTRADA);
		saida = criarGerenciadoDeArquivo(ARQUIVO_SAIDA);
		conteudo = entrada.lerArquivoComSubstituicao(LIDO, RETORNADO);
		saida.escreverArquivo(conteudo);
		entradaDaSaida = criarGerenciadoDeArquivo(ARQUIVO_SAIDA);
		resultado = entradaDaSaida.lerArquivo();
		esperado = corrigirConteudo();
		msg = "Resultado :" + Arrays.toString(resultado);
		msg += " Esperado :" + Arrays.toString(esperado);
		Assert.assertTrue(msg, Arrays.deepEquals(esperado, resultado));
	}

}
