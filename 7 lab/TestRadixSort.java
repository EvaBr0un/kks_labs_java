public class TestRadixSort{

	public static void main(String[] args){
		int arr1[] = {1,2,2,3,4,5,6,1,3,5,6};
		RadixSort.lsd(arr1, 0, arr1.length-1);	
		
		System.out.println("\n/**************************************************/");
		System.out.printf("Sorted by a lsd_sort array '1 2 2 3 4 5 6 1 3 5 6': ");	
		for (int i = 0; i < 10; i++){
			System.out.printf("%d ", arr1[i]);
		}

		int arr2[] = {1,2,2,3,4,5,6,1,3,5,6};
		RadixSort.counting_sort(arr2,  0, arr2.length-1);
		
		System.out.println("\n/**************************************************/");
		System.out.printf("Sorted by counting_sort array    '1 2 2 3 4 5 6 1 3 5 6': ");	
		for (int i = 0; i < 10; i++){
			System.out.printf("%d ", arr2[i]);
		}
		System.out.println("\n/**************************************************/");
		
		int arr3[] = {1, 2, 2, 3, 4, 5, 6, 1, 3, 5, 6};
		RadixSort.msd(arr3,  0, arr3.length-1);

		System.out.printf("Sorted by msd_range array   '1 2 2 3 4 5 6 1 3 5 6': ");	
		for (int i = 0; i < 10; i++){
			System.out.printf("%d ", arr3[i]);
		}
		System.out.println("\n/************************************************** /");

		Integer[] arr4 = new Integer[10000];
        	int[] arr5 = new int[10000];

        	for (int i = 0; i < 10000; i++) arr4[i] = (int) (Math.random() * (int) Math.pow(10, 6));
        	for (int i = 0; i < 10000; i++) arr5[i] = (int) (Math.random() * (int) Math.pow(10, 6));

        	long time = System.currentTimeMillis();
        	EffectiveSort.heap_sort(arr4);
        	double time1 = System.currentTimeMillis() - time;

        	System.out.println("Heap sort execution time: " + (int)time1 + " ms");

		System.out.println("/************************************************** /");

        	time = System.currentTimeMillis();
        	RadixSort.lsd(arr5, 0, 9999);
        	double time2 = System.currentTimeMillis() - time;

        	System.out.println("lsd sort execution time: " + (int)time2 + " ms");
        	System.out.println("Difference between count and heap sorts: "+(int)(time2 - time1) + " ms");

}
}