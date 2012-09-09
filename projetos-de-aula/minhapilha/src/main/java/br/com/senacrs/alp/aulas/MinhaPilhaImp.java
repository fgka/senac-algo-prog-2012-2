package br.com.senacrs.alp.aulas;

public class MinhaPilhaImp<T> extends AbstractMinhaPilha<T> {
	
	private MinhaLista<T> lista = null;
	
	public MinhaPilhaImp() {

		super();
		
		this.lista = new MinhaListaImp<T>();
	}

	@Override
	protected MinhaLista<T> getMinhaLista() {

		return this.lista;
	}

}
