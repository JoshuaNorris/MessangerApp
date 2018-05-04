package GUI.PopupGUI;

import java.io.IOException;

import GUI.MainGui.GUIApp;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class popupMakerApp {

	public void run() throws IOException {
		try { // fix this
			BorderPane root = (BorderPane) FXMLLoader.load(GUIApp.class.getResource("popupGUI.fxml"));
			Stage stage = new Stage();
			stage.setTitle("Make New Conversation");
			stage.setScene(new Scene(root));
			stage.toFront();
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}