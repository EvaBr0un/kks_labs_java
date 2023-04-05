import java.util.Arrays;

public class EffectiveSort <T extends Comparable<T>>{
//быстрая сортировка любой подпоследовательности массива с любым типом данных	
    	public static <T extends Comparable<T>> void quick_sort_range(T[] A, int left, int right){

		if (left < right){

			int divideIndex = partition(A, left, right);

            		quick_sort_range(A, left, divideIndex - 1);

           		quick_sort_range(A, divideIndex, right);
        	}
    	}

	private static <T extends Comparable<T>> int partition(T[] A, int left, int right){
		int rightIndex = right;
		int leftIndex = left;

		T pivot = A[left + (right - left) / 2];
		while (leftIndex <= rightIndex) {
		    while (A[leftIndex].compareTo(pivot) < 0) {
		        leftIndex++;
		    }

		    while (A[rightIndex].compareTo(pivot)  > 0) {
		        rightIndex--;
		    }

		    if (leftIndex <= rightIndex) {
		    	swap(A, rightIndex, leftIndex);
		        leftIndex++;
		        rightIndex--;
		    }
		}
		return leftIndex;
	    }

	private static <T extends Comparable<T>> void swap(T[] A, int index1, int index2) {
        	T tmp  = A[index1];
        	A[index1] = A[index2];
        	A[index2] = tmp;
    	}
//быстрая сортировка массива с любым типом данных
	public static <T extends Comparable<T>> void quick_sort(T A[]){
			quick_sort_range(A, 0, A.length-1);
	}	
	public static <T extends Comparable<T>> void heapify(T[] A, int length, int i) {
    		int left = 2 * i + 1;
    		int right = 2 * i + 2;
    		int largest = i;
    		if (left < length && A[left].compareTo(A[largest]) > 0) {
        		largest = left;
    		}
    		if (right < length && A[right].compareTo(A[largest]) > 0) {
        		largest = right;
    		}
    		if (largest != i) {
        		T tmp = A[i];
        		A[i] = A[largest];
        		A[largest] = tmp;
        		heapify(A, length, largest);
    		}
	}
//пирамидальная сортировка любой подпоследовательности массива с любым типом данных
	public static <T extends Comparable<T>> void heap_sort_range(T A[], int left, int right){
    		for (int i = right / 2 - 1; i >= left; i--) {
        		heapify(A, right, i);
    		}
    		for (int i = right - 1; i >= left; i--) {
        		T tmp = A[0];
        		A[0] = A[i];
        		A[i] = tmp;
        		heapify(A, i, left);
   		}
	}
//пирамидальная сортировка массива с любым типом данных
	public static <T extends Comparable<T>> void heap_sort(T A[]){
			heap_sort_range(A, 0, A.length);
	}


//сортировка слиянием любой подпоследовательности массива с любым типом данных
	public static <T extends Comparable<T>> void merge_sort_range(T[] A, int left, int right) {
        	T[] tmp;
		T[] dest = (T[]) new Comparable[right];

        	int size = 1;
        	while (size < right){
            		for (int i = left; i < right; i += 2 * size){
                		merge(A, i, A, i + size, dest, i, size);
            		}

            		tmp = A;
            		A = dest;
            		dest = tmp;
            		size = size * 2;
        	}
    	}

    	private static <T extends Comparable<T>> void merge(T[] src1, int src1Start, T[] src2, int src2Start, T[] dest, int destStart, int size){
        	int index1 = src1Start;
        	int index2 = src2Start;

        	int src1End = Math.min(src1Start + size, src1.length);
        	int src2End = Math.min(src2Start + size, src2.length);

        	if (src1Start + size > src1.length){
            		for (int i = src1Start; i < src1End; i++){
                		dest[i] = src1[i];
            		}
            		return;
        	}

        	int iterationCount = src1End - src1Start + src2End - src2Start;

        	for (int i = destStart; i < destStart + iterationCount; i++) {
            		if ( index1 < src1End && (index2 >= src2End || src1[index1].compareTo(src2[index2]) < 0 ) ){
                		dest[i] = src1[index1];
                		index1++;
            		} 
			else{
                		dest[i] = src2[index2];
                		index2++;
            		}
        	}
    	}

//сортировка слиянием массива с любым типом данных
	public static <T extends Comparable<T>>  void merge_sort(T[] A){
		merge_sort_range(A, 0, A.length);
	}	

//Сортировка Шелла с шагом Кнута массива от Left до Right любого типа
    	public static <T extends Comparable<T>> void shell_sort(T[] A, int left, int right){
        	int h = 1;

        	while (h <= right / 3) {
            		h = h * 3 + 1;
			
        	}

        	while (h > left){
            		for (int i = h; i < A.length; i++) {
                		T key = A[i];
                		int j = i;

                		while (j > h - 1 && A[j - h].compareTo(key) > 0) {
                    			A[j] = A[j - h];
                    			j -= h;
                		}

               			A[j] = key;
            		}

            		h = (h - 1) / 3;
        	}
	}	



//сортировка слиянием любой подпоследовательности контейнера MyVector
	public static <T extends Comparable<T>> void vec_merge_sort_range(MyVector<T> A, int left, int right) {
        	MyVector<T> tmp = new MyVector<T>(right);
		MyVector<T> dest = new MyVector<T>(right);

        	int size = 1;
        	while (size < right){
            		for (int i = left; i < right; i += 2 * size){
                		vec_merge(A, i, A, i + size, dest, i, size);
            		}

            		tmp = MyVector<T>(A);
            		A = MyVector<T>(dest);
            		dest = MyVector<T>(tmp);
            		size = size * 2;

        	}
    	}

    	private static <T extends Comparable<T>> void vec_merge(MyVector<T> src1, int src1Start, MyVector<T> src2, int src2Start, MyVector<T> dest, int destStart, int size){
	try{
        	int index1 = src1Start;
        	int index2 = src2Start;

        	int src1End = Math.min(src1Start + size, src1.getLen());
        	int src2End = Math.min(src2Start + size, src2.getLen());

        	if (src1Start + size > src1.getLen()){
            		for (int i = src1Start; i < src1End; i++){
                		dest.insert(src1.getByIndex(i), i);
            		}
            		return;
        	}

        	int iterationCount = src1End - src1Start + src2End - src2Start;

        	for (int i = destStart; i < destStart + iterationCount; i++) {
            		if ( index1 < src1End && (index2 >= src2End || src1.getByIndex(index1).compareTo(src2.getByIndex(index2)) < 0) ){
                		dest.insert(src1.getByIndex(index1), i);
                		index1++;
            		} 
			else{
                		dest.insert(src2.getByIndex(index2), i);
                		index2++;
            		}
        	}
	}catch(Exception err){};
    	}

//сортировка слиянием контейнера
	public static <T extends Comparable<T>> void vec_merge_sort(MyVector<T> A){
				vec_merge_sort_range(A, 0, A.getLen());
	}	
}