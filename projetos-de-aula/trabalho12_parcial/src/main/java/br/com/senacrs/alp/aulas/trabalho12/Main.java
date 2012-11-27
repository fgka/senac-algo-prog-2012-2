package br.com.senacrs.alp.aulas.trabalho12;

import java.io.File;
import java.util.Arrays;

public class Main {

	private static String PWD = System.getProperty("user.dir");

	public static void main(String[] args) {

		String saida = null;
		try {
			saida = meuMain(args);
		} catch (Exception e) {
			saida = "ERRO";
		}
		System.out.println(saida);
	}

	private static String meuMain(String[] args) {
		
		String saida = null;
		String arquivoConf = null;
		String arquivoReq = null;
		Configuracao conf = null;

		arquivoConf = obterNomeArquivo(args, 0);
		conf = criarConfiguracao(arquivoConf);
		validarRootDir(conf.getRootDirTraduzido());
		arquivoReq = obterNomeArquivo(args, 1);
		saida = conf.toString();
		return saida;
	}

	private static void validarRootDir(String rootDirTraduzido) {

		File rootDir = null;
		
		rootDir = new File(rootDirTraduzido);
		if (!rootDir.exists() || !rootDir.isDirectory()) {
			throw new IllegalArgumentException(rootDirTraduzido);
		}
	}

	private static Configuracao criarConfiguracao(String nomeArquivo) {

		Configuracao resultado = null;
		EmissorMensagens msg = null;
		String rootDir = null;
		String port = null;
		int portInt = 0;

		msg = new EmissorMensagens(nomeArquivo);
		rootDir = msg.buscarMensagem("root_dir");
		port = msg.buscarMensagem("port");
		portInt = Integer.valueOf(port).intValue();
		resultado = new Configuracao(rootDir, portInt);

		return resultado;
	}

	private static String obterNomeArquivo(String[] args, int indice) {

		String resultado = null;

		if (args.length > indice) {
			throw new IllegalArgumentException(Arrays.toString(args));
		}
		resultado = PWD + File.separator + args[0];

		return resultado;
	}
}
