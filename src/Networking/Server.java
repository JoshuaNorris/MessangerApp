package Networking;

import java.net.*;

import GUI.MainGui.GUIController;

import java.io.*;

public class Server {

	private ServerSocket server;
	private GUIController gui;

	public Server(GUIController gui){
		
		try {
			server = new ServerSocket(22223);
			new WaitingForConnection(server, gui);
		}catch(IOException i) {
			System.out.println(i);
		}
	}
}