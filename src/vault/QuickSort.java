package vault;

public class QuickSort {

	public static void sort(int[] a) {
		sort(a, 0, a.length - 1);
	}

	private static void sort(int[] a, int lo, int hi) {
		if (hi <= lo)
			return;
		int j = partition(a, lo, hi); // Partition (see page 291).
		sort(a, lo, j - 1); // Sort left part a[lo .. j-1].
		sort(a, j + 1, hi); // Sort right part a[j+1 .. hi].
	}

	private static int partition(int[] a, int lo, int hi) {
		int i = lo, j = hi+1;
		int v = a[lo]; 
		while (true) { 
			while (a[++i] < v)
				if (i == hi)
					break;
			while (v < a[--j])
				if (j == lo)
					break;
			if (i >= j)
				break;
			exchange(a, i, j);
		}
		exchange(a, lo, j); // Put v = a[j] into position
		return j; // with a[lo..j-1] <= a[j] <= a[j+1..hi].
	}

	private static void exchange(int[] list, int lowPointer, int highPointer) {
		int buffer = list[lowPointer];
		list[lowPointer] = list[highPointer];
		list[highPointer] = buffer;
	}

	public static void main(String[] args){
		sort(new int[]{1,8,5,6,7,2,3,4,9,0});
	}
}
