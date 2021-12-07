package model;

public class ScoreTree {

	private NodeScore root;
	
	public void add(int key, Player player) {
		if (root == null) {
			root = new NodeScore(key);
		} else {
			root.insert(key, player);
		}
	}
	
	public void triggerInorder() {
		inorder(root,0);
	}
	
	public void inorder(NodeScore node,int n) {
		// Caso base
		if (node == null) {
			return;
		}
		// Recursivo
		n++;
		inorder(node.getLeft(),n);
		System.out.println(n+" "+node.getScore());
		inorder(node.getRight(),n);
	}
}
