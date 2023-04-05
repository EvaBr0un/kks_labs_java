public class SimpleSort{
// пузырьковая сортировка любой подпоследовательности массива с любым типом данных
	public static <T extends Comparable<T>> void sort_buble_range(T A[], int left, int right){

		for (int i = left + 1; i < right; i++){

            		for (int j = left; j < right - i; j++){
                		if (A[j].compareTo(A[j+1]) > 0){
                    			T tmp = A[j+1];
                   			A[j+1] = A[j];
                    			A[j] = tmp;
                		}
			}
        	}
    	}
//пузырьковая сортировка массива с любым типом данных
    	public static <T extends Comparable<T>> void sort_buble(T A[]){
        	sort_buble_range(A, 0, A.length);
    	}
//сортировка вставками любой подпоследовательности массива с любым типом данных
    	public static <T extends Comparable<T>> void sort_insert_range(T A[], int left, int right){
        	for (int i = left+1; i < right; i++){
            		T key = A[i];
            		int j = i - 1;

            		while (j >= left && A[j].compareTo(key) > 0){	
                    		A[j+1] = A[j];
                		j--;
                		}
			A[j+1] = key;
            	}	
      	}
//сортировка вставками массива с любым типом данных
    	public static <T extends Comparable<T>> void sort_insert(T A[]){
        	sort_insert_range(A, 0, A.length);
    	}	
//сортировка выбором любой подпоследовательности массива с любым типом данных
    	public static <T extends Comparable<T>> void sort_selection_range(T A[], int left, int right){
        	for (int i = left; i < right - 1; ++i){
            		int minPos = i;

            		for (int j = i + 1; j < right; ++j){
                		if (A[j].compareTo(A[minPos]) < 0){
                    			minPos = j;
                		}
            		}
            		T tmp = A[i];
            		A[i] = A[minPos];
            		A[minPos] = tmp;
        	}
    	}
//сортировка выбором массива с любым типом данных
    	public static <T extends Comparable<T>> void sort_selection(T A[]){
        	sort_selection_range(A, 0, A.length);
    	}
}