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

	private <T> T buscarSufixo(MinhaListaImp<T> lista) {
		
		T resultado = null;
		Nodo<T> nodoSufixo = null;
		
		nodoSufixo = buscarNodoSufixo(lista);
		resultado = nodoSufixo.getValor();
		
		return resultado;
	}

	private <T> Nodo<T> buscarNodoSufixo(MinhaListaImp<T> lista) {
		
		Nodo<T> nodo = null;

		nodo = lista.getInicio();
		while (nodo.getProximo() != null) {
			nodo = nodo.getProximo();
		}
		
		return nodo;
	}

	@Test
	public void testPrefixar() {
				
		MinhaListaImp<String> obj = null;
		String prefixo = null;
		String prefixoReal = null;
		
		obj = criarMinhaListaImp();
		prefixo = "prefixo";
		obj.prefixar(prefixo);
		prefixoReal = buscarPrefixo(obj);
		Assert.assertEquals(prefixo, prefixoReal);
	}

	private <T> T buscarPrefixo(MinhaListaImp<T> lista) {
		
		T resultado = null;
		Nodo<T> nodo = null;
		
		nodo = lista.getInicio();
		nodo = nodo.getProximo();
		resultado = nodo.getValor();

		return resultado;
	}

	@Test
	public void testTamanho() {
		
		MinhaListaImp<String> obj = null;
		int quantidade = 0;
		int tamanho = 0;
		
		obj = criarMinhaListaImp();
		quantidade = 10;		 
		adicionarElementos(obj, quantidade);
		tamanho = obj.tamanho();
		Assert.assertEquals(quantidade, tamanho);
	}

	@Test
	public void testTamanhoListaVazia() {
		
		MinhaListaImp<String> obj = null;
		int tamanho = 0;
		
		obj = criarMinhaListaImp();
		tamanho = obj.tamanho();
		Assert.assertEquals(0, tamanho);
	}

	@SuppressWarnings("unchecked")
	private <T> void adicionarElementos(
			MinhaListaImp<T> lista, 
			int quantidade) {

		T[] valores = null;

		valores = (T[]) new Object[quantidade];
		for (int i = 0; i < quantidade; i++) {
			valores[i] = null;
		}
		encadearValores(lista, valores);
	}
	
	private <T> void encadearValores(MinhaListaImp<T> lista, T[] valores) {
				
		Nodo<T> ultimoNodo = null;
		Nodo<T> novoNodo = null;
		
		ultimoNodo = buscarNodoSufixo(lista);
		for (T valor : valores) {
			novoNodo = new Nodo<T>(valor);
			ultimoNodo.setProximo(novoNodo);
			ultimoNodo = novoNodo;
		}		
	}

	@Test
	public void testBuscar() {
		
		MinhaListaImp<String> obj = null;
		int quantidade = 0;
		String esperado = null;
		String resultado = null;
		String prefixo = null;
		
		prefixo = "string-";
		quantidade = 10;		
		obj = criarMinhaListaImpDeStringComPrefixo(prefixo, quantidade);
		for (int i = 0; i < quantidade; i++) {
			esperado = valorStringPrefixadoParaIndice(prefixo, i);
			resultado = obj.buscar(i);
			Assert.assertEquals(esperado, resultado);
		}
	}

	private MinhaListaImp<String> criarMinhaListaImpDeStringComPrefixo(
			String prefixo, int quantidade) {
		
		MinhaListaImp<String> resultado = null;
		String[] valores = null;

		resultado = criarMinhaListaImp();
		valores = new String[quantidade]; 
		for (int i = 0; i < quantidade; i++) {
			valores[i] = valorStringPrefixadoParaIndice(prefixo, i);
		}
		encadearValores(resultado, valores);

		return resultado;
	}

	private String valorStringPrefixadoParaIndice(String prefixo, int indice) {
		
		String resultado = null;
		
		resultado = prefixo + String.valueOf(indice);
		
		return resultado;
	}

	@Test
	public void testBuscarPosicaoNegativa() {
		
		MinhaListaImp<String> obj = null;
		
		obj = criarMinhaListaImp();
		try {
			obj.buscar(-1);
			fail();
		} catch (IndexOutOfBoundsException e) {
			assertTrue(true);
		}
	}

	@Test
	public void testBuscarPosicaoAlemDoTamanho() {
		
		MinhaListaImp<String> obj = null;
		
		obj = criarMinhaListaImp();
		try {
			obj.buscar(0);
			fail();
		} catch (IndexOutOfBoundsException e) {
			assertTrue(true);
		}
	}

	@Test
	public void testInserir() {
		
		MinhaListaImp<String> obj = null;
		String valor = null;
		int posicao = 0;
		String resultado = null;

		obj = criarMinhaListaImpDeStringComPrefixo("string-", 10);
		valor = "novo valor";
		posicao = 3;
		obj.inserir(posicao, valor);
		resultado = buscarValorEmPosicao(obj, posicao);
		Assert.assertEquals(valor, resultado);
	}

	private String buscarValorEmPosicao(MinhaListaImp<String> lista, int posicao) {
		
		String resultado = null;
		Nodo<String> nodo = null;

		nodo = lista.getInicio();
		for (int i = 0; i <= posicao; i++) {
			nodo = nodo.getProximo();
		}
		resultado = nodo.getValor();
		
		return resultado;
	}

	@Test
	public void testInserirNaPrimeiraPosicaoComListaVazia() {
		
		MinhaListaImp<String> obj = null;
		String valor = null;
		int posicao = 0;
		String resultado = null;

		obj = criarMinhaListaImp();
		valor = "novo valor";
		posicao = 0;
		obj.inserir(posicao, valor);
		resultado = buscarValorEmPosicao(obj, posicao);
		Assert.assertEquals(valor, resultado);
	}

	@Test
	public void testInserirNaUltimaPosicao() {
				
		MinhaListaImp<String> obj = null;
		int quantidade = 0;
		String valor = null;
		int posicao = 0;
		String resultado = null;

		quantidade = 10;
		obj = criarMinhaListaImpDeStringComPrefixo("string-", quantidade);
		valor = "novo valor";
		posicao = quantidade;
		obj.inserir(posicao, valor);
		resultado = buscarValorEmPosicao(obj, posicao);
		Assert.assertEquals(valor, resultado);
	}

	@Test
	public void testInserirPosicaoNegativa() {
		
		MinhaListaImp<String> obj = null;
		String valor = null;
		int posicao = 0;

		obj = criarMinhaListaImpDeStringComPrefixo("string-", 10);
		valor = "novo valor";
		posicao = -1;
		try {
			obj.inserir(posicao, valor);
			fail();
		} catch (IndexOutOfBoundsException e) {
			assertTrue(true);
		}
	}

	@Test
	public void testRemoverDevolveValorCorreto() {
				
		MinhaListaImp<String> obj = null;
		int quantidade = 0;
		int posicao = 0;
		String esperado = null;
		String resultado = null;
		String prefixo = null;
		
		prefixo = "string-";
		quantidade = 10;
		obj = criarMinhaListaImpDeStringComPrefixo(prefixo, quantidade);
		posicao = 7;
		esperado = valorStringPrefixadoParaIndice(prefixo, posicao);
		resultado = obj.remover(posicao);		
		Assert.assertEquals(esperado, resultado);
	}

	@Test
	public void testRemoverValorRemovido() {
				
		MinhaListaImp<String> obj = null;
		int quantidade = 0;
		int posicao = 0;
		String valor = null;
		String prefixo = null;
		boolean encontrado = false;
		
		prefixo = "string-";
		quantidade = 10;
		obj = criarMinhaListaImpDeStringComPrefixo(prefixo, quantidade);
		posicao = 7;
		valor = valorStringPrefixadoParaIndice(prefixo, posicao);
		obj.remover(posicao);
		encontrado = existeValorNaLista(obj, valor);
		Assert.assertFalse(encontrado);
	}

	private <T> boolean existeValorNaLista(MinhaListaImp<T> lista, T valor) {
		
		boolean resultado = false;
		Nodo<T> nodo = null;
		
		nodo = lista.getInicio();
		while (!resultado && (nodo.getProximo() != null)) {
			resultado = valor.equals(nodo.getValor());
			nodo = nodo.getProximo();
		}

		return resultado;
	}

	@Test
	public void testRemoverPosicaoNegativa() {
				
		MinhaListaImp<String> obj = null;
		int posicao = 0;

		obj = criarMinhaListaImpDeStringComPrefixo("string-", 10);
		posicao = -1;
		try {
			obj.remover(posicao);
			fail();
		} catch (IndexOutOfBoundsException e) {
			assertTrue(true);
		}
	}
}
