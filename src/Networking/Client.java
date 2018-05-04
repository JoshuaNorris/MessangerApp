package Networking;

import java.net.*;
import java.io.*;

public class Client {

	private Socket socket;

	public Client(String ip, String message) throws IOException {
		try {
			socket = new Socket(ip, 22223);
		} catch (UnknownHostException h) {
			System.out.println(h);
		} catch (IOException e) {
			System.out.println(e);
		}
		byte[] bytes = message.getBytes();
		OutputStream os = socket.getOutputStream();
		os.write(bytes);
		os.flush();
		os.close();
		socket.close();
	}
}