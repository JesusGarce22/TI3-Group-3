package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.Player;

public class Game extends Stage{

	@FXML
	private BorderPane mainPane;
	
    @FXML
    private TextField userName;

    @FXML
    private Button star;
	
	public void loadLogin() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Register.fxml"));

		loader.setController(this);
		Parent addUser = loader.load();

		mainPane.setCenter(addUser);
		mainPane.getChildren().clear();
		mainPane.setTop(addUser);

	}
	
   public void enterToTheGame(ActionEvent event)throws IOException {
	   
	   String name=userName.getText();
	   
	   Player p = new Player(name,0);

		FXMLLoader loader = new FXMLLoader(getClass().getResource("Game.fxml"));

		loader.setController(this);
		Parent addUser = loader.load();

		mainPane.setCenter(addUser);
		mainPane.getChildren().clear();
		mainPane.setTop(addUser);

    }
}
