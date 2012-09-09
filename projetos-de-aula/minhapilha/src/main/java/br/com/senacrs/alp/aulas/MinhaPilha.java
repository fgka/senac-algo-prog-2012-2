package br.com.senacrs.alp.aulas;

public interface MinhaPilha<T> {
	
	void push(T valor);
	
	T pop();
}
