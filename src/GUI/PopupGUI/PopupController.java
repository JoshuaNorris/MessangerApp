package GUI.PopupGUI;

import DataStructures.BadNews;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.Window;

public class PopupController {

	@FXML
	private BorderPane pane;
	
	@FXML
	private Button enterButton;
	
	@FXML
	private TextField ip;
	
	@FXML
	private TextField name;
	
	static BadNews error;
	
	public static boolean closed = false;
	
	private String ipString;
	
	private String nameString;
	
	private static PopupController controller;
	
	public void initialize() {
		controller = this;
	}
	
	public static String getIp() {
		return controller.ipString;
	}
	
	public static String getName() {
		return controller.nameString;
	}
	
	public static boolean isClosed() {
		return closed;
	}
	
	@FXML
	public void saveConversation() {
		ipString = ip.getText();
		nameString = name.getText();
		closed = true;
		Stage scene = (Stage) name.getScene().getWindow();
		scene.close();
	}
	
	public static void clear() {
		
		closed = false;
	}
}
