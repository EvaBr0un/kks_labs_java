public class RadixSort {
	    private static void swap(int[] a, int i, int j) {
			int temp = a[i];
			a[i] = a[j];
			a[j] = temp;
	    }

	    public static int max(int[] arr) {
			int val = 0;

			for (int item : arr) {
		    		if (item > val) val = item;
			}

			return val;
	    }

	    public static int gdm(int[] arr) {
			int temp = max(arr);
			int ld = 0;

			while (temp > 0) {
		    		ld++;
		    		temp /= 10;
			}

			return ld;
	    }

	    public static int getdig(int num, int i, int[] arr) {
			System.out.println(Math.pow(10,gdm(arr)-i));

			if (Math.pow(10,gdm(arr)-i) < 1) return 0;

			else return (num/(int)Math.pow(10, gdm(arr)-i))%10;
	    }

	    public static void lsd(int[] arr, int lb, int rb) {
			int dgtplc = 1;
			int n = rb+1;
			int[] result = new int[n];
			int largest = max(arr);

			while (largest/dgtplc > 0) {
		    		int[] count = new int[10];

		    		for (int i = 0; i < 10; i++) count[i] = 0;
		    		for (int i = lb; i < n; i++) count[(arr[i]/dgtplc) % 10]++;
		    		for (int i = 1; i < 10; i++) count[i] += count[i-1];

		    		for (int i = n - 1; i >= lb; i--) {
		        		result[count[(arr[i]/dgtplc) % 10] - 1] = arr[i];
		        		count[(arr[i]/dgtplc)%10]--;
		    		}

		    		System.arraycopy(result, 0, arr, lb, rb);
		    		dgtplc *= 10;
			}
	    }

	    public static void counting_sort (int[] arr, int lb, int rb) {
			int[] temp = new int[rb-lb+1];

			for (int i = 0; i <= rb-lb; i++) temp[i] = arr[lb+i];

			int k = max(temp);

			int[] c = new int[k+1];

			for (int i = 0; i <= k; i++) c[i] = 0;
			for (int i = 0; i <= temp.length-1; i++) c[temp[i]]++;

			int pos = 0;

			for (int i = 0; i < k+1; i++){
		    		for (int j = 0; j < c[i]; j++) temp[pos++] = i;
			}

			System.arraycopy(temp, 0, arr, lb, rb + 1 - lb);
	    }

	    public static void msd(int[] arr, int lb, int rb) {
		msd(arr, lb, rb, true, 31);
	    }

	    private static void msd(int[] arr, int lb, int rb, boolean sign, int bit) {
		if (bit < 0 || lb >= rb) return;
		int zeros = lb - 1;
		int ones = rb + 1;
		int index = zeros + 1;

		while(index < ones) {
		    if (((arr[index] >> bit) & 1) == 1 ^ sign) {
		        ones--;
		        swap(arr, ones, index);
		    }
		    else {
		        zeros++;
		        index++;
		    }
		}

		msd(arr, lb, zeros, false, bit - 1);
		msd(arr, ones, rb, false, bit - 1);
	    }

	    public static  void heapsort(int[] arr, int lb, int rb) {
		heapify(arr, lb, rb);

		int end = rb-lb;

		while (end > lb) {
		    swap(arr, end--, 0);
		    restore(arr, lb, end);
		}
	    }

	    public static void heapify(int[] arr, int lb, int rb) {
		int l = (rb-lb-1)/2;

		while (l >= lb) restore(arr, l--, rb);
	    }

	    public static void restore(int[] arr, int lb, int rb) {
		int root = lb;

		while ((2*root+1) <= rb) {
		    int child = 2*root+1;
		    int temp = root;

		    if (arr[temp] < arr[child]) temp = child;
		    if (child+1 <= rb && arr[temp] < arr[child+1]) temp = child+1;

		    if (temp == root) break;
		    else {
		        swap(arr, root, temp);
		        root = temp;
		    }
		}
	    }
}
