package br.com.senacrs.alp.aulas.trabalho13;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ListaDiretorioTest {

	private static final String PWD = System.getProperty("user.dir");
	private static final String TEST_DIR = "raiz";
	private static final String FULL_TEST_DIR = PWD + File.separator + TEST_DIR;
	private static final String FULL_TEST_FILE = FULL_TEST_DIR + File.separator
			+ "arq2.txt";
	private static File TEST_DIR_EMPTY_FILE = null;
	private static String FULL_TEST_DIR_EMPTY = null;

	private static final String[] EXPECTED = new String[] {
			"list: " + FULL_TEST_DIR, 
			"total: " + Integer.valueOf(6),
			"d algumdir1", 
			"d dir2", 
			"d dir3", 
			"a algumarq1.txt",
			"a arq2.txt", 
			"a arq3.txt", 
			};

	private static final String[] EXPECTED_EMPTY = new String[] {
			"list: ", 
			"total: " + Integer.valueOf(0), 
			};

	private ListaDiretorio obj = null;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		TEST_DIR_EMPTY_FILE = createTempDirectory();
		FULL_TEST_DIR_EMPTY = TEST_DIR_EMPTY_FILE.getAbsolutePath();
		EXPECTED_EMPTY[0] += FULL_TEST_DIR_EMPTY;
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {

		TEST_DIR_EMPTY_FILE = null;
		FULL_TEST_DIR_EMPTY = null;
	}

	@Before
	public void setUp() throws Exception {

		this.obj = new ListaDiretorio();
	}

	@After
	public void tearDown() throws Exception {

		this.obj = null;
	}

	@Test
	public void testListaConteudoDiretorioNull() {

		try {
			this.obj.listaConteudoDiretorio(null);
			Assert.fail();
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
		}
	}

	@Test
	public void testListaConteudoDiretorioNotExist() {

		try {
			this.obj.listaConteudoDiretorio(FULL_TEST_DIR + "asdf");
			Assert.fail();
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
		}
	}

	@Test
	public void testListaConteudoDiretorioFile() {

		try {
			this.obj.listaConteudoDiretorio(FULL_TEST_FILE);
			Assert.fail();
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
		}
	}

	@Test
	public void testListaConteudoDiretorioEmpty() {

		String[] result = null;
		String msg = null;

		result = this.obj.listaConteudoDiretorio(FULL_TEST_DIR_EMPTY);
		msg = Arrays.toString(result);
		Assert.assertArrayEquals(msg, EXPECTED_EMPTY, result);
	}

	@Test
	public void testListaConteudoDiretorio() {

		String[] result = null;
		String msg = null;

		result = this.obj.listaConteudoDiretorio(FULL_TEST_DIR);
		msg = Arrays.toString(result);
		Assert.assertArrayEquals(msg, EXPECTED, result);
	}
	
	private static File createTempDirectory() throws IOException {

		final File temp;

		temp = File.createTempFile("temp", Long.toString(System.nanoTime()));
		if (!temp.delete()) {
			throw new IOException("Could not delete temp file: "
					+ temp.getAbsolutePath());
		}

		if (!temp.mkdir()) {
			throw new IOException("Could not create temp directory: "
					+ temp.getAbsolutePath());
		}

		return temp;
	}
}
