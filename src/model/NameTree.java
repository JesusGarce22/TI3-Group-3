package model;

public class NameTree {

	private int numProgramadores;
	private Node root;

	public void add(String key, Player value)  {
		if(root == null) {
			root = new Node(key,value);
		}else {
			root.insert(key,value);
		}
	}

	public void triggerInorder() {
		inorder(root);
	}

	//Recursivo
	public void inorder(Node node) {
		//Caso base
		if(node == null) {
			return;
		}
		//Recursivo

		inorder(node.getLeft());
		System.out.println(node.getKey());
		inorder(node.getRight());
	}

	public Node triggerSearch(String key) {
		return search(root,key,1);

	}

	public Node search(Node node,String key,int contador) {

		//condicion de parada	
		if(node==null) {
			return null;
		}

		if(key.equalsIgnoreCase(node.getKey())) {
			return node;
		}

		//condicion recursiva
		if(key.compareTo(node.getKey())<0) {
			contador++;
			//System.out.println(contador);
			return search(node.getLeft(),key,contador);
		}
		else {
			contador++;
			//System.out.println(contador);
			return search(node.getRight(),key,contador);
		}

	}
	
	public Node getMin(Node x) {
		
		if(x.getLeft() == null) {
			return x;
		}else {
			return getMin(x.getLeft());
		}
	}
	
	public Node getMax(Node x) {
		
		if(x.getRight() == null) {
			return x;
		}else {
			return getMax(x.getRight());
		}
	}
	
	public void trigerDelete(String key) {
		if(root != null) {
			root=delete(root,key);
		}
	}
	
	public Node delete(Node x,String key) {
		
		if(key.equalsIgnoreCase(x.getKey())) {
			if(x.getLeft()==null && x.getRight()==null) {
				return null;
			}else if(x.getLeft()==null) {
				
				Node succesor = getMin(x.getRight());
				Node newRigthTree = delete(x.getRight(),succesor.getKey());
				
				succesor.setLeft(x.getLeft());
				succesor.setRight(newRigthTree);
				
				return succesor;
				
			}else {
				return  x.getRight();
			}
			
			
			
		} else if(key.equalsIgnoreCase(x.getKey())){
			
			x.setLeft(delete(x.getLeft(),key));
		} else {
			
			x.setRight(delete(x.getRight(),key));
		}
		
		return x;
		
	}
}
