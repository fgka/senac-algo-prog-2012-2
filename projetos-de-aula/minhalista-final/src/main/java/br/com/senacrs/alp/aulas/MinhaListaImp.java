package br.com.senacrs.alp.aulas;

public class MinhaListaImp<Tipo> implements MinhaLista<Tipo> {
	
	private Nodo<Tipo> inicio = null;
	
	public MinhaListaImp() {
		
		this.inicio = new Nodo<Tipo>(null);
	}

	protected Nodo<Tipo> getInicio() {
		return inicio;
	}


	public void sufixar(Tipo valor) {

		Nodo<Tipo> ultimo = buscarUltimoNodo();
		Nodo<Tipo> novoUltimo = new Nodo<Tipo>(valor);
		
		ultimo.setProximo(novoUltimo);
	}


	private Nodo<Tipo> buscarUltimoNodo() {
		
		int tamanho = tamanho();
		Nodo<Tipo> resultado = buscarNodo(tamanho - 1);
		
		return resultado;
	}


	private Nodo<Tipo> buscarNodo(int posicao) {
		
		Nodo<Tipo> resultado = getInicio();
		
		for (int i = 0; i < posicao; i++) {
			resultado = resultado.getProximo();
		}
				
		return resultado;
	}

	public void prefixar(Tipo valor) {
		
		Nodo<Tipo> inicio = null;
		Nodo<Tipo> primeiro = null;
		Nodo<Tipo> novoPrimeiro = null;
		
		inicio = this.inicio;
		primeiro = inicio.getProximo();
		novoPrimeiro = new Nodo<Tipo>(valor);		
		novoPrimeiro.setProximo(primeiro);
		inicio.setProximo(novoPrimeiro);
	}

	public Tipo buscar(int posicao) {
		
		Nodo<Tipo> nodo = null;
		
		verificarPosicao(posicao);
		nodo = buscarNodo(posicao + 1);
		
		return nodo.getValor();
	}

	private void verificarPosicao(int posicao) {

		if (posicao < 0) {
			throw new IndexOutOfBoundsException();
		}
	}

	public void inserir(int posicao, Tipo valor) {

		Nodo<Tipo> anterior = null;
		Nodo<Tipo> proximo = null;
		Nodo<Tipo> nodo = null;
		
		verificarPosicao(posicao);
		anterior = buscarNodo(posicao);
		proximo = anterior.getProximo();
		nodo = new Nodo<Tipo>(valor);
		anterior.setProximo(nodo);
		nodo.setProximo(proximo);		
	}

	public Tipo remover(int posicao) {
		
		Nodo<Tipo> anterior = null;
		Nodo<Tipo> nodo = null;
		Nodo<Tipo> proximo = null;
		
		verificarPosicao(posicao);
		anterior = buscarNodo(posicao);
		nodo = anterior.getProximo();
		proximo = nodo.getProximo();
		anterior.setProximo(proximo);
		
		return nodo.getValor();
	}

	public int tamanho() {
		
		Nodo<Tipo> nodo = getInicio();
		int resultado = 0;

		while (nodo.getProximo() != null) {
			nodo = nodo.getProximo();
			resultado++;
		}
		
		return resultado;
	}

}
