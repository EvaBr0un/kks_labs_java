public class TestBinaryTree{
	
	public static void printNodeByValue(BinaryTree<Integer> tree, int value){

		BinaryTree.Node<Integer> targetNode = tree.searchNode(value);
		System.out.printf("Entered Node: %d\n", targetNode.getData());
	
		targetNode = targetNode.getLeftNode();
		if(targetNode != null){
			System.out.printf("LeftNode: %d\n", targetNode.getData());
		} else System.out.printf("LeftNode: null\n");
		
		targetNode = tree.searchNode(value);
		targetNode = targetNode.getRightNode();
		if(targetNode != null){
			System.out.printf("RightNode: %d\n", targetNode.getData());
		} else	System.out.printf("RightNode: null\n");

		System.out.println("*********************");
	}

	public static void main(String[] args){

	BinaryTree<Integer> tree = new BinaryTree<Integer>();

	tree.addNode(5);
	tree.addNode(3);
	tree.addNode(6);
	tree.addNode(2);
	tree.addNode(4);
	tree.addNode(1);
	
	System.out.println("TREE:");
	printNodeByValue(tree, 5);
	printNodeByValue(tree, 3);
	printNodeByValue(tree, 6);
	printNodeByValue(tree, 2);
	printNodeByValue(tree, 4);
	printNodeByValue(tree, 1);	
	
	BinaryTree<Integer> copied_tree = new BinaryTree<Integer>(tree);
	
	System.out.println("COPIED TREE:");
	printNodeByValue(copied_tree, 5);
	printNodeByValue(copied_tree, 3);
	printNodeByValue(copied_tree, 6);
	printNodeByValue(copied_tree, 2);
	printNodeByValue(copied_tree, 4);
	printNodeByValue(copied_tree, 1);

	}
}