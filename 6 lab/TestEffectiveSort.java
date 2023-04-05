public class TestEffectiveSort{

	public static void main(String[] args){
		Integer[] arr1 = {1,2,2,3,4,5,6,1,3,5,6};
		EffectiveSort.quick_sort(arr1);	
		
		System.out.println("\n/**************************************************/");
		System.out.printf("Sorted by a quick_sort array '1 2 2 3 4 5 6 1 3 5 6': ");	
		for (int i = 0; i < 10; i++){
			System.out.printf("%d ", arr1[i]);
		}

		Integer[] arr2 = {1,2,2,3,4,5,6,1,3,5,6};
		EffectiveSort.heap_sort(arr2);
		
		System.out.println("\n/**************************************************/");
		System.out.printf("Sorted by heap_sort array    '1 2 2 3 4 5 6 1 3 5 6': ");	
		for (int i = 0; i < 10; i++){
			System.out.printf("%d ", arr2[i]);
		}
		System.out.println("\n/**************************************************/");
		
		Integer[] arr3 = {1, 2, 2, 3, 4, 5, 6, 1, 3, 5, 6};
		EffectiveSort.merge_sort(arr3);

		System.out.printf("Sorted by merge_sort array   '1 2 2 3 4 5 6 1 3 5 6': ");	
		for (int i = 0; i < 10; i++){
			System.out.printf("%d ", arr3[i]);
		}
		System.out.println("\n/************************************************** /");

		Integer[] arr4 = {1, 2, 2, 3, 4, 5, 6, 1, 3, 5, 6};
		EffectiveSort.shell_sort(arr4, 0, arr4.length);

		System.out.printf("Sorted by shell_sort array   '1 2 2 3 4 5 6 1 3 5 6': ");	
		for (int i = 0; i < 10; i++){
			System.out.printf("%d ", arr4[i]);
		}
		System.out.println("\n/************************************************** /");

}
}