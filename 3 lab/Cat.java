public class Cat{

	private String name;
	private int age;
	
	public Cat(){};

	public Cat(String _name, int _age){
		name = _name;
		age = _age;
	}
	public void setName(String _name){
        	name = _name;
    	}
	public void setAge(int _age){
        	age = _age;
    	}
	public int getAge(){
        	return this.age;
    	}
	public String getName(){
        	return this.name;
    	}

	@Override
    	public String toString(){
		return "name: " + name + "; age: " + age;

	}	

}