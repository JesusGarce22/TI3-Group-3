package model;

public class ScoreTree {

	private NodeScore root;
	String top="";
	
	public void add(int key, Player player) {
		if (root == null) {
			root = new NodeScore(key);
		} else {
			root.insert(key, player);
		}
	}
	
	public String triggerInorder() {
		String aux=inorder(root,0);
		return aux;
	}
	
	public String inorder(NodeScore node,int n) {
		// Caso base
		if (node == null) {
			
			return top;
		}
		// Recursivo
		n++;
		inorder(node.getLeft(),n);
		top+= n+" "+node.getScore()+"\n";
		//System.out.println(n+" "+node.getScore());
		inorder(node.getRight(),n);
		 
		 return top;
	}
}
