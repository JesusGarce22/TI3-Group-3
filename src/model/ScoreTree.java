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
		inorder(root);
	}
	
	public void inorder(NodeScore node) {
		// Caso base
		if (node == null) {
			return;
		}
		// Recursivo

		inorder(node.getLeft());
		System.out.println(node.getScore());
		inorder(node.getRight());
	}
}
