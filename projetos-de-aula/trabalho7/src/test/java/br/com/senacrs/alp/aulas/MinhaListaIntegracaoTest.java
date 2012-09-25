package br.com.senacrs.alp.aulas;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MinhaListaIntegracaoTest {
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMinhaListaImp() {
		
		MinhaLista<Object> obj = null;
	
		try {
			obj = criarMinhaLista();
		} catch (Exception e) {
			fail("Deve funcionar");
		}
		Assert.assertNotNull(String.valueOf(obj), obj);
	}

	private <T> MinhaLista<T> criarMinhaLista() {
		
		MinhaLista<T> resultado = null;
		
		//TODO resultado = new MinhaListaReversivelImp<T>();
		
		return resultado;
	}

	@Test
	public void testSufixar() {
		
		MinhaLista<String> obj = null;
		String sufixo = null;
		String sufixoReal = null;
		
		obj = criarMinhaLista();
		sufixo = "sufixo";
		obj.sufixar(sufixo);
		sufixoReal = buscarSufixo(obj);
		Assert.assertEquals(String.valueOf(obj), sufixo, sufixoReal);
	}

	private <T> T buscarSufixo(MinhaLista<T> lista) {
		
		T resultado = null;
		int indiceSufixo = 0;
		
		indiceSufixo = lista.tamanho() - 1;
		resultado = lista.buscar(indiceSufixo);
		
		return resultado;
	}

	@Test
	public void testSufixarMuitos() {
		
		MinhaLista<String> obj = null;
		String str = null;
		String valor = null;
				
		obj = criarMinhaLista();
		str = "sufixo_";			
		for (int i = 0; i < 10; i++) {
			valor = str + i;
			obj.sufixar(valor);
		}
		for (int i = 0; i < 10; i++) {
			valor = obj.buscar(i); 
			Assert.assertEquals(String.valueOf(obj), str + i, valor);			
		}
	}

	@Test
	public void testPrefixar() {
				
		MinhaLista<String> obj = null;
		String prefixo = null;
		String prefixoReal = null;
		
		obj = criarMinhaLista();
		prefixo = "prefixo";
		obj.prefixar(prefixo);
		prefixoReal = buscarPrefixo(obj);
		Assert.assertEquals(String.valueOf(obj), prefixo, prefixoReal);
	}

	private <T> T buscarPrefixo(MinhaLista<T> lista) {
		
		T resultado = null;

		resultado = lista.buscar(0);

		return resultado;
	}

	@Test
	public void testPrefixarMuitos() {
		
		MinhaLista<String> obj = null;
		String str = null;
		String valor = null;
				
		obj = criarMinhaLista();
		str = "prefixo_";			
		for (int i = 0; i < 10; i++) {
			valor = str + i;
			obj.prefixar(valor);
		}
		for (int i = 0; i < 10; i++) {
			valor = obj.buscar(9 - i); 
			Assert.assertEquals(String.valueOf(obj), str + i, valor);			
		}
	}

	@Test
	public void testTamanho() {
		
		MinhaLista<String> obj = null;
		int quantidade = 0;
		int tamanho = 0;
		
		obj = criarMinhaLista();
		quantidade = 10;		 
		adicionarElementos(obj, quantidade);
		tamanho = obj.tamanho();
		Assert.assertEquals(String.valueOf(obj), quantidade, tamanho);
	}

	@Test
	public void testTamanhoListaVazia() {
		
		MinhaLista<String> obj = null;
		int tamanho = 0;
		
		obj = criarMinhaLista();
		tamanho = obj.tamanho();
		Assert.assertEquals(String.valueOf(obj), 0, tamanho);
	}

	@SuppressWarnings("unchecked")
	private <T> void adicionarElementos(
			MinhaLista<T> lista, 
			int quantidade) {

		T[] valores = null;

		valores = (T[]) new Object[quantidade];
		for (int i = 0; i < quantidade; i++) {
			valores[i] = null;
		}
		encadearValores(lista, valores);
	}
	
	private <T> void encadearValores(MinhaLista<T> lista, T[] valores) {
				
		for (T valor : valores) {
			lista.sufixar(valor);
		}		
	}

	@Test
	public void testBuscar() {
		
		MinhaLista<String> obj = null;
		int quantidade = 0;
		String esperado = null;
		String resultado = null;
		String prefixo = null;
		
		prefixo = "string-";
		quantidade = 10;		
		obj = criarMinhaListaDeStringComPrefixo(prefixo, quantidade);
		for (int i = 0; i < quantidade; i++) {
			esperado = valorStringPrefixadoParaIndice(prefixo, i);
			resultado = obj.buscar(i);
			Assert.assertEquals(String.valueOf(obj), esperado, resultado);
		}
	}

	private MinhaLista<String> criarMinhaListaDeStringComPrefixo(
			String prefixo, int quantidade) {
		
		MinhaLista<String> resultado = null;
		String[] valores = null;

		resultado = criarMinhaLista();
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
		
		MinhaLista<String> obj = null;
		
		obj = criarMinhaLista();
		try {
			obj.buscar(-1);
			fail(String.valueOf(obj));
		} catch (IndexOutOfBoundsException e) {
			assertTrue(true);
		}
	}

	@Test
	public void testBuscarPosicaoAlemDoTamanho() {
		
		MinhaLista<String> obj = null;
		
		obj = criarMinhaLista();
		try {
			obj.buscar(0);
			fail();
		} catch (IndexOutOfBoundsException e) {
			assertTrue(true);
		}
	}

	@Test
	public void testInserir() {
		
		MinhaLista<String> obj = null;
		String valor = null;
		int posicao = 0;
		String resultado = null;

		obj = criarMinhaListaDeStringComPrefixo("string-", 10);
		valor = "novo valor";
		posicao = 3;
		obj.inserir(posicao, valor);
		resultado = obj.buscar(posicao);
		Assert.assertEquals(String.valueOf(obj), valor, resultado);
	}

	@Test
	public void testInserirNaPrimeiraPosicaoComListaVazia() {
		
		MinhaLista<String> obj = null;
		String valor = null;
		int posicao = 0;
		String resultado = null;

		obj = criarMinhaLista();
		valor = "novo valor";
		posicao = 0;
		obj.inserir(posicao, valor);
		resultado = obj.buscar(posicao);
		Assert.assertEquals(valor, resultado);
	}

	@Test
	public void testInserirNaUltimaPosicao() {
				
		MinhaLista<String> obj = null;
		int quantidade = 0;
		String valor = null;
		int posicao = 0;
		String resultado = null;

		quantidade = 10;
		obj = criarMinhaListaDeStringComPrefixo("string-", quantidade);
		valor = "novo valor";
		posicao = quantidade;
		obj.inserir(posicao, valor);
		resultado = obj.buscar(posicao);
		Assert.assertEquals(valor, resultado);
	}

	@Test
	public void testInserirPosicaoNegativa() {
		
		MinhaLista<String> obj = null;
		String valor = null;
		int posicao = 0;

		obj = criarMinhaListaDeStringComPrefixo("string-", 10);
		valor = "novo valor";
		posicao = -1;
		try {
			obj.inserir(posicao, valor);
			fail(String.valueOf(obj));
		} catch (IndexOutOfBoundsException e) {
			assertTrue(true);
		}
	}

	@Test
	public void testInserirPosicaoAlemDoTamanho() {
		
		MinhaLista<String> obj = null;
		String valor = null;
		int posicao = 0;

		obj = criarMinhaListaDeStringComPrefixo("string-", 10);
		valor = "novo valor";
		posicao = 11;
		try {
			obj.inserir(posicao, valor);
			fail(String.valueOf(obj));
		} catch (IndexOutOfBoundsException e) {
			assertTrue(true);
		}
	}

	@Test
	public void testRemoverDevolveValorCorreto() {
				
		MinhaLista<String> obj = null;
		int quantidade = 0;
		int posicao = 0;
		String esperado = null;
		String resultado = null;
		String prefixo = null;
		
		prefixo = "string-";
		quantidade = 10;
		obj = criarMinhaListaDeStringComPrefixo(prefixo, quantidade);
		posicao = 7;
		esperado = valorStringPrefixadoParaIndice(prefixo, posicao);
		resultado = obj.remover(posicao);		
		Assert.assertEquals(String.valueOf(obj), esperado, resultado);
	}

	@Test
	public void testRemoverValorRemovido() {
				
		MinhaLista<String> obj = null;
		int quantidade = 0;
		int posicao = 0;
		String valor = null;
		String prefixo = null;
		boolean encontrado = false;
		
		prefixo = "string-";
		quantidade = 10;
		obj = criarMinhaListaDeStringComPrefixo(prefixo, quantidade);
		posicao = 7;
		valor = valorStringPrefixadoParaIndice(prefixo, posicao);
		obj.remover(posicao);
		encontrado = existeValorNaLista(obj, valor);
		Assert.assertFalse(String.valueOf(obj), encontrado);
	}

	private <T> boolean existeValorNaLista(MinhaLista<T> lista, T valor) {
		
		boolean resultado = false;
		T valorAtual = null;
		
		for (int i = 0; i < lista.tamanho(); i++) {
			valorAtual = lista.buscar(i);
			if (valor == valorAtual) {
				resultado = true;
				break;
			}
		}

		return resultado;
	}

	@Test
	public void testRemoverPosicaoNegativa() {
				
		MinhaLista<String> obj = null;
		int posicao = 0;

		obj = criarMinhaListaDeStringComPrefixo("string-", 10);
		posicao = -1;
		try {
			obj.remover(posicao);
			fail(String.valueOf(obj));
		} catch (IndexOutOfBoundsException e) {
			assertTrue(true);
		}
	}

	@Test
	public void testRemoverPosicaoAlemDoTamanho() {
				
		MinhaLista<String> obj = null;

		obj = criarMinhaLista();
		try {
			obj.remover(0);
			fail(String.valueOf(obj));
		} catch (IndexOutOfBoundsException e) {
			assertTrue(true);
		}
	}
}
