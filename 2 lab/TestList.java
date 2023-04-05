public class TestList
{	
    
	public static void main(String[] args){
        	MyList.Node<Integer> a = new MyList.Node<Integer>(1, null);
        	MyList.Node<Integer> b = new MyList.Node<Integer>(2, null);
		MyList.Node<Integer> d = new MyList.Node<Integer>(4, null);
        	MyList.Node<Integer> e = new MyList.Node<Integer>(5, null);
        	MyList.Node<Integer> f = new MyList.Node<Integer>(0, null);
        	MyList.List<Integer> lst = new MyList.List<Integer>(a,b,3);
		//список: 1,2,3
		lst.addLastNode(d);
		lst.addLastNode(e);
		//cписок: 1,2,3,4,5
		try{
		lst.deleteByValue(3);
		}catch(Exception er){}
	
		lst.deleteFirstNode();
		lst.deleteLastNode();
		//cписок: 2,4
		lst.addFirstNode(f);
		//cписок: 0,2,4
		MyList.List<Integer> lst_copy = new MyList.List<Integer>(lst);
		

		for (int i = 1; i < 4; i++){
			try{
			System.out.println(lst.getData(i));
			}catch(Exception err){}
		}
		
		for (int i = 1; i < 4; i++){
			try{
			System.out.println(lst_copy.getData(i));
			}catch(Exception err){}
		}
		
		lst_copy.deleteList();
		lst.deleteList();

	}
}