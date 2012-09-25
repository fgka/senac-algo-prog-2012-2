package br.com.senacrs.alp.aulas.trabalho5;

import java.util.LinkedList;
import java.util.List;

import br.com.senacrs.alp.aulas.MinhaLista;

public class MinhaListaListImp<Tipo> implements MinhaLista<Tipo> {

	private List<Tipo> lista = new LinkedList<Tipo>();
	
	@Override
	public void sufixar(Tipo valor) {
		
		lista.add(valor);
	}

	@Override
	public void prefixar(Tipo valor) {
		
		lista.add(0, valor);
	}

	@Override
	public Tipo buscar(int posicao) {

		return lista.get(posicao);		
	}

	@Override
	public void inserir(int posicao, Tipo valor) {
		
		lista.add(posicao, valor);
	}

	@Override
	public Tipo remover(int posicao) {

		return lista.remove(posicao);
	}

	@Override
	public int tamanho() {
		
		return lista.size();
	}
	
	

}
