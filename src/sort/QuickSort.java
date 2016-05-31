package sort;

public class QuickSort {

	public static void main(String args[]){
		QuickSort sort = new QuickSort();
		sort.sort(new int[]{9,7,5,11,12,2,14,3,10,6});
	}

	private void sort(int[] list) {
		sort(list, 0, list.length-1);
	}

	private void sort(int[] list, int lowPointer, int highPointer) {
		if(highPointer<=lowPointer){
			return;
		}
		int pivot = partition(list,lowPointer,highPointer);
		sort(list,lowPointer,pivot-1);
		sort(list,pivot+1,highPointer);
	}

	private int partition(int[] list, int lowPointer, int highPointer) {
		int greaterThanPointer = lowPointer;
		int lessThanPointer = highPointer+1;
		int pivot = list[lowPointer];
		while(true){
			while(list[++greaterThanPointer]<pivot){
				if(greaterThanPointer==highPointer){
					break;
				}
			}
			while(list[--lessThanPointer]>pivot){
				if(lessThanPointer==lowPointer){
					break;
				}
			}
			if(lessThanPointer<=greaterThanPointer){
				break;
			}
			exchange(list, lessThanPointer, greaterThanPointer);
		}
		exchange(list,lowPointer,lessThanPointer);
		return lessThanPointer;
	}

	private void exchange(int[] list, int lowPointer, int highPointer) {
		int buffer = list[lowPointer];
		list[lowPointer] = list[highPointer];
		list[highPointer] = buffer;
	}
	
}
