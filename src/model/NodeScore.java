package model;

import java.util.ArrayList;

public class NodeScore {

	private int key;
	private ArrayList<Player> value;
	
	private NodeScore left;
	private NodeScore right;
	
	public NodeScore(int score) {
		this.key = score;
		this.value = new ArrayList<>();
	}
	public int getScore() {
		return key;
	}
	public void setScore(int score) {
		this.key = score;
	}
	public ArrayList<Player> getPlayers() {
		return value;
	}
	public void setPlayers(ArrayList<Player> players) {
		this.value = players;
	}
	public NodeScore getLeft() {
		return left;
	}
	public void setLeft(NodeScore left) {
		this.left = left;
	}
	public NodeScore getRight() {
		return right;
	}
	public void setRight(NodeScore right) {
		this.right = right;
	}
	public void insert(int newkey,Player player) {
		if(newkey<this.key) {
			//insertar a la izquierda
			if(this.left == null) {
				this.left = new NodeScore(newkey);
				this.left.getPlayers().add(player);
			}else {
				this.left.insert(newkey,player);
			}
			
		}else if(newkey>this.key){
			//insertar a la derecha
			if(this.right == null) {
				this.right = new NodeScore(newkey);
				this.right.getPlayers().add(player);
			}else {
				this.right.insert(newkey,player);
			}
		}else {
			this.value.add(new Player(player.getUserName(),newkey ));
		}
	}
}
