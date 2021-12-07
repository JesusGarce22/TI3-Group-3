package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Player implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String userName;
	private int score;
	private static ArrayList<Player> pyer;
	
	public Player(String userName,int score)  {
		this.score = score;
		this.userName = userName;
		pyer = new ArrayList<>();
	}
	public Player() {}
	
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String toString() {
		return "Nombre: "+userName+ " Puntaje: "+score + "\n";
	}
	
	public ArrayList<Player> getPlayers(){
		return pyer;
	} 
	

}
