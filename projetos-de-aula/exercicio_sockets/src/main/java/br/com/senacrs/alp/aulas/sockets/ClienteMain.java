package br.com.senacrs.alp.aulas.sockets;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClienteMain {

	public static void main(String[] args) {

		Socket client = null;
		ManipuladorSocket obj = null;
		String line = null;

		try {
			client = new Socket("127.0.0.1", 54321);
			obj = new ManipuladorSocket(client);
			obj.enviarTexto("cliente falando. escutou?");
			line = obj.receberTexto();
			System.out.println(line);
			obj.finalizar();
		} catch (UnknownHostException e) {
			throw new IllegalArgumentException(e);
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		} finally {
			closeSocket(client);
		}
	}

	private static void closeSocket(Socket client) {
		
		if (client != null) {
			try {
				client.close();
			} catch (IOException e) {
				throw new IllegalStateException(e);
			}
		}
	}

}
