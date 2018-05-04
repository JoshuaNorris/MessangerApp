package DataStructures;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ConversationContainer {
	
	private String ip;
	private String name;
	private ObservableList<String> conversationHistory = FXCollections.observableArrayList();
	
	public ConversationContainer(String ip, String name) {
		this.ip = ip;
		this.name = name;
	}
	
	public String getIp() {return ip;};
	public String getName() {return name;};
	public ObservableList<String> getHistory() {return conversationHistory;};
	
	public void addMessage (ObservableList<String> list) {
		conversationHistory = list;
	}
	
	public void addMessage (String message) {
		conversationHistory.add(message);
	}
	
	@Override
	public String toString() {
		return "Name: " + name + " IP: " + ip;
	}
	
}
