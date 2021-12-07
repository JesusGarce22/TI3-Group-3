package ui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.Challenge;
import model.Chronometer;
import model.NameTree;
import model.Player;
import model.ScoreTree;

public class Game extends Stage {

	private NameTree nameTree;
	private ScoreTree scoreTree;
	private Challenge challenge;
	private Chronometer chro;

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
	private Button optionA;

	@FXML
	private Label operation;

	@FXML
	private Label score;
	@FXML
	private TextField nameDeleteOrSearch;

	@FXML
	private Button submit;

	@FXML
	private Label timeLabel;

	@FXML
	private Label scoreLB;

	@FXML
	private Label failLB;

	private int score1;
	private int fails;
	private boolean mainProcces = true;

	public Game() {
		nameTree = new NameTree();
		scoreTree = new ScoreTree();
		challenge = new Challenge();
		chro = new Chronometer(this);
		
	}

	public void loadLogin() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Register.fxml"));

		loader.setController(this);
		Parent addUser = loader.load();

		mainPane.setCenter(addUser);
		mainPane.getChildren().clear();
		mainPane.setTop(addUser);

	}

	public void enterToTheGame(ActionEvent event) throws IOException {

		if (userName.getText().equals("")) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("ERROR");
			alert.setHeaderText("You must fill all the fields");
			alert.setContentText(null);
			alert.showAndWait();
		} else {
			String name = userName.getText();

			Player p = new Player(name, 0);
			nameTree.add(name, p);
			scoreTree.add(0, p);

			FXMLLoader loader = new FXMLLoader(getClass().getResource("Game.fxml"));

			loader.setController(this);
			Parent addUser = loader.load();

			mainPane.setCenter(addUser);
			mainPane.getChildren().clear();
			mainPane.setTop(addUser);

			init(p);
		}
	}

	public void init(Player p) throws IOException {

		chro.start();

		getOperation(p);

	}

	public void SearchUser(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Search.fxml"));

		loader.setController(this);
		Parent addUser = loader.load();

		mainPane.setCenter(addUser);
		mainPane.getChildren().clear();
		mainPane.setTop(addUser);

		String key = nameDeleteOrSearch.getText();
		nameTree.triggerSearch(key);
	}

	public void deleteScore(ActionEvent event) throws IOException {

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

	public void getOperation(Player p) throws IOException {

		if (timeLabel.getText().equals("0")) {

			int newScore = Integer.parseInt(scoreLB.getText());
			p.setScore(newScore);
			saveObject(p);
			saveReadableFile(p);
			loadData();

			scoreTree.triggerInorder();

			FXMLLoader loader = new FXMLLoader(getClass().getResource("Positions.fxml"));

			loader.setController(this);
			Parent addUser = loader.load();

			mainPane.setCenter(addUser);
			mainPane.getChildren().clear();
			mainPane.setTop(addUser);

		}

		operation.setText(challenge.operators());
		ramdonBotton();
		initBottons(p);

	}

	public void tell(boolean process) {
		// run on ui thread
		Platform.runLater(() -> {

			mainProcces = process;

		});
	}

	public void initBottons(Player p) {

		optionA.setOnAction(event -> {

			int ans = challenge.getAnswer();

			String an = Integer.toString(ans);

			if (optionA.getText().equals(an)) {

				score1 += 10;
				String sc = Integer.toString(score1);
				scoreLB.setText(sc);
				try {
					getOperation(p);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else {

				score1 -= 10;
				String sc = Integer.toString(score1);
				fails++;
				String f = Integer.toString(fails);
				failLB.setText(f);
				scoreLB.setText(sc);
				try {
					getOperation(p);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		});

		optionB.setOnAction(event -> {

			int ans = challenge.getAnswer();

			String an = Integer.toString(ans);

			if (optionB.getText().equals(an)) {

				score1 += 10;
				String sc = Integer.toString(score1);
				scoreLB.setText(sc);
				try {
					getOperation(p);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else {

				score1 -= 10;
				String sc = Integer.toString(score1);
				fails++;
				String f = Integer.toString(fails);
				failLB.setText(f);
				scoreLB.setText(sc);
				try {
					getOperation(p);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		});

		optionC.setOnAction(event -> {

			int ans = challenge.getAnswer();

			String an = Integer.toString(ans);

			if (optionC.getText().equals(an)) {

				score1 += 10;
				String sc = Integer.toString(score1);
				scoreLB.setText(sc);
				try {
					getOperation(p);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else {

				score1 -= 10;
				String sc = Integer.toString(score1);
				fails++;
				String f = Integer.toString(fails);
				failLB.setText(f);
				scoreLB.setText(sc);
				try {
					getOperation(p);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		});

		optionD.setOnAction(event -> {

			int ans = challenge.getAnswer();

			String an = Integer.toString(ans);

			if (optionD.getText().equals(an)) {

				score1 += 10;
				String sc = Integer.toString(score1);
				scoreLB.setText(sc);
				try {
					getOperation(p);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else {

				score1 -= 10;
				String sc = Integer.toString(score1);
				fails++;
				String f = Integer.toString(fails);
				failLB.setText(f);
				scoreLB.setText(sc);
				try {
					getOperation(p);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		});

	}

	public void ramdonBotton() {

		int botton = challenge.ramdonBotton();

		if (botton == 0) {

			String an = Integer.toString(challenge.getAnswer());
			optionA.setText(an);

		} else {

			int ramdon = (int) (Math.random() * 10) + 1;
			int decition = (int) (Math.random() * 2);

			if (decition == 0) {

				String ramdonAns = Integer.toString(challenge.getAnswer() + ramdon);
				optionA.setText(ramdonAns);
			} else if (decition == 1) {

				String ramdonAns = Integer.toString(challenge.getAnswer() - ramdon);
				optionA.setText(ramdonAns);
			}

		}

		if (botton == 1) {

			String an = Integer.toString(challenge.getAnswer());
			optionB.setText(an);

		} else {

			int ramdon = (int) (Math.random() * 10) + 1;
			int decition = (int) (Math.random() * 2);

			if (decition == 0) {

				String ramdonAns = Integer.toString(challenge.getAnswer() + ramdon);
				optionB.setText(ramdonAns);
			} else if (decition == 1) {

				String ramdonAns = Integer.toString(challenge.getAnswer() - ramdon);
				optionB.setText(ramdonAns);
			}

		}

		if (botton == 2) {

			String an = Integer.toString(challenge.getAnswer());
			optionC.setText(an);

		} else {

			int ramdon = (int) (Math.random() * 10) + 1;
			int decition = (int) (Math.random() * 2);

			if (decition == 0) {

				String ramdonAns = Integer.toString(challenge.getAnswer() + ramdon);
				optionC.setText(ramdonAns);
			} else if (decition == 1) {

				String ramdonAns = Integer.toString(challenge.getAnswer() - ramdon);
				optionC.setText(ramdonAns);
			}

		}

		if (botton == 3) {

			String an = Integer.toString(challenge.getAnswer());
			optionD.setText(an);

		} else {

			int ramdon = (int) (Math.random() * 10) + 1;
			int decition = (int) (Math.random() * 2);

			if (decition == 0) {

				String ramdonAns = Integer.toString(challenge.getAnswer() + ramdon);
				optionD.setText(ramdonAns);
			} else if (decition == 1) {

				String ramdonAns = Integer.toString(challenge.getAnswer() - ramdon);
				optionD.setText(ramdonAns);
			}

		}

	}

	public void setTimeLabel(int time) {

		Platform.runLater(() -> {

			String t = Integer.toString(time);
			timeLabel.setText(t);

		});

	}

	public boolean getMainProcces() {
		return mainProcces;
	}

	public void saveObject(Player p) {

		try {
			
			File ref = new File("ObjecPlayer.temp");
			FileOutputStream fos = new FileOutputStream(ref);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(p);
			oos.close();

		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public void loadData() {
		
		try {
			File f = new File("ObjecPlayer.temp");
			FileInputStream fis = new FileInputStream(f);
			ObjectInputStream ois = new ObjectInputStream(fis);
			Player p = (Player) ois.readObject();
			// Agregar este objeto al arbol
			
		}catch(IOException ex) {
			
			ex.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void saveReadableFile(Player p) {
		
		try {
			String data = p.toString();
			File ref = new File("ListaDeJugadores.txt");
			FileOutputStream fos = new FileOutputStream(ref);
			fos.write(data.getBytes());
			fos.close();
			
		}catch(IOException ex) {
			ex.printStackTrace();
		}
	}

}
