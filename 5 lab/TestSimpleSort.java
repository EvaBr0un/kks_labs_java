public class TestSimpleSort{

	public static void main(String[] args){
		Integer[] arr1 = {1,2,2,3,4,5,6,1,3,5,6};
		SimpleSort.sort_buble(arr1);	

		System.out.printf("Sorted by a bubble array '1 2 2 3 4 5 6 1 3 5 6': ");	
		for (int i = 0; i < 10; i++){
			System.out.printf("%d ", arr1[i]);
		}

		Integer[] arr2 = {1,2,2,3,4,5,6,1,3,5,6};
		SimpleSort.sort_insert(arr2);

		System.out.printf("\nSorted by inserts array  '1 2 2 3 4 5 6 1 3 5 6': ");	
		for (int i = 0; i < 10; i++){
			System.out.printf("%d ", arr2[i]);
		}

		Integer[] arr3 = {1,2,2,3,4,5,6,1,3,5,6};
		SimpleSort.sort_selection(arr3);

		System.out.printf("\nSorted by selection array  '1 2 2 3 4 5 6 1 3 5 6': ");	
		for (int i = 0; i < 10; i++){
			System.out.printf("%d ", arr3[i]);
		}

	}




}