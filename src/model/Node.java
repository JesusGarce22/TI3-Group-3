package model;

public class Node {
	
	private String key;
	private Player value;
	
	
	public Node(String key, Player value) {
		this.key = key;
		this.value = value;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public Player getValue() {
		return value;
	}
	public void setValue(Player value) {
		this.value = value;
	}
	
	//Enlaces
	private Node left;
	private Node right;
	
	
	public void insert(String newkey, Player value){
		if(newkey.compareTo(key)<0) {
			//insertar a la izquierda
			if(this.left == null) {
				this.left = new Node(newkey,value);
			}else {
				this.left.insert(newkey,value);
			}
			
		}else if(newkey.compareTo(key)>0) {
			//insertar a la derecha
			if(this.right == null) {
				this.right = new Node(newkey,value);
			}else {
				this.right.insert(newkey,value);
			}
		}
	}
	
	public Node getLeft() {
		return left;
	}


	public void setLeft(Node left) {
		this.left = left;
	}


	public Node getRight() {
		return right;
	}


	public void setRight(Node right) {
		this.right = right;
	}
	

}
