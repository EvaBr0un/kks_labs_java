public class BinaryTree<T extends Comparable<T>>{
//Класс, описывающий узел дерева
	public static class Node<T>{

		private T data;
		private Node<T> leftNode;
		private Node<T> rightNode;

		public Node(){
			this.leftNode = null;
			this.rightNode = null;
		}
    		//public Node(T _data, Node<T> _leftNode, Node<T> _rightNode){
        		//data = _data;
        		//leftNode = _leftNode;
			//rightNode = _rightNode;	
    		//}
		public void setData(T _data){
        		data = _data;
    		}
		public T getData(){
        		return this.data;
    		}
		public Node<T> getLeftNode(){
        		return this.leftNode;
    		}
		public Node<T> getRightNode(){
        		return this.rightNode;
    		}		
    		public void setLeftNode(Node<T> node){
        		this.leftNode = node;
    		}
    		public void setRightNode(Node<T> node){
        		this.rightNode = node;
    		}
	}

	private Node<T> rootNode;
	int len;	
//пустой конструктор
    	public BinaryTree(){
		this.rootNode = null;
		this.len = 1;		
	}

	public void copyTree(Node<T> anotherRoot){

		while(anotherRoot != null){
			this.addNode(anotherRoot.getData());
			copyTree(anotherRoot.getRightNode());
			anotherRoot = anotherRoot.getLeftNode();
		}
	
	}
	
//конструктор копирования
	public BinaryTree(BinaryTree<T> anotherTree){
		this.rootNode = null;
		this.len = 0;		

		copyTree(anotherTree.rootNode);

	}
//получить корень
	public Node<T> getNode(){
		return this.rootNode;
	}
//добавление элемента	
	public void addNode(T data){
		if(this.rootNode == null){
			this.rootNode = new Node();
			this.rootNode.setData(data);
			return;
		}

		Node<T> newNode = this.rootNode;
		Node<T> bufNode = this.rootNode;

		while(newNode != null){
			
			bufNode = newNode;

			if(data.compareTo(newNode.getData()) == 0) return;
			if(data.compareTo(newNode.getData()) < 0){
				newNode = newNode.getLeftNode();
			} else newNode = newNode.getRightNode();
		}

		newNode = new Node();
		newNode.setData(data);		

		if(data.compareTo(bufNode.getData()) < 0){
				bufNode.setLeftNode(newNode);	
		}
		else bufNode.setRightNode(newNode);

		this.len++;	
	}
//поиск элемента
	public Node<T> searchNode(T data){
		Node<T> bufNode = this.rootNode;
			
		while(data.compareTo(bufNode.getData()) != 0){
			if(data.compareTo(bufNode.getData()) < 0){
				bufNode = bufNode.getLeftNode();
			}
			else bufNode = bufNode.getRightNode();				
		}
		return bufNode;
	}
		
//удаление дерева
	public void deleteTree(){
		this.rootNode = null;
		len = 1;
	}
}