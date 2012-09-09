package br.com.senacrs.alp.aulas;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MinhaPilhaImpTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAbstractMinhaPilha() {
		
		MinhaPilhaImp<Object> obj = null;
		
		try {
			obj = new MinhaPilhaImp<Object>();
			Assert.assertNotNull(obj);
		} catch (Exception e) {
			fail("Não deveria lançar exceção");
		}
	}

	@Test
	public void testPush() {
		
		MinhaPilhaImp<String> obj = null;
		String valor = null;
		String valorPosicaoZero = null;

		obj = new MinhaPilhaImp<String>();
		valor = "valor";
		obj.push(valor);
		valorPosicaoZero = consultarValorTopo(obj);
		Assert.assertEquals(valorPosicaoZero, valor);
	}

	private <T> T consultarValorTopo(MinhaPilhaImp<T> obj) {
		
		T resultado = null;
		MinhaLista<T> lista = null;
		
		lista = obj.getMinhaLista();
		resultado = lista.buscar(0);

		return resultado;
	}

	@Test
	public void testPop() {
		fail("Not yet implemented");
	}

}
