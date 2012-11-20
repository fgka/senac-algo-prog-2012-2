package br.com.senacrs.alp.aulas.sockets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ManipuladorSocket {

	private Socket socket = null;
	private BufferedReader reader = null;
	private BufferedWriter writer = null;

	public ManipuladorSocket(Socket socket) {

		if (socket == null) {
			throw new IllegalArgumentException();
		}
		this.socket = socket;
	}

	public void enviarTexto(String texto) {

		BufferedWriter writer = null;

		try {
			writer = criarWriter();
			writer.write(texto);
			writer.newLine();
			writer.flush(); // importante para enviar imediatamente
		} catch (IOException e) {
			throw new IllegalStateException(e);
		}
	}

	public BufferedWriter criarWriter() throws IOException {

		OutputStream out = null;
		OutputStreamWriter osWriter = null;

		if (this.writer == null) {
			out = this.socket.getOutputStream();
			osWriter = new OutputStreamWriter(out);
			this.writer = new BufferedWriter(osWriter);			
		}

		return this.writer;
	}

	public String receberTexto() {

		String resultado = null;
		BufferedReader reader = null;

		try {
			reader = criarReader();
			resultado = reader.readLine();
		} catch (IOException e) {
			throw new IllegalStateException(e);
		} catch (InterruptedException e) {
			throw new IllegalStateException(e);
		}

		return resultado;
	}

	public BufferedReader criarReader() throws IOException, InterruptedException {

		InputStream in = null;
		InputStreamReader isReader = null;

		if (this.reader == null) {
			in = this.socket.getInputStream();
			isReader = new InputStreamReader(in);
			this.reader = new BufferedReader(isReader);
		}
		while (!this.reader.ready()) {
			Thread.sleep(1000);
		}

		return this.reader;
	}

	public void finalizar() {

		closeReader();
		closeWriter();
	}

	private void closeReader() {

		if (this.reader != null) {
			try {
				this.reader.close();
			} catch (IOException e) {
				throw new IllegalStateException(e);
			}
		}
	}

	private void closeWriter() {

		if (this.writer != null) {
			try {
				this.writer.close();
			} catch (IOException e) {
				throw new IllegalStateException(e);
			}
		}
	}
}
