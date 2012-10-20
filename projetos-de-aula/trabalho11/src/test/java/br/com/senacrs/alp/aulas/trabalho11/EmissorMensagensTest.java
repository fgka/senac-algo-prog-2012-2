package br.com.senacrs.alp.aulas.trabalho11;

import static org.junit.Assert.fail;

import java.io.File;
import java.util.Arrays;

import junit.framework.Assert;

import org.junit.Test;

public class EmissorMensagensTest {

	private final static String DIRETORIO_ENTRADA = System
			.getProperty("user.dir")
			+ File.separatorChar
			+ "mensagens"
			+ File.separatorChar;
	private final static String NOME_ARQUIVO_EN = "mensagens_en.txt";
	private final static String NOME_ARQUIVO_PT = "mensagens_en.txt";
	private final static String ARQUIVO_EN = DIRETORIO_ENTRADA
			+ NOME_ARQUIVO_EN;
	private final static String ARQUIVO_PT = DIRETORIO_ENTRADA
			+ NOME_ARQUIVO_PT;
	private final static String NOME_FULANO = "Fulano";
	private final static String NOME_MODULO = "Modulo";
	private final static Integer[] HORA_MINUTO = new Integer[] {10, 11};
	private final static String[] RESULTADOS_PT = new String[]{
		"Bom dia " + NOME_FULANO,
		"Ocorreu um erro no módulo " + NOME_MODULO + " às " + HORA_MINUTO[0] + ":" + HORA_MINUTO[1], 
	};
	private final static String[] RESULTADOS_EN = new String[]{
		"Good morning " + NOME_FULANO,
		"An error on module " + NOME_MODULO + " had happened at " + HORA_MINUTO[0] + ":" + HORA_MINUTO[1], 
	};	
	
	private enum ChavesEnum {
		
		BOM_DIA("mensagem_bom_dia"),
		ERRO("mensagem_erro"),
		INEXISTENTE("mensagem_inexistente"),
		;
		
		private final String chave;
		
		private ChavesEnum(String chave) {
			
			this.chave = chave;
		}
		
		public String getChave() {
			
			return this.chave;
		}
		
		public static ChavesEnum valorDe(String valor) {
			
			ChavesEnum resultado = null;
			
			for (ChavesEnum c : ChavesEnum.values()) {
				if (c.getChave().equals(valor)) {
					resultado = c;
					break;
				}
			}
			
			return resultado;
		}
	}

	@Test
	public void testEmissorMensagensNull() {

		try {
			criarEmissorMensagens(null);
			fail("Deveria ter abortado");
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
		}
	}

	private EmissorMensagens criarEmissorMensagens(String arquivo) {

		return new EmissorMensagens(arquivo);
	}

	@Test
	public void testEmissorMensagensDiretorio() {

		try {
			criarEmissorMensagens(DIRETORIO_ENTRADA);
			fail("Deveria ter abortado");
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
		}
	}

	@Test
	public void testEmissorMensagensInexistente() {

		try {
			criarEmissorMensagens(NOME_ARQUIVO_PT + ".nao_existe");
			fail("Deveria ter abortado");
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
		}
	}

	@Test
	public void testFormatarMensagemChaveInexistente() {
		
		EmissorMensagens obj = null;	

		obj = criarEmissorMensagens(ARQUIVO_PT);
		try {
			obj.formatarMensagem(ChavesEnum.INEXISTENTE.getChave());
			fail("Deveria ter abortado");
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
		}
	}

	@Test
	public void testFormatarMensagemPt() {
		
		String[] resultado = null;
		String[] esperado = null;
		EmissorMensagens obj = null;
		String msg = null;
		
		obj = criarEmissorMensagens(ARQUIVO_PT);
		resultado = new String[2];
		resultado[0] = obj.formatarMensagem(ChavesEnum.BOM_DIA.getChave(), NOME_FULANO);
		resultado[1] = obj.formatarMensagem(ChavesEnum.ERRO.getChave(), NOME_MODULO, HORA_MINUTO[0], HORA_MINUTO[1]);
		esperado = RESULTADOS_PT;
		msg = "Esperado: " + Arrays.toString(esperado);
		msg += " Resultado: " + Arrays.toString(resultado);
		Assert.assertTrue(msg, Arrays.deepEquals(esperado, resultado));
	}

	@Test
	public void testFormatarMensagemEn() {
		
		String[] resultado = null;
		String[] esperado = null;
		EmissorMensagens obj = null;
		String msg = null;
		
		obj = criarEmissorMensagens(ARQUIVO_EN);
		resultado = new String[2];
		resultado[0] = obj.formatarMensagem(ChavesEnum.BOM_DIA.getChave(), NOME_FULANO);
		resultado[1] = obj.formatarMensagem(ChavesEnum.ERRO.getChave(), NOME_MODULO, HORA_MINUTO[0], HORA_MINUTO[1]);
		esperado = RESULTADOS_EN;
		msg = "Esperado: " + Arrays.toString(esperado);
		msg += " Resultado: " + Arrays.toString(resultado);
		Assert.assertTrue(msg, Arrays.deepEquals(esperado, resultado));
	}
}
