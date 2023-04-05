public class TestVector{

	public static void main(String[] args){

		MyVector<Integer> vec = new MyVector<Integer>(5);
		for (int i = 0; i < 4; i++){
			try{
				vec.insert(i,i);
			}catch(Exception err){}
		}//0,1,2,3
		
		System.out.println("Vector(0,1,2,3) max length:");
		System.out.println(vec.getCapacity());

		vec.push(4);
		vec.push(5);//0,1,2,3,4,5
		System.out.println("Vector(0,1,2,3,4,5) max length:");
		System.out.println(vec.getCapacity());
		
		try{
			vec.pop();//0,1,2,3,4
			vec.deleteByIndex(0);//1,2,3,4
			vec.deleteByValue(2);//1,3,4
		}catch(Exception err){}

		System.out.println("Vector length:");
		System.out.println(vec.getLen());
		
		System.out.println("Final vector:");
		try{
			for (int i = 0; i < vec.getLen(); i++){
				System.out.println(vec.getByIndex(i));		
			}
		}catch(Exception err){}

		MyVector<Integer> copied_vec = new MyVector<Integer>(vec);
		System.out.println("Copied vector:");
		try{
			for (int i = 0; i < copied_vec.getLen(); i++){
				System.out.println(copied_vec.getByIndex(i));		
			}
		}catch(Exception err){}

		Cat cat1 = new Cat("cat1", 1);
		Cat cat2 = new Cat("cat2", 2);
		Cat cat3 = new Cat("cat3", 3);
		
		MyVector<Cat> vecCat = new MyVector<Cat>(3);
		vecCat.push(cat1);
		vecCat.push(cat2);
		vecCat.push(cat3);

		try{
			vecCat.deleteByValue(cat2);
		}catch(Exception err){System.out.println(err);}

		for(int i = 0; i < vecCat.getLen(); i++){
			try{
				Cat catBuf = vecCat.getByIndex(i);
				System.out.println(catBuf.toString());
			}catch(Exception err){System.out.println(err);}
			
		}
		
	
	}
}