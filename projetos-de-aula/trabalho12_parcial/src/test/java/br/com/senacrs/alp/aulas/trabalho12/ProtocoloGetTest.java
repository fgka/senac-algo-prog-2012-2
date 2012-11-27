package br.com.senacrs.alp.aulas.trabalho12;

import org.junit.Assert;
import org.junit.Test;


public class ProtocoloGetTest {

	protected static final String GET_HTTP_1_1 = "GET / http/1.1";
	protected static final String HOST_WWW_EXAMPLE_COM = "Host: www.example.com";

	@Test
	public void testProtocoloGetLinhaGetNull() {
		
		ProtocoloGet obj = null;
		
		try {
			obj = new ProtocoloGet(null, HOST_WWW_EXAMPLE_COM);
			Assert.fail(String.valueOf(obj));
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
		}
	}

	@Test
	public void testProtocoloGetLinhaGetSemGet() {
		
		ProtocoloGet obj = null;
		
		try {
			obj = new ProtocoloGet("/ http/1.1", HOST_WWW_EXAMPLE_COM);
			Assert.fail(String.valueOf(obj));
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
		}
	}

	@Test
	public void testProtocoloGetLinhaGetGetErrado() {
		
		ProtocoloGet obj = null;
		
		try {
			obj = new ProtocoloGet("POST / http/1.1", HOST_WWW_EXAMPLE_COM);
			Assert.fail(String.valueOf(obj));
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
		}
	}

	@Test
	public void testProtocoloGetLinhaGetSemHttp() {
		
		ProtocoloGet obj = null;
		
		try {
			obj = new ProtocoloGet("GET /", HOST_WWW_EXAMPLE_COM);
			Assert.fail(String.valueOf(obj));
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
		}
	}

	@Test
	public void testProtocoloGetLinhaGetHttpErrado() {
		
		ProtocoloGet obj = null;
		
		try {
			obj = new ProtocoloGet("GET / ftp/1.1", HOST_WWW_EXAMPLE_COM);
			Assert.fail(String.valueOf(obj));
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
		}
	}

	@Test
	public void testProtocoloGetLinhaGetSemCaminho() {
		
		ProtocoloGet obj = null;
		
		try {
			obj = new ProtocoloGet("GET  http/1.1", HOST_WWW_EXAMPLE_COM);
			Assert.fail(String.valueOf(obj));
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
		}
	}

	@Test
	public void testProtocoloGetLinhaGetCaminhoErrado() {
		
		ProtocoloGet obj = null;
		
		try {
			obj = new ProtocoloGet("GET caminho http/1.1", HOST_WWW_EXAMPLE_COM);
			Assert.fail(String.valueOf(obj));
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
		}
	}
	
	@Test
	public void testProtocoloGetLinhaHostNull() {
		
		ProtocoloGet obj = null;
		
		try {
			obj = new ProtocoloGet(GET_HTTP_1_1, null);
			Assert.fail(String.valueOf(obj));
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
		}
	}

	@Test
	public void testProtocoloGetLinhaHostSemHost() {
		
		ProtocoloGet obj = null;
		
		try {
			obj = new ProtocoloGet(GET_HTTP_1_1, "alguma_coisa");
			Assert.fail(String.valueOf(obj));
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
		}
	}

	@Test
	public void testProtocoloGetLinhaHostSemComplemento() {
		
		ProtocoloGet obj = null;
		
		try {
			obj = new ProtocoloGet(GET_HTTP_1_1, "Host: ");
			Assert.fail(String.valueOf(obj));
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
		}
	}

	@Test
	public void testProtocoloGetLinhaHostErrado() {
		
		ProtocoloGet obj = null;
		
		try {
			obj = new ProtocoloGet(GET_HTTP_1_1, "NaoHost: algumacoisa");
			Assert.fail(String.valueOf(obj));
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
		}
	}

	@Test
	public void testGetCaminho() {
		
		ProtocoloGet obj = null;
		String caminho = null;
		String linhaGet = null;
		String retornado = null;
		
		caminho = "/caminho";
		linhaGet = ProtocoloGet.GET + " " 
				+ caminho + " " 
				+ ProtocoloGet.HTTP_1_1;
		obj = new ProtocoloGet(linhaGet, HOST_WWW_EXAMPLE_COM);
		retornado = obj.getCaminho();
		Assert.assertEquals(caminho, retornado);
	}
}
