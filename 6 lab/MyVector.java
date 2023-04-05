public class MyVector<T> <T extends Comparable<T>>{
    
	private T[] arr;
	private int len;
	private int capacity;

//пустой конструктор
	public MyVector(){
        	this.arr = (T[])new Object[1];
        	this.capacity = 1;
        	this.len = 0;
	}
//конструктор с заданным максимальным числов элементов
	public MyVector(int _capacity){
        	this.arr = (T[])new Object[_capacity];
        	this.capacity = _capacity;
        	this.len = 0;
	}
//конструктор копирования
	public MyVector(MyVector<T> another_vec){
		this.arr = (T[])new Object[another_vec.len];
		this.len = another_vec.len;
		this.capacity = another_vec.capacity;
	
		for(int i = 0; i < this.len; i++){
			this.arr[i] = another_vec.arr[i];	
		}	
	}
//изменение размера массива
	private void resize(int new_capacity){
		T[] new_arr = (T[])new Object[new_capacity];
        	for (int i = 0; i < this.capacity; i++){
            		new_arr[i] = this.arr[i];
        	}
		this.arr = new_arr;
        	this.capacity = new_capacity;
    	}
//получение максимального размера контейнера
	public int getCapacity(){
        	return this.capacity;
    	}
//получение текущего размера контейнера
    	public int getLen(){
        	return this.len;
    	}
//добавление элемента в конец
    	public void push(T element){
        	if (this.len == this.capacity){
            		resize(2*(this.len + 1) + 10);
        	}
        	this.arr[this.len] = element;
        	this.len++;
    	}
//удаление последнего элемента
  	public T pop() throws Exception{
        	if (this.len == 0){
            		throw new Exception("Error: nothing to pop");
        	}
        	this.len--;
        	return this.arr[this.len];
    	}
//получить элемент по индексу    
    	public T getByIndex(int index) throws Exception{
        	if (index > this.len || index < 0){
            		throw new Exception("Bad Index (method getByIndex)");
        	}

        	return this.arr[index];
    	}
//вставка элемента по индексу
    	public void insert(T element, int index) throws Exception{
        	if (index > this.len || index < 0){
            		throw new Exception("Bad Index (method insert)");
        	}

        	if (this.len == this.capacity){
            		resize(2*(this.len + 1) + 10);
        	}

        	len++;

        	for (int i = len-1; i > index; i--){
            		this.arr[i] = arr[i-1];
        	}

        	arr[index] = element;
    	}
//удалить элемент по индексу 
    	public void deleteByIndex(int index) throws Exception{
        	if (index > this.len || index < 0){
            		throw new Exception("Bad Index (method deleteByIndex)");
        	}

        	for (int i = index; i < len-1; i++){
            		this.arr[i] = arr[i+1];
        	}
        	len--;
    	}
//удалить элемент по значению 
    	public void deleteByValue(T value) throws Exception{
        	for (int i = 0; i < len-1; i++){
            		if (this.arr[i] == value){
                		deleteByIndex(i);
				//break;
                		return;
            		}
        	}
        	throw new Exception("Error: Value not found (method deleteByValue)");
    	}
//очистка массива
    	public void clear(){
        	this.arr = (T[])new Object[1];
        	this.capacity = 1;
        	this.len = 0;
    	}
}