package br.com.senacrs.alp.aulas;

public class Nodo<Tipo extends Object> {

	private Tipo valor;
	private Nodo<Tipo> proximo = null;
	
	public Nodo(Tipo valor) {

		this.valor = valor;
	}
	public Tipo getValor() {
		return valor;
	}
	public void setValor(Tipo valor) {
		this.valor = valor;
	}
	public Nodo<Tipo> getProximo() {
		return proximo;
	}
	public void setProximo(Nodo<Tipo> proximo) {
		this.proximo = proximo;
	}
	
	
}
