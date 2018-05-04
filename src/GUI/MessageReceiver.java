package GUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MessageReceiver {

	private String messages;
	private ObservableList<String> list;
	private String name;
	
	public MessageReceiver(String messages) {
		this.messages = messages;
		this.list = toList();
		this.name = calculateName(list);
	}
	
	public ObservableList<String> getList() {return list;};
	public String getName() {return name;};
	
	private ObservableList<String> toList() {
		ObservableList<String> result = FXCollections.observableArrayList();
		String[] split = messages.split("///");
		for (int x = 0; x < split.length; x++) {
			result.add(split[x]);
		}
		return result;
	}
	
	private String calculateName(ObservableList<String> list) {
		String lastElement = list.get(list.size() - 1);
		int index = lastElement.indexOf(':');
		return lastElement.substring(0, index);
	}

}
