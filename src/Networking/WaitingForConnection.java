package Networking;

import java.net.*;

import GUI.MainGui.GUIController;

import java.io.*;

public class WaitingForConnection extends Thread{
	ServerSocket s;
	Socket connectingSocket;
	GUIController gui;

	public WaitingForConnection(ServerSocket s, GUIController gui) {
		this.s = s;
		this.gui = gui;
	}

	@Override
	public void start() {
		run();
	}

	@Override
	public void run() {
		new Thread(() -> {try {
			connectingSocket = s.accept();
			new UpdateGUI(connectingSocket, gui);
			new WaitingForConnection(s, gui).start();
		} catch(IOException e) {
			e.printStackTrace();
		}}).start();
	}

	public Socket getConnectingSocket() {
		return connectingSocket;
	}
}