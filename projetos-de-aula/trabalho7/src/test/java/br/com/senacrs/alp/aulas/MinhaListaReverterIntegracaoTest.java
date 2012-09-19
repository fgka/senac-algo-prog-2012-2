package br.com.senacrs.alp.aulas;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MinhaListaReverterIntegracaoTest {
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMinhaListaReversivel() {
		
		MinhaListaReversivel<Object> obj = null;
	
		try {
			obj = criarMinhaListaReversivel();
		} catch (Exception e) {
			fail("Deve funcionar");
		}
		Assert.assertNotNull(String.valueOf(obj), obj);
	}

	private <T> MinhaListaReversivel<T> criarMinhaListaReversivel() {
		
		MinhaListaReversivel<T> resultado = null;

		//TODO resultado = new MinhaListaReversivelImp<T>();
		
		return resultado;
	}
	
	@Test
	public void testReverterListaVazia() throws Exception {

		MinhaListaReversivel<Object> obj = null;
		
		obj = criarMinhaListaReversivel();
		try {
			obj.reverter();
		} catch (Exception e) {
			fail("Deve funcionar");
		}
		Assert.assertNotNull(String.valueOf(obj), obj);
		Assert.assertEquals(String.valueOf(obj), 0, obj.tamanho());		
	}
	
	@Test
	public void testReverterListaTamanhoUm() throws Exception {

		MinhaListaReversivel<String> obj = null;
		String valor = null;
		
		valor = "elemento";
		obj = criarMinhaListaReversivel();
		obj.prefixar(valor);
		try {
			obj.reverter();
		} catch (Exception e) {
			fail("Deve funcionar");
		}
		Assert.assertEquals(String.valueOf(obj), valor, obj.buscar(0));
		Assert.assertEquals(String.valueOf(obj), 1, obj.tamanho());		
	}
	
	@Test
	public void testReverterListaSimples() throws Exception {

		MinhaListaReversivel<String> obj = null;
		String str = null;
		String valor = null;
		
		str = "elemento_";
		obj = criarMinhaListaReversivel();
		for (int i = 0; i < 10; i++) {
			obj.sufixar(str + i);
		}		
		obj.reverter();
		Assert.assertEquals(String.valueOf(obj), 10, obj.tamanho());		
		for (int i = 0; i < 10; i++) {
			valor = obj.buscar(i);
			Assert.assertEquals(String.valueOf(obj), str + (9 - i), valor);
		}		
	}
	
	@Test
	public void testReverterDuplamente() throws Exception {

		MinhaListaReversivel<String> obj = null;
		String str = null;
		String valor = null;
		
		str = "elemento_";
		obj = criarMinhaListaReversivel();
		for (int i = 0; i < 10; i++) {
			obj.sufixar(str + i);
		}		
		obj.reverter();
		Assert.assertEquals(String.valueOf(obj), 10, obj.tamanho());		
		obj.reverter();
		Assert.assertEquals(String.valueOf(obj), 10, obj.tamanho());		
		for (int i = 0; i < 10; i++) {
			valor = obj.buscar(i);
			Assert.assertEquals(String.valueOf(obj), str + i, valor);
		}		
	}
}
