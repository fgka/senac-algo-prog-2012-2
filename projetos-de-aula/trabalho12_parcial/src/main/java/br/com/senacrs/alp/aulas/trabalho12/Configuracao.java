package br.com.senacrs.alp.aulas.trabalho12;

import java.io.File;

public class Configuracao {

	protected static String PWD = System.getProperty("user.dir") + File.separator;
	private final String rootDir;
	private final int port;
	
	
	public Configuracao(String rootDir, int port) {
		
		validarRootDir(rootDir);
		validarPort(port);
		this.rootDir = rootDir;
		this.port = port;
	}


	private void validarPort(int port) {

		if ((port <= 0) || (port > 65535)) {
			throw new IllegalArgumentException(String.valueOf(port));
		}
		
	}


	private void validarRootDir(String rootDir) {
		
		if (rootDir == null) {
			throw new IllegalArgumentException();
		}
		if(!rootDir.startsWith("./")) {
			throw new IllegalArgumentException(rootDir);
		}
	}


	public String getRootDir() {
		
		return this.rootDir;
	}
	
	public String getRootDirTraduzido() {
		
		String resultado = null;
		String parcial = null;
		
		parcial = this.rootDir.substring(2).replace("/", File.separator);
		resultado = PWD + parcial;
		
		return resultado;
	}
	
	public int getPort() {
		
		return this.port;
	}
	
	@Override
	public String toString() {
		
		String resultado = null;
		
		resultado = this.port + ":" + this.getRootDirTraduzido();
		
		return resultado;
	}	
}
