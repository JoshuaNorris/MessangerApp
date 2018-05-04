package GUI.EnterNameGUI;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class enterNameController {

	@FXML
	public Button enterButton;
	
	@FXML
	public TextField name;
	
	private static String nameString;
	
	private static boolean closed = false;
	
	private static enterNameController controller;
	
	public void initialize() {
		controller = this;
	}
	
	public static String getName() {
		return controller.nameString;
	}
	
	public static boolean isClosed() {
		return controller.closed;
	}
	
	@FXML
	public void saveConversation() {
		this.nameString = name.getText();
		closed = true;
		Stage scene = (Stage) name.getScene().getWindow();
		scene.close();
	}
	
	
}
