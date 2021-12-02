package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.NameTree;
import model.Player;
import model.ScoreTree;

public class Game extends Stage{

	private NameTree nameTree;
	private ScoreTree scoreTree;

	@FXML
	private Button deleteScore;

	@FXML
	private TextArea top5;

	@FXML
	private Button searchUser;
	@FXML
	private BorderPane mainPane;

	@FXML
	private TextField userName;

	@FXML
	private Button star;
	@FXML
	private Button optionC;

	@FXML
	private Button optionD;

	@FXML
	private Button optionB;

	@FXML
	private Button optiopnA;

	@FXML
	private TextArea operation;

	@FXML
	private Label score;
    @FXML
    private TextField nameDeleteOrSearch;

    @FXML
    private Button submit;

	public Game() {
		nameTree = new NameTree();
		scoreTree = new ScoreTree();
	}

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
		nameTree.add(name, p);
		scoreTree.add(0, p);

		FXMLLoader loader = new FXMLLoader(getClass().getResource("Game.fxml"));

		loader.setController(this);
		Parent addUser = loader.load();

		mainPane.setCenter(addUser);
		mainPane.getChildren().clear();
		mainPane.setTop(addUser);

	}


	public void SearchUser(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("DeleteOrSearch.fxml"));

		loader.setController(this);
		Parent addUser = loader.load();

		mainPane.setCenter(addUser);
		mainPane.getChildren().clear();
		mainPane.setTop(addUser);
		
		String key = nameDeleteOrSearch.getText();
		nameTree.triggerSearch(key);
	}

	public void deleteScore(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("DeleteOrSearch.fxml"));

		loader.setController(this);
		Parent addUser = loader.load();

		mainPane.setCenter(addUser);
		mainPane.getChildren().clear();
		mainPane.setTop(addUser);
		
		String key = nameDeleteOrSearch.getText();
		nameTree.trigerDelete(key);
	}

    @FXML
    public void deleteOrSearch(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Positions.fxml"));

		loader.setController(this);
		Parent addUser = loader.load();

		mainPane.setCenter(addUser);
		mainPane.getChildren().clear();
		mainPane.setTop(addUser);
    }
}
