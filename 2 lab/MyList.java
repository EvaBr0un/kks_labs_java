public class MyList{
//Класс, описывающий узел списка	
	public static class Node<T>{
		private T data;
		private Node<T> nextNode;

    		public Node(){}
    		public Node(T _data, Node<T> _nextNode){
        		data = _data;
        		nextNode = _nextNode;
    		}
    		public Node(Node<T> node){
        		this(node.getData(), node.getNextNode());
    		}

    		public void setData(T _data){
        		data = _data;
    		}

    		public T getData(){
        		return data;
    		}

    		public Node<T> getNextNode(){
        		return nextNode;
    		}
    
    		public void setNextNode(Node<T> node){
        		nextNode = node;
    		}
	}
//Класс, описывающий сам список
	public static class List<T> implements Iterable<T>{

    		private Node<T> first_node;
    		private Node<T> last_node;
    		private int list_len;
//пустой конструктор
    		public List(){};

    		public List(Node<T> fe, Node<T> se, int len) {
        		list_len   = len;
        		first_node = fe;
        		last_node  = se;

        		first_node.setNextNode(last_node);
    		}
//конструктор копирования
    		public List(List<T> another_list){
        		
			this.first_node = another_list.first_node;
			this.last_node = another_list.last_node;
			this.list_len = another_list.list_len;		
			
			Node<T> another_node = this.first_node.getNextNode();
			while(another_node.getNextNode() != null){
				
				this.addLastNode(new Node(another_node.getData(), another_node.getNextNode()));
				another_node = another_node.getNextNode();
			}
    		}
//Задать входной элемент списка
    		public void addFirstNode(Node<T> node){
        		node.setNextNode(first_node);
        		first_node = node;
        		list_len++;
		}
//Задать выходной элемент списка
    		public void addLastNode(Node<T> node){
        		if (list_len == 1){
            			first_node.setNextNode(node); 
            			last_node = node;
        		}
        		last_node.setNextNode(node);
        		node.setNextNode(null);
        		last_node = node;
        		list_len++;
    		}
//Удалить первый элемент списка
    		public void deleteFirstNode(){
        		first_node = first_node.getNextNode();
        		list_len--;
		}
//удалить последний элемент списка
    		public void deleteLastNode(){
			Node<T> node = first_node;
			while (node.getNextNode().getNextNode() != null){
            			node = node.getNextNode();
        		}
        		node.setNextNode(null);
        		list_len--;
    		}
//Удаление по значению первого найденного элемента
    		public void deleteByValue(T value) throws Exception{
        		Node<T> node = first_node;
        		Node<T> lastNode = null;
        
			while (node != null){
				if (node.getData() == value){
					if (node == first_node){
						first_node = node.getNextNode();
						node.setNextNode(null);
					} else if (node == this.last_node){
						lastNode.setNextNode(null);
						last_node = lastNode;
					} else{
						lastNode.setNextNode(node.getNextNode());
						node.setNextNode(null); 
					}
					list_len--;
					return;
				}
				lastNode = node;
				node = node.getNextNode();
			}
			throw new Exception("No element found for delete.");
		}
//Получить количество элементов в списке
    		public int getLength(){
        		return this.list_len;
    		}
    		public int extendedGetLength(){
        		int i = 0;
        		Node<T> node = first_node;
        		while (node!=null){
            			node = node.getNextNode();
            			i++;
        		}
        		return i;
    		}
//Вывод элемента списка по его номеру
		public T getData(int position) throws Exception{	
			Node<T> node = first_node;		
			try{	
				if ((position > list_len) || (position <= 0)){
            				throw new Exception("Error: invalid Index value!");
        			}				

				for (int i = 0; i < position-1; i++){
            				node = node.getNextNode();
        			}
				
			}catch (Exception e){System.out.println(e.getMessage());}
        		return node.getData();
    		}
//Удаление списка
    		public void deleteList(){
        		first_node = null;
        		last_node = null;
        		list_len = 0;
    		}
	}
@Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private Node<T> current = first_element;

@Override
            public boolean hasNext() {
                return (current != null);
            }

@Override
            public T next() {
                if (hasNext()) {
                    T data = current.getData();
                    current = current.getNextNode();
                    return data;
                }
                return null;
            }
        };
    }
}