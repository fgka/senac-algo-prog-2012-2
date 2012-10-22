package br.com.senacrs.alp.aulas.sockets;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorMain {

	public static void main(String[] args) {
		
		ServerSocket server = null;
		Socket socket = null;
		ManipuladorSocket obj = null;
		String line = null;
		
		try {
			server = new ServerSocket(54321);
			socket = server.accept();
			obj = new ManipuladorSocket(socket);
			line = obj.receberTexto();
			System.out.println(line);
			obj.enviarTexto("OK");
			obj.finalizar();
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		} finally {
			closeSocket(socket);
			closeServer(server);
		}
	}

	private static void closeSocket(Socket socket) {

		if (socket != null) {
			try {
				socket.close();
			} catch (IOException e) {
				throw new IllegalStateException(e);
			}				
		}
	}

	private static void closeServer(ServerSocket server) {
		
		if (server != null) {
			try {
				server.close();
			} catch (IOException e) {
				throw new IllegalStateException(e);
			}							
		}
	}
}
