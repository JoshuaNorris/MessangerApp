package GUI;

import java.io.IOException;
import java.util.ArrayList;

import GUI.BadNews;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class GUIController {

	private ArrayList<ConversationContainer> conversations = new ArrayList<ConversationContainer>();

	private ObservableList<String> observableList = FXCollections.observableArrayList();

	@FXML
	public ListView<String> conversationList = new ListView<String>();

	@FXML
	public ListView<String> messageList = new ListView<String>();

	@FXML
	public Pane conversationViewer;

	@FXML
	public Button addButton;

	@FXML
	public Button goToButton;

	@FXML
	public Label name;

	@FXML
	public TextField messageTextField;

	@FXML
	public Button sendButton;
	
	public ConversationContainer currentConversation;
	
	private String myName;

	static BadNews error;

	@FXML
	public void initialize() throws IOException {
		messageTextField.setEditable(false);
		sendButton.setDisable(true);
		myName = " ";
		new Server(this);
	}

	@FXML
	public void addConversation() throws IOException {
		popupMakerApp popup = new popupMakerApp();
		popup.run();
		System.out.println(myName);
		if (myName.equals(" ")) {
			enterNamePopup namePopup = new enterNamePopup();
			namePopup.run();
			new Thread(() -> {

				while (!enterNameController.isClosed()) {
					System.out.print("");
				}

				this.myName = enterNameController.getName();

			}).start();
		}

		new Thread(() -> {

			while (!PopupController.isClosed()) {
				System.out.print(""); // ask Dr. Ferrer about this line.
				// also ask Dr. Ferrer about my static controller
			}

			Platform.runLater(() -> {
				updateLists(PopupController.getIp(), PopupController.getName());
			});
			PopupController.clear();

		}).start();
	}

	private ConversationContainer updateLists(String ip, String name) {
		ConversationContainer conversation = new ConversationContainer(PopupController.getIp(),
				PopupController.getName());
		conversations.add(conversation);
		System.out.println("	NAME:" + PopupController.getName());
		observableList.add(PopupController.getName());
		conversationList.setItems(observableList);
		
		return conversation;
	}
	
	public void updateLists(ObservableList<String> observableList) {
		messageList.setItems(observableList);
	}

	@FXML
	public void goToConversation() {
		int index = conversationList.getSelectionModel().getSelectedIndex();
		ConversationContainer conversation = conversations.get(index);
		currentConversation = conversation;
		name.setText(conversation.getName());
		conversationList.setItems(conversation.getHistory());
		messageTextField.setEditable(true);
		sendButton.setDisable(false);
	}

	@FXML
	public void sendMessage() throws IOException {
		String message = messageTextField.getText();
		message = myName + ": " + message;
		currentConversation.addMessage(message);
		messageList.setItems(currentConversation.getHistory());
		MessageSender sender = new MessageSender(currentConversation.getHistory());
		new Client(currentConversation.getIp(), sender.toString());
	}
	
	public ConversationContainer getConversationWithIp (String ip, String name) {
		for (int x = 0; x < conversations.size(); x++) {
			if (conversations.get(x).getIp() == ip) {
				return conversations.get(x);
			}
		}
		return updateLists(ip, name);
		
	}

}