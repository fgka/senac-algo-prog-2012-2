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
		Nodo<T> nodoSufixo = null;
		
		nodoSufixo = buscarNodoSufixo(obj);
		resultado = nodoSufixo.getValor();
		
		return resultado;
	}

	private <T> Nodo<T> buscarNodoSufixo(MinhaListaImp<T> obj) {
		
		Nodo<T> nodo = null;

		nodo = obj.getInicio();
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

	private <T> T buscarPrefixo(MinhaListaImp<T> obj) {
		
		T resultado = null;
		Nodo<T> nodo = null;
		
		nodo = obj.getInicio();
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

	@SuppressWarnings("unchecked")
	private <T> void adicionarElementos(
			MinhaListaImp<T> obj, 
			int quantidade) {

		T[] valores = null;

		valores = (T[]) new Object[quantidade];
		for (int i = 0; i < quantidade; i++) {
			valores[i] = null;
		}
		encadearValores(obj, valores);
	}
	
	private <T> void encadearValores(MinhaListaImp<T> obj, T[] valores) {
				
		Nodo<T> ultimoNodo = null;
		Nodo<T> novoNodo = null;
		
		ultimoNodo = buscarNodoSufixo(obj);
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

	private String buscarValorEmPosicao(MinhaListaImp<String> obj, int posicao) {
		
		String resultado = null;
		Nodo<String> nodo = null;

		nodo = obj.getInicio();
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
	public void testRemover() {
		fail("Not yet implemented");
	}
}
