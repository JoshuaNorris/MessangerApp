package GUI.EnterNameGUI;

import java.io.IOException;

import GUI.MainGui.GUIApp;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class enterNamePopup {

	public void run() throws IOException {
		try { // fix this
			BorderPane root = (BorderPane) FXMLLoader.load(enterNamePopup.class.getResource("enterNameGUI.fxml"));
			Stage stage = new Stage();
			stage.setTitle("Enter Your Name");
			stage.setScene(new Scene(root));
			stage.toFront();
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
