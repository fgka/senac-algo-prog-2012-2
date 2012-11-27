package br.com.senacrs.alp.aulas.trabalho12;


public class ProtocoloGet {

	protected static final String HTTP_1_1 = "http/1.1";
	protected static final String GET = "GET";
	protected static final String HOST = "Host: ";
	private final String caminho;

	public ProtocoloGet(String linhaGet, String linhaHost) {
		
		validarHost(linhaHost);
		this.caminho = validarGet(linhaGet);
	}
	
	public String getCaminho() {
		
		return this.caminho;
	}

	private String validarGet(String linhaGet) {
		
		String partes[] = null;
		String get = null;
		String caminho = null;
		String http = null;

		if (linhaGet == null) {
			throw new IllegalArgumentException();
		}
		partes = linhaGet.split(" ");
		if (partes.length != 3) {
			throw new IllegalArgumentException(linhaGet);
		}
		get = partes[0];
		validarPrefixoGet(get);
		caminho = partes[1];
		validarCaminho(caminho);
		http = partes[2];
		validarSufixo(http);
		
		return caminho;
	}

	private void validarSufixo(String http) {
		
		if (!HTTP_1_1.equalsIgnoreCase(http)) {
			throw new IllegalArgumentException(http);			
		}
	}

	private void validarCaminho(String caminho) {
		
		if (!caminho.startsWith("/")) {
			throw new IllegalArgumentException(caminho);			
		}
		
	}

	private void validarPrefixoGet(String get) {
		
		if (!GET.equalsIgnoreCase(get)) {
			throw new IllegalArgumentException(get);			
		}		
	}

	private void validarHost(String linhaHost) {
		
		if (linhaHost == null) {
			throw new IllegalArgumentException();
		}
		if (!linhaHost.toLowerCase().startsWith(HOST.toLowerCase())) {
			throw new IllegalArgumentException(linhaHost);			
		}
		if (linhaHost.trim().length() <= HOST.length()) {
			throw new IllegalArgumentException(linhaHost);						
		}
	}
}
