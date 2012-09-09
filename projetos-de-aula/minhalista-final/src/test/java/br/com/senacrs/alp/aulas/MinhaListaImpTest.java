package br.com.senacrs.alp.aulas;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MinhaListaImpTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMinhaListaImp() {
		
		MinhaListaImp<Object> obj = null;
	
		try {
			obj = new MinhaListaImp<Object>();
		} catch (Exception e) {
			fail("Deve funcionar");
		}
		Assert.assertNotNull(obj);
	}

	@Test
	public void testSufixar() {
		
		MinhaListaImp<String> obj = null;
		String sufixo = null;
		String sufixoReal = null;
		
		obj = criarMinhaListaImp();
		sufixo = "sufixo";
		obj.sufixar(sufixo);
		sufixoReal = buscarSufixo(obj);
		Assert.assertEquals(sufixo, sufixoReal);
	}

	private <T> MinhaListaImp<T> criarMinhaListaImp() {
		
		MinhaListaImp<T> obj = null;

		obj = new MinhaListaImp<T>();
		
		return obj;
	}

	private <T> T buscarSufixo(MinhaListaImp<T> obj) {
		
		T resultado = null;
		Nodo<T> nodo = null;

		nodo = obj.getInicio();
		while (nodo.getProximo() != null) {
			nodo = nodo.getProximo();
		}
		resultado = nodo.getValor();
		
		return resultado;
	}

	@Test
	public void testPrefixar() {
		fail("Not yet implemented");
	}

	@Test
	public void testBuscar() {
		fail("Not yet implemented");
	}

	@Test
	public void testInserir() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemover() {
		fail("Not yet implemented");
	}

	@Test
	public void testTamanho() {
		fail("Not yet implemented");
	}

}
