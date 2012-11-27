package br.com.senacrs.alp.aulas.trabalho12;

import org.junit.Assert;
import org.junit.Test;

public class ConfiguracaoTest {

	@Test
	public void testConfiguracaoRootDirNull() {

		Configuracao obj = null;

		try {
			obj = new Configuracao(null, 123);
			Assert.fail(obj.toString());
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
		}
	}

	@Test
	public void testConfiguracaoRootDirVazio() {

		Configuracao obj = null;

		try {
			obj = new Configuracao("", 123);
			Assert.fail(obj.toString());
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
		}
	}

	@Test
	public void testConfiguracaoRootDirSemPrefixo() {

		Configuracao obj = null;

		try {
			obj = new Configuracao("/", 123);
			Assert.fail(obj.toString());
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
		}
	}

	@Test
	public void testConfiguracaoPortNegativa() {

		Configuracao obj = null;

		try {
			obj = new Configuracao("./", -1);
			Assert.fail(obj.toString());
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
		}
	}

	@Test
	public void testConfiguracaoPortAcima() {

		Configuracao obj = null;

		try {
			obj = new Configuracao("./", 70000);
			Assert.fail(obj.toString());
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
		}
	}

	@Test
	public void testConfiguracao() {

		Configuracao obj = null;

		obj = new Configuracao("./", 123);
		Assert.assertNotNull(obj);
	}

	@Test
	public void testGetRootDirTraduzidoUserDir() {

		Configuracao obj = null;
		String esperado = null;
		String obtido = null;

		esperado = Configuracao.PWD;
		obj = new Configuracao("./", 123);
		obtido = obj.getRootDirTraduzido();
		Assert.assertEquals(esperado, obtido);
	}

	@Test
	public void testGetRootDirTraduzido() {

		Configuracao obj = null;
		String esperado = null;
		String obtido = null;
		String nomeDir = null;

		nomeDir = "diretorio";
		esperado = Configuracao.PWD + nomeDir;
		obj = new Configuracao("./" + nomeDir, 123);
		obtido = obj.getRootDirTraduzido();
		Assert.assertEquals(esperado, obtido);
	}

	@Test
	public void testToString() {

		Configuracao obj = null;
		String esperado = null;
		String obtido = null;
		String nomeDir = null;
		int port = 0;

		port = 1234;
		nomeDir = "diretorio";
		esperado = String.valueOf(port) 
				+ ":" + Configuracao.PWD + nomeDir;
		obj = new Configuracao("./" + nomeDir, port);
		obtido = obj.toString();
		Assert.assertEquals(esperado, obtido);
	}

}
