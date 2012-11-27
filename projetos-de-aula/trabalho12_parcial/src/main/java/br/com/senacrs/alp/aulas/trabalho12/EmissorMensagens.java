package br.com.senacrs.alp.aulas.trabalho12;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class EmissorMensagens {
		
	private Map<String, String> map = null;
	
	public EmissorMensagens(String nomeArquivo) {
	
		if (nomeArquivo == null) {
			throw new IllegalArgumentException();
		}
		popularMapa(nomeArquivo);
	}

	private void popularMapa(String nomeArquivo) {
		
		BufferedReader arquivo = null;
		try {
			arquivo = abrirArquivo(nomeArquivo);
			this.map = lerArquivo(arquivo);
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		} finally {
			fecharArquivo(arquivo);
		}
	}

	private void fecharArquivo(BufferedReader arquivo) {
		
		if (arquivo != null) {
			try {
				arquivo.close();
			} catch (IOException e) {
				throw new IllegalArgumentException(e);
			}
		}
	}

	private BufferedReader abrirArquivo(String nomeArquivo) throws FileNotFoundException {
		
		BufferedReader resultado = null;
		File file = null;
		
		file = new File(nomeArquivo);
		if (!file.exists() || !file.isFile()) {
			throw new IllegalArgumentException();
		}
		resultado = new BufferedReader(new FileReader(file));

		return resultado;
	}

	private Map<String, String> lerArquivo(BufferedReader arquivo) throws IOException {
		
		Map<String, String> resultado = null;
		String line = null;
		String[] chaveConteudo = null;
		String chave = null;
		String conteudo = null;
		
		resultado = new HashMap<String, String>();
		line = arquivo.readLine();
		while (line != null) {
			chaveConteudo = obterChaveConteudo(line);
			chave = chaveConteudo[0].trim();
			conteudo = chaveConteudo[1].trim();
			resultado.put(chave, conteudo);
			line = arquivo.readLine();
		}
		
		return resultado;
	}

	private String[] obterChaveConteudo(String line) {
		
		String[] resultado = null;
		
		resultado = line.split("=");
		if (resultado.length != 2) {
			throw new IllegalArgumentException();
		}
		
		return resultado;
	}

	public String formatarMensagem(String chave, Object... argumentos) {

		String resultado = null;
		String conteudo = null;
		
		conteudo = this.map.get(chave);
		if (conteudo == null) {
			throw new IllegalArgumentException();
		}
		resultado = formatarConteudo(conteudo, argumentos);
		
		return resultado;
	}
	
	public String buscarMensagem(String chave) {
		
		return formatarMensagem(chave);
	}

	private String formatarConteudo(String conteudo, Object[] argumentos) {
		
		String resultado = null;
		
		resultado = String.format(conteudo, argumentos);

		return resultado;
	}
}
