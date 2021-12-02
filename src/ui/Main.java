package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	
	private Game game;

	public static void main(String[] args) {
		launch(args);

	}
	
	public Main() {
		game = new Game();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("mainPane.fxml"));
		loader.setController(game);
		Parent root = loader.load();
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();

		game.loadLogin();
	
	}

}
