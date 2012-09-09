package br.com.senacrs.alp.aulas;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MinhaPilhaImpTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAbstractMinhaPilha() {
		
		MinhaPilhaImp<Object> obj = null;
		
		try {
			obj = new MinhaPilhaImp<Object>();
			Assert.assertNotNull(obj);
		} catch (Exception e) {
			fail("Não deveria lançar exceção");
		}
	}

	@Test
	public void testPush() {
		fail("Not yet implemented");
	}

	@Test
	public void testPop() {
		fail("Not yet implemented");
	}

}
