package model;

public class Player {
	
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

}
