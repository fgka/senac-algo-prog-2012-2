package br.com.senacrs.alp.aulas.trabalho12;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import org.junit.Assert;
import org.junit.Test;

public class LeitorRequisicaoTest {
	
	private static String NL = System.getProperty("line.separator");
	private static String GET = ProtocoloGetTest.GET_HTTP_1_1 
			+ NL + ProtocoloGetTest.HOST_WWW_EXAMPLE_COM;
	private static StringReader GET_READER = new StringReader(GET); 

	@Test
	public void testLeitorRequisicaoNull() {
		
		try {
			new LeitorRequisicao(null);
			Assert.fail();
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
		}
	}

	@Test
	public void testLerRequisicao() throws IOException {
		
		LeitorRequisicao obj = null;
		Reader in = null;
		ProtocoloGet pGet = null;

		in = GET_READER;
		obj = new LeitorRequisicao(in);
		pGet = obj.lerRequisicao();
		Assert.assertNotNull(pGet);
	}
}
