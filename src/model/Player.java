package model;

import java.io.Serializable;

public class Player implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String userName;
	private int score;
	
	public Player(String userName,int score)  {
		this.score = score;
		this.userName = userName;
	}
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
	

}
