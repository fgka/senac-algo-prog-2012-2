package br.com.senacrs.alp.aulas.trabalho12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

public class LeitorRequisicao {
	
	private final BufferedReader entrada;

	public LeitorRequisicao(Reader in) {
		
		if (in == null) {
			throw new IllegalArgumentException();
		}
		this.entrada = new BufferedReader(in);
	}
	
	public ProtocoloGet lerRequisicao() throws IOException {
		
		ProtocoloGet resultado = null;
		String linhaGet = null;
		String linhaHost = null;
		
		linhaGet = lerLinha();
		linhaHost = lerLinha();
		resultado = new ProtocoloGet(linhaGet, linhaHost);
		
		return resultado;
	}

	private String lerLinha() throws IOException {
		
		String resultado = null;

		resultado = this.entrada.readLine();
		
		return resultado;
	}
}
