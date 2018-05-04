package Networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import DataStructures.ConversationContainer;
import DataStructures.MessageReceiver;
import GUI.MainGui.GUIController;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.scene.layout.Pane;

public class UpdateGUI {

	Socket socket;
	GUIController gui;

	public UpdateGUI(Socket socket, GUIController gui) throws IOException {
		this.socket = socket;
		this.gui = gui;
		BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String messageStr = is.readLine();
		MessageReceiver receiver = new MessageReceiver(messageStr);
		ObservableList<String> messageList = receiver.getList();
		String name = receiver.getName();

		Platform.runLater(() -> {
			ConversationContainer conversation = gui.getConversationWithIp(socket.getInetAddress().toString(), name);
			conversation.addMessage(messageList);
		});
	}

}