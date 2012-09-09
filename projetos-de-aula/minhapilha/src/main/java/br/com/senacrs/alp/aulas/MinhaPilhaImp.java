package br.com.senacrs.alp.aulas;

import java.util.EmptyStackException;

public abstract class MinhaPilhaImp<T> implements MinhaPilha<T> {

	private MinhaLista<T> lista = null;

	protected MinhaPilhaImp() {

		super();

		lista = new MinhaListaImp<T>();
	}

	public void push(T valor) {

		this.lista.prefixar(valor);
	}

	protected MinhaLista<T> getMinhaLista() {

		return this.lista;
	}

	public T pop() {

		T resultado = null;

		try {
			resultado = this.lista.remover(0);
		} catch (IndexOutOfBoundsException e) {
			throw new EmptyStackException();
		}

		return resultado;
	}

}
