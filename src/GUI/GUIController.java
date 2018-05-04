package GUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class GUIController {

	//private ArrayList<Conversation> conversationArrayList = new ArrayList<Conversation>();
	
	private ObservableList<String> conversationObservableList = FXCollections.observableArrayList();

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
	
	public popupMaker addConversation;
}