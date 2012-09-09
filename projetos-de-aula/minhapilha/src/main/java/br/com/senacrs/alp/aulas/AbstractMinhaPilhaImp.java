package br.com.senacrs.alp.aulas;

import java.util.EmptyStackException;

public abstract class AbstractMinhaPilhaImp<T> implements MinhaPilha<T> {

	protected AbstractMinhaPilhaImp() {

		super();
	}

	public void push(T valor) {
		
		MinhaLista<T> lista = null;
		
		lista = this.getMinhaLista();
		lista.prefixar(valor);
	}

	protected abstract MinhaLista<T> getMinhaLista();
	
	public T pop() {

		T resultado = null;
		
		MinhaLista<T> lista = null;
		
		lista = this.getMinhaLista();
		try {
			resultado = lista.remover(0);
		} catch (IndexOutOfBoundsException e) {
			throw new EmptyStackException();
		}

		return resultado;
	}

}
